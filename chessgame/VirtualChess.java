package chessgame;
/**
 *  This virtual chess game is played using the console.  Players input their moves into the console
 *  in the format of 'E1 to E5'.  After each move, the updated chess board is printed on the console.
 *  The game has implemented simple move validation for the different types of playing pieces.  The
 *  is exited when one of the players types in 'Exit' during their move, or when a King is taken by
 *  another piece.
 *  
 *  Future versions should implement constraints to prevent pieces from disappearing off the chess
 *  board, a piece of one colour taking another piece of the same colour, and more sophisticated game
 *  logic such as castling, checking for 'Check' and 'Checkmate' moves, et cetera.
 *  @author yinyekan
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class VirtualChess {
	
	// Declare logger
	private final static Logger LOGGER = Logger.getLogger(VirtualChess.class.getName());

	// Reference: https://moodle.ucl.ac.uk/pluginfile.php/3058331/mod_resource/content/1/Tutorial%201.pdf
	public enum Chessmen{
		WHITE_KING,
		WHITE_QUEEN,
		WHITE_KNIGHT,
		WHITE_CASTLE,
		WHITE_BISHOP,
		WHITE_PAWN,
		BLACK_KING,
		BLACK_QUEEN,
		BLACK_KNIGHT,
		BLACK_CASTLE,
		BLACK_BISHOP,
		BLACK_PAWN,
		EMPTY
	}
	
	// Reference: http://pad3.whstatic.com/images/e/e8/Chessboard-Diagram.png
	public static void main(String[] args) {
	
		try {
			ChessLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot set up ChessLogger");
		}
		
		LOGGER.setLevel(Level.ALL);
		
		Chessmen[][] chessboard = new Chessmen[8][8]; // Reference: https://moodle.ucl.ac.uk/pluginfile.php/3058331/mod_resource/content/1/Tutorial%201.pdf
		
		for (int i = 0; i < 8; i++){
			
			for (int j = 0; j < 8; j++){
				
				switch (i)
				{
					case 0:
					{
						if (j == 0 || j == 7){
							chessboard[i][j] = Chessmen.BLACK_CASTLE;
						}
						if (j == 1 || j == 6){
							chessboard[i][j] = Chessmen.BLACK_KNIGHT;
						}
						if (j == 2 || j == 5){
							chessboard[i][j] = Chessmen.BLACK_BISHOP;
						}
						if (j == 3){
							chessboard[i][j] = Chessmen.BLACK_KING;
						}
						if (j == 4){
							chessboard[i][j] = Chessmen.BLACK_QUEEN;
						}
						continue;
					}
					case 1:
					{
						chessboard[i][j] = Chessmen.BLACK_PAWN;
						continue;
					}
					case 6:
					{
						chessboard[i][j] = Chessmen.WHITE_PAWN;
						continue;
					}	
					case 7:
					{
						if (j == 0 || j == 7){
							chessboard[i][j] = Chessmen.WHITE_CASTLE;
						}
						if (j == 1 || j == 6){
							chessboard[i][j] = Chessmen.WHITE_KNIGHT;
						}
						if (j == 2 || j == 5){
							chessboard[i][j] = Chessmen.WHITE_BISHOP;
						}
						if (j == 3){
							chessboard[i][j] = Chessmen.WHITE_QUEEN;
						}
						if (j == 4){
							chessboard[i][j] = Chessmen.WHITE_KING;
						}
						continue;
					}
					default:
					{
						chessboard[i][j] = Chessmen.EMPTY;
					}
				}
					
			}
			
		}
		
		printBoard(chessboard);
		
		Scanner robot = new Scanner(System.in);
		String move = new String();
		
		{
			do {
			System.out.println("What is your move e.g. 'E1 to E5'? Type 'EXIT' to exit the game.");
			move = robot.nextLine();
			if (move.compareTo("EXIT")==0) // Reference: http://www.tutorialspoint.com/java/java_string_compareto.htm
				break;
			else {
				chessboard = updateBoard(move, chessboard);
				printBoard(chessboard);
				}
			} while (true); // Reference: Help from tutor
		}
		
		robot.close();
	}

/**
 * The printBoard method prints the chess board to the console.
 * @param chessboard
 */
	public static void printBoard(Chessmen[][] chessboard){
		
		System.out.println("\tA\tB\tC\tD\tE\tF\tG\tH");
		
			for (int i = 0; i < 8; i++){
				System.out.print(8-i +".");
				for (int j = 0; j < 8; j++){
					
					String chesspiece = new String();
					switch (chessboard[i][j]){
					case BLACK_CASTLE:
						chesspiece = "BC";
						break;
					case BLACK_KNIGHT:
						chesspiece = "BN";
						break;
					case BLACK_BISHOP:
						chesspiece = "BB";
						break;
					case BLACK_KING:
						chesspiece = "BK";
						break;
					case BLACK_QUEEN:
						chesspiece = "BQ";
						break;
					case BLACK_PAWN:
						chesspiece = "BP";
						break;
					case WHITE_CASTLE:
						chesspiece = "WC";
						break;
					case WHITE_KNIGHT:
						chesspiece = "WN";
						break;
					case WHITE_BISHOP:
						chesspiece = "WB";
						break;
					case WHITE_QUEEN:
						chesspiece = "WQ";
						break;
					case WHITE_KING:
						chesspiece = "WK";
						break;
					case WHITE_PAWN:
						chesspiece = "WP";
						break;
					case EMPTY:
						chesspiece = "  ";
						break;
					default:
						chesspiece = "  ";
					}
					System.out.print("\t" + chesspiece);
				}
		System.out.println();
		}
		
	}
	
/**
 * The updateBoard method updates the chess board with the move that the player has entered into the console.
 * @param move
 * @param chessboard
 * @return
 */
	public static Chessmen[][] updateBoard(String move, Chessmen[][]chessboard){
		
		LOGGER.info(move);
		
		// Reference: https://moodle.ucl.ac.uk/pluginfile.php/3058331/mod_resource/content/1/Tutorial%201.pdf
		// Reference: http://www.w3schools.com/jsref/jsref_split.asp
		String[] moveComponents = move.split(" ");
		char from_charj = moveComponents[0].charAt(0);
		char from_chari = moveComponents[0].charAt(1);
		char to_charj = moveComponents[2].charAt(0);
		char to_chari = moveComponents[2].charAt(1);
		
		int from_i = convertCoordinates(from_chari);
		int from_j = convertCoordinates(from_charj);
		int to_i = convertCoordinates(to_chari);
		int to_j = convertCoordinates(to_charj);
		
		Chessmen piece = chessboard[from_i][from_j];
		Chessmen target = chessboard[to_i][to_j];
		
		if (checkLegal(piece, target, from_i, from_j, to_i, to_j)){
			if (target == Chessmen.BLACK_KING || target == Chessmen.WHITE_KING){
				LOGGER.severe("King is captured.  Game over.");
				System.out.println("King is captured.  Game over.");
				System.exit(0); // Reference: Help from tutor
			} else {
				chessboard[to_i][to_j] = chessboard[from_i][from_j];
				chessboard[from_i][from_j] = Chessmen.EMPTY;
			}} 
			else {
				LOGGER.severe("That is an illegal move");
				System.out.println("That is an illegal move.");
			}
		return chessboard;
	}
	
/**
 * The convertCoordinates method converts the moves entered by the player in standard chess terminology
 * into coordinates that correspond to the programming logic.
 * @param userCoordinates
 * @return
 */
	public static int convertCoordinates(char userCoordinates){
		
		// Reference: http://www.asciitable.com/
		int boardCoordinates = -1;
		
		switch (userCoordinates)
		{
			case 49: // 1
				boardCoordinates = 7;
				break;
			case 50: // 2
				boardCoordinates = 6;
				break;
			case 51: // 3
				boardCoordinates = 5;
				break;
			case 52: // 4
				boardCoordinates = 4;
				break;
			case 53: // 5
				boardCoordinates = 3;
				break;
			case 54: // 6
				boardCoordinates = 2;
				break;
			case 55: // 7
				boardCoordinates = 1;
				break;
			case 56: // 8
				boardCoordinates = 0;
				break;
			case 65: // A
				boardCoordinates = 0;
				break;
			case 66: // B
				boardCoordinates = 1;
				break;
			case 67: // C
				boardCoordinates = 2;
				break;
			case 68: // D
				boardCoordinates = 3;
				break;
			case 69: // E
				boardCoordinates = 4;
				break;
			case 70: // F
				boardCoordinates = 5;
				break;
			case 71: // G
				boardCoordinates = 6;
				break;
			case 72: // H
				boardCoordinates = 7;
				break;
		}
		return boardCoordinates;
	}
	
/**
 * The checkLegal method checks if the move entered by the player follows the most basic movement rules
 * for each type of chess piece.
 * @param piece
 * @param target
 * @param from_i
 * @param from_j
 * @param to_i
 * @param to_j
 * @return
 */
	public static boolean checkLegal(Chessmen piece, Chessmen target, int from_i, int from_j, int to_i, int to_j){
		
		// Reference: https://en.wikipedia.org/wiki/Rules_of_chess
		// Rules for moving
		int delta_i = from_i - to_i;
		int delta_j = from_j - to_j;
		
		// Reference: http://stackoverflow.com/questions/9706869/calculating-magnitude-of-a-number-in-java
		if (piece == Chessmen.BLACK_KNIGHT || piece == Chessmen.WHITE_KNIGHT){
			if ((Math.abs(delta_i) == 1 && Math.abs(delta_j) == 2) || (Math.abs(delta_i) == 2 && Math.abs(delta_j) == 1)){
				return true;
			} else {
				return false;
			}
		}
		
		if (piece == Chessmen.BLACK_BISHOP || piece == Chessmen.WHITE_BISHOP){
			if (Math.abs(delta_i) == Math.abs(delta_j)){
				return true;
			} else {
				return false;
			}
		}
			
		if (piece == Chessmen.BLACK_CASTLE || piece == Chessmen.WHITE_CASTLE){
			if ((Math.abs(delta_i) > 0 && Math.abs(delta_j) == 0) || (Math.abs(delta_i) == 0 && Math.abs(delta_j) > 0)){
				return true;
			} else {
				return false;
			}
		}
		
		if (piece == Chessmen.BLACK_KING || piece == Chessmen.WHITE_KING){
			if (Math.abs(delta_i) < 2 && Math.abs(delta_j) < 2){
				return true;
			} else {
				return false;
			}
		}
			
		if (piece == Chessmen.BLACK_QUEEN || piece == Chessmen.WHITE_QUEEN){
			if (Math.abs(delta_i) == Math.abs(delta_j) || (Math.abs(delta_i) > 0 && Math.abs(delta_j) == 0) || (Math.abs(delta_i) == 0 && Math.abs(delta_j) > 0)){
				return true;
			} else {
				return false;
			}
		}
		
		if (piece == Chessmen.BLACK_PAWN || piece == Chessmen.WHITE_PAWN){
			if (target == Chessmen.EMPTY){
				if (Math.abs(delta_i) == 1 && Math.abs(delta_j) == 0){
					return true;
				} else {
					if (Math.abs(delta_i) == 1 && Math.abs(delta_j) == 1){
						return true;
					} else {
						return false;
					}
				}
			}
		}
		return false;
	}
}
