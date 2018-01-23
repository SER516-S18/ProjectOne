import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author himanshudua
 */
public final class P027_Dua_Panel extends JPanel{
    
    private Name name;
    private JLabel counter;
    boolean flag = false;
    int count=9;
    
    
    
    public P027_Dua_Panel(int num){
        variable(num);
	name = new Name("Himanshu","Dua");
	counter = new JLabel();		
	setTimer();
	Box box = boxLabels();
	this.setBackground(getColor(num));
	this.add(box);
    }
    private void variable(int value){
        if(value%2 == 0)
            flag = true;
	if(flag)
            count=0;
    }
    /*
    Running the counter/timer that has to be displayed on panel
    the counter is rest when it reaches value 0 or 9
    */
    private void setTimer() {
	Timer timer = new Timer();
            try{
		TimerTask timerTask = new TimerTask(){
                    public void run(){
			setCounter(counter);
                        if(flag){
                            count+=1;
                            count = count > 9 ? 0 : count;
			}
                        else {
                            count-=1;
                            count = count < 0 ? 9 : count;
			}
                    }
		};
	timer.scheduleAtFixedRate(timerTask, 1000, 1000);
	}catch(Exception e){
	System.out.println("Exception occured : "+e);
    }
		
    }
    /*
    Returning the color for background on the basis of var color
    */
    private Color getColor(int color) {
		if(flag==true)
                    return Color.WHITE;
                return new Color(243, 255, 255, 255);
	}
   
	private void setCounter(JLabel counter) {
		counter.setText(Integer.toString(count));
		counter.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		counter.setFont(new Font("Papyrus",Font.BOLD,15));
	}
	
	private Box boxLabels(){
		Box box = Box.createVerticalBox();
		box.add(name.fname);
		box.add(name.lname);
		box.add(counter);
		return box;
	}
        /*
        First and last name labels that are to be added
        */
        class Name{
        JLabel fname;
        JLabel lname;
        
        Name(String first,String last){
            fname = new JLabel(first);
            lname = new JLabel(last);
            fname.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            lname.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            fname.setFont(new Font("Papyrus",Font.BOLD,15));
            lname.setFont(new Font("Papyrus",Font.BOLD,15));
        }
    }
    /*
        Main method for Testing
        */
    public static void main(String args[]){
        JFrame frame = new JFrame();
        P027_Dua_Panel panel = new P027_Dua_Panel(1);
        frame.add(panel);
        frame.setSize(100, 100);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
