//package gopika;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * P082_gspai_panel is a panel containing two JLables 
 * In this program we are creating a panel with the name and a counter that 
 * keeps incrementing. 
 *  
 * @author Gopika Pai
 * gspai@asu.edu
 */
/**
 * This file creates the JPanel and the color is assigned to the 
 * frame on the basis of even and odd numbers 
 */
public class P082_gspai_panel extends JPanel{


    public static int cntr = 0;
/**
 * Private members of the class
 */
    private boolean even;
    private Color type_color;
  
    /**
     *Constructor for the class 
     * 
     */

    public P082_gspai_panel(int val) {
        /**
         * Checks if the value is even, if it is even it assigns a blue color
         * else assigns white
         */
        if(val%2==0)
        {
            even=true;
            cntr=-1;
            type_color=Color.white;  

        }
        else
        {
            even=false;
            cntr=10;
            type_color= new Color(173,216,230); 

        }
        background_color(type_color);

    }
/**
 * Here we set the frame and background of the panel along with 
 * the font and the size 
 */
    public void background_color(Color col) {

      
        setSize(100,100);
        setBackground(col);
        setLayout(new GridBagLayout());
        GridBagConstraints center1 = new GridBagConstraints();
        JLabel Name = new JLabel("<html>Gopika<br>Pai</html>");
        Name.setFont(new Font("Papyrus", Font.PLAIN, 10));
        center1.gridx=0;
        center1.gridy=0;
        add(Name,center1);

        JLabel  Counter = new JLabel(String.valueOf(cntr));
        Counter.setFont(new Font("Papyrus", Font.PLAIN, 10));
        center1.gridx=0;
        center1.gridy=1;
        add(Counter, center1);
        
        /**
         * Timer value is wrapped in between try and catch to handle exceptions during runtime
         */
        
        try {

            TimerTask new_counter = new TimerTask()
            {
                public void run()
                {
                    if(even)
                    {
                        cntr = (cntr+1)%10;


                    }
                    else
                    {
                        if(cntr>0)
                            cntr = (cntr-1)%10;
                        else
                            cntr=9;


                    }

                    Counter.setText(String.valueOf(cntr));
                }
            };

            Timer t1 = new Timer();
            long Delay = 5L;
            long TimeLapse = 1000L;
            t1.scheduleAtFixedRate(new_counter, Delay, TimeLapse);

        } catch(Exception e)
        {
            e.printStackTrace();
        }


    }




  /** public static void main(String[] args) {

        JFrame sampleJframe1 = new JFrame("Gopika's Frame");
       // sampleJframe1.setSize(1000,1000);
        P082_gspai_panel obj1 = new P082_gspai_panel (5);
        //sampleJframe1.setLayout(new GridLayout(5,5));
        sampleJframe1.add(obj1 );
        sampleJframe1.setVisible(true);
        sampleJframe1.pack();
        sampleJframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }*/
}
