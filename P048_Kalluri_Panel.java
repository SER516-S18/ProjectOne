// Import libraries
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class name : P048_Kalluri_Panel
 * Author : Nagarjuna Kalluri (048)
 * Purpose : Populate the panel with First name, last name and counter value. 
 * Panel is white in color and counter value needs to increase from 0  to 9 if the value sent from tab class is even.
 * Else, the panel is light blue in color and counter value needs to decrease from 9  to 0. 
 */
public class P048_Kalluri_Panel extends JPanel{

	/**
	 * Local variables
	 */
	private static final long serialVersionUID = 1L;		// default version ID for suppressing warnings

	private JLabel firstName;								// JLabel for populating first name	
	private JLabel lastName;								// JLabel for populating last name	
	private JLabel timerLabel;								// JLabel for populating counter/timer value 	
	Timer timer = new Timer();								// Timer variable

	boolean autoIncrement = false;							// boolean value for incrementing / decrementing counter (default - decrement)

	/**
	 * Constructor
	 * Parameters : Integer value (sent from the Tab class)
	 * Counter increments/ decrements based on this integer value
	 */
	public P048_Kalluri_Panel(int value) {

		// checking for integer parameter passed to constructor from the tab class
		try {
			if(value % 2 == 0) {
				autoIncrement = true;		// increment variable is set to true
			}
		}
		catch(ArithmeticException e) {
			System.err.println(e.toString());
		}

		/**
		 *  Putting a grid layout for the panel in a 3 X 1 format
		 *  3 segments for First name, last name and counter respectively
		 */ 
		this.setLayout(new GridLayout(3, 1));
		this.setBackground(autoIncrement ? Color.white : new Color(90,150,255));	

		// JLabel and properties for setting first name 
		firstName = new JLabel("Nagarjuna");
		firstName.setHorizontalAlignment(JLabel.CENTER);
		firstName.setFont(new Font("Papyrus",Font.BOLD,12));

		// JLabel and properties for setting last name 
		lastName = new JLabel("Kalluri");
		lastName.setHorizontalAlignment(JLabel.CENTER);
		lastName.setFont(new Font("Papyrus",Font.BOLD,12));

		this.add(firstName);		// setting first name to the grid
		this.add(lastName);			// setting last name to the grid

		/**
		 * Thread for running the counter logic
		 */
		Thread counterThread = new Thread(new Runnable() {
			@Override
			public void run() {

				// Local variables
				int value = autoIncrement ? 0 : 9;
				int stepVal = autoIncrement ? 1 : -1;

				// JLabel and properties for setting counter/ timer 
				timerLabel = new JLabel(new Integer(value).toString());

				timerLabel.setHorizontalAlignment(JLabel.CENTER);
				timerLabel.setFont(new Font("Papyrus", Font.BOLD, 12));
				
				// adding timer label to the grid
				P048_Kalluri_Panel.this.add(timerLabel);

				// Checking the boundary conditions for the counter
				while (true) {

					// if value > 9, value is reset to 0
					if(value > 9) {
						value = 0;
					}
					// if value < 0, value is reset to 9
					else if(value < 0) {
						value = 9;
					}

					// adding counter value to the timer JLabel
					timerLabel.setText(new Integer(value).toString());

					try {
						Thread.sleep(1000);	
					} catch (InterruptedException e) {
						System.err.println(e.toString());
						continue;
					}
					
					// incrementing the step value
					value += stepVal;
				}
			}         
		});
		
		// starting the thread for running the counter logic
		counterThread.start();
	}

	/**
	 * Main method - for Testing only
	 */
	
	/*
	public static void main(String[] args) {

		// setting up a grid of 25 panels for testing
		JFrame frame = new JFrame();
		GridLayout grid = new GridLayout(5, 5);
		frame.setLayout(grid);

		// populating each panel with integers from 0 to 24
		for (int i = 0; i < 25; i++) {
			frame.add(new P048_Kalluri_Panel(i));
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
	}
	*/
}
