import java.util.Random;

/** Create data sets (files) to use for comparative study of algos. */
public class DatasetMaker {

	public static void main(String[] args) {

		/** MAKE THE INTEGER DATASETS */
/*
		DataMaker.seed = 100;
		DataMaker.makeInteger("datasets/integerRandom1.txt",10000000, DataMaker.Config.RANDOM);

		DataMaker.makeInteger("datasets/integerSorted.txt",10000000, DataMaker.Config.SORTED);

		DataMaker.seed = 200;
		DataMaker.makeInteger("datasets/integerRandom2.txt",10000000, DataMaker.Config.RANDOM);

		DataMaker.makeInteger("datasets/integerReverse.txt",10000000, DataMaker.Config.REVERSE);

		DataMaker.seed = 300;
		DataMaker.makeInteger("datasets/integerRandom3.txt",10000000, DataMaker.Config.RANDOM);

		DataMaker.seed = 400;
		DataMaker.makeInteger("datasets/integerLarge.txt",100000, DataMaker.Config.LARGE);

		DataMaker.seed = 500;
		DataMaker.makeInteger("datasets/integerRandom4.txt",10000000, DataMaker.Config.RANDOM);

		DataMaker.seed = 600;
		DataMaker.makeInteger("datasets/integerRandom5.txt",10000000, DataMaker.Config.RANDOM);
*/


		/** MAKE THE SIMPLE DATASETS ORDERED BY NUMERIC */
/*
		DataMaker.seed = 1000;
		DataMaker.makeSimple("datasets/simpleNumericRandom1.txt",10000000, DataMaker.Config.RANDOM,false);


		DataMaker.makeSimple("datasets/simpleNumericSorted.txt",10000000, DataMaker.Config.SORTED,false);

		DataMaker.seed = 2000;
		DataMaker.makeSimple("datasets/simpleNumericRandom2.txt",10000000, DataMaker.Config.RANDOM,false);

		DataMaker.makeSimple("datasets/simpleNumericReverse.txt",10000000, DataMaker.Config.REVERSE,false);

		DataMaker.seed = 3000;
		DataMaker.makeSimple("datasets/simpleNumericRandom3.txt",10000000, DataMaker.Config.RANDOM,false);
*/
		DataMaker.seed = 4000;
		DataMaker.makeSimple("datasets/simpleNumericLarge.txt",100000, DataMaker.Config.LARGE,false);
/*
		DataMaker.seed = 5000;
		DataMaker.makeSimple("datasets/simpleNumericRandom4.txt",10000000, DataMaker.Config.RANDOM,false);

		DataMaker.seed = 6000;
		DataMaker.makeSimple("datasets/simpleNumericRandom5.txt",10000000, DataMaker.Config.RANDOM,false);
*/


				/** MAKE THE SIMPLE DATASETS ORDERED BY ALPHA */
				/*
				DataMaker.seed = 10000;
				DataMaker.makeSimple("datasets/simpleAlphaRandom1.txt",10000000, DataMaker.Config.RANDOM,true);


				DataMaker.makeSimple("datasets/simpleAlphaSorted.txt",10000000, DataMaker.Config.SORTED,true);

				DataMaker.seed = 20000;
				DataMaker.makeSimple("datasets/simpleAlphaRandom2.txt",10000000, DataMaker.Config.RANDOM,true);

				DataMaker.makeSimple("datasets/simpleAlphaReverse.txt",10000000, DataMaker.Config.REVERSE,true);

				DataMaker.seed = 30000;
				DataMaker.makeSimple("datasets/simpleAlphaRandom3.txt",10000000, DataMaker.Config.RANDOM,true);
*/
				DataMaker.seed = 40000;
				DataMaker.makeSimple("datasets/simpleAlphaLarge.txt",100000, DataMaker.Config.LARGE,true);
/*
				DataMaker.seed = 50000;
				DataMaker.makeSimple("datasets/simpleAlphaRandom4.txt",10000000, DataMaker.Config.RANDOM,true);

				DataMaker.seed = 60000;
				DataMaker.makeSimple("datasets/simpleAlphaRandom5.txt",10000000, DataMaker.Config.RANDOM,true);
*/
	}
}
