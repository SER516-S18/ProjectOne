import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * 
 * For SER 516 only.
 * @author  Abdul Samad Khan	
 * @version 1.0
 * @since   01-21-2018
 * The class P055_Khan_Panel creates a JPanel including 2 JLabels
 * In this class there is a overloaded constructor that takes an integer value
 * depending on which if its even the color of the panel turns to white if its 
 * odd the panel turns to light blue, if the value given to the overloaded 
 * constructor is even the counter in the panel starts from 0 and increases by 1 
 * every second for odd it starts from 9 and decreases by 1 every second 
 *
 */

public class P055_Khan_Panel extends JPanel{
	private JLabel labelName;
	private JLabel labelCounter;
	private Timer timer;
	public Color LIGHT_BLUE = new Color(173,216,230);
	/*
	 * This function initializes the panel and the labels
	 * and assign color to the panel according to the value 
	 * given to the constructor.
	 * 
	 */	
	public P055_Khan_Panel(int value){
		try{
			setSize(100,100);
			setLayout(new FlowLayout());
			setVisible(true);
			labelName=new JLabel("<html>Abdul Samad<br/>Khan</html>");
			labelName.setFont(new Font("Papyrus", Font.PLAIN, 15));
			add(labelName);
			if(value%2==0)
				{labelCounter= new JLabel(String.valueOf( 0 ));
				setBackground(Color.WHITE);
				}
			else
				{labelCounter= new JLabel(String.valueOf( 9 ));
				setBackground(LIGHT_BLUE);
				}
			labelCounter.setFont(new Font("Papyrus", Font.PLAIN, 15));
			add(labelCounter);
			timer(value);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	/*
	 * This function handles how the counter increments or decrements
	 * according the value passed to the overloaded constructor after 
	 * 1 second
	 */
	public void timer(int value){
		try{
		timer = new Timer(1000, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				int counter = Integer.parseInt(labelCounter.getText());
				if(value % 2 ==0){			
					counter++;
					if(counter>9){
						counter=0;
					}
				}
				else{
					counter--;					
					if(counter<0){
						counter=9;
					}					
				}
				labelCounter.setText(Integer.toString(counter));
			}
					
		});
		timer.start();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
