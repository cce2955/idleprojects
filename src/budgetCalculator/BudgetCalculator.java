package budgetCalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BudgetCalculator {
	//Add monthly income and spending to a database
	//Calculate a monthly difference between them
	//maybe do some extra calculations for budget goals or something
	ArrayList<Double> arr = new ArrayList<>();
	private boolean size;
	private double percent;
	private double monthEarningsPrimary;
	private double monthEarningsSecondary;
	
	
	public ArrayList<Double> earningsThisMonth(double deposit) {
		arr.add(deposit);
		setArr(arr);
		return getArr();
	}
	
	public ArrayList<Double> resetEarnings(){
		arr.clear();
		setArr(arr);
		return getArr();
	}
	
	public String choice() {
		if(availableMonths() == 1) {
			return "You have " + availableMonths() + " month available.";
		}else {
			return "You have " + availableMonths() + " months available.";
		}
		
	}
	
	
	public String showEarningsPerTwoMonths(String month1, String month2) {
		if(!arr.isEmpty()) {	
			//This is run early so I can find if there 
			//is an increase or decrease
			findPercentage(month1, month2);
			//A monolith of encapsulation here
			//So we grab the month, turn it to a string value of 0,1,2,3,etc.
			//That value corresponds to a section in the array
			//Which is converted to a double
			//Set to a setter
		setMonthEarningsPrimary(Double.valueOf(arr.get(stringToMonth(month1))));
		setMonthEarningsSecondary(Double.valueOf(arr.get(stringToMonth(month2))));
		
		return "Earnings for " + month1 + " was " + getMonthEarningsPrimary() + 
				" and earnings for " + month2 + " was " 
				+ getMonthEarningsSecondary() + ", which is a " + 
				increaseOrDecrease() + " of " + findPercentage(month1, month2)
				+ "%";
		//Calculation for percentage and calculation for determining
		//if this is an increase or decrease
		} else {
			return "you currently have not submitted any earnings";
		}
	}
	
	private double findPercentage(String month1, String month2) {
		int num1 = stringToMonth(month1);
		int num2 = stringToMonth(month2);
		
		//Find a size, smaller number/larger * 100 gives you a percentage
		if (arr.get(num1) < arr.get(num2)) {
			setPercent((arr.get(num1)/arr.get(num2)) * 100.00) ;
			setSize(true); //size is an increase
		} else {
			setPercent(percent = 100 * (arr.get(num2)/arr.get(num1)));
			setSize(false);//Size is a decrease
		}
		
		DecimalFormat df2 = new DecimalFormat("#.##");
		df2.setRoundingMode(RoundingMode.DOWN);
		setPercent(Double.valueOf(df2.format(getPercent())));
		return getPercent();
	}
	
	private String increaseOrDecrease() {
		if (isSize()) {
			return "increase";
		} else {
			return "decrease";
		}
	}
	
	private int stringToMonth(String month) {
		
		switch (month.toLowerCase()) {
			case "january":
				return 0;
			case "february":
				return 1;
			case "march":
				return 2;
			case "april":
				return 3;
			case "may":
				return 4;
			case "june":
				return 5;
			case "july":
				return 6;
			case "august":
				return 7;
			case "september":
				return 8;
			case "october":
				return 9;
			case "november":
				return 10;
			case "december":
				return 11;
			default:
				//This program in theory should never return 0
				return 0;
				//Just realized I could do this in a loop, too late
		}
	}
	private String monthToString(String month) {
		return "";
	}
	public int availableMonths () {
		if(!getArr().equals(null)) {
			return getArr().size();
		}else {
			return 0;
		}
		
	}
	
	public ArrayList<Double> getArr() {
		return arr;
	}

	public void setArr(ArrayList<Double> arr) {
		this.arr = arr;
	}

	public boolean isSize() {
		return size;
	}

	public void setSize(boolean size) {
		this.size = size;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public double getMonthEarningsPrimary() {
		return monthEarningsPrimary;
	}

	public void setMonthEarningsPrimary(double monthEarningsPrimary) {
		this.monthEarningsPrimary = monthEarningsPrimary;
	}

	public double getMonthEarningsSecondary() {
		return monthEarningsSecondary;
	}

	public void setMonthEarningsSecondary(double monthEarningsSecondary) {
		this.monthEarningsSecondary = monthEarningsSecondary;
	}
	
	
	
	
}
