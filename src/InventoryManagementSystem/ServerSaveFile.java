/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jakob
 */
//this class is resposible for saving and reading from the server
public class ServerSaveFile {

    DataBaseManager dbManager;
    Connection conn;
    Statement statement;

    public ServerSaveFile() {
        dbManager = new DataBaseManager();
        conn = dbManager.getConnection();
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    //initialises the tables for the inventory management system if not already done will not be called unless the program cannot read a table
    public void initialiseTables() {
        try {
            //each batch is a sql statement to create a table the two tables priced by weight and priced by unit are dependant on the table stores
            statement.addBatch("CREATE TABLE STORES (\n"
                    + "Name VARCHAR(256),\n"
                    + "PRIMARY KEY (Name)\n"
                    + ")");

            statement.addBatch("CREATE TABLE PricedByWeight (\n"
                    + "AMOUNT VARCHAR(20) NOT NULL,\n"
                    + "STOCKPRICE VARCHAR(20) NOT NULL,\n"
                    + "PRICE VARCHAR(20) not null,\n"
                    + "ITEMNAME VARCHAR(256), \n"
                    + "PRIMARY KEY (ITEMNAME),\n"
                    + "NAME VARCHAR(256)"
                    + ")");
            //adds foreign key to the stores table
            statement.addBatch("alter table pricedbyweight add FOREIGN KEY (NAME) REFERENCES STORES(NAME)");

            statement.addBatch("CREATE TABLE pricedByunit (\n"
                    + "AMOUNT VARCHAR(20) NOT NULL,\n"
                    + "STOCKPRICE VARCHAR(20) NOT NULL,\n"
                    + "PRICE VARCHAR(20) not null,\n"
                    + "WEIGHT VARCHAR(20) not null,"
                    + "ITEMNAME VARCHAR(256), \n"
                    + "PRIMARY KEY (ITEMNAME),\n"
                    + "NAME VARCHAR(256)"
                    + ")");
            //adds foreign key to the stores table
            statement.addBatch("alter table pricedbyunit add FOREIGN KEY (NAME) REFERENCES STORES(NAME)");

            //execute all batch statements
            statement.executeBatch();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //this method adds a new priced by unit table entry into the database
    public void addPricedByUnit(Inventory e, PricedByUnit item) {
        try {
            statement.addBatch("INSERT INTO pricedbyunit VALUES ('" + item.getAmount() + "', '" + item.getStockPrice() + "', '" + item.getPrice() + "', '" + item.getWeight() + "', '" + item.getName() + "', '" + e.getLocationName() + "')");
            statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //this method adds a new priced by weight entry into the data base
    public void addPricedByWeight(Inventory e, PricedByWeight item) {
        try {
            statement.addBatch("INSERT INTO pricedbyweight VALUES ('" + item.getAmountKg() + "', '" + item.getStockPrice() + "', '" + item.getPricePerKg() + "', '" + item.getName() + "', '" + e.getLocationName() + "')");
            statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addStore(Inventory e) {
        try {
            statement.addBatch("INSERT INTO Stores VALUES ('" + e.getLocationName() + "')");
            statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void removeStore(Inventory e){
        try {
            statement.addBatch("DELETE FROM Stores WHERE Name='"+e.getLocationName() + "'");
            statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void removePricedByUnit(Inventory e, PricedByUnit item){
        try {
            statement.addBatch("DELETE FROM PricedByUnit WHERE Name='"+e.getLocationName() + "' and itemName = '"+item.getName()+"'");
            statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void removePricedByWeight(Inventory e, PricedByWeight item){
        try {
            statement.addBatch("DELETE FROM PricedByweight WHERE Name='"+e.getLocationName() + "' and itemName = '"+item.getName()+"'");
            statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public AllStock readTables() {
        ArrayList<Inventory> stores = readStores();
        return new AllStock(stores);
    }
    public void readItems(Inventory e) {
        readPricedByUnit(e);
        readPricedByWeight(e);
    }

    public ArrayList<Inventory> readStores() {
        ArrayList<Inventory> returnList = new ArrayList<>();
        try {
            ResultSet results;

            results = statement.executeQuery("SELECT * "
                    + "FROM Stores ");

            while (results.next()) {

                String name = results.getString("NAME");

                returnList.add(new Inventory(name));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return returnList;
    }

    public void readPricedByUnit(Inventory inv) {

        try {
            ResultSet results;

            results = statement.executeQuery("SELECT * "
                    + "FROM pricedbyunit where name='" + inv.getLocationName() + "'  ");

            while (results.next()) {
                
                String name = results.getString("ITEMNAME");
                double price = Double.parseDouble(results.getString("PRICE"));
                int amount = Integer.parseInt(results.getString("AMOUNT"));
                double weight = Double.parseDouble(results.getString("WEIGHT"));
                double stockPrice = Double.parseDouble(results.getString("STOCKPRICE"));

                PricedByUnit unit = new PricedByUnit(name, price, amount, weight, stockPrice);
                inv.addProduct(unit);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void readPricedByWeight(Inventory inv) {
        try {
            ResultSet results;

            results = statement.executeQuery("SELECT * "
                    + "FROM pricedbyweight where name='" + inv.getLocationName() + "'  ");

            while (results.next()) {
                String name = results.getString("ITEMNAME");
                double price = Double.parseDouble(results.getString("PRICE"));
                double weight = Double.parseDouble(results.getString("AMOUNT"));
                double stockPrice = Double.parseDouble(results.getString("STOCKPRICE"));

                PricedByWeight add = new PricedByWeight(name, price, weight, stockPrice);
                inv.addProduct(add);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        ServerSaveFile sbs = new ServerSaveFile();
        sbs.readStores();
        sbs.readPricedByUnit(new Inventory("walmart"));
        sbs.closeConnection();
    }

    public void closeConnection() {
        this.dbManager.closeConnections();
    }

}
