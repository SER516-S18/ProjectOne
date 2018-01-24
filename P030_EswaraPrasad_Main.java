import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

/**
 * The P030_EswaraPrasad_Main class creates a JPanel that contains 5 tabs,
 * each of which have 25 Panels in them. This is a similar to a gateway and
 * lets the user access all 125 Panels segregated using tabs.
 *
 * @author  Swaroop Eswara Prasad
 * @version 1.0
 * @since   2018-01-22
 */

public class P030_EswaraPrasad_Main extends JPanel {

    /**
     * The constructor of this class is used to create a JTabbedPane and link
     * all the individual tabs together. Tabbed Pane allows the creation of
     * tabs in a window and each tab can be linked with a JPanel.
     */
    public P030_EswaraPrasad_Main(){

        /* Enclosing the code in Try/Catch block to catch exceptions. */

        try {

            JTabbedPane myTabPane = new JTabbedPane();

            /* Creating JPanel Objects to Link to the tabs. */
            P091_Prakash_Tab Tab1 = new P091_Prakash_Tab();
            P107_Srivastava_Tab Tab2 = new P107_Srivastava_Tab();
            P039_Henderson_Tab Tab3 = new P039_Henderson_Tab();
            P074_Mishra_Tab Tab4 = new P074_Mishra_Tab();
            P004_Bahl_Tab Tab5 = new P004_Bahl_Tab();

            /* Creating tabs from Panels and assigning other attributes
            * like border and Titles to each tab.
            * */

            myTabPane.addTab(Tab1.TABNAME, Tab1);
            myTabPane.addTab(Tab2.TABNAME, Tab2);
            myTabPane.addTab(Tab3.TABNAME, Tab3);
            myTabPane.addTab(Tab4.TABNAME, Tab4);
            myTabPane.addTab(Tab5.TABNAME, Tab5);

            myTabPane.setBorder(new EmptyBorder(10, 10, 10, 10));

            setLayout(new BorderLayout());
            add(myTabPane, BorderLayout.CENTER);
        }
        /* Exception Handling. Printing out the Exception to the console. */
        catch(Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }

    }

    /**
     * Main Method that creates a JFrame object and adds the JTabbedPane Object.
     * @param args Unused
     * @return Nothing.
     */
    public static void main(String[] args) {
                JFrame frame = new JFrame();
                frame.add(new P030_EswaraPrasad_Main());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);
                frame.setSize(800, 800);
                frame.setTitle("Swaroop Eswara Prasad");
                frame.setVisible(true);
    }
}
