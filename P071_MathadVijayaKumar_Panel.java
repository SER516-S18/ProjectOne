import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* overview: 
 * This class implements a 100*100 JPanel with three JLabels viz, Firstname, Lastname and 
 * a counter thread which counts 0-9 increment or decrement depending on the number passed to class. 
 * 
 * @author avinash mathad vijayakumar
 */
public class P071_MathadVijayaKumar_Panel extends JPanel {
	
	
	private JLabel firstname; 
	private JLabel lastname;
	private JLabel count;
	private boolean even;
	
	/**
	 * @param num
	 * Description: upon invoking this constructor, it creates a JPanel object. 
	 * note that this class extends JPanel. So by default it has all methods of JPanel.
	 */
	public P071_MathadVijayaKumar_Panel(int num) {
		
		//determining the num is even or odd.
		if(num%2!=0)
			even=false;
		else
			even=true;
		
		//Layout in Y_Axis becoz panels will be added to new line.
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//This is for counter. When a new panel is added to old panel it is displayed at center.
		JPanel helper=new JPanel();
		
		/* Implementing the requirement. 
		 * 173,216,230 is the color co-ordinates for light blue color.
		 */
		
		if(even==false) {//number is odd
			setBackground(new Color(173,216,230));
			helper.setBackground(new Color(173,216,230));
		}
		else {//number is even.
			setBackground(Color.white);
			helper.setBackground(Color.white);
		}
		
		//max size of panel is 100*100.
		setPreferredSize(new Dimension(100,100));
		setMaximumSize( getPreferredSize() );
		
		//setting up JLabel
		firstname=new JLabel("Avinash");
		lastname= new JLabel("Mathad Vijayakumar");
		count=new JLabel();
		firstname.setFont(new Font("Papyrus",Font.PLAIN,15));
		lastname.setFont(new Font("Papyrus",Font.PLAIN,15));
		count.setFont(new Font("Papyrus",Font.PLAIN,15));
		
		//adding every component to main default panel.
		helper.add(count);
		add(firstname);
		add(lastname);
		add(helper);
		setVisible(true);
		
		//setting up counter. 
		if(even==true) 
			P071_Mathad_VijayaKumar_TimerIncrement();
		else
			P071_Mathad_VijayaKumar_TimerDecrement();
	}
	
	/**
	 * This function is for starting a thread which increments 
	 * the timer and prints it in JLabel count.
	 */
	public void P071_Mathad_VijayaKumar_TimerIncrement() {
		
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
	}//end or function. 
	
	/**
	 * This function is for starting a thread which decrements 
	 * the timer and prints it in JLabel count.
	 */
	public void P071_Mathad_VijayaKumar_TimerDecrement() {
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
	}//end or function. 
	
	/**
	 * @param args
	 * This is for testing. In main Panel is added to 
	 * frame and is displayed.
	 */
//	public static void main(String[] args) {
//		
//		JPanel p= new P071_MathadVijayaKumar_Panel(2);
//		JFrame f=new JFrame("Simple Window");
//		//f.setSize(800,800);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.getContentPane().add(p);
//		f.pack();
//		//f.add(p);
//		f.setVisible(true);
//	}
}
