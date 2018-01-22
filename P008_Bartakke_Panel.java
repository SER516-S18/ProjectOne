package com.P008.Bartakke.Panel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * This class implements a JPanel with following contents:
 * A Label for Name (JLabel Name)
 * A Label to display a counter (JLabel Name2)
 * 
 * In this class the parameterized constructor takes a value.
 * Based on this value the Background Color and the Counter change.
 * 
 * If value is odd then background color is light blue and counter decrements from 9 - 0
 * If value is even then background color is white and counter increments from 0 - 9
 * Note that counter keeps on running continuously
 * 
 * @author Pratik Bartakke
 * Date created- 01-20-2018
 *
 */

public class P008_Bartakke_Panel 
{
	Timer timer; // Timer object for counter
	int counter = 0; // Variable for incrementing counter scenario
	int counter2 = 9; // Variable for decrementing counter scenario
	int value;
	P008_Bartakke_Panel(int flag)
	{
		value = flag; // Parameterized constructor accepting value based upon which background color and counter change
	}
	
	public JPanel Logic() // The function that holds the main logic for the background color and counter change and where panel and labels ae created
	{
		JPanel Panel1 = new JPanel();
		Font f = new Font("Papyrus", Font.BOLD, 10); // Defining the font for name label
		Font f1 = new Font("Papyrus", Font.BOLD, 15); // Defining the font for counter label
		Color lightBlue= new Color(32,190,215); // Defining the light blue color for background
		JLabel Name = new JLabel("<html>PRATIK<br>BARTAKKE</html>",JLabel.CENTER);
		JLabel Name2 = new JLabel("",JLabel.CENTER);
		Name.setFont(f);
		Name2.setFont(f1);
		Name.setBounds(10,10,80,80);
		Panel1.add(Name);
		Name2.setBounds(10,60,30,30);
		Panel1.add(Name2);
		Panel1.setSize(100, 100);
		Panel1.setLayout(null);

		try // Exception handling included for the changing background and counter conditions
    	{
    		if(value % 2 == 0) // Checks whether value is even
    		{
    			Panel1.setBackground(Color.white); // If value is even background set to white
    			timer = new Timer(1000, new ActionListener() // Timer initialized with 1 sec interval
    			{
    	            @Override
    	            public void actionPerformed(ActionEvent e) 
    	            {
    	                Name2.setText(String.valueOf(counter)); // Display counter value starting from 0
    	                counter++; // Increment counter till it reaches 9
    	                if (counter == 10) 
    	                {
    	                     counter = 0; // Reset counter once it reaches 9 to restart the counting from 0
    	                }
    	            }
    		     });
    		        timer.start(); // Start timer for displaying the counter
    		}
    		else // Value is odd
    		{
    			Panel1.setBackground(lightBlue); // background set to light blue
    			timer = new Timer(1000, new ActionListener()
    			{
    	            @Override
    	            public void actionPerformed(ActionEvent e)
    	            {
    	                Name2.setText(String.valueOf(counter2));
    	                Name2.setBackground(lightBlue);
    	                counter2--; // Decrement counter till it reaches 0
    	                if (counter2 == -1)
    	                {
    	                     counter2 = 9; // Reset counter once it reaches 0 to restart the counting from 9
    	                }
    	            }
    	        });
    	        timer.start(); // Start timer for displaying the counter
    		}
    	}
    	catch(Exception e) // Any exceptions encountered are handled in this part
    	{
    		System.out.println("Error in Timer and Background Color Display");
			e.printStackTrace();
    	}
    	return Panel1;
	}
	
	/*
	// FOR TESTING ONLY - Specification requires this to remain in here.
	public static void main(String[] args) 
	{
		P008_Bartakke_Panel Obj = new P008_Bartakke_Panel(5);
		JPanel Pan1 = Obj.Logic();
		JFrame Frame1 = new JFrame("PRATIK BARTAKKE PANEL");
		Frame1.add(Pan1);
		Frame1.setSize(150, 150);
		Frame1.setLayout(null);    
        Frame1.setVisible(true);
	}*/
}
