package main;

import java.util.ArrayList;

import fibSequence.FibSequenceMain;
import userInput.UserInput;
import vowelChecker.VowelCheckerMain;

public class ProjectMasterList {
	UserInput input = new UserInput();
	public ArrayList<String> listOfEntries = new ArrayList<String>();
	
	public void choice(String string) {
		int choice = Integer.parseInt(string);
		
		FibSequenceMain fib = new FibSequenceMain();
		VowelCheckerMain checker = new VowelCheckerMain();
			
		switch (choice) {
			case 1:
				fib.calculateFibonnaciSequence();
				break;
			case 2: 
				checker.checkVowels();
				break;
			case 3:
				
		}
	}
	
	public boolean listEntries() {
		
		masterList();
		
		for(int i = 0; i < listOfEntries.size(); i++) {
			System.out.println(listOfEntries.get(i));
		}
		
		input.setString(input.userInput.nextLine());
		
		while (!input.checkIfValidNumber(input.getString())){
			System.out.println("Not a valid number, please input a number");
			input.setString(input.userInput.nextLine());
		}
		
		choice(input.getString());
		
		if (Integer.parseInt(input.getString()) > listOfEntries.size()) {
			listOfEntries.clear();
			return true;
		}else {
			listOfEntries.clear();
			return false;
		}
		
		
	}
	
	public ArrayList<String> masterList(){
		listOfEntries.add("1. Fibonacci Number Generator");
		listOfEntries.add("2. Check how many vowels are in a sentence");
		listOfEntries.add("3. Basic Text Editor (May replace this menu)");
		return listOfEntries;
	}
	
	
}
