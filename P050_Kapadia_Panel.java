import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class P050_Kapadia_Panel extends JPanel {

    private int counter;
    private int type;
    private Font font = new Font("Papyrus", Font.BOLD, 16);

    /**
     * Pass int type
     * @param type
     */
    public P050_Kapadia_Panel(int type) {
        this.type = type;
        if(type%2==0)
            counter = 0;
        else
            counter = 9;

        init();
    }

    /**
     * creates the panels, labels and takes care of the counter
     */
    private void init(){
        if(type%2==0)
            setBackground(new Color(255,255,255));
        else
            setBackground(new Color(90,150,255));

        setLayout(new GridLayout(2,1));
        setPreferredSize(new Dimension(100,100));

        JLabel nameLab = new JLabel("<html>Zubin<br/>Kapadia</html>", JLabel.CENTER);
        nameLab.setFont(font);
        add(nameLab);

        JLabel TimerLab = new JLabel("Timer", JLabel.CENTER);
        TimerLab.setFont(font);
        add(TimerLab);

        try {
            final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    TimerLab.setText("" + counter);
                    if (type % 2 == 0) {
                        if (counter >= 9)
                            counter = 0;
                        else
                            counter++;
                    } else {
                        if (counter <= 0)
                            counter = 9;
                        else
                            counter--;
                    }
                }
            }, 0, 1, TimeUnit.SECONDS);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * for testing purpose
     */
//    public static void main(String[] args) {
//
//        JFrame frame = new JFrame();
//        frame.getContentPane().add(new P050_Kapadia_Panel(1));
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 400);
//        frame.setVisible(true);
//    }
}