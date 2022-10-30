/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem.LegacyCode;

import InventoryManagementSystem.AllStock;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author Jakob
 */
//this class will save the state of the stock in program
public class SaveToFile {

    //keeps the file locations in one play
    public static File file = new File("Resources/Save.txt");

    //reads the stock from file and returns a object file filled with data from the file
    public static AllStock readAllStock() {
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = br.readLine();
            if (str == null || str.equals("")) {
                return new AllStock();
            } else {
                return new AllStock(str);
            }

        } catch (Exception E) {
            return new AllStock();
        }

    }

    //saves the stock object to the text file
    public static void saveAll(AllStock stock) {

        try {

            PrintWriter writer = new PrintWriter(file);
            writer.append(stock.getStringRepresentation());
            writer.close();
        } catch (Exception E) {
            System.out.println("File write error");
        }

    }

}
