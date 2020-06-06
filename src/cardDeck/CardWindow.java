package cardDeck;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class CardWindow extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Jframe declarations
	JFrame f = new JFrame();
	JTextArea mainTextArea = new JTextArea(), 
	resultsArea = new JTextArea();
	Container c = new Container();
	JPanel combopanel = new JPanel();
	JPanel textPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JButton drawButton = new JButton("Draw Card");
	JButton resetButton = new JButton("Reset");
	CardDeck deck = new CardDeck();
	//Combobox declaration
	String[] numbers = { "Ace", "2","3",
			"4","5","6","7","8",
			"9","10","Jack","Queen","King"
	};
	String[] suit = {"Heart","Diamond","Club","Spade"};
	JComboBox<String> numberCB = new JComboBox<>(numbers);
	JComboBox<String> suitCB = new JComboBox<>(suit);
	
	@SuppressWarnings("deprecation")
	public CardWindow() {
		f = new JFrame("Card Counter");
		try {  
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");  
            MetalLookAndFeel.setCurrentTheme(new OceanTheme()); 
        } 
        catch (Exception e) { 
        } 
		combopanel.add(numberCB, BorderLayout.EAST);
		combopanel.add(suitCB, BorderLayout.WEST);
		textPanel.add(mainTextArea, BorderLayout.NORTH);
		textPanel.add(resultsArea, BorderLayout.SOUTH);
		buttonPanel.add(drawButton);
		buttonPanel.add(resetButton);
		
		mainTextArea.setText("Choose a card and I'll draw it from"
				+ "the deck");
		
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> resultsDeck = new ArrayList<>();
				deck.makeFullDeck();
				mainTextArea.setText("Deck reset");
				resultsArea.setText("cards remaining: \n " 
						+ deck.getDeck().size());
				
				deck.getDeck().forEach(card ->{
					if(card.getNum() != 1 &&
							card.getNum() <= 11 ) {
						resultsDeck.add(card.getNum() + " "
								+ card.getSuit());
					} else {
						resultsDeck.add( card.getFace() + " "
								+ card.getSuit());
					}
					if(card.getNum() == 0) {
						resultsDeck.add(card.getFace().toString());
					}
				});
				resultsDeck.remove(resultsDeck.size() - 2);
				//0 EMPTY gets added, I could remove it normally but 
				//I'm kind of done debugging this stupid array
				
				//Reset deck, should give you a full deck plus one joker
			}
		});
		
		drawButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String suit = String.valueOf(suitCB.getSelectedItem());
				String num = String.valueOf(numberCB.getSelectedItem());
				if(deck.doesCardExist(num, suit)) {
					mainTextArea.setText("Card " + num + " of " + suit + "s "
							+ "has been drawn");
					resultsArea.setText("cards remaining: \n " 
							+ deck.getDeck().size());
				}else {
					mainTextArea.setText("Card has already been drawn");
					
					
				}
				
			}
		});
		//Container setup
		deck.makeFullDeck();//Initialize a deck 
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
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
