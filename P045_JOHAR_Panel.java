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

    //Singelton Panel object which is returned
    private static P045_JOHAR_Panel panel;

    /**
     * Class constructor.
     * @param	num	Describes the background and counter mode of the panel.
     */
    protected P045_JOHAR_Panel(int num) {

        counter = 9;
        isEven = false;

        if (num % 2 == 0) {
            isEven = true;
            counter = 0;
        }

        createPanelObject();
    }

    // Singleton setup
    // num - Even for increasing counter, odd for decreasing.
    public static P045_JOHAR_Panel getInstance( int num ) {

        //if panel object is null, then create a new object else return the already created object
        if( panel == null) {
            panel = new P045_JOHAR_Panel( num );
        }
        return panel;
    }

    public void createPanelObject()
    {
        Timer timer;
        JLabel firstName;
        JLabel lastName;
        JLabel displayNum;

        setLayout(null);
        // Setting the size of the panel
        setSize(100, 100);

        //Setting the background color of the panel depending on the input passed to constructor
        if (isEven) {
            setBackground(Color.WHITE);
        } else {
            Color lightBlue = new Color(173, 216, 230);
            setBackground(lightBlue);
        }

        //First name of the author which goes in the first row
        firstName=new JLabel("Saheb", JLabel.CENTER);
        firstName.setBounds(10, 0, 50, 25);
        firstName.setFont(new Font("Papyrus", Font.PLAIN, 15));
        firstName.setHorizontalAlignment(JLabel.CENTER);
        firstName.setVerticalAlignment(JLabel.CENTER);
        firstName.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(firstName);

        //Last name of the author which goes in the second row
        lastName=new JLabel("Johar", JLabel.CENTER);
        lastName.setBounds(10, 15, 50, 25);
        lastName.setFont(new Font("Papyrus", Font.PLAIN, 15));
        lastName.setHorizontalAlignment(JLabel.CENTER);
        lastName.setVerticalAlignment(JLabel.CENTER);
        lastName.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lastName);

        //Counter value which goes in the last row
        displayNum=new JLabel(String.valueOf(counter), JLabel.CENTER);
        displayNum.setBounds(10, 30, 50, 25);
        displayNum.setFont(new Font("Papyrus", Font.PLAIN, 15));
        displayNum.setHorizontalAlignment(JLabel.CENTER);
        displayNum.setVerticalAlignment(JLabel.CENTER);
        displayNum.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(displayNum);

        setLayout(new BorderLayout(0, 0));
        setBorder(new EmptyBorder(30, 30, 30, 30));

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



   /* public static void main(String args[])
    {

        JFrame frame = new JFrame();
        frame.setSize(100, 100);
        frame.add(P045_JOHAR_Panel.getInstance(0));
        frame.setVisible(true);

    }*/

}
