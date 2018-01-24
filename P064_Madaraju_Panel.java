import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
/* 
 * LAB I - Project
 * AUTHOR: Venkata Akhil Madaraju
 * DESC : A Main Frame consisting of 5 Tabs in it which 
 * in turn has 25 Panels (5*5) one for each student
*/ 

/*
 * Class implements a panel  with FirstName, LastName and a counter, 
 * counter displaying numbers, also a constructor which receives an integer value.
 * if the value is Even, background is White and the counter increases
 */
public class P064_Madaraju_Panel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel firstName;
	private JLabel lastName;
	private JLabel counter;
	private Timer timer;
	public Color LIGHTBLUE = new Color(173,216,230);
	
	/*
	 * Constructor which takes an integer as input based on which 
	 * background color is decided
	 * Parameters : integer to decide color
	 * return : JPanel Object
	 */
	public P064_Madaraju_Panel(int colorDecider){
		try{
			if(colorDecider%2==0){
				counter= new JLabel(String.valueOf( 0 ));
				setBackground(Color.WHITE);
			}
			else{
				counter= new JLabel(String.valueOf( 9 ));
				setBackground(LIGHTBLUE);
			}
			setSize(100,100);
			setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
			setVisible(true);
			//First Name
			firstName = new JLabel("Venkata Akhil");
			firstName.setFont(new Font("Papyrus",Font.PLAIN,15));
			firstName.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			//Last Name
			lastName = new JLabel("Madaraju");
			lastName.setFont(new Font("Papyrus",Font.PLAIN,15));
			lastName.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			add(firstName);
			add(lastName);
			//counter
			counter.setFont(new Font("Papyrus", Font.PLAIN, 15));
			counter.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			add(counter);
			timer(colorDecider);
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	//Timer to increment if the constructor receives even value else decrement
	//Parameters : timerDecider (which is same as colorDecider)
	//return : None
	public void timer(final int timerDecider){
		try{
			timer = new Timer(1000, new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent) {
					int count = Integer.parseInt(counter.getText());
					if(timerDecider % 2 ==0){			
						count++;
						if(count>9){
							count=0;
						}
					}
					else{
						count--;					
						if(count<0){
							count=9;
						}					
					}
					counter.setText(Integer.toString(count));
				}
			});
			timer.start();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
}
