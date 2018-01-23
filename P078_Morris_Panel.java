/**
 * Project One
 * SER 516 (SP18)
 * Gary Morris, ID#78
 */
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
 * @author Gary Morris
 * @version 1.5
 * @since 19 JAN 2018
 */
class P078_Morris_Panel extends JPanel {
    private final boolean isEven;
    private int counter;
    private int count;
    private final JLabel label_name;
    private final JLabel label_count;
    private final String string_name = "<html>Gary<br>Morris</html>";
    
    /**
     * Constructs the panel class
     * @param value determines background color and if counter increases or 
     * decreases.
     */
    public P078_Morris_Panel(int value) {
        // determine if value is odd  or even
        isEven = value %2 == 0;
        // creates counter lable, determines background color and counter
        // direction
        if(isEven) {
            setBackground(Color.WHITE);
            count = 0;
            label_count = new JLabel("0");
        } else {
            setBackground(new Color(173, 216, 230));
            count = 9;
            label_count = new JLabel("9");
        }
        // create name label
        label_name = new JLabel(string_name);
        // set font style and size
        label_name.setFont(new Font("Papyrus", Font.PLAIN, 20));
        label_count.setFont(new Font("Papyrus", Font.PLAIN, 30));
        // set font alignment
        label_name.setHorizontalAlignment(JLabel.CENTER);
        label_count.setHorizontalAlignment(JLabel.CENTER);
        // set how panel is layed out
        setLayout(new GridLayout(1, 2));
        // set size of panel
        setPreferredSize(new Dimension(100, 100));
        // creates the panel
        add(label_name);
        add(label_count);
        // creates timer thread
        try {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new CounterTask(), 1000, 1000);
        } catch(Exception e) {
            System.out.println("Error with P078_Morris_Panel.java");
        }
    }
    
    /**
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
            if(isEven) {
                counter++;
                count = counter %10;
            }
            // decreases counter
            else {
                counter--;
                // ensures 0 is printed
                if(counter %10 == 0) {
                    count = 0;
                } 
                // ensures counter goes down
                else {
                    count = (counter %10) + 10;
                }
            }
            // sets current counter value in panel
            label_count.setText(Integer.toString(count));
        }
    }
}
