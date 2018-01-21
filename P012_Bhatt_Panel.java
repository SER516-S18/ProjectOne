import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * 
 * @author vihar bhatt
 * 
 */
public class P012_Bhatt_Panel extends JPanel
{
	JLabel name;
	JLabel counter;
	Timer timer;
	int count;
	int flag;
	Border border;
	
	/**
	 * 
	 * @param value - the value determines the background color of panel and increment/decrement of counter
	 */
	public P012_Bhatt_Panel(int value)
	{
		border=BorderFactory.createLineBorder(Color.black);
		setBackgroundProperties(value);

		name=new JLabel("<html>Vihar<br>Bhatt</html>");
		name.setBounds(0,0,100,50);
		name.setHorizontalAlignment(JLabel.CENTER);
		name.setBorder(border);
		name.setFont(new Font("Papyrus",Font.PLAIN,18));

		counter.setBounds(0,50,100,50);
		counter.setHorizontalAlignment(JLabel.CENTER);
		counter.setBorder(border);
		counter.setFont(new Font("Papyrus",Font.PLAIN,18));

		setPreferredSize(new Dimension(100,100));
		setBorder(border);
		setLayout(null);

		add(name);
		add(counter);

		timer=new Timer(1000, new CounterListener());
		timer.start();
	}
	
	/**
	 * 
	 * @param value - use to set the background color and flag for timer
	 */
	private void setBackgroundProperties(int value)
	{
		try
		{
			if((value%2)==0)
			{
				counter=new JLabel("0");
				setBackground(Color.white);
				count=0;
			}
			else
			{
				counter=new JLabel("9");
				setBackground(new Color(135,206,250));
				flag=1;
				count=9;
			}
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @author vihar bhatt
	 *
	 */
	private class CounterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				counter.setText(String.valueOf(count));
				if(flag==0)
				{
					if(count!=9)
					{
						count++;
					}
					else
					{
						count=0;
					}
				}
				else
				{
					if(count!=0)
					{
						count--;
					}
					else
					{
						count=9;
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}
}