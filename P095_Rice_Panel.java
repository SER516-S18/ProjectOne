import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Extended JPanel class that takes in an int and displays two labels.
 * The first label is my first and last name. 
 * If event it will have a white background and count up from 0-9.
 * If odd it will have a light blue background and count down from 9-0.
 */

/**
 * SER516 ProjectOne Panel Class
 * @author Jason Rice
 * @category Class
 * @version 1.0
 */
public class P095_Rice_Panel extends JPanel{
	private
		JLabel nameLabel;
		JLabel countLabel;
		Color lightblue;
		int count;

	/**
	 * Panel Constructor
	 * @param int
	 */
	public P095_Rice_Panel(int evenCheck){
		super();
		this.count = 0;
		this.lightblue = new Color(173, 216, 230);
		init();
		evenCheck(evenCheck);
		setVisible(true);
	}
	
	/**
	 * init method
	 * @category Method
	 * @return void
	 * Creates the labels and adds them to the Panel.
	 */
	private void init(){
		Font font = new Font("Papyrus", Font.PLAIN, 16);
		
		this.nameLabel = new JLabel();
		this.nameLabel.setText("<html>"
					+ "Jason"
					+ "<br>"
					+ "Rice"
					+ "</html>");
		
		this.countLabel = new JLabel(String.valueOf(count));
		
		this.nameLabel.setFont(font);
		this.countLabel.setFont(font);
		
		add(this.nameLabel);
		add(this.countLabel);
	}

	/**
	 * evenCheck method
	 * @category Method
	 * @param int
	 * @return void
	 * Checks the input for an even number. 
	 * If so creates a Timer to increment the count value.
	 */
	private void evenCheck(int check){
		boolean validate = check % 2 == 0;
		
		if(validate){
			setBackground(Color.WHITE);
		} else{
			setBackground(this.lightblue);
		}
		
		try{
			ActionListener actionListner = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e){
					if(validate){
						if(count < 9){
							count++;
						} else{
							count = 0;
						}
					} else{
						if(count > 0){
							count--;
						} else{
							count = 9;
						}
					}
					countLabel.setText(String.valueOf(count));
				}
			};
			new Timer(1000, actionListner).start();
			
		} catch(Exception exception){
			System.out.println( "P095_Rice_Panel Exception in evenCheck(): "
					+ exception.getMessage());
		}
	}

}
