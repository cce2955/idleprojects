package budgetCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BudgetCalculatorTest {
	BudgetCalculator budget = new BudgetCalculator();
	
	@Test
	void addToArray() {
		budget.earningsThisMonth(100);
		budget.earningsThisMonth(200);
		int size = budget.arr.size();
		assertEquals(2, size);
	}
	
	@Test
	void testString() {
		String test = budget.showEarningsPerTwoMonths("january", "feburary");
		assertEquals("you currently have not submitted any earnings", test);
		
	}
	@Test
	void testEntireFunctionality(){
		budget.earningsThisMonth(100);
		budget.earningsThisMonth(200);
		String test = budget.showEarningsPerTwoMonths("january", "february");
		assertEquals("Earnings for january was 100.0 and earnings for"
				+ " february was 200.0, which is a increase of 50.0%", test);
		
	}
	
	@Test
	void testDecrease() {
			budget.earningsThisMonth(200);
			budget.earningsThisMonth(100);
			String test = budget.showEarningsPerTwoMonths("january", "february");
			assertEquals("Earnings for january was 200.0 and earnings for"
					+ " february was 100.0, which is a decrease of 50.0%", test);
	}

}
