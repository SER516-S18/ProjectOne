import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/*The program creates a panel with two labels which are name and timer.
 * The name label has first name and last name.
 * The timer label contains a counter.
 * The counter increments or decrements based on the flag passed to the constructor.
 * Thread class  is used for incrementing or decrementing the counter.
**@author Jahnavi Bantupalli
**@version 01-23-2018
*/

public class P006_Bantupalli_Panel extends JPanel implements ActionListener {
	private JLabel nameLabel ;				
	private JLabel timerLabel;				
	private static int counter;			
	private static boolean countUp;	
	private class UpdateCount implements Runnable	
	{
		public void run(){
			if(countUp)
			{
				counter=counter+1;	
				if(counter==10)
					counter=0;
			}
		else
		{
				counter=counter-1;		
				if(counter==-1)
					counter=9;
		}						
			timerLabel.setText(Integer.toString(counter));	

		}
		}
	
/*Constructor for panel which takes an integer value backgroundFlag as parameter.
 * If backgroundFlag is even, the background of panel is white and the counter is incrementing.
 * If backgroundFlag is odd, the background of panel is light blue and the counter is decrementing.
 *The constructor invokes a method to customize the panel.
 */
	public P006_Bantupalli_Panel(int backgroundFlag) {
		super();
		if(backgroundFlag%2==0)										
		{
			setBackground(Color.white);
			countUp=true;
			counter=-1;	
		}
		else
		{
			Color lightBlue=new Color(173,216,230);
			setBackground(lightBlue);	
			countUp=false;
			counter=10;
		}
		customizePanel();
	}
	
/* This method sets the labels for the panel.
 * It handles in setting various parameters of the panel such as layout,size etc.
 * It also customizes the name and timer labels and adds them to the panel.
 * 
 */

	public void customizePanel()					
	{
		this.setPreferredSize(new Dimension(100, 100));
		this.setLayout(null);
		this.setBounds(100,100, 100, 100);
		nameLabel=new JLabel("<html>Jahnavi<br>Bantupalli</html>",JLabel.CENTER);
		nameLabel.setFont(new Font("PAPYRUS",Font.PLAIN,15));
		nameLabel.setBounds(50, 5, 200, 100);
		timerLabel= new JLabel("",JLabel.CENTER);
		timerLabel.setFont(new Font("PAPYRUS",Font.PLAIN,15));
		timerLabel.setBounds(50, 50, 200, 100);
		Timer timer=new Timer(1000,this);
		try
		{
		timer.start();					
		}
		catch(Exception e)
		{
			System.out.println("The timer failed to start"+e.getMessage());
		}
		this.add(nameLabel);		
		this.add(timerLabel);				
	}
	
/*
 * This function is invoked as the timer progresses.
 * It in turn instantiates the thread to perform the necessary counter operation.
 */
	
	@Override
	public void actionPerformed(ActionEvent e){
		try
		{
		javax.swing.SwingUtilities.invokeLater(new UpdateCount());
		}
		catch(RuntimeException exception)
		{
			nameLabel.setText("Thread failed to start due to "+exception.getMessage());		
		}
		}

}
