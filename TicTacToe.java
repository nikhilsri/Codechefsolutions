
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.*;

public class Main {
	
	private static final char COMPUTERMOVE = 'O';
	private static final char HUMANMOVE = 'X';
	private static int COMPUTER =1;
	private static int HUMAN= 2;
	private static int SIDE= 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playTicTacToe(COMPUTER);
	}

	private static void playTicTacToe(int whoseTurn) {
		
		char[][] board = new char [SIDE][SIDE];
		
		Integer[] moves=new Integer [SIDE*SIDE];
		
		// Initialise the game
		initialise(board, moves);
		//Map<Integer,Integer> hm=new HashMap<Integer,Integer>();
		
		
		// Show the instructions before playing
		showInstructions();
		
		int moveIndex = 0, x, y;
		
		// Keep playing till the game is over or it is a draw
		while (gameOver(board) == false &&
				moveIndex != SIDE*SIDE)
		{
			int aa=moves[moveIndex]+1;
			if (whoseTurn == COMPUTER)
			{
				x = moves[moveIndex] / SIDE;
				y = moves[moveIndex] % SIDE;
				board[x][y] = COMPUTERMOVE;
				
				System.out.println("COMPUTER has put a " + COMPUTERMOVE +" in cell "+aa);
				showBoard(board);
				moveIndex ++;
				whoseTurn = HUMAN;
			}
			
			else if (whoseTurn == HUMAN)
			{
				x = moves[moveIndex] / SIDE;
				y = moves[moveIndex] % SIDE;
				board[x][y] = HUMANMOVE;
				System.out.println ("HUMAN has put a "+HUMANMOVE+" in cell "+aa);
				showBoard(board);
				moveIndex ++;
				whoseTurn = COMPUTER;
			}
		}

		// If the game has drawn
		if (gameOver(board) == false &&
				moveIndex == SIDE * SIDE)
			System.out.println("It's a draw");
		else
		{
			// Toggling the user to declare the actual
			// winner
			if (whoseTurn == COMPUTER)
				whoseTurn = HUMAN;
			else if (whoseTurn == HUMAN)
				whoseTurn = COMPUTER;
			
			// Declare the winner
			declareWinner(whoseTurn);
		}
		return;
	}

	private static void declareWinner(int whoseTurn) {
		// TODO Auto-generated method stub
		if (whoseTurn == COMPUTER)
			System.out.println("COMPUTER has won");
		else
			System.out.println("HUMAN has won");
		return;
		
	}

	private static void showBoard(char[][] board) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println();
		
		System.out.println("\t\t\t "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]);
		System.out.println("\t\t\t--------------");
		System.out.println("\t\t\t "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
		System.out.println("\t\t\t--------------");
		System.out.println("\t\t\t "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]);
		
		return;
		
	}

	private static boolean gameOver(char[][] board) {
		return(rowCrossed(board) || columnCrossed(board)
				|| diagonalCrossed(board) );
	}

	private static boolean diagonalCrossed(char[][] board) {
		if (board[0][0] == board[1][1] &&
				board[1][1] == board[2][2] &&
				board[0][0] != ' ')
				return(true);
				
			if (board[0][2] == board[1][1] &&
				board[1][1] == board[2][0] &&
				board[0][2] != ' ')
				return(true);

			return(false);
	}

	private static boolean columnCrossed(char[][] board) {
		for (int i=0; i<SIDE; i++)
		{
			if (board[0][i] == board[1][i] &&
				board[1][i] == board[2][i] &&
				board[0][i] != ' ')
				return (true);
		}
		return(false);
	}

	private static boolean rowCrossed(char[][] board) {
		for (int i=0; i<SIDE; i++)
		{
			if (board[i][0] == board[i][1] &&
				board[i][1] == board[i][2] &&
				board[i][0] != ' ')
				return (true);
		}
		return(false);
	}

	private static void showInstructions() {
		// TODO Auto-generated method stub
		System.out.println("\t\t\t Tic-Tac-Toe");
		System.out.println("Choose a cell numbered from 1 to 9 as below and play");
		
		System.out.println("\t\t\t 1 | 2 | 3 ");
		System.out.println("\t\t\t--------------");
		System.out.println("\t\t\t 4 | 5 | 6 ");
		System.out.println("\t\t\t--------------");
		System.out.println("\t\t\t 7 | 8 | 9 ");
		
		System.out.println("-\t-\t-\t-\t-\t-\t-\t-\t-\t-");

		return;
		
	}

		// TODO Auto-generated method stub
	private static void initialise(char[][] board, Integer[] moves) {
		
		
		Random rand = new Random();
		// Initially the board is empty
		for (int i=0; i<SIDE; i++)
		{
			for (int j=0; j<SIDE; j++)
				board[i][j] = ' ';
		}
		
		// Fill the moves with numbers
		for (int i=0; i<SIDE*SIDE; i++)
			moves[i] = i;

		// randomise the moves
		
		for (int i = 0; i < moves.length; i++) {
			int randomIndexToSwap = rand.nextInt(moves.length);
			int temp = moves[randomIndexToSwap];
			moves[randomIndexToSwap] = moves[i];
			moves[i] = temp;
		}
		return;
		
	}

}
