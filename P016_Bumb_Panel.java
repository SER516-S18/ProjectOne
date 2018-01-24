import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Row1 one is the first name.
 * Row 2 is the last name.
 * Row 3 is the counter that is incrementing from 0 or decrementing frrom 9.
 * The mode of the counter and the background color are determined by the value passed to the constructor.
 */
public class P016_Bumb_Panel extends JPanel {
    private int timer;
    private int type;
    // private static JPanel jp;
    private Font f = new Font("Papyrus", Font.BOLD, 16);

    /**
     * constuctor class
     * describes the background color and counter mode of the panel.
     */
    public P016_Bumb_Panel(int type) { //constructor
        // Even is white and count uop, odd is cyan and counts down.
        this.type = type;
        if (type % 2 == 0) {
            timer = 0;
        } else {
            timer = 9;
        }

        function(); // calling method which has the logic
    }
    /**
     *This function sets the layout, color and also executing the thread
     *for counter
     */

    private void function() {
        // jp = new JPanel();
        setSize(100,100);
        this.setLayout(new GridLayout(2,1)); // giving attributes to the panel
//        jp.setPreferredSize(new Dimension(100,100));
        if (type % 2 == 0)
            this.setBackground(new Color(255, 255, 255));
        else
            this.setBackground(new Color(171, 216,230));
        JLabel name = new JLabel("<html>Chirag<br> Bumb</html>", JLabel.CENTER);// JPanel with full name, first name on first row and last name on second row
        name.setFont(new Font("Papyrus", Font.PLAIN, 15));
        JLabel counter = new JLabel("",JLabel.CENTER);
        counter.setFont(new Font("Papyrus",Font.PLAIN, 15));

        //error and handling and logging.
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                counter.setText(String.valueOf(timer));
                if (type % 2 == 0) {
                    timer++;
                    if (timer > 9) {
                        timer = 0;
                    }
                } else {
                    timer--;
                    if (timer < 0)
                        timer = 9;

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);

        this.add(name);
        this.add(counter);
        setVisible(true);





    }
    // Main method used for testing.

    /* public static void main(String args[])
     *{
     *  JFrame jf= new JFrame();
     *   jf.getContentPane().add(new P016_Bumb_Panel(3));// calling constructor.
     *    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     *    jf.setVisible(true);
     *    jf.setSize(1200,400);

     *}*/




}
