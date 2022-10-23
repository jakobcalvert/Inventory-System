/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Jakob
 */
public class StaffModePanel extends JPanel {
    private AllStock model;
    private JList box;
    private JButton back;
    private JButton next;
    public StaffModePanel(AllStock model){
        this.model = model;
        
        this.box = new JList();
        this.box.setSize(100, 200);
        this.box.setLocation(10, 10);
        Update();
        
    }
    public void Update(){
        this.box.setListData(model.getStoresStringArray());
    }
}
