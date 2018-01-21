import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

/*
* @author Shubham Vyas
*/
public class P122_Vyas_Panel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 * Declaration of class attributes required for logic.
	 */
	private JPanel panel;
	private boolean flag;
	private static int counter;
	
	public P122_Vyas_Panel(int n) {
		/*
		 * Creating new panel object and setting the size and flag attribute for appropriate background and timer.
		 */
		panel = new JPanel();
		panel.setSize(100,100);
		if(n%2 == 0) {
			flag = true;
			this.setBackground(Color.WHITE);
		}
		else{
			this.setBackground(new Color(176, 216, 230));
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

		JLabel lblNewLabel = new JLabel("<html><center>Shubham<br>Vyas</center></html>");
		lblNewLabel.setFont(new Font("Papyrus", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 10, 60, 38);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("Papyrus", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 44, 46, 14);
		add(lblNewLabel_1);

		Timer timer = new Timer();
		try {
		timer.scheduleAtFixedRate(new TimerTask(){ 
			public void run() {
				if(flag){
					lblNewLabel_1.setText(""+(counter++%10));
				}
				else {
					lblNewLabel_1.setText(""+(9-(counter++%10)));
				}
			} 
		}, new Date(), 1000);
		}
		catch(IllegalArgumentException iae) {
			lblNewLabel_1.setText("Illegal argument has been passed to method scheduleAtFixedRate. Please fix it!");
		}
		catch(IllegalStateException iae) {
			lblNewLabel_1.setText("Java application is not in an appropriate state for the requested operation!");
		}
		catch(NullPointerException e) {
			lblNewLabel_1.setText("Null pointer exception has occured!");
		}
		return panel;
	}
}
