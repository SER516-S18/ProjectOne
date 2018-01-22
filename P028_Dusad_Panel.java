
import java.awt.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.lang.Exception;
import javax.swing.border.EmptyBorder;
/**
 * P028_Dusad_Utsav: We create a panel with three rows of JLabels.
 * Row1 contains first name of the author of this class. 
 * Row2 is the last name of the author. 
 * Row3 is a counter which increments or decrements depending on the parameter passed to the constructor while creating the object.
 * @author Utsav Dusad
 * @version 1.0
 */
public class P028_Dusad_Panel{
	private int counter;
	private boolean even;
	private JPanel panel;
	private JLabel timer;
	

	//Constructor which takes an integer as input. 
	//If the integer is even then we set even=true and counter to 0. value goes from 0 to 9
	//If the integer is odd then we set even=false and counter to 9. value goes from 9 to 0
	public P028_Dusad_Panel(int color_value) {
		try {
			if (color_value % 2 == 0) {
				even = true;
				counter = 0;
			} else {
				even = false;
				counter = 9;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P028_Dusad_Panel panel28 = new P028_Dusad_Panel(2);
		JFrame frame = new JFrame("28-Frame");
		frame.setSize(300, 300);
		JPanel panel = panel28.preparePanelUI(7);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
 
	}
	
	public JPanel preparePanelUI(int color_value) {
		try {
			//Panel and label properties: Font, Color, Text, Layout, size and calls function made for the timer execution
			panel = new JPanel();
			panel.setLayout(null);
			panel.setSize(100, 100);
			JLabel firstNameLabel,lastNameLabel;
			
			firstNameLabel = new JLabel("Utsav", JLabel.CENTER);
			firstNameLabel.setBounds(10, 0, 35, 25);
			firstNameLabel.setFont(new Font("Papyrus", Font.PLAIN, 10));
			firstNameLabel.setHorizontalAlignment(JLabel.CENTER);
			firstNameLabel.setVerticalAlignment(JLabel.CENTER);
			panel.add(firstNameLabel);
			
			lastNameLabel = new JLabel("Dusad", JLabel.CENTER);
			lastNameLabel.setBounds(10, 10, 35, 25);
			lastNameLabel.setFont(new Font("Papyrus", Font.PLAIN, 10));
			lastNameLabel.setHorizontalAlignment(JLabel.CENTER);
			lastNameLabel.setVerticalAlignment(JLabel.CENTER);
			panel.add(lastNameLabel);
			
			timer = new JLabel("0", JLabel.CENTER);
			timer.setBounds(10, 20, 25, 25);
			Timer t = new Timer();
			timer.setFont(new Font("Papyrus", Font.PLAIN, 10));
			timer.setHorizontalAlignment(JLabel.CENTER);
			timer.setVerticalAlignment(JLabel.CENTER);
			panel.add(timer);
			
			
			if (color_value % 2 == 0) {
				panel.setBackground(Color.WHITE);
			} else {
				Color lightBlue = new Color(173,216,230);
				panel.setBackground(lightBlue);
			}
	        panel.setLayout(new BorderLayout(0, 0));
	        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
			
			//Timer execution : From 0 to 9 when flag is even and from 9 to 0 when flag is odd
			t.schedule(new TimerTask() {
				@Override
				public void run() {
					if (even==true) {
						if (counter == 10)
							counter = 0;
						timer.setText(""+ counter++);
					} else {
						if (counter == -1)
							counter = 9;
						timer.setText(""+ counter--);
					}
				}
			}, 0, 1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return panel;
	}

}
