//package ser516;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Amaresh
 *
 */
public class P014_Bingumalla_Panel extends JPanel {

	private JPanel panel = new JPanel();
	private JLabel timer_label = new JLabel();
	private int count;

	/**
	 * 
	 * @param num
	 * This parameter is the flag provided. 
	 * This decides the background color and timer functionality.
	 */
	public P014_Bingumalla_Panel(int num) {

		if(num%2 == 0){
			this.setBackground(Color.WHITE);
			count = 0;
		} else {
			this.setBackground(new Color(51,204,255));
			count = 9;
		}

		/*Calling the timer function and setting it's label*/
		timerFn(num);

		//Panel Configurations
		this.setSize(100,100);
		/*FirstName and LastName Creation and Assignment*/
		JLabel firstName = new JLabel("Amaresh", JLabel.CENTER);
		JLabel lastName = new JLabel("Bingumalla", JLabel.CENTER);
		firstName.setFont(new Font("Papyrus", Font.PLAIN, 15));
		lastName.setFont(new Font("Papyrus", Font.PLAIN, 15));
		firstName.setAlignmentX(Component.CENTER_ALIGNMENT);
		lastName.setAlignmentX(Component.CENTER_ALIGNMENT);

		/*Timer label Alignment*/
		timer_label.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		timer_label.setFont(new Font("Papyrus",Font.BOLD,16));

		/*FirstName and LastName Alignment as a vertical box*/
		Box vbox=Box.createVerticalBox();
		vbox.add(firstName);
		vbox.add(lastName);
		vbox.add(timer_label);
		/*Addition of Name and timer labels to the panel*/
		this.add(vbox);

	}

	/**
	 * 
	 * @param n
	 * This parameter decides whether the counter increments or decrements
	 */
	public void timerFn(int n){
		try{
			Timer timer = new Timer(1000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					if(n%2 == 0){ /*If the given flag is even then start from 0 and then increment*/
						timer_label.setText(String.valueOf(count));
						if(count >= 9){
							count = 0;
						} else {
							count++;
						}

					} else {	/*If the given flag is odd then start from 9 and then decrement*/
						timer_label.setText(String.valueOf(count)); 
						if(count <= 0){
							count = 9;
						} else {
							count--;
						}

					}
				}
			});
			timer.start();
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * 
	 * @param args
	 * Main function just to test testing
	 */
	/*public static void main(String[] args) {	
		P014_Bingumalla_Panel obj = new P014_Bingumalla_Panel(0141);
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.add(obj);
		frame.setVisible(true);
	}*/

}
