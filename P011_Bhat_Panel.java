import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Shilpa Gajanan Bhat 
 * 		   Version 1.0 (01/23/2018)
 * 	       Adds and styles two labels in the
 *         JPanel Panel Background Color - White if the number received through
 *         constructor is even and blue if it is odd.
 * 		   Counter - Increments or decrements every second.Increments if the
 *         number received through constructor is even and decrements if it is
 *         odd.
 *         Timer fires event every second.
 */
public class P011_Bhat_Panel extends JPanel {
	Color lightBlue = new Color(173, 216, 230);
	boolean isOddPosition = true;

	public P011_Bhat_Panel(int position) {
		try {
			isOddPosition = position % 2 != 0 ? true : false;
			stylePanel();
			createNameLabel();
			JLabel counterLabel = createCounterLabel(position);
			TimerListener y = new TimerListener(counterLabel, isOddPosition);
			Timer t = new Timer(1000, y);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param num
	 *            - number received from tab.
	 * @return Jlabel which is used to display counter
	 */
	private JLabel createCounterLabel(int position) {
		JLabel counterLabel = new JLabel("", SwingConstants.CENTER);
		counterLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
		counterLabel.setPreferredSize(new Dimension(50, 30));
		add(counterLabel);
		return counterLabel;
	}

	/**
	 * Name label shows First name in the one row and last name in the second row
	 */
	private void createNameLabel() {
		JLabel nameLabel = new JLabel("<html>Shilpa <br> Bhat </html>", SwingConstants.CENTER);
		nameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
		nameLabel.setPreferredSize(new Dimension(95, 50));
		add(nameLabel);
	}

	/**
	 * Panel size set to 100*100
	 */
	private void stylePanel() {
		setPreferredSize(new Dimension(100, 100));
		setLayout(new GridLayout(2, 1));
		setBackground(isOddPosition ? lightBlue : Color.WHITE);
	}
}

/**
 * @author Shilpa TimerListener implements Actionlistener interface to listen to
 *         timer events. When the event is fired counter increments from 0-9 or
 *         decrements from 9-0 based on the position number received through
 *         constructor.
 */
class TimerListener implements ActionListener {
	private int counter;
	JLabel l;
	private boolean isOddPosition;

	/**
	 * @param label
	 *            - get the initial value of counter
	 */
	public TimerListener(JLabel label, boolean isOddPosition) {
		l = label;
		this.isOddPosition = isOddPosition;
		counter = isOddPosition ? 9 : 0;
		l.setText("" + counter);
	}

	/*
	 * (non-Javadoc) Increments the counter when position is even and decrements when it
	 * is odd.
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!isOddPosition) {
			l.setText("" + ++counter);
			if (counter == 9)
				counter = -1;
		} else {
			l.setText("" + --counter);
			if (counter == 0)
				counter = 10;
		}
	}
}
