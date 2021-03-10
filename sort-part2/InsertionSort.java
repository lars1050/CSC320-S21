/** Used as part of a comparative study of different sorting algorithms. */
public class InsertionSort {
    /** start time in nanoseconds */
    private long startNS;
    /** end time in nanoseconds */
    private long endNS;

    /** number of comparisons in sorting process. machine-independent measure of runtime. */
    private long comparisons;

    /** Constructor. Initializes metrics to 0. */
    public InsertionSort() {
        startNS = 0;
        endNS = 0;
        comparisons = 0;
    }

    /** This is the call from outside the class. It calls the function that is actually doing the sorting. */
    public void sort(int[] inArray) {
        // initialize everything
        endNS = 0;
        comparisons = 0;

        // start the timer
        startNS = System.nanoTime();

        // sort the array
        sortTimed(inArray);

        // mark the finish time
        endNS = System.nanoTime();

        // this for debugging purposes to check timer.
        System.out.println("start="+startNS+". end="+endNS+". elapsed="+(endNS-startNS)/1000);
    }

    /** Getter for comparisons. */
    public long comparisons() {
        return comparisons;
    }

    /** Getter for elapsed time in microsecs based on stored start and end time, which are in ns */
    public long elapsedTimeUS() {
        return (endNS - startNS) / 1000;
    }

    /** This performs the sorting using the insertion sort algorithm. */
    void sortTimed(int[] array) {
        /*************************    FILL THIS IN with Insertion Sort   **********************/
    }
}
