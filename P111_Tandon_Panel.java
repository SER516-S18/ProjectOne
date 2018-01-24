import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * This class creates a panel with two labels i.e. Name of creator and a Counter
 * value (0 to 9 ;or 9 to 0). Integer value passed to the constructor determines
 * the background color of panel and nature of counter.
 * 
 * @author Manish Tandon (mtandon3@asu.edu)
 * @version 1.1
 * 
 */
public class P111_Tandon_Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	// Constants
	public static final int RED_PART = 173;
	public static final int GREEN_PART = 216;
	public static final int BLUE_PART = 230;
	public static final String NAME_TAG = "<html>Manish<br>Tandon</html>";
	public static final int PANEL_HEIGHT = 100;
	public static final int PANEL_WIDTH = 100;
	public static final int TIMER_DELAY = 1000;
	public static final int FONT_SIZE = 15;
	public static final String FONT_STYLE = "papyrus";

	/**
	 * Class variable for name label
	 */
	private JLabel nameLabel;
	/**
	 * Class variable for counter label
	 */
	private JLabel counterLabel;
	/**
	 * Counter value to access and change , counter at any given time.
	 */
	private int counterVal;
	/**
	 * Determines nature of counter and background color of Panel If true ,
	 * background is white and counter increases from 0 to 9. If false, background
	 * is light blue and counter decreases from 9 to 0. Defaults to true.
	 */
	private boolean configParam = true;

	/**
	 * Class constructor. Toggles configParam, if even configParam is true and for
	 * odd configParam if false. See configParam properties for more details. Calls
	 * methods that create the panel.
	 * 
	 * @param val
	 *            Parameter used for toggling configParam
	 */
	public P111_Tandon_Panel(int val) {

		try {
			this.configParam = checkEven(val);
		} catch (NumberFormatException e) {
			System.out.println("Check input value to constructor,Error message(Panel 111): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Please see error message(Panel 111): " + e.getMessage());
		}

		setPanelProperties();
		setNameLabelProperties();
		setCounterProperties();

	}

	/**
	 * Initializes counter label as per configParams and adds it to the
	 * Panel.Generates timer with interval of 1 second to increment or decrement the
	 * counter value.
	 */
	private void setCounterProperties() {
		try {
			if (this.configParam) {
				this.counterVal = 0;
			} else {
				this.counterVal = 9;
			}
			counterLabel = new JLabel(String.valueOf(this.counterVal));
			counterLabel.setHorizontalAlignment(JLabel.CENTER);
			counterLabel.setVerticalAlignment(JLabel.CENTER);
			counterLabel.setFont(new Font(FONT_STYLE, Font.PLAIN, FONT_SIZE));
			counterLabel.setForeground(Color.BLACK);
			this.add(counterLabel);

			new Timer(TIMER_DELAY, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// gets the current counter label value after converting string to integer.
					int currentVal = Integer.parseInt(counterLabel.getText());

					// If even value is passed into constructor counter value will be increased,
					// otherwise it will be decreased.
					if (configParam) {
						if (currentVal == 9) {
							counterVal = 0;
						} else {
							counterVal++;
						}
					} else {
						if (currentVal == 0) {
							counterVal = 9;
						} else {
							counterVal--;
						}
					}
					counterLabel.setText(String.valueOf(counterVal));
				}
			}).start();
		} catch (Exception e) {
			System.out.println("Please see error message(Panel 111): " + e.getMessage());
		}

	}

	/**
	 * Initializes name label and adds it to the Panel.
	 */
	private void setNameLabelProperties() {
		nameLabel = new JLabel(NAME_TAG);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setFont(new Font("Papyrus", Font.PLAIN, FONT_SIZE));
		nameLabel.setForeground(Color.BLACK);
		this.add(nameLabel);

	}

	/**
	 * Sets the background color and Panel size.
	 */
	private void setPanelProperties() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setLayout(new GridLayout(2, 0));
		if (this.configParam) {
			this.setBackground(Color.WHITE);
		} else {
			Color lightBlueColor = new Color(RED_PART, GREEN_PART, BLUE_PART);
			this.setBackground(lightBlueColor);
		}
	}

	/**
	 * @param val
	 * @return true if value is even, otherwise false.
	 */
	private boolean checkEven(int val) {
		return val % 2 == 0;
	}

}
