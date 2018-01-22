/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p104_shilimkar_panel;

import java.awt.Color;
import java.awt.Font;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Anuradha Shilimkar *
 */
//This class for writing tha full name is two rows
class FullNameLabel {

    JLabel firstname, lastname;

    //This method is reciving two parameters @firstname and last name
    FullNameLabel(String firstName, String lastName) {
        firstname = new JLabel(firstName);
        lastname = new JLabel(lastName);
        firstname.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        lastname.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        firstname.setFont(new Font("Papyrus", Font.PLAIN, 16));
        lastname.setFont(new Font("Papyrus", Font.PLAIN, 16));
    }
}
//This the inherietance this class is extending the Jpanel class

public class P104_Shilimkar_Panel extends JPanel {

    private FullNameLabel nameLabel;
    private JLabel counterLabel;
    int count = 9;
    boolean flag = false;

    /**
     * This is the constructor of receiving the parameter
     *
     * @param num
     *
     */
    public P104_Shilimkar_Panel(int num) {

        setBackColor(num);

        nameLabel = new FullNameLabel("Anu", "Shilimkar");

        counterLabel = new JLabel();

        setTimerTask();

        Box box = setBoxLabels();

        this.setBackground(getColor(num));

        this.add(box);

    }

    //This method is checking the variable is odd or even and setting the color of panel
    private void setBackColor(int value) {
        if (value % 2 == 0) {
            flag = true;
        }
        if (flag) {
            count = 0;
        }
    }

    //This is the methid to show the counter on panel from 0-9
    private void setTimerTask() {
        Timer timer = new Timer();
        try {
            TimerTask timerTask = new TimerTask() {
                public void run() {
                    setCounterLabelProperties(counterLabel);
                    if (flag) {
                        count = count + 1;
                        // counter is again reset when it will reach to 9
                        count = count > 9 ? 0 : count;
                    } else {
                        count = count - 1;
                        // Counter is resetting when it will reach to 0
                        count = count < 0 ? 9 : count;
                    }
                }
            };
            //Set the timer for 1 second
            timer.scheduleAtFixedRate(timerTask, 1000, 1000);
        } catch (Exception e) {
            System.out.println("Exception occured : " + e);
        }
    }

    //This method is getting the number for the color
    private Color getColor(int num) {
        return flag ? Color.WHITE : new Color(173, 216, 230);
    }

    //function to set counter label
    private void setCounterLabelProperties(JLabel counterLabel) {
        counterLabel.setText(Integer.toString(count));
        counterLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        counterLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
    }

    //This method is used to add the labels on in the panel
    private Box setBoxLabels() {
        Box box = Box.createVerticalBox();
        box.add(nameLabel.firstname);
        box.add(nameLabel.lastname);
        box.add(counterLabel);
        return box;
    }

    //main method to test working of panel
    public static void main(String[] args) {

        // TODO Auto-generated method stub
        JFrame frame = new JFrame();
        JPanel panel = new P104_Shilimkar_Panel(2);
        panel.setBounds(40, 80, 200, 200);
        frame.add(panel);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
