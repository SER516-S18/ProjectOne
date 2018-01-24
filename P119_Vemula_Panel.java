/**
 * @author Raghavendra Prasad Vemula
 * @date 01/22/2018
 * @description A Panel class for SER516 lab project.
 *
 * Counter increments from 0-9 if value is even or decrements from 9-0 if odd.
 * Panel background is set to WHITE if value is even or LIGHT BLUE (173,216,230) if odd.
 */
import java.awt.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.lang.Exception;
import javax.swing.border.EmptyBorder;

public class P119_Vemula_Panel extends JPanel {
    private int count , val;


    //Constructor taking integer input.
    public P119_Vemula_Panel(int val) {
        this.val = val;
    	setPanelSize();//Sets the size of the Panel
    	backGroundColor();//Sets the Background Color of the Panel
    	createPanel(val);//Prints the output of the Required Panel
    }

     private void setPanelSize() {
        //Setting the Size of the Panel Size 
        this.setPreferredSize(new Dimension(100,100));
        
    }

    private void backGroundColor() {
        //Color is White if the val is even or Light Blue if odd
        if(this.val % 2 == 0)
            this.setBackground(Color.White);
        else {
            Color light_blue = new Color(173,216,230);
            this.setBackground(light_blue);
        }
            
    }

    private void createPanel(int val) throws InterruptedException {
        //Name is Printed in Multi-Lined Label with first name in one line and last name in another
        JLabel firstName,lastName;

        firstName = new JLabel("Raghavendra Prasad", JLabel.CENTER);       //Creating Label for First Name
        firstName.setBounds(10, 0, 45, 25);
        firstName.setFont(new Font("Papyrus", Font.PLAIN, 10));
        firstName.setHorizontalAlignment(JLabel.CENTER);
        firstName.setVerticalAlignment(JLabel.CENTER);
        add(firstName);

        lastName = new JLabel("Vemula", JLabel.CENTER);            //Creating Label for Last Name
        lastName.setBounds(10, 10, 45, 25);
        lastName.setFont(new Font("Papyrus", Font.PLAIN, 10));
        lastName.setHorizontalAlignment(JLabel.CENTER);
        lastName.setVerticalAlignment(JLabel.CENTER);
        add(lastName);

        JLabel showTimer = new JLabel("0", JLabel.CENTER);
        showTimer.setBounds(10, 20, 25, 25);
        Timer t = new Timer();                                      //Creating Label for timer
        showTimer.setFont(new Font("Papyrus", Font.PLAIN, 10));
        showTimer.setHorizontalAlignment(JLabel.CENTER);
        showTimer.setVerticalAlignment(JLabel.CENTER);
        add(showTimer);

	this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS)); 
        setBorder(new EmptyBorder(20, 20, 20, 20));
       
        Thread t;
        t = new Thread(() -> {
            //Starting value is 0 if even or 9 if odd.
            try{
            if(val % 2 == 0){
                //Timer increasing from 0 to 9
            	if (count == 10)                     //if timer is 10 setting it to 0
                        count = 0;
                showTimer.setText(""+ count++);      //incrementing the timer             
           }
           else {
           	if (count == -1)                       //if timer is -1 setting it to 9
                        count = 9;
           	showTimer.setText(""+ count--);      //decrementing the timer
           }}
           catch(InterruptedException e){
                        System.out.print("Exception Occurred in " + P119_Vemula_Panel.class.getName());
           }
            
        });
       t.start();
       }
    
}

    /*public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new P119_Vemula_Panel(3));
        frame.pack();
        frame.setVisible(true);
    }*/

    