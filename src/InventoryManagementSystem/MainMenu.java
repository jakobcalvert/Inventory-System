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
public class MainMenu extends JFrame {

    private JButton exit;
    private JButton studentMode;
    private JButton staffMode;
    private AllStock model;
    private JLabel Welcome;
    private JLabel Instructions;

    public MainMenu(AllStock model) {

        this.model = model;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.FrameSize);
        this.setVisible(true);
        this.setResizable(true);
        this.getContentPane().setLayout(null);
        this.setBackground(Color.yellow);
        this.setTitle("Inventory Management System");
        
        this.Welcome = new JLabel("Welcome to the inventory Management system",SwingConstants.CENTER);
        this.Welcome.setFont(Constants.titleFont);
        this.Welcome.setVisible(true);
        this.Welcome.setSize(Constants.framex, 80 );
        this.Welcome.setLocation(Constants.framex/2 - 200, 80);
        
        this.Instructions = new JLabel("select a mode to get started",SwingConstants.CENTER);
        this.Instructions.setFont(Constants.titleFont);
        this.Instructions.setVisible(true);
        this.Instructions.setSize(Constants.framex, 100 );
        this.Instructions.setLocation(Constants.framex/2 - 100, 100);
        
        this.add(this.Instructions);
        
        this.add(this.Welcome);
        
        
        

        this.studentMode = new JButton("Student Mode");
        
        this.studentMode.setSize(Constants.ButtonSize);
        this.studentMode.setVisible(true);
        this.studentMode.setLocation(((Constants.framex/2) - 130) ,((Constants.framey/2)-20) );
        

        this.add(studentMode);

        this.studentMode.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                studentModeClick();
            }
        });

        this.staffMode = new JButton("Staff Mode");
        
        this.staffMode.setSize(Constants.ButtonSize);
        this.staffMode.setVisible(true);
        this.staffMode.setLocation((Constants.framex/2) + 10 , (Constants.framey/2)-20);
       
        this.add(staffMode);
       
        this.staffMode.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                staffModeClick();
            }
        });
        this.setVisible(true);
    }

    public void staffModeClick() {
        StaffModePanel panel = new StaffModePanel(model);
        this.dispose();
    }

    public void studentModeClick() {
        StaffModePanel panel = new StaffModePanel(model);
        this.dispose();
    }

}
