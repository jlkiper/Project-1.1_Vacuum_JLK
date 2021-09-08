import java.lang.Math;

/**
 * Board.java
 * 
 * This program will implement the floor that will be vacuumed and 
 * show which squares are dirty and clean. Also this will count the number of
 * moves and sucks by the vacuum.
 * 
 * @author Jaylon Kiper
 * FALL2021
 * 9/2/2021
 */
public class Board {

	private Square floor[][];
	private Vacuum vacuum;
	private int x, y = 0;
	
	//Initializes the position of the vacuum.
	public Board(Vacuum vacuum, int x, int y) {
		
		this.vacuum = vacuum;
		this.x = x;
		this.y = y;
		
		createFloorAndRandomSetState();
		runVacuum();
		
	}//end Board method
	
	//Initializes the size of the board.
	public Board(Vacuum vacuum, Square floor[][]) {
		
		this.vacuum = vacuum;
		this.floor = floor;
		x = this.floor.length;
		y = this.floor.length;
		
		runVacuum();
		
	}//end second Board Method
	
	//Runs methods for vacuum location, floor layout, checks for the floor to be
	//clean and displays outcome.
	private void runVacuum() {
		
		provideVacuumLocation();
		showInitialFloor();
		cleanFloor();
		displayOutcome();
		
	}//end runVacuum method
	
	//Creates floor board with squares and links them randomly.
	private void createFloorAndRandomSetState() {
		
		setFloor();
		generateSquares();
		linkSquaresAndRandomSetDirty();
		
	}//end createFloorAndRandomSetState method
	
	//Sets the floor's size by its length and width.
	private void setFloor() {
		
		floor = new Square[x][y];
		
	}//end setFloor method
	
	//Produces the squares that are clean or dirty with two for loops.
	private void generateSquares() {
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				floor[i][j] = new Square(false, false);
			}//end inner loop
		}//end inner loop
		
	}//end generateSquares method
	
	//Links each square to dictate what direction the vacuum can go in.
	private void linkSquaresAndRandomSetDirty() {
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				linkRightLeftSquares(i, j);
				linkUpDownSquares(i, j);
				randomlyChangeStates(i, j);
			}//end inner loop
		}//end inner loop
		
	}//end linkSquaresAndRandomSetDirty method
	
	//Links the squares by how long the board is.
	private void linkRightLeftSquares(int i, int j) {
		
		if(i > 0 && x > 1) {
			
			floor[i - 1][j].setRight(floor[i][j]);
			floor[i][j].setLeft(floor[i - 1][j]);
			
		}//end if statement
		
	}//end linkRightLeftSquares method
	
	//Links the squares by how wide the board is.
	private void linkUpDownSquares(int i, int j) {
		
		if(j > 0 && y > 1) {
			
			floor[i][j - 1].setDown(floor[i][j]);
			floor[i][j].setUp(floor[i][j - 1]);
			
		}//end if statement
		
	}//end linkUpDownSquares method
	
	//Sets the location of the randomly generated squares.
	private void randomlyChangeStates(int i, int j) {
		
		if(randomlyChangeStates()) {
			floor[i][j].changeSquareState();
		}//end if statement
		
	}//end voided randomlyChangeStates method
	
	//Provides the random squares on the board.
	private boolean randomlyChangeStates() {
		
		return (Math.random() > 0.50);
		
	}//end boolean randomlyChangeStates method
	
	//Sets the vacuum in a random location based on the size of the board.
	private void provideVacuumLocation() {
		
		int randomX;
		int randomY;
		
		do {
			
			randomX = (int)(Math.random() * x);
			randomY = (int)(Math.random() * y);
			
		} while(floor[randomX][randomY] == null);
		//end do while loop
		
		vacuum.setVacuumLocation(floor[randomX][randomY]);
		
	}//end provideVacuumLocation method
	
	//Prints floor label.
	private void showInitialFloor() {
		
		System.out.println("Floor:");
		showFloor();
		
	}//end showInitialFloor method
	
	//Checks to see if the entire floor is clean or if the vacuum still needs to move.
	private void cleanFloor() {
		
		while(!checkIfFloorIsClean()) {
			
			cleanAndMoveVacuum();
			
		}//end while loop
		
	}//end cleanFloor method
	
	//Moves the vacuum and sucks the dirty squares.
	private void cleanAndMoveVacuum() {
		
		vacuum.vacuumSuction();
		vacuum.moveVacuum();
		
	}//end cleanAndMoveVacuum method
	
	//Displays the count on how many moves were made and the number of sucks
	//that vacuum did.
	private void displayOutcome() {
		
		System.out.println("The vacuum moved: " + vacuum.getMoves() + " times.");
		System.out.println("The vacuum sucked: " + vacuum.getSucksNumber() + " times.\n");
		
	}//end displayOutcome method
	
	//Shows a spaced layout of the floor by it length and width.
	private void showFloor() {
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				printFloorPiece(i, j);
			}//end inner for loop
			System.out.println();
		}//end for loop
		
	}//end ShowFloor method
	
	//Prints each square on the board and tabs a space for each one.
	private void printFloorPiece(int i, int j){ 
		
				System.out.print(floor[i][j] + "\t");
				
	}//end printFloorPiece method
	
	//Runs a scan of the entire floor to confirm that everything is clean.
	private boolean checkIfFloorIsClean(){
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				if(!checkIfFloorPieceIsClean(i, j))
					return false;
			}//end for loop
		}//end floor loop
		return true;
		
	}//end checkIfFloorIsClean method
	
	//Runs a try catch exception to see if each square piece is clean.
	private boolean checkIfFloorPieceIsClean(int i, int j){
		try{
			
			if(floor[i][j].dirty()) {
				
				return false;
				
			}//end if statement
	
		}catch(Exception e){} //end try catch statement
		
		return true;
	}//end checkIfFloorPieceIsClean method
	
	
}//end Board class
