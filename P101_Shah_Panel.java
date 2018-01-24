import java.awt.*;
import javax.swing.*;

/**
* First Lab for SER 516. Simple panel to be added to the 4th group tab.
* @author Shaunak Shah (Under Professor Gonzalez Sanchez)
* @version 1/21/2018
*class extends JPanel as it functions as a panel and contains some basic 
*functionality define the labels for the panel such that they can be 
*changed and used as per the requirement
*/

public class P101_Shah_Panel extends JPanel implements Runnable{
	
	private JLabel firstName;
	private JLabel lastName;
	private JLabel countNumber;	
	private boolean isEven;
	final Font FONT_STYLE = new Font("Papyrus", Font.PLAIN, 15);	
	final Color LIGHT_BLUE = new Color(173, 216, 230);
	final Color WHITE = new Color(255, 255, 255);
	final String FIRST_NAME = "Shaunak";
	final String LAST_NAME = "Shah";	
	
//Contructor of the panel which accepts an integer based on which the background 
//color and the variant of counter will be decided while adding to the main tab.
//Defining the label for first and last name, as well as the counter.
	
	public P101_Shah_Panel(int value){				
		
		if(value%2 == 0){
			setBackground(WHITE);
			isEven = true;
		}
		else{
			setBackground(LIGHT_BLUE);
			isEven = false;
		}				
		
		createPanel();
		Thread timer = new Thread(this);
		timer.start();		
	}
	
//	Function accepts an integer as flag, checks whether it is even or odd. 
//	If even, the counter label increments from 0 to 9 and then again starts
//	from 0. If found odd, it decrements from 9 to 0 and again goes back to
//	9 and begins the process again.
	
	@Override
	public void run() {
		int currentTime = 0;
		if(isEven)
			currentTime = 9;
		
		while(true){
			if(isEven){
				countNumber.setText(" " +currentTime);
				currentTime++;
				if(currentTime > 9)
					currentTime = 0;
			}
			else{
				countNumber.setText(" " +currentTime);
				currentTime--;
				if(currentTime < 0)
					currentTime = 9;
			}
			try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            	System.out.println(this.getClass().getSimpleName());
                e.printStackTrace();
            }
		}
		
	}
	
//	Function arranges the labels inside a panel. In short where would the
//	text and counter appear inside of a Panel.
	
	private void createPanel(){
		setSize(100,100);
		setLayout(new GridBagLayout());
		firstName = new JLabel(FIRST_NAME);
		firstName.setFont(FONT_STYLE);
		lastName = new JLabel(LAST_NAME);
		lastName.setFont(FONT_STYLE);
		countNumber = new JLabel();
		countNumber.setFont(FONT_STYLE);
		
		GridBagConstraints grid = new GridBagConstraints(); 		
		grid.gridx = 0;
		grid.gridy = 1;
		add(firstName, grid);
		grid.gridy = 2;
		add(lastName, grid);
		grid.gridy = 3;		
		add(countNumber, grid);
	}
}