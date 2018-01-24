import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel class for tabs
 *
 * @author Gary Morris, ID#78, SER 516 (SP18)
 * @version Project One
 * @since 23 JAN 2018
 */
class P078_Morris_Panel extends JPanel {

    private int counter;
    private int count;
    private final boolean IS_EVEN;
    private final int COUNT_BOTTOM = 0;
    private final int COUNT_TOP = 9;
    private final JLabel LABEL_NAME;
    private final JLabel LABEL_COUNT;
    private final Color LIGHT_BLUE = new Color(173, 216, 230);
    private final String STRING_NAME = "<html>Gary<br>Morris</html>";
    private final String ZERO = "0";
    private final String NINE = "9";
    private final String FONT_NAME = "Papyrus";
    private final String PANEL_ERROR = "Error with P078_Morris_Panel.java";

    /**
     * Constructs the panel
     *
     * @param value determines background color and if counter increases or
     * decreases.
     */
    public P078_Morris_Panel(int value) {
        // determine if value is odd  or even
        IS_EVEN = value % 2 == 0;

        // creates counter lable, determines background color and counter
        // direction
        if (IS_EVEN) {
            setBackground(Color.WHITE);
            count = COUNT_BOTTOM;
            LABEL_COUNT = new JLabel(ZERO);
        } else {
            setBackground(LIGHT_BLUE);
            count = COUNT_TOP;
            LABEL_COUNT = new JLabel(NINE);
        }

        // create name label
        LABEL_NAME = new JLabel(STRING_NAME);

        // set font style and size
        LABEL_NAME.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
        LABEL_COUNT.setFont(new Font(FONT_NAME, Font.PLAIN, 30));

        // set font alignment
        LABEL_NAME.setHorizontalAlignment(JLabel.CENTER);
        LABEL_COUNT.setHorizontalAlignment(JLabel.CENTER);

        // set how panel is layed out
        setLayout(new GridLayout(1, 2));

        // set size of panel
        setPreferredSize(new Dimension(100, 100));

        // creates the panel
        add(LABEL_NAME);
        add(LABEL_COUNT);

        // creates timer thread
        try {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new CounterTask(), 1000, 1000);
        } catch (Exception e) {
            System.out.println(PANEL_ERROR);
        }
    }

    /**
     * Creates a thread to manipulate the counter
     *
     * @author Gary Morris
     * @version 1.2
     * @since 18 JAN 2018
     */
    private class CounterTask extends TimerTask {

        /**
         * Starts the CounterTask.
         */
        @Override
        public void run() {
            // increases counter
            if (IS_EVEN) {
                counter++;
                count = counter % 10;
            } // decreases counter
            else {
                counter--;

                // ensures 0 is printed
                if (counter % 10 == 0) {
                    count = 0;
                } // ensures counter goes down
                else {
                    count = (counter % 10) + 10;
                }
            }

            // sets current counter value in panel
            LABEL_COUNT.setText(Integer.toString(count));
        }
    }
}
