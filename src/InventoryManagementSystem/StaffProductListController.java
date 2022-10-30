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

/**
 *
 * @author Jakob
 */
//class to control the staff product list panel
public class StaffProductListController {

    //initialises variables
    private Inventory model;
    private StaffProductListPanel panel;
    private AllStock previous;
    private boolean pricedByweight;

    //constructor to set all objects
    public StaffProductListController(Inventory model, StaffProductListPanel panel, AllStock previous) {
        //sets the panels and the models
        this.panel = panel;

        this.model = model;

        this.previous = previous;

        this.pricedByweight = false;

        //adds action listeners for button presses and calls the corresponding functions
        this.panel.back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });
        this.panel.next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                next();
            }
        });
        this.panel.add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });
        this.panel.remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                remove();
            }
        });
        this.panel.unitOrWeight.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox();
            }
        });
        //adds focus listeners for text fields to clear and show instructions
        addFocusListenerTextField(this.panel.addName, "Name of new Product");
        addFocusListenerTextField(this.panel.stockingprice, "Stocking price");
        addFocusListenerTextField(this.panel.weight, "Weight");
        
        //adds a focus listener for the price text field changes dependand on whether is is priced by weight or not so is done differently than the others 
        this.panel.price.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

                focusGain(panel.price);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (pricedByweight) {
                    focusLos(panel.price, "Enter the price per Kg");
                } else {
                    focusLos(panel.price, "Enter the price");
                }

            }
        });

    }
//method to add a focus listener to a text field and clear when the user focuses
    public void addFocusListenerTextField(JTextField field, String message) {

        field.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                focusGain(field);
            }

            @Override
            public void focusLost(FocusEvent e) {
                focusLos(field, message);
            }
        });
    }

    //method for back button creates new instance of previous panel and disposes of current one
    public void back() {
        StaffModePanel panel = new StaffModePanel(this.previous);
        this.panel.dispose();
        StaffModeController controller = new StaffModeController(this.previous, panel);

    }

    //method for next frame
    public void next() {
        //checks the user had selected a item 
        if (!this.panel.box.isSelectionEmpty()) {
            //gets the selected item
            int index = this.panel.box.getSelectedIndex();
            Item item = model.getProduct(index);
            //creats new panel 
            StaffItemPanel panel = new StaffItemPanel(item);
            //trys to create a staff weight controller if wrong type create a staff unit controller
            try{
                StaffWeightController controller = new StaffWeightController((PricedByWeight)item, panel, this.model,this.previous);
            }catch (Exception e){
                StaffUnitController controller = new StaffUnitController((PricedByUnit)item, panel, this.model,this.previous);
            }
            //disposes of current panel
            this.panel.dispose();
        }
        
    }

    //method for add button
    public void add() {

        //priced by weight is selected
        if (pricedByweight) {
            //initialises variables 
            String name;
            double price;
            double weight;
            double stockingPrice;
            try {
                //trys to parse all text field to the corresponding type if doesnt work print a error message
                name = this.panel.addName.getText();
                if (name.equals("Name of new Product")) {
                    throw new IllegalArgumentException("Name needs to be filled in");
                }

                try {
                    price = Double.parseDouble(this.panel.price.getText());
                } catch (Exception e) {
                    throw new IllegalArgumentException("invalid price input");
                }
                try {
                    weight = Double.parseDouble(this.panel.weight.getText());
                } catch (Exception e) {
                    throw new IllegalArgumentException("invalid weight input");
                }
                try {
                    stockingPrice = Double.parseDouble(this.panel.stockingprice.getText());
                } catch (Exception e) {
                    throw new IllegalArgumentException("invalid stocking price input");
                }
                this.panel.invalidInput.setVisible(false);
                //adds the new item to the model
                this.model.addPricedByWeight(new PricedByWeight(name, price,  weight,stockingPrice));
                //updates the panel
                this.panel.update();
            } catch (Exception e) {
                this.panel.invalidInput.setText(e.getMessage());
                this.panel.invalidInput.setVisible(true);
            }

        } else {
            //if the object is priced by unit repeats the same process but with the priced by unit object constructor
            String name;
            double price;
            double weight;
            double stockingPrice;
            int amount;

            try {
                name = this.panel.addName.getText();
                if (name.equals("Name of new Product")) {
                    throw new IllegalArgumentException("Name needs to be filled in");
                }

                try {
                    price = Double.parseDouble(this.panel.price.getText());
                } catch (Exception e) {
                    throw new IllegalArgumentException("invalid price input");
                }
                try {
                    weight = Double.parseDouble(this.panel.weight.getText());
                } catch (Exception e) {
                    throw new IllegalArgumentException("invalid weight input");
                }
                try {
                    stockingPrice = Double.parseDouble(this.panel.stockingprice.getText());
                } catch (Exception e) {
                    throw new IllegalArgumentException("invalid stocking price input");
                }
                try {
                    amount = (int) this.panel.amount.getValue();
                } catch (Exception e) {
                    throw new IllegalArgumentException("invalid amount input");
                }
                this.panel.invalidInput.setVisible(false);
                this.model.addPricedByUnit(new PricedByUnit(name, price, amount, weight, stockingPrice));
                
                this.panel.update();
            } catch (Exception e) {
                this.panel.invalidInput.setText(e.getMessage());
                this.panel.invalidInput.setVisible(true);
            }
        }

    }

    //method for the remove button 
    public void remove() {
        //makes the user confirm that they would like to remove the item
        int input = JOptionPane.showConfirmDialog(null, "Are you sure your would like to remove " + this.panel.box.getSelectedValue() + "?");

        //if yes removes gets the index and removes the item from the model and updates the panel
        if (input == 0) {
            int remove = this.panel.box.getSelectedIndex();
            if (remove >= 0) {

                this.model.removeProduct(remove);
                this.panel.update();
            }
        }

    }

    //method for the check box
    //changes the inputs for create new object 
    public void checkBox() {
        if (this.panel.unitOrWeight.isSelected()) {
            this.pricedByweight = true;
            this.panel.price.setText("Enter price per KG");
            this.panel.weight.setText("Enter the amount in kg");
            this.panel.stockingprice.setText("Enter the stocking price per KG");
            this.panel.amount.setVisible(false);
            this.panel.amountLabel.setVisible(false);

        } else {
            this.pricedByweight = false;
            this.panel.price.setText("Enter price");
            this.panel.weight.setText("Enter the weight per unit");
            this.panel.stockingprice.setText("Enter the stocking price");
            this.panel.amount.setVisible(true);
            this.panel.amountLabel.setVisible(true);
        }
    }

    //if focus to the text field is gained clears the text field 
    public void focusGain(JTextField field) {
        field.setText("");
    }

    //if focus is lost and the user didnt input anything puts the instructions back up
    public void focusLos(JTextField field, String text) {
        if (field.getText().equals("")) {
            field.setText(text);
        }

    }
}
