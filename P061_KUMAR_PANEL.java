import java.awt.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.lang.Exception;
import javax.swing.border.EmptyBorder;

public class P061_KUMAR_PANEL extends JPanel {
    private int counter;
    private boolean even;


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

    /*public static void main(String[] args) {
        
        P061_KUMAR_PANEL panel28 = new P061_KUMAR_PANEL(2);
        JFrame frame = new JFrame("61-Frame");
        frame.setSize(300, 300);                             //Setting Panel Size
        frame.add(panel28);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }*/

    public void prepPanel(int color_val) {

        setLayout(null);
        setSize(100, 100);
        JLabel firstName,lastName;

        firstName = new JLabel("Natalya", JLabel.CENTER);       //Creating Label for First Name
        firstName.setBounds(10, 0, 45, 25);
        firstName.setFont(new Font("Papyrus", Font.PLAIN, 10));
        firstName.setHorizontalAlignment(JLabel.CENTER);
        firstName.setVerticalAlignment(JLabel.CENTER);
        add(firstName);

        lastName = new JLabel("Kumar", JLabel.CENTER);            //Creating Label for Last Name
        lastName.setBounds(10, 10, 45, 25);
        lastName.setFont(new Font("Papyrus", Font.PLAIN, 10));
        lastName.setHorizontalAlignment(JLabel.CENTER);
        lastName.setVerticalAlignment(JLabel.CENTER);
        add(lastName);

        JLabel counterShow = new JLabel("0", JLabel.CENTER);
        counterShow.setBounds(10, 20, 25, 25);
        Timer t = new Timer();                                      //Creating Label for timer
        counterShow.setFont(new Font("Papyrus", Font.PLAIN, 10));
        counterShow.setHorizontalAlignment(JLabel.CENTER);
        counterShow.setVerticalAlignment(JLabel.CENTER);
        add(counterShow);

        setLayout(new BorderLayout(0, 0));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        if (color_val % 2 == 0) {                           // Checking if color_val is ODD or EVEN
            setBackground(Color.WHITE);                     // Setting Panel Background to White
        } else {
            Color lightBlue = new Color(173,216,230);       
            setBackground(lightBlue);                       // Setting Panel Background to Light Blue
        }

        t.schedule(new TimerTask() {                         // Scheduling the Timer Task
            @Override
            public void run() {
                if (even==true) {
                    if (counter == 10)                       //if counter is 10 setting it to 0
                        counter = 0;
                    counterShow.setText(""+ counter++);      //incrementing the counter
                } else {
                    if (counter == -1)                       //if counter is -1 setting it to 9
                        counter = 9;
                    counterShow.setText(""+ counter--);      //decrementing the counter
                }
            }
        }, 0, 1000);
    }

}