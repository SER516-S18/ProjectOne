/*
Lab1
Author: Vaishak Ramesh Vellore
The class creates a Panel with First and Last Name's of a person.
A counter is incremented and decremented from 0-9 or 9-0.
The background color changes depending on the integer passed to the constructor.
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class P094_Vellore_Panel {
	/* The class consists of a JPanel with the Firstname and Lastname*/
	//The JPanel is of size 100*100 
	private JPanel panel;
	private JLabel name;
	private JLabel timer;
	private boolean var;
	
	public JPanel P094_Vellore_Panel() {
		
		//setting up JPanel.
		panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		if(var==false)
			panel.setBackground(Color.blue);
		else
			panel.setBackground(Color.white);
		
		//setting the size of the panel x,y axis
		panel.setPreferredSize(new Dimension(100,100));
		panel.setMaximumSize( panel.getPreferredSize() );
		
		//setting up JLabel
		//lable with first and last name details
		name = new JLabel("<html><br>Vaishak<br>Ramesh Vellore</html>");
		timer=new JLabel();
		
		//Resetting the font for both the variables
		Font font = new Font("Papyrus", Font.PLAIN, 15);
		name.setFont(font);
		timer.setFont(font);
				
		name.setHorizontalAlignment(JLabel.CENTER);
	    timer.setHorizontalAlignment(JLabel.CENTER);
		
		panel.add(name);
		panel.add(timer);
		panel.setVisible(true);
		
		//setting up counter. 
		if(var==true) 
			TimerIncrement();
		else
			TimerDecrement();
		
		return panel;
	}//end of JLabel
	
	
	//Constructor for the class
		public P094_Vellore_Panel(int num) {
			/* A parameter is sent to the constructor and if this number is even then it is set to true*/
			if(num%2==0)
				var=true;
			else
				var=false;
		}// end of constructor

	
	public void TimerIncrement() {
		new Thread() {
	        int counter = 0;
	        public void run() {
	            while(true) {
	            	if(counter==10)
	            		counter=0;	
	            	
	                timer.setText(" " +counter++);
	                try{
	                    Thread.sleep(1000);
	                } 
	                catch(Exception e) {}
	            }
	        }
	    }.start();
	}//end or function. 
	
	
	public void TimerDecrement() {
		/* Start the thread and run from 0-9 */
		new Thread() {
	        int counter = 9;
	        public void run() {
	            while(true) {
	            	if(counter==-1)
	            			counter=9;
	            	
	            	timer.setText(" " +counter--);
	                try{
	                	Thread.sleep(1000);
	                } 
	                catch(Exception e) {}
	            }
	        }
	    }.start();
	}//end or function. 
	
	
	public static void main(String[] args) {
		
		P094_Vellore_Panel object= new P094_Vellore_Panel(4);
		JPanel a =object.P094_Vellore_Panel();
		JFrame b=new JFrame(" ");
		b.setVisible(true);
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.getContentPane().add(a);
		b.pack();
		
	}// end of main
}//end of class