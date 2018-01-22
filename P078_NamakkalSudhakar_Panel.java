import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * This class is a panel class consisting of three methods and 
 * displays a label with 3 rows,
 * 1st row displays the first name,
 * 2nd row displays the last name and 
 * 3rd row displays the counter time 
 *
 * @author raamprashanthns
 * created on 2018/01/21
 */

@SuppressWarnings("serial")
public class P078_NamakkalSudhakar_Panel extends JPanel {
	
	//Panel type is based on the number passed to the constructor, this is used instead of repeatedly finding whether the number is even or odd
	enum PanelType {
		Odd,
		Even
	}
	
	private PanelType panelType;
	
	public P078_NamakkalSudhakar_Panel(int num) {
		
		//Set panel type
		this.panelType = (num%2 == 0) ? PanelType.Even : PanelType.Odd; 
		
		//Panel related settings 
		setLayout(new GridBagLayout());
		//setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
       		setPreferredSize(new Dimension(100, 100));
        	//setting background for panel based on the panel type
        	this.setBackground((this.panelType == PanelType.Even) ? Color.white : new Color(173, 216, 230)); 
		
        	//Labels for displaying name and specifying their configuration values
		JLabel firstNameLabel = new JLabel("Raam Prashanth", JLabel.CENTER);
		JLabel lastNameLabel = new JLabel("Namakkal Sudhakar", JLabel.CENTER);
		
		firstNameLabel.setFont(new Font("Papyrus", Font.PLAIN, 16));
		lastNameLabel.setFont(new Font("Papyrus", Font.PLAIN, 16));
		
		addLabel(firstNameLabel, 0, 0);
		addLabel(lastNameLabel, 0, 1); 
		
		//Timer mechanism using thread
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//Setting up initial values and change value for the timer based on the panel type
				int change = 1;
				int start = 0;
				
				if (panelType == PanelType.Odd) {
					change = -1;
					start = 9;
				}
				
				// setting up counter label
				JLabel counterLabel = new JLabel(new Integer(start).toString());
				counterLabel.setFont(new Font("Papyrus", Font.PLAIN, 16));
				counterLabel.setHorizontalAlignment(JLabel.CENTER);
				addLabel(counterLabel, 0, 3);
				
				//timer increment and decrement operations
				while (true) {
					try {
						Thread.sleep(1000); //1000Ms = 1S
					} catch (InterruptedException e) { //this exception handling is to only skip a second instead of program failure
						e.printStackTrace();
					} 
					
					start = start + change;
					
					if (start < 0) { //if the counter decreases after 0 start from 9 again
						start = 9;
					} else if (start > 9) { //if the counter increases after 9 start counter from 0
						start = 0;
					}
					
					counterLabel.setText(new Integer(start).toString());
				}
				
			}
		});
		
		thread.start();
		
	}

	// This method is used for positioning the label component
	private void addLabel(JLabel label, int x, int y) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		
		add(label, gbc);
	}
	
	// This method returns this panel object
	public JPanel getPanel() {
		return this;
	}
}
