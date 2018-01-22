//package edu.asu.swing.group5;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * This class creates a panel with my name and a counter
 * @author Vikram Wathodkar (vikram.wathodkar@asu.edu)
 *
 */
public class P125_Wathodkar_Panel extends JPanel {

	/**
	 * Constructor of the class; It initialize all 
	 * components and start the counter
	 * @param x : if x is odd background is light blue, otherwise white
 	 */
	public P125_Wathodkar_Panel(int x) {
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel1.setText("Vikram Kiran");
		jLabel2.setText("Wathodkar");
		jLabel3.setText("0");
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(55, 55, 55)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3)
												.addComponent(jLabel2)
												.addComponent(jLabel1))
								.addContainerGap(202, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(40, 40, 40)
						.addComponent(jLabel1).addGap(40, 40, 40)
						.addComponent(jLabel2).addGap(39, 39, 39)
						.addComponent(jLabel3)
						.addContainerGap(82, Short.MAX_VALUE)));
		
		/* Set the background depending on argument */
		if (x % 2 == 0)
			this.setBackground(Color.WHITE);
		else
			this.setBackground(new Color(90, 150, 255));
		
		/* Start the counter */
		startCounter();
	}

	/**
	 * This function will start the counter in new thread
	 * Counter will start from 0 and oscillate between 0 and 9
	 */
	private void startCounter() {
		Thread t = new Thread(new Runnable(){
			//@Override
			public void run() {
				Integer counter = 0;
				int step = 1;
				while (true) {
					jLabel3.setText(counter.toString());
					try {
						/* Put thread to sleep for 1 sec */
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					counter = counter + step;
					if (counter == 0 || counter == 9)
						step = step * -1;
				}
			}
		});
		t.start();
	}
	
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
}
