/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Jakob
 */
//controller for the customer product list frame
public class CustomerProductListController {

    //initialises variables 
    private Inventory model;
    private CustomerProductListPanel panel;
    private AllStock previous;
    private Item currentItem;

    //constructor for the frame
    public CustomerProductListController(Inventory model, CustomerProductListPanel panel, AllStock previous) {
        //set the variables 
        this.panel = panel;
        this.model = model;
        this.previous = previous;

        //sets the action listeners for the buttons and the function they call
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

    //function to go back a page
    public void back() {
        //creates new frame and controller for previous form gets rid of current frame
        CustomerModePanel panel = new CustomerModePanel(this.previous);
        this.panel.dispose();
        CustomerModeController controller = new CustomerModeController(this.previous, panel);

    }

    //method for but button
    public void buy() {
        //checks if the current class is priced by weight or priced by unit
        if (this.currentItem.getClass() == PricedByWeight.class) {
            //if priced by weight promts the user to input the amout loops untill the amount variable is  acceptable
            String amount = JOptionPane.showInputDialog("Please enter the amount in KG of " + this.currentItem.getName() + " you would like to buy");
            while (amount != null) {
                try {
                    //convert the string to a double checks if the amount is available 
                    double amountD = Double.parseDouble(amount);
                    if (amountD > ((PricedByWeight) this.currentItem).getAmountKg()) {
                        //if not prints a output message saying that it is not available and breaks loop ending method
                        JOptionPane.showMessageDialog(null, "Sorry we do not have that amount in stock");
                        break;
                    } else {
                        //if it is available makes the user confirm the transaction and then removes the amount from the model 
                        int input = JOptionPane.showConfirmDialog(null, "Confirm purchase " + amountD + "KG of " + this.currentItem.getName() + " for " + (amountD * ((PricedByWeight) this.currentItem).getPricePerKg()) + "$.");
                        if (input == 0) {
                            //removes the old save from data base
                            this.model.removeSave(this.currentItem);
                            //updates model
                            ((PricedByWeight) this.currentItem).remove(amountD);
                            //updates database with new variable
                            this.model.addSave(this.currentItem);
                            //updates panel
                            this.panel.update(this.currentItem.getCustomerArray());
                        }
                        break;
                    }
                    //if a invalid input is detected prompts user to reenter
                } catch (Exception e) {
                    amount = JOptionPane.showInputDialog("Invalid input enter the amount in KG of " + this.currentItem.getName() + " you would like to buy");
                }
            }
        } else {
            //if priced by unit repeats the same actions as above with a integer amount instean for the unit amount instead of weight
            String amount = JOptionPane.showInputDialog("Please enter the amount of " + this.currentItem.getName() + " you would like to buy");
            while (amount != null) {
                try {
                    int amountI = Integer.parseInt(amount);
                    if (amountI > ((PricedByUnit) this.currentItem).getAmount()) {
                        JOptionPane.showMessageDialog(null, "Sorry we do not have that amount in stock");
                        break;
                    } else {
                        int input = JOptionPane.showConfirmDialog(null, "Confirm purchase of " + amountI + " " + this.currentItem.getName() + " for " + (amountI * ((PricedByUnit) this.currentItem).getPrice()) + "$.");
                        if (input == 0) {
                            this.model.removeSave(this.currentItem);
                            ((PricedByUnit) this.currentItem).removeAmount(amountI);
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

    //if a new item is selected this function is called and changes the item preview box
    public void changeBox2() {
        int index = this.panel.box.getSelectedIndex();
        this.currentItem = this.model.getProduct(index);
        this.panel.ItemDetails.setListData(this.currentItem.getCustomerArray());
        this.panel.ItemDetailsPane.setVisible(true);
        this.panel.Buy.setVisible(true);
    }

}
