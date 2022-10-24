/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem.LegacyCode;

import InventoryManagementSystem.AllStock;
import InventoryManagementSystem.Inventory;
import InventoryManagementSystem.Item;
import InventoryManagementSystem.PricedByUnit;
import InventoryManagementSystem.PricedByWeight;
import java.util.Scanner;

/**
 *
 * @author Jakob
 */
//this class is how the staff interacts with the program
public class StaffMode {

    //this scan object is utilised throughout the class so it is initialises a public 
    public static Scanner scan;

    //this method controlls how the staff can access the code
    public static boolean staffMode(AllStock stock) {
        scan = new Scanner(System.in);
        System.out.println("Staff mode selected");

        while (true) {
            stock.listStores();
            if (stock.size() == 0) {
                System.out.println("No Stores currently registered type add to add a new store");
            } else {
                System.out.println("Please Select a store by entering the number of the store you would like to edit or"
                        + "\nenter add or remove to add or remove a store another store: ");

            }
            try {
                String input = scan.nextLine();
                if (input.equals("X") || input.equals("x")) {
                    return true;

                } else if (input.equals("B") || input.equals("b")) {
                    return false;
                } else if (input.toLowerCase().equals("add")) {
                    if (addStore(stock)) {
                        return true;
                    }
                } else if (input.toLowerCase().equals("remove")) {
                    if (removeStore(stock)) {
                        return true;
                    }
                } else {
                    int index = Integer.parseInt(input);
                    Inventory inv = stock.getStock(index);
                    if (editStore(inv)) {
                        return true;
                    }
                }

            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    //this method is used to edit the store object
    private static boolean editStore(Inventory inventory) {
        System.out.println("You selected " + inventory.getLocationName());
        while (true) {
            if (inventory.getSize() == 0) {
                System.out.println("There are currently no items in this store");
                System.out.println("Enter add to add some items to the store:");
            } else {
                System.out.println("Items at this store: ");
                inventory.printItems();
                System.out.println("Enter a index or a name to edit the product or enter add to add a product of remove "
                        + "\nto remove a product\nenter B to return to previous menu:");
            }

            try {
                String input = scan.nextLine();

                if (input.equals("x") || input.equals("X")) {
                    return true;
                }
                if (input.equals("b") || input.equals("B")) {
                    return false;
                }
                if (input.toLowerCase().equals("add")) {
                    if (addItem(inventory)) {
                        return true;
                    }
                }
                if (input.toLowerCase().equals("remove")) {
                    if (removeItem(inventory)) {
                        return true;
                    }

                } else {
                    Item selected = inventory.getProduct(input);
                    if (selected == null) {
                        int index = Integer.parseInt(input);
                        selected = inventory.getProduct(index);
                    }
                    if (selected == null) {
                        System.out.println("Item not found try again");
                    }
                    if (selected instanceof PricedByUnit) {

                        if (editPricedByUnit((PricedByUnit) selected)) {
                            return true;

                        }
                    } else if (selected instanceof PricedByWeight) {
                        if (editPricedByWeight((PricedByWeight) selected)) {
                            return true;
                        }
                    }
                }

            } catch (Exception E) {
                System.out.println("Item not found try again");
            }

        }
    }

    //this method remove a store that the used picks using its index
    private static boolean removeStore(AllStock stock) {
        while (true) {
            try {
                System.out.println("Enter the index of the Store you would like to remove or press b to cancel:");
                String index = scan.nextLine();
                if (index.equals("X") || index.equals("x")) {
                    return true;
                } else if (index.equals("B") || index.equals("b")) {
                    return false;

                } else if (stock.getStock(Integer.parseInt(index)) != null) {
                    stock.remove(Integer.parseInt(index));
                    System.out.println("Store removed");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
                scan.next();
            }
        }

    }

    //this method adds a store to the stock object
    private static boolean addStore(AllStock stock) {
        while (true) {
            try {
                System.out.println("Enter the Name of the new Store or press b to cancel:");
                String name = scan.nextLine();
                if (name.equals("X") || name.equals("x")) {
                    return true;
                } else if (name.equals("B") || name.equals("b")) {
                    return false;

                } else if (name.contains("@") || name.contains(">") || name.contains("~")) {
                    System.out.println("Invalid name try again");
                } else {
                    stock.addStore(new Inventory(name, true));
                    System.out.println("Store Created");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
                scan.next();
            }
        }

    }

    //this method edits a item that is priced by weight it can change all of its variables
    private static boolean editPricedByWeight(PricedByWeight item) {
        System.out.println("Selected " + item.getName());
        while (true) {
            try {
                System.out.println("Information for product " + item.getName() + ":");
                System.out.println("Price per Kg: " + item.getPricePerKg() + "$/Kg");
                System.out.println("Amount left: " + item.getAmountKg() + "Kg");
                System.out.println("Stock price: " + item.getStockPrice() + "$/Kg");
                System.out.println("Enter name to edit the name, price to edit the Price per Kg, stock to edit the stock price and amount to edit the amount left in kg");
                System.out.println("Enter b to return to the previous menu");
                String input = scan.nextLine();
                if (input.equals("x") || input.equals("X")) {
                    return true;
                } else if (input.equals("b") || input.equals("B")) {
                    return false;
                } else if (input.toLowerCase().equals("name")) {
                    while (true) {
                        try {
                            System.out.println("Enter the new name");
                            String name = scan.nextLine();
                            if (input.equals("x") || input.equals("X")) {
                                return true;
                            } else if (input.equals("b") || input.equals("B")) {
                                break;
                            } else if (name.contains("@") || name.contains(">") || name.contains("~")) {
                                System.out.println("Invalid input");
                            } else {
                                item.setName(name);
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }
                    }
                } else if (input.toLowerCase().equals("price")) {
                    while (true) {
                        try {
                            System.out.println("Enter the new price");
                            String price = scan.nextLine();
                            if (price.equals("x") || price.equals("X")) {
                                return true;
                            } else if (price.equals("b") || price.equals("B")) {
                                break;
                            } else if (!(Double.parseDouble(price) > 0)) {
                                System.out.println("Invalid input");
                            } else {
                                item.setPricePerKg(Double.parseDouble(price));
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }
                    }
                } else if (input.toLowerCase().equals("amount")) {
                    while (true) {
                        try {
                            System.out.println("Enter the new amount");
                            String amount = scan.nextLine();
                            if (amount.equals("x") || amount.equals("X")) {
                                return true;
                            } else if (amount.equals("b") || amount.equals("B")) {
                                break;
                            } else if (!(Double.parseDouble(amount) >= 0)) {
                                System.out.println("Invalid input");
                            } else {
                                item.setAmountKg(Double.parseDouble(amount));
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }
                    }
                } else if (input.toLowerCase().equals("stock")) {
                    while (true) {
                        try {
                            System.out.println("Enter the new stock price per kg");
                            String stock = scan.nextLine();
                            if (stock.equals("x") || stock.equals("X")) {
                                return true;
                            } else if (input.equals("b") || input.equals("B")) {
                                break;
                            } else if (!(Double.parseDouble(stock) > 0)) {
                                System.out.println("Invalid input");
                            } else {
                                item.setAmountKg(Double.parseDouble(stock));
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    //this method edits a item that is priced by the unit it can edit all of its values
    private static boolean editPricedByUnit(PricedByUnit item) {
        System.out.println("Selected " + item.getName());
        while (true) {
            try {
                System.out.println("Information for product " + item.getName() + ":");
                System.out.println("Price: " + item.getPrice() + "$");
                System.out.println("Weight: " + item.getWeight() + "Kg");
                System.out.println("Amount of units left: " + item.getAmount());
                System.out.println("Stocking price: " + item.getPrice() + "$");
                System.out.println("Enter name to edit the name, price to edit the Price, weight to edit the weight, stock to edit the stocking price and amount to edit the amount left in kg");
                System.out.println("Enter b to return to the previous menu");
                String input = scan.nextLine();
                if (input.equals("x") || input.equals("X")) {
                    return true;
                } else if (input.equals("b") || input.equals("B")) {
                    return false;
                } else if (input.toLowerCase().equals("name")) {
                    while (true) {
                        try {
                            System.out.println("Enter the new name");
                            String name = scan.nextLine();
                            if (input.equals("x") || input.equals("X")) {
                                return true;
                            } else if (input.equals("b") || input.equals("B")) {
                                break;
                            } else if (name.contains("@") || name.contains(">") || name.contains("~")) {
                                System.out.println("Invalid input");
                            } else {
                                item.setName(name);
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }
                    }
                } else if (input.toLowerCase().equals("price")) {
                    while (true) {
                        try {
                            System.out.println("Enter the new price");
                            String price = scan.nextLine();
                            if (price.equals("x") || price.equals("X")) {
                                return true;
                            } else if (price.equals("b") || price.equals("B")) {
                                break;
                            } else if (!(Double.parseDouble(price) > 0)) {
                                System.out.println("Invalid input");
                            } else {
                                item.setPrice(Double.parseDouble(price));
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }
                    }
                } else if (input.toLowerCase().equals("amount")) {
                    while (true) {
                        try {
                            System.out.println("Enter the new amount");
                            String amount = scan.nextLine();
                            if (amount.equals("x") || amount.equals("X")) {
                                return true;
                            } else if (amount.equals("b") || amount.equals("B")) {
                                break;
                            } else if (!(Double.parseDouble(amount) >= 0)) {
                                System.out.println("Invalid input");
                            } else {
                                item.setAmount(Integer.parseInt(amount));
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }
                    }
                } else if (input.toLowerCase().equals("stock")) {
                    while (true) {
                        try {
                            System.out.println("Enter the new stock price");
                            String stock = scan.nextLine();
                            if (stock.equals("x") || stock.equals("X")) {
                                return true;
                            } else if (input.equals("b") || input.equals("B")) {
                                break;
                            } else if (!(Double.parseDouble(stock) > 0)) {
                                System.out.println("Invalid input");
                            } else {
                                item.setStockPrice(Double.parseDouble(stock));
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }
                    }
                } else if (input.toLowerCase().equals("weight")) {
                    while (true) {
                        try {
                            System.out.println("Enter the new weight ");
                            String weight = scan.nextLine();
                            if (weight.equals("x") || weight.equals("X")) {
                                return true;
                            } else if (input.equals("b") || input.equals("B")) {
                                break;
                            } else if (!(Double.parseDouble(weight) > 0)) {
                                System.out.println("Invalid input");
                            } else {
                                item.setWeight(Double.parseDouble(weight));
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    //this method adds items to the specific shops list
    private static boolean addItem(Inventory inventory) {
        while (true) {
            try {
                System.out.println("Enter the name of the item you would like to add enter b to cancel: ");

                String name = scan.nextLine();
                if (name.equals("X") || name.equals("x")) {
                    return true;
                } else if (name.equals("B") || name.equals("b")) {
                    return false;

                } else if (name.contains("@") || name.contains(">") || name.contains("~")) {
                    System.out.println("Invalid name try again");
                } else {
                    System.out.println("Enter the item type w for priced my weight and u for priced by unit:");
                    String Type = scan.nextLine();
                    if (Type.equals("X") || Type.equals("x")) {
                        return true;
                    } else if (Type.equals("B") || Type.equals("b")) {
                        return false;

                    } else if (Type.toLowerCase().equals("u")) {
                        while (true) {
                            System.out.println("Enter the price of the item you would like to add enter b to cancel: ");
                            try {
                                String price = scan.nextLine();
                                if (price.equals("X") || price.equals("x")) {
                                    return true;
                                } else if (price.equals("B") || price.equals("b")) {
                                    return false;

                                } else {
                                    Double priced = Double.parseDouble(price);
                                    while (true) {
                                        System.out.println("Enter the amount of the item you would like to add enter b to cancel: ");
                                        try {
                                            String amount = scan.nextLine();
                                            if (amount.equals("X") || amount.equals("x")) {
                                                return true;
                                            } else if (amount.equals("B") || amount.equals("b")) {
                                                return false;

                                            } else {
                                                int amounti = Integer.parseInt(amount);
                                                while (true) {
                                                    System.out.println("Enter the weight of the item you would like to add enter b to cancel: ");
                                                    try {
                                                        String weight = scan.nextLine();
                                                        if (weight.equals("X") || weight.equals("x")) {
                                                            return true;
                                                        } else if (weight.equals("B") || weight.equals("b")) {
                                                            return false;

                                                        } else {
                                                            Double weightd = Double.parseDouble(weight);
                                                            while (true) {
                                                                System.out.println("Enter the stocking price of the item you would like to add enter b to cancel: ");
                                                                try {
                                                                    String stock = scan.nextLine();
                                                                    if (stock.equals("X") || stock.equals("x")) {
                                                                        return true;
                                                                    } else if (stock.equals("B") || stock.equals("b")) {
                                                                        return false;

                                                                    } else {
                                                                        Double stockprice = Double.parseDouble(stock);
                                                                        inventory.addProduct(new PricedByUnit(name, priced, amounti, weightd, stockprice));
                                                                        System.out.println("Item added");
                                                                        return false;
                                                                    }
                                                                } catch (Exception e) {
                                                                    System.out.println("Invalid input");
                                                                }
                                                            }
                                                        }
                                                    } catch (Exception e) {
                                                        System.out.println("Invalid input");
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Invalid input");
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid input");
                            }
                        }
                    } else if (Type.toLowerCase().equals("w")) {
                        while (true) {
                            System.out.println("Enter the price per Kg of the item you would like to add enter b to cancel: ");
                            try {
                                String price = scan.nextLine();
                                if (price.equals("X") || price.equals("x")) {
                                    return true;
                                } else if (price.equals("B") || price.equals("b")) {
                                    return false;

                                } else {
                                    Double priceKg = Double.parseDouble(price);
                                    while (true) {
                                        System.out.println("Enter the amount of the item you would like to add enter b to cancel: ");
                                        try {
                                            String amount = scan.nextLine();
                                            if (amount.equals("X") || amount.equals("x")) {
                                                return true;
                                            } else if (amount.equals("B") || amount.equals("b")) {
                                                return false;

                                            } else {
                                                double amountKg = Double.parseDouble(amount);
                                                while (true) {
                                                    System.out.println("Enter the weight of the item you would like to add enter b to cancel: ");
                                                    try {
                                                        String stock = scan.nextLine();
                                                        if (stock.equals("X") || stock.equals("x")) {
                                                            return true;
                                                        } else if (stock.equals("B") || stock.equals("b")) {
                                                            return false;

                                                        } else {
                                                            Double stockPrice = Double.parseDouble(stock);
                                                            inventory.addProduct(new PricedByWeight(name, priceKg, amountKg, stockPrice));
                                                            System.out.println("Item added");
                                                            return false;
                                                        }
                                                    } catch (Exception e) {
                                                        System.out.println("Invalid input");
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Invalid input");
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid input");
                            }
                        }
                    } else {
                        System.out.println("Invalid type try again");
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    //this method removes items of index given by user from store
    private static boolean removeItem(Inventory inventory) {
        while (true) {
            try {
                System.out.println("Enter the index you would line to remove ");
                String input = scan.nextLine();
                if (input.equals("x") || input.equals("X")) {
                    return true;
                } else if (input.equals("b") || input.equals("B")) {
                    return false;

                } else {
                    inventory.removeProduct(Integer.parseInt(input));
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }

    }
}
