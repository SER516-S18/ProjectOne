
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

public class P005_Banerjee_Panel extends JPanel
{
	int count_even = 0;
	int flag;
	int count_odd = 9;
	
	//creating JPanel and JLabels for printing Firstname, Lastname and the timer field
	JPanel myPanel = new JPanel();
	private JLabel firstname = new JLabel("Sanchari", JLabel.CENTER);
	private JLabel lastname = new JLabel("Banerjee", JLabel.CENTER);
	private JLabel displayNumber = new JLabel("  0  ", JLabel.CENTER);
	//private JLabel flagNum;
	Border border = BorderFactory.createLineBorder(Color.black, 1);
	
	//parameterized constructor to check if the input number is even or odd
	public P005_Banerjee_Panel(int number)
	{
		//JPanel objPanell = new JPanel();
		if ((number % 2) == 0)
		{
			flag = 1;
			Color white = new Color(255,255,255);
			this.setBackground(white);
		}
			
		else 
		{
			flag = 0;
			Color lightblue = new Color(187,255,255);
			this.setBackground(lightblue);
		}
			
		//Passing the flag value to Panel
		createPanel(flag);
	}
	
	private void createPanel(int flag)
	{	
		//setting panel dimension to a window of size 100X100
		this.setPreferredSize(new Dimension(100, 100));
	    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));  
	   
	    //Printing the labels
	    this.add(firstname, BorderLayout.CENTER);
	    this.add(lastname);
	   // flagNum = new JLabel(String.valueOf(flag));
	    //myPanel.add(flagNum);
		this.add(displayNumber);
		
		//Aligning the labels to center of the panel
		firstname.setAlignmentX(Component.CENTER_ALIGNMENT);
		lastname.setAlignmentX(Component.CENTER_ALIGNMENT);
		displayNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Customizing labels using fonts of style 'Papyrus' and size '15'
		firstname.setFont(new Font("Papyrus", Font.PLAIN, 15));
		lastname.setFont(new Font("Papyrus", Font.PLAIN, 15));
		displayNumber.setFont(new Font("Papyrus", Font.PLAIN, 15));
		//displayNumber.setBorder(new LineBorder(Color.BLACK));
		
		try {
			/*Creating a Timer to auto-increment or auto-decrement from 0-9 / 9-0 based on the value of Flag variable, passed 
			from the constructor, which determines if the input number is even or odd*/
			Timer myTimer = new Timer(1000, new ActionListener() 
			{
				@Override	
				public void actionPerformed(ActionEvent e)	//Triggered when action performed, that is Flag value is set to 0/1
				{
					if(flag==1)
					{	
						if(count_even<10)
						{	
							count_even++;
						}
						else
						{
							count_even=0;
							//displayNumber.setText(""+count_even);
						}
						displayNumber.setText(""+ count_even);
					}
					else if(flag==0)
					{	
												
						if(count_odd>0)
						{
							
						count_odd--;
							//myPanel.add(displayNumber);
						}
						else
						{
							count_odd = 9;	
						}
						displayNumber.setText(""+count_odd);
					}
				}
			});
			myTimer.start();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	    //return myPanel;
	}
	/*public static void main(String[] args)
	{
		//Creating an object of the P005_Banerjee_Panel class and passing it a test value(say 4). 
		//This value is passed to the parameterized constructor of the class, which in turn checks if the number is even or odd in nature. 
		P005_Banerjee_Panel objPanel = new P005_Banerjee_Panel(4);
		JFrame frame = new JFrame("JPanel Test");	//Creating a JFrame object
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.add(objPanel);	//Adding the JPanel to the Frame, using the JPanel object, myPanel
		frame.pack();
		frame.setVisible(true);
	}*/
	
}
