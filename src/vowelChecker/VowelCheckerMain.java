package vowelChecker;

import userInput.UserInput;

public class VowelCheckerMain {
	VowelCounter counter = new VowelCounter();
	UserInput input = new UserInput();
	public void checkVowels() {
		int sum = 0;
		String[] arr = {"A", "E", "I", "O", "U"};
		System.out.println("Input a string and I can count how many vowels are "
				+ "there.");
		input.setString(input.userInput.nextLine());
		counter.findVowels(input.getString().toLowerCase());
		System.out.println("In your phrase, there are ");
		for (int i = 0; i < counter.vowelCounter.size(); i++) {
			System.out.print(" [" + counter.vowelCounter.get(i) + "] " +
		arr[i] +"'s ");
			sum += counter.vowelCounter.get(i);
		}
		
		
		System.out.println(", which is a total of " + sum + " vowels");
	}
}