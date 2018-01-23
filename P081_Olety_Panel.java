/*
 * ID 81
 * Name: Namratha Olety Venkatesh
 * Class: P081_Olety_Panel
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
	JLabel label1 = new JLabel("<html><br>Namratha<br>Olety Venkatesh<br></html>"); //label for full name
	//parameterized constructor
	public P081_Olety_Panel(int oddeven) 
	{
		//Setup Panel and Label properties
		Font labelFont1 = new Font("Papyrus",Font.BOLD,12); 
		Font labelFont2 = new Font("Papyrus",Font.BOLD,18); 
		label1.setFont(labelFont1); 
		jpanel.setPreferredSize(new Dimension(100, 100)); 
		jpanel.add(label1);
		JLabel label2 = new JLabel("");
		label2.setFont(labelFont2);
		jpanel.add(label2);
		//check value passed is even or odd
		if(oddeven%2==0) 
		{
			//Background blue if even
			jpanel.setBackground( new Color(173,216,230) );
			while(true)
			{
				//Counter up if parameter is even
				for (int up = 0; up <=9; up++) {
					label2.setText("" + up);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("Exception in P081_Olety_Panel "+e.getMessage());
					}
				}
			}
		}
		
		else 
		{
			//Background white if odd
			jpanel.setBackground(Color.WHITE);
			while(true)
			{
				//Counter down if parameter is odd
				for ( int down = 9; down >= 0; down--) {
					label2.setText("" + down);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ie) {
						System.out.println("Exception in P081_Olety_Panel "+ie.getMessage());
					}
				}
			}
		}
		
	}
	
	/*public static void main(String[] args) {
		new P081_Olety_Panel(28);
	}*/
}
