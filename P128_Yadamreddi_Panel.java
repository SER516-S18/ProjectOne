import javax.swing.*; 
import java.awt.*;  
/*Panel consisting first and last name and a counter incrementing or decrementing from 0 to 9 or
 * 9 to 0 based on a argument passed to it. */
public class P128_Yadamreddi_Panel {
	//JFrame frame = new JFrame("Dummy");
	JPanel panel = new JPanel();
	JLabel firstLine = new JLabel("", JLabel.CENTER);
	JLabel secondLine = new JLabel("", JLabel.CENTER);
	JLabel time = new JLabel("", JLabel.CENTER);
	Thread timer =new Thread();
	int i = 0;
	// Panel constructor which includes color, counter, name and position of the panel
	P128_Yadamreddi_Panel(int counter){
		panel.setBounds(220, 440, 100, 100);
		if(counter%2 == 0)
			panel.setBackground(Color.WHITE);
		else
			panel.setBackground(Color.BLUE);
		
		firstLine.setFont(new Font("Papyrus", Font.BOLD, 16));
		firstLine.setText("Divya");
		secondLine.setFont(new Font("Papyrus", Font.BOLD, 16));
		secondLine.setText("Yadamreddi");
		time.setFont(new Font("Papyrus", Font.BOLD, 16));
		/*frame.add(panel);
		frame.setSize(600, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		panel.add(firstLine);
		panel.add(secondLine);
		if(counter%2 == 0)
		{
			i = 0;
			while(i<10) {
				time.setText(Integer.toString(i));
				panel.add(time);
				try { 
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
				if(i == 10)
					i = 0;
			}
		}
		else
		{
			i = 9;
			while(i>-1) {
				time.setText(Integer.toString(i));
				panel.add(time);
				try { 
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i--;
				if(i == -1)
					i = 9;
			}
		}
		
	}
	
	/*public static void main(String[] args) {
		int counter=1;
		new P128_Yadamreddi_Panel(counter);
		
	}*/

}
