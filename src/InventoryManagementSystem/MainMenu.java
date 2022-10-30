/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.SwingConstants;

/**
 *
 * @author Jakob
 */
//frame making the user pick a mode
public class MainMenu extends JFrame {

    //initialises variables
    private JButton exit;
    private JButton studentMode;
    private JButton staffMode;
    private AllStock model;
    private JLabel Welcome;
    private JLabel Instructions;

    //makes the menu using the model
    public MainMenu(AllStock model) {

        //initialises variables 
        this.model = model;
        
        //sets the frame up
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.FrameSize);
        this.setVisible(true);
        this.setResizable(true);
        this.getContentPane().setBackground(Constants.backGround);
        this.getContentPane().setLayout(null);
        this.setBackground(Constants.backGround);
        this.setTitle("Inventory Management System");
        
        //sets the title text
        this.Welcome = new JLabel("Welcome to the inventory Management system",SwingConstants.CENTER);
        this.Welcome.setFont(Constants.titleFont);
        this.Welcome.setSize(Constants.framex, 80 );
        this.Welcome.setLocation(Constants.framex/2 - 200, 80);
        this.Welcome.setForeground(Constants.fontColor);
        //adds the titles to the frame
        this.add(this.Welcome);
        
        //sets the instructions 
        this.Instructions = new JLabel("select a mode to get started",SwingConstants.CENTER);
        this.Instructions.setFont(Constants.titleFont);
        this.Instructions.setSize(Constants.framex, 100 );
        this.Instructions.setLocation(Constants.framex/2 - 100, 100);
        this.Instructions.setForeground(Constants.fontColor);
        //adds the instructions to the frame
        this.add(this.Instructions);
     
        //sets the student mode button
        this.studentMode = new JButton("Student Mode");
        this.studentMode.setForeground(Constants.fontColor);
        this.studentMode.setSize(Constants.ButtonSize);
        this.studentMode.setLocation(((Constants.framex/2) - 130) ,((Constants.framey/2)-20) );
        //adds the button to the frame
        this.add(studentMode);

        //action listener for when the user clicks the student mode button calls student mode function
        this.studentMode.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                studentModeClick();
            }
        });

        //sets the staff mode button
        this.staffMode = new JButton("Staff Mode");
        this.staffMode.setForeground(Constants.fontColor);
        this.staffMode.setSize(Constants.ButtonSize);
        this.staffMode.setLocation((Constants.framex/2) + 10 , (Constants.framey/2)-20);
        //adds the staffmode button to the frame
        this.add(staffMode);
       
        //acion listener for when the user clicks the staff mode button call staff mode function
        this.staffMode.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                staffModeClick();
            }
        });
        this.setVisible(true);
    }

    //is called when the staff mode button is clicked creates new staff mode frame
    public void staffModeClick() {
        //new staff mode frame
        StaffModePanel panel = new StaffModePanel(this.model);
        //disposes of this frame
        this.dispose();
        //new staff mode controller
        StaffModeController controller = new StaffModeController(this.model,panel);
        
    }

    //function for when student mode is clicked
    public void studentModeClick() {
        //new student mode frame
        CustomerModePanel panel = new CustomerModePanel(this.model);
        //disposes of old frame
        this.dispose();
        //new customer mode controller
        CustomerModeController controller = new CustomerModeController(this.model,panel);
    }

}
