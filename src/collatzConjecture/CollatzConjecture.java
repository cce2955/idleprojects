package collatzConjecture;

public class CollatzConjecture {
	//Given a number > 1, find how long it takes to reach 1
	//With the restraints that in the event of an even num, divide by 2
	//and with an odd number multiply by 3 and add 1
	private int incrementer;
	private boolean even;
	private int num;
	private int highestNumber;
	public int numSteps (int number) {
		//Decide if number is even or odd
		//increment a variable 
		//process variable with method
		//repeat until 1
		setNum(number);
		setHighestNumber(number);
		while (getNum() > 1) {
			setEven(evenOrOdd(getNum()));
			if(isEven()) {
				evenCalc(getNum());
			} else {
				oddCalc(getNum());
			}
			highestNumberReached(getNum());
			setIncrementer();
		}
		return number;
	}
	
	private int highestNumberReached(int number) {
		if(number > getHighestNumber()) {
			setHighestNumber(number);
		}
		return getHighestNumber();
	}
	private boolean evenOrOdd(int number) {
		if (number % 2 == 0) {
			return true; //even
		} else {
			return false; //odd
		}
	}
	
	private int evenCalc(int number) {
		setNum(number/2);
		return getNum();
		
	}
	private int oddCalc(int number) {
		setNum((number * 3) + 1);
		return getNum();
	}
	
	
	public boolean isEven() {
		return even;
	}

	public void setEven(boolean even) {
		this.even = even;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}


	public int getIncrementer() {
		return incrementer;
	}

	public void setIncrementer() {
		this.incrementer++;
	}
	
	public void resetIncrementer() {
		this.incrementer = 0;
	}

	public int getHighestNumber() {
		return highestNumber;
	}

	public void setHighestNumber(int highestNumber) {
		this.highestNumber = highestNumber;
	}
	

}
