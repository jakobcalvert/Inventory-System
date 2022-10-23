/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jakob
 */
public class Main {

    public static void main(String[] args) {

        AllStock Stock = SaveToFile.readAllStock();
        MainMenu menu = new MainMenu(Stock);

    }
}
