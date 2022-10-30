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

/**
 *
 * @author Jakob
 */
//controller for the staff mode panel frame
public class StaffModeController {

    //initialises variables
    private AllStock model;
    private StaffModePanel panel;

    //constructor sets all varaibles and actions controllers 
    public StaffModeController(AllStock model, StaffModePanel panel) {
        //sets panel and model
        this.panel = panel;

        this.model = model;

        //adsd action listeners for button click events
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
        //adds event for when the text field is in or out of focus
        this.panel.addName.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                focusGain();
            }

            @Override
            public void focusLost(FocusEvent e) {
                focusLos();
            }
        });
    }

    //method to go back a menu
    public void back() {
        //creates new version of previous menu and disposes of this frame
        MainMenu menu = new MainMenu(this.model);
        this.panel.dispose();

    }

    //method to go to the item screen
    public void next() {
        //checks if the user has selected a store
        if (!this.panel.box.isSelectionEmpty()) {
            //if the user has gets the selected index and find the corresponding store
            int index = this.panel.box.getSelectedIndex();
            Inventory store = model.getStock(index);
            //if the store is empty loads the items in the from the database
            if (store.Stock.isEmpty()){
                new ServerSaveFile().readItems(store);
            }          
            //creates new frame and controllers to view the items and disposes of current frame
            StaffProductListPanel panel = new StaffProductListPanel(store);
            StaffProductListController controller = new StaffProductListController(store, panel, this.model);
            this.panel.dispose();
        }

    }

    //method for when the user clicks the add button adds a new store to the model and updates the panel
    public void add() {
        //gets the name the user has inputed
        String add = this.panel.addName.getText();
        //makes sure the user has inputed a name
        if (!add.equals("Name of new Store")) {
            //adds the store to the model
            this.model.addStore(new Inventory(add));
            //updates the panel
            this.panel.addName.setText("");
            this.panel.update();
            this.panel.addName.setText("Name of new Store");
        }

    }

    //method for the remove button
    public void remove() {
        //makes the user confirm removing the store
        int input = JOptionPane.showConfirmDialog(null, "Are you sure your would like to remove " + this.panel.box.getSelectedValue() + "?");

        //if user selected yes 
        if (input == 0) {
            //gets the stores index 
            int remove = this.panel.box.getSelectedIndex();
            //removes it from the model and updates the panel
            if (remove >= 0) {
                this.model.remove(remove);
                this.panel.update();
            }
        }

    }

    //clears the input field when the user clicks on it
    public void focusGain() {
        this.panel.addName.setText("");
    }

    //if the user hasnt entered anything in the text field redisplays instructions
    public void focusLos() {
        if (this.panel.addName.getText().equals("")) {
            this.panel.addName.setText("Name of new Store");
        }

    }
}
