package window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import fibSequence.FibSequenceGui;
import textEditor.TextEditorMain;
import userInput.UserInput;
import vowelChecker.VowelCheckerGui;



public class WindowMain extends JFrame implements ActionListener{
	private enum ProjectType{
		MAIN, DEBUG, FIB, VOWEL,TEXT;
	}
	
	private static final long serialVersionUID = 1L;
	
	//Declarations
	JTextArea t;
	JFrame f;
	Container c;
	JLabel label;
	JButton button, debugButton;
	JPanel panel, buttonPanel;
	JPanel mainPanel;
	JMenuBar mb;
	ProjectType projectType;
	FibSequenceGui fibGui = new FibSequenceGui();
	UserInput buttonInput = new UserInput();
	VowelCheckerGui vowelChecker = new VowelCheckerGui();
	//---------------------------------------------------------------------
	@SuppressWarnings("deprecation")
	
	public WindowMain(){
		//Container
		c = getContentPane();
		c.setLayout(new BorderLayout());
		c.setBackground(Color.WHITE);
		//---------------------------------------------------------------------
		//Frame
		f= new JFrame("Idle Programs");
		//---------------------------------------------------------------------
		//Panel
		panel = new JPanel();
		mainPanel = new JPanel(new FlowLayout());
        buttonPanel = new JPanel(new FlowLayout());
		//---------------------------------------------------------------------
        //Button
        button = new JButton("OK");
        debugButton = new JButton("Test Button");
        debugButton.setVisible(false);
		//---------------------------------------------------------------------
        //Label
        label = new JLabel();
		//---------------------------------------------------------------------
		try { 
            // Set metal look and feel 
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
  
            // Set theme to ocean 
            MetalLookAndFeel.setCurrentTheme(new OceanTheme()); 
        } 
        catch (Exception e) { 
        } 
		//---------------------------------------------------------------------
//		//Setting backgrounds for debug purposes, comment when finished
//		//---------------------------------------------------------------------
//		panel.setBackground(Color.BLACK);
//		mainPanel.setBackground(Color.cyan);
//		buttonPanel.setBackground(Color.ORANGE);
		//---------------------------------------------------------------------

		// Text component 
         t = new JTextArea("Welcome to my little project workspace, click on "
         		+ "a project to test stuff out");
 		//---------------------------------------------------------------------
         //Button Panel         
         JPanel panelGroup = new JPanel();
         panelGroup.add(button);
         panelGroup.add(debugButton);
         debugButton.setVisible(false);
 		//---------------------------------------------------------------------
         // Create a menubar 
         mb = new JMenuBar(); 
 		//---------------------------------------------------------------------
        // Create a menu for menu 
        JMenu m1 = new JMenu("Projects"); 
		//---------------------------------------------------------------------
        // Create menu items 
        JMenuItem mi1 = new JMenuItem("Main"); 
        JMenuItem mi2 = new JMenuItem("Fibonacci Generator"); 
        JMenuItem mi3 = new JMenuItem("Vowel Counter"); 
        JMenuItem mi9 = new JMenuItem("Text Editor");
		//---------------------------------------------------------------------
        //---------------------------------------------------------------------
        JMenuItem mDebug = new JMenuItem("Debug");
        //---------------------------------------------------------------------
        
        // Add action listener 
        mi1.addActionListener(this); 
        mi2.addActionListener(this); 
        mi3.addActionListener(this); 
        mi9.addActionListener(this); 
        //---------------------------------------------------------------------
        mDebug.addActionListener(this);
        //---------------------------------------------------------------------
        m1.add(mi1); 
        m1.add(mi2); 
        m1.add(mi3); 
        m1.add(mi9);
		//---------------------------------------------------------------------
        //---------------------------------------------------------------------
        m1.add(mDebug);
        //---------------------------------------------------------------------
		//---------------------------------------------------------------------
        JMenuItem mc = new JMenuItem("close"); 
		//---------------------------------------------------------------------
        mc.addActionListener(this); 
		//---------------------------------------------------------------------
        mb.add(m1); 
        mb.add(mc); 
        mb.setSize(50, 10);
		//---------------------------------------------------------------------
        f.setJMenuBar(mb);
        f.setSize(500, 500);
		//---------------------------------------------------------------------
		//---------------------------------------------------------------------
        button.addActionListener(new ActionListener() {
    	//---------------------------------------------------------------------
		@Override
		public void actionPerformed(ActionEvent e) {
			//Hitting the OK button will sort the commands
			//by Enum then perform the necessary actions
			String input = t.getText();
		
			action(projectType, input.trim());
				
				}
			});        
		//---------------------------------------------------------------------
        f.show();
        label = new JLabel();
        c.add(t, BorderLayout.CENTER);
        c.add(panelGroup, BorderLayout.WEST);
        f.add(c);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 
	
	 public void actionPerformed(ActionEvent e) {
		  String s = e.getActionCommand();
		  switch(s) {
		  case "Main":
			  projectType = ProjectType.MAIN;
			  t.setText("Welcome to the Main Menu");
			  action(projectType, null);
			  break;
		  case "Fibonacci Generator":
			  projectType = ProjectType.FIB;
			  action(projectType, null);
			  break;
		  case "Vowel Counter":
			  projectType = ProjectType.VOWEL;
			  action(projectType, null);
			  break;
		  case "Text Editor":
			  projectType = ProjectType.TEXT;
			  action(projectType, null);
			  break;
		  case "Debug":
			  projectType = ProjectType.DEBUG;
			  action(projectType, null);
			  break;
		  default:
			  t.setText("Welcome to the Main Menu");
			  break;
			  
		  }
	    }
	 
	 public void action(ProjectType type, String input) {
		 
		 if(!type.equals(ProjectType.DEBUG)){
			 debugButton.setVisible(false);
		 }
		 switch(type) {
		 
		 case MAIN:
			 System.out.println("Hit main");
			 break;
		
			 
		 case FIB:
			 fibGui.setFirstVar(true);
			 if(fibGui.isFirstVar()) {
			 t.setText("I'm going to generate a Fibonacci Sequence, \n"
			 		+ " please input the number you wish to iterate over");
			 fibGui.inputOne(input);
			 }
			 if(!fibGui.isFirstVar()) {
				 t.setText("How many iterations do you require?");
				 if(fibGui.getInputNum() != 0 && fibGui.getIterationNum() !=0) {
					 fibGui.fibGenerator(fibGui.getInputNum(), fibGui.getIterationNum());
					 t.setText("With a starting number of: " + fibGui.getInputNum() +
							 " over an iteration of " + fibGui.getIterationNum() +
							 " gives us: \n" + fibGui.getInputNum() + " " +
							 fibGui.arrayToString());
					 
					fibGui.fibArray.clear();
					fibGui.setFirstVar(true);
				 }else {
					 fibGui.inputTwo(input);
				 }
			 }
			 
			 break;
		
		 case VOWEL:
			 if(!vowelChecker.isValidInput()) {
				 t.setText("Input a string and I can count how many vowels are "
							+ "there.");
				 vowelChecker.setValidInput(true);
			 }

			 if(vowelChecker.isValidInput()) {
				 t.setText(vowelChecker.returnVowels(input));
				 
			 }
		 case TEXT:
			TextEditorMain textEdit = new TextEditorMain(); 
			 break;
		 case DEBUG:
			 debugButton.setVisible(true);
			 break;
			
		 default:
			 System.out.println("You have reached an unreachable area somehow");
		 }
		
	 }
	 
}
