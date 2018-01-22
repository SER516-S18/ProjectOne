/**
 * SER: 516(SOFTWARE AGILITY)
 *LAB 1: USING AGILE PRINCIPLES TEAM SHOULD ASSEMBLE A PROJECT.
 * IN THIS CODE A JPANEL IS BEING CREATED DISPLAYING THE NAME AND 
 * INTEGER NUMBERS USING A TIMER.
 * @author sanaydevi, ASU id: svdevi, Number 028.
 */

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public final class P026_Devi_Panel extends JPanel {

    
    private JPanel panel;
    private JLabel namelabel;
    private JLabel numlabel;

    public P026_Devi_Panel(int i) { //Constructor
        
        Devi_method(i);//Calling method which has the logic for counter and displaying name.
    }
    public void Devi_method(int i) {
        
        
        //Giving attributes to the panel
        panel = new JPanel(new GridBagLayout());
        panel.setSize(100, 100);
        GridBagConstraints c = new GridBagConstraints();
       // blackline = BorderFactory.createLineBorder(Color.BLACK);
      //  panel.setBorder(blackline);
        
        //Giving attributes to the name label
        namelabel = new JLabel();
        namelabel.setFont(new Font("Papyrus", Font.BOLD, 15));
       // namelabel.setBorder(blackline);
        namelabel.setText("<html> Sanay <br> Devi </html>");//(a) JPanel with full namelabel,first namelabel on first row and last namelabel on the next row.
        c.gridx = 0;
        c.gridy = 1;
        panel.add(namelabel, c);//setting the namelabel label to coordinates 0,1.
        
        Timer timer = new Timer();
        numlabel = new JLabel();
        /*Checking if integer passed is not even, means it's odd so set 
        background to light blue and decrement counter from 9 onwards till zero*/
        
       if (i % 2 != 0) {
            panel.setBackground(new Color(173, 216, 230));//if int value is odd then color = light blue
            TimerTask task = new TimerTask() {
           int i =9;
            public void toDO() {
                numlabel.setText(String.valueOf(i--));//(b)JLabel displaying numbers from 0-9
                numlabel.setFont(new Font("Papyrus", Font.PLAIN , 15));

            }
            public void run() {
                
                toDO();
                try {
                    if (i < -1) {
                        i = 9;
                        toDO();
                    }
                } catch (Exception e) { //Error unknown exception, timer failed.
                    
                    e.printStackTrace();
                    System.out.println("Error! Stopping the timer...");
                    timer.cancel();
                }

            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);//after every 1000 ms that is one second timer is set

        } else
       {
        panel.setBackground(Color.WHITE);//else color = white
        TimerTask task = new TimerTask() {
           int i =0;
            public void toDO() {
                numlabel.setText(String.valueOf(i++));//(b)JLabel displaying numbers from 0-9
                numlabel.setFont(new Font("Papyrus", Font.PLAIN, 15));

            }
            public void run() {
                
                toDO();
                try {
                    if (i > 10) {
                        i = 0;
                        toDO();
                    }
                } catch (Exception e) { //Error unknown exception, timer failed.
                    
                    e.printStackTrace();
                    System.out.println("Error! Stopping the timer...");
                    timer.cancel();
                }

            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);//setting the timer to run every 1 second.
       }
        
        //Setting position of second JLabel of numbers
        c.gridx = 0;
        c.gridy = 2;
        panel.add(numlabel, c);//setting the numlabel label to coordinates 0,2.
        panel.setVisible(true);
        
    }
    public JPanel getPanel()//returns the panel
    {
        return panel;
    //PLEASE READ THIS!!
    //In Main Method use: JPanel panel = new P026_Devi_Panel(0).getPanel(); for intializing
   
    }
    // MAIN METHOD USED FOR TESTING, SHOULD BE COMPLETED BY ASSIGNED TAB MEMBER.
    
    /* public static void main(String[] args) {
        
        JFrame frame = new JFrame("GROUP 1");
         JPanel panel = new P026_Devi_Panel(5).getPanel();
         //Giving attributes to the frame
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        
   
    }*/
    
} //END 


