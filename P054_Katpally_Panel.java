import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class P054_Katpally_Panel{
	
	JPanel panel;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	Color color;
	Timer timer;
	int flag = 1;
	int c;
	
	/*Constructor of the Panel class that takes an integer input based on which the 
	 * background color of the panel is decided
	 */
	public P054_Katpally_Panel(int x) 
	{
		if(x%2 == 0)
		{
			color = Color.WHITE;
			flag = 0;
		}
		else
		{	
			color = new Color(31, 190, 214);
		}
	}
	
	/*Function to create a JPanel with three JLabels and return the panel*/
	public JPanel createPanel()  
	{
		
		
	    label1 = new JLabel("Harshitha");
	    label1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	    label1.setFont(new Font("Papyrus", Font.BOLD, 16));
	    
	    label2 = new JLabel("Katpally");
	    label2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	    label2.setFont(new Font("Papyrus", Font.BOLD, 16));
	    
	    label3 = new JLabel("Text");
	    label3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	    label3.setFont(new Font("Papyrus", Font.BOLD, 16));
	  
	    panel = new JPanel();
	    panel.setSize(100, 100);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

	    /*Using Timer class to display the counter depending on the argument passed while object creation*/
	    	if(flag == 0)
	    	{
	    		c = 0;
	    		timer = new Timer(1000, new ActionListener() {
	    			@Override
	    			public void actionPerformed(ActionEvent e) {
	    				if(c > 9)
	    				{
	    					c = 0;
	    				}
	    				label3.setText(Integer.toString(c));
	    				c++;	  				
	    			}
	    		});
	    	}
	    	else
	    	{
	    		c = 9;
	    		timer = new Timer(1000, new ActionListener() {
	    			@Override
	    			public void actionPerformed(ActionEvent e) {
	    				if(c < 0)
	    				{
	    					c = 9;
	    				}
	    				label3.setText(Integer.toString(c));
	    				c--;	    				
	    			}
	    		});
	    	}
	    		
	    
	    timer.start();
	    panel.add(label1);
	    panel.add(label2);
	    panel.add(label3);
	    panel.setBackground(color);

	    return panel;
	}	

	/*Main Function to test the creation of a JPanel*/
	/*public static void main(String[] args) 
	{
		
		int a = 6;
		P054_Katpally_Panel pobj = new P054_Katpally_Panel(a);
		
		JFrame frame = new JFrame("Test");
	    frame.setVisible(true);
	    frame.setLayout(null);
	    frame.setSize(500, 500);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel p = pobj.createPanel();
	    frame.add(p);
		
		
	}*/

}
