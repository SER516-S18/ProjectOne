
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This class creates a panel with a name and an infinite counter. Counter can
 * either increase or decrease depending on the integer value passed to the
 * constructor.
 * 
 * @author Rhythm Sharma
 * @since January 21, 2018
 * @version 1.0
 *
 */

public class P103_Sharma_Panel extends JPanel {

	static int counter;
	static boolean timerIncrements;
	JLabel nameLabel;
	JLabel timerLabel;
	final Color LIGHTBLUE = new Color(173, 216, 230);
	final int CENTER_ALIGNMENT = SwingConstants.CENTER;
	final int BOTTOM_ALIGNMENT = SwingConstants.BOTTOM;
	final int TOP_ALIGNMENT = SwingConstants.TOP;
	final int FONT_STYLE = Font.PLAIN;

	/*
	 *  Constructor sets the dimension for panel. It initializes nameLabel 
	 *  and timerLabel. Constructor accepts an integer and set the counter
	 *  value, panel background for even - odd integers separately.
	 */
	P103_Sharma_Panel(int timeColorValue) {

		setPreferredSize(new Dimension(100, 100));
		setLayout(new GridLayout(2, 1, 0, 0));
		nameLabel = new JLabel("<html>Rhythm<br>Sharma</html>", CENTER_ALIGNMENT);
		nameLabel.setFont(new Font("Papyrus", FONT_STYLE, 15));
		timerLabel = new JLabel(String.valueOf(counter), CENTER_ALIGNMENT);
		timerLabel.setFont(new Font("Papyrus", FONT_STYLE, 15));
		
		// Aligning the texts in the panel 
		nameLabel.setVerticalAlignment(BOTTOM_ALIGNMENT);
		timerLabel.setVerticalAlignment(TOP_ALIGNMENT);
		timerLabel.setHorizontalAlignment(CENTER_ALIGNMENT);

		if (timeColorValue % 2 == 0) {
			setBackground(Color.WHITE);
			timerIncrements = true;
			counter = 0;
		} else {
			timerIncrements = false;
			counter = 9;
			setBackground(LIGHTBLUE);
		}
		add(nameLabel);
		add(timerLabel);

		// Set the timer
		scheduleTimer(timerLabel);
					
	}
	
	/*
	 * Set the timer counter and display using timerLabel.
	 * Timer will start as soon as panel is called.
	 * Interval of the timer is 1 second.
	 */
	
	public static void scheduleTimer(JLabel timerLabel) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				timerLabel.setText("" + counter);
				if (timerIncrements == true) {
					counter++;
					if (counter > 9) {
						counter = 0;
					}
				} else {
					counter--;
					if (counter < 0) {
						counter = 9;
					}
				}
			}
		};
		try {
			timer.scheduleAtFixedRate(task, 0, 1000);
		}
		catch (Exception e) {
				e.printStackTrace();
		}
	}
}