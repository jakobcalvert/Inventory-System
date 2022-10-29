/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import javax.swing.JOptionPane;


/**
 *
 * @author Jakob
 */
//this is where the program is first started 
public class Main {

    public static void main(String[] args) {
        //starts the program 
        try{
            //creates a new server save file
            ServerSaveFile save = new ServerSaveFile();
            //initialises all stock variable to contain the contents of the server
            AllStock Stock = save.readTables();
            //creates new menu frame
            MainMenu menu = new MainMenu(Stock);    
        } catch(Exception E){
            //called if the user has another instance of this code open
            JOptionPane.showMessageDialog(null, "Previous instance of program has not been closed please close before proceeding ");
            
        }
    }
}
