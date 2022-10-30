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
//this class makes the frame for the staff mode store list
public class StaffModePanel extends JFrame {
    //initialises variables 
    private AllStock model;
    public JList box;
    public JButton back;
    public JButton next;
    public JButton add;
    public JButton remove;
    public JTextField addName;
    
    private JScrollPane pane;
    private JLabel Title;
    
    //constructor opens and sets up new frame
    public StaffModePanel(AllStock model){
        //sets the model
        this.model = model;

        //sets up the new frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.FrameSize);
        this.setVisible(true);
        this.setResizable(true);
        this.getContentPane().setBackground(Constants.backGround);
        this.getContentPane().setLayout(null);
        this.setBackground(Constants.backGround);
        this.setTitle("Inventory Management System - Staff Mode");
        
        //sets the title
        this.Title = new JLabel("Select a store to view inventory");
        this.Title.setFont(Constants.titleFont);
        this.Title.setForeground(Constants.fontColor);
        this.Title.setSize(Constants.framex, 100 );
        this.Title.setLocation(20, -20);
        //adds the title to the frame
        this.add(this.Title);
        
        //sets the list box
        this.box = new JList();
        this.box.setListData(this.model.getStoresStringArray());
        this.box.setForeground(Constants.fontColor);
        this.box.setBackground(Constants.buttonColor);
        this.pane = new JScrollPane(this.box);
        this.pane.setSize(Constants.listBoxSize);
        this.pane.setLocation(20,60);
        //adds the list box to the frame
        this.add(this.pane);
        
        //set the back button
        this.back = new JButton("Back");
        this.back.setForeground(Constants.fontColor);
        this.back.setSize(Constants.ButtonSize);
        this.back.setLocation(20 , Constants.framey - 40 - Constants.ButtonSize.height);
        //adds the back button to the frame
        this.add(this.back);
        
        //sets the next button 
        this.next = new JButton("next");
        this.next.setForeground(Constants.fontColor);
        this.next.setSize(Constants.ButtonSize);
        this.next.setLocation( Constants.framex - 20 - Constants.ButtonSize.width , Constants.framey - 40 - Constants.ButtonSize.height);
        //adds the next button to the frame
        this.add(this.next);
        
        //sets the add button
        this.add = new JButton("Add");
        this.add.setForeground(Constants.fontColor);
        this.add.setSize(Constants.textFieldSize.width,Constants.ButtonSize.height);
        this.add.setLocation( Constants.framex/2 , 140);
        //adds the add button to the display
        this.add(this.add);
        
        //Sets the text field for new store name
        this.addName = new JTextField("Name of new Store");
        this.addName.setForeground(Constants.fontColor);
        this.addName.setBackground(Constants.buttonColor);
        this.addName.setSize(Constants.textFieldSize);
        this.addName.setLocation(Constants.framex/2,100);
        //adds the text field to the frame
        this.add(this.addName);
        
        //sets the remove button
        this.remove = new JButton("Remove selected");
        this.remove.setForeground(Constants.fontColor);
        this.remove.setSize(Constants.textFieldSize.width,Constants.ButtonSize.height);
        this.remove.setLocation( Constants.framex/2 , 240);
        //adds the remove button to the display
        this.add(this.remove);
                
    }
    //this method updates the frame with new values for the list box
    public void update(){
        this.box.setListData(this.model.getStoresStringArray());
    }
    
}
