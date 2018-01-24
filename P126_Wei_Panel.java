import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
}
