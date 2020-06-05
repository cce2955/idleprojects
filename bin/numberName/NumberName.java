package numberName;

import java.util.ArrayList;

public class NumberName {

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
		
		//This separates numbers into triplets
		//So 1000000 would be 100,000,000
		//and 10000 would be 10,000 etc.
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
					if(sb.length() >2) {
						arr.add(getNumOne(String.valueOf(sb.charAt(i))));
					}
					
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
					if (!String.valueOf(sb.charAt(i)).contains("1")
							&& sb.length() > 2) {
						arr.add(getNumTen(String.valueOf(sb.charAt(i))));
					} else if (sb.length() > 2) {
						//If the number has at least 3 digits check the ones 
						//place and give it eleven, twelve, etc.
						arr.add(getNumTeens(String.valueOf(sb.charAt(i + 1))));
						setTeen(true);
					}else {
						//or else just check the number in the ones place, 
						//which will still give you eleven, twelve, etc.
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
