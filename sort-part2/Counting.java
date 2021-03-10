import java.util.function.Function;

/** Used as part of a comparative study of different sorting algorithms. */
public class Counting <T> {

    /** start time in nanoseconds */
    private long startNS;
    /** end time in nanoseconds */
    private long endNS;

    /** number of operations in sorting process.
		machine-independent measure of runtime. */
    private long operations;

		/** Function to map an object to an index */
		Function<T,Integer> hashFn;

		/** max value within array - determines histogram size */
		int max = 1;

    /** Constructor. Initializes metrics to 0. */
    public Counting() {
        startNS = 0;
        endNS = 0;
        operations = 0;
    }

    /** Method call from outside class to sort input array.
		You must put elements into the array that is passed in sorted order.
		@param inArray array that will contain sorted elements upon fn return.
		@param m maximum value used to size the histogram (i.e. C array)
		@param fn hash function applied to T object to determine index
		*/
		public void sort(T[] inArray, int m, Function<T,Integer> fn) {
        // initialize everything
        endNS = 0;
        operations = 0;
				hashFn = fn;
				max = m;

				// IMPORTANT:
				// operations = total number of iterations for all loops
				// including this one below that is copying the array.
				//

				@SuppressWarnings("unchecked")
				T[] copy = (T[]) new Object[inArray.length];
				for (int i=0; i<inArray.length; i++) {
					++operations;
					copy[i] = inArray[i];
				}

        // start the timer
        startNS = System.nanoTime();

        // sort the array recording the time
        sortTimed(inArray,copy);

        // mark the finish time
        endNS = System.nanoTime();

        // this for debugging purposes to check timer.
      System.out.println("start="+startNS+". end="+endNS+". elapsed="+(endNS-startNS)/1000+". OPS "+operations);
    }

    /** Getter for number of operations. */
    public long operations() {
        return operations;
    }

    /** Getter for elapsed time in microsecs based on stored start and end time, which are in ns */
    public long elapsedTimeUS() {
        return (endNS - startNS) / 1000;
    }

		/** Counting Sort algorithm.
		Use the textbook for the logic. Then fix the syntax for Java.
		BE CAREFUL WITH INDEXING!
		@param array original array where the sorted elements need to go
		@param copy copy of original used to copy elements back into array in order
		*/
		void sortTimed(T[] array, T[] copy) {
			// create the counter
			int[] histogram = new int[max+1];

			// record frequency of each element
			for (int i=0; i<array.length; i++) {
				int index = hashFn.apply(array[i]);
				histogram[index]++;
				operations++;
			}

			/*
			for (int h : histogram) {
				System.out.print(h+" ");
			}
			System.out.println();
			*/

			// subtract 1 from the first element due to 0-based indexing
			histogram[0]--;

			// accumulate the sum within the histogram
			// due to subtracting 1 at index 0, these should all be correct
			for (int i=1; i<histogram.length; i++) {
				histogram[i] = histogram[i]+histogram[i-1];
				operations++;
			}
			/*
			for (int h : histogram) {
				System.out.print(h+" ");
			}
			System.out.println();
			*/

			// put everything into the array copy in sorted order
			for (int i=array.length-1; i>=0; i--) {
				int index = hashFn.apply(copy[i]);
				array[histogram[index]] = copy[i];
				--histogram[index];
				operations++;
			} // end for loop
		}
}
