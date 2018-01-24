import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*The below code constructs a panel with name and a counter on it. The counter
 * increments if the value passed is even and decrements if the value is odd. */

public class P128_Yadamreddi_Panel extends JPanel
{    
    private static final long serialVersionUID = 1L;
    private JLabel firstLine;
    private JLabel secondLine;
    private JLabel count;
    private static final Color LIGHT_BLUE = new Color(173, 216, 230);
    
    static Thread timerThread;
    public int i;

    /*Panel constructor which initializes name and count on the panel.
     * An integer is passed to this constructor, if the value is even, 
     * the counter increments and if the value is odd, the counter decrements */
    public P128_Yadamreddi_Panel(int counter) 
    {	
    	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(100, 100);
        firstLine = new JLabel("Divya");
        secondLine = new JLabel("Yadamreddi");
        count = new JLabel("");
        firstLine.setFont(new Font("Papyrus", Font.PLAIN, 15));
        secondLine.setFont(new Font("Papyrus", Font.PLAIN, 15));
        count.setFont(new Font("Papyrus", Font.PLAIN, 15));
        firstLine.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        secondLine.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        count.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        
        add(firstLine);
        add(secondLine);
        add(count);

        if ((counter % 2) == 0) 
        {
        	setBackground(Color.WHITE);
        	timerThread = new Thread(() -> {
            	i = 0;
                while(i < 10) 
                {       	
                    count.setText(Integer.toString(i));
                    try 
                    {   	
                        Thread.sleep(1000);
                    } catch (InterruptedException e) 
                    {
                        e.printStackTrace();
                    }
                    i++;
                    if(i == 10)
                    	i = 0;
                }
            });
        } 
        else 
        {
        	setBackground(LIGHT_BLUE);
            timerThread = new Thread(() -> {
               while(i > -1) 
               {
                   count.setText(Integer.toString(i));
                   try 
                   {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) 
                   {
                       e.printStackTrace();
                   }
                   i--;
                   if(i == -1)
                	   i = 9;
               }
            });
        }

        timerThread.start();
    }
}
