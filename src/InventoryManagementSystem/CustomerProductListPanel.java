
package InventoryManagementSystem;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;


/**
 *
 * @author Jakob
 */
//frame displaying all of the items and their details
public class CustomerProductListPanel extends JFrame {
   
    //initialises variables 
    private Inventory model;
    public JList box;
    public JList ItemDetails;
    public JButton back;
    public JScrollPane ItemDetailsPane;
    public JButton Buy;
    private JScrollPane pane;
    private JLabel Title;
    
    
    //sets the variables when the frame is created
    public CustomerProductListPanel(Inventory model){
        //initialises variables 
        this.model = model;

        //sets the frame 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.FrameSize);
        this.setVisible(true);
        this.setResizable(true);
        this.getContentPane().setBackground(Constants.backGround);
        this.getContentPane().setLayout(null);
        this.setBackground(Constants.backGround);
        this.setTitle("Inventory Management System - Customer Mode");
        
        //sets the title 
        this.Title = new JLabel("Select a Item to view details");
        this.Title.setFont(Constants.titleFont);
        this.Title.setVisible(true);
        this.Title.setForeground(Constants.fontColor);
        this.Title.setSize(Constants.framex, 100 );
        this.Title.setLocation(20, -20);
        //adds the title to the frame
        this.add(this.Title);
        
        //sets the list box containing the items 
        this.box = new JList();
        this.box.setBackground(Constants.buttonColor);
        this.box.setListData(this.model.getStringArray());
        this.box.setForeground(Constants.fontColor);
        this.pane = new JScrollPane();
        this.pane.getViewport().setView(this.box);
        this.pane.setVisible(true);
        this.pane.setSize(Constants.listBoxSize);
        this.pane.setLocation(20,60);
        //adds the list box to the 
        this.add(this.pane);
        
        //set the item details box
        this.ItemDetails = new JList();
        this.ItemDetails.setBackground(Constants.buttonColor);
        this.ItemDetails.setListData(this.model.getStringArray());
        this.ItemDetails.setForeground(Constants.fontColor);
        this.ItemDetailsPane = new JScrollPane(this.ItemDetails);
        this.ItemDetailsPane.setVisible(false);
        this.ItemDetailsPane.setSize(Constants.listBoxSize.width, 75);
        this.ItemDetailsPane.setLocation(Constants.framex/2,60);
        //adds the box to the frame
        this.add(ItemDetailsPane);
        
        //sets the back button
        this.back = new JButton("Back");
        this.back.setForeground(Constants.fontColor);
        this.back.setSize(Constants.ButtonSize);
        this.back.setLocation(20 , Constants.framey - 40 - Constants.ButtonSize.height);
        //adds the back button to the frame
        this.add(this.back);      
        
        //sets the buy button
        this.Buy = new JButton("Buy");
        this.Buy.setForeground(Constants.fontColor);
        this.Buy.setSize(Constants.listBoxSize.width,Constants.ButtonSize.height);
        this.Buy.setVisible(false);
        this.Buy.setLocation( Constants.framex/2 , 300);
        this.Buy.setForeground(Constants.fontColor);
        this.Buy.setBackground(Constants.buttonColor);
        //adds the buy button to the frame
        this.add(this.Buy);
      
    }
    //updates the item details box after a change has been made
    public void update(String[] update){
        this.ItemDetails.setListData(update);
    }
    
}


