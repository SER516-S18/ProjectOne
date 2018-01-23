import java.awt.*;
import javax.swing.*;

/**
 * @author Ayan Shah
 * @version 1.0
 * @since 01-23-2018
 */
public class P100_Shah_Panel implements Runnable {

    private JLabel name = new JLabel("<html>Ayan<br/>Shah</html>");
    private JLabel Counter = new JLabel("0");
    private JPanel P100_Panel;

    private int value;
    private int control;

    private Font font;
    private final Color LIGHTBLUE  = new Color(173, 216, 230);

    /*
    * Constructor of this class, used to instantiate
    * panel objects, set panel properties and attach labels to it.
    *
    * @param value An integer parameter to decide the background color of the panel
    */
    public P100_Shah_Panel(int value) {
        this.value = value;

        P100_Panel = new JPanel(new GridBagLayout());
        font = new Font("Papyrus", Font.PLAIN, 15);

        name.setFont(font);
        Counter.setFont(font);

        GridBagConstraints layoutConstraints = new GridBagConstraints();
        layoutConstraints.anchor = GridBagConstraints.CENTER;
        layoutConstraints.insets = new Insets(0, 0, 0, 0);

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        P100_Panel.add(name, layoutConstraints);

        layoutConstraints.gridy = 1;
        P100_Panel.add(Counter, layoutConstraints);


        if ((value % 2) == 0) {
            P100_Panel.setBackground(Color.WHITE);
            control = 0;
        } else {
            P100_Panel.setBackground(LIGHTBLUE);
            control = 1;
        }

        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        P100_Panel.setBorder(BorderFactory.createEtchedBorder());
        P100_Panel.setPreferredSize(new Dimension(100, 100));

        Thread timer = new Thread(this);
        timer.start();
    }


    /*
    * Thread method which is executed when a
    * new thread is started by this class.
    * It will keep the counter running in an infinite loop
    *
    * */
    @Override
    public void run() {
        int time = 0;
        if(control == 1)
            time = 9;

        while (true) {
            Counter.setText("" + time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (control == 0) {
                time++;
                if (time > 9) {
                    time = 0;
                }
            } else {
                time--;
                if (time <0) {
                    time = 9;
                }
            }
        }
    }


    /*
    * @return the panel object is returned
    */
    public JPanel getInstance() {
        return P100_Panel;
    }

}
