package InventoryManagementSystem;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Jakob
 */
//this class creats the frame to display the list of items 
public class StaffProductListPanel extends JFrame {

    //initialises variables
    private Inventory model;
    public JList box;
    public JButton back;
    public JButton next;
    public JButton add;
    public JButton remove;
    public JTextField addName;
    public JTextField price;
    public JTextField weight;
    public JTextField stockingprice;
    public JSpinner amount;
    public JCheckBox unitOrWeight;
    public JLabel amountLabel;
    public JLabel invalidInput;

    private JScrollPane pane;
    private JLabel Title;

    //constructor sets all components
    public StaffProductListPanel(Inventory model) {
        //sets the model
        this.model = model;

        //sets the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.FrameSize);
        this.setVisible(true);
        this.setResizable(true);
        this.getContentPane().setBackground(Constants.backGround);
        this.getContentPane().setLayout(null);
        this.setBackground(Constants.backGround);
        this.setTitle("Inventory Management System - Staff Mode");

        //sets the title
        this.Title = new JLabel("Select a Item to view details about item and edit / add or remove a item");
        this.Title.setFont(Constants.titleFont);
        this.Title.setForeground(Constants.fontColor);
        this.Title.setSize(Constants.framex, 100);
        this.Title.setLocation(20, -20);
        //adds the title to the frame
        this.add(this.Title);

        //sets the list box
        this.box = new JList();
        this.box.setBackground(Constants.buttonColor);
        this.box.setListData(this.model.getStringArray());
        this.box.setForeground(Constants.fontColor);
        this.pane = new JScrollPane(this.box);
        this.pane.setSize(Constants.listBoxSize);
        this.pane.setLocation(20, 60);
        //adds the list box to the frame
        this.add(this.pane);

        //sets the back button
        this.back = new JButton("Back");
        this.back.setForeground(Constants.fontColor);
        this.back.setSize(Constants.ButtonSize);
        this.back.setLocation(20, Constants.framey - 40 - Constants.ButtonSize.height);
        //adds the back button to the frame
        this.add(this.back);

        //sets the next button 
        this.next = new JButton("Next");
        this.next.setForeground(Constants.fontColor);
        this.next.setSize(Constants.ButtonSize);
        this.next.setLocation(Constants.framex - 20 - Constants.ButtonSize.width, Constants.framey - 40 - Constants.ButtonSize.height);
        //adds the next button to the frame
        this.add(this.next);

        //sets the add button
        this.add = new JButton("Add");
        this.add.setForeground(Constants.fontColor);
        this.add.setSize(Constants.textFieldSize.width, Constants.ButtonSize.height);
        this.add.setLocation(Constants.framex / 2, 250);
        //adds the add button to the frame
        this.add(this.add);

        //sets the add name text field
        this.addName = new JTextField("Name of new Product");
        this.addName.setSize(Constants.textFieldSize);
        this.addName.setLocation(Constants.framex / 2, 90);
        this.addName.setForeground(Constants.fontColor);
        this.addName.setBackground(Constants.buttonColor);
        //adds the add name text field to the frame
        this.add(this.addName);

        //sets the remove button
        this.remove = new JButton("remove selected");
        this.remove.setForeground(Constants.fontColor);
        this.remove.setSize(Constants.textFieldSize.width, Constants.ButtonSize.height);
        this.remove.setLocation(Constants.framex / 2, 300);
        this.remove.setForeground(Constants.fontColor);
        this.remove.setBackground(Constants.buttonColor);
        //adds the remove button to the frame
        this.add(this.remove);

        //sets the price text field
        this.price = new JTextField("Enter the price");
        this.price.setSize(Constants.textFieldSize);
        this.price.setLocation(Constants.framex / 2, 120);
        this.price.setBackground(Constants.buttonColor);
        this.price.setForeground(Constants.fontColor);
        //adds the price text field to the frame
        this.add(this.price);

        //sets the weight text field
        this.weight = new JTextField("Enter the weight");
        this.weight.setSize(Constants.textFieldSize);
        this.weight.setLocation(Constants.framex / 2, 150);
        this.weight.setForeground(Constants.fontColor);
        this.weight.setBackground(Constants.buttonColor);
        //adds the  weight text field to the frame
        this.add(this.weight);

        //sets the stocking price text field
        this.stockingprice = new JTextField("Enter the stocking price");
        this.stockingprice.setSize(Constants.textFieldSize);
        this.stockingprice.setLocation(Constants.framex / 2, 180);
        this.stockingprice.setForeground(Constants.fontColor);
        this.stockingprice.setBackground(Constants.buttonColor);
        //adds the stocking price text field to the frame
        this.add(this.stockingprice);

        //sets the amount spinner
        this.amount = new JSpinner();
        this.amount.setSize(50, 30);
        this.amount.setLocation(Constants.framex / 2, 210);
        this.amount.setForeground(Constants.fontColor);
        this.amount.setBackground(Constants.buttonColor);
        //adds the amount spinner to the frame
        this.add(this.amount);

        //sets the amount label
        this.amountLabel = new JLabel("Enter the amount");
        this.amountLabel.setFont(Constants.regularFont);
        this.amountLabel.setSize(Constants.textFieldSize);
        this.amountLabel.setForeground(Constants.fontColor);
        this.amountLabel.setLocation(Constants.framex / 2 + 60, 210);
        //adds the amount label to the frame
        this.add(this.amountLabel);

        //set the unit or weight check box
        this.unitOrWeight = new JCheckBox("Priced by weight");
        this.unitOrWeight.setLocation(Constants.framex / 2, 60);
        this.unitOrWeight.setBackground(Constants.buttonColor);
        this.unitOrWeight.setSize(150, 30);
        this.unitOrWeight.setForeground(Constants.fontColor);
        //adds the unit or weight check box to the display
        this.add(this.unitOrWeight);

        //sets the invalid input lable
        this.invalidInput = new JLabel();
        this.invalidInput.setFont(Constants.regularFont);
        this.invalidInput.setSize(Constants.textFieldSize);
        this.invalidInput.setForeground(Color.red);
        this.invalidInput.setLocation(Constants.framex / 2 + 60, 30);
        //adds the invalid input label to the display
        this.add(this.invalidInput);

    }

    //method to update the list box
    public void update() {
        this.box.setListData(this.model.getStringArray());        
    }

}
