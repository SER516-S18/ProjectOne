import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;

/**
 * 
 * @author Cephas Armstrong-Mensah
 *
 */
public class P002_ArmstrongMensah_Panel extends JPanel {
	private int flag;
	
	/**
	 * 
	 * @param flag - int to determine the counter direction and panel color
	 */
	public P002_ArmstrongMensah_Panel (int flag) {
		this.flag = flag;
	}
	
	public void main() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		setLayout(null);
		
		JLabel lblFullName = new JLabel("<html>Cephas<br>Armstrong-Mensah</html>");
		lblFullName.setFont(new Font("Papyrus", Font.PLAIN, 10));
		lblFullName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFullName.setBounds(5, 5, 90, 50);
		add(lblFullName);
		
		JLabel lblCounter = new JLabel("");
		lblCounter.setFont(new Font("Papyrus", Font.BOLD, 16));
		lblCounter.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCounter.setBounds(35, 65, 30, 30);
		add(lblCounter);
		
		setBackground (this.flag % 2 == 0 ? Color.WHITE : new Color(243, 255, 255));				
		Counter counter = new Counter (lblCounter, (this.flag % 2 == 0) ? 0 : 9);
		new Thread(counter).start();
		
		this.setSize(100, 100);
		this.setVisible(true);
	}
	
	/**
	 * 
	 * @author Cephas Armstrong-Mensah
	 *
	 */
	private class Counter implements Runnable {
		private JLabel lblCounter;
		private int counter;
		private int flag;

		public Counter (JLabel lbl, int c) {
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
							if (++this.counter > 9) this.counter = 0;
						} else {
							if (--this.counter < 0) this.counter = 9;
						}
						Thread.sleep (1000);
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