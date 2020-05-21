package fibSequence;

import java.util.ArrayList;

import userInput.UserInput;

//This will be a rewrite of the FSMain class but GUI(and class) friendly
public class FibSequenceGui {
	UserInput validCheck = new UserInput();
	private boolean firstVar;
	private int inputNum;
	private int iterationNum;
	public ArrayList<Integer> fibArray = new ArrayList<>();
	
	public void inputOne(String input) {
		if(validCheck.checkIfValidNumber(input)) {
			setIterationNum(Integer.valueOf(input));
			setFirstVar(false);	 
		}else {
			setFirstVar(true);
		}
	}
	
	public void inputTwo(String input) {
		if(validCheck.checkIfValidNumber(input)) {
			setInputNum(Integer.valueOf(input));	
		}
		else {
			setFirstVar(true);
		}
	}
	
	public String arrayToString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fibArray.size(); i++) {
			sb.append(fibArray.get(i) + " ");
			System.out.println(sb.toString());
			if (i % 5 == 0 && i > 1) {
				sb.append(" \n");
			}
		}
		String converter = sb.toString();
		setInputNum(0);
		setIterationNum(0);
		
		return converter;
	}
	
	public ArrayList<Integer> fibGenerator (int num, int iterations){
		int sum = num;
		int numMinusOne = num;
		
		for (int i = 0; i < iterations; i++) {
			if(sum < Integer.MAX_VALUE) {
				numMinusOne = num;
				num = sum;
				sum = numMinusOne + num;
				fibArray.add(sum);
			}
				
		}
		
		return fibArray;
	}
	public int getInputNum() {
		return inputNum;
	}

	public void setInputNum(int inputNum) {
		this.inputNum = inputNum;
	}

	public int getIterationNum() {
		return iterationNum;
	}

	public void setIterationNum(int iterationNum) {
		this.iterationNum = iterationNum;
	}


	public boolean isFirstVar() {
		return firstVar;
	}
	public void setFirstVar(boolean firstVar) {
		this.firstVar = firstVar;
	}
}
