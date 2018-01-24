/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Shibani Hegde
 */

public class P003_Arvind_Panel extends JPanel{ 
    private JLabel firstName = new JLabel("Shibani", JLabel.CENTER);
    private JLabel lastName = new JLabel("Arvind", JLabel.CENTER);
    private JLabel counterLabel = new JLabel("0", JLabel.CENTER);    
    Color bgColor;        
    int counter;

    public P003_Arvind_Panel(int flag) {    	
    	if (flag % 2 == 0) {
            bgColor = Color.WHITE;
            this.counter = 0;
       	} else {
            Color color = new Color(173, 216, 230);            
            bgColor = color;
            this.counter = 9;
    	}
    	try {
            configureComponents(bgColor);
            Timer t = new Timer(1000, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (flag % 2 == 0) {
                        if (counter < 9)
                            counter++;
                        else
                            counter = 0;
                        counterLabel.setText(String.valueOf(counter));                        
                    } else {
                        if (counter > 0)
                            counter--;
                        else
                            counter = 9;						
                        counterLabel.setText(String.valueOf(counter));				
                    }
                }
            });
            t.start();
    	} catch(Exception e) {
            System.out.println(e.getMessage());
    	}    	         
    }
    
    public void configureComponents(Color bgColor) throws Exception {
        this.setSize(100, 100);
        firstName.setFont(new Font("Papyrus",Font.PLAIN,15));
    	lastName.setFont(new Font("Papyrus",Font.PLAIN,15));
        this.add(firstName);
    	this.add(lastName);
        firstName.setAlignmentX(Component.CENTER_ALIGNMENT);
    	lastName.setAlignmentX(Component.CENTER_ALIGNMENT);
    	this.setBackground(bgColor);    	  	    	    	
    	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    	counterLabel.setFont(new Font("Papyrus",Font.PLAIN,15));
    	this.add(counterLabel);
    	counterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);    	
    }    
}
