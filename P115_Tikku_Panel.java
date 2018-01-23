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
	private JLabel lName, lNumber;
	private CountDirection countDirection;
	
	/* Constants */
	private static final String name = "<html>Adhiraj<br>Tikku</html>";
	private static final String FONT_NAME = "Papyrus";
	private static final int FONT_SIZE = 15;
	private static final Color FONT_COLOR = Color.BLACK;
	
	/**
	* This constructor creates a customized JPanel with two labels for name and timer.
	* @param flagCounterColor Value to determine the panel background color and increasing or decreasing order of timer.
	* If flag is even, then white background and increasing order.
	* If flag is odd, then light blue and decreasing order.
	*/
	P115_Tikku_Panel(int flagCounterColor)
	{
		setCountDirection(flagCounterColor);
		createPanel();
		startTimer();
	}
	
	/**
	* This function sets the count direction of the counter.
	* @param flagCounter Value to determine the increasing or decreasing order of timer.
	* If flag is even, then increasing order.
	* If flag is odd, then decreasing order.
	*/
	public void setCountDirection(int flagCounter)
	{
		if(flagCounter % 2 == 0)
			countDirection = CountDirection.increment;
		else
			countDirection = CountDirection.decrement;
	}
	
	/**
	* This function customizes the panel with two labels.
	* 1st label is set to the name.
	* 2nd label is set to a timer value.
	* A thread is run to display the timer value as it changes every second.
	* @param Nothing 
	* @return Nothing.
	*/
	public void createPanel()
	{
		setSize(100, 100);
		setLayout(new GridLayout(2, 0));
		
		// lName
		lName = new JLabel(name, SwingConstants.CENTER);
		lName.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
		lName.setForeground(FONT_COLOR);
		
		// lNumber
		lNumber = new JLabel("", SwingConstants.CENTER);
		lNumber.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
		lNumber.setForeground(FONT_COLOR);
		
		add(lName);
		add(lNumber);
		
		setStartingTimerValue();
		setBackground(getBackgroundColor());
	}
	
	/**
	* Sets the starting value of the lNumber label.
	* If count direction is increment then label is set to 0
	* else it is set to 9.
	* @param Nothing 
	* @return Nothing.
	*/
	public void setStartingTimerValue()
	{
		if(this.countDirection == CountDirection.increment)
		{
			lNumber.setText("0");
		}
		else
		{
			lNumber.setText("9");
		}
	}
	
	/**
	* Gets the background color of the panel.
	* @param Nothing 
	* @return Color.
	*/
	public Color getBackgroundColor()
	{
		if(this.countDirection == CountDirection.increment)
		{
			return Color.WHITE;
		}
		else
		{
			return new Color(173, 216, 230);
		}
	}
	
	/**
	* Starts a timer at intervals of 1 second in either increasing or decreasing order.
	* @param Nothing 
	* @return Nothing.
	* @exception Exception
	*/
	public void startTimer()
	{
		try
		{
			Timer timer = new Timer(1000, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(countDirection == CountDirection.increment)
					{
			        	counterIncrement();
			        }
					else
					{
						counterDecrement();
					}
				}
			});
			timer.start();
		}
		catch(Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	/**
	* Increases count of timer by 1 and sets it to the label lNumber.
	* If timer value is crossing 9 then label is set to 0 so that it loops from 0-9.
	* @param Nothing 
	* @return Nothing.
	*/
	public void counterIncrement()
	{
		int num = Integer.parseInt(lNumber.getText());
		if(num == 9)
			lNumber.setText("0");
		else
			lNumber.setText("" + ++num);
	}
	
	/**
	* Decreases count of timer by 1 and sets it to the label lNumber.
	* If timer value is crossing 0 then label is set to 9 so that it loops from 9-0.
	* @param Nothing 
	* @return Nothing.
	*/
	public void counterDecrement()
	{
		int num = Integer.parseInt(lNumber.getText());
		if(num == 0)
			lNumber.setText("9");
		else
			lNumber.setText("" + --num);
	}
}
