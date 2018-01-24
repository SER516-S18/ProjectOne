import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JLabel;

/**
* P115_Tikku_Panel class creates a JPanel containing two labels for name and a timer value.<br>
* 1. The name shows the full name in 2 separate lines.<br>
* 2. The timer displays a number between 0-9 and changes every second in either increasing or decreasing order.
* 
* @author  Adhiraj Tikku
* @version 1.0
* @since   2018-01-21
*/
@SuppressWarnings("serial")
public class P115_Tikku_Panel extends JPanel
{
	private enum CountDirection {increment, decrement}; 
	private JLabel lName, lNumber;
	private CountDirection countDirection;
	
	/* Constants */
	private static final String FULL_NAME = "<html>Adhiraj<br>Tikku</html>";
	private static final String FONT_NAME = "Papyrus";
	private static final int FONT_SIZE = 15;
	private static final Color FONT_COLOR = Color.BLACK;
	private static final Color LIGHT_BLUE = new Color(173, 216, 230);
	
	/**
	* This constructor creates a customized JPanel with two labels for name and timer.
	* @param panelConfigure Value to determine the panel background color and increasing or decreasing order of timer.
	* <br>1. If {@code even}, then white background and increasing order.
	* <br>2. If {@code odd}, then light blue background and decreasing order.
	*/
	P115_Tikku_Panel(int panelConfigure)
	{
		setCountDirection(panelConfigure);
		createPanel();
		startTimer();
	}
	
	/**
	* This function sets the {@code countDirection} of the counter.
	* @param panelConfigure Value to determine the increasing or decreasing order of timer.
	* <br>1. If {@code even}, then increasing order.
	* <br>2. If {@code odd}, then decreasing order.
	* @return Nothing
	*/
	public void setCountDirection(int panelConfigure)
	{
		if(panelConfigure % 2 == 0)
			countDirection = CountDirection.increment;
		else
			countDirection = CountDirection.decrement;
	}
	
	/**
	* This function creates the panel and adds two labels to it.
	* <br>1st label is set to the name.
	* <br>2nd label is set to a number.
	* @param Nothing
	* @return Nothing
	*/
	public void createPanel()
	{
		setSize(100, 100);
		setLayout(new GridLayout(2, 0));
		
		// lName
		lName = new JLabel(FULL_NAME, SwingConstants.CENTER);
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
	* Sets the starting value of label {@code lNumber}.
	* If {@code countDirection} is increment then label is set to 0,
	* else it is set to 9.
	* @param Nothing
	* @return Nothing
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
	* @return Color
	*/
	public Color getBackgroundColor()
	{
		if(this.countDirection == CountDirection.increment)
		{
			return Color.WHITE;
		}
		else
		{
			return LIGHT_BLUE;
		}
	}
	
	/**
	* Starts a timer at intervals of 1 second in either increasing or decreasing order.
	* @param Nothing
	* @return Nothing
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
	* Increases count of timer by 1 and sets it to the label {@code lNumber}.
	* If timer value is crossing 9 then label is set to 0 so that it loops from 0 to 9.
	* @param Nothing
	* @return Nothing
	*/
	public void counterIncrement()
	{
		int counterValue = Integer.parseInt(lNumber.getText());
		if(counterValue == 9)
			lNumber.setText("0");
		else
			lNumber.setText("" + ++counterValue);
	}
	
	/**
	* Decreases count of timer by 1 and sets it to the label {@code lNumber}.
	* If timer value is crossing 0 then label is set to 9 so that it loops from 9 to 0.
	* @param Nothing
	* @return Nothing
	*/
	public void counterDecrement()
	{
		int counterValue = Integer.parseInt(lNumber.getText());
		if(counterValue == 0)
			lNumber.setText("9");
		else
			lNumber.setText("" + --counterValue);
	}
}
