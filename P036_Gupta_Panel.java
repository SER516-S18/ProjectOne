import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;
/**
 * 
 * @author RAHUL
 * @description Panel class
 * @version 1.0
 * 
 * SER 516 : Project 01
 * Class extends JPanel containing name of the author and the counter with parameterized constructor 
 * that accepts integer as a value.
 * When value is even -> background : white, Counter increments from 0 to 9
 * When value is odd -> background : Light Blue, Counter decrements from 9 to 0 
 *
 */
@SuppressWarnings("serial")
public class P036_Gupta_Panel extends JPanel{
	private static JLabel nameLabel, labelCtr;
	public int counter;
	public static final Color LIGHTBLUE = new Color(173, 216, 230);
	/*
	 * Constructor : setting labels, fonts, Grid layout, background
	 * @param value
	 */
	public P036_Gupta_Panel(int counter) {
		setLayout(new GridLayout(2,0));
		nameLabel = new  JLabel("<html>RAHUL<br>GUPTA</html>", SwingConstants.CENTER);
		nameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
		labelCtr = new JLabel(String.valueOf(counter), SwingConstants.CENTER);
		labelCtr.setFont(new Font("Papyrus", Font.PLAIN, 15));
		add(nameLabel);
		add(labelCtr);
		setBounds(0, 0, 100, 100);
		Timer time = new Timer();
		// control to check whether counter is even or odd
		if(counter%2==0) {
			setBackground(Color.white);
			Mytask task = new Mytask(labelCtr, 0);
			time.scheduleAtFixedRate(task, 0, 1000);
		}
		else {
			setBackground(LIGHTBLUE);
			Mytask task2 = new Mytask(labelCtr, 9);
			time.scheduleAtFixedRate(task2, 0, 1000);
		}	
	}
	// extending TimerTask class. Increment and decrement counter
	public class Mytask extends TimerTask {
		public JLabel ctrLabel;
		public int check; 
		/*
		 *  class Mytask constructor initializing counter label and check 
		 *  @param {Object} Passing JLabelCtr
		 *  @param start integer value to initialize
		 */
		public Mytask(JLabel ctrLabel, int ctrStart) {
			this.ctrLabel = ctrLabel;
			counter = ctrStart;
			this.check = ctrStart;
		}
		// Control to check whether to increment or decrement
		public void run(){
			try {
				if(check == 0) {
					ctrLabel.setText(String.valueOf(counter));
					counter++;
					counter = counter % 10;
				}
				if(check == 9) {
					ctrLabel.setText(String.valueOf(counter));
					counter--;
					if(counter < 0) {
						counter = 9;
					}
				}
	}
		catch(Exception e) {
			System.out.println("Timer Exception"+ e);
		}
		}
	}	
}
