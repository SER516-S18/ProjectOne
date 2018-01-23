import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * P098_Sawant_Panel
 * @author: Nishiti Sawant
 * */

public class P098_Sawant_Panel extends JPanel{
    Timer timer;
    int counter;
    int index;

    //Initializing panel and count label
    JLabel name = new JLabel("<html>Nishiti<br>Sawant</html>");
    JLabel timerlabel = new JLabel("");

    //Constructor: Takes the value of the decider variable
    public P098_Sawant_Panel(int n) {

        index = n;

        setLayout(new BorderLayout());
        setSize(100,100);

        //first label: Name


        name.setHorizontalAlignment(JLabel.CENTER);
        timerlabel.setHorizontalAlignment(JLabel.CENTER);

        //adding labels to the panel
        add(BorderLayout.NORTH, name);
        add(timerlabel);

        //method call for the timer
        counter();
    }

    //displays the timer values
    public void counter() {

        //checks if index is even or odd and performs the following actions
        try {
            if (index % 2 == 0) {

                setBackground(Color.white);
                counter = 0;

                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        timerlabel.setText(String.valueOf(counter));
                        counter++;
                        if (counter == 10)
                            counter = 0;
                    }
                });
                timer.start();
            }
            else {

                Color lightBlue = new Color(153, 180, 209);
                setBackground(lightBlue);
                counter = 9;

                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        timerlabel.setText(String.valueOf(counter));
                        counter--;
                        if (counter < 0)
                            counter = 9;
                    }
                });
                timer.start();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


    /*public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);//Visibility of the Frame is set
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        P098_Sawant_Panel pan = new P098_Sawant_Panel (99);
        jFrame.getContentPane().add(pan);//Panel added to the frame
        jFrame.setSize(100,100);
    }*/
}
