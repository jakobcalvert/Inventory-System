/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jakob
 */
//class to manages the database
public class DataBaseManager {
    
    //data base variables 
    private static final String USER_NAME = "pdc"; 
    private static final String PASSWORD = "pdc"; 
    private static final String URL = "jdbc:derby:Inventory_DB_Ebd; create=true";
    Connection conn;

    //makes a connection with the database when the object is created
    public DataBaseManager() {
        establishConnection();
    }

    //returns the connection object
    public Connection getConnection() {
        return this.conn;
    }

    //if the conection has not already been made makes it
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    //if called closes the connection
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
