/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author Jakob
 */
//this class makes a frame to display the items at a given store
public class StaffItemPanel extends JFrame {
    
    //initialises variables
    private Item model;
    public JList box;
    public JButton back;
    public JButton Edit;

    private JScrollPane pane;
    private JLabel Title;
    
    //constructor sets all elements
    public StaffItemPanel(Item model){
        //declares model
        this.model = model;

        //makes new frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.FrameSize);
        this.setVisible(true);
        this.setResizable(true);
        this.getContentPane().setBackground(Constants.backGround);
        this.getContentPane().setLayout(null);
        this.setBackground(Constants.backGround);
        this.setTitle("Inventory Management System - Staff Mode");
        
        //makes title label
        this.Title = new JLabel("View or edit item details");
        this.Title.setFont(Constants.titleFont);
        this.Title.setForeground(Constants.fontColor);
        this.Title.setSize(Constants.framex, 100 );
        this.Title.setLocation(20, -20);
        //adds title label to the frame
        this.add(this.Title);
        
        //makes list box and fills with items
        this.box = new JList();
        this.box.setBackground(Constants.buttonColor);
        this.box.setListData(model.getStaffArray());
        this.box.setForeground(Constants.fontColor);
        this.pane = new JScrollPane(this.box);
        this.pane.setSize(Constants.listBoxSize);
        this.pane.setLocation(20,60);      
        //adds list box to frame
        this.add(this.pane);
        
        //creates back button
        this.back = new JButton("Back");
        this.back.setForeground(Constants.fontColor);
        this.back.setSize(Constants.ButtonSize);
        this.back.setLocation(20 , Constants.framey - 40 - Constants.ButtonSize.height);
        //adds back button to the frame
        this.add(this.back);
        
        //creates edit button
        this.Edit = new JButton("Edit");
        this.Edit.setForeground(Constants.fontColor);
        this.Edit.setSize(Constants.ButtonSize);
        this.Edit.setLocation(Constants.framex - 20 - Constants.ButtonSize.width  , Constants.framey - 40 - Constants.ButtonSize.height);
        //adds edit button to the frame
        this.add(this.Edit);
        
    }
    //method to update the list box in the frame
    public void update(){
        this.box.setListData(this.model.getStaffArray());
    }
}
