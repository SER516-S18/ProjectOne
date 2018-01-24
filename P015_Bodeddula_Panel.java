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

/**
 * 
 */

/**
 * @author Madhavi Latha
 *
 */
public class P015_Bodeddula_Panel extends JPanel{
    private int count ;
	private static String firstName = "Madhavi Latha";
	private static String lastName = "Bodeddula";
	public static Color lightBlue = new Color(173, 216, 230);
	  private JLabel timerLabel;



public P015_Bodeddula_Panel(int counter) {
	if(counter%2 ==0) {
		count = 0;
	}
	else {
		count =9;
	}
	 setSize(100,100);
	 System.out.println("Inside constructor");
     setLayout(new GridLayout(3, 1));
     JLabel firstNameLabel = new JLabel(firstName,JLabel.CENTER);
     JLabel lastNameLabel = new JLabel(lastName, JLabel.CENTER); 
     timerLabel = new JLabel("", JLabel.CENTER);
     firstNameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
     lastNameLabel.setFont(new Font("papyrus", Font.PLAIN, 15));
     timerLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
     
     add(firstNameLabel);
     add(lastNameLabel);
     add(timerLabel);
     startTimer(counter);
}



private void startTimer(int counter) {
	System.out.println("Inside timer");
	try {
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(counter %2 == 0) {
            		timerLabel.setText("" + count);
            		if(count ==9) {
            			count = 0;
            		} count++;
            	} 
            	else {
            		setBackground(lightBlue);
            		//count = 9;
            		timerLabel.setText("" + count);
            		if(count == 0) {
            			count = 9;
            		} count--;
            		
            		}
            }
        });

        timer.start();
    }
	catch (Exception e)//Exception thrown
    {
        System.out.print(e);
    }
}
            


public static void main(String args[])
{
    P015_Bodeddula_Panel p= new P015_Bodeddula_Panel(5);
    JFrame frame = new JFrame();
    frame.setSize(200, 200);
    frame.add(p);
    frame.setVisible(true);

}  
}
