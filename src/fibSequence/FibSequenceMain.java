package fibSequence;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import userInput.UserInput;

/*Enter a number and have the program generate the 
 * Fibonacci sequence to that number or to the Nth number.
 */
public class FibSequenceMain {
	
	FibCalc fibCalc = new FibCalc();
	ArrayList<Integer> storage = new ArrayList<Integer>();
	UserInput initialInput = new UserInput();
	UserInput iterationInput = new UserInput();
	
	
	public void calculateFibonnaciSequence() {
		System.out.println("Hi, in this program, we're going to calculate"
				+ " a fibonacci sequence, please input your first number: ");
		
		initialInput.setString(initialInput.userInput.nextLine());
		
		while(!initialInput.checkIfValid(initialInput.getString())) {
			initialInput.setString(initialInput.userInput.nextLine());
		}
		
		System.out.println("Now how many iterations of this numbe do "
				+ "you wish to go through?");
		
		iterationInput.setString(initialInput.userInput.nextLine());
		
		while(!iterationInput.checkIfValid(iterationInput.getString())) {
			iterationInput.setString(initialInput.userInput.nextLine());
		}
		
		storage.addAll(fibCalc.FibSequence(Integer.parseInt(
				initialInput.getString()), 
				Integer.parseInt(iterationInput.getString())));
		
		System.out.println("The fibonacci sequence for: " + 
				initialInput.getString() + " over the course of " +
				iterationInput.getString() + " iterations is " 
				);
		
		System.out.print(initialInput.getString() + " ");
		for (int i = 0; i< storage.size(); i++) {
			System.out.print(storage.get(i) + " ");
			if (i % 15 == 0 && i > 1) {
				System.out.println("");
			}
		}
	}
	
	
}
