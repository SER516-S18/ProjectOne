import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//Implements three labels first name, last name and timer and adds to a panel.
//The timer label behaviour, and panel's background is set based on flag
//Author: Chintham Tharun
//Use "JPanel panel = new P020_Chintham_panel(0).getPanel();" to fetch the panel

public class P020_Chintham_panel extends JPanel implements ActionListener{
	int clock=-1;
	int check;
	Color lightBlue = new Color(173, 216, 230);
	JLabel lblTharun;
	JLabel lblChintham;
	JLabel lblTimer; 
	JPanel panel;
	
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
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		panel.setSize(100,100);
		//setting background and clock based on check
		if (check==0) {
			panel.setBackground(Color.WHITE);
		}
		else {
			panel.setBackground(lightBlue);
			clock=10;
		}
		
		//labels
		lblTharun = new JLabel("Tharun");
		lblTharun.setFont(new Font("Papyrus",Font.PLAIN,15));
		lblTharun.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblTharun);		
		
		lblChintham = new JLabel("Chintham");
		lblChintham.setFont(new Font("Papyrus",Font.PLAIN,15));
		lblChintham.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblChintham);		
		
		lblTimer = new JLabel();
		lblTimer.setFont(new Font("Papyrus",Font.PLAIN,15));
		lblTimer.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblTimer);		
		
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
		panel.repaint();	
		
	}
	//returns the panel
	public JPanel getPanel()
    	{
        return panel;
    	}
}
