import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;




public class P007_Bao_Panel extends JPanel implements Runnable{
	public int height = 100;           //define height of label
	public int wide = 100;             //define wide of label
	int count = 0;						//timer
	JPanel main = new JPanel(); 		//create a panel
	JLabel name = new JLabel("<html><body>"+"Zelin"+"<br>"+"Bao"+"</html>",JLabel.CENTER);    //create a name label	
	JLabel number = new JLabel("testing",JLabel.CENTER);										//create a timer label
	private boolean input = false;		//decide increasing or decreasing
	
	
	public P007_Bao_Panel(int num) {
		//set font of labels
	    number.setFont(new Font("Rockwell", 1, 30));	
		name.setFont(new Font("Rockwell", 1, 30));		
		
		
		//set panel
		setSize(height,wide);
		setLayout(new BorderLayout());
		add(name, BorderLayout.NORTH);
		add(number,BorderLayout.SOUTH);
		setBackground(new Color(224, 255, 255));
		
		//decide input
		if(num%2 == 0){
			input = true;
			setBackground(Color.WHITE);
		}
		
	}
	
	
	public void run(){
		try{
			
			if(input){		//increasing
				int i = 0;
			
				while(i <= 9){
					String iValue = String.valueOf(i);
					number.setText(iValue);
					Thread.sleep(1000);
					i++;
					if(i > 9)	i = 0;
					
				 }
		
			}
			else{		//decreasing
				int i = 9;
				while(i >= 0){
					String iValue = String.valueOf(i);
					number.setText(iValue);
					Thread.sleep(1000);
					i--;
					if(i < 0)	i = 9;
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args){
		//test 
		JFrame jf = new JFrame();	//create a frame
		P007_Bao_Panel p = new P007_Bao_Panel(1);	
		new Thread(p).start();	
		jf.setSize(800,800);
		jf.setVisible(true);
		jf.add(p);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
