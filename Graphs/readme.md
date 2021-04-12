### Project 3 : Graphs
#### Due Friday, April 23 end-of-day (I will accept this up to Tuesday April 27 end-of-day)
#### no late penalty on this assignment

<hr>

The algorithms can be copied almost exactly as presented in the textbook. The one place to pay attention to is the fetching and traversal of the adjacency list.

1. Add Javadocs and in-line comments to the Graph class. These should demonstrate an understanding of the purpose of the data structures and the logic of the methods.

2. Implement bfs in Traverse.java.

3. Implement dfs in Traverse.java. Be sure and include the time of discovery and completing the exploration (vertex.distance and vertex.finish, respectively). This can be implemented recursively, as presented in the textbook, or you can essentially use the bfs algorithm except use a stack instead of an FIFO queue (and you will need an outer loop to insure you visit every node).

4. Implement Dijkstra's algorithm in Traverse.java to determine the shortest path from a source in a weighted graph.

5. Create a weighted graph for testing Dijkstra's method.

6. Add in-line comments to your BFS, DFS, and Dijkstra's algorithms to demonstrate understanding of the logic.

The TestGraph.java sets up the mouse-cat-dog problem (graph included). You can check your results against the graph. You will need to create a test graph that is weighted to test Dijkstra's.
