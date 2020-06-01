package reverseString;

public class ReverseString {
	private String reversedInput (String input) {
		StringBuilder sb = new StringBuilder();
		sb.append(input);
		input = String.valueOf(sb.reverse());
		return input;
	}

	public String setReverseStringInput(String stringInput) {
		return String.valueOf(reversedInput(stringInput));
		
	}
}
