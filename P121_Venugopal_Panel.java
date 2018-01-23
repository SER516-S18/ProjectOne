
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
*
* @author Prasanth Venugopal (ASU: pvenugo1)
* @version 1.0.0 (01/21/2018)
* @purpose This class is a Jpanel consisting of Name (First Name, Last Name )along with counter and background value based on Parameter
*/

class P121_Venugopal_Panel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel count=new JLabel();
	JPanel panel =new JPanel();
    
	public P121_Venugopal_Panel(int num) {
		/* This is a constructor
		 * @param num
		 */
		setAlignment();
		if(num%2 == 0)
		{
			/*
			 * If num is even , Background is set to white, counter is increased from 0 to 9 and place in a continues loop
			 */
			setBackground(Color.white);
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
			setBackground(new Color(173,216,230));
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

	public void setAlignment() {
		/*
		 * Output: Alignement purposes , Sets Gridlayout 
		 */
		setLayout(new GridLayout(2,1));
		setPreferredSize(new Dimension(100,100));
		JLabel name=new JLabel("<html> Prasanth <br> Venugopal <br> </html>");
		// 2 Lines in 1 Jlabel
		name.setHorizontalAlignment(JLabel.CENTER);
		count.setHorizontalAlignment(JLabel.CENTER);
		count.setFont(new Font("Papyrus", Font.PLAIN, 15));
                name.setFont(new Font("Papyrus", Font.PLAIN, 15));
		add(name);
	        add(count);
	}
		
	public static void main(String[] args) {
		
		/*
		 * Main Method to test the JPanel
	
		JFrame f=new JFrame("Simple Window");
		f.setLayout(new GridLayout());
		f.setLocationRelativeTo( null );
		f.getContentPane().add(new P121_Venugopal_Panel(5));
		f.pack();
		f.setVisible(true);
		*/
		
	}
}
