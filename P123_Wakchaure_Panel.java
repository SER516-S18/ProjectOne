/*
 * @author Kanchan Wakchaure
 * Lab1: Create a panel with first_name, last_name and counter (using Timer)
 * Version 1.1
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.*;

public class P123_Wakchaure_Panel extends JPanel{	
	
	Timer timer;
	int count;
	
// Constructor to create the panel 
	public P123_Wakchaure_Panel(int p) {
			
		Font font = new Font("Papyrus", Font.PLAIN, 15);  //font of style PAPAYRUS
		setSize(100,100);   			          //panel size 100*100
		setLayout(new GridLayout(0, 1));
		
		//First name and Last name in panel
		JLabel f_label = new JLabel("<html>Kanchan<br>Wakchaure</html>");
		f_label.setFont(font);
		f_label.setHorizontalAlignment(JLabel.CENTER);
	        add(f_label);
			    
		//Counter
	        JLabel counter = new JLabel();
		counter.setFont(font);
		counter.setHorizontalAlignment(JLabel.CENTER);
		add(counter);
		
		
		//To set the color and timer			
		try {
		 if ( p % 2 == 0) {		      //if even number is passed to constructor
			 setBackground(Color.WHITE);	 
			 count = 0;	
			 timer = new Timer(1000, new ActionListener(){			  
				 public void actionPerformed(ActionEvent e) {			            				    
					    if (count < 10) {
					    	counter.setText(Integer.toString(count));
					    	
					    	if (count == 9) 
					    		count = 0;
					    	else 
					    		count++;
					    }
					    else {
							((Timer) (e.getSource())).stop();
						}
			  }
			 });
		 }
	     
		 else {		              //if odd number is passed to constructor								
			 setBackground(new Color(173,216,230));	//LightBlue
			 count = 9;
			 timer = new Timer(1000, new ActionListener(){			  
				 public void actionPerformed(ActionEvent e) {		 					
					 counter.setText(Integer.toString(count));
					 if (count >= 0) {
						 if (count == 0) 
							 count = 9;
						 else
							 count--;
					 }
				 }
			 });
		 }
		 timer.start();
		}			  
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
/* For validation	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		//To test
		JFrame frame = new JFrame("Lab1");
		frame.setVisible(true);
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		P123_Wakchaure_Panel p1 = new P123_Wakchaure_Panel(3); 
		frame.add(p1);
	}
*/
}
