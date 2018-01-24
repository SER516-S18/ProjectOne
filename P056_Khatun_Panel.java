import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*For SER 516 
 * @author Raisa
 * @version 1.0
 * @since 01-23-18
 */

/*This class adds two labels, a name and a counter to a jpanel 
 * The counter is always either increasing or decreasing
 * the background color of the panel is white and counter 
 * increases from 0 to 9 and then decreases if the value passed
 * to constructor is even
 * If value is odd the background is light blue and counter
 * decreases from 9 to 0 and then increases 
 */

public class P056_Khatun_Panel extends JPanel {
	
	JLabel lblCounter;
	JLabel lblName;
	Boolean isEven;
	
	//CONSTRUCTOR 
	public P056_Khatun_Panel(int value){
	
		// PANEL PROPERTIES
		setLayout(new FlowLayout());
		setVisible(true);
		
		// NAME LABEL PROPERTIES
		JLabel lblName = new JLabel("<html>Raisa<br>Khatun</html>");
		lblName.setBounds(75,40,50,50);
		lblName.setFont(new Font("Papyrus",Font.PLAIN, 15));
		
		// COUNTER LABEL PROPERTIES
		lblCounter = new JLabel();
		lblCounter.setBounds(90,100,50,50);
		lblCounter.setFont(new Font("Papyrus",Font.PLAIN, 15));
		
		// ADD LABELS TO PANEL
		add(lblName);
		add(lblCounter);
		
		// BACKGROUND COLOR SET
		Color lightBlue=new Color(173,216,230);
		Color white=new Color(255,255,255);
		if(value%2==0)
		{
			setBackground(white);
			isEven=true;		
		}
		else
		{
			setBackground(lightBlue);
			isEven=false;
		}
		
		CounterDetails();
			
	}
	
	public void CounterDetails()
	{
		Thread thread = new Thread(new Runnable() {

			Integer c = 0;
			
			@Override
			public void run() {
				
				try {
					while(true)
					{
						//EVEN
						if(isEven)
						{			
							// 0 TO 9
							for(c=0;c<9;c++)
							{
								lblCounter.setText(c.toString());					
								Thread.sleep(1000);
							}										

							// 9 TO 0
							for(c=9;c>0;c--)
							{						
								lblCounter.setText(c.toString());
								Thread.sleep(1000);
							}
						}
						
						//ODD
						else {
							
							// 9 TO 0
							for(c=9;c>0;c--)
							{								
								lblCounter.setText(c.toString());								
								Thread.sleep(1000);
							}
							
							// 0 TO 9
							for(c=0;c<9;c++)
							{
								lblCounter.setText(c.toString());						
								Thread.sleep(1000);
							}
						}
					
					} // END WHILE
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}// END RUN
		});	
		
		thread.start();
	}

	
}//END OF CLASS