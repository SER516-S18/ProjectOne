/*The program creates a panel with two labels which are name and timer.
**@author Jahnavi Bantupalli
**@version- 01-20-2018
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


//Defining a jpanel
public class P006_Bantupalli_Panel extends JPanel implements ActionListener {
	private JLabel nameLabel ;				//label for first name and last name.
	private JLabel timerLabel;				//label for timer
	private static int counter;			//counter to implement timer.
	private static boolean countUp;	//flag for count up and count down.
	public class UpdateCount implements Runnable	//thread for implementing timer.
	{
		public void run(){
			if(countUp)
			{
				//increase counter value for count up.
				counter=counter+1;	
				//if counter exceeds 9 start from 0 again.
				if(counter==10)
					counter=0;
			}
		else
		{
			//decrease the counter value for count down.
				counter=counter-1;		
			//if counter is less than 0, start from 9 again.
				if(counter==-1)
					counter=9;
		}						
			//add counter to the timer label.
			timerLabel.setText(Integer.toString(counter));	

		}
		}
	

	public P006_Bantupalli_Panel(int i) {
		super();
		
		
		if(i%2==0)										
		{
			//set background color to white if i is even.
			setBackground(Color.white);
			//set the timer to count up.
			countUp=true;
			counter=-1;
			
		}
		else
		{
			//set background color to light blue if i is odd.
			setBackground(new Color(243,255,255));	
			//set the timer to count down.
			countUp=false;
			counter=10;
		}
		makeApplication();
	}

	//Creates the panel with required specifications.
	public void makeApplication()					
	{
		//sets layout,font,border and size for the panel
		
		this.setFont(new Font("Papyrus",Font.PLAIN,10));
		this.setPreferredSize(new Dimension(100, 100));
		this.setLayout(null);
		this.setBounds(100,100, 100, 100);
		//customizing name label.
		nameLabel=new JLabel("<html>Jahnavi<br>Bantupalli</html>",JLabel.CENTER);
		nameLabel.setFont(new Font("PAPYRUS",Font.PLAIN,15));
		nameLabel.setBounds(50, 5, 200, 100);
		//customizing timer label
		timerLabel= new JLabel("",JLabel.CENTER);
		timerLabel.setFont(new Font("PAPYRUS",Font.PLAIN,15));
		timerLabel.setBounds(50, 50, 200, 100);
		//create a timer that generates an event after 1 second and pass it the frame object which handles the action event by implementing the ActionListener interface
		Timer timer=new Timer(1000,this);
		try
		{
		//start the timer
		timer.start();					
		}
		catch(Exception e)
		{
			//Handles any exceptions
			System.out.println("The timer failed to start"+e.getMessage());
		}
		//adds name label to the panel
		this.add(nameLabel);		
		//adds timer label to the panel
		this.add(timerLabel);				

		
	}



	@Override
	public void actionPerformed(ActionEvent e){
		try
		{
			//invokes thread
		javax.swing.SwingUtilities.invokeLater(new UpdateCount());
		}
		catch(RuntimeException exception)
		{
			//handles run time exceptions.
			nameLabel.setText("Thread failed to start due to "+exception.getMessage());		
		}
		}

/*	public static void main(String args[])
	{
		 //creates a panel
	    P006_Bantupalli_Panel jb= new P006_Bantupalli_Panel(3);
	  //makes the panel satisfy the given requirements.
	    jb.makeApplication();									
	    JFrame mainFrame = new JFrame("Java Application");
	    JPanel mainPanel= new JPanel(new BorderLayout());
	    mainPanel.add(jb);
		mainFrame.setSize(400,400);
		mainFrame.setContentPane(mainPanel);;
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		
		
	}
	*/

}
