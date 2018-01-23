
import java.awt.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

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

	int counter;
	Timer timer = new Timer();
	boolean flag;

	P103_Sharma_Panel(int num) {

		// Set the layout and size for panel
		setPreferredSize(new Dimension(100, 100));
		setLayout(new GridLayout(2, 1, 0, 0));
		// Label for displaying the name
		JLabel nameLabel = new JLabel("<html>Rhythm<br>Sharma</html>", SwingConstants.CENTER);
		nameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
		// Label for displaying the counter
		JLabel timerLabel = new JLabel(String.valueOf(counter), SwingConstants.CENTER);
		timerLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
		// Set the text in center of the panel and counter after the name
		nameLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		timerLabel.setVerticalAlignment(SwingConstants.TOP);
		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// Set the background and counter value
		if (num % 2 == 0) {
			setBackground(Color.WHITE);
			flag = true;
			counter = 0;
		} else {
			flag = false;
			counter = 9;
			setBackground(new Color(173, 216, 230)); // RGB for Light-blue color = 173,216,230
		}

		// Set the timer to run in an infinite loop
		try {
			TimerTask task = new TimerTask() {

				@Override
				public void run() {

					// Counter value set to the label
					timerLabel.setText("" + counter);

					if (flag == true) {
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
			// Counter will start immediately once the panel is
			// called; Interval of the timer is 1 second.
			timer.scheduleAtFixedRate(task, 0, 1000);
		} catch (Exception e) {
			e.printStackTrace(); // Print the runtime errors
		}

		// Add the labels to the panel
		add(nameLabel);
		add(timerLabel);

	}
	
	/*
	 * Main Method to execute the panel with frame
	 */

	/*
	 * public static void main(String[] args) {
	 * 
	 * JFrame jFrame = new JFrame(); JPanel jPanel = new JPanel(); jPanel.add(new
	 * P103_Sharma_Panel(101)); jFrame.add(jPanel); jFrame.setSize(1000, 500);
	 * jFrame.setVisible(true);
	 * jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); }
	 */

}
