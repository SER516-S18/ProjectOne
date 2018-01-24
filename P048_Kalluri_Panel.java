/**
 * This program is used for SER 516 - Lab 1 Project.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Timer;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class creates a Panel with 3 rows. First name in the first row,
 * last name in the second row and counter value in the third row. 
 * It has a parameterized constructor which takes in an integer value.
 * Panel is white in color and counter value needs to increase from 
 * 0  to 9 if the value sent from tab class is even. Else, the panel
 * is light blue in color and counter needs to decrease from 9  to 0.
 * 
 * @author Nagarjuna Kalluri
 * @version 1.1
 * @since 1/23/2017
 */
public class P048_Kalluri_Panel extends JPanel{

	// default version ID for suppressing warnings
	private static final long serialVersionUID = 1L;

	/**
	 * Local variables
	 * JLabels for first name, last name and timer/counter
	 * Timer variable and Color constants
	 * boolean flag to increment/decrement (default) counter
	 * 
	 */
	private JLabel firstName;
	private JLabel lastName;
	private JLabel timerLabel;

	Timer timer = new Timer();
	boolean autoIncrement = false;

	Color lightBlue = new Color(189,214,238);
	Color white = Color.white;

	/**
	 * This Constructor takes in the Integer value from Tab class  
	 * & increments/decrements counter based on this integer value
	 * 
	 * @author Nagarjuna Kalluri
	 * @param Integer value (sent from the Tab class)
	 * @throws Arithematic exception if an invalid value is passed
	 * @throws InterruptedException if a thread is interrupted
	 */
	public P048_Kalluri_Panel(int value) {

		/**
		 *  checking for integer parameter passed to constructor
		 *  If value is even 'autoIncrement' flag is set to true
		 */
		try {
			if(value % 2 == 0) {
				autoIncrement = true;
			}
		}
		catch(ArithmeticException e) {
			System.err.println(e.toString());
		}

		/**
		 *  A grid layout is put in for the panel in a 3 X 1 format
		 *  3 segments, 1 each for First name, last name and counter
		 */ 
		this.setLayout(new GridLayout(3, 1));
		this.setBackground(autoIncrement ? white : lightBlue);

		// JLabel and properties for setting first name 
		firstName = new JLabel("Nagarjuna");
		firstName.setHorizontalAlignment(JLabel.CENTER);
		firstName.setFont(new Font("Papyrus",Font.BOLD,16));

		// JLabel and properties for setting last name 
		lastName = new JLabel("Kalluri");
		lastName.setHorizontalAlignment(JLabel.CENTER);
		lastName.setFont(new Font("Papyrus",Font.BOLD,16));

		// Setting first name and last name to the grid
		this.add(firstName);
		this.add(lastName);

		//Thread for running the counter logic
		Thread counterThread = new Thread(new Runnable() {
			@Override
			public void run() {

				// Local variables
				int value = autoIncrement ? 0 : 9;
				int stepVal = autoIncrement ? 1 : -1;

				// JLabel and properties for setting counter/ timer 
				timerLabel = new JLabel(new Integer(value).toString());

				timerLabel.setHorizontalAlignment(JLabel.CENTER);
				timerLabel.setFont(new Font("Papyrus", Font.BOLD, 16));

				// adding timer label to the grid
				P048_Kalluri_Panel.this.add(timerLabel);

				// Checking the boundary conditions for the counter
				while (true) {

					try {
						// If value > 9, value is reset to 0
						if(value > 9) {
							value = 0;
						}
						// If value < 0, value is reset to 9
						else if(value < 0) {
							value = 9;
						}
					}
					catch(ArithmeticException e) {
						System.err.println(e.toString());
					}

					// Adding counter value to the timer JLabel
					timerLabel.setText(new Integer(value).toString());

					try {
						Thread.sleep(1000);	
					} catch (InterruptedException e) {
						System.err.println(e.toString());
						continue;
					}

					// Incrementing the step value
					value += stepVal;
				}
			}         
		});

		// Starting the thread for running the counter logic
		counterThread.start();
	}
}