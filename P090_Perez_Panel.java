import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * P090_Perez_Panel
 *
 * @author Isidro Perez
 * @version 1.0
 */
public class P090_Perez_Panel extends JPanel {

    private JLabel nameLabel;
    private JLabel timeLabel;

    private int num;
    private int count;

    P090_Perez_Panel(int num) {
        this.nameLabel = new JLabel("<html>Isidro<br>Perez</html>");
        this.timeLabel = new JLabel("");
        this.num = num;
        this.count = 0;
        init();
    }

    private void init() {
        // initialize background color based on panel position
        setBackground(num % 2 == 0 ? Color.WHITE :  new Color( 171, 216, 230 ));
        setLayout(new GridLayout(2, 1, 0, 0));
        setTimeLable();

        // set name label
        nameLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setVerticalAlignment(JLabel.CENTER);

        // set time label
        timeLabel.setFont(new Font("Papyrus", Font.PLAIN, 15));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.CENTER);

        add(nameLabel, BorderLayout.NORTH);
        add(timeLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // sets the displayed time label every second
    private void setTimeLable() {
        Timer timer = new Timer( 1000, event -> {
            if(num % 2 == 0) {
                if(count == 10) {
                    count = 0;
                } else {
                    count++;
                }
            } else {
                if(count <= 0) {
                    count = 9;
                } else {
                    count--;
                }
            }
            timeLabel.setText(Integer.toString(count));
        });
        timer.setRepeats(true);
        timer.start();
    }
}
