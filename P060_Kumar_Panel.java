import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Abhishek
 * 
 * Description-This class helps in creating a panel
 *
 */
public class P060_Kumar_Panel extends JPanel{

	private JPanel p;

	private JLabel firstName;
	private JLabel lastName;
	private JLabel displayNum;
	private Color backColor;


	/**Description - Constructor
	 * @param numInput- number input for checking the color
	 */
	public P060_Kumar_Panel(int numInput)
	{		

		//checking if input number is  even or odd
		if(numInput%2==0) {
			backColor=Color.WHITE;
		}else
		{			
			backColor=new Color(173,216,230);
		}
		
	}
	
	
	/**
	 * @param numInput - number input for checking the color
	 */
	public JPanel createPanel(int numInput)
	{
		
		try {
			this.p=new JPanel(); //creating object of new panel

			//setting the attributes
			this.p.setSize(100, 100);
			this.p.setBackground(backColor);

			
			
			//setting the Jlabels
			this.firstName=new JLabel("Abhishek");
			this.lastName=new JLabel("Kumar");
			
			this.firstName.setFont(new Font("Papyrus ", Font.PLAIN, 15));
			this.lastName.setFont(new Font("Papyrus ", Font.PLAIN, 15));
			

			//initialising the Jlabel for changing digit
			displayNum=new JLabel();
			this.displayNum.setFont(new Font("Papyrus ", Font.PLAIN, 15));

			//setting the Timer to change the digit every second
			Timer t = new javax.swing.Timer(1000, new ActionListener(){

				 int counter1=-1;
					int counter2=10;

				String num;

				@Override
				public void actionPerformed(ActionEvent e){

					//logic for changing digit
					
					if(numInput%2==0) {
					counter1++;
					num=String.valueOf(counter1);
					displayNum.setText(num);

					if(counter1>8)
					{counter1=-1;}
					}
					
					else {
						counter2--;
					num=String.valueOf(counter2);
					displayNum.setText(num);

					if(counter2<1)
					{counter2=10;}
					}
				}
			});
			
			t.start();	

			//initialising the panel
			this.p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			this.p.add(this.firstName);
			this.p.add(this.lastName);
			this.p.add(this.displayNum);


		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	
	/**Main method--Uncomment the main method for testing
	 * @param args
	 */
/*	public static void main(String args[])
	{
	
		JFrame jFrame = new JFrame();



    	jFrame.setContentPane(new P060_Kumar_Panel(1).createPanel(1));


    	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    	jFrame.pack();



    	jFrame.setVisible(true);



    	jFrame.pack();



		}*/
}
