import java.awt.*;
import javax.swing.*;

/**
 * SER: 516(SOFTWARE AGILITY)
 * P010_Bhat_Panel implements assignment one. A panel has two labels-
 * one that displays my full name, and the other that displays a counter.
 * fullName: JLabel that contains First and Second Name
 * displayNumber: JLabel that contains the timer value
 * <P>
 * @author kritikabhat, ASU ID: kbhat3
 * @since 2018-01-20
 */
public class P010_Bhat_Panel extends JPanel {
		private JLabel fullName;
		private JLabel displayNumber;
		
		/**
		 * This constructor creates the JPanel, changes the background
		 * and calls methodTimer method that sets timer depending
		 * on the value of passed integer- whether it is even or odd.
		 * @param controlInteger Integer passed to constructor
		 */
		public P010_Bhat_Panel(int controlInteger){
			
			this.setPreferredSize(new Dimension(100,100));
 			this.setLayout(new GridLayout(2,1));
 			this.setVisible(true);	 		
 			fullName = new JLabel("<html>Kritika<br> Bhat</html>");
 			fullName.setFont(new Font("Papyrus", Font.PLAIN, 15));
 			fullName.setHorizontalAlignment(JLabel.CENTER);
	 		this.add(fullName);
	 		displayNumber = new JLabel();
			displayNumber.setFont(new Font("Papyrus", Font.PLAIN, 15));
			displayNumber.setHorizontalAlignment(JLabel.CENTER);
			this.add(displayNumber);
			 		
	 		/** 
	 		 *The background color and counter value are decided here 
	 		 */
	 		if(controlInteger % 2 == 0) { 
	 			this.setBackground(Color.white);
	 			methodTimer(controlInteger);	 			
	 		}
	 		else { 
	 			this.setBackground(new Color(173,216,230));
	 			methodTimer(controlInteger);			 	    
	 		}
		}
		
		/**
		 * methodTimer method includes the logic which decides the value
		 * of the timer displayed on the panel
		 * @param timer Integer value passed from constructor
		 */
		private void methodTimer(int timer){
			
			/**
			 * If the integer is even, the timer increments from 0 to 9
			*/
			if(timer % 2 == 0) { 
				new Thread() {
			        int timer = 0;
			        public void run() {
			            while(true) {
			            		if(timer == 10) timer = 0;
			            	displayNumber.setText("" + (timer));
			                timer++;
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {
			                	System.out.println("Exception: "
			                			+ "methodTimer- even case");
			                }
			            }
			        }
			    }.start();
			}
			
			/**
			 * If the integer is odd, the timer decrements from 9 to 0
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
			                } catch(Exception e) {
			                	System.out.println("Exception: "
			                			+ "methodTimer- odd case");
			                }
			            }
			        }
			    }.start();
			}
		}
}
