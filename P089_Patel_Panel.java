import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

/**
 * P089_Patel_Panel.java - a class to implement Panel.
 * @author  Meet Patel
 * @version 1.0
 */

public class P089_Patel_Panel
{
    int counter; // to increase or decrease the timer
    Timer timer;
    JPanel newPanel = new JPanel(new GridBagLayout());// Object of JPanel class and declared the layout of Panel
    JLabel nameLabel = new JLabel("<html>Meet<br>Patel</html>");//First Label with first and last name
    JLabel timerLabel = new JLabel();//Second Label for the counter

    /**
     *
     * @param num - To change the Backgroud of the panel, if ODD, changes to lightblue else to White
     */
    public P089_Patel_Panel(int num) { // Parameterized constructor to add the Labels in the Panel

        GridBagConstraints constraints = new GridBagConstraints(); //object of Layout Class
        GridBagConstraints constraints1 = new GridBagConstraints();// 2nd object for 2nd label of layout class
        newPanel.setPreferredSize(new Dimension(100, 100));// Fix the dimensions of Panel
        constraints.gridx = 0; // Positioning of Label 1 - x-coordinate
        constraints.gridy = 0; // Positioning of Label 1 - y-coordinate
        constraints1.gridx = 0; //Positioning of Label 1 - x-coordinate
        constraints1.gridy = 2; //Positioning of Label 1 - y-coordinate
        nameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15)); // Set font properties of Label1
        timerLabel.setFont(new Font("Papyrus", Font.PLAIN, 15)); // Set font properties of Label2
        newPanel.add(nameLabel, constraints);// Adds Label1 to panel
        newPanel.add(timerLabel, constraints1);//Adds Label2 to panel
        if(num % 2 != 0){ // checks for odd number
            Color lightblue = new Color(173,216,230); // changes the background color of Panel
            newPanel.setBackground(lightblue);
            counter = 9;
            Thread t = new Thread(){ //creates the new thread
                public void run(){
                    timer = new Timer(1000, new ActionListener() { //creates the timer
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            timerLabel.setText(Integer.toString(counter));//prints the timer in the label
                            counter--;
                            if (counter == -1) {
                                counter = 9;
                            }
                            try{
                            }
                            catch(Exception a){ // Exception Handling
                                System.out.println(a);
                            }
                        }
                    });
                    timer.setInitialDelay(0); // Sets initial delay of the timer
                    timer.start(); // Initiates the timer
                }
            };
            t.start(); // Starts the Thread

        }
        else{
            newPanel.setBackground(Color.WHITE); // sets background color
            counter = 0;
            Thread t = new Thread(){ // creates a new Thread
                public void run(){
                    timer = new Timer(1000, new ActionListener() { // Creates the new Timer
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            timerLabel.setText(Integer.toString(counter)); //prints the timer on the Label
                            counter++;
                            if(counter == 10){
                                counter = 0;
                            }
                            try{
                            }
                            catch(Exception a){ // Exception Handling
                                System.out.println(a);
                            }
                        }
                    });
                    timer.setInitialDelay(0);
                    timer.start();//Starts the Timer
                }
            };
            t.start();// Starts the Thread

        }
        //add(newPanel); //adds the panel to the frame
        //pack(); //to pack all components
        //setLocationRelativeTo(null);
        //setVisible(true);

    }

    /**
     *
     * @return - Returns the object of the Panel
     */
    public JPanel Ret_Panel_Object(){ // Funtion to return the JPanel Object
        return newPanel;
    }

}
