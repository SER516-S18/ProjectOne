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

    private final String nameValue = "<html>Ejaz<br>Saifudeen</html>";
    private JLabel counter;
    private JLabel name;

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
        setPreferredSize(new Dimension(100,100));
        Font font = new Font("Papyrus", 0, 15);

        //Border to separate Name and Counter
        EmptyBorder border = new EmptyBorder(5, 5, 5, 5);

        //Initializing labels and adding them to the panel
        counter = new JLabel();
        counter.setFont(font);
        counter.setBorder(border);
        name = new JLabel(nameValue);
        name.setFont(font);
        name.setBorder(border);
        add(name);
        add(counter);
    }

    /**
     * @param isEven
     */
    private void setBackgroundColor(boolean isEven){
        //Set background color. White if even. Light Blue if odd
        Color bg = isEven? new Color(255,255,255) : new Color(173,216,230);
        setBackground(bg);
    }

    /**
     * @param isEven
     */
    private void startCounter(boolean isEven){

        //Initializing thread that increments or decrements the counter.
        Thread background = new Thread(new Runnable(){
            @Override
            public void run() {

                //Starting value is 0 if even. 9 if odd.
                int counterValue = isEven ? 0 : 9;
                while (true) {
                    counter.setText(Integer.toString(counterValue));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Calculate new counter value by checking if it increments or decrements.
                    counterValue = (isEven ? counterValue + 1 : counterValue + 9) % 10;
                }
            }
        });
        background.start();
    }



    /**
     * Main method to test code
     * @param args
     *
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new P096_Saifudeen_Panel(1), BorderLayout.CENTER);
        frame.getContentPane().add(new P096_Saifudeen_Panel(2), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
    */
}
