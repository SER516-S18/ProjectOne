/*
 * P065_Mahajan_Panel
 * @author: aanchalmahajan
 * @version: 4.0
 * @since: 01/23/2018
 * 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * The P065_Mahajan_Panel class adds two labels labelFullName and
 * timeLabel. Background color of JPanel is white if the value passed
 * by the calling class is even, else it is light blue.
 * There is a timer which runs infinitely incrementing at intervals 
 * of one second. The counter increases in the range of 0-9 if the 
 * value passed by calling class is even else the counter decreases 
 * in the range of 0-9
 *  
 */

public class P065_Mahajan_Panel extends JPanel implements Runnable  {  
   	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel labelFullName;				//Label for FullName
	JLabel timeLabel;				    //Label for Counter
	Font fontName;
	int determineCounter;			    /*Variable for to determine
	 									which counter to implement*/
	GridBagConstraints c;	
	/**
	 * The constructor receives a value from the calling class 
	 * and sets the background color accordingly along with 
	 * starting the thread for the respective timer
	 * It declares and defines the light blue color
	 * It defines the font as Papyrus, plain style and size 15
	 * It sets the size and layout for the panel
	 * Adds the labelFullName to the panel
	 */
	P065_Mahajan_Panel(int val)  {  
		Color lightBlue= new Color(173,216,230); /*Creating light 
										blue color with RGB values*/ 
		Thread t = new Thread(this);
		c = new GridBagConstraints();
		setLayout(new GridBagLayout());  
		setSize(100,100);
		fontName = new Font("Papyrus", Font.PLAIN, 15);
		timeLabel=new JLabel();
        labelFullName = new JLabel("<html>Aanchal<br>"
        		+ "Mahajan</html>");		/* Setting the value of 
        										labelFullName*/ 
        labelFullName.setFont(fontName);
        c.gridx=0;                                                   
		c.gridy=2;
		/**
    	 * Checking if value passed by calling function is odd
    	 * or even
    	 */   
        if(val%2==0) {
            determineCounter=0;
			setBackground(Color.WHITE);		/*Setting Background 
												color to white*/			
			t.start();
		}
		else {
			determineCounter=1;
			setBackground(lightBlue);		/*Setting Background 
			  								color to light blue*/
			t.start();
		}

       add(labelFullName);		   //Adding labelFullName to panel 
       setVisible(true);
   }
	/**
	 * It declares and defines variables counterI and counterD
	 * which increases or decreases respectively according 
	 * to the value passed by calling function.
	 * It adds the timeLabel to the panel
	 */
   	@Override
	public void run() {
	    Integer counterD=10; 	//For increasing counter
		Integer counterI=-1;	//For decreasing counter
			
		if(determineCounter==0) {
		    while(true){
	            try{	
	               	timeLabel.setText(counterI.toString()); /*setting
	               	  			the timeLabel with counter value*/
	            	counterI++; 	//incrementing the counter   
	                Thread.sleep(1000);
	                /**
	            	 * Resetting the counter to initial value
	            	 */
	                if(counterI==10) {
	                   	counterI=0;
	                }
	                timeLabel.setFont(fontName);
	                add(timeLabel,c);   //adding timeLabel to panel
	               
	           }catch (InterruptedException iex) { 
	                System.out.println("Exception in thread: "+iex.getMessage());
	            }
	        }
	    }
	    else {
		    while(true) {
		        try{
		            timeLabel.setText(counterD.toString()); /*setting
       	  			the timeLabel with counter value*/
		            counterD--;    //Decrementing the counter
		            Thread.sleep(1000);
		            /**
	            	 * Resetting the counter to initial value
	            	 */
		            if(counterD==-1) {
		                counterD=9;
		            }
		            timeLabel.setFont(fontName);	
		            add(timeLabel,c);	//adding timeLabel to panel
		               
		        }catch (InterruptedException iex) {
		            System.out.println("Exception in thread: "+iex.getMessage());
		      }  
		    }	
		}
	}	
}  