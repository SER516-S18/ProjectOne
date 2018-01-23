import java.awt.Color;
import javax.swing.JPanel;

/**
 * This class creates a panel with my name and a counter
 * @author Vikram Wathodkar (vikram.wathodkar@asu.edu)
 */
public class P125_Wathodkar_Panel extends JPanel {

	/**
	 * Constructor of the class; It initialize all 
	 * components and start the counter
	 * @param panelPlace : if panelPlace is odd background is light blue, otherwise white
 	 */
	public P125_Wathodkar_Panel(int panelPlace) {
		
		/* Initialize labels and add them in panel */
		jLabelFirstName = new javax.swing.JLabel();
		jLabelLastName = new javax.swing.JLabel();
		jLabelCounter = new javax.swing.JLabel();
		jLabelFirstName.setText("Vikram Kiran");
		jLabelLastName.setText("Wathodkar");
		jLabelCounter.setText("0");
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(20, 20, 20)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabelCounter)
												.addComponent(jLabelLastName)
												.addComponent(jLabelFirstName))
								.addContainerGap(202, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(20, 20, 20)
						.addComponent(jLabelFirstName).addGap(20, 20, 20)
						.addComponent(jLabelLastName).addGap(20, 20, 20)
						.addComponent(jLabelCounter)
						.addContainerGap(82, Short.MAX_VALUE)));
		
		/* Set the background depending on argument */
		if (panelPlace % 2 == 0)
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
					jLabelCounter.setText(counter.toString());
					try {
						/* Put thread to sleep for 1 second */
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
	
	/* Private Variables */
	private javax.swing.JLabel jLabelFirstName;
	private javax.swing.JLabel jLabelLastName;
	private javax.swing.JLabel jLabelCounter;
}
