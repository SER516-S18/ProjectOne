import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

//CLASS P056_KHATUN_PANEL

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
		if(value%2==0)
		{
			setBackground(Color.decode("#ffffff"));
			isEven=true;		
		}
		else
		{
			setBackground(new Color(173,216,230));
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

	/* TO TEST
	public static void main(String args[])     {
		 
		P056_Khatun_Panel p= new P056_Khatun_Panel(3);
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.add(p);
		frame.setVisible(true);
	}
	*/
	
}//END OF CLASS