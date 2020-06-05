package fibSequence;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class FibTest {
	FibCalc fib = new FibCalc();
	FibSequenceGui gui = new FibSequenceGui();
	
	@Test
	void fibOneIterationTenPositionAtTwo() {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.addAll(fib.FibSequence(1, 10));
		int number = arr.get(2);
		assertEquals(5, number);
	}
	@Test
	void fibOneIterationTenPositionAtThree() {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.addAll(fib.FibSequence(1, 10));
		int number = arr.get(3);
		assertEquals(8, number);
	}
	
	@Test
	void fibGuiTest() {
		boolean test = gui.validCheck.checkIfValidNumber("3");
		assertEquals(true, test);
	}
	
	@Test
	void fibGuiFalse() {
		boolean test = gui.validCheck.checkIfValidNumber("Not a number");
		assertEquals(false, test);
	}
	
	@Test
	void checkFibArray() {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.addAll(gui.fibGenerator(1, 10));
		int num = arr.get(1);
		assertEquals(3, num);
	}
	
	@Test
	void checkFibArrayPosThree() {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.addAll(gui.fibGenerator(1, 10));
		int num = arr.get(3);
		assertEquals(8, num);
	}
}
