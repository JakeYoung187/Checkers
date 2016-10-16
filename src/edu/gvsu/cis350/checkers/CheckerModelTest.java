package edu.gvsu.cis350.checkers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/************************************************************
 * JUnit testing for the CheckerModel Class.
 * 
 * @author Nate Benson, Kaye Suarez, Jake Young
 * @version 1.0 
 ************************************************************/

public class CheckerModelTest {
	
	/** Test Checker Model. */
	protected ICheckerModel model;
	
	/****************************
	 * Create Test Checker model.
	 ****************************/
	@Before
	public final void setup() {
		model = new CheckerModel();
	}
	
	/**************************************************** 
	 * Test if game is over.  Move to capture last piece.
	 * @throws Exception 
	 ****************************************************/
	@Test
	public final void noGameOver() throws Exception {
		model.move(new Move(5, 3, 4, 2));
	
		assertFalse("Testing notIsComplete", model.gameOver());
	}
	
	
	/****************************
	 * Checks if piece was moved. 
	 * @throws Exception 
	 ****************************/
	@Test
	public final void moveWorks() throws Exception {

		IGamePiece piece = model.pieceAt(5, 3);
		model.move(new Move(5, 3, 4, 2));

		assertEquals(model.pieceAt(4, 2), piece);

	}
	
	/*****************************************
	 * Checks if piece was moved and captured. 
	 * @throws Exception 
	 *****************************************/
	@Test
	public final void captureWorks() throws Exception {

		IGamePiece piece = model.pieceAt(5, 3);
		IGamePiece other = model.pieceAt(2, 6);
		model.move(new Move(5, 3, 4, 4));
		model.move(new Move(2, 6, 3, 5));
		model.move(new Move(4, 4, 2, 6));

		assertEquals(model.pieceAt(2, 6), piece);
		assertEquals(null, model.pieceAt(3, 5));
	}
	
	
	/***************************************
	 * Checks if player switches after turn.
	 * @throws Exception 
	 ***************************************/
	@Test
	public final void playerSwitches() throws Exception {

		Player p = model.getCurrentPlayer();
		model.move(new Move(5, 3, 4, 2));

		assertTrue(!p.equals(model.getCurrentPlayer()));

	}
	
	/******************************************
	 * Checks player moves piece on wrong turn.
	 * @throws Exception  
	 ******************************************/
	@Test
	public final void wrongTurn() throws Exception {

		Player p = model.getCurrentPlayer();
		model.move(new Move(5, 3, 4, 2));

		assertTrue(!p.equals(model.getCurrentPlayer()));

	}
	
	
}
