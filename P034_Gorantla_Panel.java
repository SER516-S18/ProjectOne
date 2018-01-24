import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
Author: Ramesh Gorantla
Date: 1/21/2018
Description: This code is part of SER 516 lab 1. In this code I implemented a panel which will be integrated into a tab. The panel has a name and a counter.
The panel has 2 properties and they vary based on the number passed into the parameterised constructor. If the number passed is even then the panel will have a white background
and the counter starts from 0 to 9 and continues in a loop (incresing counter). If the number passed is odd then the panel will have a light blue background
and the counter starts from 9 to 0 and continues in a loop (decreasing counter).

Input: Expects a integer
Output: Returns JPanel object

*/

public class P034_Gorantla_Panel extends JPanel{
    // variables initialisation
    private JLabel counterHolder;
    private JLabel nameHolder;
    private static int COUNTER = 0;
    Color LIGHTBLUE = new Color(173,216,230); 
    private static String FONTSTYLE = "Papyrus";
    private static int FONTSIZE = 15;
    private static String NAMETOBEDISPLAYED = "<html>Ramesh<br>Gorantla";

    // one parameter constructor, accepts integer value
    public P034_Gorantla_Panel(int number) {
        try{
            if(number == (int)number) // check for making sure integer is passed as argument
            {
                initUI(); //initialises the panel
                setValues(number); //sets values inside the panel
            }else{
                System.out.println("Integer is expected");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    // initialises the panel UI
    public void initUI(){
        // setting the layout for the panel
        this.setLayout(new GridLayout(2,1));
    }
    
    // sets the content for the panel
    public JPanel setValues(int number){
        Boolean isEven = false;
        try{
            if(number % 2 ==0) isEven = true; // check for even or odd number
        }catch(ArithmeticException e){
            System.out.println(e);
        }
        Font fontStyle = new Font(FONTSTYLE,Font.PLAIN,FONTSIZE);       
        // making the lables center aligned
        counterHolder = new JLabel("", JLabel.CENTER); 
        nameHolder = new JLabel("", JLabel.CENTER);         
        // setting font style for the labels
        counterHolder.setFont(fontStyle);
        nameHolder.setFont(fontStyle);
        nameHolder.setText(NAMETOBEDISPLAYED);        
        // setting background color for the panel
        if(isEven){
            this.setBackground(Color.white);
        }else{
            this.setBackground(LIGHTBLUE); 
        }
        initCounter(isEven);        
        // adding individual components to the main layout
        this.add(nameHolder);
        this.add(counterHolder);
        return this;
    }
    // starting the timer
    public void initCounter(Boolean isEven){
        if(isEven){
            COUNTER = -1;
        }else{
            COUNTER = 10;
        }
        // timer logic: based on the whether its a even or odd number the timer increases or decreases for every second
        Timer timer = new Timer(); 
        try{
            timer.scheduleAtFixedRate(new TimerTask(){
                public void run() { 
                    if(isEven){
                        if(COUNTER == 9){
                            COUNTER = -1;
                        }
                        COUNTER++;
                    }else{
                        if(COUNTER == 0){
                            COUNTER = 10;
                        }
                        COUNTER--;
                    }
                    // updates the counter label value ever second
                    counterHolder.setText(Integer.toString(COUNTER));
                } 
            }, new Date(), 1000); 
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
