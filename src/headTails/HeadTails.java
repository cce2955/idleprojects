package headTails;

import java.util.HashMap;
import java.util.Map;

public class HeadTails {

	private int headCounter;
	private int tailCounter;
	private int winCounter;
	private int loseCounter;
	private int coinThrown;
	private int displayWinner;
	
	public String flipCoin (boolean coin, boolean reset) {
		HashMap<String, Integer> coinHashMap = new HashMap<>();
		coinHashMap.putAll(hashMapCoin(coin, reset));
		System.out.println(coinHashMap);
		String coinWon = "";
		if (coinHashMap.get("Coin won") == 1){
			coinWon = "Heads";
		}
		if (coinHashMap.get("Coin won") == 2){
			coinWon = "Tails";
		}
		
		String result = "You have thrown " + coinHashMap.get("Coins Thrown")
		+ " coins, this coin toss resulted in " + coinWon + ", you have won"
		+ " " + coinHashMap.get("Wins") + " games and lost " + 
		coinHashMap.get("Loss") + " games \n" +
		"There has been " + coinHashMap.get("Heads Thrown") + " heads thrown "
		+" and " + coinHashMap.get("Tails thrown") + " tail thrown so far.";
		return result;
		
		
	}
	
	private HashMap<String, Integer> hashMapCoin(boolean coin, boolean reset) {
		HashMap<String, Integer> winLoss = new HashMap<>();
		double rand = Math.random() * 100;

		setCoinThrown();
		if (rand >= 50 && rand <= 100) {
			setHeadCounter();
			if(coin == true) {
				setWinCounter();
				setDisplayWinner(1);//1 for Heads
			}
			if(coin == false) {
				setLoseCounter();
				setDisplayWinner(1);//2 for Tails
			}
		}else if(rand <= 50 && rand >= 0) {
			setTailCounter();
			if(coin == false) {
				setWinCounter();
				setDisplayWinner(2);//2 for Tails
			}
			if(coin== true) {
				setLoseCounter();
				setDisplayWinner(2);//1 for Heads
			}
		}
		if(reset) {
			resetValues();
		}
			
			
		winLoss.put("Heads Thrown",	getHeadCounter());
		winLoss.put("Tails thrown", getTailCounter());
		winLoss.put("Wins", getWinCounter());
		winLoss.put("Loss", getLoseCounter());
		winLoss.put("Coins Thrown", getCoinThrown());
		winLoss.put("Coin won", getDisplayWinner());
		
		
	
		return winLoss;
	}
	
	public void resetValues() {
		
		this.coinThrown = 0;
		this.displayWinner = 0;
		this.headCounter = 0;
		this.loseCounter = 0;
		this.tailCounter = 0;
		this.winCounter = 0;
	}
	public int getHeadCounter() {
		return headCounter;
	}
	public int getWinCounter() {
		return winCounter;
	}
	public void setWinCounter() {
		this.winCounter++;
	}
	public int getLoseCounter() {
		return loseCounter;
	}
	public void setLoseCounter() {
		this.loseCounter++;
	}
	public void setHeadCounter() {
		this.headCounter++;
	}
	public int getTailCounter() {
		return tailCounter;
	}
	public void setTailCounter() {
		this.tailCounter++;
	}
	public int getCoinThrown() {
		return coinThrown;
	}
	public void setCoinThrown() {
		this.coinThrown++;
	}

	public int getDisplayWinner() {
		return displayWinner;
	}
	public void setDisplayWinner(int displayWinner) {
		this.displayWinner = displayWinner;
	}
}
