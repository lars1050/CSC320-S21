import java.io.*;
import java.util.*;

/** Used in conjunction with DatasetMaker to create large arrays for experiments */
public class DataReader {

	/** Reads the files created by DatasetMaker and puts values into an array of Integers.
	@param filename (absolute path) to the file containing values.
	@param size array size (the number of values to read from the file)
	@return Integer array with first "size" values of file
	*/
	public static Integer[] readIntegers(String filename, int size) {

		//Creating Scanner instance to read File in Java
		Scanner scan = null;

		// Open the file
		try {
			scan = new Scanner(new File(filename));
		} catch (IOException e) {
			System.out.println("Error opening file "+filename);
			e.printStackTrace();
			return null;
		} // end try-catch

		// create the array to fill
		Integer[] array = new Integer[size];

		try {
			// Fill all "size" elements of the array
			// NOTICE: no error checking for end of file. This will crash
			// if there are fewer items in the file than "size"
			for (int i=0; i<size; i++) {
				// The file has values INTEGER INTEGER INTEGER ...
				// read one INTEGER and add to array.
				array[i] = Integer.valueOf(scan.next());
			}
		} catch (Exception e) {
			System.out.println("Error reading from file "+filename);
			e.printStackTrace();
			return null;
		}
		return array;
	}

	/** Reads the files created by DatasetMaker and puts values into an array of Simples.
	@param filename (absolute path) to the file containing values.
	@param size array size (the number of values to read from the file)
	@return Simple array with "size" Simple objects
	*/
	public static Simple[] readSimples(String filename, int size) {

		//Creating Scanner instance to read File in Java
		Scanner scan = null;

		// Open the file
		try {
			scan = new Scanner(new File(filename));
		} catch (IOException e) {
			System.out.println("Error opening file "+filename);
			e.printStackTrace();
			return null;
		} // end try-catch

		// create the array to fill
		Simple[] array = new Simple[size];

		try {
			// Fill all "size" elements of the array
			// NOTICE: no error checking for end of file. This will crash
			// if there are fewer items in the file than "size"
			for (int i=0; i<size; i++) {
				// The file has values ALPHA NUMERIC ALPHA NUMERIC ...
				// read an ALPHA NUMERIC pair and make a new Simple Object.
				array[i] = new Simple(scan.next(), Integer.valueOf(scan.next()));
			}
		} catch (Exception e) {
			System.out.println("Error reading from file "+filename);
			e.printStackTrace();
			return null;
		}
		return array;
	}
}
