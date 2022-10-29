
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
public class CustomerProductListPanel extends JFrame {
    private Inventory model;
    public JList box;
    public JList box2;
    public JButton back;
    public JScrollPane pane2;
    public JButton Buy;

    private JScrollPane pane;
    
    private JLabel Title;
    
    
    
    public CustomerProductListPanel(Inventory model){
        this.model = model;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.FrameSize);
        this.setVisible(true);
        this.setResizable(true);
        this.getContentPane().setBackground(Constants.backGround);
        this.getContentPane().setLayout(null);
        this.setBackground(Constants.backGround);
        this.setTitle("Inventory Management System - Customer Mode");
        
        this.Title = new JLabel("Select a Item to view details");
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
        
        this.box2 = new JList();
        this.box2.setBackground(Constants.buttonColor);
        this.box2.setListData(this.model.getStringArray());
        this.box2.setForeground(Constants.fontColor);
        
        this.pane2 = new JScrollPane();
        this.pane2.getViewport().setView(this.box2);
        this.pane2.setVisible(false);
        this.pane2.setSize(Constants.listBoxSize.width, 75);
        this.pane2.setLocation(Constants.framex/2,60);

        this.add(pane2);
        
        this.back = new JButton("Back");
        this.back.setForeground(Constants.fontColor);
        this.back.setSize(Constants.ButtonSize);
        this.back.setVisible(true);
        this.back.setLocation(20 , Constants.framey - 40 - Constants.ButtonSize.height);
       
        this.add(this.back);      
        
        this.Buy = new JButton("Buy");
        this.Buy.setForeground(Constants.fontColor);
        this.Buy.setSize(Constants.listBoxSize.width,Constants.ButtonSize.height);
        this.Buy.setVisible(false);
        this.Buy.setLocation( Constants.framex/2 , 300);
        this.Buy.setForeground(Constants.fontColor);
        this.Buy.setBackground(Constants.buttonColor);
        
        this.add(this.Buy);
      
    }
    public void update(String[] update){
        this.box2.setListData(update);
    }
    
}


