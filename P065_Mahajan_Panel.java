import java.awt.*;
import javax.swing.*;

/**
*
* @author aanchalmahajan
*/
public class P065_Mahajan_Panel implements Runnable {  
	JPanel panel;
	JLabel labelName;
	JLabel timeLabel;
	JFrame f;
	Font font;
    static Integer counterD=10;
	static Integer counterI=-1;
	int determineCounter;
	P065_Mahajan_Panel(int val)  
        {  
		timeLabel=new JLabel();
		Thread t = new Thread(this);
		font = new Font("Papyrus", Font.BOLD, 18);
        f= new JFrame();
       
        labelName = new JLabel("<html>Aanchal<br>Mahajan</html>"); //JLabel to display full name in two rows
        labelName.setFont(font);
        panel=new JPanel();  
        panel.setSize(100,100);   
        if(val%2==0) {
        	determineCounter=0;
			panel.setBackground(Color.WHITE);					//setting background color to white
			t.start();
		}
		
		else {
			determineCounter=1;
			panel.setBackground(new Color(173,216,230));  		//setting background color to light blue
			t.start();
		}

        panel.add(labelName);
       
        f.add(panel);  
        
                f.setSize(400,400);    
                f.setLayout(null);    
               f.setVisible(true);    
        } 
	
        public static void main(String args[])  
        {  
        
        	 new P065_Mahajan_Panel(2);
        	
        }

		@Override
		public void run() {
			
			if(determineCounter==0) {
			while(true){
	            try{
	            	
	            	timeLabel.setText(P065_Mahajan_Panel.counterI.toString());  //JLabel to increase counter from 0-9
	            	counterI++;
	                
	                Thread.sleep(1000);
	                if(counterI==10) {
	                	counterI=0;
	            }
	                timeLabel.setFont(font);
	               panel.add(timeLabel); 
	               
	               
	            }catch (InterruptedException iex) {
	            
	                System.out.println("Exception in thread: "+iex.getMessage());
	            }
	        }
	    }
			else {
				while(true){
		            try{
		            	
		            	timeLabel.setText(P065_Mahajan_Panel.counterD.toString());  //JLabel to decrease counter from 9-0
		            	counterD--;
		                
		                Thread.sleep(1000);
		                if(counterD==-1) {
		                	counterD=9;
		            }
		                timeLabel.setFont(font);
		               panel.add(timeLabel);
		               
		            }catch (InterruptedException iex) {
		            
		                System.out.println("Exception in thread: "+iex.getMessage());
		            }
		        }	
			}
		}	
		public JPanel returnPanel() {
			return panel;
		}
		}  
        
        
        
        

        
    