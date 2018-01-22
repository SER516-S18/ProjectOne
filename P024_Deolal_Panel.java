import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P024_Deolal_Panel extends JPanel {
    private JLabel myName;
    private JLabel clock;
    private int value_of_counter;
    private int check;
    public final int HEIGHT = 50;
    public final int WIDTH = 50;
    public final int wait = 1000;

    // contructor to initialize the check variable
    public P024_Deolal_Panel(int check){
        this.check = check;
        set_panel_size();
        name_label();
        set_background_colour();
        set_counter_value();
        set_timer();
    }

    // value of counter changes depending upon the check. If check is even it sets to 0 and if it is odd it sets to 9
    private void set_counter_value() {
        if(is_even()) value_of_counter = 0; else value_of_counter = 9;
        
    }


      // The background colour of the panel is set white if the check is even else it set "light blue".
    private void set_background_colour() {

        if(is_even()){
            this.setBackground(Color.WHITE);
        }
        else{
            Color Light_Blue = new Color(173,216,230); //rgb for light blue
            this.setBackground(Light_Blue);
        }
    }

      // function to initialize the full name
    private void name_label() {
        myName = new JLabel("<html>Kaustuv<br>Deolal</html>");
        myName.setFont(new Font("TimesRoman",Font.BOLD,14));
        this.add(myName);
    }


    // Clock timer begins. If the initial value of check is even it increments else it decrements by one.
    private void set_timer() {
        clock = new JLabel(String.valueOf(value_of_counter));
        clock.setFont(new Font("TimesRoman",Font.ITALIC,14));
        this.add(clock);

        // listener to start the timer
        ActionListener driver = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(is_even() && value_of_counter == 9) value_of_counter = 0;
                
                else if(!is_even() && value_of_counter == 0) value_of_counter = 9;
                
                else if(is_even() == true) value_of_counter = value_of_counter + 1;
                
                else value_of_counter = value_of_counter -1;
                
                clock.setText(String.valueOf(value_of_counter));
            }
        };
        new Timer(wait, driver).start();
    }

  
  
    // function to set the panel size
    private void set_panel_size() {
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }

    // function of check is the initial variable is even or odd
    private boolean is_even(){
        
            return check % 2 == 0;
        
    }

  /*  public static void main(String [] s) {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new P024_Deolal_Panel(7));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }*/
}
