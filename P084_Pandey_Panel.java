import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.synth.SynthStyle;

/**
 * P084_Pandey_Panel
 * @author: Dileep Pandey
 */
public class P084_Pandey_Panel extends JPanel implements ActionListener{

    JLabel counter = new JLabel();;
    Timer tm = new Timer(1000, this);
    static int time;
    static boolean even;
    JLabel firstName = new JLabel("Dileep");
    JLabel lastName = new JLabel("Pandey");

    public P084_Pandey_Panel(int c) {
        // Checking if even or odd.
        if(c % 2 == 0) {
            even = true;
            time = 0;
        } else {
            even = false;
            time = 9;
        }

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(100, 100);
        
        // Setting background to white if even, else light blue.
        if(even) {
            setBackground(Color.WHITE);
        } else {
            setBackground(new Color(173, 216, 230));
        }
        
        // Setting font style
        firstName.setFont(new Font("Papyrus", Font.PLAIN, 15));
        lastName.setFont(new Font("Papyrus", Font.PLAIN, 15));
        counter.setFont(new Font("Papyrus", Font.PLAIN, 15));

        // Align Center
        firstName.setAlignmentX(Component.CENTER_ALIGNMENT);
        lastName.setAlignmentX(Component.CENTER_ALIGNMENT);
        counter.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Starting the timer
        tm.start();
        
        // Adding Components
        add(firstName);
        add(lastName);
        add(counter);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        execute();
        repaint();
    }

    public void execute() {
        // Logic for counter
        counter.setText("" + time);
        if(even) {
            time++;
        } else {
            time--;
        }
        if(time == 10) {
            time = 0;
        }
        if(time == -1){
            time = 9;
        }
    }
    
}
