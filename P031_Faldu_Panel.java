import java.awt.*;  
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
 * @author Vivek Faldu
 * @version 1.0
 * This class creates a panel displaying a name and a counter which increments for even value of integer passed and decrements
 * for the odd integer passed.
 */

class P031_Faldu_Panel extends JPanel  {

       private int count = 0;
       private int flag = 0;
       private JLabel counter = null;
       private Color lightblue = null;
        
        /**
    	 * This constructor sets the text, orientation of label and background color of the panel based on the input
    	 * @param input. if input is even then background is White else it is Light Blue.
    	 */
    	        
        public P031_Faldu_Panel(int input) {
        	        	
           	this.setLayout(new GridLayout(3, 1));
           	this.setSize(100,100);
        	Font f =new Font("Papyrus",Font.BOLD,15);
        	lightblue = new Color(189,214,238);
        	
        	counter = new JLabel("",SwingConstants.CENTER);
            JLabel lname = new JLabel("Faldu",SwingConstants.CENTER);
            JLabel fname = new JLabel("Vivek",SwingConstants.CENTER);
            
        	fname.setVerticalAlignment(SwingConstants.CENTER);
            fname.setFont(f);
        	this.add(fname);
        		
        
        	lname.setVerticalAlignment(SwingConstants.CENTER);
        	lname.setFont(f);
        	this.add(lname);
        	
        	
        	counter.setVerticalAlignment(SwingConstants.CENTER);
        	counter.setFont(f);
        	this.add(counter);
        	doTask(input);
        	
        	}
        
       public void doTask(int input) {
    	   if (input%2 == 0)   //if the input is even, begin counter with 0 value else begin with 9.
       		{
       			count=0;
       			flag=1;
       		}
       		else
       		{
       			count=9;
       			flag=0;
       		}
       	
       	/* 
       	 * Set background color in accordance with the value of flag variable
       	 *  which is set according to the input passed.
       	 *   
       	 */
       	
       		if (flag==1) //if the input is even 
       		{
       			this.setBackground(Color.WHITE);
       		}
       		else
       		{
       			this.setBackground(lightblue);
       		}
       	
       	/* 
       	 * This is the timer class used for incrementing or decrementing the counter value per second
       	 * based on the flag value. Exceptions has been handled.
       	 */
       	try
       	{
       		
       		Timer timer = new Timer(1000, new ActionListener() 
       		{
       			@Override
       			public void actionPerformed(ActionEvent e) 
       			{
               	
       				counter.setText(count+"");
       				if (flag==1)
       				{
       					count ++;
       					if (count > 9) 
       						{
       						count = 0;
       						}	
       				}
       				else
       				{
       					count --;
       					if (count < 0)
       					{
       						count=9;
       					}
       				}           
       			}
       		});
       		timer.start();
       	}
       	
       	catch(Exception e)
       	{
       		System.out.println("An Error has occured in timer"+e);
       	}
       }
        
} //class ends
    
    
    
