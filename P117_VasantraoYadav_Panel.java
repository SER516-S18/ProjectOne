
import java.awt.*; 

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 * SER516 - Lab1
 * @author Mohan Vasantrao Yadav
 * It displays a panel with Mohan as first name
 * and Vasantrao Yadav as last name.
 * There is a counter variable which is displayed in the third row
 * and background color is set to white when input is even
 * and light blue if it is odd.
 *
 *
 */

public class P117_VasantraoYadav_Panel extends JPanel{
	
	int fwd=0; /* Intialize forward variable*/
	int bwd=1; /*Intialize counter variable*/
	
	
	GridBagConstraints abc = new GridBagConstraints();
	
	public P117_VasantraoYadav_Panel(int checkvalue) 
	{
		
	/* Panel Layout which consists of firstname, lastname and counter*/
		setLayout(new GridBagLayout());
		abc.weightx = 1.0;
		abc.weighty = 1.0;
		abc.fill = GridBagConstraints.BOTH;
		abc.gridx=1;
		abc.gridy=1;
		JLabel fname = new JLabel("Mohan",JLabel.CENTER);
		JLabel lname= new JLabel("Vasantrao Yadav",JLabel.CENTER);
		fname.setFont(new Font("Papyrus",Font.PLAIN,15));
		lname.setFont(new Font("Papyrus",Font.PLAIN,15));
		addAtPosition(fname,0,0);/* Positioning first name in first row*/
		addAtPosition(lname,0,1);/*Positioning last name in second row*/
	
		if(checkvalue%2==0) /*Checking if input is even*/
		{
			this.setBackground(Color.white);/* Set background white*/
			countforward();/*Call the forward function*/
		
		}
		else /* Input is odd*/
		{
			this.setBackground(new Color(90,150,255));/*Set backgroung light blue*/
			countbackward();/*Call the backward function*/
		}
	
		setVisible(true);
	
	}

	void countforward()
	{
		/*Increment the counter by 1*/
		Thread thread = new Thread(new Runnable()
		{
			@Override
			public void run() 
			{
				JLabel counter = new JLabel(new Integer(fwd).toString());
				counter.setHorizontalAlignment(JLabel.CENTER);
				counter.setFont(new Font("Papyrus", Font.PLAIN,15));
				addAtPosition(counter,0,2);
				while(true) 
				{
					try 
					{
						Thread.sleep(1000);
					}
					catch(InterruptedException e)
					{
						System.err.println(e.toString());
					}
					fwd=fwd+bwd;
					counter.setText(new Integer(Math.abs(fwd%10)).toString());
				}
			}
		});
		thread.start();
	}
	
	void countbackward()
	{
		/*Decrement the counter by 1*/
		fwd=9;
		bwd=-1;
		Thread thread = new Thread(new Runnable() 
		{
			@Override
			public void run() 
			{	
				JLabel counter = new JLabel(new Integer(fwd).toString());
				counter.setHorizontalAlignment(JLabel.CENTER);
				counter.setFont(new Font("Papyrus", Font.BOLD,14));
				addAtPosition(counter,0,2);
				while(true) 
				{
					try 
					{
						Thread.sleep(1000);
					}
					catch(InterruptedException e) 
					{
						System.err.println(e.toString());
					}
					fwd=fwd+bwd;
					if(fwd==-1)
					{
						fwd=9;
					}	
					counter.setText(new Integer(Math.abs(fwd)).toString());
				}
		}
	});
	thread.start();
	}

	void addAtPosition(Component component, int x,int y)
	{
		/*Assigning the grid values*/
		abc.gridx=x;
		abc.gridy=y;
		add(component,abc);
	}
	


}
