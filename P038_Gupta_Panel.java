/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Timer;

/**
 *
 * @author srajangupta
 * @version 1.0
 * @since 18-01-2018
 */
public class P038_Gupta_Panel extends JPanel{
   
    public P038_Gupta_Panel(int i)
    {
        int c = i;
        //JFrame jf = new JFrame("Srajan's Frame");
        
        
                setLayout(null);
        
        setSize(100,100);
        
        /**
          Creating Labels for adding Fullname.
            */
        
        JLabel jl1,jl2;
        jl1=new JLabel("Srajan");
        jl2=new JLabel("Gupta");
        jl1.setBounds(10, 5, 100, 30);
        jl2.setBounds(10, 20, 100, 30);
        jl1.setFont(new Font("Papyrus",Font.BOLD,16));
        jl2.setFont(new Font("Papyrus",Font.BOLD,16));
        
        //jf.setVisible(true);
        //jf.setSize(400, 400);
        //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
                add(jl1);
                add(jl2);  
        
   /*
        Changing background color based on the number passed.
        if the number is Even, background color is Blue, else White.
                */
                
        if (c%2 == 0)
        {
           setBackground(new Color(90,150,255));
        }
        else
        {
           setBackground(Color.white);
        }
        JLabel jl3 = new JLabel();
        JLabel jl4 = new JLabel();
       
    /**
        Creating a counter from 0 to 9 or 9 to 0 based on the condition.  
        if the number passed is Even, Counter Starts from 0 and goes till 9.
        Else it starts from 9 till 0.
            */  
        
        Thread t = new Thread(new Runnable() {
            int x=0,y=9;
               
            @Override
            public void run() {                   
                
                while (true) {
                    try {
                        if(c%2==0)
                        {
                             add(jl3);
                        jl3.setText(String.valueOf(x));
                        jl3.setBounds(60, 13, 100, 30);    
                        
                        if (x<9)
                            x++;
                        else 
                            x = 0;
                        
                        }
                        else 
                        {   
                            add(jl4);
                            jl4.setText(String.valueOf(y));
                            jl4.setBounds(60, 13, 100, 30);
                          
                          if(y>0)
                              y--;
                          else
                              y=9;                
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        t.start();
 }
    
    /*public static void main(String [] s)
    {
        int a = 3;
        
        new P038_Gupta_Panel(a);
    }*/
    
}
