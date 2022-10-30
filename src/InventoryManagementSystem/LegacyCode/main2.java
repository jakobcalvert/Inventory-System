/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem.LegacyCode;

import InventoryManagementSystem.AllStock;
import InventoryManagementSystem.LegacyCode.StaffMode;
import java.util.Scanner;

/**
 *
 * @author Jakob
 */
//this is the main2 class of the program 
public class main2 {

    //This is the starting poing of the program it prompts the user to pick between being a customer and a staff
    public static void main(String[] args) {

        AllStock Stock = SaveToFile.readAllStock();

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Inventory Management System!");
        System.out.println("To save exit at any time enter X any other method of closing the program will not save the changes made by the user "
                + "\nto return to a previous menu enter b.");
        System.out.println("Customers are able to view all products and purchase and staff are able to edit any of the information saved.");

        while (true) {
            System.out.println("Enter C if you would like to access as a customer and S if you would like to access as a staff member");
            String input = scan.nextLine();
            if (input.equals("C") || input.equals("c")) {

                if (CustomerMode.customerMode(Stock)) {
                    break;
                }

            } else if (input.equals("S") || input.equals("s")) {
                if (StaffMode.staffMode(Stock)) {
                    break;
                }

            } else if (input.equals("X") || input.equals("x")) {
                break;
            } else {
                System.out.println("Invalid input try again");
            }
        }
        SaveToFile.saveAll(Stock);
    }

}
