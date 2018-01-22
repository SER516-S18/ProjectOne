/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Author: Ramesh Gorantla
Date: 1/21/2018
Description: This code is part of SER 516 lab 1. In this code I implemented a panel which will be integrated into a tab. The panel has a name and a counter.
The panel has 2 properties and they vary based on the number passed into the parameterised constructor. If the number passed is even then the panel will have a white background
and the counter starts from 0 to 9 and continues in a loop (incresing counter). If the number passed is odd then the panel will have a light blue background
and the counter starts from 9 to 0 and continues in a loop (decreasing counter).

Input: Expects a integer
Return value: The class returns JPanel object

*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date; 
import java.util.Timer; 
import java.util.TimerTask; 
import javax.swing.border.Border;

public class P034_Gorantla_Panel extends JPanel{
    // variables initialisation
    private JLabel counterHolder;
    private JLabel nameHolder;
    private JPanel contentPanel;
    private JFrame mainFrame;
    public static int counter = 0;

    // one parameter constructor, accepts integer value
    public P034_Gorantla_Panel(int number) {
        try{
            if(number == (int)number)
            {
               initUI(); //initialises the panel
               setValues(number); //sets values inside the panel
            }else{
                System.out.println("Integer is expected");
            }
        }catch(NumberFormatException e){
            System.out.println("Integer is expected"+e);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void initUI(){
        // mainframe is the outer layout for the app
        mainFrame = new JFrame();
        mainFrame.setSize(200, 200);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              System.exit(0);
           }        
        }); 

        // adding a panel inside the mainframe
        contentPanel = new JPanel();
        contentPanel.setSize(100, 100);
        contentPanel.setLayout(new FlowLayout());
        
        // setting border for the panel
        Border panelBorder = BorderFactory.createLineBorder(Color.GRAY, 1);
        contentPanel.setBorder(panelBorder);

        mainFrame.setVisible(true); 
    }
    public JPanel setValues(int number){
        Boolean isEven = false;
        try{
            if(number % 2 ==0) isEven = true; // check for even or odd number
        }catch(ArithmeticException e){
            System.out.println(e);
        }
        System.out.println(isEven);
        Font fontStyle = new Font("Papyrus",Font.PLAIN,15); // setting font style
        
        // making the lables center aligned
        counterHolder = new JLabel("", JLabel.CENTER); 
        nameHolder = new JLabel("", JLabel.CENTER); 
        
        // setting font style for the labels
        counterHolder.setFont(fontStyle);
        nameHolder.setFont(fontStyle);
        
        // value for name label
        nameHolder.setText("<html>Ramesh<br>Gorantla");
        
        // setting background color for the panel
        if(isEven){
            contentPanel.setBackground(Color.white);
        }else{
            contentPanel.setBackground(new Color(173,216,230));
        }
        
        // starting the counter
        initCounter(isEven);
        
        // adding individual components to the main layout
        contentPanel.add(nameHolder);
        contentPanel.add(counterHolder);
        mainFrame.add(contentPanel);
        return contentPanel;

    }
    public void initCounter(Boolean isEven){
        if(isEven){
            counter = -1;
        }else{
            counter = 10;
        }
        // timer logic: based on the whether its a even or odd number the timer increases or decreases for every second
        Timer timer = new Timer(); 
        try{
            timer.scheduleAtFixedRate(new TimerTask(){
                public void run() { 
                    if(isEven){
                        if(counter == 9){
                            counter = -1;
                        }
                        counter++;
                    }else{
                        if(counter == 0){
                            counter = 10;
                        }
                        counter--;
                    }
                    // updates the counter label value ever second
                    counterHolder.setText(Integer.toString(counter));
                } 
            }, new Date(), 1000); 
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    // main function --- uncomment to test the file
    /*public static void main(String args[]){
        int number = 34; // this is the number which decide the properties of the panel
        P034_Gorantla_Panel p034_Gorantla_Panel = new P034_Gorantla_Panel(number);      
    }*/
}
