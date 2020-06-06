package cardDeck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

public class CardTests {
	CardDeck deck = new CardDeck();
	Card card = new Card();
	@Test
	void getAce() {
		deck.makeFullDeck();
		assertEquals("ACE", deck.getDeck().get(0).getFace().toString());		
	}
	
	@Test
	void dontGetClub() {
		deck.makeFullDeck();
		assertNotEquals("Club", deck.getDeck().get(3).getSuit().toString());
	}
	
	@Test
	void findLengthOfDeck() {
		deck.makeFullDeck();
		assertEquals(53, deck.getDeck().size());
	}
	
	@Test
	void makeSureDeckResizesOnPull() {
		deck.makeFullDeck();
		deck.doesCardExist("Ace", "club");
		assertNotEquals(53, deck.getDeck().size());
	}
}
