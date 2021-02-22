import java.util.Random;
import java.util.function.Function;


/** Framework to test various sorting algorithms. */
public class Main {

	/**  random number generator, seeded with 10 for reproducability */
	static Random rng = new Random(20);

	/**  The maximum value to be stored in an array */
	static int maxValue = 100;

	/** Lambda function to get an index value from a string.
	It uses the first letter and maps it to an index in range 0 to 25.
	*/
	static Function<Simple,Integer> getAlpha = obj -> Character.getNumericValue(obj.alpha().charAt(0)) - Character.getNumericValue('a');

	/** Lambda function to get the value of the numeric from the Simple object.
	*/
	static Function<Simple,Integer> getNumeric = obj -> obj.numeric();


	public static void main(final String[] args) {

		int maxInt = 20;
		boolean testCounting = true;
		boolean testRadix = true;

		Simple[] array = null;

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
			Counting<Simple> algo = new Counting<>();

			// Sort the array alphabetically
			// Order is set by passing the getAlpha function.
			// Notice the max value is 26 (the number of letters in alphabet)
			algo.sort(array,26,getAlpha);
			// Check the results
			System.out.print("SORT ALPHA ");
			for (Simple s : array) {
				System.out.print(s+" ");
			}
			System.out.println();

			// sort the array numerically
			// Order is set by passing the getNumeric function.
			algo.sort(array,maxInt,getNumeric);
			// Check the results
			System.out.print("SORT NUMERIC ");
			for (Simple s : array) {
				System.out.print(s+" ");
			}
			System.out.println();
		}
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
			Radix algo = new Radix();

			// Sort the array alphabetically
			// 5 is the length of the string -- this is hard coded based on the
			// size of the for loop when randomly generating strins for Simple objects
			algo.sortAlpha(array,5);
			// Check the results
			System.out.print("SORT ALPHA ");
			for (Simple s : array) {
				System.out.print(s+" ");
			}
			System.out.println();

			// sort the array numerically
			// 3 is the max number of digits -- this is hard coded based on the
			// maxInt (currently set to 1000, which means in range 0 to 999)
			algo.sortNumeric(array,3);
			// Check the results
			System.out.print("SORT NUMERIC ");
			for (Simple s : array) {
				System.out.print(s+" ");
			}
			System.out.println();
		}

	} // end main


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
