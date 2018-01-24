import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Class Assignment - 1
 * Author : Abhishek Parmar (aparmar2)
 * Description : 
 * This class will create JPanel containing person's name with 
 * background color and counter value set according to person's ID.
 * 
 */

public class P087_Parmar_Panel extends JPanel {
	
    public static int counter = 0;
    private boolean isOdd;
    private Color col;
    public final static Color LIGHT_BLUE = new Color(173, 216, 230); // To set background color of panel

    
    // Constructor to set counter and background color according to ID.
    public P087_Parmar_Panel(int id) {
        if(id%2==0)
        {
            isOdd=false;
            counter=-1;
            col=Color.white;
        }
        else
        {
            isOdd=true;
            counter=10;
            col=LIGHT_BLUE;
        }
        setPanel(col);
    }

    // To make panel, set background color, set name and counter.
    public void setPanel(Color col) {

        setSize(100,100);
        //To align labels in center
        setLayout(new GridBagLayout());
      	//A GridBagConstraint object to set x and y coordinate of name and counter in grid.
        GridBagConstraints a = new GridBagConstraints();
        
        setBackground(col);

        // Setting label for First and last Name.
        JLabel labelName = new JLabel("<html><b>Abhishek<br>Parmar</b></html>");//Initialises Name label with the name of the person
        a.gridx =0;
        a.gridy =0;
        labelName.setFont(new Font("Papyrus", Font.PLAIN, 15));
        add(labelName,a);

        // Setting label for counter.
        JLabel labelCount = new JLabel(String.valueOf(counter));//Initialises Counter label with the counter value
        labelCount.setFont(new Font("Papyrus", Font.PLAIN, 15));
        a.gridx = 0;
        a.gridy = 1;
        add(labelCount,a);

        //Changing the counter values using timer.
        //Used try and catch for exception handling.
        try {
            TimerTask task = new TimerTask()
            {
                public void run()
                {
                    //If ID is odd setting counter to run from 9 to 0.
                    if(isOdd)
                    {
                    	if(counter>0)
                            counter = (counter-1)%10;
                        else
                            counter=9;
                    }
                    //If ID is even setting counter to run from 0 to 9.
                    else
                    {
                    	counter = (counter+1)%10;
                    }
                    labelCount.setText(String.valueOf(counter));
                }
            };

            // Setting timer class to run every second(1000 ms).
            Timer t = new Timer();
            long delay = 5L; // To start execution after 5ms.
            long intervalPeriod = 1000L;
            t.scheduleAtFixedRate(task, delay, intervalPeriod);

        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}

