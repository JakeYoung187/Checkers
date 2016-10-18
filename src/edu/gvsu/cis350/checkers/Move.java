package edu.gvsu.cis350.checkers;


/********************************************************************
 * Move constructs the movement of pieces from starting point to end.
 * 
 * @author Nate Benson, Kaye Suarez, Jake Young
 * @version 1.0 
 ********************************************************************/
public class Move {
	
	/** start and end position of piece. */
	public int fromRow, fromColumn, toRow, toColumn;

	/*********************************************************
	 * Move constructs move based from start and end position.
	 * @param fromRow start row
	 * @param fromColumn start column
	 * @param toRow end row
	 * @param toColumn end column
	 *********************************************************/
	public Move(final int fromRow, final int fromColumn, 
			final int toRow, final int toColumn) {
		
		this.fromRow = fromRow;
		this.fromColumn = fromColumn;
		this.toRow = toRow;
		this.toColumn = toColumn;
	}
}
