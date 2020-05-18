package fibSequence;

import java.util.ArrayList;

//This will be a rewrite of the FSMain class but GUI(and class) friendly
public class FibSequenceGui {
	
	public String phrases (int num, int iteration, int arrPos) {
		ArrayList<String> phraseArr = new ArrayList<>();
		phraseArr.clear();
		phraseArr.add("Hi, in this program, we're going to calculate"
				+ " a fibonacci sequence, please input your first number: ");
		phraseArr.add("Now how many iterations of this number do "
				+ "you wish to go through?");
		phraseArr.add("The fibonacci sequence for: " + 
				num + " over the course of " +
				iteration + " iterations is " 
				);
		phraseArr.add("Not a valid number, please input a number");
		//Double conditional somewhere
		
		return phraseArr.get(arrPos);

	}
	public void test() {
		System.out.println("working");
	}
	private boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}catch (NumberFormatException e) {
			phrases(0,0,3);
			return false;
		}
	}
	
}
