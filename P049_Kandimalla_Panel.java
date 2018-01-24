import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/* This class creates a panel that has two labels in it. description about labels is
 *  given in detail near method implementation. This class contains a parameterized constructor
 * and a method createPanel.  
 *
 * @author: Sai Saran Kandimalla
 * @version 1.1. 
 * @created on 01/20/2018. Last updated on 01/23/2018.
 */
public class P049_Kandimalla_Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel = new JPanel(new GridLayout(2, 1));;
	private Timer counterTimer;
	/*
	 * A parameterized constructor that takes an integer value when the object is
	 * instantiated. The constructor then passes the integer value to 'createPanel'
	 * method.
	 */
	public P049_Kandimalla_Panel(int code) {
		super();
        mainPanel = createPanel(code);
	}

	/*
	 * This method creates edits the mainPanel so that has two labels in it. One label displays my
	 * FirstName and LastName in different rows. The other panel keeps counting from
	 * 0 to 9 if an object passes an even value to constructor or vice versa if the integer is odd.
	 *  The function also sets background color depending upon code value
	 * 
	 */
	public JPanel createPanel(int code) {

		
		JLabel nameLabel = new JLabel("<html><p>Sai Saran<br>Kandimalla</p></html>", JLabel.CENTER);
		nameLabel.setFont(new Font("papyrus", Font.BOLD, 16));
		
		JLabel counterLabel = new JLabel();
		counterLabel.setFont(new Font("papyrus", Font.BOLD, 16));
		
		Box box;
		box = Box.createVerticalBox();
		box.add(nameLabel);
		box.add(counterLabel);
		
		mainPanel.add(box);

		if (code % 2 == 0) {
			incrementTimer(counterLabel);
			mainPanel.setBackground(Color.WHITE);
		} 
		else if (code % 2 == 1 || code % 2 == -1) {
			decrementTimer(counterLabel);
			Color lightBlue = new Color(173, 216, 230);
			mainPanel.setBackground(lightBlue);
		}
		add(mainPanel);
		return mainPanel;
	}

	//This method loops the counter in counter label in ascending order i.e., from 0 to 9 
	public void incrementTimer(JLabel counterLabel) {
		counterTimer = new Timer(1000, new ActionListener() {
			private int count = 0;

			public void actionPerformed(ActionEvent event) {
				counterLabel.setText("             " + count++ + "             ");
				if (count == 10) {
					counterTimer.stop();
					count = 0;
					counterTimer.restart();
				}
			}
		});
		counterTimer.start();
	}
    
	//This method loops the counter in counter label in descending order i.e., from 9 to 0
	public void decrementTimer(JLabel counterLabel) {
		counterTimer = new Timer(1000, new ActionListener() {
			private int count = 9;

			public void actionPerformed(ActionEvent event) {
				counterLabel.setText("             " + count-- + "             ");
				if (count == -1) {
					counterTimer.stop();
					count = 9;
					counterTimer.restart();
				}
			}
		});
		counterTimer.start();
	}
}
