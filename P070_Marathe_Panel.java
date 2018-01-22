import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*	This class implements a JPanel (100*100) with three JLabel's: 
		1. First Name		2. Last Name		3. Counter
	Depending upon number passed to the constructor this class gives background color and increasing or decreasing counter.*/
public class P070_Marathe_Panel {
	JPanel panel = null; 			//JPanel object
	private JLabel f_name = null; //JLabel for first name
	private JLabel l_name = null; //JLabel for first name
	private JLabel count;		 //JLabel for counter
	private int counter;
	private boolean even=true;
	
	//constructor with one argument
	public P070_Marathe_Panel(int num) {
		
		if(num %2 != 0)	//number is odd
		{
			even = false;	//set even flag to false
			counter = 9;	//set the counter to decreasing
		}
		else			//number is even
		{
			even = true;	//set even flag
			counter = 0;	//set the increasing counter
		}
	}
	
	//Display function to create a JPanel and return it's object
	public JPanel display(){
		count = new JLabel("",JLabel.CENTER);
		try
		{
		f_name=new JLabel("Abhishek", JLabel.CENTER);
		l_name = new JLabel("Marathe", JLabel.CENTER);
		
		panel = new JPanel();
		}
		catch (Exception e) {
			//handle exception occurred during memory allocation
			System.out.println("Error while allocating memory!!");
			e.printStackTrace();
		}
		//set label's properties
		f_name.setBounds(25, 25, 70, 25);
		f_name.setFont(new Font("Papyrus", Font.PLAIN, 15));
		panel.add(f_name);
		
		l_name.setBounds(25, 40, 60, 25);
		l_name.setFont(new Font("Papyrus", Font.PLAIN, 15));
		panel.add(l_name);
		
		count.setBounds(25, 55, 60, 25);
		count.setFont(new Font("Papyrus", Font.PLAIN, 15));
		panel.add(count);
		
		panel.setSize(100, 100);
		panel.setLayout(null);
		
		//set background according to the even flag
		if(even)
		{
			panel.setBackground(Color.white);
		}
		else
		{
			panel.setBackground(new Color(173,216,230));
		}
		
		//create a timer to increase or decrease counter per second
		try
		{
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		    @Override
		    public void run() {
		    	if(even)
		    	{
			       if(counter == 10)
			    	   counter =0;
			       count.setText(""+ counter++);
		    	}
		    	else{
		    		if(counter == -1)
		    			counter = 9;
		    		count.setText(""+ counter--);
		    	}
		    }
		}, 0, 1000);
		}
		catch(Exception e)
		{
			System.out.println("Error occured with timer!");
			e.printStackTrace();
		}
		return panel;	//return JPanel object
	}
	/*public static void main(String[] args) {
		P070_Marathe_Panel pan = new P070_Marathe_Panel(2);
		JPanel panel  = pan.display();
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setLayout(null);
	}*/
}
