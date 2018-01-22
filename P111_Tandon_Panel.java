import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
 * @author Manish Tandon
 * @version 1.0
 * @see
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
	 * Toggles configParam, if even configParam is true and for odd configParam if
	 * false. See configParam properties for more details
	 * 
	 * @param val
	 */
	public P111_Tandon_Panel(int val) {

		try {
			this.configParam = checkEven(val);
		} catch (NumberFormatException e) {
			System.out.println("Check input value to constructor,Error message: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Somethng went wrong.Error message: " + e.getMessage());
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
			counterLabel.setFont(new Font("Papyrus", Font.PLAIN, 18));
			this.add(counterLabel);

			new Timer(TIMER_DELAY, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// gets the current counter label value
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
			System.out.println("Something went wrong: Message: " + e.getMessage());
		}

	}

	/**
	 * Initializes name label and adds it to the Panel.
	 */
	private void setNameLabelProperties() {
		nameLabel = new JLabel(NAME_TAG);
		nameLabel.setFont(new Font("Papyrus", Font.PLAIN, 18));
		this.add(nameLabel);

	}

	/**
	 * Sets the background color and Panel size.
	 */
	private void setPanelProperties() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
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

	/**
	 * To conform with the technical specifications provided by scrum master on the
	 * black board thread.
	 * 
	 * @return JPanel
	 */
	public P111_Tandon_Panel getPanelInstance() {
		return this;
	}


}
