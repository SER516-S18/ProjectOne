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
 * Class extends JPanel containing name of the author and the counter with parameterized constructor 
 * that accepts integer as a value.
 * When value is even ---> background : white, Counter increments from 0 to 9
 * When value is odd ---> background : Light Blue (173, 216, 230), Counter decrements from 9 to 0 
 *
 */
@SuppressWarnings("serial")
public class P036_Gupta_Panel extends JPanel{
	private static JLabel label1, labelCtr;
	public int counter;
	
	/*
	 * Constructor : setting labels, fonts, Grid layout, background
	 * @param value
	 */
	public P036_Gupta_Panel(int ctr) {
		int counter = ctr;
		setLayout(new GridLayout(2,0));
		label1 = new  JLabel("<html>RAHUL<br>GUPTA</html>", SwingConstants.CENTER);
		label1.setFont(new Font("Papyrus", Font.PLAIN, 10));
		
		labelCtr = new JLabel(String.valueOf(counter), SwingConstants.CENTER);
		labelCtr.setFont(new Font("Papyrus", Font.PLAIN, 10));
		
		add(label1);
		add(labelCtr);
		setBounds(0, 0, 100, 100);
		
		Timer time = new Timer();
		
		// control to check whether counter is even or odd
		if(counter%2==0) {
			setBackground(Color.white);
			mtask task = new mtask(labelCtr, 0);
			time.scheduleAtFixedRate(task, 0, 1000);
		}
		
		else {
			setBackground(new Color(173, 216, 230));
			mtask task2 = new mtask(labelCtr, 9);
			time.scheduleAtFixedRate(task2, 0, 1000);
		}	
	}
	
	// class extending timer class to implement run and increment and decrement counter
	public class mtask extends TimerTask {
		public JLabel jl;
		public int check; 
		/*
		 *  class mtask constructor initializing counter label and check 
		 *  @param {Object} Passing JLabelCtr
		 *  @param start integer value to initialize
		 */
		public mtask(JLabel jb, int start) {
			jl = jb;
			counter = start;
			check = start;
		}
		
		public void run(){
			try {
			// Control to check whether to increment or decrement
			if(check == 0) {
			jl.setText(String.valueOf(counter));
			counter++;
			if(counter>9) {
				counter=0;
			}
	}
			if(check == 9) {
			jl.setText(String.valueOf(counter));
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
	/*
	 * Main method to test the code
	 * @param args
	 *
	public static void main(String args[])
	{	
		JFrame jf = new JFrame();
		P036_Gupta_Panel p = new P036_Gupta_Panel(32);
		jf.add(p);
		jf.setSize(800,800);
		jf.setLayout(null);
		jf.setVisible(true);
	}
	*/
}




