/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author Jakob
 */
public class StaffModeController {

    private AllStock model;
    private StaffModePanel panel;

    public StaffModeController(AllStock model, StaffModePanel panel) {
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

    public void back() {
        MainMenu menu = new MainMenu(this.model);
        this.panel.dispose();

    }

    public void next() {
        System.out.println("next pressed");
        int index = this.panel.box.getSelectedIndex();
        Inventory store = model.getStock(index);
        StaffProductListPanel panel = new StaffProductListPanel(store);
        StaffProductListController controller = new StaffProductListController(store, panel, this.model);
        this.panel.dispose();

    }

    public void add() {
        String add = this.panel.addName.getText();
        if(!add.equals("Name of new Store")){
            this.model.addStore(new Inventory(add));
        this.panel.addName.setText("");
        this.panel.update();
        this.panel.addName.setText("Name of new Store");
        }
        

    }

    public void remove() {
        int remove = this.panel.box.getSelectedIndex();
        if (remove >= 0) {
            this.model.remove(remove);
            this.panel.update();
        }

    }

    public void focusGain() {
        this.panel.addName.setText("");
    }

    public void focusLos() {
        if (this.panel.addName.getText().equals("")) {
            this.panel.addName.setText("Name of new Store");
        }

    }
}
