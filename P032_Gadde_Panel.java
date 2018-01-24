// Import libraries
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/* 
 * @author Vijaya Mounika Gadde
 * Implementation for SER 516 Lab-1
 * It contains a panel with three rows of Jlabels with one for the first name,one for the last name and one for the counter.
 * The background color is set to white and the counter increments if the value passed is even and
 * if the value passed is odd, the background is set to blue and the counter decrements. 
 */
public class P032_Gadde_Panel extends JPanel{
	// Variables Initialization
		private JLabel name;
	    private JLabel timer;
	    private int count;
	    private int value;
	    public final int DELAY = 1000;
	 // Constructor
	    public P032_Gadde_Panel(int value){
	        try{
	            this.value = value;
	            setPanelSize();
	            set_layout();
	            setBackgroundColor();
	            setCounterValue();
	            setClockTimer();
	        }
	        catch (Exception e){
	        	e.printStackTrace();
	        }

	    }

	    //  If value passed is even it sets to 0 and if it is odd it sets to 9
	    private void setCounterValue() {
	        if(is_even()){
	            count = 0;
	        }
	        else{
	            count = 9;
	        }
	    }
	    // If the value is even it increments by 1 else it decrements by 1
	    private void setClockTimer() {
	        timer = new JLabel(String.valueOf(count));
	        timer.setFont(new Font("Papyrus",Font.PLAIN,15));
	        name = new JLabel("<html>Vijayamounika<br>Gadde</html>");
	    	name.setFont(new Font("Papyrus",Font.PLAIN,15));
	    	name.setHorizontalAlignment(JLabel.CENTER);
	        name.setVerticalAlignment(JLabel.CENTER);
	        timer.setVerticalAlignment(JLabel.CENTER);
	        timer.setHorizontalAlignment(JLabel.CENTER);
	        this.add(name);
	        this.add(timer);

	        // Starts the timer
	        ActionListener taskPerformer = new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(is_even() && count == 9){
	                    count = 0;
	                }
	                else if(!is_even() && count == 0){
	                    count = 9;
	                }
	                else if(is_even() == true){
	                    count = count + 1;
	                }
	                else{
	                    count = count -1;
	                }
	                timer.setText(String.valueOf(count));
	            }
	        };
	        new Timer(DELAY, taskPerformer).start();
	    }

	    // Function to set  background color of the panel to white if the value is even else it set to light blue.
	    private void setBackgroundColor() {

	    	if(is_even()){
	            this.setBackground(Color.WHITE);
	        }
	        else{
	            this.setBackground(new Color(173, 216, 230));
	        }
	    }

	    // function to set the panel size
	    private void setPanelSize() {
	    	this.setPreferredSize(new Dimension(100,100));
	    }
	    
	    // function to set the Layout
	    private void set_layout() {
	        this.setLayout(new GridLayout(2, 1));
	    }

	    // Checks if the value is even or odd
	    private boolean is_even(){
	        return value % 2 == 0;
	    }
/* Main method in case of testing */
/*  public static void main(String [] s) {
      JFrame frame = new JFrame();
      frame.setContentPane(new P032_Gadde_Panel(2));
	    frame.setSize(500, 500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
  }*/
	}
