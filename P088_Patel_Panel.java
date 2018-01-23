import javax.swing.*;
import java.awt.*;

/**
 *
 * @author jay patel
 * @version 1.0
 *
 */

// defining a JPanel

public class P088_Patel_Panel implements Runnable   //thread for implementing counter.
{
    private JLabel label = new JLabel("<html> Jay <br> Patel </html>");
    private JLabel label1 = new JLabel("0");
    JPanel panel;
    int y;

    // counter logic
    @Override
    public void run() {
        if (y%2 == 0){
        for(int i=0; i<10; i++) {

            label1.setText("" + i );
            if (i == 9){
                i = 0;
            }
            // exception handling
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
        else {
            for(int i=9; i >=0 ; i-- ){
                label1.setText("" + i );
                if (i == 0){
                    i = 10;
                }
                // exception handling
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public P088_Patel_Panel(int x) {
        y = x;
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        // background logic
        if (x%2 == 0) {
            panel.setBackground(Color.white);
        }
        else {
            panel.setBackground(new Color(173,216,230));
        }
        panel.setPreferredSize(new Dimension(100, 100));
        panel.add(label);
        label.setFont(new Font("Papyrus", Font.PLAIN, 15));
        label.setHorizontalAlignment(JLabel.CENTER);
        constraints.gridy = 1;
        panel.add(label1, constraints);
        label1.setFont(new Font("Papyrus", Font.PLAIN, 15));
        label.setHorizontalAlignment(JLabel.CENTER);
        Thread thread = new Thread(this);
        thread.start();  // Starts the Thread
    }
    /**
     *
     * @return - Returns the panel object
     */

    public JPanel returnpanel(){

        return panel;
    }

}

