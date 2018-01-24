import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
/*
 * SER 516 ID:81
 * @author Namratha Olety Venkatesh
 * Class P081_OletyVenkatesh_Panel implements JPanel that displays two labels.
 * A label for First and Last name in two rows and another label for a timer.
 * Timer and background color is set based on the value passed to constructor.
 */
public class P081_OletyVenkatesh_Panel extends JPanel {

	int minCounter=0,maxCounter=9;
	JLabel name,timer;
	Font nameFontSize,timerFontSize;
	Dimension panelSize;
	Color lightBlue = new Color(173, 216, 230);

	//Constructor to set label and background properties
	public P081_OletyVenkatesh_Panel(int oddEven) {

		panelSize = new Dimension(100, 100);
		setPreferredSize(panelSize);

		name = new JLabel("<html><br>Namratha<br>Olety Venkatesh"+
						"<br><br><br><br><br></html>");
		nameFontSize = new Font("Papyrus", Font.BOLD, 12);
		name.setFont(nameFontSize);
		add(name);

		timer = new JLabel("");
		timerFontSize = new Font("Papyrus", Font.BOLD, 18);
		timer.setFont(timerFontSize);
		add(timer);

		//Thread to handle timer and background based on parameter passed.
		new Thread() {
			@Override
			public void run() {
				while(true) {
				//If parameter passed is even, set background to blue
				//and decrement timer
				if(oddEven%2==0) {
					setBackground(lightBlue);
					for ( int down = maxCounter; down >=minCounter; down--) {
						timer.setText(" "+down);
						try{
							Thread.sleep(1000);
						}
						catch(Exception e) {
							System.out.println("Exception in P081_Olety_Panel "
									+e.getMessage());
						}
					}
				}
				//If parameter passed is odd, set background to white
				//and increment timer
				else {
					setBackground(Color.WHITE);
					for ( int up = minCounter; up <= maxCounter; up++) {
						timer.setText(" " + up);
						try {
							Thread.sleep(1000);
						}
						catch (InterruptedException ie) {
							System.out.println("Exception in P081_Olety_Panel "
									+ie.getMessage());
						}
					}
				}
				}
			}
		}.start();
	}
}
