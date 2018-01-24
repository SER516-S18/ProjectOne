import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * @author Janani Thiagarajan
 * 
 * @version 1.0  A class that creates a Panel with two Labels-
 * one with Name and one with timer. Uses an Integer input to 
 * determine the background color and the timer
 *
 * If the input value is even set background to White, timer goes 
 * from 0 to 9.If its odd set background to LightBlue,timer goes 
 * from 9 to 0. 
 */
@SuppressWarnings("serial")
public class P113_Thiagarajan_Panel extends JPanel {

	String name="<html><center>Janani<br>Thiagarajan<br></center></html>";
	
	JLabel nameLabel = new JLabel(name);
	JLabel timeLabel= new JLabel();
	Font font= new Font("Papyrus", Font.PLAIN,15);
	Color lightBlue= new Color(173,216,230);
	
	Timer timer;
	int count;
	/**
	 * Constructor which creates a panel with name & timer
	 * @param integer - Input value based on which the background 
	 *		    color and timer changes
	 */
	public P113_Thiagarajan_Panel(int inputValue) {  	
		
		setPreferredSize(new Dimension(100,100));
		setLayout(new GridLayout(0, 1));
		
		nameLabel.setFont(font);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(nameLabel);
		
		timeLabel.setFont(font);
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);   
		add(timeLabel);   

		try {
		     if(inputValue % 2 == 0) {
				count=0;
				setBackground(Color.WHITE);
				timer = new Timer(1000, new ActionListener() {	  
					public void actionPerformed(ActionEvent e) {			  
					if (count < 10) {
						timeLabel.setText(Integer.toString(count));
						if (count==9) count=0;
						else count++;
					} 
					}
				});
				timer.start();
		      }
		      else {
				count=9;
				setBackground(lightBlue);
				timer = new Timer(1000, new ActionListener() {
					public void actionPerformed(ActionEvent e) {				 
					if (count >= 0) {
						timeLabel.setText(Integer.toString(count));
						if(count==0) count=9;
						else count--;
					} 
					}
				 });
				timer.start();
		      }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
  }
}
