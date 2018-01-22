/* 
 * LAB I - Project
 * AUTHOR: Venkata Akhil Madaraju
 * DESC : A Main Frame consisting of 5 Tabs in it which 
 * in turn has 25 Panels (5*5) one for each student
*/ 

import java.awt.*;
import javax.swing.*;


public class P064_Madaraju_Panel {
	/*
	 * Class implements a panel  with FirstName, LastName and a counter, 
	 * counter displaying numbers, also a constructor which receives an integer value.
	 * if the value is Even, background is White and the counter increases
	 */
	private JPanel panel;
	private JLabel firstName;
	private JLabel lastName;
	private JLabel count;
	Color bgcolor;
	int flag = 1;
	
	/*
	 * Constructor which takes an integer as input based on which 
	 * background color is decided
	 */
	public P064_Madaraju_Panel(int val){
		//if condition to check if the value received is odd or even
		if (val%2 == 0)
		{
			bgcolor = Color.WHITE;
			flag = 0;
		}
		else 
		{
			bgcolor = new Color(173,216,230);
		}
	}
	
	//Function to create three labels in the panel and return it at end
	public JPanel madaraju_Panel(){
		//Panel Setup
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		panel.setPreferredSize(new Dimension(100,100));
		panel.setMaximumSize(panel.getPreferredSize());
		
		//First Name
		firstName = new JLabel("Venkata Akhil");
		firstName.setFont(new Font("Papyrus",Font.BOLD,10));
		//Last Name
		lastName = new JLabel("Madaraju");
		lastName.setFont(new Font("Papyrus",Font.BOLD,10));
		//Counter Label
		count = new JLabel();
		panel.add(firstName);
		panel.add(lastName);
		panel.add(count);
		panel.setVisible(true);
		panel.setBackground(bgcolor);
		//if loop to increment if the constructor receives even value else decrement 
		if (flag==0)
			madaraju_increment();
		else
			madaraju_decrement();
		return panel;
	}
	
	//Thread to increment values from 0-9 if constructor receives even value
	public void madaraju_increment()
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
	
	//Thread to decrement values from 9-0 if constructor receives odd value
	public void madaraju_decrement()
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
	
	//Main Function to test the panel created
	/*public static void main(String[] args)
	{
		int con = 64;
		P064_Madaraju_Panel obj = new P064_Madaraju_Panel(con);
		JFrame frame = new JFrame("Test Main");
		frame.setVisible(true);
		frame.setSize(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = obj.madaraju_Panel();
		frame.add(p);
	}*/

}
