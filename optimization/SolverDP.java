import java.util.ArrayList;

/**
Solve a Summation Optimization problem using dynamic programming. The user can specify whether the solution should be determined iteratively (bottom-up) or recursively (top-down).
*/
public class SolverDP {

	/** The list of numbers to choose from */
	Integer[] numbers = null;

	/** Target total that subset of numbers needs to sum to */
	Integer total = 0;

	/** start time in nanoseconds */
	private long startNS;
	/** end time in nanoseconds */
	private long endNS;

	/** Number of operations.
	For our purposes, the number of table entries calculated. */
	private int operations;

	/** flag to indicate if everything is initialized */
	private boolean needToInitialize = true;

	/** Matrix/table of cost for subproblem [i][j] which is the size of the smallest subset of numbers drawing from numbers[0..i] to sum to j).
	NOTE: initialized to nulls, which is used as the "marker". */
	private Integer[][] m;

	/** Matrix/table of selection (choice) for subproblem [i][j] that results in minimum cost. In other words, that number was used (1)) or not used (0)
	NOTE: initialized to 0, so default is "not included in subset".*/
	private int[][] s;

	/** For storing the numbers that make up the optimal subset.*/
	private ArrayList<Integer> subset;

	/** Constructor. Initializes metrics to 0. */
	public SolverDP(Integer[] nums, Integer t) {

		// store the numbers to choose from and the target total sum.
		numbers = nums;
		total = t;

		startNS = 0;
		endNS = 0;
		operations = 0;

		// initialize the cost and solution (selection) tables
		initializeTables();
	}

	/** Initialize the cost and selection tables.
	You can assume numbers[0] == 0
	*/
	public void initializeTables() {
		if (needToInitialize) {
			// initialize m, leave everything null (meaning not yet solved)
			m = new Integer[numbers.length][total+1];
			// initialize s, leave everything 0 (meaning do not use)
			s = new int[numbers.length][total+1];
			needToInitialize = false;
		}
	}

	/** A dynamic programming approach to solving the Summation problem.
	@param iterative True if using an iterative approach, False for recursive
	@return Array of numbers that are the minimally sized subset of numbers.
	*/
	public ArrayList<Integer> solve(boolean iterative) {

		// This ensures the tables are good for a new run.
		// In this way, you can create an instance of this class and
		// run both iterative and recursive versions on same array of numbers.
		initializeTables();
		endNS = 0;
		operations = 0;

		// start the timer
		startNS = System.nanoTime();

		// call appropriate algorithm
		if (iterative) {
			// Do not comment out this line.
			System.out.println("SOLVING summation using iterative DP.");
			solveWithIteration();
		} else {
			// Do not comment out this line.
			System.out.println("SOLVING summation using recursive DP.");
			// You can modify the signature of this function -- it is private
			// and your choice on how to implement.
			solveWithRecursion();
		}

		// mark the finish time
		endNS = System.nanoTime();

		// indicate that the tables have been completed and will need to be reset
		needToInitialize = true;

		// For runtime evaluation. There are time and op getters to use.
		System.out.println("start="+startNS+". end="+endNS+". elapsed="+(endNS-startNS)/1000);
		System.out.println("operations "+operations);

		return constructSolution();
	} // end solve

	// >>>>> COMPLETE THIS METHOD <<<<<<<<
	private void solveWithIteration() {
		// NOTE: be sure to count the number of table entries calculated.
	} // end solveWithIteration


	// >>>>> COMPLETE THIS METHOD <<<<<<<<
	// Either change the signature and make this the recursive function,
	// or create another recursive function called by this one -- your choice.
	private void solveWithRecursion() {

		// NOTE: be sure to count the number of table entries calcualed only.
		// One could also count the number of table entries accessed, but we
		// will just count calculated entries.
	}

	// >>>>> COMPLETE THIS METHOD <<<<<<<<
	// Given the s matrix, determine the optimal subset.
	// It is optimal because it has minimum cardinality (size)
	private ArrayList<Integer> constructSolution() {

		subset = new ArrayList<Integer>();

		// traverse through selection table (s), building the minimally
		// sized subset of numbers that sum to Total.

		return subset;
	}

	/** Pretty print matrix m */
	public void printCost() {
		if (null==m) {
			System.out.println("Subset size (cost) table is null.");
			return;
		}
		// Print first row with column headings
		System.out.print("      ");
		for (int col=0; col<=total; col++) {
			System.out.print(String.format("%3d ",col));
		}
		System.out.println();
		// Ready to print the rest, row by row
		for (int row=0; row<m.length; row++) {
			// Print number corresponding to row and the marker for start of row
			System.out.print(String.format("%3d [ ",numbers[row]));

			// print each column element in current row.
			for (int col=0;col<m[0].length; col++) {
				if (null == m[row][col]) {
					System.out.print("  - ");
				} else if (m[row][col]>numbers.length) {
					// print infinity symbole
					System.out.print("  "+String.valueOf(Character.toString('\u221E'))+" ");
				} else {
					// print value in m table
					System.out.print(String.format("%3d ",m[row][col]));
				} // end if-else
			} // end column for loop

		// Finish the row
		System.out.println("]");
		} // end row for loop
	} // end printCost

	/** Pretty print selection choices s */
	public void printSelection() {
		if (null==s) {
			System.out.println("Selection table is null.");
			return;
		}
		// Print first row with column headings
		System.out.print("     ");
		for (int col=0; col<=total; col++) {
			System.out.print(String.format("%2d ",col));
		}
		System.out.println();
		for (int row=0; row<s.length; row++) {
			System.out.print(String.format("%2d [ ",numbers[row]));
			for (int col=0;col<s[0].length; col++) {
				if (s[row][col]==1) {
					System.out.print(" 1 ");
				} else {
					System.out.print(" 0 ");
				}
			}
			System.out.println("]");
		}
	}

	/** Getter for elapsed time in microsecs based on stored start and end time, which are in ns */
	public long elapsedTimeUS() {
		return (endNS - startNS) / 1000;
	}

	// operations getter
	public int operations() { return operations; }
}
