package main;




import cardDeck.CardDeck;
import cardDeck.CardWindow;
import window.WindowMain;

/*	So I'm getting a little burnt out on redux and I'm gonna have to grind at 
 * that to get into it, however I'm having fun with java, so I'll be doing 
 * tiny little (and I mean little) projects here
*/
public class EntryPoint {
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		WindowMain mainWindow = new WindowMain();
		CardWindow window = new CardWindow();
//		CardDeck deck = new CardDeck();
//		deck.makeFullDeck();
//		
//		//deck.doesCardExist("1", "Heart");
//				
//		deck.getUsedDeck().forEach(card ->{
//			System.out.println(card.getNum() + " " +card.getSuit() +  " " + card.getFace());
//		});
	}

}
;