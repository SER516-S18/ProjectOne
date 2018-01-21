import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P072_Mathur_Panel extends JPanel {
    private JLabel fullName;
    private JLabel clock;
    private int counterValue;
    private int num;
    public final int WIDTH = 100;
    public final int HEIGHT = 100;
    public final int DELAY = 1000;

    // Constructor
    public P072_Mathur_Panel(int num){
        this.num = num;
        setPanelSize();
        initializeAddNameLabel();
        setBackgroundColor();
        setCounterValue();
        setClockTimer();
    }

    // Sets the Counter Value depending on the parameter being odd or even
    private void setCounterValue() {
        if(isEven()){
            counterValue = 0;
        }
        else{
            counterValue = 9;
        }
    }

    // Starts the clock timer. If the initial parameter is set as even the value increments. If odd it decrements.
    private void setClockTimer() {
        clock = new JLabel(String.valueOf(counterValue));
        clock.setFont(new Font("Papyrus",Font.BOLD,16));
        this.add(clock);

        // Starts the timer
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEven() && counterValue == 9){
                    counterValue = 0;
                }
                else if(!isEven() && counterValue == 0){
                    counterValue = 9;
                }
                else if(isEven() == true){
                    counterValue = counterValue + 1;
                }
                else{
                    counterValue = counterValue -1;
                }
                clock.setText(String.valueOf(counterValue));
            }
        };
        new Timer(DELAY, taskPerformer).start();
    }

    // Sets Background color of panel. If odd then sets light blue else sets White.
    private void setBackgroundColor() {

        if(isEven()){
            this.setBackground(Color.WHITE);
        }
        else{
            Color lightBlue = new Color(173,216,230);
            this.setBackground(lightBlue);
        }
    }
    // Initialize and Add  Name Label to panel
    private void initializeAddNameLabel() {
        fullName = new JLabel("<html>Garv<br>Mathur</html>");
        fullName.setFont(new Font("Papyrus",Font.BOLD,16));
        this.add(fullName);
    }

    // Set the preferred panel size
    private void setPanelSize() {
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }

    // Checks if the initial configuration int value is even or odd
    private boolean isEven(){
        return num % 2 == 0;
    }

//    public static void main(String [] s) {
//        JFrame jFrame = new JFrame();
//        jFrame.setContentPane(new P072_Mathur_Panel(4));
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.pack();
//        jFrame.setVisible(true);
//    }
}
