/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Jakob
 */
public class StaffUnitController {

    private PricedByUnit model;
    private StaffItemPanel panel;
    private Inventory previous;
    private AllStock secondPrevious;

    public StaffUnitController(PricedByUnit model, StaffItemPanel panel, Inventory previous, AllStock secondPrevious) {
        this.panel = panel;

        this.model = model;

        this.previous = previous;

        this.secondPrevious = secondPrevious;

        this.panel.back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });
        this.panel.Edit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Edit();
            }
        });
    }

    public void back() {
        StaffProductListPanel panel = new StaffProductListPanel(this.previous);
        this.panel.dispose();
        StaffProductListController controller = new StaffProductListController(this.previous, panel, this.secondPrevious);
    }

    public void Edit() {
        int index = this.panel.box.getSelectedIndex();
        switch (index) {
            case 0:
                EditName();
                break;
            case 1:
                EditPrice();
                break;
            case 2:
                EditAmount();
                break;
            case 3:
                EditStock();
                break;
            case 4:
                EditWeight();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please select a index to edit value");
                break;
        }

    }

    public void EditName() {
        String name = JOptionPane.showInputDialog("Please input new name: ");
        if (name != null) {
            this.previous.removeSave(this.model);
            this.model.setName(name);
            this.previous.addSave(this.model);
            this.panel.update();
        }
    }

    public void EditPrice() {
        String price = JOptionPane.showInputDialog("Please input new price: ");
        while (price != null) {
            try {
                this.previous.removeSave(this.model);
                this.model.setPrice(Double.parseDouble(price));
                this.previous.addSave(this.model);
                this.panel.update();
                break;
            } catch (Exception e) {
                price = JOptionPane.showInputDialog("Invalid input input new price per KG: ");
            }
        }

    }

    public void EditAmount() {
        String amount = JOptionPane.showInputDialog("Please input new amount: ");
        while (amount != null) {
            try {
                this.previous.removeSave(this.model);
                this.model.setAmount(Integer.parseInt(amount));
                this.previous.addSave(this.model);
                this.panel.update();
                break;
            } catch (Exception e) {
                amount = JOptionPane.showInputDialog("Invalid input input new amount: ");
            }
        }
    }

    public void EditStock() {
        String stock = JOptionPane.showInputDialog("Please input new stock price: ");
        while (stock != null) {
            try {
                this.previous.removeSave(this.model);
                this.model.setStockPrice(Double.parseDouble(stock));
                this.previous.addSave(this.model);
                this.panel.update();
                break;
            } catch (Exception e) {
                stock = JOptionPane.showInputDialog("Invalid input input new stock price: ");
            }
        }
    }
    public void EditWeight(){
        String weight = JOptionPane.showInputDialog("Please input new weight in KG: ");
        while (weight != null) {
            try {
                this.previous.removeSave(this.model);
                this.model.setWeight(Double.parseDouble(weight));
                this.previous.addSave(this.model);
                this.panel.update();
                break;
            } catch (Exception e) {
                weight = JOptionPane.showInputDialog("Invalid input input new weight in KG: ");
            }
        }
    }
}
