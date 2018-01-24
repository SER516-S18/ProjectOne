
import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
            setBackground(new java.awt.Color(173,216,230));
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
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        //setting name and surname in the variables
        Name.setText("Rishab");
        Surname.setText("Mantri");
        add(Name);
        add(Surname);
        add(Clock);
        //setting font
        Name.setFont(new Font("Papyrus",Font.PLAIN,15));
        Surname.setFont(new Font("Papyrus",Font.PLAIN,15));
        Clock.setFont(new Font("Papyrus",Font.PLAIN,15));
        
        Name.setAlignmentX(Component.CENTER_ALIGNMENT);
        Surname.setAlignmentX(Component.CENTER_ALIGNMENT);
        Clock.setAlignmentX(Component.CENTER_ALIGNMENT);
        setSize(100,100);
        setVisible(true);   
        }
 
}   
   


    

