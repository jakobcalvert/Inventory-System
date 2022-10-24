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
    }

    public void back() {
        MainMenu menu = new MainMenu(this.model);
        this.panel.dispose();

    }

    public void next() {
        int index = this.panel.box.getSelectedIndex();
        Inventory store = model.getStock(index);
        StaffProductListPanel panel = new StaffProductListPanel(store);
        StaffProductListController controller = new StaffProductListController(store,panel,this.model);
        this.panel.dispose();
        
    }

    public void add() {
        String add = this.panel.addName.getText();
        
        if (!add.isEmpty()) {
            this.model.addStore(new Inventory(add));
            this.panel.addName.setText("");
            this.panel.update();
        }
                
    }

    public void remove() {
        int remove = this.panel.box.getSelectedIndex();
        if (remove >= 0) {
            this.model.remove(remove);
            this.panel.update();
        }

    }
}
