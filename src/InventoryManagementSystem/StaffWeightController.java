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
//this class is the controller for the staff item panel when it is displaying a priced by weight object
//this class is mostly the same as the priced by unit one so for more indepth details of methods look at the unit controller
public class StaffWeightController {

    //initialises variables
    private PricedByWeight model;
    private StaffItemPanel panel;
    private Inventory previous;
    private AllStock secondPrevious;

    //constructor sets all action controllers
    public StaffWeightController(PricedByWeight model, StaffItemPanel panel, Inventory previous, AllStock secondPrevious) {
        //sets variables
        this.panel = panel;

        this.model = model;

        this.previous = previous;

        this.secondPrevious = secondPrevious;

        //adds actions listeners for buttons and maps to appropriate methods
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

    //method for back button goes back a form
    public void back() {
        StaffProductListPanel panel = new StaffProductListPanel(this.previous);
        this.panel.dispose();
        StaffProductListController controller = new StaffProductListController(this.previous, panel, this.secondPrevious);
    }
    
    //method for edit button edits variables
    public void Edit(){
        int index = this.panel.box.getSelectedIndex();
        switch (index){
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
            default:
                JOptionPane.showMessageDialog(null, "Please select a index to edit value");
                break;
        }
    }
    //method to edit name
    public void EditName(){
        String name= JOptionPane.showInputDialog("Please input new name: ");
        if (name!= null) {
            this.previous.removeSave(this.model);
            this.model.setName(name);
            this.previous.addSave(this.model);
            this.panel.update();
        }
    }
    
    //method to edit price
    public void EditPrice(){
        String price= JOptionPane.showInputDialog("Please input new price per KG: ");
        while (price!=null){
            try{
                this.previous.removeSave(this.model);
                this.model.setPricePerKg(Double.parseDouble(price));
                this.previous.addSave(this.model);
                this.panel.update();
                break;
            } catch(Exception e){
                price= JOptionPane.showInputDialog("Invalid input input new price per KG: ");
            }
        }
        
    }
    
    //method to edit amount
    public void EditAmount(){
        String amount= JOptionPane.showInputDialog("Please input new amount in KG: ");
        while (amount!=null){
            try{
                this.previous.removeSave(this.model);
                this.model.setAmountKg(Double.parseDouble(amount));
                this.previous.addSave(this.model);
                this.panel.update();
                break;
            } catch(Exception e){
                amount= JOptionPane.showInputDialog("Invalid input input new amount in KG: ");
            }
        }
    }
    
    //method to edit stocking price
    public void EditStock(){
        String stock= JOptionPane.showInputDialog("Please input new stock price per KG: ");
        while (stock!=null){
            try{
                this.previous.removeSave(this.model);
                this.model.setStockPrice(Double.parseDouble(stock));
                this.previous.addSave(this.model);
                this.panel.update();
                break;
            } catch(Exception e){
                stock = JOptionPane.showInputDialog("Invalid input input new stock price per KG: ");
            }
        }
    }
}
