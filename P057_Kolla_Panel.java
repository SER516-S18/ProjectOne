import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Tarun kolla P05_Kolla_panel is a extension of JPanel Used to create a
 *         panel with "name" and "Counter"
 * 
 */
public class P057_Kolla_Panel extends JPanel {

	int count;
	JLabel counter = new JLabel();

	/**
	 * @param "input"
	 *            to take integer value to the constructor
	 */
	public P057_Kolla_Panel(final int input)
	/**
	 * boxLayout to align "name" and "counter" Changes background color to white for
	 * even and lightBlue for odd "input"
	 */
	{
		JLabel name = null;

		this.setSize(100, 100);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		if (input % 2 == 0) {
			count = 0;
			this.setBackground(Color.WHITE);
		} else {
			count = 9;
			int green = 216;
			int blue = 230;
			int red = 173;
			Color lightBlue = new Color(red, green, blue);
			this.setBackground(lightBlue);
		}
		/**
		 * Papyrus font style, plain with font size of 15
		 */
		name = new JLabel("<html><br>Tarun<br>Kolla</html>", JLabel.CENTER);
		name.setAlignmentX(Component.CENTER_ALIGNMENT);
		Font font = new Font("Papyrus", Font.PLAIN, 15);
		name.setFont(font);
		counter.setFont(font);

		Timer time = new Timer(1000, new ActionListener() {

			/**
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				/**
				 * Increment and decrement counter based on "input" type Increments for even
				 * input Decrements for odd input
				 */
				if (input % 2 == 0) {
					counter.setText(String.valueOf(count));
					counter.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					count++;
					if (count > 9) {
						count = 0;
					}

				} else {
					counter.setText(String.valueOf(count));
					counter.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					count--;
					if (count < 0) {
						count = 9;
					}

				}
			}
		});
		time.start();
		this.add(name);
		this.add(counter);

	}

}