import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;


@SuppressWarnings("serial")

/**
 * Class extends JPanel and contains two JLabels.
 * One JLabel used for Name and one for the Counter.
 * It Contains constructor which takes one input value.
 * Panel background is set to WHITE if the input value is even and LIGHT BLUE if the input value is odd.
 * Counter increases from 0-9 if value is even or decreases from 9-0 if input value is odd.
 * 
 * @author	Akash
 * @version 1.0
 * @since	21.01.2018
 */

public class P102_Sharma_Panel extends JPanel
{
	private int x;
	
	/**
	 * Constructor takes input value and call initialize_PanelProperties() to set panel properties.
	 * @param x
	 */
	
	public P102_Sharma_Panel(int x)
	{
		this.x = x;
		initialize_PanelProperties(); // Function to add JLabels and set various properties on panel
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
			
			if(x%2 == 0)
			{
				setBackground (Color.WHITE);
				tmObj.scheduleAtFixedRate(new clockTask(Counterlbl, 0), 0, 1000);
				
			}
			else
			{
				setBackground (new Color(173, 216, 230));
				tmObj.scheduleAtFixedRate(new clockTask(Counterlbl, 9), 0, 1000);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author Akash
	 * Class extends TimerTask is used to define the task to be executed.
	 * Check for the even odd conditions and respectively changes the counter and background color.
	 */
	
	class clockTask extends TimerTask 
	{
		private JLabel lblCounter;
		private int counter;
		private int flag;
		
		/**
		 * Constructor to to clockTask
		 * @param lblref Counter Label Reference
		 * @param startDigit Initialize the starting digit.
		 */
		
		public clockTask(JLabel lblref, int startDigit)
		{
			this.lblCounter = lblref;
			this.counter = startDigit;
			this.flag = startDigit;
		}
		
		//Function to increment or decrement the counter based on the input value.
		
		public void run()
		{
			try
			{

				if(flag == 0)
				{
					lblCounter.setText(String.valueOf(counter));
					counter++;
					if(counter > 9)
						counter = 0;
				}
				else
				{
					lblCounter.setText(String.valueOf(counter));
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
	
	/**
	 * Main method to test the code.
	 * @param args
	 *
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		P102_Sharma_Panel panel = new P102_Sharma_Panel(21);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(800, 800);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	*/
}
