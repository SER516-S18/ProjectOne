/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author mahimagupta
 */
public class P035_Gupta_Panel extends JPanel implements Runnable {
	
	JLabel labelName;
	JLabel timeLabel;
	Integer counter=0;
        public final int HEIGHT = 100;
        public final int WIDTH = 100;
        public final int wait = 1000;
        
        
	P035_Gupta_Panel(int val)  
        {  
	
      // creating labels
        labelName = new JLabel("<html>Mahima<br>Gupta</html>"); //JPanel with full namelabel,first namelabel on first row and last namelabel on the next row.
        timeLabel= new JLabel("");
        
        //Resetting the font for both the variables
        labelName.setFont(new Font("Papyrus", Font.BOLD, 15));
        timeLabel.setFont(new Font("Papyrus", Font.BOLD, 15));                             
        
        //Giving attributes to  panel
        this.setSize(HEIGHT,WIDTH); 
       
         if(val%2==0) {

			this.setBackground(Color.WHITE);
                     }
		
        else         {
			this.setBackground(new Color(173,216,230));
		}


        this.add(labelName);
        this.add(timeLabel);
		
      //Counter for displaying 0 to 9
        Thread t = new Thread(this);
        t.start();
           
        } 
	
		@Override
		public void run() {
			
			while(true){
	            try{
                        if(counter <10)
                        { Thread.sleep(wait);
                            timeLabel.setText("            "+counter.toString()); //JLabel displaying numbers from 0-9
                            
	               
	                counter++;
	                
                        }
                        else counter=0;
                        
	            }       catch (InterruptedException ex) {
                                Logger.getLogger(P035_Gupta_Panel.class.getName()).log(Level.SEVERE, null, ex);
                                 System.out.println("Error! Stopping the timer...");
		    }   
	            }
	            }
                  

	        }
/*
public static void main(String args[])  
        {  
        JFrame frame=new JFrame("");
     
        
      frame.add(new P035_Gupta_Panel(1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);    
        frame.setLayout(null);    
        frame.setVisible(true);
        	 
        	
        }
*
