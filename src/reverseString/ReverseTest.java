package reverseString;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class ReverseTest {
	
	ReverseString reverse = new ReverseString();
	@Test
	void reverseString() {
		String output = reverse.setReverseStringInput("Test");
		
		assertEquals("tseT", output);
	}
	
	@Test
	void reverseAnother() {
		String output = reverse.setReverseStringInput("Look at me, I'm "
				+ "Mr. Meeseeks.");
		assertEquals(".skeeseeM .rM m'I ,em ta kooL", output);
				
	}
}
