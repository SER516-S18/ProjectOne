import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class implements a JPanel per the project specification.
 * Every panel requires a JLabel with the author's full name and
 * another JLabel that displays a counter that increments or decrements
 * depending on the parity of the integer value that is passed as an
 * argument to the constructor.
 *
 * @author  Nelson Tran
 * @version 1.0
 * @since   2018-01-23
 */
public class P116_Tran_Panel extends JPanel {

	public P116_Tran_Panel(int value) {
		/*
		 * If the argument to the constructor is even, then the background
		 * color of the panel should be white and the counter should increment
		 * by 1 every second starting at 0.
		 *
		 * Otherwise, the background color should be sky blue and the counter
		 * should decrement by 1 every second starting at 9.
		 */

		if (value % 2 == 0) {
			setBackground(Color.WHITE);
			counterIncrement = INCREASING;
			counter = 0;

		} else {
			setBackground(SKY_BLUE);
			counterIncrement = DECREASING;
			counter = 9;
		}

		setupPanel("Nelson", "Tran");
		startTimer(UPDATE_INTERVAL);
	}

	private void setupPanel(String firstName, String lastName) {
		/*
		 * To be consistent with the other JPanels in the class, the
		 * dimensions of each JPanel should be 100×100 pixels and all
		 * labels should be drawn using the Papyrus font.
		 *
		 */

		nameLabel.setText(
			String.format(
				"<html><center>%s<br>%s</center></html>",
				firstName,
				lastName
			)
		);

		nameLabel.setFont(new Font("Papyrus", Font.PLAIN, 14));
		counterLabel.setFont(new Font("Papyrus", Font.PLAIN, 16));

		this.setLayout(new BorderLayout());
		this.add(nameLabel, BorderLayout.NORTH);
		this.add(counterLabel, BorderLayout.SOUTH);
		this.setSize(DIMENSION, DIMENSION);
		this.setVisible(true);
	}

	private void startTimer(int interval) {
		/*
		 * Every second, the timer updates the counter and the counter labels.
		 * The counter is restricted to [0, 9]. If the counter reaches the
		 * minimum or maximum value, the next value should wrap around.
		 */

		timer = new Timer(interval, event -> {
			counter += counterIncrement;
			counter = Math.floorMod(counter, MAX_COUNTER);
			counterLabel.setText(Integer.toString(counter));
		});

		timer.start();
	}

	// Graphical Components.
	private JLabel nameLabel = new JLabel("", JLabel.CENTER);
	private JLabel counterLabel = new JLabel("", JLabel.CENTER);

	// Timer & Counter.
	private Timer timer;
	private int counter;
	private int counterIncrement;

	// Constants.
	private final Color SKY_BLUE = new Color(173,216,230);
	private final int UPDATE_INTERVAL = 1000;
	private final int DIMENSION = 100;
	private final int MAX_COUNTER = 10;
	private final int INCREASING = 1;
	private final int DECREASING = -1;
}
