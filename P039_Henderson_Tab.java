import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;

/**
* P039_Henderson_Tab implements the 5x5 tabbed panel grid for group 2.
* Group 2 consists of panels 27-52, inclusive. This excludes panel 39
* which is the the ID of the tab author.
*
* @author Christopher Henderson, chris@chenderson.org
* @version 1.0
*/
public class P039_Henderson_Tab extends JPanel {

	public static final String TABNAME = "Chris Henderson";

	public P039_Henderson_Tab() {
		// Panels expect an integer in their constructor which determines
		// whether they will be an incrementor with a white background (even)
		// or a decrementor with a light blue background (odd).
		int typeSwitch = 0;
		this.setLayout(new GridLayout(5, 5));
		this.add(new P027_Dua_Panel(typeSwitch++));
		this.add(new P028_Dusad_Panel(typeSwitch++));
		this.add(new P029_Dutta_Panel(typeSwitch++));
		// 30 is the Main.
		this.add(new P031_Faldu_Panel(typeSwitch++));
		this.add(new P032_Gadde_Panel(typeSwitch++));
		this.add(new P033_Goel_Panel(typeSwitch++));
		this.add(new P034_Gorantla_Panel(typeSwitch++));
		this.add(new P035_Gupta_Panel(typeSwitch++));
		this.add(new P036_Gupta_Panel(typeSwitch++));
		this.add(new P037_Gupta_Panel(typeSwitch++));
		this.add(new P038_Gupta_Panel(typeSwitch++));
		// 39 is the tab author.
		this.add(new P040_Henderson_Panel(typeSwitch++));
		this.add(new P041_Hosahalli_Panel(typeSwitch++));
		this.add(new P042_Hu_Panel(typeSwitch++));
		this.add(new P043_Iyer_Panel(typeSwitch++));
		this.add(new P044_Jaime_Panel(typeSwitch++));
		this.add(new P045_JOHAR_Panel(typeSwitch++));
		this.add(new P046_Johnson_Panel(typeSwitch++));
		this.add(new P047_Kakarla_Panel(typeSwitch++));
		this.add(new P048_Kalluri_Panel(typeSwitch++));
		this.add(new P049_Kandimalla_Panel(typeSwitch++));
		this.add(new P050_Kapadia_Panel(typeSwitch++));
		this.add(new P051_Kapoor_Panel(typeSwitch++));
		this.add(new P052_Kasam_Panel(typeSwitch++));
		// This person swears that they are group 2. Could be
		// because the main author is in our block.
		this.add(new P131_Zhou_Panel(typeSwitch++));
	}
}
