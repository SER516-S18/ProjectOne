import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * For SER516 Lab1
 * @author - Rakesh Mohan
 * @version - 1.0
 * Description - The class creates a panel with my First Name & Last Name with 
 * counter & background changing based on the integer passed to the constructor.
*/
public class P076_Mohan_Panel implements Runnable {

	//Declaring class variables
	private final int DECIDER;
	private JPanel panel = new JPanel();
	private JLabel timerLabel = new JLabel();
	private Thread thread = new Thread();
	private final Color lIGHTBLUE= new Color(173,216,230);
	private final Font FONT = new Font("Papyrus", Font.PLAIN, 15);
	
	/** Constructor assigning the input value deciding the background colour
	 *  and counter.
	 */
	public P076_Mohan_Panel(int input){
		DECIDER = input;
	}
	
	//Designing the panel with details
	public void myPanel() {
		
		//label with first name last name details
		JLabel nameLabel = new JLabel("<html><br>Rakesh<br>Mohan</html>");
		
		//Resetting the font for both the variables
		nameLabel.setFont(FONT);
		timerLabel.setFont(FONT);
		
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
	
		//Adding the labels to the panel.
		panel.setLayout(new BorderLayout());	
		panel.setSize(100, 100);
		panel.add(BorderLayout.NORTH, nameLabel);
		panel.add(timerLabel);
	
		//Starting the Thread for the counter.
		this.thread = new Thread(this);
		this.thread.start();
		
	}
	
	/**Overriding the run function of the thread to run the counter and 
	 * modify the panel colour.
	 */
	@Override
	public void run() {
		
		/**Increment counter & light blue background colour setting if 
		 * the constructor integer is even 
		*/
		if (DECIDER % 2 == 0)
		{
			panel.setBackground(lIGHTBLUE);
			
			do {
				for (int counter = 0;counter < 10; counter++)
				{
					try {
					    		Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					timerLabel.setText(""+Integer.toString(counter));
				}
			}while (true);
		}
		/**Decrement counter & white background colour setting if 
		 * the constructor integer is odd
		 */
		else
		{
			panel.setBackground(Color.white);
			
			do {
					for (int counter = 9 ;counter >= 0; counter--)
					{
						try {
						    		Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						timerLabel.setText(""+Integer.toString(counter));
					}
					
				}while(true);
		}
	}
	
	/**
	 *  Method to access the myPanel 
	 * @return myPanel
	 */
	public JPanel getPanel() {
		
		myPanel();
		return panel;
	}
}
