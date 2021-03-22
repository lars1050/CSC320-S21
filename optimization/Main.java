import java.util.Random;
import java.util.ArrayList;

/** Framework to test your optimization algorithms for Summations problem. */
public class Main {

	// EXAMPLE PROBLEM
	// Try out different problems here
	static Integer[] numbers = { 0, 4, 3, 5, 1, 3, 4, 5 };
	static Integer targetSum = 7;
	static Integer optimalSize = 2;		// {3,4}

	public static void main(final String[] args) {

		/** The subset of numbers that should total to sum (if solved) */
		ArrayList<Integer> subset;

		// Create instance of each problem solving technique
		SolverDP summationSolverDP = new SolverDP(numbers,targetSum);
		SolverGreedy summationSolverGreedy = new SolverGreedy(numbers,targetSum);

		//----------------------------------------------------------------------
		//----------------------------------------------------------------------
		//  ***** Test of ITERATIVE VERSION *******
		//----------------------------------------------------------------------
		//----------------------------------------------------------------------

		// Return the subset of numbers that add to the total (if solved)
		subset = summationSolverDP.solve(true); 	// iterative

		// PRINT RESULTS TO VERIFY CODE
		System.out.println("------ m table (Subset Size) ------");
		summationSolverDP.printCost();
		System.out.println("\n------ s table (Selection) ------");
		summationSolverDP.printSelection();
		System.out.println("\n------- OPTIMAL SET -----");
		System.out.print("{");
		for (Integer n : subset) {
			System.out.print(n+" ");
		}
		System.out.println("}");

		// Determine if this is an optimal solution.
		if (foundSolution(subset)) {
			System.out.println("ITERATIVE WORKING!!\n");
		} else {
			System.out.println("SOMETHING NOT RIGHT -- FIX YOUR CODE.");
		}

		//----------------------------------------------------------------------
		//----------------------------------------------------------------------
		//    ***** Test of RECURSIVE VERSION ******
		//----------------------------------------------------------------------
		//----------------------------------------------------------------------

		subset = summationSolverDP.solve(false); 	// recursive

		// PRINT RESULTS TO VERIFY CODE
		System.out.println("------ m table (Subset Size) ------");
		summationSolverDP.printCost();
		System.out.println("\n------ s table (Selection) ------");
		summationSolverDP.printSelection();
		System.out.println("\n------- OPTIMAL SET -----");
		System.out.print("{");
		for (Integer n : subset) {
			System.out.print(n+" ");
		}
		System.out.println("}");

		// Determine if this is an optimal solution
		if (foundSolution(subset)) {
			System.out.println("RECURSIVE WORKING!!\n");
		} else {
			System.out.println("SOMETHING NOT RIGHT -- FIX YOUR CODE.");
		}

		//----------------------------------------------------------------------
		//----------------------------------------------------------------------
		//    ***** Test of GREEDY VERSION ******
		//----------------------------------------------------------------------
		//----------------------------------------------------------------------

		subset = summationSolverGreedy.solve();

		// PRINT RESULTS TO VERIFY CODE
		System.out.println("\n------- OPTIMAL SET -----");
		System.out.print("{");
		for (Integer n : subset) {
			System.out.print(n+" ");
		}
		System.out.println("}");

		// Determine if this is an optimal solution
		if (foundSolution(subset)) {
			System.out.println("GREEDY WORKING!!\n");
		} else {
			System.out.println("Greedy failed to produce optimal solution.");
		}
	}

	//----------------------------------------------------------------------
	//----------------------------------------------------------------------
	// 					Solution verification.

	public static boolean foundSolution(ArrayList<Integer> list) {

		// Are there any values in the list?
		if (null == list) {
			System.out.println("Subset is empty. Probably wrong.");
			return false;
		}

		// Do the values in the subset, sum to the desired total ??
		Integer sum = 0;
		for (Integer n : list) {
			sum += n;
		}
		if (sum != targetSum) {
			System.out.println("Subset does not sum to desired total.");
			return false;
		}

		// Is it the optimal size?
		if (list.size() != optimalSize) {
			System.out.println("Cardinality does not match that of optimal set.");
			return false;
		}
		return true;
	}
} // end class Main
