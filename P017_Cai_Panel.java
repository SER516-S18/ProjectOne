/**
* A Japenl used to show a name and an counter. For SER 516 only.
* @author  Zeyong Cai
* @version 1.0
* @since   2018-01-21
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class P017_Cai_Panel extends JPanel {
    private int mCnt;
    private boolean mIncrease;

    public P017_Cai_Panel(int num) {
        SetPanelProperties(num);
        AddName();
        AddCounter(num);
    }

    /**
     * Set properties of the panel
     * @para num used to set background color of the panel
     */
    private void SetPanelProperties(int num) {
        setPreferredSize(new Dimension(100,100));
      //  setBorder(BorderFactory.createLineBorder(Color.black));
        Color bg = num % 2 == 0 ? Color.white : new Color(135,206,250);
        setBackground(bg);
        setLayout(new GridLayout(2, 1));
    }

    /**
     * Add counter to the panel
     * @para num counter increases when num is even, otherwise it decreases
     */
    private void AddCounter(int num) {
        boolean even = num % 2 == 0;
        mCnt = even ? 0 : 9;
        mIncrease = even;
        JLabel counter = new JLabel(mCnt + "", JLabel.CENTER);
        counter.setFont(new Font("papyrus", Font.PLAIN, 15));
        add(counter);

        Timer t = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent act) {
                try {
                    if (mIncrease) {
                        ++mCnt;
                        mCnt = mCnt > 9 ? 0 : mCnt;
                    } else {
                        --mCnt;
                        mCnt = mCnt < 0 ? 9 : mCnt;
                    }
                    counter.setText(mCnt + "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    /**
     * Add name to the panel
     */
    private void AddName() {
        JLabel name = new JLabel("<html>Zeyong<br>Cai</html>", JLabel.CENTER);
        name.setFont(new Font("papyrus", Font.PLAIN, 15));
        add(name);
    }
}