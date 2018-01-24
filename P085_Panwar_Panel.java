/*
Lab1
Author: Shipra Panwar
The class creates a Panel with First and Last Name's of a person.
A counter is incremented and decremented from 0-9 or 9-0.
The background color changes depending on the integer passed to the constructor. For an even number the background color is white, whereas for an odd number the background is blue
*/

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class P085_Panwar_Panel extends JPanel {

    /*
    --- CLASS PROPERTIES ---
     */

    JLabel nameLabel;   //label to display first name and last name
    JLabel timerLabel;  // label to display the counter value, which keeps changing in every 1 second
    int counter;        // counter to hold the value to be displayed in Jlabel timerLabel
    boolean checkEven;


    /*
    --- CLASS CONSTRUCTOR ---
     */

    public  P085_Panwar_Panel(int number){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));    //Set the Layout

        nameLabel = new JLabel("<html>Shipra <br/>Panwar</html>");      //Define label to contain first name and lastname
        nameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);        //sets the alignment of the label to the centre inside panel
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);    //sets the alignment of the text inside the label to the centre

        timerLabel = new JLabel();                                           //Define label for time counter
        timerLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));

        //add both labels to panel
        this.add(nameLabel);
        this.add(timerLabel);


        this.setVisible(true);
        this.setPreferredSize(new Dimension(100,100));

        if(number%2 ==0){           //sets the background color as white for even number received by constructor and update the counter to start from 0
            checkEven= true;
            counter = 0;
            this.setBackground(Color.WHITE);
        }
        else {                      //sets the background color as blue for odd number received by constructor and update the counter to start from 9
            checkEven = false;
            counter = 9;
            this.setBackground(Color.BLUE);
        }
        Timers();                   //method to increment or decrement counter value and display it on panel under label timerLabel
    }



    /*
    --- CLASS METHOD --
    Update the value of counter to be displayed on Panel.
     */

    public void Timers(){
        new Thread() {
            public void run() {
                while (true) {
                    if (counter == 10)
                        counter = 0;                //sets counter to 0 after 9
                    if(counter == -1)
                        counter = 9;                //sets counter to 9 after 0
                    timerLabel.setText(" " + counter);
                    if(checkEven){
                        counter++;                  //for even number passed through constructor, this increments counter from 0-9
                    }
                    else {
                        counter--;                  // for odd number passed through constructor, this decrement counter from 9-0
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
    } //end of timers class method


    /*
    //main class
    public static void main(String[] args){
        JFrame frame = new JFrame("");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new P085_Panwar_Panel(41));
        frame.pack();
    }
    */

}//end of class

