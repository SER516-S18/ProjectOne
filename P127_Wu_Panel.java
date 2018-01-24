import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
/**
 * a JLabel used for SER 516, which can show my name and a number
 * @author Huichuan Wu
 * @version 1.0
 * @since 01/21/2018
 */
public class P127_Wu_Panel{
	Color bcolor;
	Timer timer;
	int n;
	P127_Wu_Panel(int p){
		Color lightblue = new Color(139,218,252);
		if(p % 2 == 0){
			bcolor = Color.white;
			n = 0;
		}
		else{
			bcolor = lightblue;
			n = 9;
		}
	}
	/**
	 * create a JLabel
	 * This JLabel includes my name and an automatically changing number
	 * @return
	 */
	public JLabel create(){
		JLabel p = new JLabel("title",JLabel.CENTER);
		p.setSize(100,100);
		p.setOpaque(true);
		p.setBackground(bcolor);
		p.setText("<html><body>Huichuan<br/>Wu<br/>"+n+"</body></html>");
		//set font
		p.setFont(new java.awt.Font("Papyrus", 1, 15));
		//set color
		p.setForeground(Color.red);
		if(n == 0){
			timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(n == 10){
						n=0;
					}
					p.setText("<html><body>Huichuan<br/>Wu<br/>"+n+"</body></html>");
					n++;
				}
			});
		}
		else{
			timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(n == -1){
						n=9;
					}
					p.setText("<html><body>Huichuan<br/>Wu<br/>"+n+"</body></html>"); 
					n--;
				}
			});
		}
		timer.start();
		return p;
	}
}

