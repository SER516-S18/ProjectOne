import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author: Kanchan Wakchaure
 * @version: 1.0
 * SER 516 Lab1: Create a panel with first_name, last_name and counter (using Timer). 
 *               For even number as input, background will be set to white color and 
 *               counter will run from 0 to 9 (ascending). 
 *               For odd number as input, background will be set to light blue color
 *               and counter will run from 9 to 0 (descending).
 */

public class P123_Wakchaure_Panel extends JPanel{	
	
	Timer timer;
	int count;
	
// Constructor to create the panel 
	public P123_Wakchaure_Panel(int in_num) {
			
		Font font = new Font("Papyrus", Font.PLAIN, 15);  //font of style PAPAYRUS
		setSize(100,100);   					          //panel size 100*100
		setLayout(new GridLayout(0, 1));
		
		//First name and Last name in panel
		JLabel name = new JLabel("<html>Kanchan<br>Wakchaure</html>");
		name.setFont(font);
		name.setHorizontalAlignment(JLabel.CENTER);
	    add(name);
			    
		//Counter in panel
	    JLabel counter = new JLabel();
		counter.setFont(font);
		counter.setHorizontalAlignment(JLabel.CENTER);
		add(counter);
		
		Color lightBlue = new Color(173,216,230); 
		
		//To set panel background color and counter
		if (in_num % 2 == 0) {				//even input
			setBackground(Color.WHITE);    
			count = 0;
		}
		else {							   //odd input
			setBackground(lightBlue);
			count = 9;
		}
			
				
		//To start the timer depending on input number
		try {
			timer = new Timer(1000, new ActionListener(){			  
				public void actionPerformed(ActionEvent e) {
					counter.setText(Integer.toString(count));
					if ( in_num % 2 == 0 ) {	//count from 0 to 9	 
						if (count == 9 )
							count = 0;
						else
							count++;
					}
					else {						//count from 9 to 0
						if (count == 0 )
							count = 9;
						else
							count--;
					}						
				}
			});
			timer.start();
		}		
		catch (Exception e){
			e.printStackTrace();
		}		
	}
}
