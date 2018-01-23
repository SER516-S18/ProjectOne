import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author  Nelson Tran
 * @version 1.0
 * @since   2018-01-22
 */
public class P116_Tran_Panel extends JPanel {
	
	public P116_Tran_Panel(int value) {
		
		/*
		 * The JPanel should be 100 x 100 pixels:
         *
         *      Nelson
         *      Tran
         *      [0-9]
		 */
		
		this.setSize(DIMENSION, DIMENSION);
		this.setLayout(new GridLayout(3, 1));
		this.add(_firstName_label);
		this.add(_lastName_label);
		this.add(_counter_label);
		this.setVisible(true);
		
		/*
		 * 'value' is even ⇒ white background, increasing counter (0 → 9)
		 * 'value' is odd ⇒ light blue background, decreasing counter (9 → 0)
		 */
		
		if (value % 2 == 0) {
			setBackground(Color.WHITE);
			_counter_inc = INCREASING;
			_counter = 0;
			
		} else {
			setBackground(SKY_BLUE);
			_counter_inc = DECREASING;
			_counter = 9;
		}
		
		/*
		 * Initialize the timer. Every second, the timer updates the counter
		 * and the counter label text to count up or down depending on the
		 * parity of 'value'.
		 */

		_timer = new Timer(UPDATE_INTERVAL, event -> {
			_counter += _counter_inc;
			_counter = Math.floorMod(_counter, MAX_COUNTER);
			_counter_label.setText(Integer.toString(_counter));
		});
		
		_timer.start();
	}
	
	/**
	 * Driver method to test the class.
	 * @param args Command line arguments.
	 */
	public static void main(String... args) {
		P116_Tran_Panel panel = new P116_Tran_Panel(117);
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setSize(100, 100);
		frame.setVisible(true);
	}
	
	// Graphical Components.
	private JLabel _firstName_label = new JLabel("Nelson", JLabel.CENTER);
	private JLabel _lastName_label = new JLabel("Tran", JLabel.CENTER);
	private JLabel _counter_label = new JLabel("", JLabel.CENTER);
	
	// Timer & Counter.
	private Timer _timer;
	private int _counter;
	private int _counter_inc;

	// Constants.
	private final Color SKY_BLUE = new Color(173,216,230);
	private final int UPDATE_INTERVAL = 1000;
	private final int DIMENSION = 100;
	private final int MAX_COUNTER = 10;
	private final int INCREASING = 1;
	private final int DECREASING = -1;
}
