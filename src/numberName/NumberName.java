package numberName;

import java.util.ArrayList;

public class NumberName {
/*
	 * Number Names - Show how to spell out a number in English. 
	 * You can use a preexisting implementation or roll your own, 
	 * but you should support inputs up to at least one million 
	 * (or the maximum value of your language's default bounded integer type, 
	 * if that's less). Optional: Support for inputs other than positive integers
	 *  (like zero, negative integers, and floating-point numbers).
	 */
	
	//Array Declaration
	private String[] arrSingle = {"Dummy", "One","Two","Three","Four","Five"
			,"Six", "Seven", "Eight", "Nine"};
	private String[] arrTens = {"Dummy", "Eleven", "Twelve", "Thirteen"
			, "Fourteen", "Fifthteen", "Sixteen", "Seventeen", "Eighteen"
			,"Nineteen"};
	private String[] arrDouble = {"Dummy", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", 
			"Sixty","Seventy", "Eighty", "Ninety"};
	private String[] arrMulti = {"Dummy", "Hundred", "Thousand", "Million"};
	
	//Boolean to determine if number is in the teens
	private boolean Teen;
	
	public ArrayList<String> findNum(String input){
		//Declarations
		int x = 0;
		setTeen(false);
		ArrayList<String> arr = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		//Toss String into String builder
		sb.append(input);

		if(sb.length() >= 3) {
			//Set X at the end of the arrMulti index
			x = sb.length() / 3;
		
			if (x > 3) {
				x = 3;
			}
		}
		
		for(int i =0; i < sb.length(); i++) {
			if (i % 3 == 0 && i > 0) {
				arr.add(",");
			}
			switch(i % 3) {
				case 0:		
					arr.add(getNumOne(String.valueOf(sb.charAt(i))));
					if (x > 0) {
						//Get the number and append a hundreds place to it
						//ex. One Hundred, two Thousand, three million, etc.
							arr.add(arrMulti[x]);
							x--;
						}
					break;
				case 1:
					//If the string doesn't contain one, then add 
					//Twenty, thirty, fourty, etc. to it
					if (!String.valueOf(sb.charAt(i)).contains("1")) {
						arr.add(getNumTen(String.valueOf(sb.charAt(i))));
					} else {
						//Else add eleven, twelve, thirteen, etc.
						arr.add(getNumTeens(String.valueOf(sb.charAt(i))));
						setTeen(true);
					}
					
					break;
				case 2:
					if(!isTeen()) {
						//If it's not eleven, etc., print out the one's place
						arr.add(getNumOne(String.valueOf(sb.charAt(i))));
					}
					break;
				default:
					System.out.println("Report this error");
			}
		}
		
		
		return arr;
	}
	
	private String getNumOne(String string) {
		int num = Integer.valueOf(string);
		string = arrSingle[num];
		return string;
	}
	
	private String getNumTen(String string) {
		int num = Integer.valueOf(string);
		string = arrDouble[num];
		return string;
	}
	
	private String getNumTeens(String string) {
		int num = Integer.valueOf(string);
		string = arrTens[num];
		return string;
	}
	/*
	private String getNumHundred(String string) {
		int num = Integer.valueOf(string);
		string = arrMulti[num];
		return string;
	}*/

	public boolean isTeen() {
		return Teen;
	}

	public void setTeen(boolean teen) {
		Teen = teen;
	}

}
