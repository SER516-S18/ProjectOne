import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JPanel;

/*
 * Author - Manas Ranjan Mishra 
 * Project 01 SER516
 * Version 1.0
 * This program integrates 25 panels into a JPanel object and returns the same.
 * The ids covered her are in the range of P053- P078
 **/


public class P074_Mishra_Tab extends JPanel{

	public static String TABNAME = "Manas Mishra";
	/*
 	* Constructor add 25 panels from id 53 - 78
	* */
	public P074_Mishra_Tab() {
		// Create a Grid Layout to include a layout in the panel
		GridLayout panelGrid = new GridLayout(0, 5);
		setLayout(panelGrid);
		
		// Create GridBag Constraints object to manage the extra spaces while aligning the tabs
		GridBagConstraints panelGridConstraints = new GridBagConstraints();
		panelGridConstraints.weightx = 1.0;
		panelGridConstraints.weighty = 1.0;
		
		// Add the panels with an integer as argument from 1 - 25
		try {
			P053_Kashyap_Panel kashyap = new P053_Kashyap_Panel(1);
			add(kashyap.P053_Kashyap_Panel(), panelGridConstraints);
			P054_Katpally_Panel katpally = new P054_Katpally_Panel(2);
			add(katpally.createPanel(), panelGridConstraints);
			add(new P055_Khan_Panel(3), panelGridConstraints);
			add(new P056_Khatun_Panel(4), panelGridConstraints);
			add(new P057_Kolla_Panel(5), panelGridConstraints);
			add(new P058_Kotamraju_Panel(6), panelGridConstraints);
			add(new P059_Kulkarni_Panel(7), panelGridConstraints);
			P060_Kumar_Panel kumar = new P060_Kumar_Panel(8);
			add(kumar.createPanel(), panelGridConstraints);
			add(new P061_KUMAR_PANEL(9), panelGridConstraints);
			P062_Laad_Panel laad = new P062_Laad_Panel(10);
			add(laad.getPanelInstance(), panelGridConstraints);
			add(new P063_Madabhushi_Panel(11), panelGridConstraints);
			P064_Madaraju_Panel madaraju = new P064_Madaraju_Panel(12);
			add(madaraju.madaraju_Panel(), panelGridConstraints);
			P065_Mahajan_Panel mahajan = new P065_Mahajan_Panel(13);
			add(mahajan.returnPanel(), panelGridConstraints);
			add(new P066_Maheshwari_Panel(14), panelGridConstraints);
			add(new P067_Malik_Panel(15), panelGridConstraints);
			add(new P068_Mandadi_Panel(16), panelGridConstraints);
			add(new P069_Mantri_Panel(17), panelGridConstraints);
			P070_Marathe_Panel marathe = new P070_Marathe_Panel(18);
			add(marathe.display(), panelGridConstraints);
			P071_MathadVijayaKumar_Panel mathad = new P071_MathadVijayaKumar_Panel(19);
			add(mathad.P071_Mathad_VijayaKumar_Panel(), panelGridConstraints);
			add(new P072_Mathur_Panel(20), panelGridConstraints);
			add(new P073_Menon_Panel(21), panelGridConstraints);
			P075_Modi_Panel modi = new P075_Modi_Panel(22);
			add(modi.getPanel(), panelGridConstraints);		
			P076_Mohan_Panel mohan = new P076_Mohan_Panel(23);
			add(mohan.getPanel(), panelGridConstraints);
			P077_Mohanty_Panel mohanty = new P077_Mohanty_Panel(24);
			add(mohanty.myPanel(), panelGridConstraints);
			add(new P078_Morris_Panel(25), panelGridConstraints);
			}catch (Exception e) {
				System.out.println("Exception caught while adding the panels. Exception : "
									+ e.getMessage());
			}
				
	}

}
