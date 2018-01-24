//package swing;
//Lab 1

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 *  @author: Tejasi Palkar
 *  @version: 1.0
 *  @createdOn:  23 January, 2018
 *
 *  This file creates a JPanel, the panel is painted with a color-white(for a even ID author) 
 *  and Blue(for an odd ID author) and  contains name of the author and a counter that runs 
 *  from 0-9/9-0 added as labels depending on the type of ID of the author
 *
 */

public class P083_Palkar_Panel extends JPanel{

/* Preset variable for the counter
* */
 public static int counter=0;
	
/*Private members for the class
* */
private JLabel Name;	
private JLabel Counter;	
private Color bgColor;	
	
	/*
	 * Constructor for the class
	 */
		public P083_Palkar_Panel(int ID) {
		/*
		 * If the ID is even , initialises background color to white and counter is set to -1
		 * Otherwise , background color value is set to blue and counter decreases from 9 to 0 and hence 
		 * counter is set to 10
		 * */
		if(ID%2==0)
		{
			bgColor=Color.white;
			counter=-1;
			CreatePanel(bgColor);
			
		}
		else
		{
			bgColor=new Color(173, 216, 230);
			counter=10;
			CreatePanel(bgColor);
		}
	}
	/*
	 * creates a panel with set value of bacgkround color(white or blue), having predefined size and color passed as parameter
	 * Arranges the labels on the panel,sets the size and font such that the labels are located on the
	 * center of the panel
	 * 
	 */

	private void CreatePanel(Color bgColor) 
	{
		setSize(100,100);
		setLayout(new GridBagLayout());
		setBackground(bgColor);
		
		Name =new JLabel("<html>Tejasi<br>Palkar</html>");
		setFont(new Font("Papyrus", Font.PLAIN, 15));
        
        Counter = new JLabel(String.valueOf(counter));
        Counter.setFont(new Font("Papyrus", Font.PLAIN, 15));
       
        GridBagConstraints GbcObj= new GridBagConstraints();
        GbcObj.gridx=0;
		GbcObj.gridy=0;
		add(Name,GbcObj);
		
		GbcObj.gridx=0;
        GbcObj.gridy=1;
        add(Counter,GbcObj);
        
        RunTimer(bgColor);	
	}
	/*
	 * Method call to run the timer from 0 to 9 if background color is white
	 * and from 9 to 0 if the background color is blue.The counter value keeps changing every second
	 * The run method is kept within try and catch to handle exception at the runtime
	 * 
	 */

	private void RunTimer(Color bgColor2)
	{
		// TODO Auto-generated method stub
		try {

            TimerTask updateCounter = new TimerTask()
            {
                public void run()
                {
                    if(bgColor2==Color.WHITE)
                    {
                        
                        counter = (counter+1)%10;
                    }
                    else
                    {
                        if(counter>0)
                        counter = (counter-1)%10;
                        else
                        counter=9;
                    }

                    Counter.setText(String.valueOf(counter));
                }
            };

            Timer t1 = new Timer();
            long delay = 5L;
            long timeLapse = 1000L;
            t1.scheduleAtFixedRate(updateCounter, delay, timeLapse);
        } 
        catch(Exception e)
        {
            e.printStackTrace();//Displays in message the cause of runtime error
        }


    }
 	
	//Main method to test the above class' methods
	
 /*
	public static void main(String[] args) 
	{
	        JFrame F = new JFrame("Frame_Palkar");
	        P083_Palkar_Panel obj1 = new P083_Palkar_Panel(83);
	        F.setVisible(true);
	        F.add(obj1);
	        F.pack();
	        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }*/

}

