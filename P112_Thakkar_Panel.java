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

public class P112_Thakkar_Panel extends JPanel implements Runnable {  
	private int pass;
	private JLabel labelC;
	
	/**
	 * 
	 * @param pass The value checks if odd, changes background color to light blue and 
	 * decreases counter and if the value is even changes the background color to 
	 * white and increases the counter.
	 */	
	
	public P112_Thakkar_Panel(int pass){
		super();
		this.pass = pass;    
		this.setLayout(new GridBagLayout());
		GridBagConstraints constr = new GridBagConstraints();
		this.setPreferredSize(new Dimension(100,100));                  
		constr.gridx=0;                                                   
		constr.gridy=2;
		JLabel label = new JLabel("<html>Maitreyi <br> Thakkar </html>");  
		label.setFont(new Font("Papyrus", Font.PLAIN, 15));                                     
		this.add(label);                                                 
		labelC = new JLabel(); 
		labelC.setText("0");                                                                                    
		labelC.setFont(new Font("Papyrus", Font.PLAIN, 15));               
		this.add(labelC, constr);                                        
		this.setVisible(true);
		if((pass%2)==0)	                                                   
						this.setBackground(Color.WHITE);                 
		else{
					    Color lightBlue = new Color(173,216,230);         
						this.setBackground(lightBlue);
			}
		Thread threadCounter = new Thread(this);
		threadCounter.start();
}
	/**
	 * This method runs when a thread starts. If the passed parameter is even,
	 * counter will run from 0 to 9 and otherwise it will run from 9 to 0.
	 */
	@Override
	public void run() {
		if((pass%2)==0){
		int counter = 0;
		while(true){
			labelC.setText(counter+"");
			counter++;
			if(counter == 10){                               
				counter = 0;
				}
			try{
				Thread.sleep(1000);                            
		}
			catch(Exception e){
				e.printStackTrace();;
		}
	}
}
		else{
		int counter = 9;
		while(true){
		labelC.setText(Integer.toString(counter)+"");
			counter--;
			if(counter == -1){                              
				counter = 9;
				}
			try{
				Thread.sleep(1000);                           
		}
			catch(Exception e){
				e.printStackTrace();
		}
	}
		}
	}	
}