/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

/**
 *
 * @author Jakob
 */
// this abstract class is used for shared attributes between priced by unit and priced by weight
//Comparable is implemented so the classes that extend from this can be sorted
abstract public class Item implements Comparable<Item>, StringRepresentation {

    //name of the product
    protected String name;

    //stores weather the product is in stock
    protected boolean inStock;

    //constructor that initialises name
    public Item(String name) {
        this.name = name;
    }

    //constructor
    public Item() {

    }

    //returns the name of the item
    public String getName() {
        return this.name;
    }

    //used to set the name
    public void setName(String name) {
        this.name = name;
    }

}
