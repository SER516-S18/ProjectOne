import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**The program displays a panel with my full name
 * and it also reads an integer value and displays a timer
 * if the integer value is even then timer increments with white background
 * and if integer is odd the timer decrements with blue background  
 */

/**
 * @author Madhavi Latha
 *
 */

/*
 * first name, last name, light blue are declared as variables 
 * so that it is easy to change their values when ever required
 */
public class P015_Bodeddula_Panel extends JPanel{
    private int count ;
	private static String firstName = "Madhavi Latha";
	private static String lastName = "Bodeddula";
	public static Color lightBlue = new Color(173, 216, 230);
	private JLabel timerLabel;
/*
 * initializing the timer value based on integer input
 * and displaying the output on panel with proper font and alignment
 */
public P015_Bodeddula_Panel(int counter) {
	if(counter%2 ==0) 
	{
		count = 0;
	}
	else 
	{
		count =9;
	}
	 setSize(100,100);
     setLayout(new GridLayout(3, 1));
     JLabel firstNameLabel = new JLabel(firstName,JLabel.CENTER);
     JLabel lastNameLabel = new JLabel(lastName, JLabel.CENTER); 
     timerLabel = new JLabel("", JLabel.CENTER);
     //setting font
     firstNameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
     lastNameLabel.setFont(new Font("papyrus", Font.PLAIN, 15));
     timerLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));  
     //displaying them to panel
     add(firstNameLabel);
     add(lastNameLabel);
     add(timerLabel);
     startTimer(counter);
}

/*
 * The startTimer method consists of the necessary code
 * which increment or decrements the timer according to requirements
 * and displays it to the panel.
 * try and catch statements are also added to handle exceptions.
 */

private void startTimer(int counter) {
	
	try {
        Timer timer = new Timer(1000, new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	if(counter %2 == 0) 
            	{
            		timerLabel.setText("" + count);
            		if(count ==9) 
            		{
            			count = -1;
            		} count++;
            	} 
            	else {
            		setBackground(lightBlue);
            		timerLabel.setText("" + count);
            		if(count == 0) 
            		{
            			count = 10;
            		} count--;
            		
            		}
            }
        });

        timer.start();
    }
	catch (Exception e)
    {
        e.printStackTrace();
    }
} 
}
