import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author raamprashanthns
 * @version 1
 * created on 2018/01/21
 * This class is a panel class consisting of three methods and displays a panel with 3 rows,
 * 1st row displays the first name,
 * 2nd row displays the last name and
 * 3rd row displays the counter time
 *
 */
@SuppressWarnings("serial")
public class P079_NamakkalSudhakar_Panel extends JPanel {
    
    /** 
     * Panel type is an enum that stores the panel based on the number passed to the constructor,
     * this is used instead of repeatedly checking whether the number is even or odd
     */
    enum PanelType {
        Odd,
        Even
    }
    
    private PanelType panelType;
    private Font papyrusFont = new Font("Papyrus", Font.PLAIN, 15);
    private Color lightBlue = new Color(173, 216, 230);
    private JLabel firstNameLabel = new JLabel("Raam Prashanth", JLabel.CENTER);
    private JLabel lastNameLabel = new JLabel("Namakkal Sudhakar", JLabel.CENTER);
    private JLabel counterLabel = new JLabel();
    		
    /**
     * Class Constructor  - this constructor takes a value and sets up the panel background and timer based on that value,
     * odd - increment counter, even - decrement counter,
     * the panel consists of panels with 3 labels,
     * first name, last name and timer label
     * @param num is the deciding value passed to this constructor
     */
    public P079_NamakkalSudhakar_Panel(int num) {
        
        this.panelType = (num%2 == 0) ? PanelType.Even : PanelType.Odd;
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(100, 100));
        this.setBackground((this.panelType == PanelType.Even) ? Color.white : lightBlue);
        
        firstNameLabel.setFont(papyrusFont);
        lastNameLabel.setFont(papyrusFont);
        addLabel(firstNameLabel, 0, 0);
        addLabel(lastNameLabel, 0, 1);
        
        Thread thread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                int change = 1;
                int start = 0;
                
                if (panelType == PanelType.Odd) {
                    change = -1;
                    start = 9;
                }
                
                counterLabel.setText(new Integer(start).toString());
                counterLabel.setFont(papyrusFont);
                counterLabel.setHorizontalAlignment(JLabel.CENTER);
                addLabel(counterLabel, 0, 3);
                
                while (true) {
                    try {
                        Thread.sleep(1000); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    start = start + change;  
                    if (start < 0) { 
                        start = 9;
                    } else if (start > 9) {
                        start = 0;
                    }
                    counterLabel.setText(new Integer(start).toString());
                }
                
            }
        });
        thread.start();   
    }
    
    /**
     *  This method is used for positioning the label component
     * @param label is the label component
     * @param x the x scale position
     * @param y the y scale position
     */
    private void addLabel(JLabel label, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        add(label, gbc);
    }
    
    /** 
     * This method returns the panel object
     * 
     * @return returns this JPanel class object
     */
    public JPanel getPanel() {
        return this;
    }
}
