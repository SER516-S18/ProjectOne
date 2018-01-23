/*JLabel with my full name, 
 * First row is my first name, second row is my last name.
 * A JLabel displaying a number, changing from 0-9 automatically.
 * When the number is even, background is white and counter plus one.
 * when the number is odd, background is light blue and counter minus one
 * Author: Yiru Hu. 
 * ASU id:	1213523322
 * Email:yiruhu@asu.edu
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class P042_Hu_Panel extends JPanel{

	private boolean flag;
	private int second;
	private Color color;

	
	public P042_Hu_Panel(int second) {
		super();
		//Check the second is even or odd 
		if((second%2) == 0) {
			//If second is even,background is white
			this.color = Color.white;
			this.flag=true;
			this.second = 0;
		}else {
			//If second is odd, background is light blue
			this.color = new Color(171,216,230);
			this.flag=false;
			this.second = 9;
		}
		this.create();
	}
	

	private void create() {
		Font font = new Font("Papyrus", Font.PLAIN, 15);
		
		//set panel
		setLayout(new GridLayout(2, 1));
		setPreferredSize(new Dimension(100, 100));
		setMinimumSize(new Dimension(100, 100));
		setBackground(this.color);
		
		//my name
		JLabel label1 = new JLabel("<html>Yiru<br>Hu</html>",JLabel.CENTER);
		label1.setFont(new java.awt.Font("Papyrus", Font.PLAIN, 10));  
		add(label1);

		//JLabel for time counter
		JLabel label2 = new JLabel(Integer.toString(second), JLabel.CENTER);
		label2.setFont(font);
		add(label2);
		
		//Configuring timer	and exception	
		try
		{
			ActionListener taskPerformer = new ActionListener() {
			int time;
			
			public void actionPerformed(ActionEvent evt) {
				if(flag) {
					time++;
				}
				else
				{
					time--;
					if(time<0)
					{
						time=time+10;
					}
				}
				second = time%10;
				label2.setText(Integer.toString(second));
			}
		};	
		//run my timer task
		Timer timer = new Timer(1000, taskPerformer);
		timer.start();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }	
}

