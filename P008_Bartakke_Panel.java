import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * This class implements a JPanel with following contents:
 * A Label for Name (JLabel Name)
 * A Label to display a counter (JLabel Name2)
 * 
 * In this class the parameterized constructor takes a value.
 * Based on this value the Background Color and the Counter change.
 * 
 * If value is odd then background color is light blue and counter decrements from 9 - 0
 * If value is even then background color is white and counter increments from 0 - 9
 * Note that counter keeps on running continuously
 * 
 * @author Pratik Bartakke
 * Date created- 01-20-2018
 *
 */

@SuppressWarnings("serial")
public class P008_Bartakke_Panel extends JPanel
{
	Timer timer; // Timer object for counter
	int counter = 0; // Variable for incrementing counter scenario
	int counter2 = 9; // Variable for decrementing counter scenario
	int value;
	P008_Bartakke_Panel(int flag)
	{
		value = flag; // Parameterized constructor accepting value based upon which background color and counter change
		Font f = new Font("Papyrus", Font.BOLD, 15); // Defining the font for name label
		Font f1 = new Font("Papyrus", Font.BOLD, 15); // Defining the font for counter label
		Color lightBlue= new Color(173,216,230); // Defining the light blue color for background
		JLabel Name = new JLabel("<html>Pratik<br>Bartakke</html>",JLabel.CENTER);
		JLabel Name2 = new JLabel("",JLabel.CENTER);
		Name.setFont(f);
		Name2.setFont(f1);
		Name.setBounds(10,10,80,80);
		add(Name);
		Name2.setBounds(10,60,30,30);
		add(Name2);
		setSize(100, 100);
		setLayout(null);
    		try // Exception handling included for the changing background and counter conditions
    		{
			if(value % 2 == 0) // Checks whether value is even
			{
				setBackground(Color.white); // If value is even background set to white
				timer = new Timer(1000, new ActionListener() // Timer initialized with 1 sec interval
				{
				    @Override
				    public void actionPerformed(ActionEvent e) 
				    {
					Name2.setText(String.valueOf(counter)); // Display counter value starting from 0
					counter++; // Increment counter till it reaches 9
					if (counter == 10) 
					{
					     counter = 0; // Reset counter once it reaches 9 to restart the counting from 0
					}
				    }
			     	});
				timer.start(); // Start timer for displaying the counter
			}
			else // Value is odd
			{
				setBackground(lightBlue); // background set to light blue
				timer = new Timer(1000, new ActionListener()
				{
				    @Override
				    public void actionPerformed(ActionEvent e)
				    {
					Name2.setText(String.valueOf(counter2));
					Name2.setBackground(lightBlue);
					counter2--; // Decrement counter till it reaches 0
					if (counter2 == -1)
					{
					     counter2 = 9; // Reset counter once it reaches 0 to restart the counting from 9
					}
				    }
				});
				timer.start(); // Start timer for displaying the counter
			}
    		}
		catch(Exception e) // Any exceptions encountered are handled in this part
		{
			System.out.println("Error in Timer and Background Color Display");
				e.printStackTrace();
		}
	}
	
	/*
	// FOR TESTING ONLY - Specification requires this to remain in here.
	public static void main(String[] args) 
	{
		JPanel Obj = new P008_Bartakke_Panel(56);
		JFrame Frame1 = new JFrame("PRATIK BARTAKKE PANEL");
		Frame1.add(Obj);
		Frame1.setSize(150, 150);
		Frame1.setLayout(null);    
        Frame1.setVisible(true);
	}
	*/
}
