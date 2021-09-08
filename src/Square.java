/**
 * Square.java
 * 
 * This program will set the squares as if they are dirty or clean, while
 * also setting if the space is occupied or unoccupied.
 * 
 * @author Jaylon Kiper
 * FALL2021
 * 9/2/2021
 */
public class Square {
	
	private boolean dirty;
	private boolean dirtyoccupied;
	private Square up,down,right,left = null;
	
	//Initializes squares as dirty unoccupied and dirty occupied.
	public Square(boolean dirty, boolean dirtyoccupied) {
		
		this.dirty = dirty;
		this.dirtyoccupied = dirtyoccupied;
		
	}//end Square method
	
	//Initializes squares as either dirty and being able to move in any direction.
	public Square(boolean dirty, boolean dirtyoccupied, Square up, Square down, Square right, Square left) {
		
		this.dirty = dirty;
		this.dirtyoccupied = dirtyoccupied;
		this.up = up;
		this.down = down;
		this.right = right;
		this.left = left;
		
	}//end second Square method
	
	//Returns the space as an unoccupied dirty space.
	public boolean dirty() {
		
		return dirty;
		
	}//end dirty return method
	
	//Returns the space as an occupied dirty space.
	public boolean dirtyOccupied() {
			
		return dirtyoccupied;
			
	}//end dirtyOccupied return method

	
	//This method will tell if the square space is dirty.
	public void changeSquareState() {
		
		if(dirty) {
			dirty = false;
		}else
			dirty = true;
		//end if else statement
		
		if(dirtyoccupied) {
			dirtyoccupied = true;
		}else
			dirtyoccupied = false;
			
	}//end changeSquareState method
	
	//Returns the up function.
	public Square getUp() {
		
		return up;
		
	}//end getUp method
	
	//Set the vacuum to move up.
	public void setUp(Square up) {
		
		this.up = up;
		
	}//end setUp method
	
	//Returns the down function.
	public Square getDown() {
			
		return down;
			
	}//end getUp method
		
	//Set the vacuum to move down.
	public void setDown(Square down) {
			
		this.down = down;
			
	}//end setDown method
	
	//Returns the right function.
	public Square getRight() {
			
		return right;
			
	}//end getRight method
		
	//Set the vacuum to move up.
	public void setRight(Square right) {
			
		this.right = right;
			
	}//end setRight method
		
	//Returns the left function.
	public Square getLeft() {
				
		return left;
				
	}//end getLeft method
			
	//Set the vacuum to move down.
	public void setLeft(Square left) {
				
		this.left = left;
				
	}//end setDown method
	
	//Returns strings of the squares as how they are presented.
	public String toString() {
		
		if(dirty)
			return "DU";
		else if(dirtyoccupied)
			return "DO";
		else 
			return "CU";	
	}//end toString method
	
}//end Square class
