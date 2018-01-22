package P092_Priya_Panel;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Logger;

public class P092_Priya_Panel {

    private int colorFlag;

    private static final Logger LOGGER = Logger.getLogger(P092_Priya_Panel.class.getSimpleName());

    public P092_Priya_Panel(int colorFlag) {
        this.colorFlag = colorFlag;
    }

    public JPanel getJPanel() {

        Timer timer = new Timer();

        final int[] timeElapsedSec = {0};

        JPanel panel = new JPanel();
        try {

            Font font = new Font("Papyrus", Font.PLAIN, 12);

            JLabel firstName = new JLabel("Aashita");
            JLabel lastName = new JLabel("Priya");

            firstName.setAlignmentX(Component.CENTER_ALIGNMENT);
            lastName.setAlignmentX(Component.CENTER_ALIGNMENT);

            firstName.setFont(font);
            lastName.setFont(font);

            JLabel tick = new JLabel();
            tick.setFont(font);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(firstName, Component.CENTER_ALIGNMENT);
            panel.add(lastName, Component.CENTER_ALIGNMENT);
            if (colorFlag % 2 == 0) {

                timeElapsedSec[0] = 0;
                panel.setBackground(Color.white);
                timer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        if (timeElapsedSec[0] <= 9) {
                            tick.setText(Integer.toString(timeElapsedSec[0]++));
                        } else {
                            timeElapsedSec[0] = 0;
                        }
                    }
                }, 1000, 1000);
            } else {
                timeElapsedSec[0] = 9;
                panel.setBackground(Color.cyan);
                timer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        if (timeElapsedSec[0] >= 0) {
                            tick.setText(Integer.toString(timeElapsedSec[0]--));
                        } else {
                            timeElapsedSec[0] = 9;
                        }
                    }
                }, 1000, 1000);

            }
            panel.add(tick);

        } catch (Exception e) {
            LOGGER.severe("Exception Occurred:" + e.getMessage());
        }

        return panel;
    }

    public static void main(String[] args) {
        // TODO: I have commented out the main function, which will be written by the second developer. I have written some code which should be a good starting point for the developer

        JFrame frame;
        frame = new JFrame("P092_Priya_Panel");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(100,100));
        P092_Priya_Panel obj = new P092_Priya_Panel(91);
        frame.getContentPane().add(obj.getJPanel());
    }
}