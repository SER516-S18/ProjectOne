import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JPanel;


	
/**
 * Class which creates a panel which compiles and arranges all the other small panels to be displayed on a tab
 * This Panel will be used by the main window to be displayed in a jtabbedpane
 * @author Varun.Srivastava
 *
 */
public class P107_Srivastava_Tab extends JPanel{
	
	/**
	 * Serial Id generated
	 */
	private static final long serialVersionUID = 1L;

	public static final String TABNAME = "Varun Srivastava";
	
	/**
	 * Constructor method of P107_Srivastava_Tab class. All the sub panels are loaded inside this method
	 * 
	 */
	public P107_Srivastava_Tab() {
		setLayout(new GridLayout(0, 5));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        int argumentIndex = 104;
        try {
			add(new P105_Siddiqui_Panel(++argumentIndex), gbc);
			add(new P106_Singal_Panel(++argumentIndex), gbc);
			add(new P108_SubramanianVenkatraman_Panel(++argumentIndex), gbc);
			add(new P109_Suryawanshi_Panel(++argumentIndex), gbc);
			add(new P110_Swaminathan_Panel(++argumentIndex), gbc);
			add(new P111_Tandon_Panel(++argumentIndex), gbc);
			add(new P112_Thakkar_Panel(++argumentIndex).ReturnObject(), gbc); //Had to call extra function
			add(new P113_Thiagarajan_Panel(++argumentIndex), gbc);
			add(new P114_Thoram_Panel(++argumentIndex), gbc);
			add(new P115_Tikku_Panel(++argumentIndex), gbc);
			add(new P116_Tran_Panel(++argumentIndex), gbc);
			add(new P117_VasantraoYadav_Panel(++argumentIndex), gbc);
			add(new P118_VelaudampalayamKesavan_Panel(++argumentIndex), gbc);
			add(new P119_Vemula_Panel(++argumentIndex), gbc);
			add(new P120_Venkatasubramanian_Panel(++argumentIndex), gbc);
			add(new P121_Venugopal_Panel(++argumentIndex), gbc);
			add(new P122_Vyas_Panel(++argumentIndex), gbc);
			add(new P123_Wakchaure_Panel(++argumentIndex), gbc);
			add(new P124_Wang_Panel(++argumentIndex), gbc);
			add(new P125_Wathodkar_Panel(++argumentIndex), gbc);
			add(new P126_Wei_Panel(++argumentIndex).getPanel(), gbc); //Had to call extra function
			add(new P127_Wu_Panel(++argumentIndex).create(), gbc); //Had to call extra function
			add(new P128_Yadamreddi_Panel(++argumentIndex), gbc);
			add(new P129_Yan_Panel(++argumentIndex), gbc);
			add(new P130_Zhang_Panel(++argumentIndex), gbc);
			// add(new P131_Zhou_Panel(++argumentIndex), gbc); //This guy is included in group 2 as P030 is the main window
		} catch(Exception e){
			System.out.println("Caught an exception while adding subpanels to P107_Srivastava_Tab tab: " + e.getMessage());
		}
	}

}
	

