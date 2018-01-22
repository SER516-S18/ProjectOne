import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
*
* @author Prasanth Venugopal (ASU: pvenugo1)
* @version 1.0.0 (01/21/2018)
* @purpose This class is a Jpanel consisting of Name (First Name, Last Name )along with counter and background value based on Parameter
*/

class P121_Venugopal_Panel{
	JLabel count=new JLabel();
	JPanel panel =new JPanel();
	public P121_Venugopal_Panel(int num) {
		/* This is a constructor
		 * @param num
		 */
		if(num%2 == 0)
		{
			/*
			 * If num is even , Background is set to white, counter is increased from 0 to 9 and place in a continues loop
			 */
			panel.setBackground(Color.white);
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
			
		else
		{
			/*
			 * If num is even , Background is set to Blue , counter is Decreased from 9 to 0 and place in a continues loop 
			 */
			panel.setBackground(new Color(173,216,230));
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

	public JPanel P121_panel() {
		/*
		 * Output: Returns a JPanel Object after initialization
		 */
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setPreferredSize(new Dimension(100,100));
		panel.setMaximumSize( panel.getPreferredSize() );
		JLabel name=new JLabel("<html> Prasanth <br> Venugopal </html>");
		panel.add(name);
		panel.add(count);
		panel.setVisible(true);
		return panel;
	}
		
	public static void main(String[] args) {
		
		/*
		 * Main Method to test the JPanel
		 */

		P121_Venugopal_Panel ob= new P121_Venugopal_Panel(5);
		JPanel panel =ob.P121_panel();
		JFrame f=new JFrame("Simple Window");
		f.add(panel);
		f.pack();
		f.setVisible(true);
	}
}
