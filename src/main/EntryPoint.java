package main;




import cardDeck.CardDeck;
import window.WindowMain;

/*	So I'm getting a little burnt out on redux and I'm gonna have to grind at 
 * that to get into it, however I'm having fun with java, so I'll be doing 
 * tiny little (and I mean little) projects here
*/

/* project ideas
 * 
 * Coin Flip Simulation - Write some code that simulates flipping a single 
 * coin however many times the user decides. The code should record the
 * outcomes and count the number of tails and heads.
 */
public class EntryPoint {
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		WindowMain mainWindow = new WindowMain();
		CardDeck deck = new CardDeck();
		deck.makeFullDeck();
		deck.getDeck().forEach(card ->{
			System.out.println(card.getNum() + " " + card.getFace() + " " + card.getSuit());
		});
		
		deck.pullFromDeck("1", "Heart");
	}

}
