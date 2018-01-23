import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



public class P066_Maheshwari_Panel extends JPanel {

    private int inputValue;
	
	//clock related variables

    private JLabel clock;

    private int counter;

    public final int DELAY = 1000;
    
    
    //panel related variables
    
    private JLabel firstName;
	
	private JLabel lastName;
    
    public final int panelWidth = 100;

    public final int panelHeight = 100;

    

    // Constructor of the class for initialization

    public P066_Maheshwari_Panel(int inputValue){

        try {
    	
	    	this.inputValue = inputValue;
	
	        setPanelSizeAndColor();
	
	        addLabel();
	
	        setCounterAndClockTimer();
	        
        }
        
        catch(Exception e) 
        {
        	e.printStackTrace();
        }
    }

    // Sets counter value and starts the clock timer. If input value is even, the value increments. If odd, it decrements.

    private void setCounterAndClockTimer() {
    	
    	//setting counter value based on input value
    	
    	if(inputValue % 2 == 0){

            counter = 0;

        }

        else{

            counter = 9;

        }
    	
    	
    	//Initializing clock
    	
        clock = new JLabel(String.valueOf(counter));

        clock.setFont(new Font("Papyrus",Font.PLAIN,15));

        this.add(clock);


        // Starts the timer and handles the increment/decrement of the counter value
        
        try {

	        ActionListener taskPerformer = new ActionListener() {
	
	            @Override
	
	            public void actionPerformed(ActionEvent e) {
	
	                if(inputValue % 2 == 0 && counter == 9){
	
	                    counter = 0;
	
	                }
	
	                else if(!(inputValue % 2 == 0) && counter == 0){
	
	                    counter = 9;
	
	                }
	
	                else if((inputValue % 2 == 0) == true){
	
	                    counter = counter + 1;
	
	                }
	
	                else{
	
	                    counter = counter -1;
	
	                }
	
	                clock.setText(String.valueOf(counter));
	
	            }
	
	        };
	
	        new Timer(DELAY, taskPerformer).start();
        
        }
        
        catch(Exception e)
        {
        	e.printStackTrace();
        	
        }

    }


    // Initialize and Add Name Label to panel

    private void addLabel() {
    	
    	try {

	        firstName = new JLabel("Aman");
	
	        firstName.setFont(new Font("Papyrus",Font.PLAIN,15));
	
	        firstName.setAlignmentX(Component.CENTER_ALIGNMENT);
			
		this.add(firstName);
			
		lastName = new JLabel("Maheshwari");
	
	        lastName.setFont(new Font("Papyrus",Font.PLAIN,15));
	
	        lastName.setAlignmentX(Component.CENTER_ALIGNMENT);
			
		this.add(lastName);
	        
    	}
    	
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    }



    // Set the preferred panel size

    private void setPanelSizeAndColor() {
    	
    	//Set the preferred panel size
    	
        this.setPreferredSize(new Dimension(panelWidth,panelHeight));
        
        
        //set the background color based on the input value. If odd, then sets light blue else, sets White.
        
        if(inputValue % 2 == 0){

            this.setBackground(Color.WHITE);

        }

        else{

            this.setBackground(new Color(173,216,230));

        }

    }

    
    //main function for testing purpose. Hence commented.
    /*public static void main(String [] s)

    {
    	JFrame jFrame = new JFrame();

    	jFrame.setContentPane(new P066_Maheshwari_Panel(5));

    	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	jFrame.pack();

    	jFrame.setVisible(true);


    }*/

}
