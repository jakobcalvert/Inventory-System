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

/**
 *
 * @author Jakob
 */
public class ServerSaveFile {

    SimpleDBManager dbManager;
    Connection conn;
    Statement statement;

    public ServerSaveFile() {
        dbManager = new SimpleDBManager();
        conn = dbManager.getConnection();
        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) throws SQLException {
        ServerSaveFile sbs = new ServerSaveFile();

        try {
            /* sbs.statement.addBatch("CREATE TABLE PricedByWeight (\n" +
"    AMOUNT VARCHAR(20) NOT NULL,\n" +
"    STOCKPRICE VARCHAR(20) NOT NULL,\n" +
"    PRICE VARCHAR(20) not null,\n" +
                    "ITEMNAME VARCHAR(256), \n"+
"    PRIMARY KEY (ITEMNAME),\n" +
"     NAME VARCHAR(256)"+
")");
            sbs.statement.addBatch("alter table pricedbyweight add FOREIGN KEY (NAME) REFERENCES STORES(NAME)");
            
             sbs.statement.addBatch("CREATE TABLE pricedByunit (\n" +
"    AMOUNT VARCHAR(20) NOT NULL,\n" +
"    STOCKPRICE VARCHAR(20) NOT NULL,\n" +
"    PRICE VARCHAR(20) not null,\n" +
                     "weight VARCHAR(20) not null,"+
                    "ITEMNAME VARCHAR(256), \n"+
"    PRIMARY KEY (ITEMNAME),\n" +
"     NAME VARCHAR(256)"+
")");
            sbs.statement.addBatch("alter table pricedbyunit add FOREIGN KEY (NAME) REFERENCES STORES(NAME)");
             
            sbs.statement.addBatch("INSERT INTO Stores VALUES ('walmart'),\n"
                   + "('loui vuton'),\n"
                 + "('green corp')");
*/
            //sbs.statement.addBatch("INSERT INTO pricedbyunit VALUES ('100', '10', '20', '0.2', 'taylor made boots', 'walmart')\n" );
                  
            sbs.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        ResultSet rs = null;
        System.out.println("2");
        try {
            rs = sbs.statement.executeQuery("SELECT * "
                    + "FROM pricedbyunit ");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        while (rs.next()) {

            String sd = rs.getString("amount");

            System.out.println(sd);
        }
        System.out.println("3");
        sbs.closeConnection();
    }

    public void closeConnection() {
        this.dbManager.closeConnections();
    }

}
