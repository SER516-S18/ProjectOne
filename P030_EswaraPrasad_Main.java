/**
 * The P030_EswaraPrasad_Main class creates a JPanel that contains 5 tabs, each of which have 25 Panels in them.
 * This is a similar to a gateway and lets the user access all 125 Panels segregated using tabs.
 *
 * @author  Swaroop Eswara Prasad
 * @version 1.0
 * @since   2018-01-22
 */
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


public class P030_EswaraPrasad_Main extends JPanel {

    public P030_EswaraPrasad_Main(){

        /* Enclosing the code in Try/Catch block to catch exceptions. */
        try {

            /* Tabbed Pane allows the creation of tabs in a window and each
            *  tab can be linked with a JPanel.
            * */

            JTabbedPane myTabPane = new JTabbedPane();

            /* Creating JPanel Objects to Link to the tabs.
            Variables Named after the last names of the Tab Managers.
            * */
            JPanel PrakashTab = new P091_Prakash_Tab();
            JPanel SrivastavaTab = new P107_Srivastava_Tab();
            JPanel HendersonTab = new P039_Henderson_Tab();
            JPanel MishraTab = new P074_Mishra_Tab();
            JPanel BahlTab = new P004_Bahl_Tab();

            /* Creating tabs from Panels and assigning other attributes
            * like border and Titles to each tab.
            * */

            myTabPane.addTab("Nikita Bahl", BahlTab);
            myTabPane.addTab("Chris Henderson", HendersonTab);
            myTabPane.addTab("Manas Mishra", MishraTab);
            myTabPane.addTab("Saurabh Prakash", PrakashTab);
            myTabPane.addTab("Varun Srivastava", SrivastavaTab);

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /* Main Method that creates a JFrame object and adds the JTabbedPane Object. */
                JFrame frame = new JFrame();
                frame.add(new P030_EswaraPrasad_Main());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);
                frame.setSize(800, 800);
                frame.setTitle("Swaroop Eswara Prasad");
                frame.setVisible(true);
            }
        });
    }
}
