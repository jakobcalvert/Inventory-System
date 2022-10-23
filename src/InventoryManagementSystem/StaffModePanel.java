/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

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
    private JLabel Title;
    public StaffModePanel(AllStock model){
        this.model = model;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.FrameSize);
        this.setVisible(true);
        this.setResizable(true);
        this.getContentPane().setLayout(null);
        this.setBackground(Color.yellow);
        this.setTitle("Inventory Management System");
        
        this.Title = new JLabel("Select a store to view inventory",SwingConstants.CENTER);
        this.Title.setFont(Constants.titleFont);
        this.Title.setVisible(true);
        this.Title.setSize(Constants.framex, 100 );
        this.Title.setLocation(Constants.framex/2 - 100, 20);
        
        this.add(this.Title);
        
        this.pane = new JScrollPane();
        this.pane.createVerticalScrollBar();
        
        this.box = new JList(model.getStoresStringArray());
        this.box.setVisible(true);
        this.box.setSize(Constants.listBoxSize);
        this.box.setLocation(20,50);
        this.box.add(this.pane);
        
        this.add(this.box);
        
        
    }
    public void Update(){
        
    }
}
