
package InventoryManagementSystem;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
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
    public JTextField amount;
    public JCheckBox unitOrWeight;
    
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
        this.box.setListData(this.model.getStringArray());
        this.pane = new JScrollPane();
        this.pane.getViewport().setView(this.box);
        this.pane.setVisible(true);
        this.pane.setSize(Constants.listBoxSize);
        this.pane.setLocation(20,80);
        
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
        
        this.next = new JButton("next");
        this.next.setForeground(Constants.fontColor);
        this.next.setSize(Constants.ButtonSize);
        this.next.setVisible(true);
        this.next.setLocation( Constants.framex - 20 - Constants.ButtonSize.width , Constants.framey - 40 - Constants.ButtonSize.height);
       
        this.add(this.next);
        
        this.add = new JButton("Add");
        this.add.setForeground(Constants.fontColor);
        this.add.setSize(Constants.ButtonSize);
        this.add.setVisible(true);
        this.add.setLocation( Constants.framex/2 , Constants.framey/2);
        
        this.add(this.add);
        
        this.addName = new JTextField();
        this.addName.setVisible(true);
        this.addName.setSize(120,30);
        this.addName.setLocation(Constants.framex/2,Constants.framey/2 + 40);
            
        this.add(this.addName);
        
        
        this.remove = new JButton("remove");
        this.remove.setForeground(Constants.fontColor);
        this.remove.setSize(Constants.ButtonSize);
        this.remove.setVisible(true);
        this.remove.setLocation( Constants.framex/2 , Constants.framey/2+80);
        
        this.add(this.remove);
        
        this.price = new JTextField();
        this.price.setVisible(true);
        this.price.setSize(120,30);
        this.price.setLocation(Constants.framex/2,Constants.framey/2 + 40);
            
        this.add(this.price);
        
        this.weight = new JTextField();
        this.weight.setVisible(true);
        this.weight.setSize(120,30);
        this.weight.setLocation(Constants.framex/2,Constants.framey/2 + 40);
            
        this.add(this.weight);
        
        this.stockingprice = new JTextField();
        this.stockingprice.setVisible(true);
        this.stockingprice.setSize(120,30);
        this.stockingprice.setLocation(Constants.framex/2,Constants.framey/2 + 40);
            
        this.add(this.stockingprice);
        
        this.amount = new JTextField();
        this.amount.setVisible(true);
        this.amount.setSize(120,30);
        this.amount.setLocation(Constants.framex/2,Constants.framey/2 + 40);
            
        this.add(this.amount);
        
        this.unitOrWeight = new JCheckBox("Priced by weight");
        this.unitOrWeight.setLocation(Constants.framex/2,Constants.framey/2 -40);
        
        this.add(this.unitOrWeight);
        
                
            
    }
    public void update(){
        this.box.setListData(this.model.getStringArray());
    }
    
}


