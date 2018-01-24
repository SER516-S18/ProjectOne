import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a panel displaying a name and a counter which increments from 0 to 9 every second.
 * showing different color depends received integer whether it's even or odd.
 * @author Ruihao Zhou, rzhou21@asu.edu
 * @version 1.0
 * @TimeLine 01.19.2018 - 01.22.2018
 */

public class P131_Zhou_Panel extends JPanel {
	JLabel fullname;
	JLabel number;
	int count = 0;
	Timer t;
	boolean mark;

	/**
	 * Class constructor.
	 * Determine the background color depends on the number received in increment or descend order.
	 * Run the program.
	 */
	public P131_Zhou_Panel(int n){

		setPreferredSize(new Dimension(100,100));
		setMinimumSize(new Dimension(100, 100));
		init(n);
		setLayout(null);


		fullname=new JLabel("<html>Ruihao<br>Zhou</html>");
		fullname.setBounds(0, 0, 100, 50);
		number.setBounds(0, 40, 100, 50);
		fullname.setHorizontalAlignment(JLabel.CENTER);
		number.setHorizontalAlignment(JLabel.CENTER);
		fullname.setFont(new Font("Papyrus",Font.PLAIN,15));
		number.setFont(new Font("Papyrus",Font.PLAIN,15));

		add(number);
		add(fullname);

		t = new Timer(1000, new NumberReceive());
		t.start();

	}

	/**
	 * Method which create the Panel with your full name and timer.
	 */
	public void init(int n) {

		int res = (n % 2);

		try {
			if (res == 0) {
				count = 0;
				number = new JLabel("0");
				setBackground(Color.white);
			} else {
				count = 9;
				number = new JLabel("9");
				setBackground(new Color(173, 216, 230));
				mark = true;
			}
		}
		catch (Exception ex) {
			System.out.println("There is an error" + ex);
		}
	}

	/**
	 * Method which the number sent is odd or even.
	 * Then set background color to the specified color and count repeatedly.
	 */

	public class NumberReceive implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			try{
				number.setText(String.valueOf(count));
				if(!mark) {
					if(count != 9) {
						count++;
					}else{
						count = 0;
					}
				}
				else{
					if(count != 0) {
						count--;
					}else{
						count = 9;
					}
				}
			}
			catch(Exception ex) {
				System.out.println("There is an error" + ex);
			}

		}
	}

         /**
	 public static void main(String[] args) {
	 P131_Zhou_Panel zhou = new P131_Zhou_Panel(4);
	 JFrame frame = new JFrame();
	 frame.setSize(100, 100);
	 frame.add(zhou);
	 frame.setVisible(true);
	 }
         * Test myself.
	 */

}










		

