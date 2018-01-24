import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* The program implements  a Java Panel that simple displays my full name and a counter
*
* @author  Paulo jaime
* @version 1.0
* @since   2018-01-22 
*/
public class P044_Jaime_Panel extends JPanel
{
	//declaring all the variables used in the class
    private JLabel label_name;
    private JLabel label_number;
    private static int incr = -1;
    private static int decr = 10;

    
    /**
	 * Constructor of the Class
	 * Parameters : Integer value
	 * Counter is increased or decreased based on the parameter 
	 */
    public P044_Jaime_Panel(int value)
    {
        setSize(150,150);
        setLayout(new GridLayout(2, 1));
        label_name = new JLabel("<html>Paulo<br>Jaime</html>", JLabel.CENTER);
        label_number = new JLabel("", JLabel.CENTER);
        label_name.setFont(new Font("Papyrus", Font.BOLD, 16));
        label_number.setFont(new Font("Papyrus", Font.BOLD, 16));
        add(label_name);
        add(label_number);
        counter(value);
    }

    /**
     * Counter is executed from 0 to 9, then starts over again
     * @param value Describes the background and counter mode of the panel.
     */
    public void counter(int value)
    {
        JPanel that = this;
        try {
            Timer t = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (value % 2 == 0) {
                    	    that.setBackground(Color.WHITE);
                        if (incr == 9) {
                        	   incr = -1;
                        }
                        label_number.setText("" + (incr += 1));
                    }
                    else {
                            that.setBackground(new Color(189,214,238));
                    		if (decr == 0){
                        		decr = 10;
                        }
                        label_number.setText("" + (decr += 1));
                    }
                }
            });
            t.start();
        }
        catch (Exception e)
        {
        		System.out.println("Error happened!!!!!" + e);
        }
    }

    //Main Method
    public static void main(String args[])
    {
    	    P044_Jaime_Panel Paulo_Jaime= new P044_Jaime_Panel(0);
        JFrame frame = new JFrame();
        frame.setSize(150, 150);
        frame.setVisible(true);
        frame.add(Paulo_Jaime);
        

    }
}