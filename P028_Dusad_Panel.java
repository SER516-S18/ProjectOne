import java.awt.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
import java.awt.Color;
import java.lang.Exception;
/**
 * P028_Dusad_Utsav: We create a panel with three rows of JLabels.
 * Row1 contains first name of the author of this class.
 * Row2 is the last name of the author.
 * Row3 is a counter which increments or decrements depending on the parameter passed to the constructor while creating the object.
 * @author Utsav Dusad
 * @version 1.0
 */
public class P028_Dusad_Panel extends JPanel{
    private int counter;
    private boolean even;
    private JLabel timer;
    private static final int FONT_SIZE=15;
    private static final String FONT_STYLE="Papyrus";
    private static final String FIRSTNAME="Utsav";
    private static final String LASTNAME="Dusad";
    private static final long serialVersionUID=1L;
    
    /**
     * Constructor which takes an integer as input.
     * If the integer is even then we set even=true and counter to 0. value goes from 0 to 9
     * If the integer is odd then we set even=false and counter to 9. value goes from 9 to 0
     */
    public P028_Dusad_Panel(int color_value) {
        
        if (color_value % 2 == 0) {
            even = true;
            counter = 0;
        } else {
            even = false;
            counter = 9;
        }
        
        try {
            preparePanelUI();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
    
    /**
     *This method creates a panel with 3 JLabels. First name, Last name and a timer.
     */
    public void preparePanelUI() {
        
        //Panel and label properties: Font, Color, Text, Layout, size and calls function made for the timer execution
        JLabel firstNameLabel,lastNameLabel;
        
        //1st label: create firstname label
        firstNameLabel = new JLabel(FIRSTNAME, JLabel.CENTER);
        
        firstNameLabel.setFont(new Font(FONT_STYLE, Font.PLAIN, FONT_SIZE));
        firstNameLabel.setHorizontalAlignment(JLabel.CENTER);
        firstNameLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(firstNameLabel);
        
        //2nd label: create lastname label
        lastNameLabel = new JLabel(LASTNAME, JLabel.CENTER);
        lastNameLabel.setFont(new Font(FONT_STYLE, Font.PLAIN, FONT_SIZE));
        lastNameLabel.setHorizontalAlignment(JLabel.CENTER);
        lastNameLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(lastNameLabel);
        
        //3rd label: create timer label
        timer = new JLabel("0", JLabel.CENTER);
        Timer t = new Timer();
        timer.setFont(new Font(FONT_STYLE, Font.PLAIN, FONT_SIZE));
        timer.setHorizontalAlignment(JLabel.CENTER);
        timer.setVerticalAlignment(JLabel.CENTER);
        this.add(timer);
        
        
        if (even) {
            this.setBackground(Color.WHITE);
        } else {
            Color lightBlue = new Color(173,216,230);
            this.setBackground(lightBlue);
        }
        this.setLayout(new GridLayout(3,0));
        
        //Timer execution : From 0 to 9 when flag is even and from 9 to 0 when flag is odd
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (even==true) {
                    if (counter == 10)
                        counter = 0;
                    timer.setText(""+ counter++);
                } else {
                    if (counter == -1)
                        counter = 9;
                    timer.setText(""+ counter--);
                }
            }
        }, 0, 1000);
        
    }
    
}

