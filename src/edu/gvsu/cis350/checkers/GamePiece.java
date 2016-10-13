package edu.gvsu.cis350.checkers;

/**********************************************************************
 * GamePiece implements the GamePiece interface to create board pieces.
 **********************************************************************/
public abstract class GamePiece implements IGamePiece {

	/** owner of piece. */
	private Player owner;
	
	/*********************************************
	 * Set the owner of the piece as given player.
	 * @param player owner of piece.
	 *********************************************/
	//TODO: Not sure how to fix this checkstyle issue (logic issue)
	public final void GamePiece(final Player player) {
		this.owner = player;
	}
	
	public Player player() {
		return owner;
	}

	//Determines whether it is a king
	// or a normal piece
	public abstract String type();

	//public abstract boolean isValidMove(GamePiece game);
	
}
