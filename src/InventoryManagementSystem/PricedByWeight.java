/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

/**
 *
 * @author Jakob
 */
//this class is used to store the items that are priced by weight
public class PricedByWeight extends Item {

    //stores the price per kg of product
    private double pricePerKg;

    //stores the amount of product left in kg
    private double amountKg;

    //stores the price of restoking in kg
    private double stockPricePerKg;
    
    //basic constructor
    public PricedByWeight(String name, double pricePerKg, double amountKg, double stockPrice) {
        super(name);
        this.pricePerKg = pricePerKg;
        this.amountKg = amountKg;
        this.stockPricePerKg = stockPrice;
        if (this.amountKg > 0) {
            this.inStock = true;
        } else {
            this.inStock = false;
        }
    }

    //sets the price per kg
    public void setPricePerKg(double price) {
        this.pricePerKg = price;
    }

    //sets the amount in kg
    public void setAmountKg(double amount) {
        this.amountKg = amount;
    }

    //sets the stocking price 
    public void setStockPrice(double price) {
        this.stockPricePerKg = price;
    }

    //this method removes from the amount
    public void remove(double amount) {
        if (amount <= this.amountKg && amount > 0) {
            this.amountKg -= amount;
        }

    }

    //this method gets the stock price
    public double getStockPrice() {
        return this.stockPricePerKg;
    }

    //constructor to initialise the item using a string represenation save
    public PricedByWeight(String save) {
        super();
        this.setToStringRepresentation(save);
    }

    //returns a string representation of the item that can be used to save and initialise
    @Override
    public String getStringRepresentation() {
        return "W@" + this.name + "@" + this.amountKg + "@" + this.pricePerKg + "@" + this.stockPricePerKg;
    }

    //sets the item using a string representation of itself
    @Override
    public void setToStringRepresentation(String representation) {
        String[] split = representation.split("@");
        this.name = split[1];
        this.amountKg = Double.parseDouble(split[2]);
        this.pricePerKg = Double.parseDouble(split[3]);
        this.stockPricePerKg = Double.parseDouble(split[4]);
        if (this.amountKg > 0) {
            this.inStock = true;
        } else {
            this.inStock = false;
        }
    }

    //string representation of the object
    public String toString() {
        return this.name + " - [" + this.pricePerKg + "$/kg]";
    }

    //this method returns the price per kg
    public double getPricePerKg() {
        return this.pricePerKg;
    }

    //this method returns the amount in kg
    public double getAmountKg() {
        return this.amountKg;
    }

    //compare to method used to sort the items
    @Override
    public int compareTo(Item o) {
        if (o instanceof PricedByUnit) {
            return -1;
        }
        Double one = this.amountKg;
        Double two = ((PricedByWeight) o).amountKg;
        return one.compareTo(two);
    }
    
    //returns a array representation of the item for the staff
    @Override
    public String[] getStaffArray(){
        String[] returnString = {"Name: " + this.name ,"Price per KG: "+this.pricePerKg + "$/KG","Amount: "+this.amountKg + "KG","Stocking Price Per Kg: " + this.stockPricePerKg+ "$/KG"};
        return returnString;
    }
    
    //returns a array representation of the item for the customer
    @Override
    public String[] getCustomerArray(){
        String[] returnString = {"Name: " + this.name ,"Price per KG: "+this.pricePerKg + "$/KG","Amount: "+this.amountKg + "KG"};
        return returnString;
    } 
    
    

    
}
