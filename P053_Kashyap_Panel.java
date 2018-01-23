/*
Author: Rachana Kashyap
*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;


public class P053_Kashyap_Panel {
    private JPanel panel;
    private JLabel timer;
    private boolean isEven;

    /* Function that creates a JPanel with JLables - name and timer */
    public JPanel P053_Kashyap_Panel() {
        panel = new JPanel();
        panel.setSize(100, 100);
        panel.setLayout(null);
        JLabel name;
        name = new JLabel("title",JLabel.CENTER);
        name.setBounds(0,0,100,90);

        /*first name,last name in 2 rows*/
        name.setText("<html><body>Rachana<br/>Kashyap<br/></body></html>");
        name.setFont(new Font("Papyrus", Font.PLAIN, 15));
        name.setLayout(null);
        panel.add(name);

        Color lightBlue = new Color(173, 216, 230);

        /* check if isEven is true and set Background color accordingly */
        if(isEven==false)
            panel.setBackground(lightBlue);/*Light blue color*/
        else
            panel.setBackground(Color.white);
        /* create a JLabel for timer */
        timer = new JLabel("0", JLabel.CENTER);
        timer.setBounds(0,30,100,90);
        timer.setFont(new Font("Papyrus", Font.PLAIN, 15));
        timer.setLayout(null);
        panel.add(timer);

        /*If even, increment counter from 0*/
        if(isEven==true){
            new Thread() {
                int counter = 0;
                public void run() {
                    while(true) {
                        if(counter==10)counter=0;
                        timer.setText(" " +counter++);
                        try{
                            Thread.sleep(1000);
                        }
                        catch(Exception e) {}
                    }
                }
            }.start();
        }
        /* If odd, decrement counter from 9 */
        else{
            new Thread() {
                int counter = 9;
                public void run() {
                    while(true) {
                        if(counter==-1)counter=9;
                        timer.setText(" " +counter--);
                        try{
                            Thread.sleep(1000);
                        }
                        catch(Exception e) {}
                    }
                }
            }.start();
        }
        return panel;
    }

    /*Constructor*/
    public P053_Kashyap_Panel(int val) {
        /* if val is even, set boolean isEven to true */
        if (val % 2 == 0){
            isEven=true;
            val = 0;
        }
        /* Else set it to false */
        else{
            isEven=false;
            val = 9;
        }
    }
    /* Main function */
    /*
    public static void main(String[] args) {
        P053_Kashyap_Panel myPanel = new P053_Kashyap_Panel(5);
        JPanel panel = myPanel.P053_Kashyap_Panel();
        JFrame myFrame = new JFrame("");
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(100, 150);
        myFrame.add(panel);
    }
    */

}
