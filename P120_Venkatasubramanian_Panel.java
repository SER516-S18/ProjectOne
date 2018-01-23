import java.awt.*; 
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class P120_Venkatasubramanian_Panel extends JPanel {

	public static final String firstname = "Bhavana";
	public static final String lastname = "Venkatasubramanian";
	public PanelType type;
	JLabel counter = new JLabel();

	int result, flag;
	public enum PanelType {
		Incrementor,
		Decrementor,
	};

	public P120_Venkatasubramanian_Panel(int check) {
		
		if(check %2 == 0) {
			type = PanelType.Incrementor;	//Setting pannel type to Incrementor to set background white
			incrementor();	//call to increment the counter value
		}
		
		else {
			type = PanelType.Decrementor;	//Setting pannel type to Decrementor to set background cyan (light blue)
			decrementor();	//call to decrement the counter value
		}
		
		this.setLayout(new GridLayout(3, 1));
		
		if(type == PanelType.Incrementor)
			this.setBackground(Color.white);
		else
			this.setBackground(Color.cyan);
		
		JLabel firstnameLabel = new JLabel(firstname);		//Defining the labels on the panel
		JLabel lastnameLabel = new JLabel(lastname);
		firstnameLabel.setHorizontalAlignment(JLabel.CENTER);
		firstnameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
		this.add(firstnameLabel);				//Adding the labels to the panel
		lastnameLabel.setHorizontalAlignment(JLabel.CENTER);
		lastnameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
		this.add(lastnameLabel);
		counter.setHorizontalAlignment(JLabel.CENTER);
		counter.setFont(new Font("Papyrus", Font.PLAIN, 15));
		this.add(counter);
	}
		public void incrementor() {
		Thread thread = new Thread(new Runnable() {
		    @Override
		    public void run() {
			while (true) {
				if(result == 10)			//Setting the counter to count from 0 to 9
                         		result = 0;
          			counter.setText(new Integer(result).toString())	;
                     		result++;
				try {
					Thread.sleep(1000);		//Waits for one second each time
				} catch (InterruptedException e) {
					System.err.println(e.toString());
					continue;
				}
			}
		    }         
		});
		thread.start();
	}
	
	public void decrementor() {
	Thread thread = new Thread(new Runnable() {
	    @Override
	    public void run() {
		while (true) {
			if(result == -1)				//Setting the counter to count from 9 to 0
                    		result = 9;
          		counter.setText(new Integer(result).toString());
                	result--;
			try {
				Thread.sleep(1000);			//Waits for one second each time
			} catch (InterruptedException e) {
				System.err.println(e.toString());
				continue;
			}
		}
	    }         
	});
	thread.start();
	}
}
