/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Jakob
 */
public class CustomerProductListController {

    private Inventory model;
    private CustomerProductListPanel panel;
    private AllStock previous;
    private Item currentItem;

    public CustomerProductListController(Inventory model, CustomerProductListPanel panel, AllStock previous) {
        this.panel = panel;

        this.model = model;

        this.previous = previous;

        this.panel.back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });
        this.panel.box.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                changeBox2();
            }
        });

        this.panel.Buy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buy();
            }
        });
    }

    public void back() {
        CustomerModePanel panel = new CustomerModePanel(this.previous);
        this.panel.dispose();
        CustomerModeController controller = new CustomerModeController(this.previous, panel);

    }

    public void buy() {
        if (this.currentItem.getClass() == PricedByWeight.class) {
            String amount = JOptionPane.showInputDialog("Please enter the amount in KG of " + this.currentItem.getName() + " you would like to buy");
            while (amount != null) {
                try {
                    double amountD = Double.parseDouble(amount);
                    if (amountD > ((PricedByWeight) this.currentItem).getAmountKg()) {
                        JOptionPane.showMessageDialog(null, "Sorry we do not have that amount in stock");
                        break;
                    } else {
                        int input = JOptionPane.showConfirmDialog(null, "Confirm purchase "+amountD+"KG of "+ this.currentItem.getName()+" for "+ (amountD * ((PricedByWeight) this.currentItem).getPricePerKg())+ "$.");
                        if (input == 0) {
                            this.model.removeSave(this.currentItem);
                            ((PricedByWeight) this.currentItem).setAmountKg(((PricedByWeight) this.currentItem).getAmountKg() - amountD);
                            this.model.addSave(this.currentItem);
                            this.panel.update(this.currentItem.getCustomerArray());
                        }
                        break;
                    }

                } catch (Exception e) {
                    amount = JOptionPane.showInputDialog("Invalid input enter the amount in KG of " + this.currentItem.getName() + " you would like to buy");
                }
            }
        } else {
            String amount = JOptionPane.showInputDialog("Please enter the amount of " + this.currentItem.getName() + " you would like to buy");
            while (amount != null) {
                try {
                    int amountI = Integer.parseInt(amount);
                    if (amountI > ((PricedByUnit) this.currentItem).getAmount()) {
                        JOptionPane.showMessageDialog(null, "Sorry we do not have that amount in stock");
                        break;
                    } else {
                        int input = JOptionPane.showConfirmDialog(null, "Confirm purchase of "+amountI+" "+ this.currentItem.getName()+" for "+ (amountI * ((PricedByUnit) this.currentItem).getPrice())+ "$.");
                        if (input == 0) {
                            this.model.removeSave(this.currentItem);
                            ((PricedByUnit) this.currentItem).setAmount(((PricedByUnit) this.currentItem).getAmount() - amountI);
                            this.model.addSave(this.currentItem);
                            this.panel.update(this.currentItem.getCustomerArray());
                        }
                        break;
                    }

                } catch (Exception e) {
                    amount = JOptionPane.showInputDialog("Invalid input enter the amount of " + this.currentItem.getName() + " you would like to buy");
                }
            }
        }

    }

    public void changeBox2() {
        int index = this.panel.box.getSelectedIndex();
        this.currentItem = this.model.getProduct(index);
        this.panel.box2.setListData(this.currentItem.getCustomerArray());
        this.panel.pane2.setVisible(true);
        this.panel.Buy.setVisible(true);
    }

}
