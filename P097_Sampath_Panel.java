import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Balachandar Sampath (ASU: bsampat5)
 * @version 1.0.0 (01/21/2018)
 * @purpose This class extends JPanel. This is the mini jpanel consisting of name and a counter value
 */
public class P097_Sampath_Panel extends JPanel{

    private JLabel nameLabel;
    private JLabel counterLabel;
    private int counter;
    private TimerTask oneSecondTask;
    private boolean isEven;
    private static final String LABEL_NAME = "<html>Balachandar<br>Sampath</html>";
    private static final String FONT_TYPE = "Papyrus";
    private static final int FONT_SIZE = 15;
    private static final int FONT_STYLE = Font.PLAIN;
    private static final int COUNTER_SIZE = 10;
    private static final long TIMER_INTERVAL = 1000L;

    /**
     * This enum is used to return color objects
     */
    public enum ColorsEnum{
        LIGHTBLUE(new Color(173,216,230)), WHITE(Color.WHITE);
        private Color color;
        private ColorsEnum(Color color)
        {
            this.color=color;
        }
        public Color getColor() {
            return color;
        }
    }
    /**
     * This constructor acts as a controller which calls appropriate functions to intialize timer, labels and background
     * based on input value
     * @param inputValue
     */
    public P097_Sampath_Panel(int inputValue)
    {
        isEven = (inputValue%2==0);
        setPreferredSize(new Dimension(100, 100));
        initializeLabels();
        initializeTimer(isEven);
        initializeBackGround(isEven);
        setVisible(true);
    }

    /** This method initialises the background based on the input value.
     *
     * @param isEven
     */
    private void initializeBackGround(boolean isEven) {
        if(isEven)
        {
            setBackground(ColorsEnum.WHITE.getColor());
        }
        else
        {
            setBackground(ColorsEnum.LIGHTBLUE.getColor());
        }
    }

    /**
     * This method initialises the timer based on the parameter value specifying true or false
     * @param isEven
     */
    private void initializeTimer(boolean isEven) {
        //initialise counter here
        counter = isEven?0:9;
        try {
            oneSecondTask = new TimerTask() {
                public void run() {
                    counterLabel.setText(String.valueOf(counter));
                    if (isEven)
                        counter = (counter + 1) % COUNTER_SIZE;
                    else
                        counter = (COUNTER_SIZE + counter - 1) % COUNTER_SIZE;
                }
            };
            Timer timer = new Timer();
            long delay = 0L;
            timer.scheduleAtFixedRate(oneSecondTask, delay, TIMER_INTERVAL);
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
        }
    }

    /** This method is used to initialise the labels, one for name and another for counter value.
     *
     */
    public void initializeLabels()
    {
        setLayout(new GridBagLayout());
        nameLabel = new JLabel(LABEL_NAME);
        counterLabel = new JLabel();
        Border border = counterLabel.getBorder();
        Border margin = new EmptyBorder(11,11,11,11);
        counterLabel.setBorder(new CompoundBorder(border, margin));
        nameLabel.setFont(new Font(FONT_TYPE,FONT_STYLE,FONT_SIZE));
        counterLabel.setFont(new Font(FONT_TYPE,FONT_STYLE,FONT_SIZE));
        add(nameLabel);
        add(counterLabel);
    }

    /**
     * This method is to test this application
     * @param args
     */
/*    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setLayout(new GridLayout(5, 5));
        // This is how to initialise JPanel and use the created object directly
        jFrame.add(new P097_Sampath_Panel(Integer.MIN_VALUE));
        for(int i=0;i<24;i++)
        {
            jFrame.add(new P097_Sampath_Panel(i));
        }
        jFrame.setSize(1000, 500);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
*/
}
