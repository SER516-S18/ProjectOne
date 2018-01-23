import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
* SER 516 - Lab 1
* @author Hari Siddarth Velaudampalayam Kesavan
* @version 1.0
* P118_VelaudampalayamKesavan_Panel is a Panel
* First row has the First Name
* Second row has the Last Name
* Last row has counter that either increases or decreases through 0 to 9
* The background color and the counter direction is decided based on a parameter passed to the constructor
*/

public class P118_VelaudampalayamKesavan_Panel extends JPanel{

	private Color bgWhite = Color.WHITE;
	private Color bgLBlue = new Color (173,216,230);
	private JLabel fName = new JLabel("Hari Siddarth");
	private JLabel lName = new JLabel("V Kesavan");
	private JLabel time = new JLabel();
	
	/**
	* Class Constructor
	* @param bgcolor decides the background color and counter direction based on its property ( odd or even)
	* Odd: Light Blue background and counter counts from 9 to 0
	* Even: White background and counter counts from 0 to 9
	*/
	
	public P118_VelaudampalayamKesavan_Panel(int bgcolor) {
		
		if(bgcolor % 2 == 0) {
			this.setBackground(bgWhite);
			incrementCounter();
		}
			
		else {
			this.setBackground(bgLBlue);
			decrementCounter();
		}
		
		this.setLayout(new GridLayout(3,1));
			
		Font font = new Font("Papyrus", Font.PLAIN, 15);
			
		fName.setFont(font);
		lName.setFont(font);
		time.setFont(font);
			
		fName.setHorizontalAlignment(SwingConstants.CENTER);
		lName.setHorizontalAlignment(SwingConstants.CENTER);
		time.setHorizontalAlignment(SwingConstants.CENTER);
			
		this.setBounds(0, 0, 100, 100);
		this.add(fName);
		this.add(lName);
		this.add(time);
		this.setVisible(true);
	}
		
	public void incrementCounter() {
		new Thread() {
			int counter = 0;
			public void run() {
				while(true) {
					if(counter == 10) {
						counter = 0;
					}
					time.setText(new Integer(counter).toString());
					counter++;
					
					try {
						Thread.sleep(1000);
					}catch(Exception e) {}
					}
				}
			}.start();
		}
		
		public void decrementCounter() {
			new Thread() {
				int counter = 9;
				public void run() {
					while(true) {
						if(counter == -1) {
							counter = 9;
						}
						time.setText(new Integer(counter).toString());
						counter--;
						try {
							Thread.sleep(1000);
						}catch(Exception e) {
						e.printStackTrace();
						}
					}
				}
			}.start();
		}
}
