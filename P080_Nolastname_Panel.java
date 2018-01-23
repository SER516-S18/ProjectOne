import javax.swing.*;
import java.awt.*;

/*  Lab 1
    Author: Aditya Kumar
    Panel with 2 JLabels containing full name and timer which increments from 0-9
    with background white if the input provided to constructor is even or decrements from
    9-0 with light blue background if input provided to constructor is odd
*/

public class P080_Nolastname_Panel extends JPanel implements Runnable{
    private JLabel timeLabel;  // JLabel for Timer
    private JLabel nameLabel;  // JLabel for FullName(First Row contains First name and second row contains last name)
    static Integer startingPoint;
    Color lightBlue= new Color(173,216,230); // Light blue colour definition in rgb

    public P080_Nolastname_Panel(int num){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Setting the layout
        setSize(100,100);  // Setting the size of the Layout
        nameLabel = new JLabel("<html>Aditya<br>Kumar</html>"); // Setting the contents of the FullName JLabel
        nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);        //sets the alignment of the label to the centre inside panel
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel = new JLabel("");
        timeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);   //sets the alignment of the label to the centre inside panel
        Font fontName = new Font("Papyrus", Font.PLAIN, 15); // setting the font of the labels
        nameLabel.setFont(fontName);
        timeLabel.setFont(fontName);
        timeLabelOrder(num);
        this.add(nameLabel); // adding name label to panel
        setVisible(true);
    }

    public void timeLabelOrder(int num){  // Function to identify whether even or odd input is provided and increments or decrements the timer accordingly
        Thread t = new Thread(this);
        if(num%2 == 0){
            startingPoint = -1;
            this.setBackground(Color.WHITE); // Setting Background colour to white
        } else {
            startingPoint = 10;
            this.setBackground(lightBlue);   // Setting background colour to blue
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
                    this.add(timeLabel); // adding timelabel to panel
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
                    this.add(timeLabel); // adding time label to panel
                }catch (InterruptedException e) {
                    System.out.println("Following Error has occured: "+e.getMessage());
                }

            }
        }
    }
}

