// Import necessary libraries
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

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
 * Based on the value the Background Color and the Counter change.
 * 
 * If value is odd then background color is light blue and counter decrements from 9 - 0
 * If value is even then background color is white and counter increments from 0 - 9
 * 
 * @author Mitali Kulkarni
 *
 */

public class P059_Kulkarni_Panel {
	
	private JLabel NameLabel;
	private JLabel LastNameLabel;
	private JLabel timer;
	private JPanel panel;
	private int counter = 0;
	private boolean even = true;
	private int panelHeight = 100;
	private int panelWidth = 100;
	
	// Constructor 
	public P059_Kulkarni_Panel(int color_value) {
		if (color_value % 2 == 0) {
			even = true;
			counter = 0;
		} else {
			even = false;
			counter = 9;
		}
	}
	
	public JPanel prepareGUI() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(panelWidth, panelHeight);
		
		// Add First Name JLabel with w = 25, h = 25 and font = Papyrus
		NameLabel = new JLabel("Mitali", JLabel.CENTER);
		NameLabel.setBounds(10, 10, 25, 25);
		NameLabel.setFont(new Font("Papyrus", Font.PLAIN, 6));
		panel.add(NameLabel);
		
		// Add Last JLabel with w = 25, h = 25 and font = Papyrus
		LastNameLabel = new JLabel("Kulkarni", JLabel.CENTER);
		LastNameLabel.setBounds(10, 20, 25, 25);
		LastNameLabel.setFont(new Font("Papyrus", Font.PLAIN, 6));
		panel.add(LastNameLabel);
		
		// Add Timer JLabel with w = 25, h = 25 and font = Papyrus
		timer = new JLabel("0", JLabel.CENTER);
		timer.setBounds(10, 30, 25, 25);
		timer.setFont(new Font("Papyrus", Font.PLAIN, 6));
		panel.add(timer);
		
		// Timer object
		Timer t = new Timer();		
		try {
			t.schedule(new TimerTask() {
				@Override
				public void run() {
					System.out.print(even);
					if (even) {
						panel.setBackground(Color.WHITE); // If color_value is even set background color to white
						if (counter == 10)
							counter = 0;
						timer.setText(""+ counter++);
					} else {
						Color lightBlue = new Color(31,190,214); // If color_value is odd set background color to light blue
						panel.setBackground(lightBlue);
						if (counter == -1)
							counter = 9;
						timer.setText(""+ counter--);
					}
				}
			}, 0, 1000);
		} catch(Exception e) { // Any exceptions encountered are handled in this part
			
	    		System.out.println("Error in Timer Display");
			e.printStackTrace();
	    	}
		// return JPanel object
		return panel;
	}
	
	// For testing purpose
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P059_Kulkarni_Panel panelDemo = new P059_Kulkarni_Panel(1);
		JFrame frame = new JFrame();
		JPanel panel = panelDemo.prepareGUI();

		frame.setSize(100, 100);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
