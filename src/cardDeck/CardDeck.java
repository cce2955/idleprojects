package cardDeck;

import java.awt.Window.Type;
import java.util.ArrayList;
import cardDeck.Card.Face;
import cardDeck.Card.Suit;

public class CardDeck {
	
	private ArrayList<Card> deck;
	private ArrayList<Card> usedDeck;
	private int exist = 0;
	
	public ArrayList<Card> makeFullDeck(){
		ArrayList<Card> cards = new ArrayList<>();
		int id = 0;
		for (int i = 1; i < 13; i++) {
			id++;//Id needs to increment so we're just gonna do 
			//this. I think I have an alternative way to work this out
			//but eh, this works for now.
			cards.add(new Card(id, i, Suit.HEART, Face.EMPTY));
			id++;
			cards.add(new Card(id, i, Suit.DIAMOND, Face.EMPTY));
			id++;
			cards.add(new Card(id, i, Suit.SPADE, Face.EMPTY));
			id++;
			cards.add(new Card(id, i, Suit.CLUB, Face.EMPTY));
		}
		
		cards.forEach(card ->{
			if(card.getNum() == 1){
				card.setFace(Face.ACE);			}
			if(card.getNum() == 10) {
				card.setFace(Face.JACK);
			}
			if(card.getNum() == 11) {
				card.setFace(Face.QUEEN);
			}
			if(card.getNum() == 12) {
				card.setFace(Face.KING);
			}
		});
		cards.add(new Card(id, 0, Suit.EMPTY, Face.JOKER));
		setDeck(cards);
		
		return getDeck();
	}
	
	
	private boolean doesCardExist (String input, String cardSuit) {
		int num = Integer.valueOf(input);
		this.deck.forEach(card ->{
			System.out.println(card.getSuit());
			System.out.println(cardSuit.toUpperCase());
			System.out.println(input);
			System.out.println(card.getId());
			if(card.getId() == num) {
				if(card.getSuit().equals(cardSuit.toUpperCase())) {
						exist = 1;//If card matches deck, flag it for existence
					}
				}
		});
		if(exist == 1) {
			return true;
		}
		return false;//If card doesn't exist, it doesn't exist...
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public ArrayList<Card> pullFromDeck(String input,  String suit){
		int num = Integer.valueOf(input);
		if(doesCardExist(input.toUpperCase(), suit.toUpperCase())) {
			System.out.println("Card exists already");
			return this.deck;//If card exists, don't do anything
			//Gonna find some way to return this to user
		}else {
			this.deck.forEach(card ->{
				if(card.getId() == num && card.getSuit().equals(suit)) {
					System.out.println("No card found");
					usedDeck.add(card.getId(), card);
					deck.remove(card.getId());
					//If card doesn't exist, remove it from array and toss
					//it in used array
				}
			});
		}
		return deck;
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
	public ArrayList<Card> getUsedDeck() {
		return usedDeck;
	}

	public void setUsedDeck(ArrayList<Card> usedDeck) {
		this.usedDeck = usedDeck;
	}

}

