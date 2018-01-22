package p055_Khan_Panel;
/**
 *  For SER 516 only.
 * @author  Abdul Samad Khan	
 * @version 1.0
 * @since   01-21-2018
 */

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
 * The class P055_Khan_Panel creates a JPanel including 2 JLabels
 * In this class there is a overloaded constructor that takes an integer value
 * depending on which if its even the color of the panel turns to white if its 
 * odd the panel turns to light blue, if the value given to the overloaded 
 * constructor is even the counter in the panel starts from 0 and increases by 1 
 * every second for odd it starts from 9 and decreases by 1 every second 
 *
 */

public class P055_Khan_Panel extends JPanel{
	
	private JLabel label1;
	private JLabel label2;
	private Timer timer;
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
			label1=new JLabel("<html>Abdul Samad<br/>Khan</html>");
			label1.setFont(new Font("Papyrus", Font.PLAIN, 15));
			add(label1);
			if(value%2==0)
				{label2= new JLabel(String.valueOf( 0 ));
				setBackground(Color.WHITE);
				}
			else
				{label2= new JLabel(String.valueOf( 9 ));
				setBackground(new Color(173,216,230));
				}
			label2.setFont(new Font("Papyrus", Font.PLAIN, 15));
			add(label2);
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
				int counter = Integer.parseInt(label2.getText());
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
				label2.setText(Integer.toString(counter));
			
			}
					
		});
		timer.start();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/*
	 * the main is used for testing 
	 * public static void main(String []args){
	 * P055_Khan_Panel p= new P055_Khan_Panel(1);
	 * JFrame frame = new JFrame();
	 * frame.setSize(100, 100);
	 * frame.add(p);
	 * frame.setVisible(true);
	 * }
	 */
	
	




}
