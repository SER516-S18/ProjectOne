import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//CLASS P056_KHATUN_PANEL

public class P056_Khatun_Panel {

	
	public static void main(String args[])  
    {
		//OBJECT OF THIS CLASS IS CREATED
		new P056_Khatun_Panel(5);		
    }
	
	//CONSTRUCTOR 
	P056_Khatun_Panel(int x){
		createPanel(x);
	}
	
	public void createPanel(int value)
	{
		// CREATE PANEL + PANEL PROPERTIES
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(20,20,200,200);
		panel.setBackground(Color.decode("#3cbde7"));
				
		// CREATE NAME LABEL + LABEL PROPERTIES
		JLabel lblName = new JLabel("<html>Raisa<br>Khatun</html>");
		lblName.setLayout(null);
		lblName.setBounds(75,40,50,50);
		
		// CREATE COUNTER LABEL + LABEL PROPERTIES
		JLabel lblCounter = new JLabel();
		lblCounter.setLayout(null);
		lblCounter.setBounds(90,100,50,50);
		
		// ADD LABELS TO PANEL
		panel.add(lblName);
		panel.add(lblCounter);
		
		// CREATE FRAME
		JFrame frame= new JFrame("");

		// ADD PANEL TO FRAME
		frame.setSize(300, 300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(panel);

		Integer c = 0;
		while(true)
		{
			//IF VALUE IS EVEN, INCREASE COUNTER AND BACKGROUND WHITE
			if(value%2==0)
			{
				panel.setBackground(Color.decode("#ffffff"));
				try {					
					for(c=0;c<9;c++)
					{
						lblCounter.setText(c.toString());					
						Thread.sleep(1000);
					}										
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
		
				try {
					for(c=9;c>0;c--)
					{						
						lblCounter.setText(c.toString());							
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			//IF VALUE IS NOT EVEN,BACKGROUND CYAN COUNTER DECREASES
			else {
					panel.setBackground(Color.decode("#3cbde7"));
					try {
						for(c=9;c>0;c--) {								
							lblCounter.setText(c.toString());								
							Thread.sleep(1000);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
					try {						
						for(c=0;c<9;c++)
						{
							lblCounter.setText(c.toString());						
							Thread.sleep(1000);
						}						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}							
		}//END OF WHILE LOOP				
			
	}//END OF CREATEPANEL METHOD									

}//END OF CLASS