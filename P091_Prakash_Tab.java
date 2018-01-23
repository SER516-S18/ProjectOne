import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;

/**
 * P091_Prakash_Tab implements the 5x5 tabbed panel grid for group 4.
 * Group from 79-104
 * @author Saurabh Prakash, spraka10@asu.edu
 * @version 1.0
 */
public class P091_Prakash_Tab extends JPanel {

    public P091_Prakash_Tab() {
        this.setLayout(new GridLayout(5, 5));
        //this.add(new P079_Name_Panel);
        this.add(new P080_Nolastname_Panel(1).getPanel()); // addding method to return panel
        this.add(new P082_gspai_panel(3));
        this.add(new P083_Palkar_panel(4));
        //this.add(new P084_Pandey_Panel(5)); Does not return Jpanel
        this.add(new P087_Parmar_Panel(6));
        //this.add(new P088_Patel_Panel(7));
        //this.add(new P089_Patel_Panel(8));
        this.add(new P094_Vellore_Panel(9).P094_Vellore_Panel());
        this.add(new P095_Rice_Panel(10));
        this.add(new P096_Saifudeen_Panel(11));
        this.add(new P097_Sampath_Panel(12));
        this.add(new P098_Sawant_Panel(13));
        this.add(new P099_Shah_Panel(14));
        this.add(new P100_Shah_Panel(15));
        this.add(new P101_Shah_Panel(16));
        this.add(new P102_Sharma_Panel(17));
        //this.add(new P104_Shilimkar_Panel(18)); remove package

    }
}
