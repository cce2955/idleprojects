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
	JPanel buttonPanel = new JPanel();
	JButton depositButton = new JButton("Deposit Card");
	JButton resetButton = new JButton("Reset");
	JComboBox<String> monthCB = new JComboBox<>();
	BudgetCalculator calc = new BudgetCalculator();
	String[] months = {"January", "February", "March", "April",
			"May", "June", "July", "August", "September", "October",
			"November", "December"};
	
	@SuppressWarnings("deprecation")
	public BudgetGUI(){
		f = new JFrame("Budget Calculator");
		mainTextArea.setWrapStyleWord(true);
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
				}catch (NumberFormatException ex) {
					mainTextArea.setText("That's not a valid number, please "
							+ "try again");
				}
				
			}
		});
		combopanel.add(monthCB);
		textPanel.add(mainTextArea);
		buttonPanel.add(depositButton);
		c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(combopanel);
		c.add(textPanel);
		c.add(depositButton);
		
		//Frame setup
		f.add(c);
		f.setSize(500, 500);
		f.show();

	}
}
