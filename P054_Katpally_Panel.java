import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class P054_Katpally_Panel
{
	private JPanel panel;
	private JLabel firstname;
	private JLabel lastname;
	private JLabel counter;
	private Timer timer;
	private int i;
	private static final Color LIGHTBLUE = new Color(173, 216, 230);
	
	/*Constructor of the class that takes an integer input based on which the 
	 * background color of the panel is decided.
	 */
	public P054_Katpally_Panel(int counterdecider) 
	{
		firstname = new JLabel("Harshitha");
	    	firstname.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	    	firstname.setFont(new Font("Papyrus", Font.PLAIN, 15));
	    
	    	lastname = new JLabel("Katpally");
	    	lastname.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	    	lastname.setFont(new Font("Papyrus", Font.PLAIN, 15));
	    
	    	counter = new JLabel("Text");
	    	counter.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	    	counter.setFont(new Font("Papyrus", Font.PLAIN, 15));
	  
	    	panel = new JPanel();
	    	panel.setSize(100, 100);
	    	panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

	    	/*Using Timer class to display the counter and setting background color 
	    	* depending on the argument passed while object creation.
	     	*/
	    	if(counterdecider%2 == 0)
	    	{
	    		i = 0;
	    		panel.setBackground(Color.WHITE);
	    		timer = new Timer(1000, new ActionListener() {
	    			@Override
	    			public void actionPerformed(ActionEvent e) {
	    				if(i > 9)
	    				{
	    					i = 0;
	    				}
	    				counter.setText(Integer.toString(i));
	    				i++;
	    			}
	    		});
	    	}
	    	else
	    	{
	    		i = 9;
	    		panel.setBackground(LIGHTBLUE);
	    		timer = new Timer(1000, new ActionListener() {
	    			@Override
	    			public void actionPerformed(ActionEvent e) {
	  				if(i < 0)
	  	 			{
	  	  				i = 9;
	  	  			}
	  	  			counter.setText(Integer.toString(i));
	  	  			i--;			
	  	  		}
	    		});
	    	}
	    	timer.start();
	    	panel.add(firstname);
	    	panel.add(lastname);
		panel.add(counter); 
	}
}
