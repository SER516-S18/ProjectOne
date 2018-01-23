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

    /**
     * This constructor acts as a controller which calls appropriate functions to intialize timer, labels and background based on input value
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
            setBackground(Color.WHITE);
        }
        else
        {
            setBackground(new Color(173,216,230));
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
                        counter = (counter + 1) % 10;
                    else
                        counter = (9 + counter) % 10;

                }
            };

            Timer timer = new Timer();
            long interval = 1000L;
            long delay = 0L;
            timer.scheduleAtFixedRate(oneSecondTask, delay, interval);
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
        nameLabel = new JLabel("<html>Balachandar<br>Sampath</html>");
        counterLabel = new JLabel();
        Border border = counterLabel.getBorder();
        Border margin = new EmptyBorder(11,11,11,11);
        counterLabel.setBorder(new CompoundBorder(border, margin));
        nameLabel.setFont(new Font("Papyrus",Font.PLAIN,15));
        counterLabel.setFont(new Font("Papyrus",Font.PLAIN,15));
        add(nameLabel);
        add(counterLabel);
    }

    /**
     * This method is to test this application
     * @param args
     */
  /*  public static void main(String[] args) {

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
    }*/

}
