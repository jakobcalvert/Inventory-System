/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Jakob
 */
public class StaffModePanel extends JFrame {
    private AllStock model;
    private JList box;
    private JButton back;
    private JButton next;
    private JScrollPane pane;
    public StaffModePanel(AllStock model){
        this.model = model;
        
        this.box = new JList();
        this.box.setSize(100, 200);
        this.box.setLocation(10, 10);
        this.box.setVisible(true);
        Update();
        this.add(this.pane,BorderLayout.WEST);
        
        
        
        
    }
    public void Update(){
        this.box.setListData(model.getStoresStringArray());
        pane.add(box);
    }
}
