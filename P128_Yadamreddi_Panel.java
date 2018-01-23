import javax.swing.*;
import java.awt.*;
/*Panel consisting first and last name and a counter incrementing or decrementing from 0 to 9 or
 * 9 to 0 based on a argument passed to it. */
public class P128_Yadamreddi_Panel {
    
    static JPanel panel;
    JLabel firstLine;
    JLabel secondLine;
    JLabel count;
    
    static Thread timerThread;
    int i;

    //Panel constructor which initializes name and count on the panel.
    public P128_Yadamreddi_Panel(int counter) {
    	
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(100, 100);
        firstLine = new JLabel("Divya", JLabel.CENTER);
        secondLine = new JLabel("Yadamreddi", JLabel.CENTER);
        firstLine.setFont(new Font("Papyrus", Font.BOLD, 12));
        secondLine.setFont(new Font("Papyrus", Font.BOLD, 12));
        count = new JLabel("", JLabel.CENTER);
        count.setFont(new Font("Papyrus", Font.BOLD, 12));
        
        panel.add(firstLine);
        panel.add(secondLine);
        panel.add(count);

        if ((counter % 2) == 0) {
            panel.setBackground(Color.WHITE);
        } else {
            panel.setBackground(Color.CYAN);
        }
    }

    // Thread used to increment and decrement the count in label
    public JPanel constructPanel(int counter) {
    //	timerThread = new Thread();
        if ((counter % 2) == 0) {
            timerThread = new Thread(() -> {
            	i = 0;
                while(i < 10) {
                    count.setText(Integer.toString(i));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    if(i == 10)
                    	i = 0;
                }
            });
        } else {
            timerThread = new Thread(() -> {
               while(i > -1) {
                   count.setText(Integer.toString(i));
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   i--;
                   if(i == -1)
                	   i = 9;
               }
            });
        }

        timerThread.start();
        return panel;
    }

    public static void main(String[] args) {
    	
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        
        P128_Yadamreddi_Panel panel = new P128_Yadamreddi_Panel(11);
        JPanel constructPanel = panel.constructPanel(11);
        frame.add(constructPanel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}