import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * SER516 Lab1.
 * Create a class to create panel for group project.
 * 
 * @author Yuan Cao id: 018, ASU ID: ycao87
 * @email caoyuan0816@gmail.com
 * @version 2018.0121
 * @group 1
 *
 * Class P018_Cao_Panel implemented 3 methods: A constructor, create(), and main().
 * Usage:
 *     P018_Cao_Panel p = new P018_Cao_Panel(1);
 *     JPanel panel = p.create(); //variable panel storing the panel has been created
 *     
 * @author Yuan Cao, ID: 018
 * @version 2018.0121
 * @see javax.swing.JPanel
 */
public class P018_Cao_Panel extends JPanel{

	private boolean increase;
	private int curTime;
	private Color color;
	
	//Time interval 1000 ms = 1s
	final private int TIME_INTERVAL = 1000;
	
	/**
	 * Constructor method for class P018_Cao_Panel.
	 * Recieve one integer parameter, if it's odd, will set color to lightblue, increase to false, curTime to 0
	 * else, will set color to white, increase to true and curTime to 0.
	 * 
	 * @param arg: an integer number used to determine behavior of this constructor.
	 */
	public P018_Cao_Panel(int arg) {
		super();
		//Check argument even or odd 
		if((arg & 1) == 1) {
			//If odd
			//Setting background LightBlue
			this.color = new Color(173, 216, 230);
			//Setting counter decrease
			this.increase = false;
			//Current time should be 9
			this.curTime = 9;
		}else {
			//If even
			//Setting background White
			this.color = Color.white;
			//Setting counter increase
			this.increase = true;
			//Current time should be 0
			this.curTime = 0;
		}
		this.create();
	}
	
	/**
	 * Method Create used to create a new JPanel and return it based on the behavior decided by constructor.
	 * It will create a JPnael and two JLabels.
	 * One of JLabel used to show the first name and last name, the other one used to show timer.
	 * For the timer, it will create a taskPerformer by override actionPerformed method of class ActionListener.
	 * Then create a new timer configured by constant variable TIME_INTERVAL and taskPerformer instance and start it.
	 * 
	 * @return a panel instance which user wish to create.
	 * @see java.awt.event.ActionListener;
	 */
	private void create() {
		Font font = new Font("Papyrus", Font.PLAIN, 12);
		
		//Configure panel layout and size
		setLayout(new GridLayout(2, 1));
		setPreferredSize(new Dimension(100, 100));
		setMinimumSize(new Dimension(100, 100));
		
		//Configure panel background color
		setBackground(this.color);
		
		//JLabel for name
		JLabel label1 = new JLabel("<html>Yuan<br>Cao</html>", JLabel.CENTER);
		label1.setFont(font);
		add(label1);
		
		//JLabel for time counter
		JLabel label2 = new JLabel(Integer.toString(curTime), JLabel.CENTER);
		label2.setFont(font);
		add(label2);
		
		//Configuring timer for time counter
		
		//Setting task performer
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//Check increase flag then increase of decrease cur time
				if(increase) {
					curTime++;
					if(curTime == 10) {curTime -= 10;}
				}else {
					curTime--;
					if(curTime == -1) {curTime += 10;}
				}
				//Redrawing text of label2
				label2.setText(Integer.toString(curTime));
			}
		};
		
		//Create a new timer and run it
		Timer timer = new Timer(this.TIME_INTERVAL, taskPerformer);
		timer.start();
	}

	/**
	 * This main method used for test.
	 * It should be commented when committed to github.
	 * If some one want to test this class, he should decomment this method and try to run it.
	 * 
	 * @param args: arguments for main entrance.
	 */
	/*
	public static void main(String[] args) {
		
		//Creating new JFrame
		JFrame frame = new JFrame("Lab1 Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		
		//Setting and getting new panel
		P018_Cao_Panel entity = new P018_Cao_Panel(2);
		frame.setContentPane(entity);
		
		//Pack and run it
		frame.pack();
		frame.setVisible(true);
	}
	*/
}
