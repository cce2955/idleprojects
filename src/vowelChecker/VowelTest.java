package vowelChecker;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class VowelTest {
	VowelCounter counter = new VowelCounter();
	@Test
	void findA() {
		String input = "Here is a phrase I am writing";
		HashMap<Integer, Integer> temp = new HashMap<>();
		temp.putAll(counter.findVowels(input));
		int output = temp.get(0);
		assertEquals(3, output);
	}
	@Test
	void findE() {
		String input = "Here is a phrase I am writing";
		HashMap<Integer, Integer> temp = new HashMap<>();
		temp.putAll(counter.findVowels(input));
		int output = temp.get(1);
		assertEquals(3, output);
	}
	@Test
	void findI() {
		String input = "Here is a phrase I am writing";
		HashMap<Integer, Integer> temp = new HashMap<>();
		temp.putAll(counter.findVowels(input));
		int output = temp.get(2);
		assertEquals(4, output);
	}
	
	@Test
	void findO() {
		String input = "Here is a phrase I am writing";
		HashMap<Integer, Integer> temp = new HashMap<>();
		temp.putAll(counter.findVowels(input));
		int output = temp.get(3);
		assertEquals(0, output);
	}
	
	@Test
	void findU() {
		String input = "Here is a phrase I am writing";
		HashMap<Integer, Integer> temp = new HashMap<>();
		temp.putAll(counter.findVowels(input));
		int output = temp.get(4);
		assertEquals(0, output);
	}
	
	@Test
	void findNoVowels() {
		String input = "Try gypsy hymns rhythm !";
		HashMap<Integer, Integer> temp = new HashMap<>();
		temp.putAll(counter.findVowels(input));
		double random = (Math.random() * 100) % 5;
		//Grab any index of the hash map and it should still return 0;
		int output = temp.get((int)random);
		assertEquals(0, output);
				
	}
}
