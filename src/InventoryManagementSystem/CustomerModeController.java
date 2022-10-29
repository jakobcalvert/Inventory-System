/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jakob
 */
//controllers for the customer mode menu
public class CustomerModeController {

    //stores the model and the panel for the controller to edit
    private AllStock model;
    private CustomerModePanel panel;

    //initialises variables and listeners 
    public CustomerModeController(AllStock model, CustomerModePanel panel) {
        //initialises the variables 
        this.panel = panel;
        this.model = model;

        //sets the listeners to detect any button click and runs the associated subroutine
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
    }

    //method to return the user to the previous menu
    public void back() {
        //creates new main menu and disposes current frame
        MainMenu menu = new MainMenu(this.model);
        this.panel.dispose();

    }

    //once the user has selected a store next will take the user to another frame showing the items in the store
    public void next() {
        //checks if the user has selected a store 
        if (!this.panel.box.isSelectionEmpty()) {
            //gets the store 
            int index = this.panel.box.getSelectedIndex();
            Inventory store = model.getStock(index);
            //if the stores items have not been loaded already loads the items
            if (store.Stock.isEmpty()){
                new ServerSaveFile().readItems(store);
            }          
            //creates new frame and controller with the model and gets rid of this frame
            CustomerProductListPanel panel = new CustomerProductListPanel(store);
            CustomerProductListController controller = new CustomerProductListController(store, panel, this.model);
            this.panel.dispose();
        }
    }
}
