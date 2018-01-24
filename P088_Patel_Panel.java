import javax.swing.*;
import java.awt.*;

/**
 *
 * @author jay patel
 * @version 1.0
 *
 * This file contains java code module for displaying a JPanel alongside with JLabel
 * as per given functional requirements
 *
 */
public class P088_Patel_Panel extends JPanel implements Runnable {
    private JLabel name = new JLabel("<html> Jay <br> Patel </html>");
    private JLabel counter = new JLabel("0");
    private int parameter;

    /**
   *
   * When a new thread is started by this class, Thread method is executed.
   * If the input is odd then counter will start from 9,
   * elseif input is even then counter will start from 0.
   * */
    @Override
    public void run() {
        if (parameter%2 == 0){
            for(int i=0; i<10; i++) {
                counter.setText("" + i );
                if (i == 9){
                    i = 0;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            for(int i=9; i >=0 ; i-- ){
                counter.setText("" + i );
                if (i == 0){
                    i = 10;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
    * Constructor of this class, used to instantiate
    * panel objects, and counter.
    *
    * @param parameter An integer parameter to decide the background color of the panel and
     *                  starting point of the counter.
    */
    public P088_Patel_Panel(int parameter) {
        this.parameter = parameter;
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        Color lightblue = new Color(173,216,230);
        if (parameter %2 == 0) {
            this.setBackground(Color.white);
        }
        else {
            this.setBackground(lightblue);
        }
        this.setPreferredSize(new Dimension(100, 100));
        this.add(name);
        name.setFont(new Font("Papyrus", Font.PLAIN, 15));
        name.setHorizontalAlignment(JLabel.CENTER);
        constraints.gridy = 1;
        this.add(counter, constraints);
        counter.setFont(new Font("Papyrus", Font.PLAIN, 15));
        name.setHorizontalAlignment(JLabel.CENTER);
        Thread thread = new Thread(this);
        thread.start();
    }
}
