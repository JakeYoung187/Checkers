package edu.gvsu.cis350.checkers;

import static org.junit.Assert.*;

import org.junit.Test;


/************************************************************
 * JUnit testing for the NormalPiece Class.
 * @author Nate Benson, Jake Young, Kaye Suarez
 * @version 1.0
 ************************************************************/
public class NormalPieceTest extends GamePieceTest {

	@Override
	protected final IGamePiece make(final Player p) {
		return new NormalPiece(p);
	}

	@Override
	protected final Move getValidMove(final int fromRow, final int fromCol) {
		
		if (piece.player() == Player.RED) {

			return new Move(fromRow, fromCol, fromRow - 1, fromCol);			
		} else {
			return new Move(fromRow, fromCol, fromRow + 1, fromCol);
		}
	}
	
	
	/******************************
	 * Checks if piece is "Normal".
	 * @throws Exception 
	 ******************************/
	@Test
	public final void typeTest() throws Exception {

		assertEquals("Pawn", piece.type());
	}
	
	/******************************************
	 * Checks if piece can move diagonal right.
	 * @throws Exception 
	 ******************************************/
	@Test
	public final void moveDiagRight() throws Exception {
		board[5][1] = piece;

		assertTrue(piece.isValidMove(new Move(5, 1, 4, 2), board));
	}
	
	/*****************************************
	 * Checks if piece can move diagonal left.
	 * @throws Exception 
	 *****************************************/
	@Test
	public final void moveDiagLeft() throws Exception {
		board[5][1] = piece;
	
		assertTrue(piece.isValidMove(new Move(5, 1, 4, 0), board));
	}
	
	
	/*******************************************
	 * Checks if invalid to move piece vertical.
	 * @throws Exception 
	 *******************************************/
	@Test
	public final void cantMoveForwards() throws Exception {
		board[5][3] = piece;

		assertFalse(piece.isValidMove(new Move(5, 3, 4, 3), board));
	}
	
	
	/*********************************************
	 * Checks invalid vertical backwards movement.
	 * @throws Exception 
	 *********************************************/
	@Test
	public final void cantMoveBackwards() throws Exception {
		board[5][3] = piece;

		assertFalse(piece.isValidMove(new Move(5, 3, 6, 3), board));
	}
	
	/***********************************
	 * Checks invalid movement sideways.
	 * @throws Exception 
	 ***********************************/
	@Test
	public final void cantMoveSideways() throws Exception {

		board[5][3] = piece;

		assertFalse(piece.isValidMove(new Move(5, 3, 5, 4), board));
	}
	

}
