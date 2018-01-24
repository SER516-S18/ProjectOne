import java.awt.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.lang.Exception;
import javax.swing.border.EmptyBorder;

/**
 * P061_KUMAR_PANEL: A panel with three rows of JLabel is created.
 * First Row has the firstname of the class author.
 * Second Row has the last name of the class author.
 * Third Row is a counter which increases or decreases based on the parameter passed to the constructor when creating the object.
 * @author Natalya Kumar
 * @version 1.0
 */
public class P061_KUMAR_PANEL extends JPanel {
    private int counter;
    private boolean even;
    public static Color LIGHT_BLUE = new Color(173,216,230);
    public static Font FONT = new Font("Papyrus", Font.PLAIN, 15);
    private static final String FIRSTNAME="Natalya";
    private static final String LASTNAME="Kumar";


    //Constructor taking integer input.
    //If the integer is even then even=true and counter is set to 0 and then increses. 
    public P061_KUMAR_PANEL(int color_val) {
        if (color_val % 2 == 0) {
            even = true;
            counter = 0;
        } else {
            even = false;
            counter = 9;
        }

        prepPanel(color_val);
    }

    /**
     *This method creates a panel with 3 JLabels. First name, Last name and a timer.
     */
    public void prepPanel(int color_val) {

        JLabel firstName,lastName;
         //Creating Label for First Name
        firstName = new JLabel(FIRSTNAME, JLabel.CENTER);       
        firstName.setFont(FONT);
        firstName.setHorizontalAlignment(JLabel.CENTER);
        firstName.setVerticalAlignment(JLabel.CENTER);
        this.add(firstName);

        //Creating Label for Last Name
        lastName = new JLabel(LASTNAME, JLabel.CENTER);            
        lastName.setFont(FONT);
        lastName.setHorizontalAlignment(JLabel.CENTER);
        lastName.setVerticalAlignment(JLabel.CENTER);
        this.add(lastName);

        //Creating Label for timer
        JLabel counterShow = new JLabel("0", JLabel.CENTER);
        Timer t = new Timer();                                      
        counterShow.setFont(FONT);
        counterShow.setHorizontalAlignment(JLabel.CENTER);
        counterShow.setVerticalAlignment(JLabel.CENTER);
        this.add(counterShow);

        this.setLayout(new GridLayout(3, 0));
        // Checking if color_val is ODD or EVEN
        if (color_val % 2 == 0) {  
            setBackground(Color.WHITE);                     
        } else {
            setBackground(LIGHT_BLUE);                       
        }

        // Scheduling the Timer Task and incrementing or decrementing based on the parameter passed
        t.schedule(new TimerTask() {                         
            @Override
            public void run() {
                if (even==true) {
                    if (counter == 10)                       
                        counter = 0;
                    counterShow.setText(""+ counter++);      
                } else {
                    if (counter == -1)                       
                        counter = 9;
                    counterShow.setText(""+ counter--);      
                }
            }
        }, 0, 1000);
    }
}
