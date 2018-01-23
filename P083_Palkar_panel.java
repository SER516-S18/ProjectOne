/*Lab 1
Author:Tejasi Palkar
This file creates a JPanel, the panel is painted with a color-white(for a even ID author) and Blue(for an odd ID author)
and  contains name of the author and a counter that runs from 0-9/9-0 added as labels depending on the type of ID of the author
*/



//package pkg516;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class P083_Palkar_panel extends JPanel{


 public static int counter=0;
	private JLabel Name;	//Private members
	private JLabel Counter;	//Private members
	private Color bgColor;	//Private members
	
	public P083_Palkar_Panel1(int ID) {
		// TODO Auto-generated constructor stub
		if(ID%2==0)
		{
			bgColor=Color.white;//Set panel color to white if ID is even
			counter=-1;//Set counter value
			CreatePanel(bgColor);//Create Panel with set background color
			
		}
		else
		{
			bgColor=Color.BLUE;//Set panel color to white if ID is even
			counter=10;//Set counter value
			CreatePanel(bgColor);//Create Panel with set background color
		}
	}

	private void CreatePanel(Color bgColor) 
	{
		setSize(100,100);//Set panel size
		setLayout(new GridBagLayout());
		setBackground(bgColor);//Set background color with the passed value
		
		Name =new JLabel("<html>Tejasi<br>Palkar</html>");//Initialise name label
		setFont(new Font("Papyrus", Font.PLAIN, 15));//Set font for the label
        
        Counter = new JLabel(String.valueOf(counter));//Create and Initialise Counter label with the counter value.Represents the gUI component to be added on the panel
        Counter.setFont(new Font("Papyrus", Font.PLAIN, 15));//Set the column address for the counter
       
        GridBagConstraints GbcObj= new GridBagConstraints();
        GbcObj.gridx=0;//Set the column address for the name
		GbcObj.gridy=0;//Set row address for name
		add(Name,GbcObj);//Add label onto panel
		
		GbcObj.gridx=0;//Set the column address for the counter
        GbcObj.gridy=1;//Set the row address as 1 for the counter below the name label
        add(Counter,GbcObj);//Add counter label onto the panel
        
        RunTimer(bgColor);//Call function to run timer		
	}

	private void RunTimer(Color bgColor2)
	{
		// TODO Auto-generated method stub
		try {

            TimerTask updateCounter = new TimerTask()//Create an Object of TimerTask Class
            {
                public void run()//Method to change counter value
                {
                    if(bgColor2==Color.WHITE)
                    {
                        
                        counter = (counter+1)%10;//Counter runs from 0 to 9 if ID is even
                    }
                    else
                    {
                        if(counter>0)
                        counter = (counter-1)%10;//Counter runs from 9 to 0 if ID is odd
                        else
                        counter=9;
                    }

                    Counter.setText(String.valueOf(counter));//Sets the value of Counter label with the current value and updates continously
                }
            };

            Timer t1 = new Timer();//Creates a new object of the timer class
            long delay = 5L;//The delay after which counter should start getting updated
            long timeLapse = 1000L;//The time gap between successive counter values
            t1.scheduleAtFixedRate(updateCounter, delay, timeLapse);//Method to update the counter value after fixed time lapse.The process of counter updation starts after given delay

        } 
        catch(Exception e)
        {
            e.printStackTrace();//Displays in message the cause of runtime error
        }


    }
 	
 /*
	public static void main(String[] args) 
	{
	        JFrame F = new JFrame("Frame_Palkar");
	        P083_Palkar_Panel1 obj1 = new P083_Palkar_Panel1(83);
	        F.setVisible(true);
	        F.add(obj1);
	        F.pack();
	        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }*/

}
