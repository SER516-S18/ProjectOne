import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

/**
 * This class is my Panel implementation using a parameterized constructor 
 * which receives an integer and determines Panel Color and Counter Direction
 * based on the parameter
 *
 * @author Cephas Armstrong-Mensah
 * @version 1.0
 * @since 2018-01-18
 *
 */
public class P002_ArmstrongMensah_Panel extends JPanel {
  // Declaring Color Constants
  final Color LIGHTBLUE = new Color(171, 216, 230);
  final Color WHITE = Color.WHITE;

  /**
   * 
   * @param flag Passed along to private method
   */
  public P002_ArmstrongMensah_Panel (int flag) {
    setLayout(new GridLayout(2, 1, 0, 0));
    
    JLabel lblFullName = new JLabel("<html>Cephas<br>Armstrong-Mensah</html>");
    lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
    lblFullName.setHorizontalTextPosition(SwingConstants.CENTER);
    lblFullName.setFont(new Font("Papyrus", lblFullName.getFont().getStyle() &
        ~Font.BOLD & ~Font.ITALIC, lblFullName.getFont().getSize() + 2));
    add(lblFullName);

    JLabel lblCounter = new JLabel();
    lblCounter.setHorizontalTextPosition(SwingConstants.CENTER);
    lblCounter.setHorizontalAlignment(SwingConstants.CENTER);
    lblCounter.setFont(new Font("Papyrus", lblCounter.getFont().getStyle() &
        ~Font.BOLD & ~Font.ITALIC, lblCounter.getFont().getSize() + 6));
    add(lblCounter);
    
    Counter counter = new Counter(lblCounter, (flag % 2 == 0) ? 0 : 9);

    this.setBackground(flag % 2 == 0 ? WHITE : LIGHTBLUE);
    this.setVisible(true);
    new Thread(counter).start();
  }

  /**
   * This Counter Class implements Runnable which is a Thread idea option. The
   * thread is used to run counter so it does not block the main thread
   *
   * @author Cephas Armstrong-Mensah
   *
   */
  private class Counter implements Runnable {
    private JLabel lblCounter;
    private int counter;
    private int direction;

    /**
     * Counter constructor to spin off a new thread
     * 
     * @param lblCounter JLabel used for displaying counter
     * @param counter Initial counter value either 0 or 9
     */
    public Counter(JLabel lblCounter, int counter) {
      this.lblCounter = lblCounter;
      this.counter = counter;
      this.direction = counter;
    }

    @Override
    public void run() {
      while (true) {
        lblCounter.setText(this.counter + "");
        if (direction == 0) {
          if (++this.counter > 9)
            this.counter = 0;
        } else {
           if (--this.counter < 0)
            this.counter = 9;
        }
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}