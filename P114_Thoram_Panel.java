import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * SER516 lab1
 * Program implements a panel showing name and counter 
 */
public class P114_Thoram_Panel extends JPanel {

	public static final int RED = 173;
	public static final int GREEN = 216;
	public static final int BLUE = 230;
	public static final String NAME_PANEL = "<html><font color='black'>NagaThoram</font></html>";
	public JLabel name;
	public JLabel counter;
	private static final long serialVersionUID = 1L;
	public static int count;
	boolean configuration;

	/*
	 * @param input integer value Constructor accepts the input Based on the type of
	 * integer like odd or even background color and counter initialization is made.
	 */
	public P114_Thoram_Panel(int input) {
		if (input % 2 == 0) {
			configuration = true;
			count = 0;
		} else {
			configuration = false;
			count = 9;
		}
		setBackGroundCounter();
	}

	/*
	 * set background for panel. adds name and counter labels to panel with
	 * respective values. Implements counter with help of Timer
	 */
	public void setBackGroundCounter() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		this.setPreferredSize(new Dimension(100, 100));
		if (configuration)
			this.setBackground(Color.WHITE);
		else {
			Color lightBlue = new Color(RED, GREEN, BLUE);
			this.setBackground(lightBlue);
		}
		name = new JLabel(NAME_PANEL);
		name.setFont(new Font("Papyrus", Font.PLAIN, 15));
		// constraints for name label alignment
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 1;
		constraint.gridy = 0;
		this.add(name, constraint);
		counter = new JLabel(String.valueOf(count));
		counter.setFont(new Font("Papyrus", Font.PLAIN, 15));
		// constraints for counter label alignment
		constraint.fill = GridBagConstraints.CENTER;
		constraint.gridx = 1;
		constraint.gridy = 1;
		this.add(counter, constraint);
		// try-catch block to handle timer exception
		try {
			new Timer(1000, new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					int counterValue = Integer.parseInt(counter.getText());
					if (configuration) {
						if (counterValue == 9) {
							counterValue = 0;
						} else {
							counterValue++;
						}
					} else {
						if (counterValue == 0) {
							counterValue = 9;
						} else {
							counterValue--;
						}
					}
					counter.setText(String.valueOf(counterValue));
				}

			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}