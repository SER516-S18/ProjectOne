import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * SER 516 ID:81
 * Name: Namratha Olety Venkatesh
 * Class: P081_Olety_Panel
 * Group 4
 * */
public class P081_Olety_Panel {
	
	public JPanel p081Panel = new JPanel();
	//label for full name
	JLabel p081Name = new JLabel("<html><br>Namratha<br>Olety Venkatesh</html>",JLabel.CENTER);
	JLabel p081Timer = new JLabel("<html><br><br></html> ");
	Font p081NameFont = new Font("Papyrus",Font.BOLD,12); 
	Font p081TimerFont = new Font("Papyrus",Font.BOLD,18);
	Dimension p081PanelSize = new Dimension(100, 100);
	Color lightBlue=new Color(173,216,230);
	int maxCounter=9,minCounter=0;
	//parameterized constructor
	
	public P081_Olety_Panel(int oddeven) 
	{
		//Setup Panel and Label properties
		p081Name.setFont(p081NameFont); 
		p081Panel.setPreferredSize(p081PanelSize); 
		p081Panel.add(p081Name);
		p081Timer.setFont(p081TimerFont);
		p081Panel.add(p081Timer);
		//check value passed is even or odd

		new Thread() {
			public void run() {
				while(true) {
					if(oddeven%2==0) {
						//Background blue if even
						p081Panel.setBackground(lightBlue);
						for (int up = minCounter; up <=maxCounter; up++) {
							p081Timer.setText(" "+up);
							try{
								Thread.sleep(1000);
							}
							catch(Exception e) {
								System.out.println("Exception in P081_Olety_Panel "+e.getMessage());
							}
						}
					}
					else
					{
						p081Panel.setBackground(Color.WHITE);
						//Counter down if parameter is odd
						for ( int down = maxCounter; down >= minCounter; down--) {
							p081Timer.setText(" " + down);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException ie) {
								System.out.println("Exception in P081_Olety_Panel "+ie.getMessage());
							}
						}
					}
				}

			}
		}
		.start();

	}
}
