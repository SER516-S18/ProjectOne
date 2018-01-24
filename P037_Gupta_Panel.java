import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @author Shubhangi Gupta
 * @description Panel class
 * @version 1.0
 * 
 *          Class extends JPanel containing name of the author and the counter
 *          with parameterized constructor that accepts integer as a value. When
 *          value is even ---> background : white, Counter increments from 0 to
 *          9 When value is odd ---> background : Light Blue (173, 216, 230),
 *          Counter decrements from 9 to 0
 *
 */

public class P037_Gupta_Panel extends JPanel {

	// JPanel instance
	public JPanel p;
	// counter label to increase or decrease depending upon value given to
	// constructor
	JLabel counter = new JLabel();
	public static Color LIGHT_BLUE = new Color(173, 216, 230); // color of background
	public static Font FONT = new Font("Papyrus", Font.PLAIN, 15); // style of label
	private int j;
	private boolean even;
	private int num;

	/**
	 * Constructor to create object of class.
	 * 
	 * @param num
	 *            value given can be even or odd, if even counter increases from 0
	 *            to 9 else counter decreases from 9 to 0.
	 */
	public P037_Gupta_Panel(int num) {
		this.num = num;
		getJPanelInstance();
		if (num % 2 == 0) {
			j = 0;
			even = true;
		} else
			j = 9;

	}

	/**
	 * method to create JPanel Instance to be attached to tab.
	 * 
	 * @param num
	 *            which can be even or odd, if even counter increases from 0 to 9
	 *            else counter decreases from 9 to 0.
	 * @return JPanel instance.
	 */
	public JPanel getJPanelInstance() {

		try {

			// creates JPanel.
			p = new JPanel();
			// sets layout
			p.setLayout((LayoutManager) new BoxLayout(p, BoxLayout.Y_AXIS));
			// set size
			p.setSize(100, 100);

			// creates JLabel for first name, then sets size and font and alligns to center
			// and add it to panel.
			JLabel firstName = new JLabel("Shubhangi");
			firstName.setSize(25, 25);
			firstName.setFont(FONT);
			firstName.setAlignmentX(Component.CENTER_ALIGNMENT);
			p.add(firstName);

			// creates JLabel for last name, then sets size and font and alligns to center
			// and add it to panel.
			JLabel lastName = new JLabel("Gupta");
			lastName.setSize(25, 25);
			lastName.setFont(FONT);
			lastName.setAlignmentX(Component.CENTER_ALIGNMENT);
			p.add(lastName);

			// JLabel for counter, then sets size and font and alligns to center and add it
			// to panel.
			counter.setSize(25, 25);
			counter.setFont(FONT);
			counter.setAlignmentX(Component.CENTER_ALIGNMENT);
			p.add(counter);

			// if num is even, sets panel background to white otherwise set panel color to
			// light blue.
			if (this.num % 2 == 0)
				p.setBackground(Color.WHITE);
			else
				p.setBackground(LIGHT_BLUE);

			// timer implementation for increment or decrement of counter label
			Timer timer = new Timer(1000, new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					counter.setText(Integer.toString(j));
					if (even) {
						j++;
						if (j >= 10)
							j = 0;
					} else {
						j--;
						if (j < 0)
							j = 9;
					}

				}

			});
			// timer start
			timer.start();
		} catch (Exception e) {
			System.out.println("Error occurred" + e.getStackTrace());

		}
		return p;

	}

}