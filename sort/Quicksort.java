import java.util.function.Function;

/** Used as part of a comparative study of different sorting algorithms. */
public class Quicksort <T extends Comparable<T>> {

    /** start time in nanoseconds */
    private long startNS;
    /** end time in nanoseconds */
    private long endNS;

    /** number of operations in sorting process.
		machine-independent measure of runtime. */
    private long operations;

		/** Comparator to determine ordering */
		Comparator<T> orderBy = null;

		/** max value within array - determines histogram size */
		int max = 1;

    /** Constructor. Initializes metrics to 0. */
    public Quicksort() {
        startNS = 0;
        endNS = 0;
        operations = 0;
    }

    /** Method call from outside class to sort input array.
		You must put elements into the array that is passed in sorted order.
		@param inArray array that will contain sorted elements upon fn return.
		@param m maximum value used to size the histogram (i.e. C array)
		@param comparator used for ordering elements
		*/
		public void sort(T[] inArray, int m, Comparator<T> comparator ) {
        // initialize everything
        endNS = 0;
        operations = 0;
				orderBy = comparator;
				max = m;

				// IMPORTANT:
				// operations = total number of comparisons

        // start the timer
        startNS = System.nanoTime();

        // sort the array recording the time
        sortTimed(inArray, 0, inArray.length-1);

        // mark the finish time
        endNS = System.nanoTime();

        // this for debugging purposes to check timer.
      //System.out.println("start="+startNS+". end="+endNS+". elapsed="+(endNS-startNS)/1000);
    }

    /** Getter for number of operations. */
    public long operations() {
        return operations;
    }

    /** Getter for elapsed time in microsecs based on stored start and end time, which are in ns */
    public long elapsedTimeUS() {
        return (endNS - startNS) / 1000;
    }

		/** Quick Sort algorithm.
		@param array original array where the sorted elements need to go
		@param p starting index of subarray
		@param r ending index of subarray
		*/
		void sortTimed(T[] array, int p, int r) {

				// @TODO ***^^^^^^^^^^^^^^^^ FILL ME IN
		}
}
