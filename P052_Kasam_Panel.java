import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;

/*
Contains a Jlabel with first name and last name in separate rows
Another JLabel dispaying a down counter or an up counter (i.e, either from 0 to 9 or from 9 to 0)
Contains a background color, either light blue or white (based on the integer value passed to the constructor)
A constructor which receives an integer value as a parameter and if the value is even ( if modulo 2 is 0) then background is white,
and the upcounter functions.
Try-catch statements are also included for handling exceptions (while the use of threads for the display of cnt label)

@author Vineesha Kasam
*/

public class P052_Kasam_Panel {
	
	private JPanel kasamPanel;
	private JLabel myfirstlastName; 
	private JLabel cnt;
	
	private String evenOrOddString;
	
	//Creation of a constructor which receives an integer as a parameter AND
	//Assigns values EVEN and ODD to the respectively to the variable "evenOrOddString"
	
	public P052_Kasam_Panel(int integerValue) 
	{
		
		if(integerValue%2 == 0)
		{
			evenOrOddString = "EVEN";
		}
		else
		{
			evenOrOddString = "ODD";
		}
	}

	public JPanel P052_Kasam_Panel() {
		
		kasamPanel = new JPanel();

		kasamPanel.setLayout(new BoxLayout(kasamPanel, BoxLayout.Y_AXIS));

		//Based on the parameter passed and the "evenOroddString" variable, we set the background color either to white or light blue
		// (This is done after the constructor is called with the integer parameter
		
		if(evenOrOddString == "EVEN")
		{
			kasamPanel.setBackground(Color.white);
		}
		else
		{
			kasamPanel.setBackground(new Color(173,216,230));
		}
		
		//setting differenty parameters for kasamPanel
		kasamPanel.setPreferredSize(new Dimension(100,100));

		kasamPanel.setMaximumSize(kasamPanel.getPreferredSize() );
		
		// creating two JLabels for my first name and last name in two separate rows AND 
		// counter display on sepearte row
	
		myfirstlastName =  new JLabel("<html><br>Vineesha<br>Kasam<br></html>");
		cnt = new JLabel();
		
		// Add the labels to the kasamPanel
		kasamPanel.add(myfirstlastName);
		kasamPanel.add(cnt);
		kasamPanel.setVisible(true);
		
		if(evenOrOddString == "EVEN") 
		{
			// Run a thread when an even integer is passed and the upcounter functions and
			// also exceptions are handled
			new Thread()
			{
	        		int increment = 0;
	        		public void run()
				{
	            			while(true)
					 {
	            				if(increment == 10)
						{
	            					increment = 0;
						}
	            		
	                			cnt.setText(" " + (increment));
	                			increment++;

	               		 		try
						{
	                    				Thread.sleep(1000);
	                			} 
						catch(Exception exception) 
						{
							System.err.println("Exception is caught: " + exception.getMessage());
						}
	            			}
	        		}
	   		 }.start();
		}
		else
		{
			// Run a thread when an odd integer is passed and the down counter functions and
			// also exceptions are handled
			new Thread() 
			{
	        		int decrement = 9;
	        		public void run() 
				{
	            			while(true) 
					{
	            				if(decrement == -1)
						{
	            					decrement = 9;
						}

	                			cnt.setText(" " + (decrement));
	                			decrement--;
	                			try
						{
	                				Thread.sleep(1000);
	                			} 
						catch(Exception exception) 
						{
							System.err.println("Exception is caught: " + exception.getMessage());
						}
	           			 }
	        		}
	    		}.start();
		}
			
		return kasamPanel;
	}
	
	
	
	// main function was written just to see how the panel is displayed

	public static void main(String[] args) {
		
		P052_Kasam_Panel myPanelObject = new P052_Kasam_Panel(4);
		//P052_Kasam_Panel myPanelObject = new P052_Kasam_Panel(3);

		JPanel myPanel = myPanelObject.P052_Kasam_Panel();

		JFrame frame = new JFrame("My Panel (Vineesha Kasam)");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// adding mypanel created to the frame
		frame.getContentPane().add(myPanel);
		frame.pack();
		frame.setVisible(true);
	}
}
