### CSC320 Spring 21 Programming Project Sorting
#### Comparative Study of Sorting Techniques

- Part I due Thursday, March 4
- Part II <del>due Thursday, March 11</del>

<hr>

PART I

1. Complete `void sortTimed(T[] array, T[] copy)` in _Counting.java_.

	Use the textbook for the logic, but remember it is 1-based indexing. One easy thing you can do is subtract 1 from the 0th histogram element before you calculate the cumulative sum.

	Be sure to increment the operations counter for each loop iteration.

	Test your results. I have posted my results at the bottom of this file.

2. Complete `void sortTimed(T[] array)` in Radix.java_.

	Use the textbook for the logic.

	Be sure to increment the operations counter for each loop iteration. You will have to get the number of operations from Counting Sort and add to a total.

	Test your results. I have posted my results at the bottom of this file.

3. Complete `void sortTimed(T[] array, int p, int r)` in Quicksort.java_.

	Be sure to increment the operations counter for each comparison.

	Test your results. I have posted my results at the bottom of this file.

<hr>

PART II

Run a series of experiments to compare the runtime techniques. More to come ...

<hr>

```
TESTING COUNTING SORT
SORTING THIS {svphp,13} {trwee,13} {mgcce,5} {ipxor,17} {vzpqx,6} {tnwll,11} {dbhsu,15} {wqzbv,0} {eavlj,6} {hhnyr,10}
SORT ALPHA {dbhsu,15} {eavlj,6} {hhnyr,10} {ipxor,17} {mgcce,5} {svphp,13} {trwee,13} {tnwll,11} {vzpqx,6} {wqzbv,0}
SORT NUMERIC {wqzbv,0} {mgcce,5} {eavlj,6} {vzpqx,6} {hhnyr,10} {tnwll,11} {svphp,13} {trwee,13} {dbhsu,15} {ipxor,17}

TESTING RADIX SORT
SORTING THIS {pehqu,594} {wstad,621} {bmgzl,681} {ynraw,549} {jxtlz,893} {zwfqz,546} {axlfz,530} {wqqnd,431} {jihxo,753} {vqrsa,778}
SORT ALPHA {axlfz,530} {bmgzl,681} {jihxo,753} {jxtlz,893} {pehqu,594} {vqrsa,778} {wqqnd,431} {wstad,621} {ynraw,549} {zwfqz,546}
SORT NUMERIC {wqqnd,431} {axlfz,530} {ynraw,549} {zwfqz,546} {pehqu,594} {wstad,621} {bmgzl,681} {jihxo,753} {vqrsa,778} {jxtlz,893}
```
