import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;


/**
 * This class implements the panel with 3 Labels- First Name, Last Name and a timer 
 * increasing and decreasing and the background color of the label changing 
 * depending upon the input value provided.
 * 
 * Completion Time: 3 hours
 * 
 * @author Shirisha Kakarla
 * @version 1/23/2018
 */


public class P047_Kakarla_Panel extends JPanel {
	
	private JLabel firstname; 
	private JLabel lastname;
	private JLabel count;
	private boolean even;
	Color lightBlue = new Color(189,214,238);
	
	/* params: integer 
	 * return: None
	 * Description: @para value is set to true if value is even otherwise to false.
	 */
	
	public P047_Kakarla_Panel(int value) {
		
		if(value%2==0)
		{
			even=true;
		}
		else
		{
			even=false;
		}
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		if(even==true)
		{
			this.setBackground(Color.white);
		}
		else
		{
			this.setBackground(lightBlue);
		}
		
		this.setPreferredSize(new Dimension(100,100));
		this.setMaximumSize( this.getPreferredSize() );
		
		//setting up JLabel for firstname and lastname in 2 different lines.
		this.firstname=new JLabel(" Venkat Sai Shirisha");
		this.lastname= new JLabel(" Kakarla");
		this.firstname.setFont(new Font("Papyrus",Font.PLAIN,15));
		this.lastname.setFont(new Font("Papyrus",Font.PLAIN,15));
		
		//setting up the JLabel for the Timer.
		this.count=new JLabel();
		this.count.setFont(new Font("Papyrus",Font.PLAIN,15));
		
		this.add(firstname);
		this.add(lastname);
		this.add(count);
		this.setVisible(true);
		
		
		//setting up counter,if input is even it is increasing. 
		if(even==true) 
			P047_Kakarla_CounterIncrement();
		else
			P047_Kakarla_CounterDecrement();
	}
	
	/* params: None 
	 * return: Void. 
	 * Description: Thread starts and increases the counter from 0-9
	 */
	
	public void P047_Kakarla_CounterIncrement() {
		
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
	
	/* params: None 
	 * return: Void 
	 * Description: Thread starts and decreases the counter from 9-0
	 */
	
	public void P047_Kakarla_CounterDecrement() {
		
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
}
