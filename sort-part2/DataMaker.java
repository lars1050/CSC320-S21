import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataMaker {

  // specify configuration of the array
  public enum Config {
    RANDOM, // random values from 0 to max, or strings with stringLength
    SORTED, // in order from 0 to max; or aaaaa, aaaab, aaaac, ...
    REVERSE, // in reverse order max to 0; or zzzzz, zzzzy, zzzzx
    LARGE   // super big numbers or 10-char strings
  };

	public static long seed = 100;

  // seed with 10 for replicability
  public static Random rng = new Random();

  // range of values when creating random integers from 0 to max
  public static int max = 10000000;

	// Together these determine range of values when making LARGE number arrays.
	// Numbers start at minLarge and go up to minLarge+maxDelta.
	public static int minLarge = 100000000;
	public static int maxDelta =  99999999;

	// fixed size of the string (for alpha) when creating random strings
  public static int stringLength = 5;

  /** Creating a file with size elements.
  @param filename file will be overwritten
  @param size total number of Simple elements added to file
  @param config characteristic of values created
  */
  public static void makeInteger(String filename, int size, Config config) {

    FileWriter writer = null;
		rng = new Random(seed);

    // Open the file
    try {
      writer = new FileWriter(filename);
    } catch (IOException e) {
      System.out.println("Error opening file "+filename);
      e.printStackTrace();
      return;
    } // end try-catch

    // write "size" numbers to the file with values based on config
    try {
      if (Config.RANDOM==config) {
        for (int i=0; i<size; i++) {
          writer.write(rng.nextInt(max)+" ");
        }
      } else if (Config.SORTED==config) {
        for (int i=0; i<size; i++) {
          writer.write(i+" ");
        }
      } else if (Config.REVERSE==config) {
        for (int i=0; i<size; i++) {
          writer.write((size-i)+" ");
        }
      } else if (Config.LARGE==config) {
        for (int i=0; i<size; i++) {
          // in range 100,000,000 to 199,999,998
          writer.write((minLarge+rng.nextInt(maxDelta))+" ");
        }
      }
    } catch (IOException e) {
      System.out.println("Error writing to file "+filename);
      e.printStackTrace();
      return;
    }
    // close the file
    try {
      writer.close();
    } catch (IOException e) {
      System.out.println("Error closing file "+filename);
      e.printStackTrace();
      return;
    } // end try-catch
  } // end integermaker

  /*-----------------------------------------------------------------*/
  //              MAKE SIMPLE
  /*-----------------------------------------------------------------*/

  /** Generate a random string with size characters */
  public static String randomString(int length) {
    int a = 97;         // ascii value of a
    String alpha = "";  // string to be returned
    // create each letter and concatenate to string alpha
    for (int k=0; k<length; k++) {
      // random number corresponding to a letter. 0 is a, 1 is b, ...
      // add it to the value of a to get its ASCII value, then
      // get corresponding char
      char r = (char) (rng.nextInt(26)+a);
      // concatenate to string by converting char to String
      alpha += String.valueOf(r);
    }
    return alpha;
  }

  /** Generate next string in order. Essentially, this is counting with 26 digits (as opposed to 10). 0 is "a", 1 is "b", ... , 25 is "z".
  It modifies ascii by 1 and returns the string.
  @param ascii current "string" to increment or decrement
  @param reverse true if decrement instead of increment
  @return next string converted from ascii
  */
  public static String nextString(int[] ascii, boolean reverse) {
    if (!reverse) {
      // the last digit is the one that we add or subtract 1
      int i = ascii.length-1;
      // the carry if there is overflow in that digit (starts the adding of 1)
      int carry = 1;
      // as long as the 1 is carrying to the next digit ...
      // assuming it will not overflow
      while (1==carry && i<ascii.length) {
        ascii[i] = ascii[i]+carry;
        // if it overflows
        if (ascii[i]==26) {
          carry = 1;
          ascii[i] = 0;
        } else {
          carry = 0;
        }
        i--;
      }// end while
    } else {
      int i = ascii.length-1;
      // same as above except might need to borrow instead of carry
      int borrow = 1;
      while (1==borrow && i<ascii.length) {
        ascii[i] = ascii[i] - borrow;
        if (ascii[i] < 0) {
          ascii[i] = 25;
        } else {
          borrow = 0;
        }
        i--;
      } // end while
    }
    // convert ascii to its corresponding string.
    int a = 97;
    String alpha = "";
    for (int value : ascii) {
      // value in range of 0 to 25, add to "a" to get ascii value
      char r = (char) (value+a);
      // concatenate to string by converting char to String
      alpha += String.valueOf(r);
    }
    return alpha;
  }

  /** Creating a file with 2*size elements alternating string, number.
  @param filename file will be overwritten
  @param size total number of Simple elements added to file
  @param config characteristic of values created
  @param byAlpha when sorting, sort by alpha (true) or sort by numeric (false)
  */
  public static void makeSimple(String filename, int size, Config config, boolean byAlpha) {

    FileWriter writer = null;

    int[] current = new int[stringLength];

    // Open the file
    try {
      writer = new FileWriter(filename);
    } catch (IOException e) {
      System.out.println("Error opening file "+filename);
      e.printStackTrace();
      return;
    } // end try-catch

    String alpha = "";
    try {
      if (Config.RANDOM==config) {
        for (int i=0; i<size; i++) {
          writer.write(randomString(5)+" "+rng.nextInt(max)+" ");
        }
      } else if (Config.SORTED==config) {
        for (int i=0; i<size; i++) {
          if (byAlpha) {
            writer.write(nextString(current,false)+" "+rng.nextInt(max)+" ");
          } else {
            writer.write(randomString(stringLength)+" "+i+" ");
          }
        }
      } else if (Config.REVERSE==config) {
        for (int i=0; i<stringLength; i++) {
          current[i] = 25;
        }
        for (int i=0; i<size; i++) {
          if (byAlpha) {
            writer.write(nextString(current,true)+" "+rng.nextInt(max)+" ");
          } else {
            writer.write(randomString(stringLength)+" "+(size-i)+" ");
          }
        }
      } else if (Config.LARGE==config) {
        current = new int[10];
        for (int i=0; i<size; i++) {
          writer.write(randomString(10)+" " + (minLarge+rng.nextInt(maxDelta))+" ");
        }
      }
    } catch (IOException e) {
      System.out.println("Error writing to file "+filename);
      e.printStackTrace();
      return;
    }

    try {
      writer.close();
    } catch (IOException e) {
      System.out.println("Error closing file "+filename);
      e.printStackTrace();
      return;
    } // end try-catch
  } // end integermaker

} // end class
