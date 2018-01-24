import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Anusha Chittoor Prem
 * Contains two Jlabels for name and a number used as counter.
 * If the value passed is even, then the background is set to white and the counter increments.
 * If the value passed is odd, then the background is set to blue and the counter decrements. 
 */

public class P022_ChittoorPrem_Panel extends JPanel {
	private JLabel name, number;
	private int counter;
	
	// Constructor with an integer as a parameter.
	public P022_ChittoorPrem_Panel(int num) {
		Font font = new Font("Papyrus", Font.PLAIN, 12);
		setLayout(new GridLayout(2,1));
		//instantiate name and number
		name = new JLabel("<html><center>Anusha<br>Chittoor Prem</center></html>",JLabel.CENTER);
		number = new JLabel();
		//set positions,color and font of name and number and add them to panel.
		name.setHorizontalAlignment(JLabel.CENTER);
		number.setHorizontalAlignment(JLabel.CENTER);
		name.setForeground(Color.black);
		number.setForeground(Color.black);
		name.setFont(font);
		number.setFont(font);
		add(name);
		add(number);
		//if value passed is even
		if(num%2 == 0) {
			this.setBackground(new Color(255,255,255));
			increment();
		}else{ //if value passed is odd
			this.setBackground(new Color(173,216,230));
			decrement();
		}
		//set size of the panel
		this.setPreferredSize(new Dimension(100,100));
		this.setVisible(true);
	}
	
	
	//method to increment the counter by one step
	public void increment() {
		counter = 0;
		new Thread() {
			public void run() {
				while(true) {
					number.setText(""+counter);
					//sets back the counter to 0 when the counter reaches 10
					if(++counter == 10) {
						counter = 0;	
					}
					try {
						//sleeps for 1second. 
						Thread.sleep(1000);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	
	//method to decrement the counter by one step
	public void decrement() {
		counter = 9;
		new Thread() {
			public void run() {
				while(true) {
					number.setText(""+counter);
					//sets back the counter value to 9 when the counter reaches negative value
					if(--counter < 0) {
						counter = 9;	
					}
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	
	//main function for testing
	/*public static void main(String []args) {		
		P022_ChittoorPrem_Panel p = new P022_ChittoorPrem_Panel(22);
		JFrame jframe = new JFrame("Java Applaiction");
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(p);
		jframe.setSize(100,100);
		jframe.setContentPane(mainPanel);
		jframe.setVisible(true);
	}*/

}
