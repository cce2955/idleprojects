package factorialRecursion;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class FactorialTest {
	FactorialMain facMain = new FactorialMain();
	
	@Test
	void factFiveInt () {
		int number = Integer.valueOf(facMain.factorialGeneration("5"));
		assertEquals(120, number);
	}
	
	@Test
	void factFiveString() {
		String number = facMain.factorialGeneration("5");
		assertEquals("120", number);	
	}
	
	@Test
	void factThreeInt() {
		int number = Integer.valueOf(facMain.factorialGeneration("3"));
		assertEquals(6, number);
	}
	
}
