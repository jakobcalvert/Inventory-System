/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

/**
 *
 * @author Jakob
 */
//this class is used to store the items that are priced by unit
public class PricedByUnit extends Item {

    //stores the weight of the object
    private double weight;

    //stores the amount of items there are
    private int amount;

    //stores the price of the product
    private double price;

    //stores the price to restock the product
    private double stockPrice;

    //basic constructor with amount set to 0
    public PricedByUnit(String name, double price, double weight, double stockPrice) {
        super(name);
        this.price = price;
        this.amount = 0;
        this.inStock = false;
        this.stockPrice = stockPrice;
        this.weight = weight;
    }

    //another constructor with the amount added
    public PricedByUnit(String name, double price, int amount, double weight, double stockPrice) {
        this(name, price, weight, stockPrice);
        this.amount = amount;
        if (this.amount > 0) {
            this.inStock = true;
        } else {
            this.inStock = false;
        }
    }

    //constructor to initialise object using a text representation
    public PricedByUnit(String save) {
        super();
        this.setToStringRepresentation(save);
    }

    //return string representation of the product
    public String toString() {
        return this.name + " - [" + this.price + "$]";
    }

    //gets the weight of the product
    public double getWeight() {
        return this.weight;

    }

    //sets the weight
    public void setWeight(double weight) {
        this.weight = weight;
    }

    //gets the amount of product left
    public int getAmount() {
        return this.amount;
    }

    //sets the amount
    public void setAmount(int amount) {
        this.amount = amount;
        if (this.amount == 0) {
            this.inStock = false;
        }
    }

    //gets the price of the product
    public double getPrice() {
        return this.price;
    }

    //sets the price
    public void setPrice(double price) {
        this.price = price;
    }

    //gets the stock price
    public double getStockPrice() {
        return this.stockPrice;
    }

    //sets the stock price
    public void setStockPrice(double stockprice) {
        this.stockPrice = stockprice;
    }

    //returns a string representation to be saved includs u at start to show it is a priced by unit item
    @Override
    public String getStringRepresentation() {
        return "U@" + this.name + "@" + this.price + "@" + this.amount + "@" + this.weight;
    }

    //using a string representation of the object initialises the object
    @Override
    public void setToStringRepresentation(String representation) {
        String[] split = representation.split("@");
        this.name = split[1];
        this.price = Double.parseDouble(split[2]);
        this.amount = Integer.parseInt(split[3]);
        this.weight = Double.parseDouble(split[4]);
        if (this.amount > 0) {
            this.inStock = true;

        } else {
            this.inStock = false;
        }
    }

    //compares method so the items can be sorted with one another
    @Override
    public int compareTo(Item o) {
        if (o instanceof PricedByWeight) {
            return 1;
        }
        Integer one = this.amount;
        Integer two = ((PricedByUnit) o).amount;
        return one.compareTo(two);
    }

    //used to remove a certain amount of a product
    public void removeAmount(int amount) {
        if (amount <= this.amount && amount > 0) {
            this.amount -= amount;
        }
    }

    //used to add a certain amount of a product
    public void addAmount(int amount) {
        if (amount > 0) {
            this.amount += amount;
        }
    }
    
    
    //returns a array representation of the item for the staff
    @Override
    public String[] getStaffArray() {
        String[] returnString = {"Name: " + this.name, "Price: " + this.price + "$", "Amount: " + this.amount, "Stocking Price: " + this.stockPrice + "$", "Weight: " + this.weight + "KG"};
        return returnString;
    }

    //returns a array representation of the item for the customer
    @Override
    public String[] getCustomerArray() {
        String[] returnString = {"Name: " + this.name, "Price: " + this.price + "$", "Amount: " + this.amount, "Weight: " + this.weight + "KG"};
        return returnString;
    }

}
