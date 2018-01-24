import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JPanel;


	
/**
 * Class which creates a panel which compiles and arranges all the other small panels to be displayed on a tab
 * This Panel will be used bu the main window to be displayed in a jtabbedpane
 * @author Varun.Srivastava
 *
 */
public class P107_Srivastava_Tab extends JPanel{
	
	/**
	 * Serial Id generated
	 */
	private static final long serialVersionUID = 1L;

	public static String TABNAME = "Varun Srivastava";
	
	/**
	 * Constructor method of P107_Srivastava_Tab class. All the sub panels are loaded inside this method
	 * 
	 */
	public P107_Srivastava_Tab() {
		setLayout(new GridLayout(0, 5));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
		add(new P105_Siddiqui_Panel(105), gbc);
		add(new P106_Singal_Panel(106), gbc);
		add(new P108_SubramanianVenkatraman_Panel(108), gbc);
		add(new P109_Suryawanshi_Panel(109), gbc);
		add(new P110_Swaminathan_Panel(110), gbc);
		add(new P111_Tandon_Panel(111), gbc);
		add(new P112_Thakkar_Panel(112).ReturnObject(), gbc); //Had to call extra function
		add(new P113_Thiagarajan_Panel(113), gbc);
		add(new P114_Thoram_Panel(114), gbc);
		add(new P115_Tikku_Panel(115), gbc);
		add(new P116_Tran_Panel(116), gbc);
		add(new P117_VasantraoYadav_Panel(117), gbc);
		add(new P118_VelaudampalayamKesavan_Panel(118), gbc);
		add(new P120_Venkatasubramanian_Panel(120), gbc);
		add(new P121_Venugopal_Panel(121), gbc);
		add(new P122_Vyas_Panel(122), gbc);
		add(new P123_Wakchaure_Panel(123), gbc);
		add(new P124_Wang_Panel(124), gbc);
		add(new P125_Wathodkar_Panel(125), gbc);
		add(new P126_Wei_Panel(126).getPanel(), gbc); //Had to call extra function
		add(new P127_Wu_Panel(127).create(), gbc); //Had to call extra function
		add(new P128_Yadamreddi_Panel(128).constructPanel(128), gbc); //Had to call extra function
		add(new P129_Yan_Panel(129), gbc);
		add(new P130_Zhang_Panel(130), gbc);
		add(new P131_Zhou_Panel(131), gbc);
	}

}
	

