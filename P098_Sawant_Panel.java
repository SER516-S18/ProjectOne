import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * P098_Sawant_Panel
 * @author: Nishiti Sawant
 * The following class displays a panel with 2 Jlabels: name and timer
 * The name label displays both first and the last name and
  * the timer label displays a counter
 * */
public class P098_Sawant_Panel extends JPanel{
    Timer timer;
    private int count;
    //private int decider;
    private JLabel name = new JLabel("<html>Nishiti<br>Sawant</html>");
    private JLabel timerLabel = new JLabel("");

    /*
    * The constructor takes panelPosition as a parameter and
    * displays the labels and formats the panel
    * It passes the panelPosition to counter() function
    * which decides the background and the content of timer label
    * */
    public P098_Sawant_Panel(int panelPosition) {

        setSize(100,100);
        setLayout(new GridBagLayout());

        GridBagConstraints namePosition = new GridBagConstraints();
        GridBagConstraints timerLabelPosition = new GridBagConstraints();

        namePosition.gridx = 0;
        namePosition.gridy = 0;

        timerLabelPosition.gridx = 0;
        timerLabelPosition.gridy = 2;

        name.setFont(new Font("Papyrus",Font.PLAIN,15));
        timerLabel.setFont(new Font("Papyrus",Font.PLAIN,15));

        add(name, namePosition);
        add(timerLabel, timerLabelPosition);

        counter(panelPosition);
    }

    /*
    * Displays an increasing counter and a white background
    * if the decider value that is the panel position is even
    * or a decreasing counter and a light blue background
    * if the decider is odd using a timer with a delay of 1 sec
    * */
    public void counter(int decider) {

        try {
            if (decider % 2 == 0) {

                setBackground(Color.white);
                count = 0;

                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        timerLabel.setText(String.valueOf(count));
                        count++;
                        if (count == 10)
                            count = 0;
                    }
                });
                timer.start();
            }
            else {

                Color lightBlue = new Color(153, 180, 209);
                setBackground(lightBlue);
                count = 9;

                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        timerLabel.setText(String.valueOf(count));
                        count--;
                        if (count < 0)
                            count = 9;
                    }
                });
                timer.start();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
