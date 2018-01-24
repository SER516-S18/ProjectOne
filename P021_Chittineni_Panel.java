import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*This code creates a panel and a counter whose values are First name,Last name and a Timer
 * The timer is incremented or decremented based on the parameter passed from the constructor
 * Timer class and its built-in functions are used for displaying the timer(counter).
**@author Salini Chittineni
**@version 01-23-2018
*/

public class P021_Chittineni_Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int par;
	Timer ctr;

	/*
	 * Constructor which takes 'par' as the parameter value and calls the method
	 * 'panelTimer' which sets the background color and counter values accordingly.
	 */

	public P021_Chittineni_Panel(int par) throws HeadlessException {
		// super();
		this.par = par;
		panelTimer();
	}

	@SuppressWarnings("finally")

	/*
	 * This method sets the text for name label and counter label. A parameter is
	 * passed through the constructor. If even, panel should be white in color and
	 * counter needs to be incremented from 0 to 9 If odd, panel should be in light
	 * blue color and needs to be decremented from 9 to 0. Used Timer class to
	 * achieve the functionality.
	 */

	public JPanel panelTimer() {
		JPanel pnl = new JPanel();
		Box box = Box.createVerticalBox(); 
		add(box);

		JLabel lbl = new JLabel("<HTML> Salini <br> Chittineni </HTML>", JLabel.CENTER);
		lbl.setFont(new Font("Papyrus", Font.PLAIN, 13));
		box.add(lbl);

		JLabel lbl2 = new JLabel();
		Color lightblue; 
		lightblue = new Color(173, 216, 230); 

		try {

			if (par % 2 == 0) 
			{
				ctr = new Timer(1000, new ActionListener()
															
				{
					private int timerCount = 0;

					public void actionPerformed(ActionEvent event) {
						lbl2.setText("                " + timerCount++ + "      ");
						if (timerCount > 9) {
							timerCount = 0; 
							ctr.start(); 

						}
					}

				});
				ctr.start();
				lbl2.setVerticalAlignment(JLabel.CENTER);
				pnl.setBackground(Color.white); 
			}

			else 
			{
				ctr = new Timer(1000, new ActionListener() 
															
				{
					private int timerCount = 9;

					public void actionPerformed(ActionEvent event) {

						lbl2.setText("                 " + timerCount-- + "          ");
						if (timerCount < 0) {
							timerCount = 9; 
							ctr.start(); 

						}
					}

				});
				ctr.start();
				lbl2.setHorizontalAlignment(JLabel.RIGHT);
				pnl.setBackground(lightblue); 
			}
		}

		catch (Exception e) {
			System.out.println("Exception occurred:" + e);
		}

		finally {
			box.add(lbl); 
			box.add(lbl2);
			pnl.add(box); 
			pnl.setSize(100, 100);
			pnl.setLayout(new GridLayout());
			pnl.setVisible(true);
			return pnl;
		}
	}

	/*
	 * public static void main(String args[])
	 * 
	 * { JFrame frame = new JFrame(); final long serialVersionUID = 1L;
	 * P021_Chittineni_Panel panel1 = new P021_Chittineni_Panel(21);
	 * frame.add(panel1.panelTimer()); //Adding Panel to Frame
	 * frame.setTitle("Panel and Timer"); frame.setSize(100,100);
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setVisible(true);
	 * frame.setLocationRelativeTo(null); }
	 */
}
