/*JLabel with my full name, 
 * First row is my first name, second row is my last name.
 * A JLabel displaying a number, changing from 0-9 automatically.
 * When the number is even, background is white and counter plus one.
 * Author: Yiru Hu. 
 * ASU id:	1213523322
 * Email:yiruhu@asu.edu
 */
import java.awt.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class P042_Hu_Panel  
{
	static JFrame frame1 = new JFrame();
	//setting background
	public void window()
	{	
      
		frame1.setTitle("Lab1");
		frame1.setSize(100, 100);
		frame1.getContentPane().setBackground(Color.white);
		frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);	
		frame1.setVisible(true);

	}
	
		
	static Timer myTimer = new Timer();
	int second = 0;
	int counter = 0;
	
	//setting timer,and show 0-9
	TimerTask myTask = new TimerTask()
	{
		public void run()
		{
			window();
			//show my name
			JLabel label1 = new JLabel("Yiru");
			label1.setFont(new   java.awt.Font("Papyrus",   1,   10));  
			label1.setBounds(50, 5, 50, 50);
			
			JLabel label2 = new JLabel("Hu");
			label2.setBounds(50, 20, 50, 50);
			label2.setFont(new   java.awt.Font("Papyrus",   1,   10)); 
			 //locate center
			frame1.setLocationRelativeTo(null);
			frame1.add(label1);
			frame1.add(label2);
			JPanel panel = new JPanel();
			
			//show 0 - 9
			String a = ""+second%10;
			JLabel label3 = new JLabel();
			panel.setPreferredSize(new Dimension(100,100));
			label3.setText(a);
			panel.add(label3);
			
			//if the count is even, the background is white
			if(second%2==0)
			{
				panel.setBackground(Color.white);
				counter ++;
			}
			frame1.add(panel);
			second++;	
		}

	};
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		P042_Hu_Panel yiru = new P042_Hu_Panel();
		myTimer.schedule(yiru.myTask,1000,1000);
	}
}


