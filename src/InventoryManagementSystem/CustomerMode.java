/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.util.Scanner;

/**
 *
 * @author Jakob
 */
//this class is how a customer interacts with the system
public class CustomerMode {

    //this scanner is used throughout the class so is public 
    public static Scanner scan;

    //this is the main method and how the customer interacts with the program
    public static boolean customerMode(AllStock stock) {
        scan = new Scanner(System.in);
        System.out.println("Customer mode selected");

        while (true) {
            stock.listStores();
            if (stock.size() == 0) {
                System.out.println("currently no stores available contact a staff member to create a store\npress x to exit the program");
            } else {
                System.out.println("Please Select a store by entering the number of the store you would like to browse: ");

            }

            try {
                String input = scan.nextLine();
                if (input.equals("X") || input.equals("x")) {
                    return true;

                } else if (input.equals("B") || input.equals("b")) {
                    return false;
                } else {
                    int index = Integer.parseInt(input);
                    Inventory inv = stock.getStock(index);
                    if (browseStore(inv)) {
                        return true;
                    }
                }

            } catch (Exception e) {
                System.out.println("Please enter a valid index");
            }
        }

    }

    //this method is how the used views all of the items in a specific store
    private static boolean browseStore(Inventory inventory) {
        System.out.println("You selected " + inventory.getLocationName());
        while (true) {
            if (inventory.getSize() == 0) {
                System.out.println("There are currently no items in this store");

            } else {
                System.out.println("Items at this store: ");
                inventory.printItems();
                System.out.println("Enter a index or a name to view more information about the product"
                        + "\nor enter B to return to previous menu:");
            }

            try {
                String input = scan.nextLine();
                Item selected = inventory.getProduct(input);
                if (input.equals("x") || input.equals("X")) {
                    return true;
                }
                if (input.equals("b") || input.equals("B")) {
                    return false;
                }
                if (selected == null) {
                    selected = inventory.getProduct(Integer.parseInt(input));
                }
                if (selected == null) {
                    System.out.println("Item not found try again");
                }
                if (selected instanceof PricedByUnit) {
                    if (pricedByUnit((PricedByUnit) selected)) {
                        return true;
                    }
                } else if (selected instanceof PricedByWeight) {
                    if (pricedByWeight((PricedByWeight) selected)) {
                        return true;
                    }
                }
            } catch (Exception E) {
                System.out.println("Item not found try again");
            }

        }

    }

    //this method gives the used information on priced by unit items
    private static boolean pricedByUnit(PricedByUnit item) {
        System.out.println("Information for product " + item.getName());
        System.out.println("Price: " + item.getPrice());
        System.out.println("Weight: " + item.getWeight());
        System.out.println("Amount of units left: " + item.getAmount());
        boolean cancel = false;
        while (true) {

            System.out.println("Enter buy if you would like to purchase or B to return to the previous menu: ");
            try {
                String input = scan.nextLine();
                if (input.equals("x") || input.equals("X")) {
                    return true;
                }
                if (input.equals("b") || input.equals("B")) {
                    return false;
                }
                if (input.toLowerCase().equals("buy")) {
                    while (true) {
                        try {
                            System.out.println("Enter the number of " + item.getName() + " you would like to purchase:");
                            input = scan.nextLine();
                            if (input.equals("x") || input.equals("X")) {
                                return true;
                            }
                            if (input.equals("b") || input.equals("B") || input.equals("c") || input.equals("C")) {
                                cancel = true;
                            }
                            int number = Integer.parseInt(input);
                            if (number > item.getAmount()) {
                                System.out.println("Not enough in stock");
                            } else {
                                System.out.println("Total cost for buying " + number + " " + item.getName() + " is " + number * item.getPrice() + "$");
                                System.out.println("To confirm enter y to cancel enter anything else");
                                try {
                                    input = scan.nextLine();
                                    if (input.toLowerCase().equals("y")) {
                                        item.removeAmount(number);
                                    }
                                    cancel = true;
                                } catch (Exception e) {
                                    cancel = true;
                                }

                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }
                        if (cancel) {
                            break;
                        }
                    }

                } else {
                    System.out.println("Invalid input");
                }

            } catch (Exception E) {
                System.out.println("Invalid input");
            }

        }

    }

    //this method gives the used information on priced by weight items
    private static boolean pricedByWeight(PricedByWeight item) {
        System.out.println("Information for product " + item.getName());
        System.out.println("Price per Kg: " + item.getPricePerKg() + "$/Kg");
        System.out.println("Amount left: " + item.getAmountKg() + "Kg");
        boolean cancel = false;
        while (true) {

            System.out.println("Enter buy if you would like to purchase or B to return to the previous menu: ");
            try {
                String input = scan.nextLine();
                if (input.equals("x") || input.equals("X")) {
                    return true;
                }
                if (input.equals("b") || input.equals("B")) {
                    return false;
                }
                if (input.toLowerCase().equals("buy")) {
                    while (true) {
                        try {
                            System.out.println("Enter the amount of " + item.getName() + " you would like to purchase in Kg:");
                            input = scan.nextLine();
                            if (input.equals("x") || input.equals("X")) {
                                return true;
                            }
                            if (input.equals("b") || input.equals("B") || input.equals("c") || input.equals("C")) {
                                cancel = true;
                            }
                            Double number = Double.parseDouble(input);
                            if (number > item.getAmountKg()) {
                                System.out.println("Not enough in stock");
                            } else {
                                System.out.println("Total cost for buying " + number + " " + item.getName() + " is " + number * item.getPricePerKg() + "$/Kg");
                                System.out.println("To confirm enter y to cancel enter anything else");
                                try {
                                    input = scan.nextLine();
                                    if (input.toLowerCase().equals("y")) {
                                        item.remove(number);
                                    }
                                    cancel = true;
                                } catch (Exception e) {
                                    cancel = true;
                                }

                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }
                        if (cancel) {
                            break;
                        }
                    }

                } else {
                    System.out.println("Invalid input");
                }

            } catch (Exception E) {
                System.out.println("Invalid input");
            }

        }

    }
}
