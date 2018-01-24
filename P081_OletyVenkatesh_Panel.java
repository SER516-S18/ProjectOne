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
	JLabel p081Name,p081Timer;
	Font p081NameFontSize,p081TimerFontSize;
	Dimension p081PanelSize;
	Color lightBlue = new Color(173, 216, 230);

	//Constructor to set label and background properties
	public P081_OletyVenkatesh_Panel(int oddEven) {

		p081PanelSize = new Dimension(100, 100);
		setPreferredSize(p081PanelSize);

		p081Name = new JLabel("<html><br>Namratha<br>Olety Venkatesh"+
						"<br><br><br><br><br></html>");
		p081NameFontSize = new Font("Papyrus", Font.BOLD, 12);
		p081Name.setFont(p081NameFontSize);
		add(p081Name);

		p081Timer = new JLabel("");
		p081TimerFontSize = new Font("Papyrus", Font.BOLD, 18);
		p081Timer.setFont(p081TimerFontSize);
		add(p081Timer);

		//Thread to handle timer and background based on parameter passed.
		new Thread() {
			@Override
			public void run() {
				while(true) {
				//If parameter passed is even, set background to blue
				//and increment timer
				if(oddEven%2==0) {
					setBackground(lightBlue);
					for ( int up = minCounter; up <=maxCounter; up++) {
						p081Timer.setText(" "+up);
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
				//and decrement timer
				else {
					setBackground(Color.WHITE);
					for ( int down = maxCounter; down >= minCounter; down--) {
						p081Timer.setText(" " + down);
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
