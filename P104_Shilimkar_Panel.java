/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author anu
 */
//Need to extend this class
public class P104_Shilimkar_Panel extends JPanel {

    JLabel label1, label2, label3;
    Timer timer;
    int counter = 0; //initialize with 0

    //Write a constructor for class
    public P104_Shilimkar_Panel(int num) {
        //constructor that recieves a paramter
        //setting a Panel dimensions
        setPreferredSize(new Dimension(100, 100));

        setLayout(new GridLayout(3, 1));
        //    GridBagConstraints c = new GridBagConstraints();

        setBorder(BorderFactory.createLineBorder(Color.blue));
        //JLabel label = new JLabel("<html>Anu<br>Shilimkar<br></html>");

        label3 = new JLabel("Timer");
        label3.setFont(new Font("Papyrus", Font.PLAIN, 14));
        SetTimer(num);
        add(label3, JLabel.CENTER);

        label2 = new JLabel("Shilimkar");
        label2.setFont(new Font("Papyrus", Font.PLAIN, 14));
        add(label2, JLabel.CENTER);

        label1 = new JLabel("Anu");
        label1.setFont(new Font("Papyrus", Font.PLAIN, 14));
        add(label1, JLabel.CENTER);
    }

    private void SetTimer(int num) {
        //set the background colors according to parameter for the JPanel
        if (num % 2 == 0) {
            //When num is even then color will be White
            setBackground(Color.white);

            //In Timer performing the action listerner
            timer = new Timer(1000, new ActionListener() {

                //timer now acting on the Event   
                @Override

                public void actionPerformed(ActionEvent e) {
                    label3.setText(String.valueOf(counter));
                    //incrementing the counter form 0 to 9 for White color

                    counter++;
                    //Reset the counter when it reaches 9 and start again with 0
                    if (counter == 11) {

                        counter = 0;
                        label3.setText(String.valueOf(counter));
                        counter++;

                    }

                }

            });

            timer.start();
        } else {
            counter = 9;
            setBackground(new Color(51, 204, 255));
            //Performing action of listening the event
            timer = new Timer(1000, new ActionListener() {

                //method for timer using an ActionListener    
                @Override

                public void actionPerformed(ActionEvent e) {
                    label3.setText(String.valueOf(counter));
                    //decrement in the counter from 0 to 9

                    counter--;

                    if (counter == -2) {
                        //resetting the counter and start again with 9

                        counter = 9;
                        label3.setText(String.valueOf(counter));

                        counter--;

                    }

                }

            });

            timer.start();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        //create a Jframe container for application.
        JFrame frame = new JFrame("Demo");
        //   frame.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        frame.add(new P104_Shilimkar_Panel(1));
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.pack();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}