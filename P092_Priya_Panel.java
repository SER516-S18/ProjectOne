
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * P092_Priya_Panel.java
 * @author  Aashita Priya
 */

public class P092_Priya_Panel {

    //Timer for counter
    private Timer timer = new Timer();

    final int[] timeElapsedSec = {0};

    //Creating labels with FirstName LastName and tick
    private JLabel firstName = new JLabel("Aashita");
    private JLabel lastName = new JLabel("Priya");
    private JLabel tick = new JLabel();

    private static final Logger LOGGER = Logger.getLogger(P092_Priya_Panel.class.getSimpleName());



    /**
     * Constructor with a parameter for color flag
     * @param colorFlag
     */
    public P092_Priya_Panel(int colorFlag) {
        int colorFlag1 = colorFlag;

        //Creating a JPanel object
        JPanel panel = new JPanel(new GridBagLayout());
        try {

            //Creating a Font object with given constraints
            Font font = new Font("Papyrus", Font.PLAIN, 15);

            //Creating constraints for the positions of each label
            GridBagConstraints fNameConstraints = new GridBagConstraints();
            GridBagConstraints lNameConstraints = new GridBagConstraints();
            GridBagConstraints timerConstraints = new GridBagConstraints();

            //Setting preferred size of the panel according to the given specifications
            panel.setPreferredSize(new Dimension(100, 100));

            //Setting constraints for FirstName Label
            fNameConstraints.gridx = 0;
            fNameConstraints.gridy = 0;

            //Setting constraints for LastName Label
            lNameConstraints.gridx = 0;
            lNameConstraints.gridy = 2;

            //Setting constraints for Tick Label
            timerConstraints.gridx = 0;
            timerConstraints.gridy = 4;

            //Set Fonts for all the labels
            firstName.setFont(font);
            lastName.setFont(font);
            tick.setFont(font);

            //Add FirstName and LastName to the panel
            panel.add(firstName, fNameConstraints);
            panel.add(lastName, lNameConstraints);

            //The logic for Ticker
            //If the constructor is passing even then count up from 0 else count down from 9
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
                panel.setBackground(new Color(173,216,230));
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
            //Add Tick to the panel
            panel.add(tick, timerConstraints);

        } catch (Exception e) {
            LOGGER.severe("Exception Occurred:" + e.getMessage());
        }
    }
}
