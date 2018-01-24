import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/*
 * This file creates a JPanel with the name of the author.
 * A counter is displayed which increments or decrements from 0 to 9 / 9 - 0.
 * Counter and Background color changes according to the input passed to the constructor. 
 * 
 * @author Aayushi Mehulbhai Shah
 * @version 1.0
 */

public class P099_Shah_Panel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public static int counter = 0;

    private JLabel Name; //Label to display the name in the panel
    private JLabel Counter; //Label to display the counter value in the panel 
    private boolean Id; //Boolean parameter to check the input value is odd or even
    public final static Color Light_Blue = new Color(173,216,230);
    
    /**
	 * The parameterized constructor that initializes the counter value according to the input value
	 * 
	 * @param value
	 *            The input value to the constructor according to which the background color 
	 *            and counter is displayed
	 */
    
    public P099_Shah_Panel(int value) {
        if(value%2==0)
        {
        	Id=true;
            counter=-1;
        }
        else
        {
        	Id=false;
            counter=10;
        }
        set_Background(Id);
    }
    
    /**
	 * This function sets the properties of the JPanel and the counter's value ranges from 0 to 9
	 * depending on the value received by the constructor.
	 */
    public void set_Background(boolean ID) {
    	setSize(100,100); //Size of the panel is set
      
    	//Background set to White if ID is even or set to Blue if ID is odd
    	if(ID)
    		setBackground(Color.white);
    	else
    		setBackground(Light_Blue);
        
    	Name = new JLabel("<html>Aayushi<br>Shah</html>",SwingConstants.CENTER); //Name to be displayed in panel is initialized to the Label Name
        Name.setFont(new Font("Papyrus", Font.PLAIN, 15)); //Font and TextSize of the name displayed is set
        add(Name);//Label Name is added to the panel
        
      
        Counter = new JLabel(String.valueOf(counter),SwingConstants.CENTER); //Counter value set according to the ID is initialized to the Label Counter
        Counter.setFont(new Font("Papyrus", Font.PLAIN, 15)); //Font and TextSize of the counter displayed is set
        
        add(Counter);//Label Counter is added to the panel
        
        //Set properties of JPanel
      	setBounds(0, 0, 100, 100);//Size of the panel is changed
      	setLayout(new GridLayout(2,0));//grid layout with two rows and zero columns is created and set as the layout for the panel
        
      	//Timer class used to monitor the increment/decrement of the counter
      	//Specified between the try and catch to avoid runtime errors
        try {

            TimerTask oneSecondTask = new TimerTask()
            {
                public void run()
                {
                	//If ID is even the counter would increment from 0 to 9
                    if(ID)
                    {
                        counter++;
                        counter = counter%10;
                    }
                    //If ID is even the counter would increment from 9 to 0
                    else
                    {
                    	//Counter value is checked as it's value should not go below 0 
                    	//When the value is negative, it is set back again to 9
                        if(counter>0)
                        {
                        	counter--;
                            counter = counter%10;
                        }
                        else
                            counter=9;
                    }
                    //Updated value of counter is assigned to Label Counter for display
                    Counter.setText(String.valueOf(counter));
                }
            };

            Timer timer = new Timer();
            long delay = 5L; //the counter would be displayed after the delay time is over
            long intervalPeriod = 1000L;//counter increases after every one second
            timer.scheduleAtFixedRate(oneSecondTask, delay, intervalPeriod);//scheduled to increment the counter according to the specified delay and interval

        } catch(Exception e)
        {
            e.printStackTrace();//Runtime Errors are printed
        }
    }
    
    //Main Method to Execute the function
    /*
    public static void main(String[] args) {

    	JFrame jFrame = new JFrame();
        jFrame.setVisible(true);//Visibility of the Frame is set
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        P099_Shah_Panel p099_Shah_panel = new P099_Shah_Panel (99);
        jFrame.getContentPane().add(p099_Shah_panel);//Panel added to the frame
        jFrame.pack();
    }*/
}

