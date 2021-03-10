import java.util.Random;
import java.util.function.Function;
import java.util.Comparator;

/** Framework to test various sorting algorithms. */
public class Main {

	/************** 3 Comparators: simple alpha, simple numeric, integer ******/

	public static Comparator<Simple> byAlpha = new Comparator<Simple>() {
		@Override
		public int compare(Simple s1, Simple s2) {
			return s1.alpha().compareTo(s2.alpha());
		}
	};

	public static Comparator<Simple> byNumeric = new Comparator<Simple>() {
		@Override
		public int compare(Simple s1, Simple s2) {
			return s1.numeric().compareTo(s2.numeric());
		}
	};

	public static Comparator<Integer> defaultInts = new Comparator<Integer>() {
		@Override
		public int compare(Integer n1, Integer n2) {
			return n1 - n2;
		}
	};

	/**  random number generator, seeded with 10 for reproducability */
	static Random rng = new Random(10);

	/**  The maximum value to be stored in an array */
	static int maxValue = 100;

	/** Lambda function to get an index value from a string.
	It uses the first letter and maps it to an index in range 0-25. */
	static Function<Simple,Integer> getAlpha = obj -> Character.getNumericValue(obj.alpha().charAt(0)) - Character.getNumericValue('a');

	/** Lambda function to get value of numeric from the Simple object. */
	static Function<Simple,Integer> getNumeric = obj -> obj.numeric();

	/** Lambda function to get the Integer of an Integer, hence the name */
	static Function<Integer,Integer> identity = obj -> obj;

	/**********************************************************************/
	/**********************************************************************/
	/**********************************************************************/

	/** Example of data collection of a single comparison.
	You probably want to build a more sophisticated (and more automated) method of data collection. */
	public static void experiments() {

		System.out.println("\nEXPERIMENTING WITH SORTING INTEGERS");
		System.out.println("\nCounting Sort");

		// You can run DatasetMaker to create all necessary files prior
		// to running experiments, or you can make them as needed as shown below.

		Integer[] numbers;
		DataMaker.makeInteger("test.txt",10000,DataMaker.Config.LARGE);
		numbers = DataReader.readIntegers("test.txt",10000);

		System.out.print("PRE-SORTING  ");
		// print the first 20
		for (int i=0; i<20; i++) { System.out.print(numbers[i]+" "); }
		System.out.print("...");
		// print the last 20
		for (int i=numbers.length-21; i<numbers.length; i++) {
			System.out.print(numbers[i]+" ");
		}
		System.out.println();

		// Set up the sorting algorithm. This will display the elapsed time.
		Counting<Integer> countingAlgo = new Counting<>();

		// Use the max function to determine max value in the array
		countingAlgo.sort(numbers,max(numbers),identity);
		// Check the results, print the first 20
		System.out.print("SORTED  ");
		for (int i=0; i<20; i++) { System.out.print(numbers[i]+" ");}
		System.out.print("...");
		// print the last 20
		for (int i=numbers.length-21; i<numbers.length; i++) {
			System.out.print(numbers[i]+" ");
		}
		System.out.println();

		// ------------------------------   TEST MERGE  ---
		System.out.println("\nTESTING MERGE SORT");

		// need to reset the array because it was sorted.
		numbers = DataReader.readIntegers("test.txt",10000);

		System.out.println("PRE-SORTING ");
		// print the first 20
		for (int i=0; i<20; i++) { System.out.print(numbers[i]+" "); }
		System.out.print("...");
		// print the last 20
		for (int i=numbers.length-21; i<numbers.length; i++) {
			System.out.print(numbers[i]+" ");
		}
		System.out.println();


		// Set up the sorting algorithm
		Mergesort<Integer> mergeAlgo = new Mergesort<>();

		// sort the numbers using defaultInts comparator for Integers.
		mergeAlgo.sort(numbers,defaultInts);

		// Check the results
		System.out.print("SORTED  ");
		for (int i=0; i<20; i++) { System.out.print(numbers[i]+" "); }
		System.out.print("...");
		for (int i=numbers.length-21; i<numbers.length; i++) {
			System.out.print(numbers[i]+" ");
		}
		System.out.println();
	} // end experiments

	/**********************************************************************/
	/**********************************************************************/
	/*******     THe same main as before used to test algo correctness ****/
	/**********************************************************************/

	public static void main(final String[] args) {

		experiments();

		int maxInt = 20;
		boolean testCounting = true;
		boolean testRadix = true;
		boolean testMerge = true;

		Simple[] array = null;


		// ------------------------------   TEST COUNTING  ---
		if (testCounting) {

			System.out.println("\nTESTING COUNTING SORT");

			// Fill the array with random Simple objects
			array = new Simple[10];
			// numerical values will be in range 0 to maxInt
			fillArray(array, maxInt);


			// The original
			System.out.print("SORTING THIS ");
			for (Simple s : array) {
				System.out.print(s+" ");
			}
			System.out.println();

			// Set up the sorting algorithm
			Counting<Simple> countingAlgo = new Counting<>();

			// Sort the array alphabetically
			// Order is set by passing the getAlpha function.
			// Notice the max value is 26 (the number of letters in alphabet)
			countingAlgo.sort(array,26,getAlpha);

			// Check the results
			System.out.print("SORTED  ");

			for (Simple s : array) {
				System.out.print(s+" ");
			}
			System.out.println();

			// sort the array numerically
			// Order is set by passing the getNumeric function.
			countingAlgo.sort(array,max(array),getNumeric);
			// Check the results
			System.out.print("SORT NUMERIC ");
			for (Simple s : array) {
				System.out.print(s+" ");
			}
			System.out.println();
		} // end testCounting

		// ------------------------------   TEST RADIX  ---
		if (testRadix) {

			System.out.println("\nTESTING RADIX SORT");

			// Fill the array
			array = new Simple[10];
			fillArray(array, 1000);

			// Check the results
			System.out.print("SORTING THIS ");
			for (Simple s : array) {
				System.out.print(s+" ");
			}
			System.out.println();

			// Set up the sorting algorithm
			Radix radixAlgo = new Radix();

			// Sort the array alphabetically
			// 5 is the length of the string -- this is hard coded based on the
			// size of the for loop when randomly generating strins for Simple objects
			radixAlgo.sortAlpha(array,5);
			// Check the results
			System.out.print("SORT ALPHA ");
			for (Simple s : array) {
				System.out.print(s+" ");
			}
			System.out.println();

			// sort the array numerically
			// 3 is the max number of digits -- this is hard coded based on the
			// maxInt (currently set to 1000, which means in range 0 to 999)
			radixAlgo.sortNumeric(array,3);
			// Check the results
			System.out.print("SORT NUMERIC ");
			for (Simple s : array) {
				System.out.print(s+" ");
			}
			System.out.println();
		} // end testRadix

		// ------------------------------   TEST MERGE  ---
		if (testMerge) {

			System.out.println("\nTESTING MERGE SORT");

			// Fill the array
			array = new Simple[10];
			fillArray(array, 20);

			// Check the results
			System.out.print("SORTING THIS ");
			for (Simple s : array) {
				System.out.print(s+" ");
			}
			System.out.println();

			// Set up the sorting algorithm
			Mergesort<Simple> algo = new Mergesort<>();

			// Sort the array alphabetically
			algo.sort(array,byAlpha);
			// Check the results
			System.out.print("SORTED  ");
			for (Simple s : array) {
				System.out.print(s+" ");
			}
			System.out.println();

			// sort the array numerically
			algo.sort(array,byNumeric);
			// Check the results
			System.out.print("SORT NUMERIC ");
			for (Simple s : array) {
				System.out.print(s+" ");
			}
			System.out.println();
		} // end testMerge

	} // end main


	/**********************************************************************/
	/**********************************************************************/
	/**********************************************************************/


	/** Find the max value in the Integer array */
	public static Integer max(Integer[] array) {
		Integer max = array[0];
		for (Integer el : array) {
			if (el > max) {
				max = el;
			}
		}
		return max;
	} // end max

	/** Find the max value (Integer) in the Simple array. */
	public static Integer max(Simple[] array) {
		Integer max = array[0].numeric();
		for (Simple el : array) {
			if (el.numeric() > max) {
				max = el.numeric();
			}
		}
		return max;
	} // end max

	/** Fill the given array with values in range determined by max.
	@param max integer for numeric component of Simple.
	*/
	public static void fillArray(Simple[] A, int max) {
		// ASCII value of char a
		int a = 97;
		char r;
		for (int i=0;i<A.length;i++) {
			// create a new simple object, placed in the array
			A[i] = new Simple();
			// randomly choose value for numeric part of new object
			A[i].numeric(rng.nextInt(max));
			// randomly generat a string of length 5 (arbitrarily chose 5)
			String alpha = "";
			for (int k=0; k<5; k++) {
				// random number corresponding to a letter. 0 is a, 1 is b, ...
				// add it to the value of a to get its ASCII value, then
				// get corresponding char
				r = (char) (rng.nextInt(26)+a);
				// concatenate to string by converting char to String
				alpha += String.valueOf(r);
			}
			// set the alpha component to this randomly generated string
			A[i].alpha(alpha);
		}
	} // end fillArray

} // end class Main
