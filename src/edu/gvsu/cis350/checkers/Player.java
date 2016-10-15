package edu.gvsu.cis350.checkers;

/************************************
 * Player color values.
 ************************************/
public enum Player {
	
	/** Players. */
	GRAY, RED;
	
	/********************* 
	 * Return next player. 
	 * @return color 
	 *********************/
	public Player next() {
		return this == GRAY ? RED : GRAY;
	}
}
