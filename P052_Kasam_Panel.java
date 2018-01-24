import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.BoxLayout;
/*
Below class contains two Jlabels, one which displays first name &
last name in two different rows and, another JLabel displaying a 
counter which changes automatically (implemented with the use of
threads). Background color is either light blue or white based on
the integer value passed to the constructor. Exception handling is
also included.
@author Vineesha Kasam
*/
public class P052_Kasam_Panel extends JPanel{
	private JLabel myFirstLastName; 
	private JLabel theNumCounter;
	private String evenOrOdd;
	Color lightBlue = new Color(173,216,230);
	//Method to decide EVEN/ODD for the constructor integer received
	public String evenOrOddFunction(int integerValue) {
		if(integerValue%2 == 0)
			evenOrOdd = "EVEN";
		else
			evenOrOdd = "ODD";
		return evenOrOdd;
	}
	//constructor that receives an integer value
	public P052_Kasam_Panel(int intPassed) {
		String evenOrOddString = evenOrOddFunction(intPassed);
		String myName = "<html><br>Vineesha<br>Kasam<br><br><br></html>";
		Font jLabelFont = new Font("Papyrus", Font.PLAIN, 15);
		// JLabels initialized and setting the font
		this.myFirstLastName = new JLabel(myName);
		this.theNumCounter = new JLabel();
		myFirstLastName.setFont(jLabelFont);
		theNumCounter.setFont(jLabelFont);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(100,100));
		this.add(myFirstLastName);
		this.add(theNumCounter);
		// Implementing threads according to the requirements stated and
		// the integer received by the constructor.
		if(evenOrOddString == "EVEN"){
			this.setBackground(Color.white);
			new Thread(){
				int upCounter = 0;
	        	public void run(){
	            	while(true){
	            		if(upCounter == 10)
	            			upCounter = 0;
						theNumCounter.setText(String.valueOf(upCounter));
	                	upCounter++;
	                	try{
	                		Thread.sleep(1000);} 
				catch(Throwable exception){
					exception.printStackTrace();}
	            		}
	        		}
	   		 }.start();
		}
		else{
			this.setBackground(lightBlue);
			new Thread(){
				int downCounter = 9;
	        	public void run() {
	        		while(true) {
	        			if(downCounter == -1)
	            			downCounter = 9;
						theNumCounter.setText(" " + (downCounter));
	                	downCounter--;
	                	try{
	                		Thread.sleep(1000);} 
				catch(Throwable exception){
					exception.printStackTrace();}
	           		}
	        		}
	    		}.start();
		}		
	}
}
