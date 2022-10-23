/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jakob
 */
public class Main {
private static JFrame frame;
    public static void main(String[] args) {
        frame = new JFrame("Inventory Management System");
        
        AllStock Stock = SaveToFile.readAllStock();
        MainMenu menu = new MainMenu(Stock);
        
        frame.add(menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setVisible(true);
        

    }
    public static void changePanel(JPanel panel){
        //frame.removeAll();
        frame.add(panel);
    }
}
