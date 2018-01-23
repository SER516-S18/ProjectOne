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
    private int count;
    private int decider;
    private JLabel name = new JLabel("<html>Nishiti<br>Sawant</html>");
    private JLabel timerLabel = new JLabel("");

    //Constructor: Takes the value of the decider variable
    public P098_Sawant_Panel(int panelPosition) {

        decider = panelPosition;

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

        counter();
    }

    //displays the timer values
    public void counter() {

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
