/* Implementation for SER 516 Lab-1
 * @author Zain Siddiqui
 * Class to implement Panel with full name, a counter, 
 * and background color.*/

 import java.awt.Font;
 import java.awt.Color;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

 import javax.swing.JLabel;
 import javax.swing.JPanel;
 import javax.swing.JFrame;
 import javax.swing.Timer;
 import javax.swing.BoxLayout;
 
 /*
  * Creating class as per Lab-work intructions
  */
 public class p105_Siddiqui_Panel extends JPanel {

 	private JLabel fullName;
 	private JLabel counter;
 	private ActionListener al;
 	private Color bgColor;
 	private Font font;
 	private Timer time;
 	private static int count;
 	private int flag;
 	private int delay = 1000;

 	/*
	 * Variables for white and light blue color background	
 	 */
 	public static final Color white_Bg = Color.WHITE;
 	public static final Color lightBlue_Bg = new Color(173,216,230);

 	/*
 	 * Constructor which takes an integer value and set parameters for background and counter direction.
 	 */

 	public p105_Siddiqui_Panel(int value){
 		if (value % 2 == 0){
 			count = -1;
 			bgColor = white_Bg;
 			flag = 0;
 		}	
 		else{
 			count = 10;
 			bgColor = lightBlue_Bg;
 			flag = 1;
 		}
 		panelWork();
 	}	

 	/*
 	 * The GUI for panel is set here
 	 * Logic for the counter depending on even or odd value
 	 */
 	public void panelWork(){

 		fullName = new JLabel("<Html><div style='text-align: center;'>Zain<br>Siddiqui</div></Html>");
 		counter = new JLabel();
 		font = new Font("Papyrus", Font.PLAIN, 12);


 		fullName.setFont(font);
 		counter.setFont(font);

 		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

 		add(fullName);
 		add(counter);

 		try{

 			if(flag == 0){
 				setBackground(bgColor);
 				al = new ActionListener(){
					public void actionPerformed(ActionEvent evt)
					{
					count++;
					if(count < 10){
						counter.setText(Integer.toString(count));
					}
					else{
						counter.setText("0");
						count = 0;
					}
				

					}
				};
			}	

			else{
				setBackground(bgColor);
 				al = new ActionListener(){
					public void actionPerformed(ActionEvent evt)
					{
					count--;
					if(count > -1){
						counter.setText(Integer.toString(count));
					}
					else{
						counter.setText("9");
						count = 9;
					}
				

					}
				};

			}

			time = new Timer(delay, al);
			time.start();
		}		
 			
 		catch(Exception e){
 			e.printStackTrace();
 		}	
 	}
 			

 		
 	

 	
 	/* Main method for testing purpose */
 	public static void main(String[] args) {
 		JFrame frame =  new JFrame();
 		frame.setVisible(true);
		frame.setSize(100,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p105_Siddiqui_Panel testing = new p105_Siddiqui_Panel(106);
		frame.add(testing);
 		
 	}	

 }


