import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* SER 516 - Project 1
* @author Bhavana Venkatasubramanian
* @version 1.0
* P120_Venkatasubramanian_Panel is a Panel
* First row contains the First Name
* Second row contains the Last Name
* Last row has a counter that either increases or decreases 0 through 9
* The background color and the counter direction are decided based on a parameter passed to the constructor
*/


public class P120_Venkatasubramanian_Panel extends JPanel {

	public static final String firstname = "Bhavana";
	public static final String lastname = "Venkatasubramanian";
	public PanelType type;
	JLabel counter = new JLabel();

	int result, flag;
	public enum PanelType {
		Incrementor,
		Decrementor,
	};
/**
* Class Constructor
* @param check decides the background color and counter direction based on its property ( odd or even)
* Odd: Light Blue background and counter counts from 9 to 0
* Even: White background and counter counts from 0 to 9
*/

	
         public P120_Venkatasubramanian_Panel(int check) {
		
		if(check %2 == 0) {
			type = PanelType.Incrementor;	
			incrementor();	
		}
		
		else {
			type = PanelType.Decrementor;	
			decrementor();	
		}	
		
		this.setLayout(new GridLayout(3, 1));
		
		if(type == PanelType.Incrementor)
			this.setBackground(Color.white);
		else
			this.setBackground(Color.cyan);
		
		JLabel firstnameLabel = new JLabel(firstname);		
		JLabel lastnameLabel = new JLabel(lastname);
		firstnameLabel.setHorizontalAlignment(JLabel.CENTER);
		firstnameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
		this.add(firstnameLabel);				
		lastnameLabel.setHorizontalAlignment(JLabel.CENTER);
		lastnameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
		this.add(lastnameLabel);
		counter.setHorizontalAlignment(JLabel.CENTER);
		counter.setFont(new Font("Papyrus", Font.PLAIN, 15));
		this.add(counter);
	}
		public void incrementor() {
		Thread thread = new Thread(new Runnable() {
		    @Override
		    public void run() {
			while (true) {
				if(result == 10)			
                         		result = 0;
          			counter.setText(new Integer(result).toString())	;
                     		result++;
				try {
					Thread.sleep(1000);		
				} catch (InterruptedException e) {
					System.err.println(e.toString());
					continue;
				}
			}
		    }         
		});
		thread.start();
	}
	
	public void decrementor() {
	Thread thread = new Thread(new Runnable() {
	    @Override
	    public void run() {
		while (true) {
			if(result == -1)				
                    		result = 9;
          		counter.setText(new Integer(result).toString());
                	result--;
			try {
				Thread.sleep(1000);			
			} catch (InterruptedException e) {
				System.err.println(e.toString());
				continue;
			}
		}
	    }         
	});
	thread.start();
	}
}
