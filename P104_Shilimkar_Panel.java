/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p104_shilimkar_panel;
import java.awt.Color;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author anu
 */
public class P104_Shilimkar_Panel {

    private JFrame frame;
    private JPanel panel;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    public P104_Shilimkar_Panel(int num) {

        frame = new JFrame("Ira");
        panel = new JPanel(new GridBagLayout());
        label1 = new JLabel("Anu");
        label2 = new JLabel("Shilimkar");
        GridBagConstraints c = new GridBagConstraints();

        frame.add(panel);
        label1.setFont(new Font("Papyrus", Font.PLAIN, 14));
        label2.setFont(new Font("Papyrus", Font.PLAIN, 14));

        c.gridx = 0;
        c.gridy = 1;
        panel.add(label1, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(label2, c);

        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setPreferredSize(new Dimension(100, 100));

        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        if (num % 2 == 0) {
            panel.setBackground(Color.white);
        } else {
            panel.setBackground(new Color(51, 204, 255));
        }

        counter();

    }

    public void counter() {

        int count = 0;

        GridBagConstraints c = new GridBagConstraints();
        label3 = new JLabel("0");
        c.gridx = 0;
        c.gridy = 3;
        panel.add(label3, c);
        while(true)
        {

        for (count = 0; count <= 9; count++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            label3.setText(String.valueOf(count));
            c.gridx = 0;
            c.gridy = 3;
            panel.add(label3, c);
        }

        for (count = 9; count >= 0; count--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            label3.setText(String.valueOf(count));
            c.gridx = 0;
            c.gridy = 3;
            panel.add(label3, c);
        }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // call the GUI 
        new P104_Shilimkar_Panel(3);
    }

}
