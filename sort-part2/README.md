## Programming Project 1 : Comparative Study of Sorting Techniques

### PART 2 : Complete Project 1. DUE TUESDAY APRIL 6
#### Submit a zipped file that includes the code, data collection, and the report.

> The due date for this project is April 6. I would have made it earlier but Spring Break, Good Friday, and Easter are complicating things. You will be given the next programming project BEFORE this one is due. Data collection will take time. Then you have to put the data into graph form and write a report. This is not something you can throw together at the last minute!! Make a plan. I will be checking in with you periodically to make sure you are progressing.

<hr>

Now that you have several sorting algorithms complete, you can run experiments to compare their number of operations and runtime. As you gather data, make sure you check the number of operations and runtime to ensure that those values make sense. (_You don't want to collect a lot of data only to discover there was an error, then have to collect it all again._)

Remember that runtime efficiency is expressed as a limit as the size of n increases to infinity. When algorithms have different limits (bounds), there might be little difference between their runtimes when n is small, but the difference in runtime should grow as n grows. Therefore, we want to experiment with large arrays to really highlight the differences in efficiency in these algorithms.

Several files have been created to help you set up these experiments. The class `DatasetMaker` gives you the ability to create files of both `Integer` and `Simple` values by calling `DataMaker` to create a file. These data files can be read and put into an array using `DataReader`. If you run DatasetMaker, it will generate 24 files. The ones with LARGE in the name have 100,000 entries (_large refers to BIG numbers, not large arrays - although the arrays are large too_). The other files have 10,000,000 entries. You can adjust the size of the files in `DatasetMaker` AND/OR you can adjust the number of elements you read from these files in `DataReader`. Additionally, you can adjust the maximum value within the array. Look for these lines in the code that set value ranges, make the file, and read the file, respectively:

```
// set the range of values for DataMaker (these are public static variables)
DataMaker.max = 10000000;
DataMaker.minLarge = 100000000;
DataMaker.maxDelta =  99999999;

// create the file with 10000000 array elements
DataMaker.makeInteger("datasets/integerRandom1.txt", 10000000, DataMaker.Config.RANDOM);

// read 100000000 from the file and place in an array
Integers[] numbers = DataReader.readIntegers("datasets/integerRandom1.txt", 100000000);
```

First, determine limits (without memory expansion) on your machine. On my desktop (which is pretty powerful), it could easily handle 100,000,000 elements for Merge and Counting, but it ran out of HEAP memory at 1,000,000,000 elements. It quickly ran out of memory for Counting sort when my LARGE numbers were in the trillions. Quicksort will gobble up your STACK memory. Experiment with the numbers and determine where your memory limits are.

> Now you need to expand your memory to see if you can stretch those limits.

To expand HEAP to 4 Gigs and STACK to 1 Gig, respectively, use these command line commands to run "main":

```
java -Xmx4G main
java -Xss1G main  
```

Or in Netbeans, you can set command line arguments in "Run>Set Project Configuration>Customize". In the _Arguments_ box, add "-Xmx4G". I think these are the max values that you can expand to.

IN YOUR REPORT, be sure to include the limits that you determined for your machine, so **take notes** while you are experimenting with your limits. TRUST ME -- you will be fiddling with a lot of stuff and you want to write down what you have done while you are experimenting so you can remember what you did.

## RUNNING EXPERIMENTS

Please compare the following algorithms using the specified datasets, as named in DatasetMaker, by sorting arrays of increasing size. Please modify the DataMaker to work within the limits of your machine. Record the number of operations and elapsed time.

1. Compare Counting to Radix+Counting sort using Simple objects.
	- Sort 5 different sized arrays.
	- Sort each of 3 randomly generated files.
	- Sort each of LARGE data file.

2. Compare Counting, Merge, and Randomized Quicksort using Simple objects.
	- Sort 5 different sized arrays.
	- Sort each of 3 randomly generated files.
	- Sort the SORTED file (sorted by Numeric).
	- Sort the REVERSE sorted file (sorted by Alpha).

3. Compare Counting to Mergesort using Integer objects.
	- Sort 5 different sized arrays.
	- Sort the LARGE data file.

_If there are other experiments that you would rather run, send an email to Dr. Larson with changes that you would make to the above experiments. You can even add a different algorithm (e.g. Insertion Sort) if you want. If approved, you can run your proposed experiments instead._

For #1, you are collecting 2*5*4 data points. For #2, you are collecting 3*5*5 data points. For #3, you are collecting 2*5*1 data points. That's a lot of data!

To run experiments, I highly recommend that you automate this (i.e. write functions that do batches of experiments) and store the results in a .csv file. To write to the file, it might look something like below. **DO BE CAREFUL WITH YOUR DATA - KEEP A BACKUP, AND MAKE SURE YOU DO NOT OVERWRITE THE FILE.**

```
// Open the file
try {
	// open the file and APPEND to it (not overwrite it)
	writer = new FileWriter(filename,true);
} catch (IOException e) {
	System.out.println("Error opening file "+filename);
	e.printStackTrace();
	return;
} // end try-catch

// set the range for the values randomly generated
DataMaker.minLarge = 100000000;
DataMaker.maxDelta =  99999999;
DataMaker.makeInteger("test.txt",10000000,DataMaker.Config.LARGE);

// set the 5 different sized arrays for data collection
int[] sizes = { 10000, 100000, 500000, 1000000, 10000000 };

// for each sized array, sort and record results
for (int size : sizes) {
	// read data from the file and sort it
	numbers = DataReader.readIntegers("test.txt",size);
	Counting<Integer> algo = new Counting<>();
	algo.sort(numbers,max(numbers),identity);

	// write data to the file
	// columns are algo,config,size,minval,maxval,#ops,time
	writer.write("counting"+ "," +"large"+ "," +size+ "," +"100000000"+ "," +"199999999"+ "," +algo.operations()+ "," +algo.elapsedTimeUS()+"\r\n");
}

writer.close();
```

You can open this .csv file in Excel and sort it along different columns, group data in different ways, and graph it as needed.


### Writing a Report

Create a report to show your results and to explain them. Include the limits that you determined for your particular machine. Make note of any increases in Heap or Stack memory when running experiments.

Present your data using graphs. For the collection of 3 random runs, it is best to calculate an average of the 3 runs (let Excel do this for you). Mix and match results as you wish. I would expect to see at least 3 graphs corresponding to the 3 sets of experiments above. But, as I said, mix and match as you wish, so your 3 graphs (or 6 graphs) might present data grouped in a completely different way.

Write at least 2 paragraphs that analyze some of your findings. An analysis should give a thoughtful explanation for any differences and similarities that you observe in the data. You can focus on the same algorithm applied to different array configurations, or you can focus on different algorithms applied to the same array configuration, or some other aspect that is of interest to you.

Here is an example of an analysis of the data that also refers to the graphs (which aren't shown here -- just imagine that they are here):

	"Consider the test of SelectionSort that sorted an array of size 1000 and returned an iteration count of 998,900. The runtime of SelectionSort with respect to n is expressed as `f(n) = c1*n^2 - c1*n + c2`. However, for our purposes, we have eliminated all constants and are focused on the number of iterations, so really it is `f(n) = n^2 - n`. With an array of size 1000, we would expect SelectionSort to return an iteration count of 999,000. This is close to the results, thus we conclude that the code is working as expected and the runtime function is correct.

	Looking at Graph #1 of results for Selection and Insertion Sort, we see that the runtime is the same for Selection sort regardless of the configuration of the input, and that as n increases, we are seeing a similarly shaped curve for all configurations. That is expected for Selection Sort because its worst- and best-case runtime are the same, namely Theta(n^2). This is in contrast to the results for Insertion sort, which show significant variability in the results across the different input configurations, demonstrating the range of runtime bounds from Omega(n) to O(n^2). And notice that the graph of runtimes for a sorted array with increasing n (see the blue line) is linear, which corresponds to the best-case Omega(n) bound of Insertion sort, whereas runtimes for a reverse sorted array (see green line) matches that of selection sort, which corresponds to the worst-case O(n^2) bound for Insertion Sort."

When you put your report together, remember to:
- Give your report a title
- Put your name on it
- Embed the graphs in the report
- Label your graphs (and tables if you use them).
- Include at least 2 paragraphs to explain your results. Be sure to refer to the graphs/tables when you are explaining the results.

Use informative legends and keys in your graphs. I should be able to look at the graph and the legend and understand the results.

Zip up your report, code, and data file for submission.

Hey, CONGRATULATIONS on this research that you are doing and the work that you have put into this project! This is hard stuff and you are doing great!
