import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* The program implements  a Java Panel that simple displays my full name and a counter
* @author  Paulo jaime
* @version 1.0
* @since   2018-01-22 
*/
public class P044_Jaime_Panel extends JPanel
{
    private JLabel fullName;
    private JLabel counter;
    private static int autoIncrement = -1;
    private static int autoDencrement = 10;

    /**
    * Constructor of the Class
    * Counter is increased or decreased based on the parameter 
    * @param  Integer value
    */
    public P044_Jaime_Panel(int value)
    {
        setSize(150,150);
        setLayout(new GridLayout(2, 1));
        fullName = new JLabel("<html>Paulo<br>Jaime</html>", JLabel.CENTER);
        add(fullName);
        fullName.setFont(new Font("Papyrus", Font.BOLD, 16));
        counter = new JLabel("", JLabel.CENTER);
        counter.setFont(new Font("Papyrus", Font.BOLD, 16));
        add(counter);
        counter(value);
    }

    /**
    * Counter is executed from 0 to 9, then starts over again
    * @param value Describes the background and counter mode of the panel.
    */
    public void counter(int value)
    {
        try {
            Timer timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                    if (value % 2 == 0) 
                    {
                    	setBackground(Color.WHITE);
                        if (autoIncrement == 9) 
                        {
                            autoIncrement = -1;
                        }
                        counter.setText("" + (autoIncrement += 1));
                    }
                    else {
                    	if (autoDencrement == 0)
                    	{
                    	    autoDencrement = 10;
                    	}
                    	counter.setText("" + (autoDencrement += 1));
                    	setBackground(Color.BLUE);
                    }
                }
            });
            timer.start();
        }
        catch (Exception e)
        {
             System.out.println("Error happened!!!!!" + e);
        }
    }

    public static void main(String args[])
    {
    	P044_Jaime_Panel pauloJaime= new P044_Jaime_Panel(0);
        JFrame frame = new JFrame();
        frame.setSize(150, 150);
        frame.setVisible(true);
        frame.add(pauloJaime);
    }
}
