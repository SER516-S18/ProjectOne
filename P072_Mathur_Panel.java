import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * P072_Mathur_Panel class creates a label with first and and last name displayed in 2 lines
 * The timer displays number from 0-9
 * The background color is set depending on the value of the parameter sent to the constructor
 * @author  Garv Mathur
 * @version 1.0
 */

public class P072_Mathur_Panel extends JPanel {
    private JLabel fullName;
    private JLabel clock;
    private int counterValue;
    private int num;
    public final int WIDTH = 100;
    public final int HEIGHT = 100;
    public final int DELAY = 1000;
    public final Color LIGHT_BLUE = new Color(173,216,230);

    /**
     * @param num
     * if value of num is odd background is set to light blue and counter moves from 9-0.
     * if the value is even background is set to white and the counter moves from 0 to 9.
     */
    public P072_Mathur_Panel(int num){
        try{
            this.num = num;
            setPanelSize();
            initializeAddNameLabel();
            setBackgroundColor();
            setCounterValue();
            setClockTimer();
        }
        catch (Exception e){
            System.out.println("Exception in code: " + e.getMessage());
        }

    }

    /**
     * This function sets the counter Value depending on the parameter being odd or even
     * @param Nothing
     * @return Nothing.
     */
    private void setCounterValue() {
        if(isEven()){
            counterValue = 0;
        }
        else{
            counterValue = 9;
        }
    }

    /**
     * Starts the clock timer
     * If the initial parameter (num) is set as even the value increments.
     * If odd it decrements.
     * @param Nothing
     * @return Nothing.
     */
    private void setClockTimer() {
        clock = new JLabel(String.valueOf(counterValue));
        clock.setFont(new Font("Papyrus",Font.PLAIN,15));
        this.add(clock);
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

    /**
     * Sets Background color of panel. If odd then sets light blue else sets white
     * @param Nothing
     * @return Nothing.
     */
    private void setBackgroundColor() {

        if(isEven()){
            this.setBackground(Color.WHITE);
        }
        else{
            this.setBackground(LIGHT_BLUE);
        }
    }

    /**
     * Initialize and add  Name Label to panel
     * @param Nothing
     * @return Nothing.
     */
    private void initializeAddNameLabel() {
        fullName = new JLabel("<html>Garv<br>Mathur</html>");
        fullName.setFont(new Font("Papyrus",Font.PLAIN,15));
        this.add(fullName);
    }

    /**
     * Set the preferred panel size
     * @param Nothing
     * @return Nothing.
     */
    private void setPanelSize() {
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }

    /**
     * Checks if the initial num value passed in constructor is even or odd
     * @param Nothing
     * @return true/false.
     */
    private boolean isEven(){
        return num % 2 == 0;
    }

}
