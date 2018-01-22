import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * SER: 516(SOFTWARE AGILITY)
 * P010_Bhat_Panel implements assignment one. A panel has two labels-
 * one that displays my full name, and the other that displays a counter.
 * @author kritikabhat, ASU ID: kbhat3
 * @version 1.0
 * @since 2018-01-21
 */

public class P010_Bhat_Panel extends JPanel {
		private JLabel fullname;
		private JLabel displaynumber;
		
		public P010_Bhat_Panel(int someinteger){
			
			/**
			 * This constructor creates the JPanel, changes the background and sets timer depending
			 * on the value of passed integer- whether it is even or odd.
			 */
		 
			
	 		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	 		this.setBorder(border);
	 		this.setVisible(true);
	 		
	 		this.setPreferredSize(new Dimension(100,100));
	 		displaynumber = new JLabel();
	 		
	 		fullname = new JLabel("<html>Kritika<br> Bhat</html>");
	 		fullname.setFont(new Font("Papyrus", Font.BOLD, 14));
	 		
	 		this.add(fullname);
	 		this.add(displaynumber);
	 		
	 		this.setLayout(new GridLayout(2,1));
	 		
	 		fullname.setHorizontalAlignment(JLabel.CENTER);
	 		displaynumber.setHorizontalAlignment(JLabel.CENTER);
	 		
	 		if(someinteger%2==0) { //if number passed is even background is white
	 			this.setBackground(Color.white);
	 			method_timer(someinteger);	 			
	 		}
	 		else { //if number passed is odd, background is blue
	 			this.setBackground(new Color(187,255,255));
	 			method_timer(someinteger);			 	    
	 		}
	 		
		}

		private void method_timer(int n){
			
			if(n%2==0) { //if even, counter should increase by 1
				new Thread() {
			        int timer = 0;
			        public void run() {
			            while(true) {
			            		if(timer==10)
			            			timer=0;
			            		
			                displaynumber.setText("" + (timer));
			                timer++;
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			        }
			    }.start();
			}
			else { //if odd, counter should reduce by 1
				new Thread() {
			        int timer = 9;
			        public void run() {
			            while(true) {
			            		if(timer==-1)
			            			timer=9;
			                displaynumber.setText("" + (timer));
			                timer--;
			                try{
			                    Thread.sleep(1000);
			                } catch(Exception e) {}
			            }
			        }
			    }.start();
			}
		}
}
