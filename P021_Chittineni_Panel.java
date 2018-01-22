package pkg;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class P021_Chittineni_Panel extends JPanel {
	int par; // parameter from main method
	Timer ctr; // creating an object for 'Timer' class

	public P021_Chittineni_Panel(int par) throws HeadlessException {
		// super();
		this.par = par;
		panelTimer();
	}

	@SuppressWarnings("finally")

	public JPanel panelTimer() {
		JPanel pnl = new JPanel();
		JLabel lbl = new JLabel();
		JLabel lbl2 = new JLabel();

		Box box = Box.createVerticalBox(); // Box creation to display Label1 and Label2 in a vertical line
		Color lightblue; // Declared a color name for which initialization is in the code below
		lightblue = new Color(173, 216, 230); // initializing the color to a desired one
		Border brdr = BorderFactory.createLineBorder(Color.BLACK, 1);

		pnl.setBorder(brdr); // setting the border for the panel
		lbl.setText("<HTML> Salini <br> Chittineni</HTML>"); // setting text for Label; HTML tags are used to display
																// multi line text
		lbl.setBorder(brdr);
		lbl.setFont(new Font("Papyrus", Font.BOLD, 10));

		try {

			if (par % 2 == 0) // checks if the parameter passed is even
			{
				ctr = new Timer(500, new ActionListener() // Creating ActionListener event handler with actionPerformed
															// method
				{
					private int timerCount = 0;

					public void actionPerformed(ActionEvent event) {
						lbl2.setText("    " + timerCount++ + "    ");
						if (timerCount > 9) {
							ctr.stop(); // Stopping the counter once it has reached 10
							timerCount = 0; // Resetting it to 0; as the timer needs to run back from 0 to 9
							ctr.restart(); // Restarting the counter

						}
					}

				});
				ctr.start();
				lbl2.setBorder(brdr);
				lbl2.setHorizontalAlignment(JLabel.RIGHT);
				pnl.setBackground(Color.white); // parameter passed is even; setting the background color to 'White'
			}

			else // checks if the parameter passed is even
			{
				ctr = new Timer(500, new ActionListener() // Creating ActionListener event handler with actionPerformed
															// method
				{
					private int timerCount = 9;

					public void actionPerformed(ActionEvent event) {

						lbl2.setText("    " + timerCount-- + "    ");
						if (timerCount < 0) {
							ctr.stop(); // Stopping the counter once it has reached -1
							timerCount = 9; // Resetting it to 9; as the timer needs to run back from 9 to 0
							ctr.restart(); // Restarting the counter

						}
					}

				});
				ctr.start();
				lbl2.setBorder(brdr);
				lbl2.setHorizontalAlignment(JLabel.RIGHT);
				pnl.setBackground(lightblue); // parameter passed is odd; setting the background color to 'light blue'
			}
		}

		catch (Exception e) {
			System.out.println("Exception occurred:" + e);
		}

		finally {
			box.add(lbl); // Adding labels onto Box
			box.add(lbl2);
			pnl.add(box); // Adding box onto Panel
			pnl.setSize(100, 100);
			pnl.setLayout(new GridLayout());
			pnl.setVisible(true);

			return pnl;
		}
	}

	public static void main(String args[]) 
	{
		JFrame frame = new JFrame();
		final long serialVersionUID = 1L;
		P021_Chittineni_Panel panel1 = new P021_Chittineni_Panel(21);
		frame.add(panel1.panelTimer()); // Adding Panel to Frame
		frame.setTitle("Panel and Timer");
		frame.setSize(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

}
