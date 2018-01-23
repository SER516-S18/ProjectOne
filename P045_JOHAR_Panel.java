import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.lang.Exception;
import javax.swing.border.EmptyBorder;

/**
 * P045_JOHAR_Panel describes a panel consisting of three rows of JLabels.
 * Row one is the first name of the author of this class. Row two is the last
 * name of the author. Row three is a counter which increments or decrements
 * depending on the parameter passed to the constructor while creating the object.
 * @author Saheb Singh Johar
 * @version 1.0
 */

public class P045_JOHAR_Panel extends JPanel{

    int counter;
    boolean isEven = false;
    public static Color LIGHT_BLUE = new Color(173,216,230);
    public static Font FONT = new Font("Papyrus", Font.PLAIN, 15);
    private static final String FIRSTNAME="Saheb";
    private static final String LASTNAME="Johar";

    /**
     * Class constructor.
     * @param	num	Describes the background and counter mode of the panel.
     */
    public P045_JOHAR_Panel(int num) {

        counter = 9;
        isEven = false;

        if (num % 2 == 0) {
            isEven = true;
            counter = 0;
        }
        createPanelObject();
    }

    /**
     * This method creates a panel with 3 labels :- firstName, lastName and counter.
     */
    public void createPanelObject()
    {
        Timer timer;
        JLabel firstName;
        JLabel lastName;
        JLabel displayNum;

        //Setting the background color of the panel depending on the input passed to constructor
        if (isEven) {
            setBackground(Color.WHITE);
        } else {
            setBackground(LIGHT_BLUE);
        }

        //First name of the author which goes in the first row
        firstName=new JLabel(FIRSTNAME, JLabel.CENTER);
        firstName.setFont(FONT);
        firstName.setHorizontalAlignment(JLabel.CENTER);
        firstName.setVerticalAlignment(JLabel.CENTER);;
        this.add(firstName);

        //Last name of the author which goes in the second row
        lastName=new JLabel(LASTNAME, JLabel.CENTER);
        lastName.setFont(FONT);
        lastName.setHorizontalAlignment(JLabel.CENTER);
        lastName.setVerticalAlignment(JLabel.CENTER);
        this.add(lastName);

        //Counter value which goes in the last row
        displayNum=new JLabel(String.valueOf(counter), JLabel.CENTER);
        displayNum.setFont(FONT);
        displayNum.setHorizontalAlignment(JLabel.CENTER);
        displayNum.setVerticalAlignment(JLabel.CENTER);
        this.add(displayNum);

        this.setLayout(new GridLayout(3,0));

        //Timer which is used to increment or decrement the counter
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Exception handling, if counter value becomes null or other mysterious error occurs.
                try {
                    //Condition where it is decided whether counter will increment or decrement
                    if (isEven) {
                        counter++;
                        if (counter > 9) {
                            counter = 0;
                        }
                    } else {
                        counter--;
                        if (counter < 0) {
                            counter = 9;
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    counter = 0;
                }
                displayNum.setText(Integer.toString(counter));
            }
        });
        timer.setInitialDelay(500);
        timer.start();
    }
}
