package edu.gvsu.cis350.checkers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/************************************************************
 * JUnit testing for the CheckerModel Class.
 * @author Nate Benson, Jake Young, Kaye Suarez
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
	public final void isNotCompleteTest() throws Exception {
		//TODO: FINISH GAME OVER METHOD
	//	assertFalse("Testing notIsComplete", model.gameOver());

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
	
}