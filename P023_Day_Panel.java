import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * P023_Day_Panel.java creates a JPanel with author's name and counter. 
 * Counts up or down and panel changes color, based on input.
 * 
 * @author Melissa Day
 * @version 1.0
 * @since 1/20/18
 * 
 * SER 516 : Project 01
 *
 */
public class P023_Day_Panel extends JPanel implements Runnable {
	private int counterValue, endCount, countChange;
	private boolean evenFlag;
	private Thread thread;
	private String counterAsString;
	private JLabel counterLabel;
	private static final Color LIGHT_BLUE = new Color(173, 216, 230, 255);
	private static final Font FONT_STYLE = new Font("Papyrus", Font.PLAIN, 15);
	private final String AUTHOR_FIRST_NAME = "Melissa";
	private final String AUTHOR_LAST_NAME = "Day";

	/**
	 * Constructor
	 * 
	 * @param num : Determines counter direction and panel color
	 * 
	 */
	public P023_Day_Panel(int num) {
		this.setPanel(num);
	}

	/**
	 * Sets the panel based on input parameter.
	 * 
	 * @param input
	 *            Even number input -> White background, counts 0 to 9 in loop
	 *            Odd number input -> Light blue background, counts 9 to 9 in
	 *            loop
	 */
	private void setPanel(int input) {
		GridLayout layout = new GridLayout(2, 1);
		this.setLayout(layout);
		this.setSize(100, 100);

		JLabel authorNameLabel = new JLabel("<html>" + AUTHOR_FIRST_NAME + "<br>" + AUTHOR_LAST_NAME + "</html>");
		authorNameLabel.setFont(FONT_STYLE);
		authorNameLabel.setForeground(Color.BLACK);
		authorNameLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(authorNameLabel);

		// even number
		if (input % 2 == 0) {
			counterValue = 0;
			endCount = 9;
			countChange = 1;
			evenFlag = true;
			this.setBackground(Color.white);
		}

		// odd number
		else {
			counterValue = 9;
			endCount = 0;
			countChange = -1;
			evenFlag = false;
			this.setBackground(LIGHT_BLUE);
		}

		counterAsString = Integer.toString(counterValue);

		counterLabel = new JLabel(counterAsString);
		counterLabel.setFont(FONT_STYLE);
		counterLabel.setForeground(Color.BLACK);
		counterLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(counterLabel);

		thread = new Thread(this);
		thread.start();
	}

	/**
	 * Counter thread to handle logic for even or odd input
	 */
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Input param is even
			if (evenFlag) {
				counterValue += countChange;
				counterAsString = Integer.toString(counterValue);
				counterLabel.setText(counterAsString);
				if (counterValue >= endCount) {
					counterValue = -1;
				}
			}
			// Input param is odd
			else {
				counterValue += countChange;
				counterAsString = Integer.toString(counterValue);
				counterLabel.setText(counterAsString);
				if (counterValue <= endCount) {
					counterValue = 10;
				}
			}
		}
	}
}
