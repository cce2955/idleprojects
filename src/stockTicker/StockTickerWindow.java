package stockTicker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import org.apache.http.client.ClientProtocolException;

public class StockTickerWindow extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f = new JFrame();
	JTextArea stockQueryArea =
			new JTextArea("Enter a stock symbol here"), 
	resultsArea = new JTextArea();
	Container c = new Container();
	JPanel combopanel = new JPanel();
	JPanel textPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JButton button = new JButton("Find Stock");
	JButton findValue = new JButton ("OK");
	StockTicker ticker = new StockTicker();
	JComboBox<String> stockCB = new JComboBox<>();
	String keys[];
	String values[];
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	
	@SuppressWarnings("deprecation")
	public StockTickerWindow() {
		f= new JFrame("Stock Query");
		findValue.setVisible(false);
		//Button action listener
		//----------------------------------------------
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = stockQueryArea.getText();
				HashMap<String, String> symbolResult = new HashMap<>();
				
				try {
					symbolResult.putAll(ticker.getStock(input));
					keys = new String[symbolResult.size()];
					values = new String[symbolResult.size()];
					stockCB.removeAll();
					int index = 0;
					for (HashMap.Entry<String, String> mapEntry : symbolResult.entrySet()) {
						stockCB.addItem(mapEntry.getKey());
						keys[index] = mapEntry.getKey();
						values[index] = mapEntry.getValue();
						index++;
					}
					findValue.setVisible(true);
				} catch (ClientProtocolException ex) {
					
					stockQueryArea.setText(
							"Not a valid symbol, try again");
					ex.printStackTrace();
				} catch (IOException ex) {
					stockQueryArea.setText(
							"Not a valid symbol, try again");
					ex.printStackTrace();
				} catch (IllegalArgumentException ex) {
					stockQueryArea.setText(
							"Not a valid symbol, try again");
					ex.printStackTrace();
				}
				
			}
		});
		//---------------------------------------------
		findValue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String symbol = String.valueOf(stockCB.getSelectedItem());
				for(int i = 0; i < values.length; i++) {
					if(keys[i].equals(symbol)) {
						resultsArea.setText(values[i]);
					}
				}
			}
		});
		//---------------------------------------------
		try { 
            // Set metal look and feel 
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
  
            // Set theme to ocean 
            MetalLookAndFeel.setCurrentTheme(new OceanTheme()); 
        } 
        catch (Exception e) { 
        } 
		
		
		
		combopanel.add(stockCB);
		textPanel.add(stockQueryArea);
		textPanel.add(resultsArea);
		buttonPanel.add(button);
		buttonPanel.add(findValue);
		c = getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);
		c.add(combopanel, BorderLayout.NORTH);
		c.add(textPanel,  BorderLayout.CENTER);
		c.add(buttonPanel);
		//Frame setup
		f.add(c);
		
		f.setSize(500, 500);
	    f.show();

	}

	
	
		

}
