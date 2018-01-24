/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JPanel;
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
        Integer value;
        int determineCounter;
	 GridBagConstraints c;
        
	P035_Gupta_Panel(int val)  
        {  
	this.value=val;
      // creating labels
        labelName = new JLabel("<html><br>Mahima<br>Gupta<br><br><br><br><br><br><br></html>"); //JPanel with full namelabel,first namelabel on first row and last namelabel on the next row.
        timeLabel= new JLabel("");
    
        
        //Resetting the font for both the variables
        labelName.setFont(new Font("Papyrus", Font.BOLD, 15));
        timeLabel.setFont(new Font("Papyrus", Font.BOLD, 15)); 
        
        this.setLayout(new GridBagLayout());

        c = new GridBagConstraints();
        c.gridx=0;                                                   
	c.gridy=2;
        //Giving attributes to  panel
        this.setSize(HEIGHT,WIDTH); 
       
         if(value%2==0) {

			this.setBackground(Color.WHITE);
                        counter=0;
                     }
		
        else         {
			this.setBackground(new Color(189,214,238));
                        counter=9;
		}


        this.add(labelName,c);
        this.add(timeLabel,c);
		
      //Counter for displaying 0 to 9
        Thread t = new Thread(this);
        t.start();
           
        } 
	
		@Override
		public void run() {
			
			while(true){
	            try{
                        if( value%2==0)
                        { 
                            if(counter <10)
                            {
                            Thread.sleep(wait);
                            timeLabel.setText(counter.toString()); //JLabel displaying numbers from 0-9
                            counter++;
                            }
                            else counter=0;
                        }
                        else  
                        {
                        if(counter>=0)
                        {
                        Thread.sleep(wait);
                        timeLabel.setText(counter.toString()); //JLabel displaying numbers from 0-9
                        counter--;
                        }
                        else 
                            counter=9;
                        }
                        
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
     frame.add(panel);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);    
        frame.setLayout(null);    
        frame.setVisible(true);
        
      frame.add(new P035_Gupta_Panel(2));
       
        	 
        	
        }

*/

