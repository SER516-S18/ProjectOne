import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class P108_SubramanianVenkatraman_Panel extends JPanel{  

        
        private JLabel first = new JLabel("Ganesh Kumar");
        private JLabel last = new JLabel("S V");
        private Color color;
        private JLabel counter = new JLabel();

        public P108_SubramanianVenkatraman_Panel(int background) {
            
            // Constructor to set background
            if(background % 2 == 0) {
                color = Color.WHITE;    // When the input is even, white colour will be displayed
                countUpwards();
            }
            
            else {
                color = Color.CYAN;     // When the input is odd, light blue(cyan) colour will be displayed
                countDowndards();
            }
            this.setBackground(color);
            this.setLayout(new GridLayout(3,1));        
            
            Font font = new Font("Papyrus", Font.PLAIN, 14);
            
            first.setFont(font);
            last.setFont(font);
            
            first.setHorizontalAlignment(SwingConstants.CENTER);
            last.setHorizontalAlignment(SwingConstants.CENTER);
            counter.setHorizontalAlignment(SwingConstants.CENTER);
            

            this.setBounds(0, 0, 100, 100);
            this.add(first);
            this.add(last);
            this.add(counter);
            this.setVisible(true);
        }
        
        public void countUpwards() {
            
            //Incrementing counter
            
            new Thread() {
                int count = 0;
                
                public void run() {
                    while(true) {
                        if(count == 10) {
                            count = 0;
                        }
                    
                        counter.setText(new Integer(count).toString());
                        count++;
                    
                        try {
                            Thread.sleep(1000);
                        }catch(Exception e) {}
                    }
                }
            }.start();
        }
        
        public void countDowndards() {
            
            //Decrementing counter.
            
            new Thread() {
                int count = 9;
                
                public void run() {
                    while(true) {
                        if(count == -1) {
                            count = 9;
                        }
                    
                        counter.setText(new Integer(count).toString());
                        count--;
                        
                        try {
                            Thread.sleep(1000);
                        }catch(Exception e) {}
                    }
                }
            }.start();
        }
        
}
