/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Jakob
 */
public class MainMenu extends JPanel {

    private JButton exit;
    private JButton studentMode;
    private JButton staffMode;
    private AllStock model;

    public MainMenu(AllStock model) {
        this.model = model;
        this.studentMode = new JButton("Student Mode");
        this.studentMode.setLocation(10, 10);
        this.studentMode.setVisible(true);

        this.add(studentMode);

        this.studentMode.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                studentModeClick();
            }
        });
        
        this.staffMode = new JButton("Staff Mode");
        this.staffMode.setLocation(20, 10);
        this.staffMode.setVisible(true);

        this.add(staffMode);

        this.staffMode.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                staffModeClick();
            }
        });

    }
    public void staffModeClick(){
        StaffModePanel panel = new StaffModePanel(model);
        Main.changePanel(panel);
    }
    public void studentModeClick(){
        StaffModePanel panel = new StaffModePanel(model);
        Main.changePanel(panel);
    }

}
