import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Vaishak Ramesh Vellore
 * @date 01/21/2018
 * @description A Panel class for SER516 project.
 *
 * Class Extends JPanel and contains author's name and a Counter. It contains one parameterized constructor
 * that accepts an integer value.
 * Panel background is set to WHITE (255,255,255) if value is even or LIGTH BLUE (173,216,230) if odd.
 * Counter increments from 0-9 if value is even or decrements from 9-0 if odd.
*/ 

public class P094_Vellore_Panel extends JPanel{ 
	
	//Initializing panel and count label
	private JLabel name = new JLabel("<html>Vaishak<br>Vellore</html>");
	private JLabel timer= new JLabel();
	private boolean var;
	
	
	public enum newColors{
        LIGHTBLUE(new Color(173,216,230)), WHITE(Color.WHITE);
        private Color color;
        private newColors(Color color)
        {
            this.color=color;
        }
        public Color setColor() {
            return color;
        }
    }
	
	
	//Constructor for the class
	public P094_Vellore_Panel(int num) {
		/* A parameter is sent to the constructor and if this number is even then it is set to true*/
		if(num%2==0)
			var=true;
		else
			var=false;
		
		
		//checks if number passed is true or false and performs the following actions
		if(var==false)
			setBackground(newColors.LIGHTBLUE.setColor());
		else
			setBackground(newColors.WHITE.setColor());
		
		
		//setting the size of the panel x,y axis
		setLayout(new BorderLayout());
		setSize(100,100);
		
		
		//Resetting the font and alignment for both the variables
		Font font = new Font("Papyrus", Font.PLAIN, 15);
		name.setFont(font);
		timer.setFont(font);		
		name.setHorizontalAlignment(JLabel.CENTER);
	    timer.setHorizontalAlignment(JLabel.CENTER);
	    
		
	    //adding labels to the panel
		add(BorderLayout.NORTH,name);
		add(timer);
		setVisible(true);
		
		
		//method call for the timer
		counter();
		
	}// end of constructor
	
	
	//setting up counter.
	public void counter() {
		if(var==true) 
			timerIncrement();
		else
			timerDecrement();
	}
	
		
	public void timerIncrement() {
		/* Start the thread and run from 0-9 */
		new Thread() {
	        int counter = 0;
	        public void run() {
	            while(true) {
	            	if(counter==10)
	            		counter=0;	
	            	
	                timer.setText(" " +counter++);
	                try{
	                    Thread.sleep(1000);
	                } 
	                catch(Exception e) {}
	            }
	        }
	    }.start();
	}
	
	
	public void timerDecrement() {
		/* Start the thread and run from 9-0 */
		new Thread() {
	        int counter = 9;
	        public void run() {
	            while(true) {
	            	if(counter==-1)
	            			counter=9;
	            	
	            	timer.setText(" " +counter--);
	                try{
	                	Thread.sleep(1000);
	                } 
	                catch(Exception e) {}
	            }
	        }
	    }.start();
	} 
}//end of class