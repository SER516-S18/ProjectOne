import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class P057_Kolla_Panel extends JPanel  {



	int counter;
	JLabel c = new JLabel();
	
	/* Constructor to input even or odd integer
	 * changes color and counter accordingly
	 */
	
	public P057_Kolla_Panel(final int input)

	{

		JLabel l= null;
		
		this.setSize(100, 100);  //used to set panel size
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		if(input%2 == 0) {
			counter = 0;
			this.setBackground(Color.WHITE); //even for white 
		} else {
			counter = 9;
			this.setBackground(new Color(173, 216, 230)); //odd for light blue
		}
		l = new JLabel("<html><br>Tarun<br>Kolla</html>", JLabel.CENTER); 
                l.setAlignmentX(Component.CENTER_ALIGNMENT);
		/*Font type, style and size*/

		Font font = new Font("Papyrus", Font.PLAIN, 15);
		l.setFont(font);

		Timer timer = new Timer(1000, new ActionListener() { //timer class 

			//@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(input%2 == 0) {
					c.setText(String.valueOf(counter)); //increment for even 
					c.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                                        counter++;
					if(counter>9) {
						counter = 0;
					}
					
				} else {
					c.setText(String.valueOf(counter)); // decrement for odd
					c.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                                        counter--;
					if(counter < 0) {
						counter = 9;
					}
					
				}
			}
		});
		timer.start();
		this.add(l);
		this.add(c);
		

	}

	/* main class that calls the constructor with an even or odd value */

	/*public static void main(String[] args) throws InterruptedException {
		//P057_Kolla_Panel panel = new P057_Kolla_Panel(1);
	    P057_Kolla_Panel panel = new P057_Kolla_Panel(2);
		JFrame f = new JFrame("test");
		f.add(panel);
		f.setVisible(true);
		f.setSize(500, 500);
		//f.setLayout(new GridLayout(0,1));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/

}