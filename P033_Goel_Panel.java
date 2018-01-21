import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class creates a panel displaying a name and a counter which increments per second.
 * @author Yathartha Goel
 * @version 1.0
 *
 */
public class P033_Goel_Panel extends JPanel {
	Color lightBlue=new Color(90,150,255);
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	int counter=0;
	Timer timer=new Timer();
	
	/**
	 * This constructor sets the text for all the labels and initializes the panel.
	 * It also sets the background color of the panel in accordance to the parameter value.
	 * @param value if value is even then background is White otherwise it is Light Blue.
	 */
	public P033_Goel_Panel(int value){
		label3= new JLabel();
		
		/*
		 * This is a time class which displays a number that increments every second 
		 * using threads.
		 */
		try{
			TimerTask task=new TimerTask(){
				public void run(){
					if(counter==9){
						counter=-1;
					}
					++counter;
					label3.setText(Integer.toString(counter));
					label3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					label3.setFont(new Font("Papyrus",Font.BOLD,16));
				}
			};
			timer.scheduleAtFixedRate(task, 1000, 1000);
			
			}catch(Exception e){
				System.out.println("There was an exception thrown at the timer class : "+e);
			}
		
		Box box=Box.createVerticalBox();
		
		/*
		 * Sets the background of the panel depending on whether the value passed is
		 * even or odd. If even, the background is set to White color.
		 */
		try{
		if(value%2==0){
			this.setBackground(Color.WHITE);
		}
		else{
			this.setBackground(lightBlue);
		}
		}catch(ArithmeticException e){
			System.out.println(e);
		}
		
		label1=new JLabel("Yathartha");
		label1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		label1.setFont(new Font("Papyrus",Font.BOLD,16));
		label2=new JLabel("Goel");
		label2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		label2.setFont(new Font("Papyrus",Font.BOLD,16));
		
		box.add(label1);
		box.add(label2);
		box.add(label3);
		
		this.add(box);
	}	
}
