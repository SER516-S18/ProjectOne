import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Implements three labels first name, last name and timer and adds to a panel.
//The timer label behaviour, and panel's background is set based on flag
//Author: Chintham Tharun
//Use "new P020_Chintham_panel(0)" to fetch the panel
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class P020_Chintham_panel extends JPanel implements ActionListener{
	int clock=-1;
	int check;
	Color lightBlue = new Color(173, 216, 230);
	JLabel lblTharun;
	JLabel lblChintham;
	JLabel lblTimer;	
	Timer t=new Timer(1000,this);
	
	//constructor
	public P020_Chintham_panel(int flag) {
		check=flag%2;
		
		try {
			t.start();
		}catch(Exception c){
			System.out.println("failed to start in chintham's panel"+c.getMessage());
		}
		
		
		//panel settings
		this.setLayout(new GridLayout(3,1));
		this.setSize(100,100);
		
		//setting background and clock based on check
		if (check==0) {
			this.setBackground(Color.WHITE);
		}
		else {
			this.setBackground(lightBlue);
			clock=10;
		}
		
		//labels
		lblTharun = new JLabel("Tharun");
		lblTharun.setFont(new Font("Papyrus",Font.PLAIN,15));
		lblTharun.setHorizontalAlignment(JLabel.CENTER);
		add(lblTharun);		
		
		lblChintham = new JLabel("Chintham");
		lblChintham.setFont(new Font("Papyrus",Font.PLAIN,15));
		lblChintham.setHorizontalAlignment(JLabel.CENTER);
		add(lblChintham);		
		
		lblTimer = new JLabel();
		lblTimer.setFont(new Font("Papyrus",Font.PLAIN,15));
		lblTimer.setHorizontalAlignment(JLabel.CENTER);
		add(lblTimer);		
		
	}
	
	//logic for the clock variable and lblTimer	
	public void counter() {
		if(check==0) {
			clock++;
			if(clock==10) {
				clock=0;
			}
		}else {
			clock--;
			if(clock==-1) {
				clock=9;
			}
		}
		lblTimer.setText(""+clock);
	}

	@Override
	//refreshes the label
	public void actionPerformed(ActionEvent e) {
		counter();
		repaint();	
		
	}

}
