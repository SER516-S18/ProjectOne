import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class P077_Mohanty_Panel extends JPanel {
	//Initializing JLabels
	JLabel label1 = new JLabel("Abhinab");
	JLabel label2 = new JLabel("Mohanty");
	JLabel label3 = new JLabel();
	
	 //Initializing Color object for the lighter shade of blue
	 Color lightBlue= new Color(173,216,230);
	
	//Initializing counter and up/down values
	int val1=-1,counter=0,val2=10;
	boolean slope=true;


    public JPanel myPanel()
    {
    	 	//Initializing a JPanel with Box Layout
			JPanel newPanel = new JPanel();
			 newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
			 
			 //Setting Font for labels
			 label1.setFont(new Font("Papyrus",Font.PLAIN,15));
			 label2.setFont(new Font("Papyrus",Font.PLAIN,15));
			 label3.setFont(new Font("Papyrus",Font.PLAIN,15));
			 

			 
			 //Setting X-Axis Alignment
			 label1.setAlignmentX(Component.CENTER_ALIGNMENT);
			 label2.setAlignmentX(Component.CENTER_ALIGNMENT);
			 label3.setAlignmentX(Component.CENTER_ALIGNMENT);
		try {	 //Timer Actions defined here
			Timer t = new Timer(1000,new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(counter%2==0)
						{
							slope=true;
							newPanel.setBackground(Color.WHITE);
						
						}
					else 
					{
						slope=false;
						newPanel.setBackground(lightBlue);
					}
					

					

					if(slope)
					{
						if(val1!=9)
						{
						val1++;
						
						String textval = String.valueOf(val1);
						label3.setText(textval);
						}
						else {
							val1 =0;
							label3.setText("0");
						}
					}
					else
					{
						
						if(val2!=0)
						{val2--;
						String textval = String.valueOf(val2);
						label3.setText(textval);
						}
						else {
							val2 = 9;
							label3.setText("9");
						}
					}
					

				}
				
			});
			
			 
			//Adding labels to Panel
			 newPanel.add(label1);
			 newPanel.add(label2);
			 newPanel.add(label3);
			 //Setting Size and Visibility
			 newPanel.setSize(100, 100);
			 newPanel.setVisible(true);

			 
			 
			 add(newPanel);
			 t.start();    
			 //pack();

			 
			
		} catch (Exception e) {
			//  catch block
			e.printStackTrace();
		}
		
		return newPanel;
    	
    }
	
	
	
	
	
	public P077_Mohanty_Panel(int a)
	{
		 counter = a;
	}
	
	
//	public static void main(String[] args){
//        JFrame frame;
//        frame = new JFrame("P077_Mohanty_Panel");
//        frame.setVisible(true);
//        frame.setSize(800, 800);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        P077_Mohanty_Panel obj=new P077_Mohanty_Panel(3);
//        frame.add(obj.myPanel());
//    }
	
	
}
