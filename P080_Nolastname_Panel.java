/* Panel with 2 JLabels containing full name and timer which increases and decreases according to input provided */

import java.swing.*;
import java.awt.*;
public class P080_Nolastname_Panel implements Runnable{
    private JPanel p;
    private JLabel timeLabel;  // JLabel for Timer
    private JLabel nameLabel;  // JLabel for FullName(First Row contains First name and second row contains last name)
    static Integer startingPoint;

    public P080_Nolastname_Panel(int num){
        p = new JPanel();
        p.setSize(100,100);
        nameLabel = new JLabel("<html>Aditya<br>Kumar</html>",JLabel.CENTER); // Setting the contents of the FullName JLabel
        timeLabel = new JLabel("",JLabel.CENTER);
        Font font = new Font("Papyrus", Font.PLAIN, 15);
        nameLabel.setFont(font);
        timeLabel.setFont(font);
        timeLabelOrder(num);
        p.add(nameLabel);
    }

    public void timeLabelOrder(int num){  // Function to identify whether even or odd input is provided and increments or decrements the timer accordingly
        Thread t = new Thread(this);
        if(num%2 == 0){
            startingPoint = -1;
            p.setBackground(Color.WHITE); // Setting Background colour to white
        } else {
            startingPoint = 10;
            p.setBackground(new Color(173,216,230));   // Setting background colour to blue
        }
        t.start();
    }

    @Override
    public void run(){  //Overrding run to show the counter incrementing or decrementing based on the even or odd argument provided
        if(startingPoint == -1){
            while(true){  // loop for incrementing number 0-9 on a white background in an infinite loop
                try{
                    timeLabel.setText(startingPoint.toString());
                    ++startingPoint;
                    Thread.sleep(1000);
                    if(startingPoint==10) {
                        startingPoint=0;
                    }
                    p.add(timeLabel);
                }catch (InterruptedException e) {
                    System.out.println("Following Error has occured: "+e.getMessage());
                }

            }
        } else {
            while(true){ // loop for decrementing number 9-0 on a light blue background in an infinite loop
                try{
                    timeLabel.setText(startingPoint.toString());
                    --startingPoint;
                    Thread.sleep(1000);
                    if(startingPoint==-1) {
                        startingPoint=9;
                    }
                    p.add(timeLabel);
                }catch (InterruptedException e) {
                    System.out.println("Following Error has occured: "+e.getMessage());
                }

            }
        }
    }

 /*   public static void main(String args[]) // Main Part
    {
        new P080_Nolastname_Panel(2);
        JFrame f;
        f = new JFrame();
        f.setVisible(true);
    } */
}
