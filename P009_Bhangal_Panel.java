import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * The P009_Bhangal_Panel implements a JPanel which consists of 
 * two JLabels. One for displaying the name and other for displaying
 * a counter. The counter JLabel and Jpanel's background color are updated
 * based on the input to the constructor.
 * 
 * @author Karansher Bhangal
 * @version 1.0
 * @since 2017-01-20
 *
 */

public class P009_Bhangal_Panel extends JPanel{

	private JLabel nameLabel,counterLabel;
	private Timer timer;
	private int count,even;					
	private Color lightBlue = new Color(173,216,230);
	private Color white = Color.WHITE;
	private Dimension dim = new Dimension(100,100);
	private GridLayout layout = new GridLayout(2,1);
	private Font font = new Font("Papyrus", Font.PLAIN, 15);
	private int alignment = SwingConstants.CENTER;
	private int timeDelay = 1000;
	
	/**
	 * This is the constructor method which makes use of PanelSettings, SetLabels and CounterTimer.
	 * @param i This is passed to PanelSettings. There it is used to set the background and variables for 
	 * counter.
	 */
	public P009_Bhangal_Panel(int i) {
		
		PanelSettings(i);
		
		SetLabels();
		
		CounterTimer();
		
	}
	
	/**
	 * This method is used to set the JPanel's background color,
	 * size and layout style. If the param is even the background is set to white
	 * else lightBlue.
	 * 
	 * @param i This is used to set the background and variables for counter.
	 * @return Nothing
	 */
	private void PanelSettings(int i) {
		
		if(i%2==0) {											//If input to constructor is Even 
			this.setBackground(white);
			even = 1;
			count = 0;
		}
		else {												//If input to constructor is Odd
					
			this.setBackground(lightBlue);		
			even = 0;
			count = 9;
		}
		
		this.setPreferredSize(dim);		
		this.setLayout(layout);					
	}
	
	
	/**
	 * This method is used to define the Jlabels and add then to the 
	 * JPanel. It also sets the text, font, alignment of the JLabels. 
	 */
	private void SetLabels() {
		
		nameLabel = new JLabel("nameLabel");
		counterLabel = new JLabel("counterLabel");
		
		nameLabel.setText("<html>Karansher<br>Bhangal<html>");
		nameLabel.setFont(font);
		this.add(nameLabel);
		nameLabel.setHorizontalAlignment(alignment);
		
		counterLabel.setText("0");
		counterLabel.setFont(font);
		this.add(counterLabel);
		counterLabel.setHorizontalAlignment(alignment);
	}
	
	
	/**
	 * This method updates the value of the Counter JLabel every second.
	 * Depending on the value of variable "check" it either goes from 0 to 9 
	 * or 9 to 0.
	 */
	private void CounterTimer() {
		
		try {
		timer = new Timer(timeDelay, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
		    		counterLabel.setText(Integer.toString(count));
		    		
		    		if(even == 1) {							//if input to constructor is Even
			    		count++;
			    	  	if(count==10) 
			    	  		count=0;
			    	 }
		    		else {									//if input to constructor is Odd
		    			count--;
		    			if(count==-1)
		    				count =9 ;
		    		}
		    		
			}
		    		
		    });
		    timer.setInitialDelay(0);
		    timer.start();
		    
		}catch(IllegalStateException e) {
			System.out.println("Error msg:"+ e);
		}
	}
	
}
