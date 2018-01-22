/**
* The P115_Tikku_Panel class creates a JPanel containing two labels for name and a timer value.
* The name contains the full name displayed in 2 lines.
* The timer displays a number between 0-9 and changes automatically in increasing or decreasing order.
* 
* @author  Adhiraj Tikku
* @version 1.0
* @since   2018-01-21
*/
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class P115_Tikku_Panel extends JPanel
{
	private enum CountDirection {increment, decrement}; 
	private JLabel name, number;
	private CountDirection countDirection;
	
	/**
	* This constructor creates a customized JPanel with two labels for name and timer.
	* @param flagCountColor Value to determine the panel background color and increasing or decreasing order of timer.
	* If flag is even, then white background and increasing order.
	* If flag is odd, then light blue and decreasing order.
	*/
	P115_Tikku_Panel(int flagCountColor)
	{
		if(flagCountColor % 2 == 0)
			countDirection = CountDirection.increment;
		else
			countDirection = CountDirection.decrement;
		customizePanel();
	}
	
	/**
	* This function customizes the panel with two labels.
	* 1st label is set to the name.
	* 2nd label is set to a timer value.
	* A thread is run to display the timer value as it changes every second.
	* @param Nothing 
	* @return Nothing.
	* @exception Exception
	*/
	public void customizePanel()
	{
		try
		{
			setSize(100, 100);
			setLayout(new GridLayout(2, 0));
			
			name = new JLabel("<html>Adhiraj<br>Tikku</html>", SwingConstants.CENTER);
			
			if(countDirection == CountDirection.increment)
			{
				number = new JLabel("9", SwingConstants.CENTER);
				setBackground(Color.WHITE);
			}
			else
			{
				number = new JLabel("0", SwingConstants.CENTER);
				setBackground(new Color(173, 216, 230));
			}
			
			add(name);
			add(number);
			name.setFont(new Font("Papyrus", Font.PLAIN, 15));
			number.setFont(new Font("Papyrus", Font.PLAIN, 15));
			
			Timer timer = new Timer(1000, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(countDirection == CountDirection.increment)
					{
			        	int num = Integer.parseInt(number.getText());
		        		if(num == 9)
		        			number.setText("0");
		        		else
		        			number.setText("" + ++num);
			        }
					else
					{
						int num = Integer.parseInt(number.getText());
						if(num == 0)
							number.setText("9");
						else
							number.setText("" + --num);
					}
				}
			});
			timer.start();
		}
		catch(Exception e)
		{
			System.out.println("Exception: " + e);
		}
	}
}