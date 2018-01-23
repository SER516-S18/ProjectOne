import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

//CLASS P056_KHATUN_PANEL

public class P056_Khatun_Panel extends JPanel {
	
	Color color;
	Boolean isEven;
	JLabel lblCounter;
	
	//CONSTRUCTOR 
	public P056_Khatun_Panel(int value){
		
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

		// CREATE PANEL + PANEL PROPERTIES
		//JPanel panel=new JPanel();
		this.setLayout(null);
		this.setBounds(20,20,200,200);
		this.setBackground(color);;
		
		// CREATE NAME LABEL + LABEL PROPERTIES
		JLabel lblName = new JLabel("<html>Raisa<br>Khatun</html>");
		lblName.setLayout(null);
		lblName.setBounds(75,40,50,50);
		lblName.setFont(new Font("Papyrus",Font.PLAIN, 15));
		
		// CREATE COUNTER LABEL + LABEL PROPERTIES
		lblCounter.setLayout(null);
		lblCounter.setBounds(90,100,50,50);
		lblCounter.setFont(new Font("Papyrus",Font.PLAIN, 15));
		
		// ADD LABELS TO PANEL
		this.add(lblName);
		this.add(lblCounter);	
		
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

	}// END OF CONSTRUCTOR

}//END OF CLASS