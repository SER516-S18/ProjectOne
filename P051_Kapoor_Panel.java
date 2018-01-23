/*
 * For SER515 only
 * Lab: Project 1
 * Author: Drishty Kapoor
 * Version: 1
 * ID: 51
 * P051_Kapoor_Panel is a class which creates a panel which consists of a label1 with first name and last name,
 * and label2 for timer displaying a number decreasing from 9 to 0 when "count" is odd or increasing from 0 to 9
 * when "count" is even every second. Also, made a constructor which receives an integer value(in count), 
 * if the value is even then background is White and if odd then it is light blue.
 * Exception handling is also included here.
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class P051_Kapoor_Panel extends JPanel
{
	static int i = -1, j = 10;
	private JLabel label1, label2;
	public P051_Kapoor_Panel(int count)
	{	
		/*
		 * Set Panel size as 100*100 and layout as Grid layout.
		 */
		setSize(100,100);
		setLayout(new GridLayout(2, 1));
		
		/*
		 * Align labels in the center and enter name in label1.
		 */
		label1 = new JLabel("<html>Drishty<br>Kapoor</html>", SwingConstants.CENTER);
		label2 = new JLabel("", SwingConstants.CENTER);
		
		/*
		 * Set Font size of label1 and label2.
		 */
		add(label1);
		label1.setFont(new Font("Papyrus", Font.PLAIN,15));
		add(label2);
		label2.setFont(new Font("Papyrus", Font.PLAIN,15));
		
		/*
		 * Added timer which displays a number from 0 to 9 when "count" is even
		 * and number from 9 to 0 when "count" is odd.
		 */
		try
		{
			Timer timer = new Timer(1000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(count % 2 == 0)
					{
						i++;
						if(i==10)
						{
							i=0;
						    label2.setText("0");}
					    else
						    label2.setText("" + i);
						}
					else
					{
						setBackground(new Color(173,216,230));
					    if(j==0)
					    {
					    	j = 10;
						    label2.setText("9");
						}
					    j--;
					    label2.setText("" + j);
					    }
					}
				});
			timer.start();
			}
		catch(Exception e)
		{
			System.out.print("Exception");
	    }
		}
	/*
	Main function just for trial.
	 
	public static void main(String[] args) 
    {	
		
	    P051_Kapoor_Panel p = new P051_Kapoor_Panel(3);
	    JFrame frame = new JFrame("Trial");
		frame.setVisible(true);
		frame.setSize(200,200);
		frame.add(p);
		
	}
	*/
}
