import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * @author  Rachana Kashyap
 * @version 1.0
 * @since   01-23-2018
 * The class P053_Kashyap_Panel creates a JPanel with 2 JLabels.
 * The first JLabel contains my name (first name and last name) in
 * two different rows. The second JLabel contains a counter Value. 
 * If the obtained parameter is even, the counter runs from 0 to 9 every 
 * second and has a white background color. If it is odd, it runs from 9 to 0 
 * every second and has a lightBlue background color.
 */

public class P053_Kashyap_Panel extends JPanel{ 
	
    public final Color LIGHT_BLUE = new Color(173, 216, 230);
    public final Font FONT = new Font("Papyrus", Font.PLAIN, 15);
    private final JLabel name = new JLabel("<html>Rachana<br/>Kashyap<br/></html>");
    private JLabel timer = new JLabel();
    private final boolean isEven;


    /* Constructor for the class */
    public P053_Kashyap_Panel(int param) {
        /* if param is even, set boolean isEven to true, else set it to false */
        if(param % 2 == 0){
            isEven = true;
        }    
        else{
            isEven = false;
        }   
        
        /* If Parameter is even, set background color to White, else lightBlue*/
        if(isEven == true){
            setBackground(Color.white);
        }
        else{
            setBackground(LIGHT_BLUE);
        }
        
        /* Set font, alignment, layout and position of the name */
        name.setFont(FONT);
        name.setBounds(0,0,100,90);
        name.setHorizontalAlignment(JLabel.CENTER);
        
        /* Set font, alignment, layout and position of the timer */
        timer.setBounds(0,50,100,90);
        timer.setFont(FONT);
        timer.setHorizontalAlignment(JLabel.CENTER);
        
        /* Add the JLabels - name and timer to the panel */
        add(name);
        add(timer);
        
        /* Set layout to null, size of Panel to 100x100 and make it visible */
        setLayout(null);
        setSize(100,100);
        setVisible(true);
        
        /* If param is even, increment countValue from 0 to 10 every second */
        if (isEven == true){
            new Thread(){
                int countValue = 0;
                public void run() {
                    while(true) {
                        /* if countValue reaches 10, reset it to zero */
                        if(countValue == 10){
                            countValue = 0;
                        }
                        timer.setText(" " +countValue++);
                        try{
                            Thread.sleep(1000);
                        } 
                        catch(Exception e){
                        }
                    }
                }
            }.start();
        }
        /* If param is odd, decrement countValue from 9 to 0 every second */
        else{
            new Thread() {
                int countValue = 9;
                public void run() {
                    while(true) {
                        /* if countValue reaches -1, reset it to 9 */
                        if(countValue == -1){
                            countValue = 9;
                        }
                        timer.setText(" " +countValue--);
                        try{
                            Thread.sleep(1000);
                        } 
                        catch(Exception e){
                        }
                    }
                }
            }.start();
        }
    }
}
