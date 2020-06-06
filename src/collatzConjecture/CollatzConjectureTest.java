package collatzConjecture;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CollatzConjectureTest {
	CollatzConjecture coll = new CollatzConjecture();
	 @Test
	 void increment() {
		 coll.setIncrementer();
		 coll.setIncrementer();
		 coll.setIncrementer();
		 assertEquals(3, coll.getIncrementer());
	 }
	 
	 @Test
	 void resetIncrement() {
		 coll.setIncrementer();
		 coll.setIncrementer();
		 coll.setIncrementer();
		 coll.resetIncrementer();
		 
		 assertEquals(0, coll.getIncrementer());
	 }
	 
	 @Test
	 void countSteps() {
		 coll.numSteps(100);
		 assertEquals(25, coll.getIncrementer());
	 }
	 
	 @Test
	 void countHighestNumber(){
		 coll.numSteps(1000);
		 assertEquals(9232, coll.getHighestNumber());
	 }
}
