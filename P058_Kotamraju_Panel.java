import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Koushik Kotamraju
 */
public class P058_Kotamraju_Panel extends JPanel{

    int key; //integer value that will determine the counter and background color
    JLabel counterLabel, nameLabel; //two labels: one for the counter and one for name
    int counter;

    public P058_Kotamraju_Panel(int key) 
    {
        try 
        {
            this.key = key;
            this.setPreferredSize(new Dimension(100,100));
            if(key % 2 == 0)	//if even
            {
                this.setBackground(Color.WHITE);	//changing background color to white
                this.counter = 0;
            }
            else	//if odd
            {
		Color blue1 = new Color(173,216,230); // changing background color to blue
            	this.setBackground(blue1);	
                this.counter = 9;
            }

            nameLabel = new JLabel("<html>Koushik<br>Kotamraju</html>");    //creating name label for first name and last name
            nameLabel.setFont(new Font("Papyrus",Font.BOLD,15));
            this.add(nameLabel);    //adding name to Panel
            
            counterLabel = new JLabel(String.valueOf(counter)); //counterLabel to display counter increasing or decreasing
            counterLabel.setFont(new Font("Papyrus",Font.BOLD,15));
            this.add(counterLabel); //adding counter to Panel
            startCounter(); //starting Counter
            
        }
        catch(Exception e) 
        {
        	e.printStackTrace();
        }
    }
    
    private void startCounter()
    {
        try
        {
            Timer t = new Timer(1000, new ActionListener()  {
	
	            @Override
	
	            public void actionPerformed(ActionEvent event) {	
	                if(key % 2 == 0){
                            if(counter == 9)
                            {
                                counterLabel.setText(Integer.toString(counter));
                                counter = 0; //reset counter
                            }
                            else
                            {
                                counter = counter + 1; //increasing
                            }
	
	                }	
	                else
                        {
                            if(counter == 0)
                            {
                                counterLabel.setText(Integer.toString(counter));
                                counter =9; //reset counter
                            }
                            else
                            {
                                counter = counter -1; //decreasing
                            }
	                }
	                counterLabel.setText(Integer.toString(counter));
	            }
	
	        });
            t.start();  //start timer
        }
        catch(Exception e) 
        {
        	e.printStackTrace();
        }
    }
	
//    public static void main(String[] args) {    
//        JFrame frame = new JFrame();
//     	frame.setContentPane(new P058_Kotamraju_Panel(6));
//     	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     	frame.pack();
//     	frame.setVisible(true);
//    }
    
}
