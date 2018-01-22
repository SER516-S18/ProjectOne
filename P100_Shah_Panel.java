import java.awt.*;

import javax.swing.*;

/**
 * @author Ayan Shah
 */
public class P100_Shah_Panel extends JFrame implements Runnable {

    //declare labels
    private JLabel name = new JLabel("<html>Ayan<br/>Shah</html>");
    private JLabel Counter = new JLabel("0");
    private JPanel P100_Panel;

    //declare control variables
    private int value;
    private int control;


    //declare Font Object
    public Font font;

    /*
    * Constructor of this class, used to instantiate
    * panel objects, set panel properties and attach labels to it.
    *
    * @param value An integer parameter to decide the background color of the panel
    */
    public P100_Shah_Panel(int value) {
        super("JPanel Project");
        //set value variable
        this.value = value;

        // create a new panel
        P100_Panel = new JPanel(new GridBagLayout());

        //set label Fonts
        font = new Font("Papyrus", Font.PLAIN, 24);
        name.setFont(font);
        Counter.setFont(font);

        // add grid constraints to manage layout of the elements
        GridBagConstraints layoutConstraints = new GridBagConstraints();
        layoutConstraints.anchor = GridBagConstraints.CENTER;
        layoutConstraints.insets = new Insets(0, 0, 0, 0);

        // add labels to the panel
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        P100_Panel.add(name, layoutConstraints);


        layoutConstraints.gridy = 1;
        P100_Panel.add(Counter, layoutConstraints);


        //add background color & set control variable
        if ((value % 2) == 0) {
            P100_Panel.setBackground(Color.WHITE);
            control = 0;
        } else {
            P100_Panel.setBackground(new Color(100, 149, 237));
            control = 1;
        }

        //set panel bounds
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        P100_Panel.setBorder(BorderFactory.createEtchedBorder());

        //set panel Size
        P100_Panel.setPreferredSize(new Dimension(100, 100));

        // start the timer thread
        Thread timer = new Thread(this);
        timer.start();
    }


    /*
    * Thread method which is executed when a new thread is started by this class.
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