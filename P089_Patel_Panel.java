import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

/**
 * P089_Patel_Panel.java - a class to implement Panel.
 * @author  Meet Patel
 * @version 1.0
 */
public class P089_Patel_Panel{
    int counter;
    Timer timer;
    JPanel newPanel = new JPanel(new GridBagLayout());
    JLabel nameLabel = new JLabel("<html>Meet<br>Patel</html>");
    JLabel timerLabel = new JLabel();
    /**
     *
     * @param num - To change the Backgroud of the panel, if ODD, changes to lightblue else to White
     */
    public P089_Patel_Panel(int num) { 
        GridBagConstraints constraints = new GridBagConstraints(); 
        GridBagConstraints constraints1 = new GridBagConstraints();
        newPanel.setPreferredSize(new Dimension(100, 100));
        constraints.gridx = 0;
        constraints.gridy = 0; 
        constraints1.gridx = 0; 
        constraints1.gridy = 2; 
        nameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15)); 
        timerLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
        newPanel.add(nameLabel, constraints);
        newPanel.add(timerLabel, constraints1);
        if(num % 2 != 0){
            Color lightblue = new Color(173,216,230); 
            newPanel.setBackground(lightblue);
            counter = 9;
            Thread t = new Thread(){
                public void run(){
                    timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            timerLabel.setText(Integer.toString(counter));
                            counter--;
                            if (counter == -1) {
                                counter = 9;
                            }
                            try{
                            }
                            catch(Exception a){
                                System.out.println(a);
                            }
                        }
                    });
                    timer.setInitialDelay(0);
                    timer.start(); 
                }
            };
            t.start();
        }
        else{
            newPanel.setBackground(Color.WHITE);
            counter = 0;
            Thread t = new Thread(){
                public void run(){
                    timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            timerLabel.setText(Integer.toString(counter)); 
                            counter++;
                            if(counter == 10){
                                counter = 0;
                            }
                            try{
                            }
                            catch(Exception a){ 
                                System.out.println(a);
                            }
                        }
                    });
                    timer.setInitialDelay(0);
                    timer.start();
                }
            };
            t.start();
        }
    }
    /**
     *
     * @return - Returns the object of the Panel
     */
    public JPanel Ret_Panel_Object(){
        return newPanel;
    }
}
