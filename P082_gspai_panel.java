package gopika;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * P082_gspai_panel is a panel containing two JLables 
 * In this program we are creating a panel with the name and a counter that keeps incrementing. 
 *  
 * @author Gopika Pai
 * gspai@asu.edu
 */

public class P082_gspai_panel extends JPanel{


    public static int cntr = 0; //initializing counter to 0

    private boolean even;
    private Color type_color;

    public P082_gspai_panel(int val) {
        if(val%2==0)
        {
            even=true;
            cntr=-1;
            type_color=Color.white;  // setting with white color if the value is even

        }
        else
        {
            even=false;
            cntr=10;
            type_color=Color.blue; // if value is odd we set with blue color

        }
        background_color(type_color);//this calls to set the background color

    }

    public void background_color(Color col) {

      
        setSize(100,100);//here we set the size of panel to 100 and 100
        setBackground(col);//initially setting the background color of the whole panel
        JLabel Name = new JLabel("<html>Gopika<br>Pai</html>");//Create and initialise Name label with the name of the person
        Name.setFont(new Font("Papyrus", Font.PLAIN, 10));
        add(Name);

        JLabel  Counter = new JLabel(String.valueOf(cntr));//Create and Initialise Counter label with the counter value
        Counter.setFont(new Font("Papyrus", Font.PLAIN, 10));
        add(Counter);
        
        //Timer value is wrapped in between try and catch to handle exceptions during runtime
        try {

            TimerTask new_counter = new TimerTask()
            {
                public void run()// Methods to change the value of the counter. 
                {
                    if(even)
                    {
                        cntr = (cntr+1)%10;//Counter runs from 0 to 9 if ID is even


                    }
                    else
                    {
                        if(cntr>0)
                            cntr = (cntr-1)%10;//Counter runs from 9 to 0 if ID is odd
                        else
                            cntr=9;


                    }

                    Counter.setText(String.valueOf(cntr));//Sets the value of Counter label with the current value and updates continously
                }
            };

            Timer t1 = new Timer();
            long Delay = 5L;//A set delay with which the counter needs to be updated
            long TimeLapse = 1000L;//The time gap between successive counter
            t1.scheduleAtFixedRate(new_counter, Delay, TimeLapse);

        } catch(Exception e)
        {
            e.printStackTrace();//Displays errors
        }


    }




    public static void main(String[] args) {

        JFrame sampleJframe1 = new JFrame("Gopika's Frame");
        sampleJframe1.setSize(1000,1000);
        P082_gspai_panel obj1 = new P082_gspai_panel (5);
        sampleJframe1.setLayout(new GridLayout(5,5));
        sampleJframe1.add(obj1 );
        sampleJframe1.setVisible(true);
        sampleJframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}