package edu.asu.swing.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import edu.asu.swing.group1.Tab_1;
import edu.asu.swing.group2.Tab_2;
import edu.asu.swing.group3.Tab_3;
import edu.asu.swing.group4.Tab_4;
import edu.asu.swing.group5.Tab_5;

public class MainApplication extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6349067609212857100L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplication frame = new MainApplication();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					
					
					JTabbedPane jTabbedPane = new JTabbedPane();
					
					
					jTabbedPane.addTab("Tab 1", new Tab_1());
					jTabbedPane.addTab("Tab 2", new Tab_2());
					jTabbedPane.addTab("Tab 3", new Tab_3());
					jTabbedPane.addTab("Tab 4", new Tab_4());
					jTabbedPane.addTab("Tab 5", new Tab_5());
					
					
					frame.add(jTabbedPane);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		
	}

}
