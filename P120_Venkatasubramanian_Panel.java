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
			type = PanelType.Incrementor;
			incrementor();
		}
		
		else {
			type = PanelType.Decrementor;
			decrementor();
		}
		
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
		counter.setHorizontalAlignment(JLabel.CENTER);
		counter.setFont(new Font("Papyrus", Font.BOLD, 16));
		this.add(counter);
	}
		public void incrementor() {
		Thread thread = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    		
		    		//if(P120_Venkatasubramanian_Panel.this.type == PanelType.Incrementor) {
                       
		    		
		    		/*else {
                        if (result == -1)
                            result = 9;
		    			result--;
		    		}*/
		        
				/*JLabel counter = new JLabel(new Integer(result).toString());
				counter.setHorizontalAlignment(JLabel.CENTER);
				counter.setFont(new Font("Papyrus", Font.BOLD, 16));
				P120_Venkatasubramanian_Panel.this.add(counter);*/
				while (true) {

					 if(result == 10)
                         result = 0;
                     
                     counter.setText(new Integer(result).toString())	;
                     result++;
					try {
						Thread.sleep(1000);	
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
	    		
	    		//if(P120_Venkatasubramanian_Panel.this.type == PanelType.Incrementor) {
                    
	    		
	    		/*else {
                    if (result == -1)
                        result = 9;
	    			result--;
	    		}*/
	        
			/*JLabel counter = new JLabel(new Integer(result).toString());
			counter.setHorizontalAlignment(JLabel.CENTER);
			counter.setFont(new Font("Papyrus", Font.BOLD, 16));
			P120_Venkatasubramanian_Panel.this.add(counter);*/
			while (true) {
				
				if(result == -1)
                    result = 9;
                
                counter.setText(new Integer(result).toString());
                result--;
				try {
					Thread.sleep(1000);	
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
