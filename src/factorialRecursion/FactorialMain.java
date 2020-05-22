package factorialRecursion;

public class FactorialMain {
	//Generating a factorial using recursion, nothing major but just something
	//else to add to this project
	public String factorialGeneration(String input) {
		StringBuilder sb = new StringBuilder();
		sb.append(generateSum(input));
		input = sb.toString();
		return input;
	}
	
	private String generateSum(String input) {	
		int number = Integer.valueOf(input);
		int sum = number;
		while (number > 0) {
			if(number > 1) {
				sum = sum * (number - 1);
			}
			number--;
		}
		return String.valueOf(sum);
	}
}