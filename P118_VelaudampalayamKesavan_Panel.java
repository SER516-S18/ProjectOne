import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class P118_VelaudampalayamKesavan_Panel extends JPanel{

	//int counter;
	
		//private JFrame frame = new JFrame("SER516");
		//private JPanel newPanel = new JPanel();
		private Color bg;
		
		private JLabel fname = new JLabel("Hari Siddarth");
		private JLabel lname = new JLabel("V Kesavan");
		private JLabel time = new JLabel();
		public P118_VelaudampalayamKesavan_Panel(int bgcolor) {
			
			//Constructor to take in an integer parameter and determine the background color based on it.
			
			if(bgcolor % 2 == 0) {
				bg = Color.WHITE; 	//Background Color white if parameter passed is even.
				//counter = 0;
				incrementCounter();
			}
			
			else {
				bg = new Color (173,216,230);		////Background Color cyan if parameter passed is odd.
				//counter = 9;
				decrementCounter();
			}
			this.setBackground(bg);
			this.setLayout(new GridLayout(3,1));		//A 3x1 Layout for 3 labels.
			
			Font font = new Font("Papyrus", Font.PLAIN, 15);
			
			fname.setFont(font);
			lname.setFont(font);
			
			fname.setHorizontalAlignment(SwingConstants.CENTER);
			lname.setHorizontalAlignment(SwingConstants.CENTER);
			time.setHorizontalAlignment(SwingConstants.CENTER);
			

			this.setBounds(0, 0, 100, 100);
			this.add(fname);
			this.add(lname);
			this.add(time);
			this.setVisible(true);
			//frame.add(this);
			//frame.setSize(200, 200);
			//frame.setVisible(true);
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		public void incrementCounter() {
			
			//Increasing the value of timer.
			
			new Thread() {
				int counter = 0;
				
				public void run() {
					while(true) {
						if(counter == 10) {
							counter = 0;
						}
					
						time.setText(new Integer(counter).toString());
						counter++;
					
						try {
							Thread.sleep(1000);
						}catch(Exception e) {}
					}
				}
			}.start();
		}
		
		public void decrementCounter() {
			
			//Decreasing the value of timer.
			
			new Thread() {
				int counter = 9;
				
				public void run() {
					while(true) {
						if(counter == -1) {
							counter = 9;
						}
					
						time.setText(new Integer(counter).toString());
						counter--;
						
						try {
							Thread.sleep(1000);
						}catch(Exception e) {}
					}
				}
			}.start();
		}
		

		/*public static void main(String[] args) {
			// TODO Auto-generated method stub
			new P118_VelaudampalayamKesavan_Panel(2);
		}*/
	

}
