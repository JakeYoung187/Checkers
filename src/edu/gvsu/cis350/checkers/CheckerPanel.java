package edu.gvsu.cis350.checkers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/**************************************************************
 * CheckerPanel class to create and set up board for game play.
 * 
 * @author Nate Benson, Kaye Suarez, Jake Young
 * @version 1.0 
 **************************************************************/

public class CheckerPanel extends JPanel {
	
	//add more icons for kings, 
	//also not sure if i actually need another class for just normal pieces
	//seems like bad coding
	
	/** board: array of buttons for board tiles. */
	private JButton[][] board;
	
	/** model: instance variable to hold CheckerModel. */
	private CheckerModel model;
	
	/** currentMove: holds value for the current move. */
	public Move currentMove;
	
//	private JButton pauseButton;
//	private JPanel rightSide;
	//public JMenuBar topMenu;
	
	/** image for redPieces. */
	private Image redPieces;
	
	/** image for grayPieces. */
	private Image grayPieces;
	
	/** resized image redPiece. */
	private Image redPieceResize;
	
	/** resized image grayPieceResize. */
	private Image grayPieceResize;
	
	/** red piece icon. */
	private ImageIcon rPieces;
	
	/** gray piece icon. */
	private ImageIcon gPieces;
	
	/** holds board size. */
	private static final int BOARDSIZE = 8;
	
	/** holds board dimension. */
	private static final int BOARDDIM = 80;
	
	/** holds resized red piece image. */
	private static final int REDSIZE = 105;
	
	/** holds resized gray piece image. */
	private static final int GRAYSIZE = 120;
	
	
	/*********************************************
	 * CheckerPanel creates board for game play.
	 *********************************************/
	
	public CheckerPanel() {
			
		addIcons();
		model = new CheckerModel();
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(BOARDSIZE, BOARDSIZE));
		add(center, BorderLayout.CENTER);
		board = new JButton[BOARDSIZE][BOARDSIZE];
		
		
		
//		rightSide = new JPanel();
//		rightSide.setLayout(new GridLayout(0, 1));
//		add(rightSide, BorderLayout.EAST);
//		pauseButton = new JButton("Pause");
//		pauseButton.setBackground(new Color(255, 0, 0));
//		pauseButton.setForeground(Color.BLACK);
//		pauseButton.setPreferredSize(new Dimension(50, 50));
//		Font f = new Font("Dialog", Font.PLAIN, 24);
//		pauseButton.setFont(f);
//		pauseButton.addMouseListener(listener);
//		rightSide.add(pauseButton);
		//topMenu = new JMenuBar();
		
		for (int r = 0; r < BOARDSIZE; r++) {
			for (int c = 0; c < BOARDSIZE; c++) {
				
				board[r][c] = new JButton("");
				board[r][c].addMouseListener(listener);
				board[r][c].setPreferredSize(new Dimension(BOARDDIM, BOARDDIM));
				center.add(board[r][c]);
			}
		}
		displayBoard();
	}
	
	/**************************************************************
	 * displayBoard sets icons to the different tiles on the board. 
	 **************************************************************/
	
	private void displayBoard() {
		
		for (int a = 0; a < BOARDSIZE; a++) {
			for (int b = 0; b < BOARDSIZE; b++) {
				
				if (a % 2 == b % 2) {
					board[a][b].setBackground(Color.RED);
					
				} else {
					board[a][b].setBackground(Color.BLACK);
				}
				
				if (model.pieceAt(a, b) != null) {
					if (model.pieceAt(a, b).type().equals("Pawn")) {
						
						if (model.pieceAt(a, b).player() == Player.GRAY) {
							board[a][b].setIcon(gPieces);
						}
						
						if (model.pieceAt(a, b).player() == Player.RED) {
							board[a][b].setIcon(rPieces);
						}
					}
					
				} else {
					board[a][b].setIcon(null);
				}
			}
		}
	}
	
	/***********************************************************
	 * addIcons sets the correct image to colored piece on tile.
	 ***********************************************************/
	
	private void addIcons() {
		//load graphics
		
		try {
			//load images
			redPieces = ImageIO.read(getClass().getResource(
									 "/Resources/beer-cap-icon-67249.png"));
			
			grayPieces = ImageIO.read(getClass().getResource(
									  "/Resources/ff-bottle-cap.png"));
			
			//resize images
			redPieceResize = 
					redPieces.getScaledInstance(REDSIZE, REDSIZE, REDSIZE);
			
			grayPieceResize = 
					grayPieces.getScaledInstance(GRAYSIZE, GRAYSIZE, GRAYSIZE);
			
			//set icons
			rPieces = new ImageIcon(redPieceResize);
			gPieces = new ImageIcon(grayPieceResize);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*****************************************************
	 * reset clears the current game and resets game play. 
	 *****************************************************/
	
	public final void reset() {
		model = new CheckerModel();
	}
	
	public void clearBoard() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(model.pieceAt(i, j) != null) {
					model.removePiece(i, j);
				}
			}
		}
	}
	
	// FIXME: NEEDS TO BE JAVADOC'D
	public void saveBoard(String filename) {
		try {
			PrintWriter out = new PrintWriter(filename + ".txt");
		 
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++){
					if(model.pieceAt(i, j) == null) {
						out.print("X,");
					}
					else if(model.pieceAt(i, j).type().equals("Pawn")) {
						if(model.pieceAt(i, j).player() == Player.GRAY) {
							out.print("PG,");
						}
						else
							out.print("PR,");
					}
					else {
						if(model.pieceAt(i, j).player() == Player.GRAY) {
							out.print("KG,");
						}
						else
							out.print("KR,");
					}
				}
			}
			out.close();
		} catch (IOException error1) {
			System.out.println("Failed to save file");
		}
	}

	// FIXME: NEEDS TO BE JAVADOC'D
	public void readBoard(String filename) {
		FileInputStream fileByteStream = null;
		Scanner inFS = null;
	
		try {
			// Input a filename and scan the file using commas as delimiter
			fileByteStream = new FileInputStream(filename);
			inFS = new Scanner(fileByteStream);
			inFS.useDelimiter("[,\r\n]+");
			
			// Read the board to ArrayList
			while(inFS.hasNext()) {
				clearBoard();
				ArrayList<String> list = new ArrayList<String>();
				for(int i = 0; i < 8; i++) { 
					for(int j = 0; j < 8; j++){
						String spot = inFS.next();
						if(spot.equals("PG")) {
							model.createPiece(i, j, false, false);
						}
						else if(spot.equals("PR")) {
							model.createPiece(i, j, false, true);
						}
						else if(spot.equals("KG")) {
							model.createPiece(i, j, true, false);
						}
						else if(spot.equals("KR")) {
							model.createPiece(i, j, true, true);
						}
					}
				}	
			}
			fileByteStream.close();
		} catch (FileNotFoundException error1) {
			System.out.println("Failed to open file: " + filename);
		} catch (IOException error2) {
			System.out.println("Oops! There was an error reading " + filename);
		}
	}
	
	// FIXME: NEEDS TO BE JAVADOC'D
	private void openFile() {
		String userDir = System.getProperty("user.dir");
		JFileChooser fc = new JFileChooser(userDir);
		
		// Show File Chooser and wait for user selection
		int returnVal = fc.showOpenDialog(this);
		
		// Did the user select a file?
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String filename = fc.getSelectedFile().getName();
			readBoard(filename);          
		}
	}
	
	/** holds values of mouse listener. */
	MouseListener listener = new MouseListener() {

		@Override
		public void mouseClicked(final MouseEvent a) {
			  if (a.getButton() == MouseEvent.BUTTON3) {
				Object[] options = {"Resume", "Save", "Load", "Restart", "Quit"};
				
				int n = JOptionPane.showOptionDialog(
						            null, "The Game is Paused.", "Checkers",
						            JOptionPane.DEFAULT_OPTION, 
						            JOptionPane.PLAIN_MESSAGE, null, 
						            options, options[0]);
				
				if (n == 0) {
					displayBoard();
					
				} else if (n == 1) {
					String str = JOptionPane.showInputDialog(null, "Enter file name (without .txt):");
					saveBoard(str);
					displayBoard();
					
				} else if (n == 2) {
					openFile();
					displayBoard();
				}
				else if (n ==3) {
					reset();
					displayBoard();
				}
				else if (n == 4) {
					System.exit(0);
				}
			}
			for (int r = 0; r < BOARDSIZE; r++) {
				for (int c = 0; c < BOARDSIZE; c++) {
					
					if (a.getButton() == MouseEvent.BUTTON1) {
						if (a.getSource() == board[r][c]) {
							
							if (model.pieceAt(r, c) != null) {
								if (model.pieceAt(r, c) != null) {
									
									if (model.pieceAt(r, c).player() 
											== model.getCurrentPlayer()) {
										
										if (model.getCurrentPiece() == null) {
											
											model.setCurrentPiece(
													model.pieceAt(r, c));
											System.out.println(r + " " + c);
											currentMove.fromRow = r;
											currentMove.fromColumn = c;
											
										} else {
											
											if (model.pieceAt(r, c).player() 
												  == model.getCurrentPlayer()) {
												
												model.setCurrentPiece(
														model.pieceAt(r, c));
												currentMove.fromRow = r;
												currentMove.fromColumn = c;
											}
										}
									}
								}
								
							} else {
								
								System.out.println(r + " " + c);
								currentMove.toRow = r;
								currentMove.toColumn = c;
								model.move(currentMove);
								model.currentPiece = null;
								displayBoard();
								
								//System.out.println(
								//model.pieceAt(currentMove.toRow, 
								//currentMove.toColumn).type());
							}
						}
//						if(e.getButton() == MouseEvent.BUTTON3) {
//							displayBoard();
//							if(e.getSource() == board[a][b]) {
//								if(model.getCurrentPiece() == null) {
//									if(model.pieceAt(a, b) != null) {
//										if(model.pieceAt(a, b).player()
//												== model.currentPlayer()) {
//											currentMove.fromRow = a;
//											currentMove.fromColumn = b;
//											highlight(a, b);
//											model.currentPiece = null;
					}
				}
			}
		}

		@Override
		public void mouseEntered(final MouseEvent a) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(final MouseEvent a) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(final MouseEvent a) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(final MouseEvent a) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
}
