// Import necessary libraries
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;

import java.awt.event.*;

import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;

/**
 * creates a JPanel with name and counter
 * 
 * This class implements the following contents:
 * A Label for First Name (JLabel NameLabel)
 * A Label for Last Name  (JLabel LastNameLabel)
 * A Label to display the counter (JLabel timer)
 * A Panel that contains the labels and the counter (JPanel panel)
 * 
 * @author Mitali Kulkarni
 *
 */

public class P059_Kulkarni_Panel extends Panel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Constants
	private int counter = 0;
	private boolean even = true;
	public static final int FONT_SIZE = 15;
	
	// Constructor 
	public P059_Kulkarni_Panel(int color_value) {
		
		/**
		 * Determines counter and background color of Panel
		 * If even = true , background is white and counter increases from 0 to 9. 
		 * If even = false, background is light blue and counter decreases from 9 to 0. 
		 * Even is true by default.
		 */
		if (color_value % 2 == 0) {
			even = true;
			counter = 0;
		} else {
			even = false;
			counter = 9;
		}
		
		try {
			// Add First Name JLabel with font = Papyrus Color = BLACK
			JLabel NameLabel = new JLabel("<html>Mitali<br/>Kulkarni</html>", JLabel.CENTER);
			NameLabel.setHorizontalAlignment(JLabel.CENTER);
			NameLabel.setVerticalAlignment(JLabel.CENTER);
			NameLabel.setFont(new Font("Papyrus", Font.PLAIN, FONT_SIZE));
			NameLabel.setForeground(Color.BLACK);
			
			// Add Timer JLabel with font = Papyrus Color = BLACK
			JLabel timer = new JLabel("", JLabel.CENTER);
			timer.setHorizontalAlignment(JLabel.CENTER);
			timer.setVerticalAlignment(JLabel.CENTER);
			timer.setFont(new Font("Papyrus", Font.PLAIN, FONT_SIZE));
			timer.setForeground(Color.BLACK);
			
			// Timer object
			Timer t = new Timer();		
				t.schedule(new TimerTask() {
					@Override
					public void run() {
						System.out.print(even);
						if (even) {
							setBackground(Color.WHITE); // If color_value is even set background color to white
							timer.setText("0");
							if (counter == 10)
								counter = 0;
							timer.setText(""+ counter++);
						} else {
							Color lightBlue = new Color(173,216,230); // If color_value is odd set background color to light blue
							setBackground(lightBlue);
							timer.setText("9");
							if (counter == -1)
								counter = 9;
							timer.setText(""+ counter--);
						}
					}
				}, 0, 1000);
				
			// Set up my panel
			setLayout(new GridLayout(2, 0));
			add(NameLabel);
			add(timer);
			
		} catch(Exception e) { // Any exceptions encountered are handled in this part
			
	    		System.out.println("Error in Timer Display");
			e.printStackTrace();
	    	}
	}
	
	/*
		// For testing purpose
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			P059_Kulkarni_Panel panel = new P059_Kulkarni_Panel(2);
			
			JFrame mainFrame = new JFrame("Frame");
			mainFrame.setSize(100, 100);
			mainFrame.setLayout(new GridLayout(1, 1));
			mainFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent windowEvent) {
					System.exit(0);
				}
			});
			mainFrame.add(panel);
			mainFrame.setVisible(true);
		}
	*/
}
