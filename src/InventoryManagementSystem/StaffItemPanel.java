/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Jakob
 */
public class StaffItemPanel extends JFrame {
    private Item model;
    public JList box;
    public JButton back;
    public JButton Edit;
    
    
    private JScrollPane pane;
    private JLabel Title;
    
    
    
    public StaffItemPanel(Item model){
        this.model = model;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.FrameSize);
        this.setVisible(true);
        this.setResizable(true);
        this.getContentPane().setBackground(Constants.backGround);
        this.getContentPane().setLayout(null);
        this.setBackground(Constants.backGround);
        this.setTitle("Inventory Management System - Staff Mode");
        
        this.Title = new JLabel("View or edit item details");
        this.Title.setFont(Constants.titleFont);
        this.Title.setVisible(true);
        this.Title.setForeground(Constants.fontColor);
        this.Title.setSize(Constants.framex, 100 );
        this.Title.setLocation(20, -20);
        
        this.add(this.Title);
        
        this.box = new JList();
        this.box.setBackground(Constants.buttonColor);
        this.box.setListData(model.getStaffArray());
        this.box.setForeground(Constants.fontColor);
        this.box.setVisible(true);
        this.box.setSize(Constants.listBoxSize);
        this.box.setLocation(20,60);

        this.add(this.box);
        
        this.back = new JButton("Back");
        this.back.setForeground(Constants.fontColor);
        this.back.setSize(Constants.ButtonSize);
        this.back.setVisible(true);
        this.back.setLocation(20 , Constants.framey - 40 - Constants.ButtonSize.height);
       
        this.add(this.back);
        
        this.Edit = new JButton("Edit");
        this.Edit.setForeground(Constants.fontColor);
        this.Edit.setSize(Constants.ButtonSize);
        this.Edit.setVisible(true);
        this.Edit.setLocation(Constants.framex - 20 - Constants.ButtonSize.width  , Constants.framey - 40 - Constants.ButtonSize.height);
       
        this.add(this.Edit);
        
    }
    public void update(){
        this.box.setListData(this.model.getStaffArray());
    }
}
