package cardDeck;

import java.util.ArrayList;
import cardDeck.Card.Face;
import cardDeck.Card.Suit;

public class CardDeck {
	
	private ArrayList<Card> deck;
	private ArrayList<Card> usedDeck;
	private boolean exist;
	private boolean change;
	private int cardId;	
	private int number;

	public ArrayList<Card> makeFullDeck(){
		//Create two decks, one with all the cards
		//Another deck to dump used cards into
		ArrayList<Card> cards = new ArrayList<>();
		ArrayList<Card> usedCard = new ArrayList<>();
		//Clear the array if deck has to be rebuilt
		cards.clear();
		usedCard.clear();
		
		int id = 0;
		for (int i = 1; i < 14; i++) {
			id++;//Id needs to increment so we're just gonna do 
			//this. I think I have an alternative way to work this out
			//but eh, this works for now.
			cards.add(new Card(id, i, Card.Suit.HEART, Face.EMPTY));
			id++;
			cards.add(new Card(id, i, Suit.DIAMOND, Face.EMPTY));
			id++;
			cards.add(new Card(id, i, Suit.SPADE, Face.EMPTY));
			id++;
			cards.add(new Card(id, i, Suit.CLUB, Face.EMPTY));
		}
		//After assigning the cards, give cards 1,11,12,13 faces
		cards.forEach(card ->{
			if(card.getNum() == 1){
				card.setFace(Face.ACE);			}
			if(card.getNum() == 11) {
				card.setFace(Face.JACK);
			}
			if(card.getNum() == 12) {
				card.setFace(Face.QUEEN);
			}
			if(card.getNum() == 13) {
				card.setFace(Face.KING);
			}
		});
		
		//Also throw in a joker because why not
		cards.add(new Card(id, 0, Suit.EMPTY, Face.JOKER));
		
		setDeck(cards);
		setUsedDeck(usedCard);
		return cards;
	}
	
	
	public boolean doesCardExist (String input, String cardSuit) {
		
		switch(input.toUpperCase()) {
			case "ACE":
				input = "1";
				break;
			case "JACK":
				input = "11";
				break;
			case "QUEEN":
				input = "12";
				break;
			case "KING":
				input = "13";
				break;
			default:
				break;
			//Push face cards to a number		
		}
		setNumber(Integer.valueOf(input));
		setExist(false);
		this.deck.forEach(card ->{
			if(card.getNum() == getNumber()) {
				if(card.getSuit().toString().equals(cardSuit.toUpperCase())) {
						setExist(true);;//If card matches deck, flag it for existence
					}
				}
		});
		if(exist) {
			pullFromDeck(input, cardSuit);
			return true;
		}
		return false;//If card doesn't exist, it doesn't exist...
	}
	
	
	private ArrayList<Card> pullFromDeck(String input, String suit){
		setChange(false);
		
			this.deck.forEach(card ->{	
			int num = Integer.valueOf(input);
			String upper = suit.toUpperCase().trim();
			if(card.getNum() == num && card.getSuit().
				toString().equals(upper)) {
					//After checking if the card exists in the deck
					//We're going to cycle through all the cards and find it
					//Then flag it to be moved to a used deck
				setChange(true);
				setCardId(card.getId());	
				}
			});
		
		if(change) {
			//If found, do the stated above
			//Okay so due to the way I arranged the array, all IDs
			//are off by one, I did this to work with joker 
			//but that's not working out all too well....
			for (int i =0; i < deck.size(); i++) {
				if(deck.get(i).getId() == getCardId()) {
					//Find the id, add it to the used card deck
					//Remove it from the deck
					this.usedDeck.add(deck.get(i));
					this.deck.remove(i);
				}
			}

			setDeck(this.deck);
			setUsedDeck(this.usedDeck);
			return this.deck;
		} else {
			return this.deck;
		}
	}
	
		
	
	
	
	

	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public boolean isChange() {
		return change;
	}
	public void setChange(boolean change) {
		this.change = change;
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


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public boolean isExist() {
		return exist;
	}


	public void setExist(boolean exist) {
		this.exist = exist;
	}



}

