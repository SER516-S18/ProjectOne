import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * The class P012_Bhatt_Panel is used to create a panel which shows my name and a timer.
 * @author vihar bhatt
 * @version 1.00
 * @since 01-20-2018
 * 
 */
public class P012_Bhatt_Panel extends JPanel
{
	JLabel name;
	JLabel counter;
	Timer timer;
	int count;
	int flag;
	
	/**
	 * 
	 * @param value - the value determines the background color of panel and increment/decrement of counter
	 * 
	 */
	public P012_Bhatt_Panel(int value)
	{		
		setBackgroundProperties(value);

		name=new JLabel("<html>Vihar<br>Bhatt</html>");
		name.setBounds(0,0,100,50);
		name.setHorizontalAlignment(JLabel.CENTER);
		name.setFont(new Font("Papyrus",Font.PLAIN,15));

		counter.setBounds(0,50,100,50);
		counter.setHorizontalAlignment(JLabel.CENTER);
		counter.setFont(new Font("Papyrus",Font.PLAIN,15));

		setPreferredSize(new Dimension(100,100));
		setLayout(new GridLayout(2,1));

		add(name);
		add(counter);

		timer=new Timer(1000, new CounterListener());
		timer.setInitialDelay(0);
		timer.start();
	}
	
	/**
	 * 
	 * @param value - use to set the background color and flag for timer
	 * Even if the integer value is even then the background is white and flag remains 0.
	 * If the integer value is odd then the background is light blue and flag set to 1.
	 */
	private void setBackgroundProperties(int value)
	{
		try
		{
			if((value%2)==0)
			{
				counter=new JLabel("0");
				setBackground(Color.white);
				count=0;
			}
			else
			{
				counter=new JLabel("9");
				setBackground(new Color(173,216,230));
				flag=1;
				count=9;
			}
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @author vihar bhatt
	 * This class is used to implement the timer.
	 * If the flag is 0, then timer increments from 0 to 9.
	 * If the flag is 1, then timer decrements from 9 to 0.
	 */
	private class CounterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				counter.setText(String.valueOf(count));
				if(flag==0)
				{
					if(count!=9)
					{
						count++;
					}
					else
					{
						count=0;
					}
				}
				else
				{
					if(count!=0)
					{
						count--;
					}
					else
					{
						count=9;
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}
}
