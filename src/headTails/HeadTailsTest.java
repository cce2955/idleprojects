package headTails;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class HeadTailsTest {
	//I'm going to read up on how to test randomness
	//But for now, testing that things "aren't" equal is prob
	//a good way to observe randomness
	HeadTails heads = new HeadTails();
	private boolean pass;
	
	@Test
	void checkIfHeadsAndTailsLand() {
		for (int i = 0; i < 100; i++) {
			heads.flipCoin(true, false);
		}
		int headsThrown = heads.getHeadCounter();
		int tailsThrown = heads.getTailCounter();
		if(headsThrown > 1 && tailsThrown > 1) {
			setPass(true);
		}else {
			setPass(false);
		}
		//Check if heads and tails land at least once in a
		//a sample size
		assertEquals(true, isPass());
	}
	
	@Test
	void checkIfHeadsAndTailsLand10000() {
		for (int i = 0; i < 10000; i++) {
			heads.flipCoin(true, false);
		}
		int headsThrown = heads.getHeadCounter();
		int tailsThrown = heads.getTailCounter();
		if(headsThrown > 4000 && tailsThrown > 4000) {
			setPass(true);
		}else {
			setPass(false);
		}
		//Check if heads and tails land at least once in a
		//a sample size
		assertEquals(true, isPass());
	}
	
	@Test
	void checkWinRate() {
		for (int i = 0; i < 10000; i++) {
			heads.flipCoin(true, false);
			//Flip 10000 heads
		}
		int matchesWon = heads.getWinCounter();
		if(matchesWon > 4000) {
			setPass(true);
		}else {
			setPass(false);
		}
		
		assertEquals(true,  isPass());
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
}
