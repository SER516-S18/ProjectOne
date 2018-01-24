import javax.swing.*;
import java.awt.*;

/**
 * P075_Modi_Panel.java - Class to create the panel.
 *
 * @author Rishabh Modi
 * @version 1.0
 */

public class P075_Modi_Panel extends JPanel implements Runnable {

    JLabel name = new JLabel("<html><center>Rishabh<br>Modi</center></html>");
    JLabel timer = new JLabel();
    public Font font;
    Thread t;
    int j;

    /**
     * @param j if the value is odd, the panel background changes to light blue and the counter decreases from 9 to 0
     *          if the value is even, the panel background changes to white and the counter increases from 0 to 9.
     */

    public P075_Modi_Panel(int j) {

        super();
        this.j = j;

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(100, 100));

        font = new Font("Papyrus", Font.PLAIN, 15);
        name.setFont(font);
        timer.setFont(font);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(name, constraints);
        constraints.gridy = 1;
        this.add(timer, constraints);

        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        if (j % 2 == 0) {
            this.setBackground(Color.WHITE);
            int i = 0;
            while (i < 10) {
                timer.setText("" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if (i == 10) {
                    i = 0;
                }
            }
        } else {
            this.setBackground(Color.CYAN);
            int i = 9;
            while (i > -1) {
                timer.setText("" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i--;
                if (i < 0) {
                    i = 9;
                }
            }
        }
    }
}