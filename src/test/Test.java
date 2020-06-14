package test;

import static org.junit.Assert.assertEquals;

public class Test {
	TestClassToTest test = new TestClassToTest();

	@org.junit.jupiter.api.Test
	void addition() {
		assertEquals(2, test.add(1, 1));
	}
	@org.junit.jupiter.api.Test
	void addition2Plus2() {
		assertEquals(4, test.add(2, 2));
	}

	@org.junit.jupiter.api.Test
	void additionBig() {
		assertEquals(200, test.add(150, 50));
	}
}
