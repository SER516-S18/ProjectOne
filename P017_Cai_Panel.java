import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
* A Japenl used to show a name and an counter. For SER 516 only.
* @author  Zeyong Cai
* @version 1.0
* @since   2018-01-21
*/
public class P017_Cai_Panel extends JPanel {

    public static final Color LIGHT_BLUE = new Color(171,216,230);
    public static final int FONT_SIZE = 15;
    public static final String FONT_STYLE = "papyrus";

    private int mCnt;
    private boolean mIncrease;

    /**
     * @para num is used to determine the background color of the panel and
     * whether the counter increase or decrease
     */
    public P017_Cai_Panel(int num) {
        SetPanelProperties(num);
        AddName();
        AddCounter(num);
    }

    /**
     * Set properties of the panel
     * @para num the backgourd color is white when num is even, otherwise the
     * backgoud color is lightblue
     */
    private void SetPanelProperties(int num) {
        setPreferredSize(new Dimension(100,100));
      //  setBorder(BorderFactory.createLineBorder(Color.black));
        Color bg = num % 2 == 0 ? Color.white : LIGHT_BLUE;
        setBackground(bg);
        setLayout(new GridLayout(2, 1));
    }

    /**
     * Add the counter to the panel
     * @para num counter increases fron 0 ~ 9 when num is even, otherwise it 
     * decreases form 9 ~ 0
     */
    private void AddCounter(int num) {
        boolean even = num % 2 == 0;
        mCnt = even ? 0 : 9;
        mIncrease = even;
        JLabel counter = new JLabel(mCnt + "", JLabel.CENTER);
        counter.setFont(new Font(FONT_STYLE, Font.PLAIN, FONT_SIZE));
        add(counter);

        Timer t = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent act) {
                try {
                    if (mIncrease) {
                        mCnt = ++mCnt > 9 ? 0 : mCnt;
                    } else {
                        mCnt = --mCnt < 0 ? 9 : mCnt;
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
     * Add the name to the panel
     */
    private void AddName() {
        JLabel name = new JLabel("<html>Zeyong<br>Cai</html>", JLabel.CENTER);
        name.setFont(new Font(FONT_STYLE, Font.PLAIN, FONT_SIZE));
        add(name);
    }
}