import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * This Class returns a JTabbedPane which has a compiled grid of 25 panels
 * For testing, I have added a main method, to test, call these - javac P107_Srivastava_Tab.java and java P107_Srivastava_Tab
 * @author Varun Srivastava
 *
 */
public class P107_Srivastava_Tab extends JTabbedPane{
	
	/**\
	 * Serial id generated
	 */
	private static final long serialVersionUID = 5L;
	

	/**
	* Created a main method to test out my frames
	*/
	public static void main(String args[]) {
		JFrame frame = new JFrame("Varun Srivastava");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(800, 800);
	    frame.setLocation(200, 200);
	    
	    frame.setContentPane(new P107_Srivastava_Tab());
	    frame.setVisible(true);
	}
	
	/**
	 * Constructor method of JtabbedPane class
	 */
	public P107_Srivastava_Tab() {
		
		addTab("Varun Srivastava", new PanelBase());
	    
	}
	
	
	/**
	 * Inner class which creates a panel which compiles and arranges all the other small panels to be displayed on a tab
	 * @author Varun.Srivastava
	 *
	 */
	public class PanelBase extends JPanel{
		
		/**
		 * Serial Id generated
		 */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructor method of PanelBase class
		 * 
		 */
		public PanelBase() {
			setLayout(new GridLayout(0, 5));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.weightx = 1.0;
	        gbc.weighty = 1.0;
	        
	        
			add(new P108_SubramanianVenkatraman_Panel(108), gbc);
			add(new P109_Suryawanshi_Panel(109), gbc);
			add(new P110_Swaminathan_Panel(110), gbc);
			add(new P111_Tandon_Panel(111), gbc);
			add(new P112_Thakkar_Panel(112).ReturnObject(), gbc); //Had to call extra function
			add(new P113_Thiagarajan_Panel(113), gbc);
			add(new P115_Tikku_Panel(115), gbc);
			add(new P117_VasantraoYadav_Panel(117), gbc);
			add(new P118_VelaudampalayamKesavan_Panel(118), gbc);
			add(new P120_Venkatasubramanian_Panel(120), gbc);
			add(new P122_Vyas_Panel(122), gbc);
			add(new P125_Wathodkar_Panel(125), gbc);
			add(new P126_Wei_Panel(126).getPanel(), gbc); //Had to call extra function
			add(new P127_Wu_Panel(127).create(), gbc); //Had to call extra function
			// add(new P128_Yadamreddi_Panel(128).panel, gbc);
			add(new P129_Yan_Panel(129), gbc);


			
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			
			
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			
			
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			
			
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			
			
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
			// add(new Panel_1(), gbc);
		}

	}
	

}