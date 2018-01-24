
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
 * Lab1
 * @author Mohan Vasantrao Yadav
 * It displays a panel with Mohan as first name on the first row
 * and Vasantrao Yadav as last name on the second row.
 * There is a counter variable which is displayed in the third row
 * and background color is set to white when input is even
 * and light blue if it is odd.
 *
 *
 */

public class P117_VasantraoYadav_Panel extends JPanel{
	
	int fwd=0; 
	int bwd=1; 
	
	
	GridBagConstraints abc = new GridBagConstraints();
	Font s_font=new Font("Papyrus",Font.PLAIN,15);
	Color s_color= new Color(173,216,230);
	
	/*Constructor is created.
	 *Based on checkvalue variable if it is even then background is set white and countforward method is executed.
	 *Countforward method will increment and display the counter.
	 *Orelse background is set light blue and countbackward function is executed.
	 *Countbackward function will decrement and display the counter.
	*/
	
	public P117_VasantraoYadav_Panel(int checkvalue) 
	{
		
		setLayout(new GridBagLayout());
		abc.weightx = 1.0;
		abc.weighty = 1.0;
		abc.fill = GridBagConstraints.BOTH;
		abc.gridx=1;
		abc.gridy=1;
		JLabel fname = new JLabel("Mohan",JLabel.CENTER);
		JLabel lname= new JLabel("Vasantrao Yadav",JLabel.CENTER);
		fname.setFont(s_font);
		lname.setFont(s_font);
		addAtPosition(fname,0,0);
		addAtPosition(lname,0,1);
		if(checkvalue%2==0)
		{
			this.setBackground(Color.white);
			countforward();
		
		}
		else 
		{
			this.setBackground(s_color);
			countbackward();
		}
		setVisible(true);
	}

	void countforward()
	{
		Thread thread = new Thread(new Runnable()
		{
			@Override
			public void run() 
			{
				JLabel counter = new JLabel(new Integer(fwd).toString());
				counter.setHorizontalAlignment(JLabel.CENTER);
				counter.setFont(s_font);
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
		abc.gridx=x;
		abc.gridy=y;
		add(component,abc);
	}
	


}
