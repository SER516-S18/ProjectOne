

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;


/*
Author : Minal Laad
Program to display Name on a JPanel. Panel Background color changes according to the color flag passed by the user.
If the color flag is even the timer increments from 0-9 and if it is odd the timer decrements from 9-0
 */
public class P062_Laad_Panel extends JPanel{

    private JPanel panel;
    private JLabel firstname,lastname,watch;
    private Timer timer = new Timer();
    private int secondsPassed = 0;
    private int ColorFlag ;

   public P062_Laad_Panel(int ColorFlag ){                // Setting ColorFlag
       this.ColorFlag=ColorFlag;
       getPanelInstance();
   }

   public void getPanelInstance(){
       panel = new JPanel();
       try{
           Color lightblue = new Color(173,216,230);
           Font font = new Font("Papyrus", Font.PLAIN, 15);


           setSize(100,100);             //Setting Panel Size
           firstname = new JLabel("Minal");           //Creating Label for First Name
           firstname.setAlignmentX(Component.CENTER_ALIGNMENT);
           lastname = new JLabel("Laad");            //Creating Label for Last Name
           lastname.setAlignmentX(Component.CENTER_ALIGNMENT);
           watch = new JLabel();             //Creating Label for watch
           watch.setFont(font);
           firstname.setFont(font);
           lastname.setFont(font);
           add(firstname);      //Adding First Name to the Panel
           add(lastname);       // Adding Last Name to the Panel
           if(ColorFlag%2 == 0)             // Checking if the number is ODD or EVEN
           { secondsPassed=0;
               setBackground(Color.white);     // Setting Panel Background to White
               timer.schedule(new TimerTask() {      // Scheduling the Timer Task with delay of 1 second = 1000 milliseconds

                   @Override
                   public void run() {
                       if(secondsPassed > 9)  //Re-setting the Value of secondsPassed to 0 if value is greater than 9
                       {
                           secondsPassed = 0;
                       }
                       else
                       {
                           watch.setText(Integer.toString(secondsPassed++));  // Incrementing the timer from 0 to 9
                           add(watch);         // Adding the watch to the Panel
                       }

                   }
               }, 1000, 1000);



           }
           else
           {   secondsPassed=9;
               setBackground(lightblue);  // Setting Panel Background to Light Blue
               timer.schedule(new TimerTask() {    // Scheduling the Timer Task with delay of 1 second = 1000 milliseconds

                   @Override
                   public void run() {
                       if(secondsPassed < 0 )  //Re-setting the Value of secondsPassed to 9 if value is less than 0
                       {
                           secondsPassed = 9;
                       }
                       else
                       {
                           watch.setText(Integer.toString(secondsPassed--));   // Incrementing the timer from 0 to 9
                           add(watch);    // Adding the watch to the Panel
                       }

                   }
               }, 1000, 1000);


           }

           setLayout((LayoutManager) new BoxLayout(this, BoxLayout.Y_AXIS));

       }catch(Exception ex){
           System.out.println("Exception Occurred:"+ex.getMessage());
       }

   }

}
