import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*Program to display the first and last name along with a counter that goes from 0-9 if an even number is passed along with the object creation
 * and the background is set to white. In case of an odd number counter counts down from 9-0 and background changes to light blue.
 */


public class P077_Mohanty_Panel extends JPanel {
	//Initializing JLabels
	JLabel first_name = new JLabel("Abhinab");
	JLabel last_name = new JLabel("Mohanty");
	JLabel counter = new JLabel();
	
	 //Initializing Color object for the lighter shade of blue
	 Color lightBlue= new Color(173,216,230);
	
	//Initializing checker and up/down values
	int up_checker=-1,checker=0,down_checker=10;
	boolean slope=true;


    public void myPanel()
    {
    	 	//Initializing a JPanel with Box Layout
			//JPanel newPanel = new JPanel();
			 setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			 
			 //Setting Font for labels
			 first_name.setFont(new Font("Papyrus",Font.PLAIN,15));
			 last_name.setFont(new Font("Papyrus",Font.PLAIN,15));
			 counter.setFont(new Font("Papyrus",Font.PLAIN,15));
			 

			 
			 //Setting X-Axis Alignment
			 first_name.setAlignmentX(Component.CENTER_ALIGNMENT);
			 last_name.setAlignmentX(Component.CENTER_ALIGNMENT);
			 counter.setAlignmentX(Component.CENTER_ALIGNMENT);
		try {	 //Timer Actions defined here
			Timer t = new Timer(1000,new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(checker%2==0)
						{
							slope=true;
							setBackground(Color.WHITE);
						
						}
					else 
					{
						slope=false;
						setBackground(lightBlue);
					}
					

					

					if(slope)
					{
						if(up_checker!=9)
						{
						up_checker++;
						
						String textval = String.valueOf(up_checker);
						counter.setText(textval);
						}
						else {
							up_checker =0;
							counter.setText("0");
						}
					}
					else
					{
						
						if(down_checker!=0)
						{
							down_checker--;
						String textval = String.valueOf(down_checker);
						counter.setText(textval);
						}
						else {
							down_checker = 9;
							counter.setText("9");
						}
					}
					

				}
				
			});
			
			 
			//Adding labels to Panel
			 add(first_name);
			 add(last_name);
			 add(counter);
			 //Setting Size and Visibility
			 setSize(100, 100);
			 setVisible(true);

			 
			 
			 
			 t.start();    
	

			 
			
		} catch (Exception e) {
			
			System.out.println("Exception Occurred:"+e.getMessage());
		}
		
		
    	
    }
	
	
	
	
	
	public P077_Mohanty_Panel(int a)
	{
		 checker = a;
		 myPanel();
	}
	
	
	
	
	 
}
