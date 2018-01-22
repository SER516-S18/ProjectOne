import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//use JPanel panel = new P020_chintham_panel(0).getPanel(); to fetch the panel

public class P020_chintham_panel implements ActionListener{
	int clock=-1;
	int check;
	JLabel lblTharun;
	JLabel lblChintham;
	JLabel lblTimer; 
	JPanel panel;
	Timer t=new Timer(1000,this);
	//constructor
	public P020_chintham_panel(int flag) {
		check=flag%2;
		t.start();
		panel = new JPanel();//panel settings
		panel.setLayout(new GridLayout(3,1));
		panel.setSize(100,100);
		panel.setBounds(172, 27, 111, 99);
		
		if (check==0) {
			panel.setBackground(Color.WHITE);
		}
		else {
			panel.setBackground(Color.CYAN);
			clock=10;
		}
		
		lblTharun = new JLabel("tharun");
		lblTharun.setFont(new Font("Papyrus",Font.PLAIN,18));
		lblTharun.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblTharun);
		
		
		lblChintham = new JLabel("chintham");
		lblChintham.setFont(new Font("Papyrus",Font.PLAIN,18));
		lblChintham.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblChintham);
		
		
		lblTimer = new JLabel();
		lblTimer.setFont(new Font("Papyrus",Font.PLAIN,18));
		lblTimer.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblTimer);		
		
	}
	
	//logic for the clock variable	
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
	public void actionPerformed(ActionEvent e) {
		//refreshes the label
		counter();
		panel.repaint();	
		
	}
	public JPanel getPanel()//returns the panel
    {
        return panel;
    }
	
	
}
