import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 * P040_Henderson_Panel, a panel for ProjectOne, featuring a countdown timer and the author's name
 *
 * @author  David Henderson
 * @version 1.0
 * @since   2018-01-18
 */
public class P040_Henderson_Panel extends JPanel {
	protected JLabel labelName = new JLabel("<html><center>David<br>Henderson</center></html>");
	protected JCountdownLabel labelCounter;

	/**
	 * Constructor to create the panel.
	 * @param value An integer to determine if the timer counts down (odd value) or up (even value)
	 */
	public P040_Henderson_Panel(int value) {
		this.setLayout(new BorderLayout()); // Set the panel layout
		
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		labelName.setAlignmentX(0.5f);
		this.add(labelName, BorderLayout.PAGE_START); // Add the name label to the panel, at the top

		if(value % 2 == 0) {
			// Per spec, if value is even set the panel background to white and count up
			this.setBackground(Color.WHITE);
			labelCounter = new JCountdownLabel(true);
		} else {
			// Otherwise per spec, if value is odd set the panel background to light blue and count down
			this.setBackground(new Color(189,214,238));
			labelCounter = new JCountdownLabel(false);
		}

		labelCounter.setHorizontalAlignment(SwingConstants.CENTER);
		labelCounter.setAlignmentX(0.5f);
		this.add(labelCounter, BorderLayout.CENTER); // Add the countdown label
	}

	/**
	 * JCountdownLabel, a JLabel timer that can either count up or down, with values 0 - 9.
	 */
	private static class JCountdownLabel extends JLabel {
		private final boolean ascending;
		private int value = 0;

		/**
		 * Constructor tp create the label.
		 * @param ascend Specifies whether the counter increments or decrements through values 0 - 9.
		 */
		public JCountdownLabel(boolean ascend) {
			this.ascending = ascend;
			this.setText(String.valueOf(value));

			// Task executed every 1000ms
			ActionListener task = e -> {
				JCountdownLabel.this.value = (JCountdownLabel.this.value + 1) % 10; // Keep counting
				if(ascending)
					this.setText( String.valueOf(JCountdownLabel.this.value) ); // If counting up, display raw value
				else
					this.setText( String.valueOf(9 - JCountdownLabel.this.value) ); // If counting down, display 9 minus raw value
			};

			// Timer to increment the value and update the label
			try {
				Timer timer = new Timer(1000, task);
				timer.setRepeats(true);
				timer.start();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// For testing, left in per specification
	// public static void main(String[] args) {
	//     JFrame frame = new JFrame("SER516 ProjectOne - David Henderson");
	//     frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	//     frame.setLayout(new BorderLayout());
	//     frame.add(new P040_Henderson_Panel(0), BorderLayout.PAGE_START);
	//     frame.add(new P040_Henderson_Panel(1), BorderLayout.PAGE_END);
	//     frame.pack();
	//     frame.setVisible(true);
	// }
}
