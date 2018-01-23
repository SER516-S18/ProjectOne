

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author rishabmantri
 * @version 1.0
 * @since   2018-01-20 
 * 
 */


public class P069_Mantri_Panel extends JPanel
{
    //declaring variables
    public JLabel Name= new JLabel();
    public JLabel Surname= new JLabel();
    public JLabel Clock= new JLabel(); 
    int k;
    Thread t=new Thread();
    int myCount=0;
    
       /**
   * This is a constructor.
   * @param args int i used to set the background color.
   * @return Nothing.
   * @exception InterruptedException.
   * @see IOException
   */
    public P069_Mantri_Panel(int i)
    {      
        //setting the background color
        if(i%2==0)
        {
            k=0;
            setBackground(new java.awt.Color(255, 255, 255));
        }
        
        else
        {
            k=9;
            setBackground(new java.awt.Color(204, 255, 255));
        }
        
        
        
        myCount=k;
        
        // Running thread for timer
        Thread t= new Thread (new Runnable() {
           
            @Override
            public void run() 
            {
                while(myCount <= 10){
            try{
                    if(i%2==0)
                    {
                        myCount++;
                        myCount=myCount%10;
                        //setting timer in the jlabel
                        Clock.setText(String.valueOf(myCount));
                        Thread.sleep(1000);
                    }
                else
                    {
                        //setting timer in the jlabel
                        Clock.setText(String.valueOf(myCount));
                        myCount--;
                        myCount=myCount%10;
                        Thread.sleep(1000);
                        if(myCount==-1)
                        myCount=9;
                    }
                } catch (InterruptedException iex) {
                System.out.println("Exception in thread: "+iex.getMessage());
            }
            }
            }
        });
        t.start();
    
        //setting name and surname in the variables
        Name.setText("Rishab");
        Surname.setText("Mantri");
        add(Name);
        add(Surname);
        add(Clock);
        //setting font
        Name.setFont(new Font("Papyrus",Font.BOLD,16));
        Surname.setFont(new Font("Papyrus",Font.BOLD,16));
        Clock.setFont(new Font("Papyrus",Font.BOLD,16));
        
        Name.setBounds(25, 1, 75, 25);
        Surname.setBounds(25, 30, 75, 25);
        Clock.setBounds(25, 59, 75, 25);
        setSize(100,100);    
        setLayout(null); 
        setVisible(true);   
        }
 
}   
   


    

