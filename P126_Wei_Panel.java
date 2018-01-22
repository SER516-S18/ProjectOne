/**
 * 1. Every panel class must have three methods. A constructor. A main method (for your testing). And a function which does all the work.
 * 2. The constructor will take an integer argument and based on that set a flag for background color and timer
 * 3. The main function must not have any logical code inside it. It should just call a public function which does all the work
 * 4. Every panel must have a size of 100 x 100.
 * 5. Font of the panel must be papyrus to keep it uniform across the application.
 * 6. The tabs class will create an object of each panel class individually. And organise them accordingly.
 * And Manas is creating a blackboard thread where things will be more clear and people can stay at same page all the time
 */

import javax.swing.*;
import java.awt.*;

/**
 * This is class is singleton.
 * Only one JPanel.
 * Author: Zitong Wei
 */
public class P126_Wei_Panel {
    private int counter;
    private static JPanel panel;
    private JLabel countLabel;
    private static Thread th;

    /**
     * Init panel and all JComponents.
     * The counter and color is determined by
     * argument counter.
     * @param counter
     */
    public P126_Wei_Panel(int counter) {
        if (panel == null) {
            panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setSize(100, 100);
            JLabel firstNameLabel = new JLabel("Zitong");
            JLabel lastNameLabel = new JLabel("Wei");
            countLabel = new JLabel();
            countLabel.setFont(new Font("Papyrus", Font.PLAIN, 12));
            firstNameLabel.setFont(new Font("Papyrus", Font.PLAIN, 12));
            lastNameLabel.setFont(new Font("Papyrus", Font.PLAIN, 12));
            panel.add(firstNameLabel);
            panel.add(lastNameLabel);
            panel.add(countLabel);
        }

        this.counter = counter;
        if ((this.counter & 1) == 0) {
            panel.setBackground(Color.WHITE);
        } else {
            panel.setBackground(Color.BLUE.brighter());
        }
    }

    /**
     * Return the static instance JPanel
     * the counter is set in the constructor
     * @return JPanel
     */
    public JPanel getPanel() {
        if ((this.counter & 1) == 0) {
            th = new Thread(() -> {
                for (int cur = 0; cur < 10; cur ++) {
                    countLabel.setText(Integer.toString(cur));
                    if (cur == 9) {
                        cur = -1;
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            th = new Thread(() -> {
               for (int cur = 9; cur >= 0; cur--) {
                   countLabel.setText(Integer.toString(cur));
                   if (cur == 0) {
                       cur = 10;
                   }

                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            });
        }

        th.start();
        return panel;
    }

    /**
     * This is used to testing.
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(100, 100);
        P126_Wei_Panel test = new P126_Wei_Panel(10);
        JPanel testPanel = test.getPanel();
        frame.add(testPanel);
        frame.setVisible(true);
    }
}
