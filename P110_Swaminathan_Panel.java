
import java.awt.*;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* Lab 1
* @author Sangeetha Swaminathan
* P110_Swaminathan_Panel is a panel.
* Row one is the first name.
* Row two is the last name.
* Row three is a counter that is either incrementing from 0 or decrementing from 9.
* The mode of the counter and the background color are determined by the value passed to the constructor
*/ 
public class P110_Swaminathan_Panel extends JPanel {

    
    GridBagConstraints gbc = new GridBagConstraints();
    static int value =  0;
    static int step = 1;
    
    
    /**
     * Class constructor.
     * @param typeSwitch Used to describe the background and counter mode of the panel.
     * Even number : White background and Counter Increases
     * Odd Number : Blue background and Counter Decreases
     */
    
    public P110_Swaminathan_Panel(int typeSwitch) {
       
        setLayout(new GridBagLayout());
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        setBorder(BorderFactory.createLineBorder(Color.black));
        
        JLabel firstname = new JLabel("Sangeetha", JLabel.CENTER);
        JLabel lastname = new JLabel("Swaminathan", JLabel.CENTER);
        firstname.setFont(new Font("Papyrus", Font.BOLD, 15));
        lastname.setFont(new Font("Papyrus", Font.BOLD, 15));
        addAtPosition(firstname, 0, 0);
        addAtPosition(lastname, 0, 1);
       
       
        if(typeSwitch % 2 == 0)
        {
            this.setBackground(Color.white);
        }
        else
        {
            this.setBackground(new Color(150,200,250));
           
        }
      
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int value=0;
                int step = 1;
                
                if(typeSwitch % 2 == 1)
                {
                     value = 9;
                     step = -1;
                }
                
                JLabel counter = new JLabel(new Integer(value).toString());
                counter.setHorizontalAlignment(JLabel.CENTER);
                counter.setFont(new Font("Papyrus", Font.BOLD, 15));
                addAtPosition(counter, 0, 2);
                while (true) {
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println(e.toString());
                        continue;
                    }
                    
                    value = value + step;
                    if(typeSwitch % 2 == 1 && value == -1)
                    {
                        value = 9;
                    }
                    counter.setText(new Integer(Math.abs(value%10)).toString())    ;
                }
            }
        });
        thread.start();
        setVisible(true);
    }
    
    
    void addAtPosition(Component component, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(component, gbc);
    }
}
