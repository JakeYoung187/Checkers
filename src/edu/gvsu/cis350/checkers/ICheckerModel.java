package edu.gvsu.cis350.checkers;

/******************************************************************************
 * ICheckerModel interface for game play: moving, winning and rotating players.
 ******************************************************************************/
public interface ICheckerModel {
	
	/*********************************************
	 * isComplete checks if the turn is completed.
	 * @return true if complete, false if not.
	 *********************************************/
	boolean isComplete();
	
	//boolean isValidMove(Move move);
	
	/*******************************************
	 * move handles movement of pieces on board.
	 * @param move given move
	 *******************************************/
	void move(Move move);
	
	/************************************
	 * gameOver checks if game ended.
	 * @param winner player
	 * @return true if win, false if not
	 ************************************/
	boolean gameOver(Player winner);
	
	
	/***************************************
	 * Return the piece at a given location.
	 * @param row given row
	 * @param column given column
	 * @return piece at location
	 ***************************************/
	IGamePiece pieceAt(final int row, final int column);
	
	/***********************************************************
	 * getCurrentPlayer returns the value of the current player.
	 * @return player value
	 ***********************************************************/
	Player getCurrentPlayer();
	
}
