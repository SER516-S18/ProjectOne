
        import javax.swing.*;
        import java.awt.*;
        import java.util.concurrent.Executors;
        import java.util.concurrent.ScheduledExecutorService;
        import java.util.concurrent.TimeUnit;

        import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 * P025_Desai_Panel is panel of Dhruti Desai
 * The first row is giving first name
 * The second row is giving last name
 * Row three is a counter that is either incrementing from 0 or decrementing from 9.
 * The mode of the counter and the background color are determined by the value passed to the constructor
 @author Dhruti Desai
 */

public class P025_Desai_Panel extends JPanel {
    private int timer;
    private int type;
    private Font f = new Font("Papyrus", Font.PLAIN, 15);
   // private static JPanel jp;
    /**
     * Class constructor.
     * @param  type Describes the background and counter mode of the panel. Even numbers result in a PanelType.WhiteIncrementor, odd give a PanelType.LightBlueDecrementor.
     */
    public  P025_Desai_Panel(int type) {
        this.type = type;
        if (type % 2 == 0) {
            timer = 0;
        } else {
            timer = 9;
        }

        action_function();
    }
    /**This function is basically used to design the layout for teh panel by setting its dimensions and color.
     * This action function also executes the thread for the counter.
     * Exception handling is included to check for errors encountered by threads.*/
    private void action_function() {
      //  jp = new JPanel();
        this.setLayout(new GridLayout(2,1));
//        jp.setPreferredSize(new Dimension(100,100));
        if (type % 2 == 0)
            this.setBackground(new Color(255, 255, 255));
        else
            this.setBackground(new Color(171, 216, 230));
        JLabel name = new JLabel("<html>Dhruti<br> Desai</html>", JLabel.CENTER);
        name.setFont(new Font("Papyrus", Font.PLAIN, 15));
        JLabel counter = new JLabel("",JLabel.CENTER);
        counter.setFont(new Font("Papyrus", Font.PLAIN, 15));

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
    /**Main function is included for testing. */
   /* public static void main(String args[])
     *{
     *   JFrame jf= new JFrame();
     * jf.getContentPane().add(new P025_Desai_Panel(3));
     * jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     * jf.setVisible(true);
     * jf.setSize(400,400);
     *}*/
      
      }






