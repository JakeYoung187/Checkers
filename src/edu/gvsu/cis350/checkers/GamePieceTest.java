package edu.gvsu.cis350.checkers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/************************************************************
 * JUnit testing for the GamePiece Class.
 * @author Nate Benson, Jake Young, Kaye Suarez
 * @version 1.0
 ************************************************************/
public abstract class GamePieceTest {

	private static final int BOARD_SIZE = 8;

	/* These three variables are accessible from your child test classes */
	protected IGamePiece[][] board;
	protected IGamePiece piece;

	@Before
	public void makeBoard() {
		// Don't put any pieces on the board.
		board = new IGamePiece[BOARD_SIZE][BOARD_SIZE];
		piece = make(Player.RED);
	}

	protected abstract IGamePiece make(Player p);

	protected abstract Move getValidMove(int fromRow, int fromCol);

	/************************************************
	 * Checks if location is occupied by same player.
	 * @throws Throwable 
	 ************************************************/
	@Test
	public final void complainTargetOccupiedBySamePlayer() throws Throwable {
		Move move = getValidMove(2, 4);
		board[move.toRow][move.toColumn] = make(Player.RED);
		board[move.fromRow][move.fromColumn] = piece;
		assertFalse("GamePiece Test", piece.isValidMove(move, board));
	}

}
