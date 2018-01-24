import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * for SER 516 only
 * @author Shubham Vyas
 * @version 1.0
 */
public class P122_Vyas_Panel extends JPanel{

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 * Declaration of class attributes required for logic.
	 */
	private JPanel panel;
	private boolean flag;
	private static int counter;
	private static final Color LIGHTBLUE = new Color(173, 216, 230);

	public P122_Vyas_Panel(int id) {
		/*
		 * Creating new panel object and setting the size and flag attribute
		 * for appropriate background and timer.
		 */
		panel = new JPanel();
		panel.setSize(100,100);
		if(id%2 == 0) {
			flag = true;
			this.setBackground(Color.WHITE);
		}
		else{
			this.setBackground(LIGHTBLUE);
			flag = false;
		}
		initialize();
	}
	public JPanel initialize() {
		/*
		 * Adding two labels to the panel.
		 * Implementing timer logic for display.
		 */
		setLayout(null);

		JLabel nameLabel = new JLabel("<html><center>Shubham<br>Vyas</center></html>");
		nameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
		nameLabel.setBounds(10, 10, 60, 38);
		add(nameLabel);

		JLabel timerLabel = new JLabel();
		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timerLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
		timerLabel.setBounds(10, 48, 46, 14);
		add(timerLabel);

		Timer timer = new Timer();
		try {
			timer.scheduleAtFixedRate(new TimerTask(){ 
				public void run() {
					if(flag){
						timerLabel.setText(""+(counter++%10));
					}
					else {
						timerLabel.setText(""+(9-(counter++%10)));
					}
				} 
			}, new Date(), 1000);
		}
		catch(IllegalArgumentException iae) {
			System.out.println("ID: 122:-Illegal argument has been passed to method "
					+ "scheduleAtFixedRate. Please fix it!");
		}
		catch(IllegalStateException iae) {
			System.out.println("ID: 122:-Java application is not in an appropriate "
					+ "state for the requested operation!");
		}
		catch(NullPointerException e) {
			System.out.println("ID: 122:-Null pointer exception has occurred!");
		}
		return panel;
	}
}
