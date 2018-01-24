import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Author: Lei Zhang, ID: 130
 * P130_Zhang_Panel class to create a 100*100 panel
 * The panel contains label displaying author's name
 * A number increasing from 0-9 or decreasing from 9-0 will be displayed
 * The color of panel and initial number will be set in constructor
 */

public class P130_Zhang_Panel extends JPanel{
    final private int DEFAULT_TIME_INTERVAL = 1000;
    final private int DEFAULT_FONT_SIZE = 15;
    final private String DEFAULT_FONT_STYLE = "Papyrus";
    final private String FIRST_NAME = "Lei";
    final private String LAST_NAME = "Zhang";
    final private Color LIGHT_BLUE = new Color(173,216,230);
    
    private int counter;
    private JLabel countLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private boolean counterFlag = true;
    private Timer timer;
    /**
     * Construct the panel
     * The counter and color is determined by argument count.
     * @param count
     */
    public P130_Zhang_Panel(int count) {
        init();
        counter = count;
        if (counter > 9){
        	counter %= 10;
        }
        if ((counter & 1) == 0) {
            setBackground(Color.WHITE);
            counterFlag = true;
        } else {
            setBackground(LIGHT_BLUE);
            counterFlag = false;
        }
        try{
        	/**
        	 * Create timer to update the counter on the label
        	 */
            timer = new Timer(DEFAULT_TIME_INTERVAL, new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    //Check increase flag then increase of decrease time
                    if(counterFlag) {
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
     * Set label properties
     */
    public void init(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(100, 100);
        firstNameLabel = new JLabel(FIRST_NAME, JLabel.CENTER);
        lastNameLabel = new JLabel(LAST_NAME, JLabel.CENTER);
        countLabel = new JLabel();
        
        firstNameLabel.setAlignmentX(CENTER_ALIGNMENT);
        lastNameLabel.setAlignmentX(CENTER_ALIGNMENT);
        countLabel.setAlignmentX(CENTER_ALIGNMENT);
        
        countLabel.setFont(new Font(DEFAULT_FONT_STYLE, Font.PLAIN, DEFAULT_FONT_SIZE));
        firstNameLabel.setFont(new Font(DEFAULT_FONT_STYLE, Font.PLAIN, DEFAULT_FONT_SIZE));
        lastNameLabel.setFont(new Font(DEFAULT_FONT_STYLE, Font.PLAIN, DEFAULT_FONT_SIZE));
        
        add(firstNameLabel);
        add(lastNameLabel);
        add(countLabel);
    }

    /**
     * This is main used to testing.
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
