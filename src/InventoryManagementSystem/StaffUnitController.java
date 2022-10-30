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
//this class is the controller for the staff item panel when it is displaying a priced by unit object
public class StaffUnitController {

    //initialises variables
    private PricedByUnit model;
    private StaffItemPanel panel;
    private Inventory previous;
    private AllStock secondPrevious;

    //constructor sets up action listeners 
    public StaffUnitController(PricedByUnit model, StaffItemPanel panel, Inventory previous, AllStock secondPrevious) {
        //sets variables
        this.panel = panel;

        this.model = model;

        this.previous = previous;

        this.secondPrevious = secondPrevious;

        //sets action listeners
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

    //method for back button
    public void back() {
        //creates new previous panel and controller and disposes of current panel
        StaffProductListPanel panel = new StaffProductListPanel(this.previous);
        this.panel.dispose();
        StaffProductListController controller = new StaffProductListController(this.previous, panel, this.secondPrevious);
    }

    //edit button function
    public void Edit() {
        //checks which index of the list is selected and points the coresponding method
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

    //method to edit the name
    private void EditName() {
        //makes the user input new name       
        String name = JOptionPane.showInputDialog("Please input new name: ");
        //if name is valid updates model, database and panel
        if (name != null) {
            //removes database save
            this.previous.removeSave(this.model);
            this.model.setName(name);
            //adds new save
            this.previous.addSave(this.model);
            this.panel.update();
        }
    }

    //method to edit the price
    private void EditPrice() {
        //same as the method above but casts the price to double
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

    //method to edit the amount
    private void EditAmount() {
        //same as the method above but casts the amount to int
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

    //method to edit the stocking price
    private void EditStock() {
        //same as the method above but casts the stocking price to double
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
    //method to edit the weight
    private void EditWeight(){
        //same as the method above but casts the price to double
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
