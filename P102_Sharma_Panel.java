import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;


@SuppressWarnings("serial")

/**
 * @author	Akash
 * @version 	1.0
 * @since	21.01.2018
 * 
 * Project:01 SER516
 * Class extends JPanel and contains two JLabels.
 * One JLabel used for Name and one for the Counter.
 * Panel background is set to WHITE or LIGHTBLUE based on input argument to constructor.
 * Counter increases from 0-9 if value is even or decreases from 9-0 if input value is odd.
 */

public class P102_Sharma_Panel extends JPanel
{
	private int inputValue;
	public static final Color LIGHTBLUE = new Color(173, 216, 230);
	
	/**
	 * Constructor takes input value and call initialize_PanelProperties() to set panel properties.
	 * @param inputValue
	 */
	
	public P102_Sharma_Panel(int inputValue)
	{
		this.inputValue = inputValue;
		initialize_PanelProperties();
	}
	
	/**
	 * Function to set panel properties and add JLabels.
	 */
	
	public void initialize_PanelProperties()
	{	
		//Adding JLabel for Name to Panel Object.
		JLabel Namelbl = new JLabel("<html>Akash<br>Sharma</html>", SwingConstants.CENTER);
		Namelbl.setFont(new Font("Papyrus", Font.PLAIN, 15));
		add(Namelbl);
		
		//Adding JLabel for Counter to Panel Object.
		JLabel Counterlbl = new JLabel("0", SwingConstants.CENTER);
		Counterlbl.setFont(new Font("Papyrus", Font.PLAIN, 15));
		add(Counterlbl);
		
		//Set properties of JPanel
		setBounds(0, 0, 100, 100);
		setLayout(new GridLayout(2,0));
		
		//Initialize the Timer Object to Schedule ClockTask Object.
		
		try
		{
			Timer tmObj = new Timer();
			
			if(inputValue % 2 == 0)
			{
				setBackground (Color.WHITE);
				tmObj.scheduleAtFixedRate(new ClockTask(Counterlbl, 0), 0, 1000);
				
			}
			else
			{
				setBackground (LIGHTBLUE);
				tmObj.scheduleAtFixedRate(new ClockTask(Counterlbl, 9), 0, 1000);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This class extends TimerTask class.
	 * Change counter value and background color based on inputvalue.
	 */
	
	class ClockTask extends TimerTask 
	{
		private JLabel counterLabel;
		private int counter;
		private int startDigit;
		
		/**
		 * Constructor to to clockTask
		 * @param counterLabel Counter Label Reference
		 * @param startDigit Initialize the starting digit.
		 */
		
		public ClockTask(JLabel counterLabel, int startDigit)
		{
			this.counterLabel = counterLabel;
			this.counter = startDigit;
			this.startDigit = startDigit;
		}
		
		//Function to increment or decrement the counter based on the input value.
		
		public void run()
		{
			try
			{

				if(startDigit == 0)
				{
					counterLabel.setText(String.valueOf(counter));
					counter++;
					if(counter > 9)
						counter = 0;
				}
				else
				{
					counterLabel.setText(String.valueOf(counter));
					counter--;
					if(counter < 0)
						counter = 9;
				}
			} catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
}

