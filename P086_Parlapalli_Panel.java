/* 
 * ASSIGNMENT : LAB-1
 * AUTHOR     : SUMAN PARLAPALLI
 * DESC       : This program is about creating a Jpanel which automatically changes the background and count from white and 0 while the input integer is even and blue and from 9 to 0 whne the integer is odd.
*/ 

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class P086_Parlapalli_Panel {
	/*
	 This class receives an integer as a input and according to the integer it automatically updates the background  to white while it is even
  	 and to blue while it is odd and the count increases from 0 to 9 when it is even and from 9 to 0 when it is odd.
	 */
	private JPanel panel;
	private JLabel firstName;
	private JLabel lastName;
	private JLabel count;
	Color background;
	int input = 1;
	
	public P086_Parlapalli_Panel(int nbr){
		if ((nbr & 1) == 0)
	// checks whether the input is even or odd number
		{
			background = Color.WHITE;
			input = 0; // input is set to 0
		}
		else 
		{
			background = new Color(173,216,230);
		}
	}
	
	// method to create first name , last name and counter labels
	public JPanel parlapalli_Panel(){
		//Panel Setup
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		panel.setPreferredSize(new Dimension(100,100));
		panel.setMaximumSize(panel.getPreferredSize());
		firstName = new JLabel("Suman");
		lastName = new JLabel("Parlapalli");
		count = new JLabel();
		firstName.setAlignmentX(Component.CENTER_ALIGNMENT);
		lastName.setAlignmentX( Component.CENTER_ALIGNMENT);	
		count.setAlignmentX( Component.CENTER_ALIGNMENT);
		panel.add(firstName,Component.CENTER_ALIGNMENT);
		panel.add(lastName, Component.CENTER_ALIGNMENT);
		panel.add(count,Component.CENTER_ALIGNMENT);
		firstName.setFont(new Font("Papyrus",Font.PLAIN,15));
		lastName.setFont(new Font("Papyrus",Font.PLAIN,15));
		count.setFont(new Font("Papyrus",Font.PLAIN,15));
		panel.setVisible(true);
		panel.setBackground(background); 
		if (input==0)
			parlapalli_increment();
		else
			parlapalli_decrement();
		return panel;
	}
	
	// if the input is even, it increments from 0 to 9
	public void parlapalli_increment()
	{
		new Thread()
		{
			int counter =0;
			public void run(){
				while(true){
					if (counter==10)
						counter = 0;
				count.setText(" "+(counter));
				counter++;
				try{
					Thread.sleep(1000);
				}catch (Exception e){
				}
			}
		}
		}.start();
	}
	
	// if the input is odd, it decrements from 9 t0 0
	public void parlapalli_decrement()
	{
		new Thread()
		{
			int counter = 9;
			public void run()
			{
				while (true)
				{
					if (counter == -1)
						counter = 9;
					count.setText(" " + (counter));
					counter--;
					try
					{
						Thread.sleep(1000);	
					}
					catch(Exception e){	
					}
				}
			}
		}.start();
	}
	
	// Program starts from the main
	/*public static void main(String[] args)
	{
		int id = 86;
		P086_Parlapalli_Panel obj = new P086_Parlapalli_Panel(id);
		JFrame frame = new JFrame("Test Main");
		frame.setVisible(true);
		frame.setSize(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = obj.parlapalli_Panel();
		frame.add(p);
	}
	*/

}
