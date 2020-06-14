package sorter;

import java.util.ArrayList;

public class ArraySorter {
	private ArrayList<Integer> arr = new ArrayList<>();
	//So I finally figured out why programming has been such a pain for me
	//Getters and setters are great, but abuse can be confusing, I'll
	//only do them now to store information between classes instead of being a constant
	//So for example, this array needs to be constant throughout the program
	
	
	public void quickSorterRecursion () {
		int x = 0;
		//run the sorter enough times to make the effects actually last
		while (x < getArr().size()) {
			quickSorter();
			x++;
		}
	}
	
	public void bubbleSorterRecursion () {
		int x = 0;
		//same thing but bubbly
		while (x < getArr().size()) {
			bubbleSort();
			x++;
		}
	}
	private void swapper (int oldNum, int newNum, int oldPos, int newPos) {
		//Swap array positions, I made this more confusing then needed to be
		//As you can derive the position from the number since I'm using 
		//arraylists
		int holder = getArr().get(newPos);
		getArr().set(oldPos, holder);
		getArr().set(newPos, oldNum);
	}
	private void quickSorter() {
		for (int i = 0; i < getArr().size() - 1; i++) {
			//If number is lower, push it back a space
			if(getArr().get(i) < getArr().get(i + 1)) {
				swapper(getArr().get(i), getArr().get(i + 1), i, i + 1);
			}
			//If higher, push up a space
			if(getArr().get(i) > getArr().get(i + 1)) {
				swapper(getArr().get(i + 1), getArr().get(i), i + 1, i);
			}
		}
	}
	
	private void bubbleSort() {
		for (int i = 0; i < getArr().size(); i++) {
			for (int x = 0; x < getArr().size() ; x++) {
				if(getArr().get(i) < getArr().get(x)) {
					swapper(getArr().get(x), getArr().get(i), x, i);
				}
			}
		}
	}
	
	public void testExample() {
		getArr().clear();
		double num = 0;
	 	int intNum = 0;
	 	for (int i = 0; i < 1000; i++) {
	 		num =  Math.random() * 100;
	 		intNum = (int) num;
	 		setArr(intNum);
	 	}
	}
	public void resetArr() {
		this.arr.clear();
	}
	
	public ArrayList<Integer> getArr() {
		return arr;
	}

	public void setArr(int num) {
		this.arr.add(num);
	}
	
	
}
