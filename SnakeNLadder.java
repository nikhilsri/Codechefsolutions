import java.util.*;
public class Main {

	private static int COMPUTER =1;
	private static int HUMAN= 2;
	private static int SIDE= 10;
	private static Map<Integer,Integer> snakeMap=new HashMap<Integer,Integer>();
	private static Map<Integer,Integer> ladderMap=new HashMap<Integer,Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playSnakeNLadder(COMPUTER);
	}

	private static void playSnakeNLadder(int whoseTurn) {
		// TODO Auto-generated method stub
	
		initialiseSnakeNLadderMap(snakeMap,ladderMap);
		
		showInstructions();
		
		int  computerPrev=0, computerCurr=0,x=0,humanPrev=0,humanCurr=0,y=0;
		
		// Keep playing till the game is over or it is a draw
		while (gameOver(computerCurr,humanCurr) == false)
		{	
			if (whoseTurn == COMPUTER)
			{			
				x = rollDice(6);
				System.out.println("COMPUTER has got " + x +" on dice \n");
				computerCurr=computerPrev+x;			
				if(snakeExist(computerCurr)) {
					System.out.println("----===== Shittt COMPUTER has got biten by snake at " + computerCurr +" on board======------- \n");
					computerCurr=newPosAfterSnakeBite(computerCurr);
					
				}
				if(ladderExist(computerCurr)) {
					System.out.println("----===== Voohooo COMPUTER has got Ladder at " + computerCurr +" on board======------- \n");
					computerCurr=newPosAfterLadder(computerCurr);
				}	
				if(computerPrev+x > 100) {
					computerCurr=computerPrev;
				}
				System.out.println("NOW COMPUTER is on " + computerCurr +" in board ");
				//showBoard(board);
				//moveIndex ++;
				computerPrev=computerCurr;			
				whoseTurn = HUMAN;
			}			
			else if (whoseTurn == HUMAN)
			{
				y = rollDice(6);
				System.out.println("HUMAN has got " + y +" on dice \n\n");
				humanCurr=humanPrev+y;
				if(snakeExist(humanCurr)) {
					System.out.println("----===== Shittt HUMAN has got biten by snake at " + humanCurr +" on board======------- \n");
					humanCurr=newPosAfterSnakeBite(humanCurr);
				}
				if(ladderExist(humanCurr)) {
					System.out.println("----===== Voohooo HUMAN has got Ladder at " + humanCurr +" on board======------- \n");
					humanCurr=newPosAfterLadder(humanCurr);
				}
				if(humanPrev+y > 100) {
					humanCurr=humanPrev;
				}
				System.out.println("NOW HUMAN is on " + humanCurr +" in board ");
				//showBoard(board);
				//moveIndex ++;
				humanPrev=humanCurr;			
				whoseTurn = COMPUTER;
			}
		}

		if (whoseTurn == COMPUTER)
			whoseTurn = HUMAN;
		else if (whoseTurn == HUMAN)
			whoseTurn = COMPUTER;
		
		// Declare the winner
		declareWinner(whoseTurn);
		
		return;
		
	}

	private static void initialiseSnakeNLadderMap(Map<Integer, Integer> snakeMap, Map<Integer, Integer> ladderMap) {
		// TODO Auto-generated method stub
		System.out.println("\t\t\t Snake N Ladder \n");
		Random rand=new Random();
		int key=0;
		while(snakeMap.size()<5) {
			if(rand.nextInt(80)>=30)
				key=rand.nextInt(80);
			if(key>=30) {
				snakeMap.put(key, key-8);
			}
		}
		
		key=0;
		while(ladderMap.size()<5) {
			if(rand.nextInt(80)>=20)
				key=rand.nextInt(80);
			if(key>=20) {
				if(!snakeMap.containsValue(key))
					ladderMap.put(key, key+9);
			}
		}
		
		System.out.println("-------========= Board with snake and ladder initialised =========----------- \n");
	}

	private static void declareWinner(int whoseTurn) {
		// TODO Auto-generated method stub
		if (whoseTurn == COMPUTER)
			System.out.println("COMPUTER has won");
		else
			System.out.println("HUMAN has won");
		return;
		
	}

	private static int newPosAfterLadder(int curr) {
		// TODO Auto-generated method stub
		return ladderMap.get(curr);
	}

	private static int newPosAfterSnakeBite(int curr) {
		// TODO Auto-generated method stub
		return snakeMap.get(curr);
	}

	private static boolean ladderExist(int curr) {
		// TODO Auto-generated method stub
		if(ladderMap.containsKey(curr)) {
			return true;
		}
		return false;
	}

	private static boolean snakeExist(int curr) {
		// TODO Auto-generated method stub
		if(snakeMap.containsKey(curr)) {
			return true;
		}
		return false;
	}

	private static int rollDice(int moves) {
		Random rand = new Random();
		int nos=0;
		while(true) {
			nos=rand.nextInt(moves);
			if(nos !=0) break;
		}
		return nos;
	}

	private static boolean gameOver(int computerCurr,int humanCurr) {
		// TODO Auto-generated method stub
		if(computerCurr>=100 || humanCurr>=100) {
			return true;
		}
		return false;
	}
	
	private static void showInstructions() {
		// TODO Auto-generated method stub
		
		System.out.println("-------========= Roll a dice and play =========----------- \n");

		return;
		
	}

}
