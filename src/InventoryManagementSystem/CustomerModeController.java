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
public class CustomerModeController {

    private AllStock model;
    private CustomerModePanel panel;

    public CustomerModeController(AllStock model, CustomerModePanel panel) {
        this.panel = panel;

        this.model = model;

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

    public void back() {
        MainMenu menu = new MainMenu(this.model);
        this.panel.dispose();

    }

    public void next() {

        if (!this.panel.box.isSelectionEmpty()) {
            int index = this.panel.box.getSelectedIndex();
            Inventory store = model.getStock(index);
            if (store.Stock.isEmpty()){
                new ServerSaveFile().readItems(store);
            }          
            CustomerProductListPanel panel = new CustomerProductListPanel(store);
            CustomerProductListController controller = new CustomerProductListController(store, panel, this.model);
            this.panel.dispose();
        }

    }


    
}
