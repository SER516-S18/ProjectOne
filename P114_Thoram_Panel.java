import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class P114_Thoram_Panel extends JPanel {
    /**
     * 
     */
	//string name variable to add name to the JLabel name
	public static final String name_panel = "<html>RaviThoram</html>";
	//JLabel that which need to be displayed in the panel
    JLabel name;
    JLabel counter;
    private static final long serialVersionUID = 1L;
    //count to hold the global count value
    public static int count;
    //boolean useful to configure the panel environment 
    boolean conf;
    //constructor that decides the values of configuration variables(conf,count) based on input type
    public P114_Thoram_Panel(int inp) {
        if(inp%2==0)    
        {
            conf=true;
            count=0;
        }
        else
        {
            conf=false;
            count=9;
        }
        set_bg_counter();
    }
    public P114_Thoram_Panel get_object()
    {
    	//returning an instance of class
        return this;
    }
    public void set_bg_counter() {
    	//setting dimensions for the panel
        this.setPreferredSize(new Dimension(100, 100));
        if(conf)
            this.setBackground(Color.WHITE); //even input white background
        else{
            Color blue = new Color(173,216,230); //blue color 
            this.setBackground(blue);//odd input blue color
        }
        //setting up name label with font and size
        name = new JLabel(name_panel);
        name.setFont(new Font("Papyrus",Font.PLAIN,18));
        this.add(name); // adding name label to panel
        //setting and initialing counter label
        counter = new JLabel(String.valueOf(count));
        counter.setFont(new Font("Papyrus",Font.PLAIN,18));
        this.add(counter); //adding counter label to panel
        //try catch to handle timer increments
        try
        {
        new Timer(1000 ,new ActionListener()
        {
            
            public void actionPerformed(ActionEvent arg0) {
                int temp_val = Integer.parseInt(counter.getText());
                //System.out.println("hello!!");
                if(conf)
                {
                    if(temp_val==9)
                    {
                        temp_val=0;
                    }
                    else
                    {
                        temp_val++;
                    }
                }
                else
                {
                    if(temp_val==0)
                    {
                        temp_val=9;
                    }
                    else
                    {
                        temp_val--;
                    }
                }
                counter.setText(String.valueOf(temp_val));
            }
            
        }).start();
        }
        catch(Exception e)
        {
        	//printing stack trace in case of exception
            e.printStackTrace();
        }
        
    }
        

    /**
     * @param args
     */
   /* public static void main(String[] args) {
        // TODO Auto-generated method stub
        SwingUtilities.invokeLater(new Runnable() {
 
        public void run() { JFrame test = new JFrame();
        test.add(new P114_Thoram_Panel(22).get_object());
        test.setVisible(true);
        test.setSize(100, 100); } });

    }*/
}