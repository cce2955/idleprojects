package test;


//This is a random class I am creating purely to test
//After this I'll start testing other classes which I should've
//done earlier but didn't really understand it
public class TestClassToTest {
	private int x;
	private int y;
	
	public int add (int x, int y) {
		setX(x);
		setY(y);
		
		return getX() + getY();
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
