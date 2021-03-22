### Programming Project 2 : Comparative Study of Optimization Paradigms

#### DUE Tuesday April 13 end-of-day

Requirements
- Recursive dynamic program solving summation problem.
- Iterative dynamic program solving summation problem.
- PROVIDED: Greedy approach solving summation problem.
- Report comparing the above techniques.

> COMMENTS in your code will be part of assessment.

<hr>

## Summation Optimization Problem

Solve a Summation Optimization problem using either the paradigm of
dynamic programming or greedy. The problem is to choose a minimally sized subset (that may have repeats) from a given list of numbers whose summation equals a given total.

For example, if the numbers = { 0, 3, 1, 5, 1, 3, 4, 5 } and the total is 7,
then the subsets
- {3,1,3}
- {3,4}
- {1,5,1}
all sum to 7. However, the subset {3,4} has the smallest cardinality (i.e. size) and thus is the optimal subset. The COST of this optimal solution is 2.

For example, if the numbers = { 0, 2, 5, 10, 5} and the total is 3, then there is no solution for this problem. The cost is infinity.

Notice that the list of numbers starts with 0. You can (and should) assume that the 0 is always the first number. It functions as a sentinel.

### CODE

Complete _class SolverDP_. 

**COMMENTS IN YOUR CODE will be part of assessment. Please add comments.**

1. In the file _SolverDP.java_, write an ITERATIVE method `public void solveWithIteration()` that uses dynamic programming to solve the problem.

2. In the file _SolverDP.java_, write a RECURSIVE method `public void solveWithRecursion()` that uses dynamic programming to solve the problem. You may change the signature of this method. There are notes in the file.

3. In the file _SolverDP.java_, complete the method `public ArrayList<Integer> constructSolution()`. This method uses the selection table s[][] to create the minimally sized subset of numbers that sum to Total.

### REPORT

Choose problems (numbers and sum values) that have these results:

1. Sum to 2007 and choose a number set that is solvable (i.e. sums to 2007) with dynamic programming, such that *iterative takes significantly longer than recursive*. (I produced a time difference of 183688 versus 23376. I did have to increase my stack size to 1G to get this. You should be able to see significant time changes without increasing your stack.)

> Don't forget to put number 0 at index 0.

2. Sum to 1003 and choose a number set that is solvable with dynamic programming AND produces a relatively _insignificant_ runtime difference between the iterative and recursive versions of your dynamic programming solution.

3. Sum to 137. Choose a number set that is solvable with dynamic programming (iterative or recursive) BUT is NOT solvable with the greedy approach.

4. Choose a number set that is solvable with both dynamic programming and the greedy approach. AND, choose it such that there is a *significant runtime difference between the dynamic programming solution (recursive or iterative, your choice) and the greedy* in which greedy is more efficient.

Create a report for each of the 4 scenarios above. Be sure to identify the number set, whether or not the algorithm solved the problem, and the time it took to run the algorithm and the number of operations. IMPORTANTLY, compare the results and provide an analysis of any differences. In other words, if there is a runtime difference, explain why there is a runtime difference. If dynamic programming solves it, but greedy does not, explain why that is the case. It does not have to be a long report -- you can probably present your results with 2-3 sentences for each of the 4 scenarios.

> Instead of listing numbers, you can state where to find those numbers in your .java file (use a line number for easy reference).

When you submit, include all 4 scenarios in a form that can be run in Java. The simplest way is probably to define 4 number arrays for the 4 scenarios and 4 variables for the 4 different sum totals. I can take it from there (meaning it doesn't have to automatically run all 4 scenarios).
