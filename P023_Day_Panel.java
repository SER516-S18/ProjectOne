//package Project01;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * P023_Day_Panel.java - creates a JPanel with name and counter
 * 
 * @author Melissa Day
 * @version 1/20/18
 *
 */
public class P023_Day_Panel extends JPanel implements Runnable {
	private int count, endCount, countChange;
	private boolean even;
	private Thread thread;
	private String counterAsString;
	private JLabel counterLabel;

	/**
	 * Constructor - Creates JPanel, changes background color and counter value
	 * based on param
	 * 
	 * @param num
	 *            Takes integer to determine even or odd number Even: White
	 *            background, counts from 0 to 9 in loop Odd: Light blue
	 *            background, counts from 9 to 0 in loop
	 */
	public P023_Day_Panel(int num) {
		this.setPanel(num);
	}
	
	private void setPanel(int input) {
		GridLayout layout = new GridLayout(2, 1);
		this.setLayout(layout);
		this.setSize(100, 100);

		JLabel name = new JLabel("<html>Melissa <br>Day</html>");
		name.setFont(new Font("Papyrus", Font.BOLD, 14));
		name.setHorizontalAlignment(JLabel.CENTER);
		this.add(name);

		// even number
		if (input % 2 == 0) {
			// counter starts at 0
			count = 0;
			// counter stops at 9
			endCount = 9;
			// set to increase counter value
			countChange = 1;
			even = true;

			this.setBackground(Color.white);
		}

		// odd number
		else {
			// counter starts at 9
			count = 9;
			// counter stops at 0
			endCount = 0;
			// set to increase counter value
			countChange = -1;
			even = false;

			Color lightBlue = new Color(243, 255, 255, 255);
			this.setBackground(lightBlue);
		}

		counterAsString = Integer.toString(count);

		counterLabel = new JLabel(counterAsString);
		counterLabel.setFont(new Font("Papyrus", Font.BOLD, 14));

		counterLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(counterLabel);

		thread = new Thread(this);
		thread.start();
	}

	/**
	 * Counter thread logic to handle logic for even or odd input
	 */
	public void run() {
		try {
			while (true) {
				try {
					Thread.sleep(1000);
					// Input param is even
					if (even) {
						count += countChange;
						counterAsString = Integer.toString(count);
						counterLabel.setText(counterAsString);
						if (count >= endCount) {
							// reset to -1 to account for value change in next
							// iteration
							count = -1;
						}
					}
					// Input param is odd
					else {
						count += countChange;
						counterAsString = Integer.toString(count);
						counterLabel.setText(counterAsString);
						if (count <= endCount) {
							// reset to 10 to account for value change in next
							// iteration
							count = 10;
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * For Testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		GridLayout grid = new GridLayout(5, 5);
		frame.setLayout(grid);

		for (int i = 0; i < 10; i++) {
			frame.add(new P023_Day_Panel(8));
		}

		for (int i = 0; i < 15; i++) {
			frame.add(new P023_Day_Panel(9));
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
	}

}
