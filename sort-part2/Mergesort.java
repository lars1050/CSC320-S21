import java.util.Comparator;

/** A class to use to experiment with sorting algorithms.
Typically, one would only need a static sort algorithm, but this class
measures the efficiency of the algorithm by recording the time it takes to sort and by counting the number of operations.
*/
public class Mergesort <T> {
	/** start time in nanoseconds */
	long startNS;
	/** end time in nanoseconds */
	long endNS;

	/** number of ops to sort array. machine-independent measure of runtime. */
	long operations;

	Comparator<T> orderBy = null;

	/** Copy the array so that it is accessible to all methods. */
	T[] array = null;

	/** Constructor. Initializes metrics to 0. */
	public Mergesort() {
		startNS = 0;
		endNS = 0;
		operations = 0;
	}

	/** Entry point of sorting.
	@param inArray to be sorted IN PLACE.
	@param order for comparing elements to establish ordering
	*/
	public void sort(T[] inArray, Comparator<T> order) {
		// make sure everything is initialized.
		endNS = 0;
		operations = 0;
		array = inArray;
		orderBy = order;

		// mark the time
		startNS = System.nanoTime();

		// make the first call to the recursive function.
		sort(0,inArray.length-1);

		// mark the finish time
		endNS = System.nanoTime();

		// this is for debugging to check timer.
		System.out.println("start="+startNS+". end="+endNS+". elapsed="+(endNS-startNS)/1000+". OPS "+operations);
	}

	/** Getter for comparisons. */
	public long operations() {
		return operations;
	}

	/** Getter for elapsed time in micorosecs based on stored start and end time, which are in ns */
	public long elapsedTimeUS() {
		return (endNS - startNS) / 1000;
	}

	/** The recursive function (Mergesort) following book's logic.
	@param p index of first element of subarray to sort.
	@param r index of last element of subarray to sort.
	*/
	void sort(int p, int r) {
		if (p<r) {
			// 1 or more elements to sort
			// establish middle index
			int q = (p+r)/2;
			// sort left half
			sort(p,q);
			// sort right half
			sort(q+1,r);
			// merge left and right half
			merge(p,q,r);
			// now array[p] to array[r] are in sorted order
		}
	}

	/** Given a subarray with left and right halves sorted, merge left and right into sorted order.
	@param p index of first element in subarray
	@param q middle index of subarray (marks end of left half)
	@param r index of last element of subarray
	*/
	void merge(int p, int q, int r) {
		// Instantiate new arrays to hold copies of the left and right halves.
		@SuppressWarnings("unchecked")
		T[] left = (T[]) new Object[q-p+2];
		@SuppressWarnings("unchecked")
		T[] right = (T[]) new Object[r-q+1];
		// Copy elements from array into left and right halves.
		int iLeft = 0;
		for (int i=p; i<=q; i++) {
			left[iLeft] = array[i];
			iLeft++;
			operations++;
		}
		left[iLeft] = null;	// mark the end with null as sentinal to mark end.

		int iRight = 0;
		for (int i=q+1; i<=r; i++) {
			right[iRight] = array[i];
			iRight++;
			operations++;
		}
		right[iRight] = null;	// senintal

		// index into the left and right subarrays to mark next element to merge.
		iRight = 0;
		iLeft = 0;
		// iterate over the subarray from A[p] to A[r]
		for (int i=p; i<=r; i++) {

			operations++;	// record number of ops (equating a forloop to single op)

			// check for nulls first, then compare the two
			// these if-statements can be combined but they get hard to read.

			if (null==right[iRight]) {
				// done adding the right side -- must be something in the left
				array[i] = left[iLeft];
				iLeft++;
			} else if (null==left[iLeft]) {
				// done adding the left side
				array[i] = right[iRight];
				iRight++;
			} else if (orderBy.compare(left[iLeft],right[iRight])<0) {
				// the front of the left side is smaller, it goes next.
				array[i] = left[iLeft];
				iLeft++;
			} else {
				// the front of right side is smaller.
				array[i] = right[iRight];
				iRight++;
			} // end of the if-else to determine smallest element to add
		} // end of for-loop for merging back into array
	} // end merge
} // end class Mergesort
