package main;

import fibSequence.FibSequenceMain;
import userInput.UserInput;

/*	So I'm getting a little burnt out on redux and I'm gonna have to grind at 
 * that to get into it, however I'm having fun with java, so I'll be doing 
 * tiny little (and I mean little) projects here
*/
public class EntryPoint {
	
	
	public static void main(String[] args) {
		ProjectMasterList masterList = new ProjectMasterList();
		
		System.out.println("Welcome to the entry point, what project do you "
				+ "need today?");
		System.out.println("Current Entries: ");
		masterList.listEntries();
		
		
		
	}

}
