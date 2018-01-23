import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//CLASS P056_KHATUN_PANEL

public class P056_Khatun_Panel extends JPanel {

	//private static final long serialVersionUID = 1L;

	/* 
	public static void main(String args[])  
    {
		//OBJECT OF THIS CLASS IS CREATED
		P056_Khatun_Panel p = new P056_Khatun_Panel(5);		
		p.createPanel();
    }
    */
	
	Color color;
	Boolean isEven;
	
	//CONSTRUCTOR 
	P056_Khatun_Panel(int value){
		
		Color blue = new Color(173, 216, 230);
		Color white = new Color(255, 255, 255);
		
		if(value%2==0)
		{
			color = white;
			isEven = true;
			
		}

		//IF VALUE IS NOT EVEN,BACKGROUND LIGHT BLUE COUNTER DECREASES
		else {
				//panel.setBackground(blue);
				color = blue;
				isEven = false;
			
		}

	}
	//CREATING A PANEL WITH DESIRED FUNCTIONALITY 
	public void createPanel()
	{
		// CREATE PANEL + PANEL PROPERTIES
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(20,20,200,200);
		panel.setBackground(color);;
		
		// CREATE NAME LABEL + LABEL PROPERTIES
		JLabel lblName = new JLabel("<html>Raisa<br>Khatun</html>");
		lblName.setLayout(null);
		lblName.setBounds(75,40,50,50);
		lblName.setFont(new Font("Papyrus",Font.PLAIN, 15));
		
		// CREATE COUNTER LABEL + LABEL PROPERTIES
		JLabel lblCounter = new JLabel();
		lblCounter.setLayout(null);
		lblCounter.setBounds(90,100,50,50);
		lblCounter.setFont(new Font("Papyrus",Font.PLAIN, 15));
		
		// ADD LABELS TO PANEL
		panel.add(lblName);
		panel.add(lblCounter);
		
		/* 
		// CREATE FRAME
		JFrame frame= new JFrame("");

		// ADD PANEL TO FRAME
		frame.setSize(300, 300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(panel);
		*/

		
		Integer c = 0;
		while(true)
		{
			//IF VALUE IS EVEN, COUNTER INCREASES
			if(isEven)
			{
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

			//IF VALUE IS NOT EVEN, COUNTER DECREASES
			else {
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