//Lab1
//Author: Rakesh Mohan
//The class creates a panel with my First Name & Last Name with counter & background changing 
//based on the integer passed to the constructor.

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class P076_Mohan_Panel implements Runnable {

	//Declaring class variables
	int decider;
	JPanel panel = new JPanel();
	JLabel timerLabel = new JLabel("Counter :");
	Thread thread;
	
	//Assigning the integer received to a variable
	public P076_Mohan_Panel(int num){
		decider = num;
	}
	
	//Designing the panel with details
	public void myPanel() {
		
		//lable with first name last name details
		JLabel NameLabel = new JLabel("<html><br>First Name: Rakesh<br>Last Name: Mohan</html>");
		
		//Resetting the font for both the variables
		Font font = new Font("Papyrus", Font.PLAIN, 15);
		NameLabel.setFont(font);
		timerLabel.setFont(font);
		
		NameLabel.setHorizontalAlignment(JLabel.CENTER);
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
	
		//Adding the labels to the panel.
		panel.setLayout(new BorderLayout());	
		panel.setSize(100, 100);
		panel.add(BorderLayout.NORTH, NameLabel);
		panel.add(timerLabel);
	
		//Starting the Thread for the counter.
		this.thread = new Thread(this);
		this.thread.start();
		
	}
	
	//Overriding the run function of the thread to run the counter and modify the panel colour.
	@Override
	public void run() {
		
		//Increment counter & light blue background colour setting if the constructor integer is even
		if (decider % 2 == 0)
		{
			Color lightBlue= new Color(153,180,209);
			panel.setBackground(lightBlue);
			
			do {
				for (int i = 0 ;i < 10; i++)
				{
					try {
					    		Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					timerLabel.setText("Counter :"+Integer.toString(i));
				}
			}while (true);
		}
		//Decrement counter & white background colour setting if the constructor integer is odd
		else
		{
			panel.setBackground(Color.white);
			
			do {
					for (int i = 9 ;i >= 0; i--)
					{
						try {
						    		Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						timerLabel.setText("Counter :"+Integer.toString(i));
					}
					
				}while(true);
		}
	}
	
	//Returns the panel. 
	public JPanel getPanel() {
		
		myPanel();
		return panel;
	}
}
