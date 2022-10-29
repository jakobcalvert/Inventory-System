/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jakob
 */
public class Main {

    public static void main(String[] args) {
        try{
            ServerSaveFile save = new ServerSaveFile();
            AllStock Stock = save.readTables();
            MainMenu menu = new MainMenu(Stock);    
        } catch(Exception E){
            System.out.println("Previous instance of program has not been closed please close before proceeding ");
        }
    }
}
