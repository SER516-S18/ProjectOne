import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * P084_Pandey_Panel
 * @author: Dileep Pandey
 */
public class P084_Pandey_Panel extends JPanel implements ActionListener {
    private JLabel counter = new JLabel();;
    private int time;
    private boolean isEven;
    private final Color WHITE = Color.WHITE;
    private final Color LIGHTBLUE = new Color(173, 216, 230);

    /*
     * @param value
     * @summary: creates a panel containing fisrt name, last name, and counter 
     * that increases from 0 - 9 or decreases from 9 - 0 and background-color 
     * is changed to white or light blue based on value being even or odd.
    */
    public P084_Pandey_Panel(int value) {
        final JLabel firstName = new JLabel("Dileep");
        final JLabel lastName = new JLabel("Pandey");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(100, 100);
        firstName.setFont(new Font("Papyrus", Font.PLAIN, 15));
        lastName.setFont(new Font("Papyrus", Font.PLAIN, 15));
        counter.setFont(new Font("Papyrus", Font.PLAIN, 15));
        firstName.setAlignmentX(Component.CENTER_ALIGNMENT);
        lastName.setAlignmentX(Component.CENTER_ALIGNMENT);
        counter.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Adding Components to panel
        add(firstName);
        add(lastName);
        add(counter);
        // Checking if even or odd.
        if (value % 2 == 0) {
            isEven = true;
            time = 0;
        } else {
            isEven = false;
            time = 9;
        }
        if (isEven) {
            setBackground(WHITE);
        } else {
            setBackground(LIGHTBLUE);
        }
        try {
            Timer timer = new Timer(1000, this);
            timer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** 
     * @param: actionEvent
     * @summary: action listener for Timer
    */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        execute();
        repaint();
    }

    /**
     * @summary: sets state of counter
     */
    public void execute() {
        counter.setText(Integer.toString(time));
        if (isEven) {
            time++;
            if(time == 10) {
                time = 0;
            }
        } else {
            time--;
            if (time == -1) {
                time = 9;
            }
        }       
    }
}
