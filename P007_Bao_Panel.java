import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


/**
* This program implements 2 labels which are a name and a timer.
* If an even integer is entered, the timer will increase and background will be WHITE.
* If an odd integer is entered, the timer will decrease and the background will be LIGHTBLUE.
* @author  Zelin Bao
* @version 2.0
* @since   01-22-2018
*/
public class P007_Bao_Panel extends JPanel implements Runnable{
	
	/**
	 * Height and width of panel.
	 * Represent the integer accepted by constructor is either even or odd
	 * Initiate a main panel.
	 * Initiate two label, the name of author and the timer.
	 * isEven Represent the integer accepted by constructor is either even or odd
	 */
	private int height = 100;
	private int width = 100;
	private boolean isEven = false;
	private Thread thread;
	JPanel main = new JPanel(); 
	JLabel name = new JLabel("<html><body>"+"Zelin"+"<br>"+"Bao"+"</html>",JLabel.CENTER);
	JLabel number = new JLabel("testing",JLabel.CENTER);										//create a timer label
	
	/**
	 * @param num   Input integer.
	 * Set the font of words.
	 * Set the size, position and color of labels.
	 * Decide if the input is either even or odd.
	 * Execute a thread.
	 */
	public P007_Bao_Panel(int num) {				
	    number.setFont(new Font("Papyrus", 0, 15));	
		name.setFont(new Font("Papyrus", 0, 15));		
		setSize(height,width);
		setLayout(new BorderLayout());
		add(name, BorderLayout.NORTH);
		add(number,BorderLayout.SOUTH);
		setBackground(new Color(224, 255, 255));
		if(num%2 == 0){
			isEven = true;
			setBackground(Color.WHITE);
		}	
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * @override the run method implementing timer increasing or decreasing
	 * @param isEven Represent the integer accepted by constructor is either even or odd
     * @param i  Value of timer and is added into number label
     * @exception InterruptedException on thread interruption  
     * @return Nothing
	 */
	public void run(){		
		try{	
			if(isEven){
				int i = 0;
				while(i <= 9){
					String iValue = String.valueOf(i);
					number.setText(iValue);
					Thread.sleep(1000);
					i++;
					if(i > 9)	i = 0;	
				 }		
			}
			else{
				int i = 9;
				while(i >= 0){
					String iValue = String.valueOf(i);
					number.setText(iValue);
					Thread.sleep(1000);
					i--;
					if(i < 0)	i = 9;
				}
			}			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
