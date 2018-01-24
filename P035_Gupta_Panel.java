/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Scanner;



import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author mahimagupta
 */
 class P035_Gupta_Panel extends JPanel implements Runnable {
	
	JLabel labelName;
	JLabel timeLabel;
	Integer counter=0;
        public static Color LIGHT_BLUE = new Color(173,216,230);
        public final int HEIGHT = 100;
        public final int WIDTH = 100;
        public final int wait = 1000;
        Integer value;
     
         
        
	P035_Gupta_Panel(int val)  
        {  
	value=val;
        
        labelName = new JLabel("<html>Mahima<br>Gupta</html>");
        labelName.setFont(new Font("Papyrus", Font.BOLD, 15));
        labelName.setHorizontalAlignment(JLabel.CENTER);
        labelName.setVerticalAlignment(JLabel.CENTER);
        this.add(labelName);
    
      
        timeLabel = new JLabel("");
        timeLabel.setFont(new Font("Papyrus", Font.BOLD, 15)); 
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(timeLabel);
        
       this.setSize(HEIGHT,WIDTH); 
       this.setLayout(new GridLayout(2, 0));

       
        
      
       
         if(value%2==0) {

			this.setBackground(Color.WHITE);
                        counter=0;
                        }
		
        else            {
			this.setBackground(LIGHT_BLUE);
                        counter=9;
                        }


        
     
		
      
        Thread t = new Thread(this);
        t.start();
           
        } 
		@Override
		public void run() {
			
			while(true){
	            
                        if( value%2==0)
                        { 
                            if(counter <10)
                            {
                                try {
                                    Thread.sleep(wait);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(P035_Gupta_Panel.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            timeLabel.setText(counter.toString()); //JLabel displaying numbers from 0-9
                            counter++;
                            }
                            else counter=0;
                        }
                        else  
                        {
                        if(counter>=0)
                        {
                            try{
                                Thread.sleep(wait);
                                }
                            catch (InterruptedException ex)
                                {
                                Logger.getLogger(P035_Gupta_Panel.class.getName()).log(Level.SEVERE, null, ex);
                                 System.out.println("Error! Stopping the timer...");
                                }
                        timeLabel.setText(counter.toString()); //JLabel displaying numbers from 9-0
                        counter--;
                        
                               
                        }
                        else 
                            counter=9;
                        
                        
	                 
                        }   
                                }
                                }
            
	 }       	 
                   
        



