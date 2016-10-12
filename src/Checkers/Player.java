package Checkers;

public enum Player {
	GRAY, RED;
	
	/**
	 * return the player whose turn is next
	 * 
	 */
	public Player next() {
		return this == GRAY ? RED : GRAY;
	}
}
