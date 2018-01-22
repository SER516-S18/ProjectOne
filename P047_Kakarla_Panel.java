/**
 * This class implements the panel with 3 Labels- First Name, Last Name and a timer increasing and decreasing
 * and the background color of the label changing depending upon the input provided.
 * 
 * Completion Time: 3 hours
 * 
 * @author Shirisha Kakarla
 * @version 1/21/2018
 */

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class P047_Kakarla_Panel {
	
	private JPanel p;
	
	private JLabel firstname; 
	private JLabel lastname;
	
	private JLabel count;
	
	private boolean even;
	
	//constructor.
	public P047_Kakarla_Panel(int n) {
		/* params: integer 
		 * return: None
		 * Description: @para n is set to true if n is even otherwise to false.
		 */
		if(n%2==0)
		{
			even=true;
		}
		else
		{
			even=false;
		}
	}

	public JPanel P047_Kakarla_Panel() {
		/* params: None
		 * return: JPanel object 
		 * Description: Populates JPanel with three JLabels arranged in Y_axis.
		 */
		
		//setting up JPanel and its color to either white or blue based upon input.
		p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		if(even==true)
		{
			p.setBackground(Color.white);
		}
		else
		{
			p.setBackground(new Color(51,204,255));
		}
		
		p.setPreferredSize(new Dimension(100,100));
		p.setMaximumSize( p.getPreferredSize() );
		
		//setting up JLabel for firstname and lastname in 2 different lines.
		firstname=new JLabel(" Venkat Sai Shirisha");
		lastname= new JLabel(" Kakarla");
		
		//setting up the JLabel for the Timer.
		count=new JLabel();
		
		p.add(firstname);
		p.add(lastname);
		p.add(count);
		p.setVisible(true);
		
		
		//setting up counter,if input is even it is increasing. 
		if(even==true) 
			P047_Kakarla_CounterIncrement();
		else
			P047_Kakarla_CounterDecrement();
		
		return p;
	}
	
	
	public void P047_Kakarla_CounterIncrement() {
		/* params: None 
		 * return: Void. 
		 * Description: Thread starts and increases from 0-9
		 */
		new Thread() {
	        int counter = 0;
	        public void run() {
	            while(true) {
	            		if(counter==10)
	            			counter=0;
	            		
	                count.setText(" " + (counter));
	                counter++;
	                try{
	                    Thread.sleep(1000);
	                } catch(Exception e) {}
	            }
	        }
	    }.start();
	} 
	
	
	public void P047_Kakarla_CounterDecrement() {
		/* params: None 
		 * return: Void 
		 * Description: Thread starts and decreases from 9-0
		 */
		new Thread() {
	        int counter = 9;
	        public void run() {
	            while(true) {
	            		if(counter==-1)
	            			counter=9;
	                count.setText(" " + (counter));
	                counter--;
	                try{
	                    Thread.sleep(1000);
	                } catch(Exception e) {}
	            }
	        }
	    }.start();
	} 
	
	//For testing purpose this class was created.
	public static void main(String[] args) {
		/*
		 * params: None 
		 * return: None. 
		 * Description: To test. 
		 */
		
		P047_Kakarla_Panel ob= new P047_Kakarla_Panel(3);
		JPanel p=ob.P047_Kakarla_Panel();
		JFrame f=new JFrame("Simple Window");
		//f.setSize(800,800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(p);
		f.pack();
		//f.add(p);
		f.setVisible(true);
	}
}

