import javax.swing.*;
import java.awt.*;

/**
 * P075_Modi_Panel.java - Class to create the panel.
 * @author Rishabh Modi
 * @version 1.0
 *
 */

public class P075_Modi_Panel extends JFrame implements Runnable
{

//     Initialize Objects and Labels

    JPanel panel = new JPanel(new GridBagLayout());
    JLabel name = new JLabel("<html><center>Rishabh<br>Modi</center></html>");
    public int c = 0 ;
    JLabel timer = new JLabel();
    public Font font;
    Thread t;
    int j;

    /**
     *
     * @param j if the value is odd, the panel background changes to light blue and the counter decreases from 9 to 0
     *          if the value is even, the panel background changes to white and the counter increases from 0 to 9.
     */
//    Panel Constructor

    public P075_Modi_Panel(int j) {

        super();
        this.j = j;

//      Manipulate Panel

        add(panel);
        panel.setPreferredSize(new Dimension(100,100));

//        Set Fonts

        font = new Font("Papyrus", Font.PLAIN, 18);
        name.setFont(font);
        timer.setFont(font);

//      Created Grids

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(name, constraints);
        constraints.gridy = 1;
        panel.add(timer,constraints);

//      Pack

        pack();

//      Starting Thread

        t = new Thread(this);
        t.start();
    }

    @Override

//  Logic for Counter

    public void run()
    {

        if(j%2 == 0)
        {
            panel.setBackground(Color.WHITE);
            int i = 0;
            while (i < 10)
            {
                timer.setText(""+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if(i == 10)
                {
                    i = 0;
                }
            }
        }
        else
        {
            panel.setBackground(Color.CYAN);
            int i = 9;
            while (i > -1)
            {
                timer.setText(""+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i--;
                if(i < 0)
                {
                    i = 9;
                }
            }
        }
    }

    /**
     *
     * @return Jpanel object.
     */
//    Created function to return panel object

    public JPanel getPanel()
    {
        return panel;
    }
}