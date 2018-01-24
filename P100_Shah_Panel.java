import java.awt.*;
import javax.swing.*;

/**
 * Create a JPanel class with custom settings which
 * can be extended to a JTab.
 *
 * @author Ayan Shah
 * @version 1.0
 * @since 01-23-2018
 */
public class P100_Shah_Panel extends JPanel implements Runnable {

    private JLabel name = new JLabel("<html>Ayan<br/>Shah</html>");
    private JLabel Counter = new JLabel("0");

    private int value;
    private int control;

    private Font font;
    private final Color LIGHTBLUE  = new Color(173, 216, 230);

    /**
    * Constructor of this class, used to instantiate
    * panel objects, set panel properties and attach labels to it.
    *
    * @param value An integer parameter to decide the background color of the panel
    */
    public P100_Shah_Panel(int value) {
        super();
        this.value = value;

        this.setLayout(new GridBagLayout());
        font = new Font("Papyrus", Font.PLAIN, 15);

        name.setFont(font);
        Counter.setFont(font);

        GridBagConstraints layoutConstraints = new GridBagConstraints();
        layoutConstraints.anchor = GridBagConstraints.CENTER;
        layoutConstraints.insets = new Insets(0, 0, 0, 0);

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        this.add(name, layoutConstraints);

        layoutConstraints.gridy = 1;
        this.add(Counter, layoutConstraints);

        if ((value % 2) == 0) {
            this.setBackground(Color.WHITE);
            control = 0;
        } else {
            this.setBackground(LIGHTBLUE);
            control = 1;
        }

        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setPreferredSize(new Dimension(100, 100));
        this.setVisible(true);

        Thread timer = new Thread(this);
        timer.start();
    }


    /**
    * Thread method which is executed when a
    * new thread is started by this class.
    * It will keep the counter running in an infinite loop
    *
    */
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
}
