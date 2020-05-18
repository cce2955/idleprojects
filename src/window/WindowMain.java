package window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import fibSequence.FibSequenceGui;

public class WindowMain extends JFrame implements ActionListener{
	private enum ProjectType{
		MAIN, DEBUG, FIB, VOWEL;
	}
	private static final long serialVersionUID = 1L;
	
	JTextArea t;
	JFrame f;
	JLabel label;
	JButton button;
	JPanel panel;
	JPanel mainPanel;
	JMenuBar mb;
	ProjectType projectType;
	FibSequenceGui fibGui = new FibSequenceGui();
	@SuppressWarnings("deprecation")
	
	public WindowMain(){
		
		f= new JFrame("Idle Programs");	
		panel = new JPanel(new GridLayout(1,0,5,0));
        button = new JButton("OK");
        label = new JLabel();
        mainPanel = new JPanel();
		try { 
            // Set metal look and feel 
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
  
            // Set theme to ocean 
            MetalLookAndFeel.setCurrentTheme(new OceanTheme()); 
        } 
        catch (Exception e) { 
        } 
  
        // Text component 
         t = new JTextArea("Welcome to my little project workspace, click on "
         		+ "a project to test stuff out");
  
        // Create a menubar 
        mb = new JMenuBar(); 
  
        // Create amenu for menu 
        JMenu m1 = new JMenu("Projects"); 
  
        // Create menu items 
        JMenuItem mi1 = new JMenuItem("Main"); 
        JMenuItem mi2 = new JMenuItem("Fibonacci Generator"); 
        JMenuItem mi3 = new JMenuItem("Vowel Counter"); 
        JMenuItem mi9 = new JMenuItem("Text Editor"); 
  
        // Add action listener 
        mi1.addActionListener(this); 
        mi2.addActionListener(this); 
        mi3.addActionListener(this); 
        mi9.addActionListener(this); 
  
        m1.add(mi1); 
        m1.add(mi2); 
        m1.add(mi3); 
        m1.add(mi9); 
  
        JMenuItem mc = new JMenuItem("close"); 
  
        mc.addActionListener(this); 
  
        mb.add(m1); 
 
        mb.add(mc); 
        mb.setSize(50, 10);
        
        f.setJMenuBar(mb);
        f.setSize(500, 500);
        
        panel.add(button);
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Hitting the OK button will sort the commands
				//by Enum then perform the necessary actions
				String input = e.getActionCommand();
				action(projectType);
				
			}
		});
        
        
        
        f.add(mainPanel); 
       
        f.show();
        label = new JLabel();
        
        mainPanel.add(t);
        mainPanel.add(panel, BorderLayout.SOUTH);
        
        
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 
	 public void actionPerformed(ActionEvent e) {
		  String s = e.getActionCommand();
		  switch(s) {
		  case "Main":
			  t.setText("Welcome to the Main Menu");
			  action(ProjectType.MAIN);
			  break;
		  case "Fibonacci Generator":
			  action(ProjectType.FIB);
			  break;
		  case "Vowel Counter":
			  action(ProjectType.VOWEL);
			  t.setText("Vowel Counter");
			  break;			
		  default:
			  t.setText("Welcome to the Main Menu");
			  break;
			  
		  }
	    }
	 
	 public void action(ProjectType type) {
		 switch(type) {
		 case MAIN:
			 System.out.println("Hit main");
			 break;
		 case FIB:
			 fibGui.test();
			 break;
		 case VOWEL:
			 System.out.println("Vowel");
			 break;
		 default:
			 System.out.println("Still getting there");
		 }
		
	 }
}
