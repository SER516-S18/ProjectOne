import javax.swing.*;
import java.awt.*;

public class P091_Prakash_Tab {

    public JTabbedPane getTab() {

        JTabbedPane jtp = new JTabbedPane();

        //All JPanel Objects of Students
        JPanel jPanel = new JPanel();
        jPanel.add(new P097_Sampath_Panel(1));
        jPanel.add(new P095_Rice_Panel(2));
        jPanel.add(new P096_Saifudeen_Panel(3));
        jPanel.add(new P098_Sawant_Panel(4));
        jPanel.add(new P099_Shah_Panel(5));
        //jPanel.add(new P082_gspai_panel(6));
        //jPanel.add(new P083_Palkar_panel(7));
        jPanel.add(new P087_Parmar_Panel(8));
        //jPanel.add(new P088_Patel_Panel(9));
        //jPanel.add(new P089_Patel_Panel(9));
        // jPanel.add(new P103_Sharma_Panel(1));


        jPanel.setSize(200, 100);

        //Add Scrollbar
        JScrollPane scrollPane = new JScrollPane(jPanel);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(100);
        scrollPane.getVerticalScrollBar().setUnitIncrement(100);

        //add layout
        jPanel.setLayout(new GridLayout(0, 5));


        //add panels to tabs
        jtp.addTab("P091", new JScrollPane(jPanel));

        return jtp;
    }

    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.add(new P091_Prakash_Tab().getTab());
        jFrame.setSize(1000, 500);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
