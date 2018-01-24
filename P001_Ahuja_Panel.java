import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**        For SER 516 only
 *         @author  Chetanya Ahuja
 *         @version 1.0
 *         @since   01-21-2018
 *         It Adds two labels in the
 *         JPanel with Background Color - White if the flag received
 *         through constructor as a parameter is even and light blue
 *         if its odd.
 *         The timer Increments or decrements every second.
 *         It is incremented when the flag received from the constructor
 *         is even, goes from 0 to 9 and repeats,
 *         It is decremented when the flag received from the constructor
 *         is odd, goes fro 9 to 0 and repeats.
 */
public class P001_Ahuja_Panel extends JPanel
{
    int increment= -1;
    int decrement=10;
    JLabel labelName;
    JLabel labelTime;
    private static final Color Light_Blue= new Color(173, 216,230);
    public P001_Ahuja_Panel(int flag)
    {
        /**
         * Panel and label properties: Font, Color, Text, Layout,
         * size and calls function made for the timer execution
         */
        setSize(100,100);
        setLayout(new GridLayout(2, 1));
        labelName = new JLabel("<html>Chetanya<br>Ahuja</html>", JLabel.CENTER);
        labelTime = new JLabel("", JLabel.CENTER);
        labelName.setFont(new Font("Papyrus", Font.PLAIN, 15));
        labelTime.setFont(new Font("Papyrus", Font.PLAIN, 15));
        add(labelName);
        add(labelTime);
        start_timer(flag);
    }
    /**
     * Timer execution : From 0 to 9 when flag is even
     * And from 9 to 0 when flag is odd
     * @param flag
     */
    public void start_timer(int flag)
    {
        try {
            Timer timer1 = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (flag % 2 == 0) {

                        if (increment == 9) increment = -1;

                        increment = increment + 1;
                        labelTime.setText("" + increment);

                    }

                    else {
                        setBackground(Light_Blue);
                        if (decrement == 0)
                        {
                            decrement = 10;
                        }
                        decrement = decrement - 1;
                        labelTime.setText("" + decrement);
                    }

                }
            });

            timer1.start();
        }
        catch (Exception e)//Exception thrown
        {
            System.out.print("Exception Thrown in Timer");
        }
    }
    
}
