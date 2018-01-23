import java.awt.*;
import javax.swing.*;

/**
 * SER: 516(SOFTWARE AGILITY)
 * P010_Bhat_Panel implements assignment one. A panel has two labels-
 * one that displays my full name, and the other that displays a counter.
 * 
 * @author kritikabhat, ASU ID: kbhat3
 * @since 2018-01-20
 * @param fullName JLabel that contains First and Second Name
 * @param displayNumber JLabel that contains the timer value
 * @param timer an integer to control counter increase/decrease
 * @param controlInteger the parameter passed to constructor
 */

public class P010_Bhat_Panel extends JPanel {
		private JLabel fullName;
		private JLabel displayNumber;
		
		public P010_Bhat_Panel(int controlInteger){
			
			/**
			 * This constructor creates the JPanel, changes the background and sets timer depending
			 * on the value of passed integer- whether it is even or odd.
			 */
		 	
	 		this.setPreferredSize(new Dimension(100,100));
	 		this.setLayout(new GridLayout(2,1));
	 		displayNumber = new JLabel();
	 		fullName = new JLabel("<html>Kritika<br> Bhat</html>");
			fullName.setFont(new Font("Papyrus", Font.PLAIN, 15));
	 		displayNumber.setFont(new Font("Papyrus", Font.PLAIN, 15));
	 		this.add(fullName);
	 		this.add(displayNumber);
	 		fullName.setHorizontalAlignment(JLabel.CENTER);
	 		displayNumber.setHorizontalAlignment(JLabel.CENTER);
	 		this.setVisible(true);	 		
	 		
	 		/** 
	 		 *The background color and counter value are decided here 
	 		 */
	 		
	 		if(controlInteger % 2 == 0) { 
	 			this.setBackground(Color.white);
	 			method_timer(controlInteger);	 			
	 		}
	 		else { 
	 			this.setBackground(new Color(173,216,230));
	 			method_timer(controlInteger);			 	    
	 		}
		}

		private void method_timer(int n){
			
			/**
			 * if the passed integer is even, the timer increments from 0 to 9
			 */
			
			if(n % 2 == 0) { 
				new Thread() {
			        int timer = 0;
			        public void run() {
			            while(true) {
			            		if(timer == 10) timer = 0;
			            	displayNumber.setText("" + (timer));
			                timer++;
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			        }
			    }.start();
			}
			
			/**
			 * If the passed integer is odd, the timer decrements from 9 to 0
			 */
			
			else { 
				new Thread() {
			        int timer = 9;
			        public void run() {
			            while(true) {
			            		if(timer == -1) timer = 9;
			                displayNumber.setText("" + (timer));
			                timer--;
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			        }
			    }.start();
			}
		}
		
		
		/**
		 * The main method was used for testing only.
		 * 
		 * @param args command line arguments
		 *  
		public static void main(String[] args) {
			
			//creating the panel
			P010_Bhat_Panel p = new P010_Bhat_Panel(6);
			JFrame f = new JFrame();
			
			//just style for JFrame for testing
			f.getContentPane().add(p);
			f.pack();
			f.setVisible(true);
			f.setSize(800,800);
			f.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 90));
			
			//testing to make sure threads are working properly
			System.out.print("Testing");
		}
		*/
}
