/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Timer;

/**
 *
 * @author srajangupta
 * @version 1.2
 * @since 18-01-2018
 */
 public class P038_Gupta_Panel extends JPanel{
   
    public P038_Gupta_Panel(int timerCalculate)
    {
        
        setLayout(null);
        setSize(100,100);
        
        /**
          Creating Labels for adding Full name and timer.
            */
        
        JLabel firstName,lastName,timerLabel;   
        Color lightBlue = new Color(90,150,255); 
        firstName=new JLabel("Srajan");
        lastName=new JLabel("Gupta");
        firstName.setBounds(10, 5, 100, 30);
        lastName.setBounds(10, 20, 100, 30);
        firstName.setFont(new Font("Papyrus",Font.BOLD,16));
        lastName.setFont(new Font("Papyrus",Font.BOLD,16));
        add(firstName);
        add(lastName);  
        
    /**
    Creating a counter from zero to nine or nine to zero based on the condition.  
        
        * if the number passed is Even, Counter Starts from 0 and goes till 9
        and sets the background color white
        
        * Else it starts from 9 goes till 0 and sets the background color
        LightBlue
            */  
        
        timerLabel = new JLabel();
        Thread t = new Thread(new Runnable() {
            int incCounter=0,decCouter=9;
               
            @Override
            public void run() {                   
                
                while (true) {
                    try {
                        if(timerCalculate%2==0)
                        {
                            add(timerLabel);
                            setBackground(Color.white);
                            timerLabel.setText(String.valueOf(incCounter));
                            timerLabel.setBounds(60, 13, 100, 30);    
                        
                        if (incCounter<9)
                            incCounter++;
                        else 
                            incCounter = 0;
                        
                        }
                        else 
                        {   
                            setBackground(lightBlue);
                            add(timerLabel);
                            timerLabel.setText(String.valueOf(decCouter));
                            timerLabel.setBounds(60, 13, 100, 30);
                          
                          if(decCouter>0)
                              decCouter--;
                          else
                              decCouter=9;                
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        t.start();
 }

}


