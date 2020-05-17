package userInput;

import java.util.Scanner;

public class UserInput {
	
	public Scanner userInput = new Scanner(System.in);
	private String string;
	
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	private boolean check;
	
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	
	public boolean checkIfValidNumber(String input) {
		try {
			Integer.parseInt(input);
		}catch (NumberFormatException e) {
			return false;
		}
		return true;
		
	}
	
	
	
}
