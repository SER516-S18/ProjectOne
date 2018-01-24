import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Ejaz Saifudeen (esaifude)
 * @date 01/21/2018
 * @description A Panel class for SER516 project.
 *
 * Class Extends JPanel and contains author's name and a Counter. It contains one parameterized constructor
 * that accepts an integer value.
 * Panel background is set to WHITE (255,255,255) if value is even or LIGTH BLUE (173,216,230) if odd.
 * Counter increments from 0-9 if value is even or decrements from 9-0 if odd.
 */
public class P096_Saifudeen_Panel extends JPanel{

    private final String NAME_VALUE = "<html>Ejaz<br>Saifudeen</html>";
    private final int PREFERRED_HEIGHT = 100;
    private final int PREFERRED_WIDTH = 100;
    private final String FONT_TYPE = "Papyrus";
    private final int FONT_STYLE= Font.PLAIN;
    private final int FONT_SIZE = 16;
    private final int SLEEP_TIME = 1000;
    private JLabel counter;
    private JLabel name;
    private enum BgColors{
        WHITE(new Color(255,255,255)), LIGHT_BLUE(new Color(173,216,230));
        private Color color;
        BgColors(Color c){
            color = c;
        }
        public Color getColor(){
            return color;
        }
    }

    private volatile boolean running = true;


    /**
     * Constructor, sets panel properties, labels, background and starts the counter.
     * @param value
     */
    public P096_Saifudeen_Panel(int value){

        //Get if value is even or odd
        boolean isEven = value % 2 == 0;
        setLabelsAndProperties();
        setBackgroundColor(isEven);
        startCounter(isEven);
    }

    private void setLabelsAndProperties(){

        //Setting GridBagLayout helps center the panel contents
        setLayout(new GridBagLayout());

        //Setting size and font as per requirements
        setPreferredSize(new Dimension(PREFERRED_HEIGHT,PREFERRED_WIDTH));
        Font font = new Font(FONT_TYPE, FONT_STYLE, FONT_SIZE);

        //Border to separate Name and Counter
        EmptyBorder border = new EmptyBorder(5, 5, 5, 5);

        //Initializing labels and adding them to the panel
        counter = new JLabel();
        counter.setFont(font);
        counter.setBorder(border);
        name = new JLabel(NAME_VALUE);
        name.setFont(font);
        name.setBorder(border);
        add(name);
        add(counter);
    }

    /**
     * @param isEven
     */
    private void setBackgroundColor(boolean isEven){
        Color bgColor = isEven? BgColors.WHITE.getColor() : BgColors.LIGHT_BLUE.getColor();
        setBackground(bgColor);
    }

    /**
     * @param isEven
     */
    private void startCounter(boolean isEven){

        //Initializing thread that increments or decrements the counter.
        Thread counterThread = new Thread(new Runnable(){
            @Override
            public void run() {

                //Starting value is 0 if even. 9 if odd.
                int counterValue = isEven ? 0 : 9;
                while (running) {
                    counter.setText(Integer.toString(counterValue));
                    try {
                        Thread.sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        counter.setText("Counter thread interrupted.");
                        e.printStackTrace();
                        running = false;
                    }
                    //Calculate new counter value by checking if it increments or decrements.
                    counterValue = (isEven ? counterValue + 1 : counterValue + 9) % 10;
                }
            }
        });
        counterThread.start();
    }
}

