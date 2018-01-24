/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * P104_Shilimkar_Panel this program implements an application that will display
 * panel. On the panel it will show the first and last name in two rows. It also
 * shows the timer counter. It is counting for each second. When the background
 * color is white the timer is counting from 0 to 9 and again reset at 0 so it
 * will increase. When the panel background color is light-blue then counter is
 * counting from 9 to 0 and again reset at 9 and it will decrease.
 *
 * @author anu Shilimkar
 * @version 1.0
 * @since 2018-01-23
 */
public class P104_Shilimkar_Panel extends JPanel {

    JLabel firstName, lastName, timerLabel;
    Timer timer;
    int counter = 0,red = 51, green = 204, blue = 255;
    /**
     * Constructor for class P104_Shilimkar_Panel
     * @param backgroundSelection . This parameter is used to set the background
     * color
     */
    public P104_Shilimkar_Panel(int backgroundSelection) {
        setPreferredSize(new Dimension(100, 100));
        setLayout(new GridLayout(3, 1));
        setBorder(BorderFactory.createLineBorder(Color.blue));
        
        timerLabel = new JLabel("Timer");
        timerLabel.setFont(new Font("Papyrus", Font.PLAIN, 14));
        setBackgroundCount(backgroundSelection);
        add(timerLabel, JLabel.CENTER);

        lastName = new JLabel("Shilimkar");
        lastName.setFont(new Font("Papyrus", Font.PLAIN, 14));
        add(lastName, JLabel.CENTER);

        firstName = new JLabel("Anu");
        firstName.setFont(new Font("Papyrus", Font.PLAIN, 14));
        add(firstName, JLabel.CENTER);
    }
    /*This function is setting the background color according to
    backgroundselection variable value*/
    private void setBackgroundCount(int backgroundSelection) {
        if (backgroundSelection % 2 == 0) {
            setBackground(Color.white);
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timerLabel.setText(String.valueOf(counter));
                    //incrementing the counter form 0 to 9 for White color
                    counter++;
                    //Reset the counter when it reaches 9 and start again with 0
                    if (counter == 11) {
                        counter = 0;
                        timerLabel.setText(String.valueOf(counter));
                        counter++;
                    }
                }
            });

            timer.start();
        } else {
            counter = 9;
            setBackground(new Color(red, green, blue));
            timer = new Timer(1000, new ActionListener() {
                //method for timer using an ActionListener    
                @Override
                public void actionPerformed(ActionEvent e) {
                    timerLabel.setText(String.valueOf(counter));
                    //decrement in the counter from 0 to 9
                    counter--;
                    if (counter == -2) {
                        //resetting the counter and start again with 9
                        counter = 9;
                        timerLabel.setText(String.valueOf(counter));
                        counter--;
                    }
                }
            });
            timer.start();
        }
    }

}
