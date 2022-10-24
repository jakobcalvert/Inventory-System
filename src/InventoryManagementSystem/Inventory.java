/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jakob
 */
//this class is used to store the inventory of a specific store location
public class Inventory implements StringRepresentation {

    //this array stores the items
    public ArrayList<Item> Stock;

    //this string stores the locations name
    private String locationName;

    //this constructor initialises a new store
    public Inventory(String locationName, boolean isMade) {
        this.Stock = new ArrayList<>();
        this.locationName = locationName;
    }

    //this constructor reads a string that represents a save for the inventory and creates the inventory
    public Inventory(String Representation) {
        this.Stock = new ArrayList<>();
        this.setToStringRepresentation(Representation);
    }

    //this gives a string representation of the location
    public String toString() {
        return this.locationName;
    }

    //prints all of the items in the store
    public void printItems() {
        for (int i = 0; i < this.Stock.size(); i++) {
            System.out.println("[" + i + "] " + Stock.get(i).toString());
        }
    }

    //makes a string representation of the object to be saved in a text file
    @Override
    public String getStringRepresentation() {
        String returnString = this.locationName;
        for (int i = 0; i < Stock.size(); i++) {
            returnString += ">" + Stock.get(i).getStringRepresentation();
        }
        return returnString;
    }

    //reads a string representation of the object and makes the current object equal that representation
    @Override
    public void setToStringRepresentation(String representation) {
        String[] split = representation.split(">");
        this.locationName = split[0];
        for (int i = 1; i < split.length; i++) {
            String[] type = split[i].split("@");
            if (type[0].equals("U")) {
                this.Stock.add(new PricedByUnit(split[i]));
            } else {
                this.Stock.add(new PricedByWeight(split[i]));
            }

        }
    }

    //adds product to the stock array
    public void addProduct(Item item) {
        this.Stock.add(item);
        Collections.sort(this.Stock);
    }

    //removes product of certain index from the stock array
    public void removeProduct(int index) {
        this.Stock.remove(index);
    }

    //removes a product from the array of a certain name
    public void removeProduct(String name) {
        for (int i = 0; i < this.Stock.size(); i++) {
            if (this.Stock.get(i).getName().equals(name)) {
                this.Stock.remove(i);
            }
        }
    }

    //gets a product of a certain index
    public Item getProduct(int index) {
        if (index >= 0 && index < this.Stock.size()) {
            return this.Stock.get(index);
        }
        return null;
    }

    //gets a product of a certain name
    public Item getProduct(String name) {
        for (Item element : this.Stock) {
            if (element.getName().equals(name)) {
                return element;

            }
        }
        return null;
    }

    //returns location name
    public String getLocationName() {
        return locationName;
    }

    //returns the number of items 
    public int getSize() {
        return this.Stock.size();
    }
    
    public String[] getStringArray(){
        String[] array = new String[this.Stock.size()];
        for (int i = 0; i < this.Stock.size(); i++) {
            array[i] = this.Stock.get(i).toString();
        }
        return  array;
    }
}
