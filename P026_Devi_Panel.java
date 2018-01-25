import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


/* SER: 516(SOFTWARE AGILITY)
 *@author sanaydevi, ASU id: svdevi, Number 028.
 * @version 1.0
 * @since   01-21-2018
 * LAB 1: USING AGILE PRINCIPLES TEAM SHOULD ASSEMBLE A PROJECT.
 * IN THIS CODE A JPANEL IS BEING CREATED DISPLAYING THE NAME AND 
 * INTEGER NUMBERS USING A TIMER
 */

public final class P026_Devi_Panel extends JPanel {


    JPanel finalPanel;
    JLabel nameLabel;
    JLabel numLabel;
    public static Color LIGHT_BLUE = new Color(173, 216, 230);
    public final int HEIGHT = 100;
    public final int WIDTH = 100;
    public final int FONT_SIZE = 15;
    


    public P026_Devi_Panel(int value) {

        Devi_method(value);
    }
    public void Devi_method(int flag) {
        /*Panel,label properties specified.
         *Timer with flag as condition implemented.
         *Checking if integer passed is not even, means it's odd so set 
         *background to light blue and decrement counter from 9 onwards till 0
         * else set it to white and increment counter from 0 onwards till 9.
         *after every 1000 ms that is one second timer is set
         */
        
        finalPanel = new JPanel(new GridBagLayout());
        finalPanel.setSize(WIDTH, HEIGHT);
        GridBagConstraints coordinate = new GridBagConstraints();
        nameLabel = new JLabel();
        nameLabel.setFont(new Font("Papyrus", Font.BOLD, FONT_SIZE));
        nameLabel.setText("<html> Sanay <br> Devi </html>");
        coordinate.gridx = 0;
        coordinate.gridy = 1;
        finalPanel.add(nameLabel, coordinate);

        Timer timer = new Timer();
        numLabel = new JLabel();
        
        if (flag % 2 != 0) {
            finalPanel.setBackground(LIGHT_BLUE);
            TimerTask task = new TimerTask() {
                int counter = 9;
                public void toDO() {

                    numLabel.setText(String.valueOf(counter--));
                    numLabel.setFont(new Font("Papyrus", Font.PLAIN, FONT_SIZE));

                }
                public void run() {

                    toDO();
                    try {
                        if (counter < -1) {
                            counter = 9;
                            toDO();
                        }
                    } catch (Exception e) {

                        System.out.println("Error! : " + e + " Stopping the timer...");
                        timer.cancel();
                    }

                }
            };
            timer.scheduleAtFixedRate(task, 0, 1000);
        } else {
            finalPanel.setBackground(Color.WHITE);
            TimerTask task = new TimerTask() {
                int counter = 0;
                public void toDO() {
                    numLabel.setText(String.valueOf(counter++));
                    numLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));

                }
                public void run() {

                    toDO();
                    try {
                        if (counter > 10) {
                            counter = 0;
                            toDO();
                        }
                    } catch (Exception e) {
                        System.out.println("Error! " + e + " Stopping the timer...");
                        timer.cancel();
                    }

                }
            };
            timer.scheduleAtFixedRate(task, 0, 1000);
        }
        coordinate.gridx = 0;
        coordinate.gridy = 2;
        finalPanel.add(numLabel, coordinate);
        finalPanel.setVisible(true);

    }
    public JPanel getPanel() {
        return finalPanel;
    }
}
