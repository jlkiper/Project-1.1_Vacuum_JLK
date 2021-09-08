import java.lang.Math;

/**
 * Vacuum.java
 * 
 * This program provides the functions for the vacuum to move in any direction and 
 * count the number of sucks in a dirty unoccupied square.
 * 
 * @author Jaylon Kiper
 * FALL2021
 * 9/2/2021
 */
public class Vacuum {
	
	private Square location;
	private int moves = 0;
	private int totalVacuumSucks = 0;

	//This allows the vacuum to be able to move on the board.
	public void moveVacuum() {
		
		boolean hasMoved = false;
		
		while(!hasMoved) {
			hasMoved = tryToMoveVaccum((int)(Math.random() * 4));
		}//end while loop
		
		moves++;
		
	}//end moveVacuum method
	
	//This makes the vacuum move in the four cardinal directions on the board.
	private boolean tryToMoveVaccum(int move) {
		
		switch(move) {
			
		case 0:
			if(moveUp()) {
				
				setVacuumLocation(location.getUp());
				return true;
				
			}//end case 0
			break;
			
		case 1:
			if(moveDown()) {
				
				setVacuumLocation(location.getDown());
				return true;
				
			}//end case 1
			break;
			
		case 2:
			if(moveRight()) {
				
				setVacuumLocation(location.getRight());
				return true;
				
			}//end case 2
			break;
			
		case 3:
			if(moveLeft()) {
				
				setVacuumLocation(location.getLeft());
				return true;
				
			}//end case 3
			break;
		
		}//end switch statement
		return false;
		
	}//end tryToMoveVacuum method
	
	//Allows the vacuum to suck a dirty square on the board.
	public void vacuumSuction() {
		
		if(location.dirtyOccupied()) {
			
			location.changeSquareState();
			
		}else if(location.dirty()) {
			
			location.changeSquareState();
			totalVacuumSucks++;
			
		}//end if else statement
		
	}//end vacuumSuction method
	
	//Sets which square the vacuum is on.
	public void setVacuumLocation(Square location) {
		
		this.location = location;
		
	}//end setVacuumLocation
	
	//Counts the number of moves made on the board.
	public int getMoves() {
		
		return moves;
		
	}//end getMoves method
	
	//Counts the number of times the vacuum sucked dirt.
	public int getSucksNumber() {
		
		return totalVacuumSucks;
		
	}//end getSucksNumber method 
	
	//Moves Vacuum up on the board.
	private boolean moveUp() {
		
		return location.getUp() != null;
		
	}//end moveUp method
	
	//Moves Vacuum down on the board.
	private boolean moveDown() {
		
		return location.getDown() != null;
		
	}//end moveDown method
	
	//Moves Vacuum right on the board.
	private boolean moveRight() {
		
		return location.getRight() != null;
		
	}//end moveRight method
	
	//Moves Vacuum left on the board.
	private boolean moveLeft() {
		
		return location.getLeft() != null;
		
	}//end moveLeft method
	
}//end Vacuum class
