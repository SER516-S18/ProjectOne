
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class P062_Laad_Panel {

    private JPanel panel;
    private JLabel firstname,lastname,watch;
    private Timer timer = new Timer();
    private int secondsPassed = 0;
    private int num ;

   public P062_Laad_Panel(int value ){
       this.num=value;
   }

   public JPanel getPanelInstance(){
       panel = new JPanel();
       try{
           Font font = new Font("Papyrus", Font.PLAIN, 12);


           panel.setSize(100,100);             //Setting Panel Size
           firstname = new JLabel("Minal");           //Creating Label for First Name
           firstname.setAlignmentX(Component.CENTER_ALIGNMENT);
           lastname = new JLabel("Laad");            //Creating Label for Last Name
           lastname.setAlignmentX(Component.CENTER_ALIGNMENT);
           watch = new JLabel();             //Creating Label for watch
           watch.setFont(font);
           firstname.setFont(font);
           lastname.setFont(font);
           panel.add(firstname);      //Adding First Name to the Panel
           panel.add(lastname);       // Adding Last Name to the Panel
           if(num%2 == 0)             // Checking if the number is ODD or EVEN
           { secondsPassed=0;
               panel.setBackground(Color.white);     // Setting Panel Background to White
               timer.schedule(new TimerTask() {      // Scheduling the Timer Task

                   @Override
                   public void run() {
                       if(secondsPassed > 9)  //Re-setting the Value of secondsPassed to 0 if value is greater than 9
                       {
                           secondsPassed = 0;
                       }
                       else
                       {
                           watch.setText(Integer.toString(secondsPassed++));  // Incrementing the timer from 0 to 9
                           panel.add(watch);         // Adding the watch to the Panel
                       }

                   }
               }, 1000, 1000);



           }
           else
           {   secondsPassed=9;
               panel.setBackground(Color.cyan);  // Setting Panel Background to Light Blue
               timer.schedule(new TimerTask() {    // Scheduling the Timer Task

                   @Override
                   public void run() {
                       if(secondsPassed < 0 )  //Re-setting the Value of secondsPassed to 9 if value is less than 0
                       {
                           secondsPassed = 9;
                       }
                       else
                       {
                           watch.setText(Integer.toString(secondsPassed--));   // Incrementing the timer from 0 to 9
                           panel.add(watch);    // Adding the watch to the Panel
                       }

                   }
               }, 1000, 1000);


           }

           panel.setLayout((LayoutManager) new BoxLayout(panel, BoxLayout.Y_AXIS));

       }catch(Exception ex){
           System.out.println("Exception Occurred:"+ex.getMessage());
       }

       return panel;
   }

}
