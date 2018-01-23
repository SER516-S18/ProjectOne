import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;



/* This class creates a panel that has two labels in it. description about labels is
 *  given in detail near method implementation. This class contains a parameterized constructor
 * and a method createPanel.  
 *
 * @author: Sai Saran Kandimalla
 * 
 * @version 1. created on 01/20/2018.
 */
public class P049_Kandimalla_Panel extends JPanel {

/**
	 * 
	 */
	Timer counterTimer;
	private static final long serialVersionUID = 1L;
private int code;
private JPanel mainPanel; 
/*
 * A parameterized constructor that takes an integer value when the object is instantiated. The 
 * constructor then passes the integer value to 'panelCreate' method.  
 */
public P049_Kandimalla_Panel(int code) {
	super();
	this.code = code;
	
	mainPanel = panelCreate(code); //This function call creates the panel as per specified requirements and assigns to mainPanel
	this.mainPanel = mainPanel;
}


//This method is created to access the 
public JPanel getMainPanel() {
	return mainPanel;
}

/* This method creates a panel that has two labels in it. One label displays my FirstName 
 * and LastName in different rows. The other panel keeps counting from 0 to 9 if code value
 * is even or vice versa if code value is odd. The function also sets background color depending
 * upon code value  
 * 
 */
@SuppressWarnings("finally")
public JPanel panelCreate(int code) { 

	
	Border border;
	Box box;
	JPanel panel = new JPanel(new GridLayout(2,1));;
	JLabel name,counter;
	try
	{
	
    border = BorderFactory.createLineBorder(Color.BLACK,1);
    box = Box.createVerticalBox();
    //panel.setSize(100, 100);
    //panel.setBorder(border);
    
    name = new JLabel ("<html><p>&nbsp;&nbsp;&nbsp;Sai Saran&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;Kandimalla&nbsp;&nbsp;&nbsp;</p></html>",JLabel.CENTER); 
    box.add(name);
    name.setFont(new Font("papyrus",Font.BOLD,16));
    counter = new JLabel();
    counter.setLayout(new GridLayout());
    counter.setFont(new Font("papyrus",Font.BOLD,16));
    box.add(counter);
    
    panel.add(box);
    
    if(code%2==0)
 {
    	
    	counterTimer = new Timer(1000, new ActionListener(){
    		private int count = 0;  
    		public void actionPerformed(ActionEvent event){
    			counter.setText("             "+count+++"             ");
    			if (count == 10)
    			{
    				  
    				counterTimer.stop();
                    count = 0;
    				counterTimer.restart();      			
    			}    		  
    			}
    		});
    	counterTimer.start();
    	panel.setBackground(Color.WHITE);
    	 
    		
    	
 }  
    	
 
   
    else if( code%2==1 || code%2 == -1)
{
    	
    	counterTimer = new Timer(1000, new ActionListener(){
    		private int count = 9;  
    		public void actionPerformed(ActionEvent event){
    			counter.setText("             "+count--+"             ");
    			if (count == -1)
    			{
    				  
    				counterTimer.stop();
                    count = 9;
    				counterTimer.restart();      			
    			}    		  
    			}
    		});
    	counterTimer.start();
    	Color lightBlue = new Color(173,216,230);
    	panel.setBackground(lightBlue);
}
    
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
finally {
	
	add(panel);
	return panel;
}




}

/*main method is for testing purpose only. My panel can be added by explicitly calling an object of my class in "JFrame.add(arg
)" method.
*/
public static void main(String[] args) {
	
	
JFrame frame = new JFrame("Panel_49");
frame.setSize(300, 300);
frame.setLayout(new GridLayout(2,2));

//JPanel testPanel = ssk.getMainPanel();
frame.add(new P049_Kandimalla_Panel(49));
frame.setVisible(true);
}

}

