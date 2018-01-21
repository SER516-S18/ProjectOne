import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Janani
 *
 * Class to create a panel with name and timer
 */
@SuppressWarnings("serial")
public class P113_Thiagarajan_Panel extends JPanel {

	String name="<html><center>Janani<br>Thiagarajan<br></center></html>";
	
	JLabel fnameLabel = new JLabel(name);
	JLabel timeLabel= new JLabel();
	Font font= new Font("Papyrus", Font.BOLD,15);
	
	Timer timer;
	int count;
	
	/* Constructor with integer value based on which 
	 * the background color and the timer changes 
	 */
	public P113_Thiagarajan_Panel(int i) {  	
		createMyPanel(i);
	}
	
	/* Method that creates a Panel with First 
	 * & Last name and a timer */
	
	public void createMyPanel(int i) {  
		
		setPreferredSize(new Dimension(100,100));
	  
		fnameLabel.setFont(font);
		timeLabel.setFont(font);
	 
		add(fnameLabel);   
		timeLabel = new JLabel();
		add(timeLabel);   
		try {
			/* Check if the argument sent is even and if it is then,
			 * set background to White and a timer which counts from 0 to 9 repeatedly */
			if(i % 2 == 0) {
				count=0;
				setBackground(Color.WHITE);
				timer = new Timer(1000, new ActionListener() {	  
					public void actionPerformed(ActionEvent e) {			  
					if (count < 10) {
						timeLabel.setText(Integer.toString(count));
						if (count==9) count=0;
						else count++;
					} else {
						((Timer) (e.getSource())).stop();
					  }
					}
				});
				timer.start();
			}
			/* If the argument sent is odd then, set background to 
			 * Blue and a timer which counts from 9 to 0 repeatedly */
			else {
				count=9;
				Color lightBlue= new Color(150,200,250);
				setBackground(lightBlue);
				timer = new Timer(1000, new ActionListener() {
					public void actionPerformed(ActionEvent e) {				 
					if (count >= 0) {
						timeLabel.setText(Integer.toString(count));
						if(count==0) count=9;
						else count--;
					} else {
						timer.stop();
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
