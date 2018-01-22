import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Font;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class P106_Singal_Panel  extends JPanel {

    /*
     * Pre-defined variables for color and counter
     */
    public static final Color VERY_LIGHT_BLUE = new Color(51,204,255);
    public static final Color BG_WHITE = Color.WHITE;
    public static int counter = 0;


    //================================================================================
    // Properties
    //================================================================================
    private JLabel lblFName;
    private JLabel lblLName;
    private JLabel lblCounter;

    private Color bgColor;
    private boolean isEven;

    GridBagConstraints gbc = new GridBagConstraints();



    //================================================================================
    // Constructors
    //================================================================================

    public P106_Singal_Panel() {

        bgColor = BG_WHITE;
        counter = 0;
        isEven = true;

    }

    /*
     * Constructor
     * params: val - If even the background color will be white and the counter will
     *				increase, otherwise the background color will be light blue and
     *				the counter will decrease
     */
    public P106_Singal_Panel(int val) {
        if(val%2 == 0) {
            bgColor = BG_WHITE;
            counter = 0;
            isEven = true;
        } else {
            bgColor = VERY_LIGHT_BLUE;
            counter = 9;
            isEven = false;
        }
    }



    //================================================================================
    // Public Accessors
    //================================================================================


    /*
     *	1. Creates the Graphical Interface for the panel
     *	2. Method sets the background color according to the constructor
     *	3. The method also runs a timer for displaying the counter from 0-9 or 9-0 according to constructor
     */
    public void gui() {


        setLayout(new GridBagLayout());
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 1;
        gbc.gridy = 1;

        setBorder(BorderFactory.createLineBorder(Color.black));

        this.createLabels();

        addAtPosition(lblFName, 0, 0);
        addAtPosition(lblLName, 0, 1);
        addAtPosition(lblCounter, 0, 2);

        this.setTimer();

        setVisible(true);

    }



    //================================================================================
    // Private Accessors
    //================================================================================

    /*
     * Method to add objects to the panel at positions
     */
    private void addAtPosition(Component component, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(component, gbc);
    }

    /*
     * Create the label with name in two rows
     */
    private void createLabels() {
        lblFName = new JLabel("Vishakha", JLabel.CENTER);
        lblFName.setFont(new Font("Papyrus", Font.PLAIN, 10));
        lblFName = this.centreLabel(lblFName);


        lblLName = new JLabel("Singal", JLabel.CENTER);
        lblLName.setFont(new Font("Papyrus", Font.PLAIN, 10));
        lblLName = this.centreLabel(lblLName);



        //Create a label for displaying the counter
        lblCounter = new JLabel("   " + String.valueOf(counter));
        lblCounter.setFont(new Font("Papyrus", Font.PLAIN, 10));
        lblCounter = this.centreLabel(lblCounter);
    }

    /*
     * Now, run the timer to update the counter label every second
     * Using try catch to avoid fatal execution of code in timer
     */
    private void setTimer() {

        try {

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    TimerTask oneSecondTask = new TimerTask() {
                        public void run() {
                            if (isEven) {
                                counter = (counter+1)%10;
                            } else {
                                {
                                    if(counter>0)
                                        counter = (counter-1)%10;
                                    else
                                        counter=9;
                                }
                            }

                            lblCounter.setText("   " + String.valueOf(counter));
                        }
                    };

                    Timer timer = new Timer();
                    long delay = 5L;
                    long intervalPeriod = 1000L;
                    timer.scheduleAtFixedRate(oneSecondTask, delay, intervalPeriod);
                }
            });
            t.start();

        } catch(Exception e) {

            //Uncomment this line to view the reason for exception, if any
            //e.printStackTrace();

        } finally {
            // This method can be used to perform a task if any exception occurs.

        }
    }

    /*
     * This method takes JLabel as a parameter and returns a centre aligned label
     */
    private JLabel centreLabel(JLabel swingLabel) {
        swingLabel.setHorizontalAlignment( SwingConstants.CENTER );
        swingLabel.setAlignmentX(0.5f);
        return swingLabel;
    }

    /*
     * Main method to test the execution of the class methods
     *
     *
    public static void main(String[] args) {

        //Use following lines to integrate the class in Tabs
        // ---- START -----
        P106_Singal_Panel newObj = new P106_Singal_Panel(11);
        newObj.gui();
        // ---- END -----
    }
     */
}
