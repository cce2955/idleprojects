package numberNames;

import java.beans.Encoder;
import java.util.EnumSet;
import java.util.HashSet;

public class NumberNames {
	private enum single_digits{
		ONE, TWO, THREE, FOUR, FIVE, SEVEN, EIGHT, NINE		
	}
	private enum double_digits{
		TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTHTEEN,
		SIXTHTEEN, SEVENTEEN, EIGHTTEEN, NINETEEN, TWENTY,
		THIRTY, FOURTY, FIFTY, SIXTY, SEVENTY, EIGHTY, NINETY 
	}
	private enum multiple_digits{
		HUNDRED, THOUSAND, MILLION
	}
	
	private multiple_digits multi;
	private	double_digits doubleD;
	private	single_digits single;
	private int checkNum(String input) {
		int convert = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.valueOf(input));
		
		
		switch(sb.length()) {
		case 3:
			multi(sb.charAt(3));
		case 2:
			doubleD(sb.charAt(2));
		case 1:
			single(sb.charAt(1));
			break;
			default:
				System.out.println("Getting to that");
		
		}
		return convert;
	}
	
	private int single(int input) {
		
		return input;
	}
	private int doubleD (int input) {
		
		return input;
	}
	private int multi ( int input) {
		
		
		return input;
	}
}