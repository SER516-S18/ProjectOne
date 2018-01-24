import java.awt.*;
import javax.swing.*;

/**
 *  The file creates a Panel with First and Last Name's of the author and a counter.
 *  The counter increments/decrements from 0-9/9-0 respectively.
 *  The background color of the panel changes depending on the integer passed to the class constructor. For an even number the background color is white, whereas for an odd number the background is blue
 *
 *  @author Shipra Panwar
 *  @version 1.0
 *  @createdon January, 2018
*/

public class P085_Panwar_Panel extends JPanel {

    public final static Color LIGHT_BLUE = new Color(173, 216, 230); // set background color of panel
    public final static Color WHITE = Color.WHITE;
    public final static int RangeMin = 0;
    public final static int RangeMax = 9;

    public static int counter = 0;        // counter to hold the value to be displayed in Jlabel counterLabel
    private JLabel nameLabel;   // label to display first name and last name
    private JLabel counterLabel;  // label to display the counter value, which keeps changing in every 1 second
    private boolean checkEven;  // parameter to check if the input value is even or odd


    /**
     *  The parameterized constructor defines label to be displayed on the panel, which includes name of the author and a counter.
     *  Based on the argument- number, the background color changes to white for even number or light blue for odd number.
     *
     *  @param number   numeric     a value passed to alter the background of panel accordingly
     */

    public  P085_Panwar_Panel(int number){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));    //Set the Layout

        nameLabel = new JLabel("<html>Shipra <br/>Panwar</html>", SwingConstants.CENTER);      //Define label to contain first name and last name
        nameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);        //sets the alignment of the label to the centre inside panel

        counterLabel = new JLabel( String.valueOf(counter), SwingConstants.CENTER);                                           //Define label for time counter
        counterLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));

        //add both labels to panel
        this.add(nameLabel);
        this.add(counterLabel);


        this.setVisible(true);
        this.setPreferredSize(new Dimension(100,100));

        if(number%2 ==0){           //sets the background color as white for even number received by constructor and update the counter to start from RangeMin
            checkEven= true;
            counter = RangeMin;
            this.setBackground(WHITE);
        }
        else {                      //sets the background color as blue for odd number received by constructor and update the counter to start from RangeMax
            checkEven = false;
            counter = RangeMax;
            this.setBackground(LIGHT_BLUE);
        }
        Timers();                   //method to increment or decrement counter value and display it on panel under label counterLabel
    }



    /**
    *   This method updates the value of counter to be displayed on Panel, in every 1 second.
    */

    public void Timers(){
        new Thread() {
            public void run() {
                while (true) {
                    if (counter == RangeMax+1)
                        counter = RangeMin;                //sets counter back to RangeMin after it reaches RangeMax
                    if(counter == RangeMin-1)
                        counter = RangeMax;                //sets counter back to RangeMax after it reaches RangeMin
                    counterLabel.setText(" " + counter);
                    if(checkEven){
                        counter++;                  // for even number passed through constructor, this increments counter from RangeMin-RangeMax
                    }
                    else {
                        counter--;                  // for odd number passed through constructor, this decrement counter from RangeMax-RangeMin
                    }
                    try {
                        Thread.sleep(1000);    // the next increment or decrement occurs after 1000 milliseconds
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

}

