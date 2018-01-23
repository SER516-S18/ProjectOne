/**
 * @author Siva Pranav Mandadi
 * @date 01/22/2018
 * @description A Panel class for SER516 project.
 *
 * Class Extends JPanel and contains author's name and a Counter. It contains one parameterized constructor
 * that accepts an integer value.
 * Panel background is set to WHITE if value is even or LIGHT BLUE (173,216,230) if odd.
 * Counter increments from 0-9 if value is even or decrements from 9-0 if odd.
 */
import java.awt.*;
import javax.swing.*;

public class P068_Mandadi_Panel extends JPanel {
    private JLabel name , counter;
    private int  key ;


    
public P068_Mandadi_Panel(int key){
    this.key = key;
    setPanelSize();//Sets the size of the Panel
    backGroundColor();//Sets the Background Color of the Panel
        try {
            nameandtimer(key);//Prints the output of the Required Panel
        } catch (InterruptedException ex) {
            System.out.println("There was an error in" + P068_Mandadi_Panel.class.getName() );
        }
    
    
}
  
    private void setPanelSize() {
        //Setting the Size of the Panel Size 
        this.setPreferredSize(new Dimension(100,100));
        
    }

    private void backGroundColor() {
        //Color is White if the key is even or Light Buue if odd
        if(this.key % 2 == 0)
            this.setBackground(Color.white);
        else {
            Color rgb_light_blue = new Color(173,216,230);
            this.setBackground(rgb_light_blue);
        }
            
    }

    private void nameandtimer(int key) throws InterruptedException {
        //Name is Printed in one Multi-Lined Label
       this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS)); 
       name = new JLabel("<html>Siva Pranav<br>Mandadi</html>");
       name.setAlignmentX(Component.CENTER_ALIGNMENT);
       name.setFont(new Font("Papyrus",Font.PLAIN,15));
       //Adding the Name Label to the Panel
       this.add(name);
       counter = new JLabel();
       counter.setFont(new Font("Papyrus",Font.PLAIN,15));
       counter.setAlignmentX(Component.CENTER_ALIGNMENT);
       //Adding the Counter Label to the Panel 
       this.add(counter);
       Thread t;
        t = new Thread(() -> {
            //Starting value is 0 if even or 9 if odd.
            try{
            if(key % 2 == 0){
                //Counter increasing from 0 to 9
           for(int i= 0; i <10; i++){
               counter.setText("" + i);
               Thread.sleep(1000);//This sleeps the Thread for a Second
               if(i == 9)
                   i = -1;
           }
       }
       else
           for(int j=9; j>=0 ; j--){
               //Counter Decreasing from 9 to 0
               counter.setText("" + j);
               Thread.sleep(1000);
               if(j == 0)
                   j = 10;
           }}
            catch(InterruptedException e){
                        System.out.print("There was an Exception in the Timer in " + P068_Mandadi_Panel.class.getName());
                        }
            
        });
       t.start();
       }
    
}


//Main Function to Execute
  /**
     * @param args the command line arguments
     */
/*    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new P068_Mandadi_Panel(5));
        frame.pack();
        frame.setVisible(true);
        }
*/
