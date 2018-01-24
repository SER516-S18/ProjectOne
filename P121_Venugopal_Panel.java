import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Prasanth Venugopal (ASU: pvenugo1)
 * @version 1.0.0 (01/21/2018)
 * @purpose This class is a Jpanel consisting of Name (First Name, Last Name )along with counter and background value based on Parameter
 */

class P121_Venugopal_Panel extends JPanel{
 
    private static final long serialVersionUID = 1L;
    private static final Color lightBlue =new Color(173,216,230);
    
    JLabel count=new JLabel();
    JPanel panel =new JPanel();
    
    public P121_Venugopal_Panel(int num) {
        /* This is a constructor
         * @param num
         */
        setAlignment();
        if(num % 2 == 0)
        {
            /*
             * If num is even , Background is set to white, 
             * counter is increased from 0 to 9 and place in a continues loop
             */
        	evenNumFunction();
        }
        else
        {
        	/*
        	 * If num is odd, This function is called to change Background to Blue 
        	 * Counter is decreased from 9 to 0 and is in continues loop
        	 */
        	oddNumFunction();
        }
    }
    private void evenNumFunction() {
    	/*
    * Background is set to white, 
    * counter is increased from 0 to 9 and place in a continues loop
    */
    	setBackground(Color.white);
        new Thread() {
            int counter = 0;
            public void run() {
                while(true) {
                    if(counter==10)
                        counter=0;
                    
                    count.setText(" " + (counter));
                    counter++;
                    try{
                        Thread.sleep(1000);
                    } catch(Exception e) {
                    	e.printStackTrace();
                    }
                }
            }
        }.start();
    }
    
    private void oddNumFunction() {
     /*
    	 * This function is called to change Background to Blue 
    	 * Counter is decreased from 9 to 0 and is in continues loop
    	 */
    	 setBackground(lightBlue);
         new Thread() {
             int counter = 9;
             public void run() {
                 while(true) {
                     if(counter==-1)
                         counter=9;
                     count.setText(" " + (counter));
                     counter--;
                     try{
                         Thread.sleep(1000);
                     } catch(Exception e) {
                    	 e.printStackTrace();
                     }
                 }
             }
         }.start();
    	
    }
    
    private void setAlignment() {
        /*
         * Sets Layout (GridLayout), sets Dimmension, Jlabel for firstname and Last name
         * Aligns the counter to center 
         * Adds font and size to the label
         */
        setLayout(new GridLayout(2,1));
        setPreferredSize(new Dimension(100,100));
        JLabel name=new JLabel("<html> Prasanth <br> Venugopal <br> </html>");
        name.setHorizontalAlignment(JLabel.CENTER);
        count.setHorizontalAlignment(JLabel.CENTER);
        count.setFont(new Font("Papyrus", Font.PLAIN, 15));
        name.setFont(new Font("Papyrus", Font.PLAIN, 15));
        add(name);
        add(count);
    }
}
