import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author pratik
 *
 */

//class for name labels
class NameLabel{
	
	JLabel first;
	JLabel last;
	
	NameLabel(String fName, String lName){
		first = new JLabel(fName);
		last = new JLabel(lName);
		first.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		last.setAlignmentX(JLabel.CENTER_ALIGNMENT);		
		first.setFont(new Font("Papyrus",Font.PLAIN,16));
		last.setFont(new Font("Papyrus",Font.PLAIN,16));
	}
}


public class P109_Suryawanshi_Panel extends JPanel{
	
	private NameLabel nameLabel;
	private JLabel counterLabel;
	int count = 9;
	boolean flag = false;
	
	/**
	 * @param i
	 */
	public P109_Suryawanshi_Panel(int i) {
		// TODO Auto-generated constructor stub
		setVars(i);
		nameLabel = new NameLabel("Pratik", "Suryawanshi");
		counterLabel = new JLabel();		
		setTimerTask();
		Box box = setBoxLabels();
		this.setBackground(getColor(i));
		this.add(box);
	}
	
	//function to check and set boolean flag for even/odd value and counter value
	private void setVars(int value) {
		if(value % 2 == 0)
			flag = true;
		if(flag)
			count = 0;
	}
	
	//function to create and run timer task to show count on panel
	private void setTimerTask() {
		Timer timer = new Timer();
		try{
			TimerTask timerTask = new TimerTask(){
				public void run(){
					setCounterLabelProperties(counterLabel);
					if(flag) {
						count = count + 1;
						// reset count upon reaching value of 9
						count = count > 9 ? 0 : count;
					}else {
						count = count - 1;
						// reset count upon reaching value of 0
                        count = count < 0 ? 9 : count;
					}
				}
			};
			timer.scheduleAtFixedRate(timerTask, 1000, 1000);
			}catch(Exception e){
				System.out.println("Exception occured : "+e);
			}
		
	}
	
	//function to determine color based on input num.
	private Color getColor(int num) {
		return flag ? Color.WHITE : new Color(173,216,230);
	}
	
	//function to set counter label
	private void setCounterLabelProperties(JLabel counterLabel) {
		counterLabel.setText(Integer.toString(count));
		counterLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		counterLabel.setFont(new Font("Papyrus",Font.PLAIN,16));
	}
	
	//function to add labels to box
	private Box setBoxLabels(){
		Box box = Box.createVerticalBox();
		box.add(nameLabel.first);
		box.add(nameLabel.last);
		box.add(counterLabel);
		return box;
	}
	
	//main method to test working of panel
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		JPanel panel = new P109_Suryawanshi_Panel(2);
		panel.setBounds(40, 80, 200, 200);
		f.add(panel);
		f.setSize(800, 800);
		f.setLayout(null);
		f.setVisible(true);
	}

}
