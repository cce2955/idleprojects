package fibSequence;

import java.util.ArrayList;

public class FibCalc {
	
	public ArrayList<Integer> FibSequence(int userInput, int iterations) {
		ArrayList<Integer> recursion = new ArrayList<Integer>();
		int sum = userInput;
		int userInputMinusOne = userInput;
		for (int i = 0; i < iterations; i++) {
			userInputMinusOne = userInput;
			userInput = sum;
			sum = userInputMinusOne + userInput;
			recursion.add(sum);
		}
		
		return recursion;
	}
}
