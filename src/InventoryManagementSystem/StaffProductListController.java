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
public class StaffProductListController {

    private Inventory model;
    private StaffProductListPanel panel;
    private AllStock previous;
    private boolean pricedByweight;

    public StaffProductListController(Inventory model, StaffProductListPanel panel,AllStock previous) {
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
    }

    public void back() {
        StaffModePanel panel = new StaffModePanel(this.previous);
        this.panel.dispose();
        StaffModeController controller = new StaffModeController(this.previous,panel);

    }

    public void next() {
        
        
    }

    public void add() {
        String add = this.panel.addName.getText();
        
        if (!add.isEmpty()) {
            
        }
                
    }

    public void remove() {
        int remove = this.panel.box.getSelectedIndex();
        if (remove >= 0) {
            
            this.model.removeProduct(remove);
            this.panel.update();
        }

    }
    public void checkBox(){
        if (this.panel.unitOrWeight.isSelected()){
            this.pricedByweight = true;
            this.panel.price.setText("Enter price per KG");
            this.panel.amount.setVisible(false);
            this.panel.stockingprice.setVisible(false);
            
        }else{
            this.pricedByweight = false;
            this.panel.price.setText("Enter price");
            this.panel.amount.setVisible(true);
            this.panel.stockingprice.setVisible(true);
        }
    }
}

