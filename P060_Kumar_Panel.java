import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



/**
 * @author Abhishek Kumar
 *
 */
public class P060_Kumar_Panel extends JPanel {

	//variables
    private JLabel firstName;
	
	private JLabel lastName;
    
	private int inputValue;

    private JLabel displayNum;

    private int counter;

    
    /**Constructor
     * @param inputValue-to check the number as even or odd number input
     */
    public P060_Kumar_Panel(int inputValue){

        try {
    	
	    	this.inputValue = inputValue;
		    	
	        this.setPreferredSize(new Dimension(100,100));
	        
	        //setting the color as per the input     	        
	        if(inputValue % 2 == 0){
	            this.setBackground(Color.WHITE);
	        }else{
	            this.setBackground(new Color(173,216,230));
	        }

	        //setting the JLabels
	        firstName = new JLabel("Abhishek");
			lastName = new JLabel("Kumar");

			firstName.setFont(new Font("Papyrus",Font.PLAIN,15));
	        firstName.setAlignmentX(Component.CENTER_ALIGNMENT);
			
	        lastName.setFont(new Font("Papyrus",Font.PLAIN,15));
	        lastName.setAlignmentX(Component.CENTER_ALIGNMENT);
			
	        //adding the labels in the Jpanel
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.add(firstName);
			this.add(lastName);
	
			//calling the countdown Timer 
	        setDisplayNum();
	       
        }
        catch(Exception e) 
        {
        	e.printStackTrace();
        }
    }


    /**
     * Set the counter as per the input
     */
    private void setDisplayNum() {
    	
    try {
    	//setting the counter
    	if(inputValue % 2 == 0){
    		counter = 0;
    	}else{
    		counter = 9;
    	}
    	
        	//creating JLabel to display the counter
        displayNum = new JLabel(String.valueOf(counter));
        displayNum.setFont(new Font("Papyrus",Font.PLAIN,15));

        this.add(displayNum);
        
	        ActionListener taskPerformer = new ActionListener() {
	
	            @Override
	
	            public void actionPerformed(ActionEvent e) {
	
	              //logic for increasing/decreasing counter
	            	if(inputValue % 2 == 0 && counter == 9){
	                	counter = 0;
	                }
	                else if((inputValue % 2 != 0) && counter == 0){
	                	counter = 9;
	                }
	                else if((inputValue % 2 == 0)){
	                	counter++;
	                }
	                else{
	                	counter--;
	                }
	
	                displayNum.setText(String.valueOf(counter));
	
	            }
	
	        };
	
	        new Timer(1000, taskPerformer).start();
        
        }
        
        catch(Exception e)
        {
        	e.printStackTrace();
        	
        }

    }
    /**Main method
     * @param s
     */
    /*public static void main(String [] s)

    {
    	JFrame jFrame = new JFrame();

    	jFrame.setContentPane(new P060_Kumar_Panel(1));

    	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	jFrame.pack();

    	jFrame.setVisible(true);

    }*/

}	
