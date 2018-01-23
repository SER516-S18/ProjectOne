import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

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
		int count;

	/**
	 * Panel Constructor
	 * @param int
	 */
	public P095_Rice_Panel(int evenCheck){
		super();
		this.count = 0;
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
		this.nameLabel = new JLabel();
		nameLabel.setText("<html>"
					+ "Jason"
					+ "<br>"
					+ "Rice"
					+ "</html>");
		
		countLabel = new JLabel(String.valueOf(count));
		
		add(nameLabel);
		add(countLabel);
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
		try{
			boolean validate = check % 2 == 0;
			
			if(validate){
				setBackground(Color.WHITE);
			} else{
				setBackground(Color.BLUE.brighter());
			}
			
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
			System.out.println(exception.getMessage());
		}
	}

}
