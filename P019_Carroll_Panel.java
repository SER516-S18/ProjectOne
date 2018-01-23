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
	public final int FONT_SIZE = 15;
	public final String FONT_TYPE = "Papyrus";
	
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
		nameLabel.setFont( new Font( FONT_TYPE, Font.PLAIN, FONT_SIZE ) );
		nameLabel.setHorizontalAlignment (JLabel.CENTER );
		nameLabel.setVerticalAlignment( JLabel.CENTER );
		
		// Counter label
		counterLabel = new JLabel( Integer.toString( countValue ) );
		counterLabel.setFont( new Font( FONT_TYPE, Font.PLAIN, FONT_SIZE ) );
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
		setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
		setSize( WIDTH, HEIGHT );
		setVisible( true );
		setBackground( increases(setting) ? Color.WHITE : new Color( 171, 216, 230 ) );
		add( nameLabel, BorderLayout.NORTH );
		add( counterLabel, BorderLayout.SOUTH );
	}

	// Defines if setting is set to increase or not (aka decrease)
	// setting - Even for true, odd for false.
	private boolean increases( int setting ) {
		return setting % 2 == 0;
	}
}
