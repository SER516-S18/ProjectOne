
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
* P004_Bahl_Tab implements the 5x5 tabbed panel grid for group 1( P001 to P026 ). 
*
* @author Nikita Bahl
* @version 1.0 (01/22/2018)
*/ 

public class P004_Bahl_Tab extends JPanel
{    
    public static final String TABNAME = "Nikita Bahl";
    private final JTabbedPane tbp = new JTabbedPane();
    
    public P004_Bahl_Tab()
    {
        tbp.addTab("Tab 1", this);
        this.setLayout(new GridLayout(5,5,3,3));
        
        this.add(new P001_Ahuja_Panel(1));
        this.add(new P002_ArmstrongMensah_Panel(2));
        this.add(new P003_Arvind_Panel(3));
        this.add(new P005_Banerjee_Panel(4));
        this.add(new P006_Bantupalli_Panel(5));
        this.add(new P007_Bao_Panel(6));
        this.add(new P008_Bartakke_Panel(7));
        this.add(new P009_Bhangal_Panel(8));
        this.add(new P010_Bhat_Panel(9));
        this.add(new P011_Bhat_Panel(10));
        this.add(new P012_Bhatt_Panel(11));
        this.add(new P013_Bhattacharyya_Panel(12));
        this.add(new P014_Bingumalla_Panel(13));
        this.add(new P015_Bodeddula_Panel(14));
        this.add(new P016_Bumb_Panel(15));
        this.add(new P017_Cai_Panel(16));
        this.add(new P018_Cao_Panel(17));
        this.add(new P019_Carroll_Panel(18));
        this.add(new P020_Chintham_panel(19));
        this.add(new P021_Chittineni_Panel(20).panelTimer());
        this.add(new P022_ChittoorPrem_Panel(21));
        this.add(new P023_Day_Panel(22));
        this.add(new P024_Deolal_Panel(23));
        this.add(new P025_Desai_Panel(24));
        this.add(new P026_Devi_Panel(25).getPanel());      
    }
}
