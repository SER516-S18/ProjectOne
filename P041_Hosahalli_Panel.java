import java.awt.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
import javax.swing.border.Border;

public class P041_Hosahalli_Panel extends JPanel {
    private int count;
    private Border border = BorderFactory.createLineBorder(Color.BLACK,1);
    private JLabel timer;
    private int flag;
    //Constructor which takes a color value and
    // If the value is even then we set flag to 1 and count to 0
    // we increase the count in increasing order, with the background color White
    //else if its odd set the flag to 0,count to 9,
    //decrement the count,with background color to light blue
    public P041_Hosahalli_Panel(int i) {
        Color background_color;
        if (i % 2 == 0) {
            flag = 1;
            background_color = Color.WHITE;
            count = 0;
        } else {
            flag = 0;
            Color lightBlue = new Color(173,216,230);
            background_color = lightBlue;
            count = 9;
        }
        try{
            preparePanelUI(background_color);
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (flag==1) {
                        if (count == 10)
                            count = 0;
                        timer.setText(""+ count++);
                    } else {
                        if (count == -1)
                            count = 9;
                        timer.setText(""+ count--);
                    }
                }
            }, 0, 1000);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    //create the this with first name in first row,last name in second row
    //create a label for counter(0-9)
    public void preparePanelUI(Color bgcolor) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(border);
        this.setSize(100, 100);
        JLabel label_1,label_2;
        //creating the labels in the this
        label_1 = new JLabel("Shreyas", JLabel.CENTER);
        label_2 = new JLabel("Govindaraja", JLabel.CENTER);
        timer = new JLabel("0", JLabel.CENTER);
        label_1.setFont(new Font("Papyrus", Font.PLAIN, 10));
        label_2.setFont(new Font("Papyrus", Font.PLAIN, 10));
        //Aligning the tables in the this
        label_1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label_2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label_1.setAlignmentY(Component.CENTER_ALIGNMENT);
        label_2.setAlignmentY(Component.CENTER_ALIGNMENT);
        //adding the labels to the this
        this.add(label_1);
        this.add(label_2);
        this.add(timer);
        timer.setFont(new Font("Papyrus", Font.PLAIN, 10));
        this.setBackground(bgcolor);
    }
}
