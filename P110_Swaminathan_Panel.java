
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lab 1
 * @author Sangeetha Swaminathan
 * @version 1.0
 * P110_Swaminathan_Panel is a panel.
 * Row one is the first name.
 * Row two is the last name.
 * Row three is a counter that is either incrementing from 0 or decrementing from 9.
 * The mode of the counter and the background color are determined by the value passed to the constructor
 */
public class P110_Swaminathan_Panel extends JPanel {
    
    
    GridBagConstraints gbc = new GridBagConstraints();
    Font font = new Font("Papyrus", Font.PLAIN, 15);
    Color blue = new Color (173,216,230);
    
    
    /**
     * Class constructor.
     * @param typeSwitch Used to describe the background and counter mode of the panel.
     * Even number : White background and Counter Increases
     * Odd Number : Blue background and Counter Decreases
     */
    
    public P110_Swaminathan_Panel(int typeSwitch) {
        
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(100, 100));
        
        JLabel firstname = new JLabel("Sangeetha", JLabel.CENTER);
        JLabel lastname = new JLabel("Swaminathan", JLabel.CENTER);
        firstname.setFont(font);
        lastname.setFont(font);
        addAtPosition(firstname, 0, 0);
        addAtPosition(lastname, 0, 1);
        
        if (typeSwitch % 2 == 0) {
            this.setBackground(Color.white);
        } else {
            this.setBackground(blue);
            
        }
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int value = 0;
                int step = 1;
                
                if(typeSwitch % 2 == 1) {
                    value = 9;
                    step = -1;
                }
                
                JLabel counter = new JLabel(new Integer(value).toString());
                counter.setHorizontalAlignment(JLabel.CENTER);
                counter.setFont(font);
                addAtPosition(counter, 0, 2);
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println(e.toString());
                        continue;
                    }
                    
                    value = value + step;
                    if(typeSwitch % 2 == 1 && value < 0) {
                        value = 9;
                    }
                    counter.setText(new Integer(Math.abs(value % 10)).toString());
                }
            }
        });
        thread.start();
        setVisible(true);
    }
    
    void addAtPosition(Component component, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(component, gbc);
    }
}

