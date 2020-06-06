package budgetCalculator;

import java.util.ArrayList;

public class BudgetCalculator {
	//Add monthly income and spending to a database
	//Calculate a monthly difference between them
	//maybe do some extra calculations for budget goals or something
	ArrayList<Double> arr = new ArrayList<>();
	private boolean size;
	public ArrayList<Double> earningsThisMonth(double deposit) {
		arr.add(deposit);
		setArr(arr);
		return getArr();
	}
	/*
	public String choice() {
		return "you have " + availableMonths() + " available";
	}
	*/
	
	public String showEarningsPerTwoMonths(String month1, String month2) {
		if(!arr.isEmpty()) {	
			findPercentage(month1, month2);
		return "Earnings for " + month1 + " was " + monthsEarnings(month1) + 
				" and earnings for " + month2 + " was " 
				+ monthsEarnings(month2) + ", which is a " + 
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
		
		double percent = 0;
		if (arr.get(num1) < arr.get(num2)) {
			double check = 100.00/200;
			double ten = 10.00/20;
			percent =  (arr.get(num1)/arr.get(num2)) * 100.00 ;
			setSize(true); //size is an increase
		} else {
			percent = 100 * (arr.get(num2)/arr.get(num1));
			setSize(false);//Size is a decrease
		}
		return percent;
	}
	
	private String increaseOrDecrease() {
		if (isSize()) {
			return "increase";
		} else {
			return "decrease";
		}
	}
	private double monthsEarnings (String month) {
		double m1 = getArr().get(stringToMonth(month));
		return m1;
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
					return 0;
				//Just realized I could do this in a loop, too late
		}
	}
	
	private int availableMonths () {
		return getArr().size();
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
	
	
	
}
