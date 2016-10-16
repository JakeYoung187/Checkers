package edu.gvsu.cis350.checkers;

/***********************************************
 * Player color values.
 * 
 * @author Nate Benson, Kaye Suarez, Jake Young
 * @version 1.0 
 ***********************************************/
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
