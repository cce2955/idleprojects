package main;

import java.util.ArrayList;

import fibSequence.FibSequenceMain;
import userInput.UserInput;

public class ProjectMasterList {
	UserInput input = new UserInput();
	public ArrayList<String> listOfEntries = new ArrayList<String>();
	
	public void choice(String string) {
		int choice = Integer.parseInt(string);
		
		FibSequenceMain fib = new FibSequenceMain();
		
		switch (choice) {
			case 1:
				fib.calculateFibonnaciSequence();
				break;
		}
	}
	
	public void listEntries() {
		masterList();
		for(int i = 0; i < listOfEntries.size(); i++) {
			System.out.println(listOfEntries.get(i));
		}
		input.setString(input.userInput.nextLine());
		while (!input.checkIfValid(input.getString())){
			input.setString(input.userInput.nextLine());
		}
		choice(input.getString());
	}
	
	public ArrayList<String> masterList(){
		listOfEntries.add("1. Fibonacci Number Generator");
		return listOfEntries;
	}
	
	
}
