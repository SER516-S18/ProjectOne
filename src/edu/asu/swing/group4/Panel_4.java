package edu.asu.swing.group4;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_4 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -47793851111493159L;

	public Panel_4() {
		
		setSize(300,200);
	    setLocation(100, 100);
		
		JLabel label1 = new JLabel();
	    label1.setText("Sample text");
	    
	    add(label1);
	    
	    setVisible(true);
	}

}
