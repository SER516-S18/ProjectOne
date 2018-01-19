import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;

class P078_Morris_Panel extends JPanel {
    private final boolean isEven;
    private int counter;
    private int count;
    JLabel label_name;
    JLabel label_count;
    String string_name = "<html>Gary<br>Morris</html>";
    
    public P078_Morris_Panel(int value) {
        
        isEven = value %2 == 0;

        if(isEven) {
            setBackground(Color.WHITE);
            count = 0;
            label_count = new JLabel("0");
        } else {
            setBackground(Color.CYAN);
            count = 9;
            label_count = new JLabel("9");
        }
        label_name = new JLabel(string_name);
        
        add(label_name);
        add(label_count);
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new CounterTask(), 1000, 1000);
    }
    
    private class CounterTask extends TimerTask {
        
        @Override
        public void run() {
            if(isEven) {
                counter++;
                count = counter %10;
            } else {
                counter--;
                if(counter %10 == 0) {
                    count = 0;
                } else {
                    count = (counter %10) + 10;
                }
            }
            System.out.println(counter + ", " + count);
            label_count.setText(Integer.toString(count));
        }
    }
}
