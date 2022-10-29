/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Jakob
 */
public class CustomerModePanel extends JFrame {
    private AllStock model;
    public JList box;
    public JButton back;
    public JButton next;
    
    
    private JScrollPane pane;
    private JLabel Title;
    
    
    public CustomerModePanel(AllStock model){
        this.model = model;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.FrameSize);
        this.setVisible(true);
        this.setResizable(true);
        this.getContentPane().setBackground(Constants.backGround);
        this.getContentPane().setLayout(null);
        this.setBackground(Constants.backGround);
        this.setTitle("Inventory Management System - Staff Mode");
        
        this.Title = new JLabel("Select a store to view inventory");
        this.Title.setFont(Constants.titleFont);
        this.Title.setVisible(true);
        this.Title.setForeground(Constants.fontColor);
        this.Title.setSize(Constants.framex, 100 );
        this.Title.setLocation(20, -20);
        
        this.add(this.Title);
        
        this.box = new JList();
        this.box.setListData(this.model.getStoresStringArray());
        this.box.setForeground(Constants.fontColor);
        this.box.setBackground(Constants.buttonColor);
        this.pane = new JScrollPane();
        this.pane.getViewport().setView(this.box);
        this.pane.setVisible(true);
        this.pane.setSize(Constants.listBoxSize);
        this.pane.setLocation(20,60);
        
        this.add(this.pane);
        
        this.back = new JButton("Back");
        this.back.setForeground(Constants.fontColor);
        this.back.setSize(Constants.ButtonSize);
        this.back.setVisible(true);
        this.back.setLocation(20 , Constants.framey - 40 - Constants.ButtonSize.height);
       
        this.add(this.back);
        
        this.next = new JButton("next");
        this.next.setForeground(Constants.fontColor);
        this.next.setSize(Constants.ButtonSize);
        this.next.setVisible(true);
        this.next.setLocation( Constants.framex - 20 - Constants.ButtonSize.width , Constants.framey - 40 - Constants.ButtonSize.height);
       
        this.add(this.next);
        
        
    }
    
    
}
