package test;
/**
* P004_Bahl_Tab implements the 5x5 tabbed panel grid for group 1( P001 to P026 ). 
*
* @author Nikita Bahl
* @version 1.0 (01/22/2018)
*/
import javax.swing.*;
import java.awt.GridLayout;
  

public class P004_Bahl_Tab extends JPanel
{    
//    private final JFrame f = new JFrame("Frame");
    private final JPanel p = new JPanel();
    private final JTabbedPane tbp = new JTabbedPane();
    
    public P004_Bahl_Tab()
    {
//        f.add(tbp);
//        f.setVisible(true);
        tbp.addTab("Tab 1", p);
        p.setLayout(new GridLayout(5,5,3,3));
        
        p.add(new P001_Ahuja_Panel(1));
        p.add(new P002_ArmstrongMensah_Panel(2));
        p.add(new P003_Arvind_Panel(3));
        p.add(new P005_Banerjee_Panel(4));
        p.add(new P006_Bantupalli_Panel(5));
        p.add(new P007_Bao_Panel(6));
        p.add(new P008_Bartakke_Panel(7));
        p.add(new P009_Bhangal_Panel(8));
        p.add(new P010_Bhat_Panel(9));
        p.add(new P011_Bhat_Panel(10));
        p.add(new P012_Bhatt_Panel(11));
        p.add(new P013_Bhattacharyya_Panel(12));
        p.add(new P014_Bingumalla_Panel(13));
        p.add(new P015_Bodeddula_Panel(14));
        p.add(new P016_Bumb_Panel(15));
        p.add(new P017_Cai_Panel(16));
        p.add(new P018_Cao_Panel(17));
        p.add(new P019_Carroll_Panel(18));
        p.add(new P020_Chintham_panel(19).getPanel());
        p.add(new P021_Chittineni_Panel(20).panelTimer());
        p.add(new P022_ChittoorPrem_Panel(21));
        p.add(new P023_Day_Panel(22));
        p.add(new P024_Deolal_Panel(23));
        p.add(new P025_Desai_Panel(24));
        p.add(new P026_Devi_Panel(25).getPanel());
                
//        f.setSize(800, 800);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //FOR UNIT TESTING
//    public static void main(String[] args) 
//    {
//        new P004_Bahl_Tab();
//    }
}
