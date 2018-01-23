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
 * P059_Kulkarni_Panel, creates a JPanel with name and counter
 * 
 * This class implements the following contents:
 * A Label for First Name (JLabel NameLabel)
 * A Label for Last Name  (JLabel LastNameLabel)
 * A Label to display the counter (JLabel timer)
 * A Panel that contains the labels and the counter (JPanel panel)
 * 
 * @author Mitali Kulkarni
 * @version 1.0
 */

public class P059_Kulkarni_Panel extends Panel {
	private static final long serialVersionUID = 1L;
	
	// Public Constants
	public static Color LIGHT_BLUE = new Color(173,216,230);
	public static Font FONT = new Font("Papyrus", Font.PLAIN, 15);
	
	private int counter = 0;
	private static final String NAME = "<html>Mitali<br/>Kulkarni</html>";
	
	/**
	 * @param value determines counter and background color of Panel
	 * If even , background is white and counter increases from 0 to 9. 
	 * If odd , background is light blue and counter decreases from 9 to 0. 
	 */
	public P059_Kulkarni_Panel(int color_value) {
		if (color_value % 2 == 0) {
			counter = 0;
		} else {
			counter = 9;
		}
		
		try {
			// Add First Name JLabel with font = Papyrus Color = BLACK
			JLabel NameLabel = new JLabel(NAME, JLabel.CENTER);
			NameLabel.setHorizontalAlignment(JLabel.CENTER);
			NameLabel.setVerticalAlignment(JLabel.CENTER);
			NameLabel.setFont(FONT);
			NameLabel.setForeground(Color.BLACK);
			
			// Add Timer JLabel with font = Papyrus Color = BLACK
			JLabel timer = new JLabel("", JLabel.CENTER);
			timer.setHorizontalAlignment(JLabel.CENTER);
			timer.setVerticalAlignment(JLabel.CENTER);
			timer.setFont(FONT);
			timer.setForeground(Color.BLACK);
			
			// Timer object
			Timer t = new Timer();		
				t.schedule(new TimerTask() {
					@Override
					public void run() {
						if (color_value % 2 == 0) {
							setBackground(Color.WHITE); // If color_value is even set background color to white
							timer.setText("0");
							if (counter == 10)
								counter = 0;
							timer.setText(""+ counter++);
						} else {
							setBackground(LIGHT_BLUE);
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
		} catch(Exception e) {
	    		System.out.println("Error in Timer Display");
			e.printStackTrace();
        }
	}
}
