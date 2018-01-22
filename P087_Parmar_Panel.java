/*
 * Class Assignment -1
 * Author : Abhishek Parmar (aparmar2)
 * Description : 
 * This class will create JPanel containing person's name with 
 * background color and counter value set according to person's ID.
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class P087_Parmar_Panel extends JPanel {
	
    public static int counter = 0;
    private JLabel labelName ;//To set name label in panel.
    private JLabel labelCount;//To set Counter component in the panel
    private boolean isOdd;
    private Color col; // To set background color of panel

    
    // Constructor to set counter and background color according to ID.
    public P087_Parmar_Panel(int val) {
        if(val%2==0)
        {
            isOdd=false;
            counter=-1;
            col=Color.white;
        }
        else
        {
            isOdd=true;
            counter=10;
            col=Color.blue;
        }
        setPanel();
    }

    // To make panel, set background color, set name and counter.
    public void setPanel() {

        setSize(100,100);
        setBackground(col);

        // Setting label for First and last Name.
        labelName = new JLabel("<html><b>Abhishek<br>Parmar</b></html>");//Initialises Name label with the name of the person
        labelName.setFont(new Font("Papyrus", Font.PLAIN, 10));
        add(labelName);

        // Setting label for counter.
        labelCount = new JLabel(String.valueOf(counter));//Initialises Counter label with the counter value
        labelCount.setFont(new Font("Papyrus", Font.PLAIN, 12));
        add(labelCount);

        //Changing the counter values using timer.
        //Used try and catch for exception handling.
        try {
            TimerTask oneSecondTask = new TimerTask()
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
            t.scheduleAtFixedRate(oneSecondTask, delay, intervalPeriod);

        } catch(Exception e)
        {
            e.printStackTrace();//Displays exception trace.
        }
    }


    /*
     * main() - For Saurabh
     *
    public static void main(String[] args) {

        JFrame sampleJframe1 = new JFrame("Frame");
        sampleJframe1.setSize(1000,1000);
        P087_Parmar_Panel obj = new P087_Parmar_Panel(1);
        sampleJframe1.add(obj );
        sampleJframe1.setVisible(true);

    }
    */
}



