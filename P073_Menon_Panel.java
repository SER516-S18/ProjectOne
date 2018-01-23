import javax.swing.*;
import java.awt.*;

/******************************************************************************************************************
# Name of Class		:	P073_Menon_Panel.java
#
# Description		:	This program creates a JPanel with 2 Jlabels. First Jlabel is for the full name.
#						Second Jlabel is a timer which increases from 0 to 9 for Even numbers, vice versa for Odd.
#						If the constructor receives an Even or 0, background is White and the counter increases.
#						Else, background is light Blue and the counter decreases.
#
# Subject			:   SER-516
#
# Project Number	:   1
#
# Due Date			:   23 Jan 2018
#
# Created By		:	Vimal Menon
#
# Created On		:   20 Jan 2018
#
# Version			:	1.1
#
# IDE / OS			:   Eclipse Neon 3 / Windows 10 (64 bit)
#******************************************************************************************************************/

public class P073_Menon_Panel extends JPanel {
	
	private JLabel fullName;
	private JLabel timerDisplay;
	
	public static final String firstName = "Vimal";
	public static final String lastName = "Menon";
    public static final String htmlOpenTag = "<html>";
    public static final String htmlCloseTag = "</html>";
    public static final String htmlBreakTag = "<br>";
	public static final String FONTTYPE = "Papyrus";
	
	Color lightBlue = new Color(173, 216, 230);
	Color black = Color.BLACK;
	Color white = Color.WHITE;
	
	public static final int FONTSIZE = 15;
	public static final int TIMEGAP = 1000;
	public static final int LENGTH = 100;
	public static final int BREADTH = 100;
	public static final int ROWSINPANEL = 2;
	public static final int COLUMNSINPANEL = 1;
	public static final int TIMERSTARTVALUE = 0;
	public static final int TIMERENDVALUE = 9;
    private int timerCounter = 0;
    private int numReceived = 0;
      
    public P073_Menon_Panel(int numPassed){
        
    	super(new GridLayout(ROWSINPANEL,COLUMNSINPANEL));
    	
    	numReceived = numPassed;
    	if (numReceived < 0)
    		numReceived = numReceived * (-1);
    	
    	if (numReceived % 2 == 0 || numReceived == 0)
    		timerCounter = TIMERSTARTVALUE;
        else
        	timerCounter = TIMERENDVALUE;
    	
        setPreferredSize(new Dimension(LENGTH, BREADTH));
        
        if (numReceived % 2 == 0)
            setBackground(white);
        else
            setBackground(lightBlue);	
        
        fullName = new JLabel(htmlOpenTag + firstName + htmlBreakTag + lastName + htmlCloseTag, JLabel.CENTER);
        fullName.setFont(new Font(FONTTYPE, Font.PLAIN, FONTSIZE));
        fullName.setForeground(black);
        add(fullName);
        
    	timerDisplay = new JLabel(String.valueOf(timerCounter), JLabel.CENTER);
    	timerDisplay.setFont(new Font(FONTTYPE, Font.PLAIN, FONTSIZE));
    	timerDisplay.setForeground(black);
        add(timerDisplay);
        timerMechanism();
    }
    
    /*****************************************************************************************************
	# Function / Method      		:	timerMechanism
	#
	# Description					:	A Timer which increases from 0 to 9 for Even values and decreases
	#									from 9 to 0 for Odd values passed.
	#
	# Parameters passed				:	none
	#
	# Returns						:	(nothing)
	#*****************************************************************************************************/
    
    private void timerMechanism() {
    	Thread timerThread = new Thread (new Runnable() {
    		public void run() {
    			while (timerCounter >= 0) {
    				int internalCounter = timerCounter;
	    			if (internalCounter == TIMERSTARTVALUE) {
	    				for(internalCounter = 0; internalCounter < 10; internalCounter++) {
	    					timerDisplay.setText(String.valueOf(internalCounter));
			        	    try {
			        	        Thread.sleep(TIMEGAP);
			        	    } 
			        	    catch (InterruptedException ie) {
			        	    	System.out.println("Exception in code: " + ie.getMessage());
			        	    }
			        	}
	    			} 
	    			else {
			    		for(internalCounter = TIMERENDVALUE; internalCounter > -1; internalCounter--) {
			        	    timerDisplay.setText(String.valueOf(internalCounter));
			        	    try {
			        	        Thread.sleep(TIMEGAP);
			        	    }
			        	    catch (InterruptedException ie) {
			        	    	System.out.println("Exception in code: " + ie.getMessage());
			        	    }
			        	}
			    	}
    			}
    		}
    	});
    	timerThread.start();
    }
    
    // Main - for testing purposes
//    public static void main(String [] s) {
//        JFrame jFrame = new JFrame();
//        jFrame.setContentPane(new P073_Menon_Panel(-1067));
//        jFrame.pack();
//        jFrame.setVisible(true);
//    }
}
