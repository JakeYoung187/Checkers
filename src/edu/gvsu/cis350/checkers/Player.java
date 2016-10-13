package edu.gvsu.cis350.checkers;

/************************************
 * Method for returning player color.
 ************************************/
public enum Player {
	GRAY, RED;
	
	/** Return next player. 
	 * @return color 
	 */
	public Player next() {
		return this == GRAY ? RED : GRAY;
	}
}
