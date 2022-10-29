
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
public class StaffProductListPanel extends JFrame {
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
    
    
    
    public StaffProductListPanel(Inventory model){
        this.model = model;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.FrameSize);
        this.setVisible(true);
        this.setResizable(true);
        this.getContentPane().setBackground(Constants.backGround);
        this.getContentPane().setLayout(null);
        this.setBackground(Constants.backGround);
        this.setTitle("Inventory Management System - Staff Mode");
        
        this.Title = new JLabel("Select a Item to view details about item and edit");
        this.Title.setFont(Constants.titleFont);
        this.Title.setVisible(true);
        this.Title.setForeground(Constants.fontColor);
        this.Title.setSize(Constants.framex, 100 );
        this.Title.setLocation(20, -20);
        
        this.add(this.Title);
        
        this.box = new JList();
        this.box.setBackground(Constants.buttonColor);
        this.box.setListData(this.model.getStringArray());
        this.box.setForeground(Constants.fontColor);
        this.pane = new JScrollPane();
        this.pane.getViewport().setView(this.box);
        this.pane.setVisible(true);
        this.pane.setSize(Constants.listBoxSize);
        this.pane.setLocation(20,60);
                
        this.add(this.pane);
        
        this.back = new JButton("Back");
        this.back.setForeground(Constants.fontColor);
        this.back.setSize(Constants.ButtonSize);
        this.back.setVisible(true);
        this.back.setLocation(20 , Constants.framey - 40 - Constants.ButtonSize.height);
       
        this.add(this.back);
        
        this.next = new JButton("next");
        this.next.setForeground(Constants.fontColor);
        this.next.setSize(Constants.ButtonSize);
        this.next.setVisible(true);
        this.next.setLocation( Constants.framex - 20 - Constants.ButtonSize.width , Constants.framey - 40 - Constants.ButtonSize.height);
       
        this.add(this.next);
        
        
        this.add = new JButton("Add");
        this.add.setForeground(Constants.fontColor);
        this.add.setSize(Constants.textFieldSize.width,Constants.ButtonSize.height);
        this.add.setVisible(true);
        this.add.setLocation( Constants.framex/2 , 250);
        
        this.add(this.add);
        
        this.addName = new JTextField("Name of new Product");
        this.addName.setVisible(true);
        this.addName.setSize(Constants.textFieldSize);
        this.addName.setLocation(Constants.framex/2, 90);
        this.addName.setForeground(Constants.fontColor);
        this.addName.setBackground(Constants.buttonColor);
            
        this.add(this.addName);
        
        
        this.remove = new JButton("remove selected");
        this.remove.setForeground(Constants.fontColor);
        this.remove.setSize(Constants.textFieldSize.width,Constants.ButtonSize.height);
        this.remove.setVisible(true);
        this.remove.setLocation( Constants.framex/2 , 300);
        this.remove.setForeground(Constants.fontColor);
        this.remove.setBackground(Constants.buttonColor);
        
        this.add(this.remove);
        
        this.price = new JTextField();
        this.price.setText("Enter the price");
        this.price.setVisible(true);
        this.price.setSize(Constants.textFieldSize);
        this.price.setLocation(Constants.framex/2,120);
        this.price.setBackground(Constants.buttonColor);
        this.price.setForeground(Constants.fontColor);
            
        this.add(this.price);
        
        this.weight = new JTextField();
        this.weight.setText("Enter the weight");
        this.weight.setVisible(true);
        this.weight.setSize(Constants.textFieldSize);
        this.weight.setLocation(Constants.framex/2,150);
        this.weight.setForeground(Constants.fontColor);
        this.weight.setBackground(Constants.buttonColor);
            
        this.add(this.weight);
        
        this.stockingprice = new JTextField();
        this.stockingprice.setText("Enter the stocking price");
        this.stockingprice.setVisible(true);
        this.stockingprice.setSize(Constants.textFieldSize);
        this.stockingprice.setLocation(Constants.framex/2,180);
        this.stockingprice.setForeground(Constants.fontColor);
        this.stockingprice.setBackground(Constants.buttonColor);
            
        this.add(this.stockingprice);
        
        this.amount = new JSpinner();
        this.amount.setVisible(true);
        this.amount.setSize(50,30);
        this.amount.setLocation(Constants.framex/2,210);
        this.amount.setForeground(Constants.fontColor);
        this.amount.setBackground(Constants.buttonColor);
            
        this.add(this.amount);
        
        this.amountLabel = new JLabel("Enter the amount");
        this.amountLabel.setFont(Constants.regularFont);
        this.amountLabel.setSize(Constants.textFieldSize);
        this.amountLabel.setVisible(true);
        this.amountLabel.setForeground(Constants.fontColor);
        this.amountLabel.setLocation(Constants.framex/2 + 60,210);
        
        this.add(this.amountLabel);
        
        this.unitOrWeight = new JCheckBox("Priced by weight");
        this.unitOrWeight.setLocation(Constants.framex/2,60);
        this.unitOrWeight.setBackground(Constants.buttonColor);
        this.unitOrWeight.setVisible(true);
        this.unitOrWeight.setSize(150,30);
        this.unitOrWeight.setForeground(Constants.fontColor);
        
        this.add(this.unitOrWeight);
        
        this.invalidInput = new JLabel();
        this.invalidInput.setFont(Constants.regularFont);
        this.invalidInput.setSize(Constants.textFieldSize);
        this.invalidInput.setVisible(false);
        this.invalidInput.setForeground(Color.red);
        this.invalidInput.setLocation(Constants.framex/2 + 60,30);
        
        this.add(this.invalidInput);
                
            
    }
    public void update(){
        this.box.setListData(this.model.getStringArray());
    }
    
}


