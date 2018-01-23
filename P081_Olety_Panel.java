/*
 * ID 81
 * Name: Namratha Olety Venkatesh
<<<<<<< HEAD
 * Class: P081_Olety_Panel
=======
 * File: P081_Olety_Panel
>>>>>>> 1d6aa715ab86c8af369d61858aecdd01f53aaa9b
 * Group 4
 * */
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
public class P081_Olety_Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	JPanel jpanel = new JPanel();
<<<<<<< HEAD
	JLabel label1 = new JLabel("<html><br><br>Namratha<br>Olety Venkatesh<br><br><br><br><br><br></html>"); //label for full name
=======
	JLabel label1 = new JLabel("<html><br>Namratha<br>Olety Venkatesh<br></html>"); //label for full name
>>>>>>> 1d6aa715ab86c8af369d61858aecdd01f53aaa9b
	//parameterized constructor
	public P081_Olety_Panel(int oddeven) 
	{
		//Setup Panel and Label properties
<<<<<<< HEAD
		Font labelFont = new Font("Papyrus",Font.BOLD,16); 
		label1.setFont(labelFont); 
=======
		Font labelFont1 = new Font("Papyrus",Font.BOLD,12); 
		Font labelFont2 = new Font("Papyrus",Font.BOLD,18); 
		label1.setFont(labelFont1); 
>>>>>>> 1d6aa715ab86c8af369d61858aecdd01f53aaa9b
		jpanel.setPreferredSize(new Dimension(100, 100)); 
		jpanel.add(label1);
		//check value passed is even or odd
		if(oddeven%2==0) 
		{
<<<<<<< HEAD
			jpanel.setBackground(new Color(0,0,182,155));
=======
			jpanel.setBackground( new Color(173,216,230) );
>>>>>>> 1d6aa715ab86c8af369d61858aecdd01f53aaa9b
		}
		else 
		{
			jpanel.setBackground(Color.WHITE);
		}
<<<<<<< HEAD
		JLabel label2 = new JLabel();
		label2.setFont(labelFont);
=======
		JLabel label2 = new JLabel("");
		label2.setFont(labelFont2);
>>>>>>> 1d6aa715ab86c8af369d61858aecdd01f53aaa9b
		jpanel.add(label2);
		while(true)
		{
			//Counter up
			for (int up = 0; up < 9; up++) {
				label2.setText("" + up);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Exception in P081_Olety_Panel "+e.getMessage());
				}
			}
			for ( int down = 9; down > 0; down--) {
				label2.setText("" + down);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					System.out.println("Exception in P081_Olety_Panel "+ie.getMessage());
				}
			}}
	}
	/*public static void main(String[] args) {
<<<<<<< HEAD
		new P081_Olety_Panel(2);
	}*/
}
=======
		new P081_Olety_Panel(28);
	}*/
}
>>>>>>> 1d6aa715ab86c8af369d61858aecdd01f53aaa9b
