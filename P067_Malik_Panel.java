import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * P067_Malik_Panel class creates a JPanel with two JLabels. There are two
 * columns, the first has two rows displaying the name (first row displays the
 * first name and the second row displays the last name) and the second column
 * displays a counter. The value of the counter and the background of the panel
 * depends upon an integer value received by the constructor. If the value is
 * even the background is White and the counter increases whereas if the value
 * is odd the background is LightBlue and the counter decreases.
 * 
 * @author Salil Malik
 * @version 1.0
 */
public class P067_Malik_Panel extends JPanel {

	private static final long serialVersionUID = -3797878688960536495L;
	private int configValue;
	private JLabel name;
	private JLabel number;
	private Timer timer;
	public final static Color LIGHT_BLUE = new Color(173, 216, 230);

	/**
	 * The parameterized constructor which sets up the panel
	 * 
	 * @param configValue
	 *            The value received by the constructor which decides the background
	 *            color and the counter value.
	 */
	public P067_Malik_Panel(int configValue) {
		this.configValue = configValue;
		initializePanel();
	}

	/**
	 * This function creates two JLabels and sets up the JPanel's attributes.
	 */
	private void initializePanel() {
		try {
			name = new JLabel("<html>Salil<br/>Malik</center></html>");
			name.setFont(new Font("Papyrus", Font.PLAIN, 15));
			add(name);
			number = new JLabel(String.valueOf(configValue % 2 == 0 ? 0 : 9));
			number.setFont(new Font("Papyrus", Font.PLAIN, 15));
			add(number);
			startTimer();
			setSize(100, 100);
			setBackground(configValue % 2 == 0 ? Color.WHITE : LIGHT_BLUE);
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The counter's value ranges from (0-9) and increases or decreases depending
	 * upon the configValue received by the constructor.
	 */
	private void startTimer() {
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				int value = Integer.parseInt(number.getText());
				if (configValue % 2 == 0) {
					value++;
					if (value > 9) {
						value = 0;
					}
				} else {
					value--;
					if (value < 0) {
						value = 9;
					}
				}
				number.setText(Integer.toString(value));
			}
		});
		timer.start();
	}

	/**
	 * Used for testing. A frame is created and the panel is added to it.
	 * 
	 * @param args
	 */

	/*public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new P067_Malik_Panel(1));
		frame.setSize(100, 100);
		frame.setVisible(true);
	}*/

}
