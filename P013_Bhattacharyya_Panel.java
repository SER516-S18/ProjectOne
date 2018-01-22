import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;
import java.awt.Color;

public class P013_Bhattacharyya_Panel{
	
   /*This class is used to create a Panel of size 100X100 which contains three labels Firstname, Lastname
    *and number. This number increments from 0-9 if the value passed to the class is even and decrements 
	*from 9-0 if the value passed is odd.
	*/
	
   private JLabel firstname;
   private JLabel lastname;
   private JLabel number;
   private JPanel myPanel;
   private int flag;
   
   // This is the constructor which receives an integer value.
   public P013_Bhattacharyya_Panel(int value){
	  if(value%2 == 0)
		  flag = 0; //set flag to 0 if value is even
	  else
		  flag = 1; //set flag to 1 if value is odd
   }
    
   // This method creates the Panel and returns a panel object.	
   public JPanel P013_Bhattacharyya_Panel(){
	   
	  // Creation of JLabel 
	  
      firstname = new JLabel("Debarati", JLabel.CENTER);   
      firstname.setFont(new Font("Papyrus", Font.PLAIN, 14));	  
      lastname = new JLabel("Bhattacharyya",JLabel.CENTER);  
      lastname.setFont(new Font("Papyrus", Font.PLAIN, 14));
      number = new JLabel();
	  number.setFont(new Font("Papyrus", Font.PLAIN, 14));
	  firstname.setAlignmentX(Component.CENTER_ALIGNMENT);
	  lastname.setAlignmentX(Component.CENTER_ALIGNMENT);
	  number.setAlignmentX(Component.CENTER_ALIGNMENT);
	  
	  // Creation of JPanel
	  
	  myPanel = new JPanel();  
	  myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
	  myPanel.setSize(100, 100);
	  
	  if (flag == 0)
		  myPanel.setBackground(Color.white);
	  else
		  myPanel.setBackground(new Color(187, 255, 255));
      
	  // Adding components to the panel
	  
	  myPanel.add(firstname);
	  myPanel.add(lastname);
	  myPanel.add(number);
	  myPanel.setVisible(true);
	  
	  // Timer increment and decrement
	  TimerFunc();

	  return myPanel;  
   }
	
    public void TimerFunc(){
		if(flag == 0){  // if value is even timer increments from 0-9
			Thread t = new Thread() {
				int val=0;
			    public void run(){
				    while(true){
	            		   if(val==10)
	            			  val=0;	
	                    number.setText(" " + (val++));
	                    try{
	                       Thread.sleep(1000);
	                    } catch(Exception e) {}
	                }
			    }
	        };
			t.start();
	    }
		else {         // if value is odd timer decrements from 9-0
			Thread t = new Thread() {
				int val=9;
			    public void run(){
				    while(true){
	            		   if(val==-1)
	            			  val=9;	
	                    number.setText(" " + (val--));
	                    try{
	                       Thread.sleep(1000);
	                    } catch(Exception e) {}
	                }
			    }
	        };
			t.start();
		}
	}
		
	/*This code is for testing purpose			
    public static void main(String[] args){
	   
	   P013_Bhattacharyya_Panel obj = new P013_Bhattacharyya_Panel(2);
	   JPanel panel_obj = obj.P013_Bhattacharyya_Panel();
	   JFrame frame_obj = new JFrame();
	   frame_obj.add(panel_obj);
	   frame_obj.setLayout(new FlowLayout(FlowLayout.CENTER, 0,90));
	   frame_obj.setSize(800, 800);
	   frame_obj.setVisible(true);
	   
	   frame_obj.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
       });		 
   }*/

}

   
