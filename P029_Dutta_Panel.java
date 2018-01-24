/* SER 516 Lab 01 Group 2 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class P029_Dutta_Panel extends JPanel{ //Class for creating individual panels

	int count;
    private JLabel firstname = new JLabel("Ananya", JLabel.CENTER);
    private JLabel lastname = new JLabel("Dutta", JLabel.CENTER);
    private JLabel dNum = new JLabel("0", JLabel.CENTER);

    public P029_Dutta_Panel(int i) { //Constructor for setting the background color and timer.
    	
    	Color backColor;
    	if(i%2 == 0) // Checks for even or odd and set background color.
    	{
    		backColor = Color.WHITE;
    		this.count = 0;
       	}
    	else
    	{
    		Color color = new Color(173,216,230);
    		backColor = color;
    		this.count = 9;
    	}
    	try {
    		createPanel(backColor);
    		Timer t = new Timer(1000, new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) // Checks for even or odd and sets timer accordingly.
				{
					if(i%2 == 0)
					{
						if(count < 9)
							count ++;
						else
							count =0;
						dNum.setText(""+String.valueOf(count));
						
					}
					else
					{
						if(count > 0)
							count --;
						else
							count = 9;
						
						dNum.setText(""+String.valueOf(count));
					}
				}
			});
    		t.start();
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    	
         
    }
    
    public void createPanel(Color color) throws Exception  // method for adding the different labels in the panel
    {
    	this.setBackground(color);
    	
    	//Setting font to Papyrus and font size 10
    	firstname.setFont(new Font("Papyrus",Font.PLAIN,10));
    	lastname.setFont(new Font("Papyrus",Font.PLAIN,10));
    	dNum.setFont(new Font("Papyrus",Font.PLAIN,10));
    	this.add(firstname);
    	this.add(lastname);
    	
    	//Aligning the different labels
    	firstname.setAlignmentX(Component.CENTER_ALIGNMENT);
    	lastname.setAlignmentX(Component.CENTER_ALIGNMENT);
    	dNum.setAlignmentX(Component.CENTER_ALIGNMENT);
    	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    	
    	this.add(dNum);
    	this.setSize(100, 100);
    }
    
    /*public static void main(String[] args)
    {
    	JFrame frame  = new JFrame(" test ");
    	P029_Dutta_Panel p = new P029_Dutta_Panel(2);
    	frame.add(p.panel);
    	frame.setSize(800,800);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.pack();
    	frame.setVisible(true);

    } */
    
}
