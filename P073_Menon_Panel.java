/******************************************************************************************************************
# Name of Program				:	P073_Menon_Panel.java
#
# Description					:	This program creates a JPanel in the following manner:
#									a) A Jlabel with full name (one row for first name, a second row for last name).
#									b) A Jlabel displaying a number (0 to 9). It will change automatically 
#										(increasing from 0 or decreasing from 9) every second.
#									c) A constructor that receives an integer value. 
#										If the value is Even or 0, background is White and the counter increases.
#										Else, background is light Blue and the counter decreases.
#
# Subject                       :   SER-516
#
# Project Number				:   1
#
# Due Date						:   23 Jan 2018
#
# Created By					:	Vimal Menon
#
# Created On                    :   20 Jan 2018
#
# IDE / OS                      :   Eclipse Neon 3 / Windows 10 (64 bit)
#******************************************************************************************************************/

import javax.swing.*;
import java.awt.*;

public class P073_Menon_Panel extends JPanel {
	private int num, numValue;
	
	private String firstName = "Vimal";
    private String lastName = "Menon";
	private JLabel fullName;
    
	public static final int LENGTH = 100;
	public static final int BREADTH = 100;
	
	Color lightBlue= new Color(203, 246, 255);
    
	public static final int TIMEGAP = 1000; // Equivalent to 1 second
    private int counter;
    private JLabel timerDisplay;
    
    // Constructor
    public P073_Menon_Panel(int num){
        
    	// To Display the Timer below the name, two rows and a column grid layout is employed.
    	super(new GridLayout(2,1));
    	
    	// Assigning the integer value passed to constructor to local variable.
    	numValue = num;
    	
        // Setting the size of the JPanel.
        setPreferredSize(new Dimension(LENGTH, BREADTH));
        
        // Setting the color of the Panel.
        // If Odd integer is passed, then Color is set to Light Blue, else White.
        if (numValue % 2 == 0)
            setBackground(Color.WHITE);
        else
            setBackground(lightBlue);	
        
    	// Setting the value of the "fullName" Jlabel along with type & size of Font.
        fullName = new JLabel("<html>" + firstName + "<br>" + lastName + "</html>", JLabel.CENTER);
        fullName.setFont(new Font("Papyrus", Font.BOLD, 16));
        add(fullName);
        
    	// Setting Counter start value for the Timer. 
    	// If Odd value passed, then Counter is initialized to 9 and then decremented.
    	// If Even value passed, then Counter is set to 0 and then incremented.
    	if (numValue % 2 == 0)
            counter = 0;
        else
            counter = 9;
        
    	// Second Jlabel for displaying a Counter which goes from 0 to 9 for Even and vice versa for Odd numbers.
    	timerDisplay = new JLabel(String.valueOf(counter), JLabel.CENTER);
    	timerDisplay.setFont(new Font("Papyrus",Font.BOLD,16));
        add(timerDisplay);
        timerMechanism();
    }
    
    /*****************************************************************************************************
	# Function / Method      		:	timerMechanism
	#
	# Description					:	A Timer which increases from 0 to 9 for Even values and decreases
	#									from 9 to 0 for Odd values.
	#
	# Parameters passed				:	none
	#
	# Returns						:	(nothing)
	#*****************************************************************************************************/
    
    private void timerMechanism() {
    	Thread timerThread = new Thread (new Runnable() {
    		public void run() {
    			if (counter == 0) {
    				for(int i = 1; i< 10; i++) {
		        	    try {
		        	        //sending the actual Thread of execution to sleep X milliseconds
		        	        Thread.sleep(TIMEGAP);
		        	    } catch(InterruptedException ie) {}
		        	    counter++;
		        	    timerDisplay.setText(String.valueOf(counter));
		        	}
    			} 
    			else {
		    		for(int i = 1; i< 10; i++) {
		        	    try {
		        	        //sending the actual Thread of execution to sleep X milliseconds
		        	        Thread.sleep(TIMEGAP);
		        	    } catch(InterruptedException ie) {}
		        	    counter--;
		        	    timerDisplay.setText(String.valueOf(counter));
		        	}
		    	}
    		}
    	});
    	timerThread.start();
    }
    
    //Main - for testing purposes
//    public static void main(String [] s) {
//        JFrame jFrame = new JFrame();
//        jFrame.setContentPane(new P073_Menon_Panel(100));
//        jFrame.pack();
//        jFrame.setVisible(true);
//    }
    
}