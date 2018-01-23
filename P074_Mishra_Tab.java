/*
 * Author - Manas Ranjan Mishra 
 * Project 01 SER516
 * This program integrates 25 panels into a JPanel object and returns the same.
 * The ids covered her are in the range of P053- P078
 **/

// Import the Swing packages
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class P074_Mishra_Tab {

	/*
 * Function returns a panel object container consisting of 25 panels from id 53 - 78
 * */
	public static JPanel createTab() {
		// Create a panel object to include all the 25 panels
		JPanel panel = new JPanel();
		// Create a Grid Layout to include a layout in the panel
		GridLayout grid = new GridLayout(0, 5);
		panel.setLayout(grid);
		// Create GridBag Constraints object to manage the extra spaces while aligning the tabs
		GridBagConstraints setGrid = new GridBagConstraints();
		setGrid.weightx = 1.0;
		setGrid.weighty = 1.0;
		// Add the panels with an integer as argument from 1 - 25
		try {
			P053_Kashyap_Panel kashyap = new P053_Kashyap_Panel(1);
			panel.add(kashyap.P053_Kashyap_Panel(), setGrid);
			P054_Katpally_Panel katpally = new P054_Katpally_Panel(2);
			panel.add(katpally.createPanel(), setGrid);
			panel.add(new P055_Khan_Panel(3), setGrid);
			//P056 -4
			panel.add(new P057_Kolla_Panel(5), setGrid);
			panel.add(new P058_Kotamraju_Panel(6), setGrid);
			panel.add(new P059_Kulkarni_Panel(7), setGrid);
			P060_Kumar_Panel kumar = new P060_Kumar_Panel(8);
			panel.add(kumar.createPanel(), setGrid);
			panel.add(new P061_KUMAR_PANEL(9), setGrid);
			P062_Laad_Panel laad = new P062_Laad_Panel(10);
			panel.add(laad.getPanelInstance(), setGrid);
			panel.add(new P063_Madabhushi_Panel(11), setGrid);
			P064_Madaraju_Panel madaraju = new P064_Madaraju_Panel(12);
			panel.add(madaraju.madaraju_Panel(), setGrid);
			P065_Mahajan_Panel mahajan = new P065_Mahajan_Panel(13);
			panel.add(mahajan.returnPanel(), setGrid);
			panel.add(new P066_Maheshwari_Panel(14), setGrid);
			panel.add(new P067_Malik_Panel(15), setGrid);
			panel.add(new P068_Mandadi_Panel(16), setGrid);
			panel.add(new P069_Mantri_Panel(17), setGrid);
			P070_Marathe_Panel marathe = new P070_Marathe_Panel(18);
			panel.add(marathe.display(), setGrid);
			P071_MathadVijayaKumar_Panel mathad = new P071_MathadVijayaKumar_Panel(19);
			panel.add(mathad.P071_Mathad_VijayaKumar_Panel(), setGrid);
			panel.add(new P072_Mathur_Panel(20), setGrid);
			panel.add(new P073_Menon_Panel(21), setGrid);
			P075_Modi_Panel modi = new P075_Modi_Panel(22);
			panel.add(modi.getPanel(), setGrid);		
			P076_Mohan_Panel mohan = new P076_Mohan_Panel(23);
			panel.add(mohan.getPanel(), setGrid);
			P077_Mohanty_Panel mohanty = new P077_Mohanty_Panel(24);
			panel.add(mohanty.myPanel(), setGrid);
			panel.add(new P078_NamakkalSudhakar_Panel(25), setGrid);
		}catch (Exception e) {
			// Handle any sort of exception while adding the panels
			System.out.println("Exception caught while adding the panels. Exception : " + e.getMessage());
		}
		
		
		return panel;
	}
	// Code fragment to be used for only testing purpose
	
	/*public static void main(String[] args) {
		JFrame frame = new JFrame();
		JTabbedPane tab = new JTabbedPane();
		P074_Mishra_Tab mishraM = new P074_Mishra_Tab(); 
		tab.addTab("Manas Mishra", mishraM.createTab());
		frame.setSize(800, 800);
	    frame.setLocation(200, 200);
	    frame.setVisible(true);
	    frame.setContentPane(tab);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}*/

}
