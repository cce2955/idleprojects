package vowelChecker;

import java.util.HashMap;

public class VowelCheckerGui {

	VowelCounter counterObject = new VowelCounter();
	private boolean validInput;

	private HashMap<Integer, Integer> findVowels(String input) {
		counterObject.findVowels(input);
		return counterObject.vowelCounter;
	}
	
	public String returnVowels (String input) {
			StringBuilder sb = new StringBuilder();
			String[] arr = {"A","E","I","O","U"};
			int sum = 0;
			counterObject.vowelCounter.clear();
			findVowels(input.toLowerCase());
			
			sb.append("In your phrase, there are: ");
			for (int i = 0; i < counterObject.vowelCounter.size(); i++) {
				sb.append(" [" + counterObject.vowelCounter.get(i) + "] " +
			arr[i] +"'s ");
				if(i % 5 ==0) {
					sb.append("\n");
				}
				sum += counterObject.vowelCounter.get(i);
			}
			
			sb.append(", \n which is a total of " + sum + " vowels");
			
			String convert = sb.toString();
			setValidInput(false);
			return convert;
	}
	
	public boolean isValidInput() {
		return validInput;
	}

	public void setValidInput(boolean validInput) {
		this.validInput = validInput;
	}

}
