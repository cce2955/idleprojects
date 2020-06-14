package budgetCalculator;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class BudgetGUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f = new JFrame();
	JTextArea mainTextArea = new JTextArea(5, 40), 
	resultsArea = new JTextArea();
	Container c = new Container();
	JPanel combopanel = new JPanel();
	JPanel textPanel = new JPanel();
	JPanel monthPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JButton depositButton = new JButton("Deposit Money");
	JButton okButton = new JButton("Ok");
	JButton firstMonthButton = new JButton("Select First Month");
	JButton secondMonthButton = new JButton("Select Second Month");
	JButton resetButton = new JButton("Reset");
	JComboBox<String> monthCB = new JComboBox<>();
	BudgetCalculator calc = new BudgetCalculator();
	String[] months = {"January", "February", "March", "April",
			"May", "June", "July", "August", "September", "October",
			"November", "December"};
	
	@SuppressWarnings("deprecation")
	public BudgetGUI(){
		f = new JFrame("Budget Calculator");
		okButton.setVisible(false);
		resetButton.setVisible(false);
		mainTextArea.setWrapStyleWord(true);
		firstMonthButton.setVisible(false);
		secondMonthButton.setVisible(false);
		mainTextArea.setText("How much have you deposited this month");
		monthCB.setVisible(false);
		try {  
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");  
            MetalLookAndFeel.setCurrentTheme(new OceanTheme()); 
        } 
        catch (Exception e) { 
        }
		
		
		depositButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String deposit = mainTextArea.getText();
				try {
					calc.earningsThisMonth(Double.valueOf(deposit));
					mainTextArea.setText(
							deposit + " has been added to your account, "
							+ calc.choice());
					resultsArea.setText("Select your first month");
					monthCB.removeAllItems();
					monthCB.setVisible(true);
					for (int i = 0; i < calc.getArr().size(); i++) {
						int x = i;
						monthCB.addItem(months[x]);
						if(i > 1 && i % 12 == 0) {
							x = 0;
						}
						x++;
					}
					firstMonthButton.setVisible(true);
					secondMonthButton.setVisible(true);
					resetButton.setVisible(true);
				}catch (NumberFormatException ex) {
					mainTextArea.setText("That's not a valid number, please "
							+ "try again");
				}
				
			}
		});
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!calc.getPrimaryMonth().isEmpty()
						&& !calc.getPrimaryMonth().isEmpty()) {
				mainTextArea.setText(
						calc.showEarningsPerTwoMonths(calc.getPrimaryMonth(), 
								calc.getSecondaryMonth()));
				}
				
			}
		});
		
		firstMonthButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = String.valueOf(monthCB.getSelectedItem());
				try {
					if(calc.getPrimaryMonth().isEmpty()) {
						calc.getPrimaryMonth();
					}
					
				}catch (NullPointerException ex) {
					calc.setPrimaryMonth(input);
					checkMonths();
				}
			}
		});
		
		secondMonthButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = String.valueOf(monthCB.getSelectedItem());
				try {
					if(calc.getSecondaryMonth().isEmpty()) {
						calc.setSecondaryMonth(input);
					}
				}catch (NullPointerException ex) {
					calc.setSecondaryMonth(input);
					checkMonths();
				}
				
			}
		});
		
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calc.resetMonths();
				okButton.setVisible(false);
				firstMonthButton.setVisible(false);
				secondMonthButton.setVisible(false);
				resultsArea.setVisible(false);
				monthCB.setVisible(false);
				
			}
		});
		textPanel.add(mainTextArea);
		buttonPanel.add(depositButton);
		buttonPanel.add(okButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(firstMonthButton);
		buttonPanel.add(secondMonthButton);
		monthPanel.add(resultsArea);
		combopanel.add(monthCB);
		c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(monthPanel);
		c.add(combopanel);
		c.add(textPanel);
		c.add(buttonPanel);
		
		//Frame setup
		f.add(c);
		f.setSize(500, 500);
		f.show();

	}
	public void checkMonths() {
		try {
			if(!calc.getPrimaryMonth().isEmpty()
					&& !calc.getSecondaryMonth().isEmpty()) {
				okButton.setVisible(true);
			}
		} catch (NullPointerException e) {
			
		}
	}
}
