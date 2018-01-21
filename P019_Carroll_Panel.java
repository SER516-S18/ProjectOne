import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

public class P019_Carroll_Panel extends JPanel {
	
	public final int WIDTH = 100;
	public final int HEIGHT = 100;
	public final int COUNT_MAX = 9;
	public final int COUNT_MIN = 0;
	
	private int setting;
	private Timer timer;
	private int countValue;
	private JLabel nameLabel;
	private JLabel counterLabel;

	P019_Carroll_Panel( int setting ) {
		this.setting = setting;
		init();
	}
	
	private void init() {
		countValue = increases( setting ) ? COUNT_MIN : COUNT_MAX;
		
		// Name label
		nameLabel = new JLabel("<html><center> Douglas <br/> Carroll </center></html>");
		nameLabel.setFont( new Font( "Papyrus", Font.PLAIN, 9 ) );
		nameLabel.setHorizontalAlignment (JLabel.CENTER );
		nameLabel.setVerticalAlignment( JLabel.CENTER );
		
		// Counter label
		counterLabel = new JLabel( Integer.toString( countValue ) );
		counterLabel.setFont( new Font( "Papyrus", Font.PLAIN, 9 ) );
		counterLabel.setHorizontalAlignment( JLabel.CENTER );
		counterLabel.setVerticalAlignment( JLabel.CENTER );
		timer = new Timer( 1000, new ActionListener() {
			public void actionPerformed( ActionEvent event )  {
				countValue = increases( setting ) ? ++countValue : --countValue;
				// Keep within bounds
				if( countValue < COUNT_MIN ) {
					countValue = COUNT_MAX;
				} else if ( countValue > COUNT_MAX ) {
					countValue = COUNT_MIN;
				}
				counterLabel.setText( Integer.toString( countValue ) );
			}
		});
		timer.setRepeats( true );
		timer.start();
		
		// Panel settings
		setLayout( new BorderLayout( 0, 0 ) );
		setBorder( new EmptyBorder( 20, 20, 20, 20 ) );
		setSize( WIDTH, HEIGHT );
		setVisible( true );
		setBackground( increases(setting) ? Color.WHITE : new Color( 135, 206, 250 ) );
		add( nameLabel, BorderLayout.NORTH );
		add( counterLabel, BorderLayout.SOUTH );
	}

	// Defines if setting is set to increase or not (aka decrease)
	// setting - Even for true, odd for false.
	private boolean increases( int setting ) {
		return setting % 2 == 0;
	}

	// FOR TESTING ONLY - Specification requires this to remain in here.
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(100, 100);
		P019_Carroll_Panel panel = new P019_Carroll_Panel(1);
		frame.add(panel);
		frame.setVisible(true);
	}
}
