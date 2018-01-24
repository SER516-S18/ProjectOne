import java.awt.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
/*
*Author: Shreyas Hosahalli Govindaraja
* Date:01/23/2018
* Description: This is a part of the SER 516 Lab1. In this code,
* I have implemented a panel which will be part of the tab,and integrated
  into a Frame
 */
public class P041_Hosahalli_Panel extends JPanel{
    private int count;
    private JLabel timer;
    private boolean evenNumber;
    private Color lightBlue = new Color(173,216,230);
    //Constructor which takes a counter value as argument
    //sets the background color to white or light blue
    // and initialize the counter(0-9)
    public P041_Hosahalli_Panel(int counterValue) {
        Color background_color;
        if (counterValue % 2 == 0) {
            evenNumber = true;
            background_color = Color.WHITE;
            count = 0;
        } else {
            evenNumber = false;

            background_color = lightBlue;
            count = 9;
        }
        setSize(100, 100);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JLabel firstName,lastName;

        //creating the labels in the panel
        firstName = new JLabel("Shreyas",JLabel.CENTER);
        lastName = new JLabel("Govindaraja",JLabel.CENTER);
        timer = new JLabel("0", JLabel.CENTER);

        //setting the font size and style of label
        firstName.setFont(new Font("Papyrus", Font.PLAIN, 15));
        lastName.setFont(new Font("Papyrus", Font.PLAIN, 15));
        timer.setFont(new Font("Papyrus", Font.PLAIN, 15));

        //setting the alignment of the label
        firstName.setAlignmentX(Component.CENTER_ALIGNMENT);
        lastName.setAlignmentX(Component.CENTER_ALIGNMENT);

        //adding the panel to the label
        add(firstName);
        add(lastName);
        add(timer);
        setBackground(background_color);
        try{
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (evenNumber) {
                        if (count == 10)
                            count = 0;
                        timer.setText(""+ count++);
                    } else {
                        if (count == -1)
                            count = 9;
                        timer.setText(""+ count--);
                    }
                }
            }, 0, 1000);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
