/**
* First Lab for SER 516. Simple panel to be added to the 4th group tab.
*
* @author Shaunak Shah (Under Professor Gonzalez Sanchez)
* @version 1/21/2018
*/

import java.awt.*;
import javax.swing.*;

//class extends JPanel as it functions as a panel and contains some basic functionality.
//define the labels for the panel such that they can be changed and used as per the 
//requirement

public class P101_Shah_Panel extends JPanel{
	
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private int value;
	
//	Contructor of the panel which accepts an integer based on which the background color
//	and the variant of counter will be decided while adding to the main tab/frame.
	
	public P101_Shah_Panel(int value){
		
		setSize(100,100);					
		setLayout(new GridBagLayout());
		
//		Defining the label for first and last name, as well as the counter.
		
		l1 = new JLabel("Shaunak");
		l1.setFont(new Font("Verdana", Font.PLAIN, 25));
		l2 = new JLabel("Shah");
		l2.setFont(new Font("Verdana", Font.PLAIN, 25));
		l3 = new JLabel();
		l3.setFont(new Font("Verdana", Font.PLAIN, 25));
	
//		check whether number is odd or even.
		
		if(value%2 == 0){
			setBackground(Color.WHITE);			// white background for even
		}
		else{
			setBackground(new Color(173, 216, 230));		// light blue background for odd 			
		}
		
//		Calling the create fucntion which basically arranges the Labels inside the Panel that
//		is created for the class
		
		create(value);
	}
	
//	Function accepts an integer as flag, checks whether it is even or odd. If even, the counter 
//	label increments from 0 to 9 and then again starts from 0. If found odd, it decrements from 
//	9 to 0 and again goes back to 9 and begins the process again.
	
	private void counter(int x){
				
		if(x%2 == 0){		//check if flag is even
			new Thread() {				   //run a thread so that the computation is done in parallel
		        public void run() {
		        	int counter = 0;
		            while(counter <= 9) {
		                l3.setText("" + (counter++));		//increment of the counter and adding that to the label
		                try{
		                    Thread.sleep(1000);
		                } catch(Exception e) {
		                	System.out.println("Exception while running the thread");
		                }	                
		            }
		            run();		//After one full iteration, recursing to the same function so that the counter is continuous
		        }
		    }.start();		//Instruction for the thread to begin the counting process			
		}
		else{				//If the flag is not even => it is odd, we run the exact same logic with little variation
			new Thread() {				        
		        public void run() {
		        	int counter = 9;	//Here counter starts from 9 and decreases to 0
		            while(counter >= 0) {
		                l3.setText("" + (counter--)); 		//Decrement of the counter
		                try{
		                    Thread.sleep(1000);
		                } catch(Exception e) {
		                	System.out.println("Exception while running the thread");
		                }	                
		            }
		            run();
		        }
		    }.start();		//Instruction for the thread to begin the counting process
		}
		
	}
	
	//Function arranges the labels inside a panel. In short where would the text and counter appear inside of a Panel.
	
	private void create(int x){
		
		GridBagConstraints c = new GridBagConstraints();	//grid structure for ease of arrangement 
		
		c.gridx = 0;		//setting x axis to 0
		c.gridy = 1;		//setting y axis to 1. Hence y = 2 will be below this
		add(l1, c);			//Assigning the earlier defined position to name label (l1)
		c.gridy = 2;		//setting y axis to 2. Hence y = 3 will be below this
		add(l2, c);			//Assigning the earlier defined position to last name label (l2)
		c.gridy = 3;		//setting y axis to 3. 
		
		counter(x);			//function adds the dynamic counter to the label l3 
		
		add(l3, c);			//Assigning the last defined position to l3 (counter)
	}
	
//	Created for testing only
	
//	public static void main(String[] args){
//				
//		P101_Shah_Panel s = new P101_Shah_Panel(10);  
//		JFrame f = new JFrame();
//        f.setSize(400, 400);
//        f.getContentPane().add(s);
//        f.setVisible(true);
//		
//	}
}
