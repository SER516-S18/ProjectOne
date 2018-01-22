import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;  

/**
 * P112_Thakkar_Panel.java - a class to create panel for an application.
 * @author Maitreyi Thakkar
 * @version 1.0
 *
 */


public class P112_Thakkar_Panel extends Thread{  
	JPanel jpanel;
	
	/**
	 * 
	 * @param i The value checks if odd, changes background color to light blue and decreases counter and if the value is even 
	 * changes the background color to white and increases the counter.
	 */
	
	
	public P112_Thakkar_Panel(int i){
			
	    jpanel = new JPanel(new GridBagLayout());                          
	    GridBagConstraints constr = new GridBagConstraints();
		jpanel.setPreferredSize(new Dimension(100,100));                  
		constr.gridx=0;                                                   
		constr.gridy=2;
		
		JLabel label = new JLabel("<html>Maitreyi <br> Thakkar </html>");  
		label.setFont(new Font("Papyrus", Font.PLAIN, 14));                                     
		jpanel.add(label);                                                 
		
		JLabel labelC = new JLabel();                                     
		jpanel.add(labelC);                                                
		labelC.setFont(new Font("Papyrus", Font.PLAIN, 14));               
		jpanel.add(labelC, constr);                                        
		
		if((i%2)==0){	                                                   
			Thread t1= new Thread(){                                       
				public void run(){                                         
					int count = 0;                                         
					while(true){                                           
						labelC.setText(Integer.toString(count));           
						jpanel.setBackground(Color.WHITE);                 
						count++;                                           
		    				if(count == 10){                               
		    						count = 0;
		    					}
		    		try{
		    				Thread.sleep(1000);                            
		    			}
		    		catch(Exception e){
		    				System.out.println(e);
		    			}
		    		}
		    	}
		    };
		  t1.start();                                                      
		}
		else{
			Thread t2= new Thread(){                                      
				public void run(){
					int count = 9;
					while(true){                                           
						labelC.setText(Integer.toString(count));          
						Color lightBlue = new Color(170,200,210);         
						jpanel.setBackground(lightBlue);
						count--;                                          
		    				if(count == -1){                              
		    						count = 9;
		    					}
		    		try{
		    				Thread.sleep(1000);                           
		    			}
		    		catch(Exception e){
		    				System.out.println(e);
		    			}
		    		}
		    	}
		    };
		  t2.start();                                                     
		}
		jpanel.setVisible(true);                                         
		  
		
	}
	
	/**
	 * 
	 * @return object of JPanel.
	 */
	
	public JPanel ReturnObject(){                                        
		P112_Thakkar_Panel h1 = new P112_Thakkar_Panel(115);
		return jpanel;
	}
	

}



  