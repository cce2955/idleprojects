package window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import cardDeck.CardWindow;
import factorialRecursion.FactorialMain;
import fibSequence.FibSequenceGui;
import headTails.HeadTails;
import legacy.UserInput;
import numberName.NumberName;
import reverseString.ReverseString;
import textEditor.TextEditorMain;
import vowelChecker.VowelCheckerGui;



public class WindowMain extends JFrame implements ActionListener{
	private enum ProjectType{
		MAIN, DEBUG, FIB, VOWEL,TEXT, FACTORIAL,
		NUMNAME, HEADTAILS, REVERSE, CLOSE, CARDS;
	}
	
	private static final long serialVersionUID = 1L;
	
	//Declarations
	JTextArea t;
	JFrame f;
	Container c;
	JLabel label;
	JButton button, debugButton,
	headButton, tailButton, resetButton;
	JPanel panel, buttonPanel;
	JPanel mainPanel;
	JMenuBar mb;
	ProjectType projectType;
	FibSequenceGui fibGui = new FibSequenceGui();
	UserInput buttonInput = new UserInput();
	VowelCheckerGui vowelChecker = new VowelCheckerGui();
	FactorialMain factorial = new FactorialMain();
	NumberName numName = new NumberName();
	HeadTails headOrTails = new HeadTails();
	ReverseString reverse = new ReverseString();
	//---------------------------------------------------------------------
	@SuppressWarnings("deprecation")
	
	public WindowMain(){
		//Container
		c = getContentPane();
		c.setLayout(new FlowLayout());
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
        headButton = new JButton("Heads");
        tailButton = new JButton("Tails");
        resetButton = new JButton("Reset");
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
         panelGroup.add(headButton);
         panelGroup.add(tailButton);
         panelGroup.add(resetButton);  
         debugButton.setVisible(false);
         headButton.setVisible(false);
         tailButton.setVisible(false);
         resetButton.setVisible(false);
 		//---------------------------------------------------------------------
         // Create a menubar 
         mb = new JMenuBar(); 
 		//---------------------------------------------------------------------
        // Create a menu for menu 
        JMenu m1 = new JMenu("Projects"); 
        JMenu m2 = new JMenu("Cont.");
        JMenu m3 = new JMenu("etc.");
		//---------------------------------------------------------------------
        // Create menu items 
        JMenuItem mi1 = new JMenuItem("Main"); 
        JMenuItem mi2 = new JMenuItem("Fibonacci Generator"); 
        JMenuItem mi3 = new JMenuItem("Vowel Counter"); 
        JMenuItem mi9 = new JMenuItem("Text Editor");
        //Menu 2 items
        JMenuItem mi4 = new JMenuItem("Factorial Generator");
        JMenuItem mi5 = new JMenuItem("Number Name");
        JMenuItem mi6 = new JMenuItem("Heads or Tails?");
        JMenuItem mi7 = new JMenuItem("Reverse A String");
        //Menu 3 items
        JMenuItem miCard = new JMenuItem("Card Counter");
		//---------------------------------------------------------------------
        //---------------------------------------------------------------------
        JMenuItem mDebug = new JMenuItem("Debug");
        //---------------------------------------------------------------------
        
        // Add action listener 
        mi1.addActionListener(this); 
        mi2.addActionListener(this); 
        mi3.addActionListener(this); 
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);
        mi7.addActionListener(this);
        mi9.addActionListener(this);
        miCard.addActionListener(this);
        //---------------------------------------------------------------------
        mDebug.addActionListener(this);
        //---------------------------------------------------------------------
        m1.add(mi1); 
        m1.add(mi2); 
        m1.add(mi3); 
        m1.add(mi9);
        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);
        m2.add(mi7);
        m3.add(miCard);
		//---------------------------------------------------------------------
        //---------------------------------------------------------------------
        m1.add(mDebug);
        //---------------------------------------------------------------------
		//---------------------------------------------------------------------
        JMenuItem mc = new JMenuItem("Close"); 
		//---------------------------------------------------------------------
        mc.addActionListener(this); 
		//---------------------------------------------------------------------
        mb.add(m1); 
        mb.add(m2);
        mb.add(m3);
        mb.add(mc); 
        mb.setSize(50, 10);
		//---------------------------------------------------------------------
        f.setJMenuBar(mb);
        f.setSize(500, 500);
		//---------------------------------------------------------------------
		//---------------------------------------------------------------------
        //Action listener for OK button
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
		  case "Number Name":
			  projectType = ProjectType.NUMNAME;
			  action(projectType, null);
			  break;
		  case "Heads or Tails?":
			  projectType = ProjectType.HEADTAILS;
			  action(projectType, null);
			  break;
		  case "Debug":
			  projectType = ProjectType.DEBUG;
			  action(projectType, null);
			  break;
		  case "Close":
			  projectType = ProjectType.CLOSE;
			  action(projectType, null);
			  break;
		  case "Factorial Generator":
			  projectType = ProjectType.FACTORIAL;
			  action(projectType, null);
			  break;
		  case "Reverse A String":
			  projectType = ProjectType.REVERSE;
			  action(projectType, null);
		  case "Card Counter":
			  projectType = ProjectType.CARDS;
			  action(projectType, null);
			  break;
		  default:
			  t.setText("Welcome to the Main Menu");
			  break;
			  
		  }
	    }
	 
	 public void action(ProjectType type, String input) {
		 debugButton.setVisible(false);
		 headButton.setVisible(false);
		 tailButton.setVisible(false);
		 resetButton.setVisible(false);
		button.setVisible(true); 
		 
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
						 fibGui.fibGenerator(fibGui.getInputNum(), 
								 fibGui.getIterationNum());
						 t.setText("With a starting number of: " + 
						 fibGui.getInputNum() + " over an iteration of " 
								 + fibGui.getIterationNum() + " gives us: \n" 
								 + fibGui.getInputNum() + " " 
								 +	 fibGui.arrayToString());
						 
						fibGui.fibArray.clear();
						fibGui.setFirstVar(true);
					 }else {
						 fibGui.inputTwo(input);
					 }
				 }
				 
				 break;
			
			 case VOWEL:
					 try {
						 t.setText(vowelChecker.returnVowels(input)); 
					 }catch(NullPointerException e) {
						 t.setText("Input a string and I can count how many vowels "
							 		+ "are there.");
					 }
				 break;
				
			 case TEXT:
				@SuppressWarnings("unused") TextEditorMain textEdit = 
				new TextEditorMain(); 
				 break;
				 
			 case FACTORIAL:
				 if(!buttonInput.checkIfValidNumber(input)) {
					 t.setText("Input a number to find the factorial of.");
				 }
				 if(buttonInput.checkIfValidNumber(input)) {
					 t.setText("The factorial of " + input + " is: "+
				 factorial.factorialGeneration(input));
				 }
				 break;
				 
			 case NUMNAME:
				try {
					if (Integer.valueOf(input) < 999999999) {
						t.setText(String.join(" ", numName.findNum(input)));
					}
					else {
						t.setText("For now, let's try a number less than 1"
								+ " Billion");
					}
					
				}catch(NumberFormatException e) {
					t.setText("Please input a number and it'll "
							+ "be converted to English Letters (please no"
							+ "commas at the moment)");
				}
				break;
				
			 case HEADTAILS:
				 button.setVisible(false);
				 headButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						t.setText(headOrTails.flipCoin(true, false));
					}
				});
				 tailButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						t.setText(headOrTails.flipCoin(false, false));
						
					}
				});
				 resetButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						headOrTails.flipCoin(false, true);
						
						t.setText("Stats Reset");
					}
				});
				 headButton.setVisible(true);
				 tailButton.setVisible(true);
				 resetButton.setVisible(true);
				 break;
			 case REVERSE:
				 try {
					 t.setText(reverse.setReverseStringInput(input));
				 } catch (NullPointerException e) {
					 t.setText("Input a sentence and I'll reverse it");
				 }
				 	 
				 break;
			 case CARDS:
				 @SuppressWarnings("unused") CardWindow cards = new CardWindow();
				 break;
			 case DEBUG:	
				 debugButton.setVisible(true);
				 break;
				 
			 case CLOSE:
				 System.exit(0);
				 
			 default:
				 System.out.println("You have reached an unreachable area somehow");
		 }
		
	 }
	 
}
