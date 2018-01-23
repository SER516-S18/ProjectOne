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
    static JPanel panel=new JPanel();
    JLabel count = new JLabel("");

    //Constructor: Takes the value of the decider variable
    public P098_Sawant_Panel(int n) {

        index = n;

        panel.setLayout(new BorderLayout());
        panel.setSize(100,100);

        //first label: Name
        JLabel name = new JLabel("<html>Nishiti<br>Sawant</html>");

        name.setHorizontalAlignment(JLabel.CENTER);
        count.setHorizontalAlignment(JLabel.CENTER);

        //adding labels to the panel
        panel.add(BorderLayout.NORTH, name);
        panel.add(count);

        //method call for the timer
        counter();
    }

    //displays the timer values
    public void counter() {

        //checks if index is even or odd and performs the following actions
        try {
            if (index % 2 == 0) {

                panel.setBackground(Color.white);
                counter = 0;
                
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        count.setText(String.valueOf(counter));
                        counter++;
                        if (counter == 10)
                            counter = 0;
                    }
                });
                timer.start();
            } 
            else {

                Color lightBlue = new Color(153, 180, 209);
                panel.setBackground(lightBlue);
                counter = 9;
                
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        count.setText(String.valueOf(counter));
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
        JFrame frame=new JFrame();
        frame.setVisible(true);
        new P098_Sawant_Panel(2);
        frame.setSize(100,100);
        frame.getContentPane().add(panel);
    }*/
}
