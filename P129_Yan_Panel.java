import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

/**
* This program creates one name label, one counter label, and a timer.
* if input number is an odd number, the panel background will be WHITE, 
* and the counter will increase from 0 to 9.
* if input number is an even number, the panel background will be LIGHTBLUE, 
* and the counter will decrease from 9 to 0.
* name label shows author's firstname and lastname in seperate two rows.
* @author  Binbin Yan
* @version 1.0
* @since   01/22/2018
*/
public class P129_Yan_Panel extends JPanel{
    
    int i;
    int j;
    Font f = new Font("Serif", Font.BOLD, 15);
    
    /**
    * Constructor.
    * @para a is input number and will be determined it is an even number or an odd number.
    * Counter will increase from 0 to 9 if @para a is even, and vice versa.
    * timer will change counter's value by seconds.
    */
    public P129_Yan_Panel (int a){
        
        if(a%2==0){
            j=0;
            i=0;
        }
        else {
            j=1;
            i=9;
        }
        
        getpanel(a);
        getname();
        
        JLabel count = new JLabel();
        count.setFont(f);
        add(count);
        count.setText(""+i); 
        
        Timer timer=new Timer(1000,new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try{
                    if(j==0){  
                        ++i; 
                        if(i>9){
                            i=0;
                        }
                    }
                    else{ 
                        --i;
                        if(i<0){
                            i=9;
                        }
                    }
               
               count.setText(""+i);
                }catch (Throwable ex){
                    ex.printStackTrace(); 
                }
            }
            
        });
        timer.start(); 
        }
    
    /**
    * Set panel's property.
    * @para a determine the background color, if a is even, background is white, 
    * or background is lightblue.
    */
    public void getpanel (int a){
        setSize(new Dimension(100,100));
        Color back = new Color(31, 190, 214); 
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); 
        if(j==0){ 
            setBackground(Color.WHITE); 
        }
        else { 
            setBackground(back); 
        } 
        
    }
    
    /**
    * Set name Label
    * Add name Label
    */
    public void getname(){
        JLabel name1 = new JLabel("Binbin"); 
        JLabel name2 = new JLabel("Yan"); 
        name1.setFont(f); 
        name2.setFont(f);
        add(name1);
        add(name2);
        
    }
    
    /**
    * Main method
    * To test panel
    public static void main(String[] args){
        JFrame f=new JFrame();
        f.setSize(200,200);    
        f.setLayout(null); 
        f.setVisible(true); 
        P129_Yan_Panel p = new P129_Yan_Panel(10);
        f.add(p);
    }
    */
    
    
    
    
}