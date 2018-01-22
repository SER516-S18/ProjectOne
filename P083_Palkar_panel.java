package pkg516;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class P083_Palkar_panel extends JPanel{


    public static int counter = 0;
    private boolean EvenFlag;
    private Color col;

    public P083_Palkar_panel(int ID) {
        if(ID%2==0)
        {
            
            counter=-1;// Initialise counter value to -1
            col=Color.white;//Set panel color to white
            EvenFlag=true;//Set evenFlag to true if ID is even

        }
        else
        {
            
            counter=10;// Initialise counter value to 10
            col=Color.blue;//Set panel color to white
           EvenFlag=false;//Set evenFlag to false if ID is even

        }
        setbgcol(col);//Function Call to set the background colour of the panel passing the set colour as parameter

    }

    public void setbgcol(Color c) 
    {
        setSize(100,100);//Set the size of the panel
        setBackground(c);//Set the background colour of the panel
        JLabel Name = new JLabel("<html>Tejasi<br>Palkar</html>");//Create and initialise Name label with the name of the person.Represents the GUI component to be added on the panel
        Name.setFont(new Font("Papyrus", Font.PLAIN, 10));
        add(Name);//Add label onto panel

        JLabel  Counter = new JLabel(String.valueOf(counter));//Create and Initialise Counter label with the counter value.Represents the gUI component to be added on the panel
        Counter.setFont(new Font("Papyrus", Font.PLAIN, 10));
        add(Counter);//Add counter label onto the panel

        
        //Timer value change is kept between try and catch to handle exception at the runtime
        try {

            TimerTask updateCounter = new TimerTask()//Create an Object of TimerTask Class
            {
                public void run()//Method to change counter value
                {
                    if(EvenFlag)
                    {
                        
                        counter = (counter+1)%10;//Counter runs from 0 to 9 if ID is even
                        


                    }
                    else
                    {
                        if(counter>0)
                        {  
                            counter = (counter-1)%10;//Counter runs from 9 to 0 if ID is odd
                            
                        }
                        
                        else
                            counter=9;


                    }

                    Counter.setText(String.valueOf(counter));//Sets the value of Counter label with the current value and updates continously
                }
            };

            Timer t1 = new Timer();//Creates a new object of the timer class
            long delay = 5L;//The delay after which counter should start getting updated
            long timeLapse = 1000L;//The time gap between successive counter values
            t1.scheduleAtFixedRate(updateCounter, delay, timeLapse);//Method to update the counter value after fixed time lapse.The process of counter updation starts after given delay

        } 
        catch(Exception e)
        {
            e.printStackTrace();//Displays in message the cause of runtime error
        }


    }



    
   /* public static void main(String[] args) {

        JFrame F = new JFrame("Frame_Palkar");
        F.setSize(100,100);
        P083_Palkar_panel obj1 = new P083_Palkar_panel (81);
        F.add(obj1 );
        F.setVisible(true);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }*/
}