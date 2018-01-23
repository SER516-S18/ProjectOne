import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author Chiranjeevi Ramamurthy <cramamu1@asu.edu>
 * Version 1.0
 *
 * SER516 Lab1 Panel submission from Chiranjeevi Ramamurthy for Group 4, ID 93
 * ASURITE cramamu1
 * ASU ID 1213037941
 *
 * This file contains java code module for displaying a JPanel alongside with JLabel
 * as per given functional requirements
 *
 * Final update made on January 23, 2018
 */
public class P093_Ramamurthy_Panel extends JPanel {

    private JLabel name;
    private JLabel counter;
    private int count;
    private TimerTask timerTask;
    private boolean isEven;

    /**
     * This parameterized constructor acts as a controller which calls appropriate functions to initialize timer,
     * labels and background color depending on input value
     * @param inputValue
     */
    public P093_Ramamurthy_Panel(int inputValue) {
        isEven = (inputValue%2==0); //To determine the given input as even or odd
        setPreferredSize(new Dimension(100, 100));
        setBackground(isEven ? Color.WHITE : Color.CYAN);//Deciding panel's bg color based on given input parameter
        initializeLabel();
        computeCounter(isEven);
        setVisible(true);
    }

    /**
     * This method is used to display name and counter (as per requirement) using JLabel class
     */
    public void initializeLabel() {
        setLayout(new GridLayout(2, 1, 0, 0));
        name = new JLabel("<html>Chiranjeevi<br/>Ramamurthy </html>",
                SwingConstants.CENTER);//Initializing name variable
        name.setVerticalAlignment(SwingConstants.BOTTOM);
        counter = new JLabel("",SwingConstants.CENTER);
        counter.setVerticalAlignment(SwingConstants.TOP);
        name.setFont(new Font("Arial",Font.BOLD,16));
        counter.setFont(new Font("Arial",Font.BOLD,16));
        add(name);
        add(counter);
    }

    /**
     * This method computes the timer based on the parameter value
     * @param isEven
     */
    private void computeCounter(boolean isEven) {
        //initialising counter here
        if(isEven)
            count =0;
        else
            count=9;

        try {
            timerTask = new TimerTask() {
                public void run() {     //Overriding run method
                    if (isEven)
                        count = (++count) % 10;
                    else
                        count = (9 + count) % 10;
                    counter.setText(String.valueOf(count));
                }
            };

            Timer timer = new Timer();
            long interval = 1000L;
            long delay = 0L;
            timer.scheduleAtFixedRate(timerTask, delay, interval);
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is for testing purposes only
     * @param args
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.add(new P093_Ramamurthy_Panel(2));
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
