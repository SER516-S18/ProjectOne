/**
 * 1. Every panel class must have three methods. A constructor. A main method (for your testing). And a function which does all the work.
 * 2. The constructor will take an integer argument and based on that set a flag for background color and timer
 * 3. The main function must not have any logical code inside it. It should just call a public function which does all the work
 * 4. Every panel must have a size of 100 x 100.
 * 5. Font of the panel must be papyrus to keep it uniform across the application.
 * 6. The tabs class will create an object of each panel class individually. And organise them accordingly.
 * And Manas is creating a blackboard thread where things will be more clear and people can stay at same page all the time
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.BoxLayout;

/**
 *author: Lei Zhang, ID: 130
 *A P130_Zhang_Panel class to create a 100*100 panel with constructor, a main method for testing and a function do all other works
 */

public class P130_Zhang_Panel extends JPanel{
    final private int TIME_INTERVAL = 1000;
    final private String FIRST_NAME = "Lei";
    final private String LAST_NAME = "Zhang";
    
    private int counter;
    private JLabel countLabel;
    private boolean flag = true;
    private Timer timer;
    /**
     * Construct the panel
     * The counter and color is determined by
     * argument counter.
     * @param counter
     */
    public P130_Zhang_Panel(int count) {
        init();
        counter = count;
        if ((counter & 1) == 0) {
            setBackground(Color.WHITE);
            flag = true;
        } else {
            setBackground(new Color(224, 255, 255));
            flag = false;
        }
        try{
            timer = new Timer(TIME_INTERVAL, new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    //Check increase flag then increase of decrease time
                    if(flag) {
                        counter++;
                        if(counter == 10) {counter -= 10;}
                    }else {
                        counter--;
                        if(counter == -1) {counter += 10;}
                    }
                    //Update text
                    countLabel.setText(Integer.toString(counter));
                }
            });
            timer.start();
        }catch(Exception err){
            err.printStackTrace();
        }
    }
    
    /**
     * Initialize the Panel
     * Set layout and font size
     * Set label options
     */
    public void init(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(100, 100);
        JLabel firstNameLabel = new JLabel(FIRST_NAME, JLabel.CENTER);
        JLabel lastNameLabel = new JLabel(LAST_NAME, JLabel.CENTER);
        countLabel = new JLabel();
        countLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
        firstNameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
        lastNameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
        add(firstNameLabel);
        add(lastNameLabel);
        add(countLabel);
    }

    /**
     * This is used to testing.
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel testPanel = new P130_Zhang_Panel(1);
        frame.setSize(800, 800);
        frame.add(testPanel);
        frame.setVisible(true);
    }
}
