/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package InventoryManagementSystem;

import java.util.ArrayList;

/**
 *
 * @author Jakob
 */
//This class store the inventorys for all of the locations for the company
public class AllStock implements StringRepresentation {

    //this array stores all the inventorys
    private ArrayList<Inventory> Stores;
    
    //stores the server save file
    private ServerSaveFile serverSave;

    //this constructor initialises the array without a save
    public AllStock() {
        Stores = new ArrayList<>();
        serverSave = new ServerSaveFile();
    }
    
    //this constructor initialises the array with a array list of inventorys 
    public AllStock(ArrayList<Inventory> stores) {
        Stores = stores;
        serverSave = new ServerSaveFile();
    }

    //this constructor initialises the array and fills the inventorys with data
    public AllStock(String save) {
        Stores = new ArrayList<>();
        this.setToStringRepresentation(save);
        serverSave = new ServerSaveFile();
    }

    //this function is used to add stores to the application
    public void addStore(Inventory e) {
        this.Stores.add(e);
        serverSave.addStore(e);
    }

    //this function lists out all the stores names and their index numbers
    public void listStores() {
        if (this.Stores != null) {
            for (int i = 0; i < this.Stores.size(); i++) {
                System.out.println("[" + i + "] " + this.Stores.get(i).toString());
            }
        }

    }

    //this function returns a string that represents all of the stores and the products stored within the stores 
    //this can be read later and be read to initialize the stores array to be filled with data
    @Override
    public String getStringRepresentation() {
        String returnString = "";

        for (Inventory element : this.Stores) {
            returnString += element.getStringRepresentation() + "~";
        }
        return returnString;
    }

    //this function uses a string represenatation to set fill the stores array with data from the text file
    @Override
    public void setToStringRepresentation(String representation) {
        String[] split = representation.split("~");
        for (int i = 0; i < split.length; i++) {
            Stores.add(new Inventory(split[i]));
        }
    }

    public void remove(int index) {
        Inventory remove = this.getStock(index);
        this.Stores.remove(index);
        
        this.serverSave.removeStore(remove);
        
        
    }

    //this functions returns a store using its index
    public Inventory getStock(int index) {
        if (index < this.Stores.size() && index >= 0) {
            return this.Stores.get(index);
        } else {
            return null;
        }

    }

    //returns the the number of stores 
    public int size() {
        return this.Stores.size();
    }
    
    public String[] getStoresStringArray(){
        String[] array = new String[this.Stores.size()];
        for (int i = 0; i < this.Stores.size(); i++) {
            array[i] = this.Stores.get(i).toString();
        }
        return  array;
    }

}
