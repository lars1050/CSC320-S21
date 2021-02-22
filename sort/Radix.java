import java.util.function.Function;

/** Used as part of a comparative study of different sorting algorithms. */
public class Radix {

    /** start time in nanoseconds */
    private long startNS;
    /** end time in nanoseconds */
    private long endNS;

		boolean orderAlpha = false;

		int max=1;

    /** number of operations in sorting process. machine-independent measure of runtime. */
    private long operations;

    /** Constructor. Initializes metrics to 0. */
    public Radix() {
        startNS = 0;
        endNS = 0;
        operations = 0;
    }

		/** Sorting by the Alpha component of Simple. */
		public void sortAlpha(Simple[] A, int length) {
			orderAlpha = true;
			max = length;
			sort(A);
		}

		/** Sorting by the numeric component of Simple. */
		public void sortNumeric(Simple[] A, int length) {
			orderAlpha = false;
			max = length;
			sort(A);
		}

    /** Call from outside the class to sort array.
		@param inArray array to be sorted either alphabetically or numerically
		*/
    public void sort(Simple[] inArray) {
        // initialize everything
        endNS = 0;
        operations = 0;

        // start the timer
        startNS = System.nanoTime();

        // sort the array recording the time.
        sortTimed(inArray);

        // mark the finish time
        endNS = System.nanoTime();

        // this for debugging purposes to check timer.
        //System.out.println("start="+startNS+". end="+endNS+". elapsed="+(endNS-startNS)/1000);
    }

    /** Getter for operations. */
    public long operations() {
        return operations;
    }

    /** Getter for elapsed time in microsecs based on stored start and end time, which are in ns */
    public long elapsedTimeUS() {
        return (endNS - startNS) / 1000;
    }

		/** Creates a lambda function to use the "d" digit for sorting.
		*/
		public static Function<Simple,Integer> getAlphaHashFunction(int digit) {
			// determine ASCII value of char at position "digit" and normalize
			// to be in range of 0 and 25
			return (simple) -> Character.getNumericValue(simple.alpha().charAt(digit)) - Character.getNumericValue('a');
		}

		/** Get the digit at the 10's position place.
		For example, if position==0, then getting the 10^0 (ones) digit.
		For example, if position==2, then getting the 10^2 (hundreds) digit.
		@param number to extract digit from
		@param position position of the digit
		*/
		public static int getDigit(Integer number, int position) {
			for (int i=0; i<position; i++) {
				number = number / 10;
			}
			return number % 10;
		}

		/** Create a lambda function that uses the getDigit function to map a position to a digit.
		@param pos position of digit to extract from Simple.numeric
		@return lambda function maps Simple.numeric to the digit at pos
		*/
		public static Function<Simple,Integer> getNumericHashFunction(int pos) {
			return (simple) -> getDigit(simple.numeric(),pos);
		}

		/** Radix sort algorithm. */
		void sortTimed(Simple[] array) {
			// IMPORTANT: You will need to get the number of operations for each loop
			// This means you have to get it from Counting sort in each loop and
			// add to total.
			if (orderAlpha) {
				// @TODO ***^^^^^^^^^^^^^^^^ FILL ME IN
			} else {
				// @TODO ***^^^^^^^^^^^^^^^^ FILL ME IN
			}
		}

}
