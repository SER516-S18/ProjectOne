/*
Name: A Panel Class 
Includes: it can creates panel, set name Jlabel, and set a counter (change with time)
Author: Binbin Yan
Course: SER516
Date: 2018/1/21
*/

/*header file*/
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

/* Class Part */
public class P129_Yan_Panel extends JPanel{
    //Global Value
    int i; //i is used as counter
    int j; //j is used to determine is number even or odd
    Font f = new Font("Serif", Font.BOLD, 15); //label font size
    
    //Construtor
    public P129_Yan_Panel (int a){
        
        //even or odd test
        if(a%2==0){
            j=0;
            i=0;// if even, i starts at 0
        }
        else {
            j=1;
            i=9;// if odd, i starts at 9
        }
        
        //create panel's property
        getpanel(a);
        
        //create name Jlabel
        getname();
        
        //create counter Jlabel 
        JLabel count = new JLabel();
        count.setFont(f);
        add(count);
        count.setText(""+i); //show original i 
        
        //set timer, to change counter by seconds 
        Timer timer=new Timer(1000,new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try{
                    if(j==0){ //if even 
                        ++i; 
                        if(i>9){
                            i=0;
                        }
                    }
                    else{ //if odd
                        --i;
                        if(i<0){
                            i=9;
                        }
                    }
               
               count.setText(""+i);
                }catch (Throwable ex){
                    ex.printStackTrace();  //exception handling 
                }
            }
            
        });
        timer.start(); //start timer
        }
    
    //get panel method
    public void getpanel (int a){
        setSize(new Dimension(100,100)); //panel size is 100*100
        Color back = new Color(31, 190, 214); //light blue color
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); //set layout as page axis, from top to bottom
        if(j==0){ //if even  
            setBackground(Color.WHITE); //white background
        }
        else { //if odd
            setBackground(back); //light blue background
        } 
        
    }
    
    //get name method
    public void getname(){
        JLabel name1 = new JLabel("Binbin"); //create first name Jlabel
        JLabel name2 = new JLabel("Yan"); //create last name Jlabel
        name1.setFont(f); 
        name2.setFont(f);
        add(name1);
        add(name2);
        
    }
    
    /* main method, use to test
    
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