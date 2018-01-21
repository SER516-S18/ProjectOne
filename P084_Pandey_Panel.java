import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.synth.SynthStyle;

/**
 * P084_Pandey_Panel
 * @author: Dileep Pandey
 * objName.getPanel() -> Returns Panel
 */
public class P084_Pandey_Panel implements ActionListener{

    static JPanel panel;
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

        // Initializing panel
        panel = new JPanel();
        // panel.setLayout(new GridLayout(3, 1));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(100, 100);
        
        // Setting background to white if even, else light blue or cyan.
        if(even) {
            panel.setBackground(Color.WHITE);
        } else {
            panel.setBackground(Color.CYAN);
        }
        
        // Setting font style
        firstName.setFont(new Font("Papyrus", Font.PLAIN, 14));
        lastName.setFont(new Font("Papyrus", Font.PLAIN, 14));
        counter.setFont(new Font("Papyrus", Font.PLAIN, 14));

        // Align Center
        firstName.setAlignmentX(Component.CENTER_ALIGNMENT);
        lastName.setAlignmentX(Component.CENTER_ALIGNMENT);
        counter.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Starting the timer
        tm.start();
        
        // Adding Components
        panel.add(firstName, SwingConstants.CENTER);
        panel.add(lastName);
        panel.add(counter);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        execute();
        panel.repaint();
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

    // Returns Panel object
    public JPanel getPanel() {
        return panel;
    }
    
}