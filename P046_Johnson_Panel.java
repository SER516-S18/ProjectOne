import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class P046_Johnson_Panel extends JPanel {

    private final int DELAY = 1000;
    private final int PERIOD = 1000;
    private final int ROWS = 2;
    private final int COLUMNS = 1;
    private final int FONT_SIZE = 15;
    private final String FONT_NAME = "Papyrus";

    private boolean incrementFlag;
    private int counter;
    private JLabel firstNameLabel;
    private JLabel timerLabel;
    private Color panelColor;
    private Font textFont;
    private Timer counterTimer;
    private TimerTask task;
    private String name;

    public JPanel panel;


    /*
    ===========================================
    ===========================================
    */

    public P046_Johnson_Panel(int number) {

        setIncrementFlag(number);
        setPanelName();
        setCounter();
        setTextFont(FONT_NAME, FONT_SIZE);
        setNameLabel();
        setTimerLabel();
        setPanelColor();
        setPanel();
        initTimer();
        startPanelTimer();
    }

    /*
    ===========================================
    ===========================================
    */

    private void setPanelName() {

        this.name = "<html><center>Jeb<br>Johnson</center></html>";
    }

    public void setPanelName(String firstName, String lastName) {

        this.name = "<html><center>" + firstName + "<br>" + lastName + "</center><html>";
    }

    private String getPanelName() {

        return this.name;
    }

    /*
    ===========================================
    ===========================================
    */

    private void setPanel() {

        this.setBackground(getPanelColor());
        this.setLayout(new GridLayout(ROWS, COLUMNS));
        this.add(this.firstNameLabel);
        this.add(this.timerLabel);
    }

    /*
    ===========================================
    ===========================================
    */

    private void setNameLabel() {

        this.firstNameLabel = new JLabel(getPanelName());
        this.firstNameLabel.setFont(getTextFont());
        this.firstNameLabel.setHorizontalAlignment(JLabel.CENTER);
        this.firstNameLabel.setVerticalAlignment(JLabel.TOP);
    }

    private void setTimerLabel() {

        this.timerLabel = new JLabel();
        this.timerLabel.setText(Integer.toString(getCounter()));
        this.timerLabel.setFont(getTextFont());
        this.timerLabel.setVerticalAlignment(JLabel.CENTER);
        this.timerLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    /*
    ===========================================
    Sets background color of panel depending on
    the initial number sent to constructor.
    Colors can be white or light blue.
    ===========================================
    */

    private void setPanelColor() {

        this.panelColor = (incrementFlag)? Color.white : new Color(173,216,230);
    }

    private Color getPanelColor() {

        return this.panelColor;
    }

    /*
    ===========================================
    ===========================================
    */

    private void setTextFont(String font_name, int font_size) {

        textFont = new Font(font_name, Font.PLAIN, font_size);
    }

    private Font getTextFont() {

        return this.textFont;
    }

    /*
    ===========================================
    ===========================================
    */

    private void setCounter() {

        this.counter = (getIncrementFlag()) ? 0 : 9;
    }

    private void resetCounter() {

        this.counter = 9;
    }

    private int getCounter() {

        return this.counter;
    }

    /*
    ===========================================
    ===========================================
    */

    private void setIncrementFlag(int number) {

        this.incrementFlag = (number % 2 == 0);
    }

    private boolean getIncrementFlag() {

        return this.incrementFlag;
    }

    /*
    ===========================================
    ===========================================
    */

    private void initTimer() {

        this.counterTimer = new Timer();
    }

    private void startPanelTimer() {

        this.task = new TimerTask() {

            @Override
            public void run() {

                counter = (incrementFlag) ? ++counter % 10 : --counter;

                if (counter < 0) {

                    resetCounter();
                }
                timerLabel.setText(Integer.toString(getCounter()));
            }
        };
        counterTimer.scheduleAtFixedRate(task, DELAY, PERIOD);
    }
}
