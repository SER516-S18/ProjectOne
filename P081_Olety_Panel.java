/*
 * SER 516 ID 81
 * Name: Namratha Olety Venkatesh
 * Class: P081_Olety_Panel
 * Group 4
 * */
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Font;

public class P081_Olety_Panel extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JFrame frame = new JFrame();
	JPanel p081Panel = new JPanel();
	JLabel p081Name = new JLabel("<html><br>Namratha<br>Olety Venkatesh<br></html>"); //label for full name
	JLabel p081Timer = new JLabel("");
	int flag=0;
	//parameterized constructor
	public P081_Olety_Panel(int oddeven) 
	{
		//Setup Panel and Label properties
		Font p081NameFont = new Font("Papyrus",Font.BOLD,12); 
		Font p081TimerFont = new Font("Papyrus",Font.BOLD,18);
		Dimension p081PanelSize = new Dimension(100, 100);
		p081Name.setFont(p081NameFont); 
		p081Panel.setPreferredSize(p081PanelSize); 
		p081Panel.add(p081Name);
		p081Timer.setFont(p081TimerFont);
		p081Panel.add(p081Timer);
		frame.add(p081Panel);
		frame.pack();
		frame.setVisible(true);
	
		//check value passed is even or odd
		if(oddeven%2==0) 
		{
			flag=0;
			
			timer(flag);

				
			}
		
		else 
		{
			flag=1;	
			timer(flag);
			//Background white if odd	
		}
			
	}
		
	public void timer(int flag) {	
		new Thread() {
            
            public void run() {
                while(true) {
                	if(flag==0) {
                		//Background blue if even
            			p081Panel.setBackground( new Color(173,216,230) );
                		for (int up = 0; up <=9; up++) {
                    p081Timer.setText(" " +up);
                    try{
                        Thread.sleep(1000);
                    }
                    catch(Exception e) {
                    	System.out.println("Exception in P081_Olety_Panel "+e.getMessage());
                    }
                }
            }
                	else
                	{
                		p081Panel.setBackground(Color.WHITE);
        				//Counter down if parameter is odd
        				for ( int down = 9; down >= 0; down--) {
        					p081Timer.setText("" + down);
        					try {
        						Thread.sleep(1000);
        					} catch (InterruptedException ie) {
        						System.out.println("Exception in P081_Olety_Panel "+ie.getMessage());
        					}
        				}
        		}
                	}
                	
        }
            }
     .start();
	}
	
	public static void main(String[] args) {
		new P081_Olety_Panel(28);
	}
}
