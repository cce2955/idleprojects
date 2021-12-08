package chess;

public class Space {
	//Add an ID to a space, this will be used to calculate it's position
	int spaceID;
	boolean occupied;
	
	/**
	 * @param spaceID
	 * @param occupied
	 */
	public Space(int spaceID, boolean occupied) {
		super();
		this.spaceID = spaceID;
		this.occupied = occupied;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public int getSpaceID() {
		return spaceID;
	}

	public void setSpaceID(int spaceID) {
		this.spaceID = spaceID;
	}
	
}
