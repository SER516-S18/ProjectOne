import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class P071_Avinash_Panel{
	/*
	 * This class implements a 100*100 JPanel with three JLabels viz, Firstname, Lastname and 
	 * a counter thread which counts 0-9 increment or decrement depending on the number passed to class. 
	 * 
	 */
	private JPanel p;
	private JLabel firstname; 
	private JLabel lastname;
	private JLabel count;
	private boolean even;
	
	//constructor.
	public P071_Avinash_Panel(int num) {
		/* params: number 
		 * return: None 
		 * Description: sets boolean even to true if param num is even.
		 */
		if(num%2!=0)
			even=false;
		else
			even=true;
	}

	public JPanel P071_Avinash_Panel() {
		/* params: None 
		 * return: JPanel object 
		 * Description: Populates JPanel with three JLabels arranged in Y_axis.
		 */
		
		//setting up JPanel.
		p=new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		if(even==false)
			p.setBackground(new Color(51,204,255));
		else
			p.setBackground(Color.white);
		
		p.setPreferredSize(new Dimension(100,100));
		p.setMaximumSize( p.getPreferredSize() );
		
		//setting up JLabel
		firstname=new JLabel(" Avinash");
		lastname= new JLabel(" Mathad Vijayakumar");
		count=new JLabel();
		p.add(firstname);
		p.add(lastname);
		p.add(count);
		p.setVisible(true);
		
		
		//setting up counter. 
		if(even==true) 
			P071_Avinash_TimerIncrement();
		else
			P071_Avinash_TimerDecrement();
		
		return p;
	}
	
	
	public void P071_Avinash_TimerIncrement() {
		/* params: None 
		 * return: None. 
		 * Description: Thread. Starts the thread and counts from 0-9.
		 */
		new Thread() {
	        int counter = 0;
	        public void run() {
	            while(true) {
	            		if(counter==10)
	            			counter=0;
	            		
	                count.setText(" " + (counter));
	                counter++;
	                try{
	                    Thread.sleep(1000);
	                } catch(Exception e) {}
	            }
	        }
	    }.start();
	}//end or function. 
	
	
	public void P071_Avinash_TimerDecrement() {
		/* params: None 
		 * return: None. 
		 * Description: Thread. Starts the thread and counts from 9-0.
		 */
		new Thread() {
	        int counter = 9;
	        public void run() {
	            while(true) {
	            		if(counter==-1)
	            			counter=9;
	                count.setText(" " + (counter));
	                counter--;
	                try{
	                    Thread.sleep(1000);
	                } catch(Exception e) {}
	            }
	        }
	    }.start();
	}//end or function. 
	
	
	public static void main(String[] args) {
		/*
		 * params: None 
		 * return: None. 
		 * Description: This is for testing. 
		 */
		
		P071_Avinash_Panel ob= new P071_Avinash_Panel(5);
		JPanel p=ob.P071_Avinash_Panel();
		JFrame f=new JFrame("Simple Window");
		//f.setSize(800,800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(p);
		f.pack();
		//f.add(p);
		f.setVisible(true);
	}
}