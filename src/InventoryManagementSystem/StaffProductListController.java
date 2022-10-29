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
public class StaffProductListController {

    private Inventory model;
    private StaffProductListPanel panel;
    private AllStock previous;
    private boolean pricedByweight;

    public StaffProductListController(Inventory model, StaffProductListPanel panel, AllStock previous) {
        this.panel = panel;

        this.model = model;

        this.previous = previous;

        this.pricedByweight = false;

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
        addFocusListenerTextField(this.panel.addName, "Name of new Product");
        addFocusListenerTextField(this.panel.stockingprice, "Stocking price");
        addFocusListenerTextField(this.panel.weight, "Weight");

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

    public void back() {
        StaffModePanel panel = new StaffModePanel(this.previous);
        this.panel.dispose();
        StaffModeController controller = new StaffModeController(this.previous, panel);

    }

    public void next() {

    }

    public void add() {

        if (pricedByweight) {

            String name;
            double price;
            double weight;
            double stockingPrice;
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
                this.panel.invalidInput.setVisible(false);
                this.model.addPricedByWeight(new PricedByWeight(name, price,  weight,stockingPrice));
                
                this.panel.update();
            } catch (Exception e) {
                this.panel.invalidInput.setText(e.getMessage());
                this.panel.invalidInput.setVisible(true);
            }

        } else {
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

    public void remove() {
        int input = JOptionPane.showConfirmDialog(null, "Are you sure your would like to remove " + this.panel.box.getSelectedValue() + "?");

        if (input == 0) {
            int remove = this.panel.box.getSelectedIndex();
            if (remove >= 0) {

                this.model.removeProduct(remove);
                this.panel.update();
            }
        }

    }

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

    public void focusGain(JTextField field) {
        field.setText("");
    }

    public void focusLos(JTextField field, String text) {
        if (field.getText().equals("")) {
            field.setText(text);
        }

    }
}
