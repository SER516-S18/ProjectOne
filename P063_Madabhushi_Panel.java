
/**
 * The below class creates a panel and uses JLabel to create 
 * three labels.
 * The first Label displays the author's first name and the second label 
 * displays the author's last name.
 * The third label displays a timer that either counts up or down based on
 * the parameter passed into the constructor of the class.
 * The background color of the panel also changes based on the value of the
 * parameter.
 * @author (Sowmya Madabhushi)
 * @version (1/21/2018)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//Using JPanel to make the class P063_Madabhushi_Panel into a panel
public class P063_Madabhushi_Panel extends JPanel
{
    Timer timer;//creating a timer object
    int counter =0;//initialising the counter to 0
    JLabel l1,l2,l3;//Using JLabel to create three labels
    public P063_Madabhushi_Panel()
    {    //constructor
    }
    public P063_Madabhushi_Panel(int n)
    {
       //constructor that recieves a paramter
       super(new GridLayout(3,1));
       this.setSize(100,100);
       //using GridLayout to divide the panel into three sections
       l1 = new JLabel("Sowmya",JLabel.CENTER);
       l1.setVerticalTextPosition(JLabel.BOTTOM);
       l1.setHorizontalTextPosition(JLabel.CENTER);
       //displaying first name and positioning the label
       l2 = new JLabel("Madabhushi",JLabel.CENTER);
       //displaying the last name
       l3 = new JLabel("Timer",JLabel.CENTER);
       //Label 3 for implementing the timer
       add(l1);
       add(l2);
       add(l3);
       // adding the three labels onto the panel
    if(n%2==0)
    {//setting the background of panel to white
            setBackground(Color.WHITE);
            timer = new Timer(1000, new ActionListener() {
            //implementing timer using an ActionListener    
            @Override
            public void actionPerformed(ActionEvent e) {
                l3.setText(String.valueOf(counter));
                counter++;//the counter counts from 0 to 9
                if(counter==11){//reset the counter and start again
                   counter = 0;
                   l3.setText(String.valueOf(counter));
                   counter++;
                }
            }
            });
            timer.start();
    } 
    else
    {//Changes the background to light blue color and uses an actionListener 
            //to run the timer. The timer counts down from 9 to 0 in this.
            counter=9;
            Color lightBlue= new Color(173,216,230);
            setBackground(lightBlue);
            timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l3.setText(String.valueOf(counter));
                counter--;
                if(counter==-2){
                    counter=9;
                   l3.setText(String.valueOf(counter));
                   counter--;
                }
                }
            });
            timer.start();
            }
        }
        /* for testing */
    public static void frame()
        {//creating JFrame 
        JFrame f = new JFrame("demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new P063_Madabhushi_Panel(3));//change 3 to even number to 
        //check white bacground and counter from 0 to 9
        f.pack();
        f.setSize(500,500);
        f.setVisible(true);
        }
   
    public static void main(String[] args)
    {
        frame();
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run(){
            new P063_Madabhushi_Panel(3);//change 3 to even number for other 
            //condition
            }
        });
    }
        
    }
        
