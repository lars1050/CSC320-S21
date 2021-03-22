import java.util.*;
import java.util.Random;

/**
Solve a Summation Optimization problem using either the paradigm of
dynamic programming or greedy.
The problem is to choose a minimally sized subset (that may have repeats)
from a given list of numbers whose summation equals a given total.

For example, if the numbers = { 0, 3, 1, 5, 1, 3, 4, 5 } and the total is 7,
then the subsets
- {3,1,3}
- {3,4}
- {1,5,1}
all sum to 7. However, the subset {3,4} has the smallest cardinality (i.e. size)
and thus is the optimal subset. The COST of this optimal solution is 2.
*/
public class SolverGreedy {

	/** The list of numbers to choose from */
	Integer[] numbers = null;

	/** Total that subset of numbers needs to sum to */
	Integer total = 0;

	/** start time in nanoseconds */
	private long startNS;
	/** end time in nanoseconds */
	private long endNS;

	// total operations
	int operations;

	/** For storing the numbers that make up the optimal subset.
	In the example up top, this would be equal to {3,4}. */
	private ArrayList<Integer> subset;

	/** Constructor. Initializes metrics to 0. */
	public SolverGreedy(Integer[] nums, Integer t) {

		numbers = nums;
		total = t;

		startNS = 0;
		endNS = 0;
	}

	// operations getter
	public int operations() { return operations; }

	/** A greedy approach to solving the Summation problem.
	@return Array of numbers that are the minimally sized subset of numbers.
	*/
	public ArrayList<Integer> solve() {

		endNS = 0;

		operations = 0;

		// initialize the solution list to empty
		subset = new ArrayList<Integer>();

		// start the timer
		startNS = System.nanoTime();

		solveWithGreedy();

		// mark the finish time
		endNS = System.nanoTime();

		// this for debugging purposes to check timer.
		System.out.println("start="+startNS+". end="+endNS+". elapsed="+(endNS-startNS)/1000);
		System.out.println("operations "+operations);

		return subset;
	} // end solve

	private void solveWithGreedy() {
		// Do not comment out this line.
		System.out.println("SOLVING summation using the Greedy Approach.");

		// Need to sort the numbers. Quicksort
		quicksort(0,numbers.length-1);

		Integer remaining = total;
		int index = numbers.length-1;
		while (index>0 && remaining>0) {
			++operations;
			if (numbers[index]<=remaining) {
				remaining = remaining - numbers[index];
				subset.add(numbers[index]);
			}
			--index;
		}

	}

	private void quicksort(int p, int r) {
		if (p<r) {
			int q = partition(p,r);;
			quicksort(p,q-1);
			quicksort(q+1,r);
		}
	}
	private int partition(int p, int r) {
		int index = new Random().nextInt((r-p+1))+p;
		Integer temp = numbers[index];
		numbers[index] = numbers[r];
		numbers[r] = temp;
		int lessDivision = p-1;
		for (index=p;index<r;index++ ) {
			++operations;
			if (numbers[index]<numbers[r]) {
				lessDivision++;
				temp = numbers[index];
				numbers[index] = numbers[lessDivision];
				numbers[lessDivision] = temp;
			}
		}
		++lessDivision;
		temp = numbers[r];
		numbers[r] = numbers[lessDivision];
		numbers[lessDivision] = temp;
		return lessDivision;
	}

		/** Getter for elapsed time in microsecs based on stored start and end time, which are in ns */
		public long elapsedTimeUS() {
			return (endNS - startNS) / 1000;
		}
	}
