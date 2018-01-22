/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P058_Kotamraju_Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author koush
 */
public class P058_Kotamraju_Panel extends JPanel{

    private int key; //integer value that will determine the counter and background color
    private JLabel counterLabel, nameLabel; //two labels: one for the counter and one for name
    private int counter;

    public P058_Kotamraju_Panel(int key) 
    {
        try 
        {
            this.key = key;
            this.setPreferredSize(new Dimension(100,100));
            if(key % 2 == 0)
            {
                this.setBackground(Color.WHITE);
                this.counter = 0;
            }
            else
            {
                this.setBackground(Color.CYAN);
                this.counter = 9;
            }

            nameLabel = new JLabel("<html>Koushik<br>Kotamraju</html>");    //creating name label for first name and last name
            nameLabel.setFont(new Font("Papyrus",Font.BOLD,15));
            this.add(nameLabel);
            
            counterLabel = new JLabel(String.valueOf(counter)); //counterLabel to display counter increasing or decreasing
            counterLabel.setFont(new Font("Papyrus",Font.BOLD,15));
            this.add(counterLabel);
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
	
	                    counter = counter + 1; //increasing
                            if(counter == 9)
                            {
                                counter =0; //reset counter
                            }
	
	                }	
	                else
                        {
	                    counter = counter -1; //decreasing
                            if(counter == 0)
                            {
                                counter =9; //reset counter
                            }
	                }
	                counterLabel.setText(Integer.toString(counter));
	            }
	
	        });
            t.setRepeats(true);
            t.start();
	
	        
        }
        catch(Exception e) 
        {
        	e.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
//     public static void main(String[] args) {
        
//         JFrame frame = new JFrame();
//     	frame.setContentPane(new P058_Kotamraju_Panel(6));
//     	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     	frame.pack();
//     	frame.setVisible(true);
//     }
    
}
