import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * P040_Henderson_Panel, a panel for ProjectOne, featuring a countdown timer and the author's name
 *
 * @author  David Henderson (dchende2@asu.edu)
 * @version 1.0
 * @since   2018-01-18
 */
public class P040_Henderson_Panel extends JPanel {
    // Public constants, available to change if necessary
    public static Color LIGHT_BLUE = new Color(173,216,230);
    public static Font FONT = new Font("Papyrus", Font.PLAIN, 16);
    
    protected final JLabel labelName = new JLabel("<html><center>David<br>Henderson</center></html>");
    protected final JCountdownLabel labelCounter;

    /**
     * Constructor to create the panel.
     * @param value An integer to determine if the timer counts down (odd value) or up (even value)
     */
    public P040_Henderson_Panel(int value) {
        this.setLayout(new BorderLayout());
        
        labelName.setFont(FONT);
        labelName.setHorizontalAlignment(SwingConstants.CENTER);
        labelName.setAlignmentX(0.5f);
        this.add(labelName, BorderLayout.PAGE_START);

        if(value % 2 == 0) {
            // If value is even set the panel background to white and count up
            this.setBackground(Color.WHITE);
            labelCounter = new JCountdownLabel(true);
        } else {
            // If value is odd set the panel background to light blue and count down
            this.setBackground(LIGHT_BLUE);
            labelCounter = new JCountdownLabel(false);
        }

        labelCounter.setFont(FONT);
        labelCounter.setHorizontalAlignment(SwingConstants.CENTER);
        labelCounter.setAlignmentX(0.5f);
        this.add(labelCounter, BorderLayout.CENTER);
    }

    /**
     * JCountdownLabel, a JLabel timer that can either count up or down, with values 0 - 9.
     */
    private static class JCountdownLabel extends JLabel {
        private final boolean ascending;
        private int value = 0;

        /**
         * Constructor to create a JLabel that counts 0-9 on repeat
         * @param ascend Specifies whether the counter increments or decrements through values 0 - 9.
         */
        public JCountdownLabel(boolean ascend) {
            this.ascending = ascend;
            this.setText(String.valueOf(value));

            // Task executed every 1000ms
            ActionListener task = e -> {
                JCountdownLabel.this.value = (JCountdownLabel.this.value + 1) % 10;
                if(ascending)
                    this.setText( String.valueOf(JCountdownLabel.this.value) ); // (Raw value)
                else
                    this.setText( String.valueOf(9 - JCountdownLabel.this.value) ); // (9 - raw value)
            };

            // Timer to increment the value and update the label
            Timer timer = new Timer(1000, task);
            timer.setRepeats(true);
            timer.start();
        }
    }
}
