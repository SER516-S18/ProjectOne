import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * @author Shilpa Gajanan Bhat Version 1.0 Adds and styles two labels in the
 *         JPanel Panel Background Color - White if the number received through
 *         constructor is even and blue if it is odd.
 * 
 *         Counter - Increments or decrements every second.Increments if the
 *         number received through constructor is even and decrements if it is
 *         odd.
 * 
 *         Timer fires event every second.
 */
public class P011_Bhat_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public P011_Bhat_Panel(int num) {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		try {
			stylePanel();
			createNameLabel();
			JLabel counterLabel = createCounterLabel(num);
			TimerListener y = new TimerListener(counterLabel);
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
	private JLabel createCounterLabel(int num) {
		JLabel counterLabel = new JLabel("",SwingConstants.CENTER);
		if (num % 2 == 0) {
			counterLabel.setText("0");
			this.setBackground(Color.white);
		} else {
			counterLabel.setText("9");
			this.setBackground(new Color(171,216,230));
		}
		counterLabel.setBorder(null);
		counterLabel.setFont(new Font("Papyrus", Font.PLAIN, 16));
		counterLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		counterLabel.setPreferredSize(new Dimension(50, 30));
		add(counterLabel);
		return counterLabel;
	}

	/**
	 * Name label shows First name in the one row and last name in the second row
	 */
	private void createNameLabel() {
		JLabel nameLabel = new JLabel("<html>Shilpa <br> Bhat </html>",SwingConstants.CENTER);
		nameLabel.setBorder(null);
		nameLabel.setFont(new Font("Papyrus", Font.PLAIN, 12));
		nameLabel.setPreferredSize(new Dimension(95, 50));
		add(nameLabel);
	}

	/**
	 * Panel size set to 100*100
	 */
	private void stylePanel() {
		setBorder(null);
		setPreferredSize(new Dimension(100, 100));
		setLayout(new GridLayout(2,1));
	}
}

/**
 * @author Shilpa TimerListener implements Actionlistener interface to listen to
 *         timer events. When the event is fired counter increments from 0-9 and
 *         then decrements from 9-0 or viceversa.
 */
class TimerListener implements ActionListener {
	private int counter;
	boolean flag = true;
	JLabel l;

	/**
	 * @param label - get the initial value of counter
	 */
	public TimerListener(JLabel label) {
		l = label;
		counter = Integer.parseInt(l.getText());
	}

	/*
	 * (non-Javadoc)
	 * Increments the counter when flag is set 
	 * and decrements when it is not set
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (counter) {
		case 9: {
			counter = counter - 1;
			l.setText("" + counter);
			flag = false;
			break;
		}
		case 0: {
			counter = counter + 1;
			l.setText("" + counter);
			flag = true;
			break;
		}
		default: {
			counter = flag ? counter + 1 : counter - 1;
			l.setText("" + counter);
		}
		}
	}
}
