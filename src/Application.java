import java.util.Scanner;

/**
 * Application.java
 * 
 * @author Jaylon Kiper
 * FALL2021
 * 9/2/2021
 *
 */
public class Application {

	public static void main(String[] args) {
		
		VacuumWorld();
		
	}//end main
	
	//Enter the size of the board and runs all the classes.
	public static void VacuumWorld() {
		
		Scanner scan = new Scanner(System.in);
		 
		System.out.print("Enter Length of Floor: ");
		int x = scan.nextInt();
		
		System.out.print("Enter Width of Floor: ");
		int y = scan.nextInt();
		
		System.out.println();
		
		Vacuum vac = new Vacuum();
		new Board(vac, x, y);
		scan.close();
		
	}//end VacuumWorld method
	
}//end Application class
