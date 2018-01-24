import java.awt.*;  
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a panel displaying a name and a counter which increments for even value of integer passed and decrements for the odd integer passed.
 * @author Vivek Faldu
 * @version 1.0
 *
 */

    class P031_Faldu_Panel extends JPanel  {

       private int x = 0;
       private int flag = 0;
        
        /**
    	 * This constructor sets the text, orientation of label and background color of the panel based on the input
    	 * @param input. if input is even then background is White else it is Light Blue.
    	 */
    	        
        public P031_Faldu_Panel(int input) {
        	        	
           	this.setLayout(new GridLayout(3, 1));
           	this.setSize(100,100);
        	Font f =new Font("Papyrus",Font.BOLD,10);
        	
        	JLabel counter = new JLabel("",SwingConstants.CENTER);
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
        	
        	if (input%2 == 0)
        	{
        		x=0;
        		flag=1;
        	}
        	else
        	{
        		x=9;
        		flag=0;
        	}
        	
        	/* 
        	 * Set background color in accordance with the value of flag variable
        	 *  which is set according to the input passed.
        	 *   
        	 */
        	
        	if (flag==1)
        	{
        		this.setBackground(Color.WHITE);
        	}
        	else
        	{
        		this.setBackground(new Color(189,214,238));
        	}
        	
        	/* 
        	 * This is the timer class used for incrementing or decrementing the counter value
        	 * based on the flag value. Exceptions has been handled. 
        	 */
        	try
        	{
        		
        		Timer timer = new Timer(1000, new ActionListener() 
        		{
        			@Override
        			public void actionPerformed(ActionEvent e) 
        			{
                	
        				counter.setText(x+"");
        				if (flag==1)
        				{
        					x ++;
        					if (x > 9) 
        						{
        						x = 0;
        						}	
        				}
        				else
        				{
        					x --;
        					if (x < 0)
        					{
        						x=9;
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
        private static P031_Faldu_Panel instance = null;
        
        
        // static method to create instance of Singleton class
        public static P031_Faldu_Panel getInstance(int a)
        {
            if (instance == null)
                instance = new P031_Faldu_Panel(a);
     
            return instance;
        }
}
    
    
    