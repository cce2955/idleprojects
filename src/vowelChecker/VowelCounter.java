package vowelChecker;

import java.util.HashMap;

public class VowelCounter {
	
	HashMap<Integer, Integer> vowelCounter = new HashMap<>();
	
	
	public HashMap<Integer,Integer> findVowels(String inputString){
		int A = 0, E = 0, I= 0, O = 0, U = 0;
		inputString.toLowerCase();
		StringBuilder stringDeconstructor = new StringBuilder();
		stringDeconstructor.append(inputString);
		
		for (int i = 0; i < stringDeconstructor.length(); i++) {
			switch(stringDeconstructor.charAt(i)) {
			case 'a':
				A++;
				vowelCounter.put(0, A);
				break;
			case 'e': 
				E++;
				vowelCounter.put(1, E);
				break;
			case 'i':
				I++;
				vowelCounter.put(2, I);
				break;
			case 'o':
				O++;
				vowelCounter.put(3, O);
				break;
			case 'u':
				U++;
				vowelCounter.put(4, U);
				break;
			default:
				break;
			}
		}
		
		return vowelCounter;
	}
}
