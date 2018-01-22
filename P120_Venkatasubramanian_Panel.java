import java.awt.*; 
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class P120_Venkatasubramanian_Panel extends JPanel {

	public static final String firstname = "Bhavana";
	public static final String lastname = "Venkatasubramanian";
	public final PanelType type;

	int result, flag;
	public enum PanelType {
		Incrementor,
		Decrementor,
	};

	public P120_Venkatasubramanian_Panel(int check) {
		
		if(check %2 == 0)
			type = PanelType.Incrementor;
		
		else
			type = PanelType.Decrementor;
		
		this.setLayout(new GridLayout(3, 1));
		
		if(type == PanelType.Incrementor)
			this.setBackground(Color.white);
		else
			this.setBackground(Color.cyan);
		
		JLabel firstnameLabel = new JLabel(firstname);
		JLabel lastnameLabel = new JLabel(lastname);
		firstnameLabel.setHorizontalAlignment(JLabel.CENTER);
		firstnameLabel.setFont(new Font("Papyrus", Font.PLAIN, 16));
		this.add(firstnameLabel);
		lastnameLabel.setHorizontalAlignment(JLabel.CENTER);
		lastnameLabel.setFont(new Font("Papyrus", Font.PLAIN, 16));
		this.add(lastnameLabel);

		Thread thread = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    		
		    		if(P120_Venkatasubramanian_Panel.this.type == PanelType.Incrementor) {
		    			result = 0;
		    			flag = 1;
		    		}
		    		else {
		    			result = 9;
		    			flag = -1;
		    		}
		        
				JLabel counter = new JLabel(new Integer(result).toString());
				counter.setHorizontalAlignment(JLabel.CENTER);
				counter.setFont(new Font("Papyrus", Font.BOLD, 16));
				P120_Venkatasubramanian_Panel.this.add(counter);
				while (true) {
					
					try {
						Thread.sleep(1000);	
					} catch (InterruptedException e) {
						System.err.println(e.toString());
						continue;
					}
					result = result + flag;
					counter.setText(new Integer(result).toString())	;
				}
		    }         
		});
		thread.start();
	}
}
