/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Jakob
 */
public class ForwardAndBackWards extends JPanel {
    JButton back;
    JButton forward;
    public ForwardAndBackWards(boolean backEnabled,boolean forEnabled){
        this.back = new JButton("Back");
        this.back.setLocation(10, 470);
        
        
        this.forward = new JButton("Next");
        
    }
    
    
}
