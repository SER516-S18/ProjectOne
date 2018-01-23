import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * This class is my Panel implementation using a parameterized constructor along
 * with private method init and class Counter
 *
 * @author Cephas Armstrong-Mensah
 * @version 1.0
 * @since 2018-01-18
 *
 */
public class P002_ArmstrongMensah_Panel extends JPanel {
	/**
	 * 
	 * @param flag Passed along to private method
	 */
	public P002_ArmstrongMensah_Panel(int flag) {
		this.init(flag);
	}

	/**
	 * 
	 * @param flag Used to determine the counter direction and panel color
	 */
	private void init(int flag) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));

		JLabel lblFullName = new JLabel("<html>Cephas<br>Armstrong-Mensah</html>");
		lblFullName.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblFullName.setFont(new Font("Papyrus", Font.PLAIN, 10));
<<<<<<< HEAD
		add(lblFullName);

		JLabel lblCounter = new JLabel("");
		lblCounter.setAlignmentX(Component.CENTER_ALIGNMENT);
=======
		lblFullName.setBounds(2, 2, 96, 50);
		add(lblFullName);

		JLabel lblCounter = new JLabel("");
>>>>>>> e8a7ba992285411cf83a75a66c4e1380b21e5cd7
		lblCounter.setFont(new Font("Papyrus", Font.PLAIN, 15));
		lblCounter.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCounter);

		Counter counter = new Counter(lblCounter, (flag % 2 == 0) ? 0 : 9);
		new Thread(counter).start();

		this.setBackground(flag % 2 == 0 ? Color.WHITE : new Color(135, 206, 250));
		this.setSize(100, 100);
		this.setVisible(true);
	}

	/**
	 * This Counter Class implements Runnable which is a Thread idea option. The
	 * thread is used to run counter so it does not block the main thread
	 *
	 * @author Cephas Armstrong-Mensah
	 *
	 */
	private class Counter implements Runnable {
		private JLabel lblCounter;
		private int counter;
		private int flag;

		/**
		 * Counter constructor to spin off a new thread
		 * 
		 * @param lbl JLabel used for displaying counter
		 * @param c Initial counter value either 0 or 9
		 */
		public Counter(JLabel lbl, int c) {
			this.lblCounter = lbl;
			this.counter = c;
			this.flag = c;
		}

		@Override
		public void run() {
			try {
				while (true) {
					try {
						lblCounter.setText(this.counter + "");
						if (flag == 0) {
							if (++this.counter > 9)
								this.counter = 0;
						} else {
							if (--this.counter < 0)
								this.counter = 9;
						}
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}