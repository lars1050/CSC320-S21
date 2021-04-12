import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.*;
import java.util.ArrayList;


class Traverse {

	/** Breadth-First Search starting at vertex source to find path from source to all other vertices it is connected to. After BFS is finished, printPath in graph G from any other vertex to trace it. The path is determined by the parent pointers that are set during bfs. You may use any type of Java data structure to complete this.
	*
	* @param source : The vertex from which all paths are calculated
	*/
	public static void BFS(Graph G, Vertex source) {

	} // end BFS()

	/** Depth-First Search that explores the entire graph. After DFS is finished, printPath from any other vertex to trace it. You may use any type of Java Queue to complete this.
	*/
	public static void DFS(Graph G) {
		// be sure and use time to mark the distance and finish time
		// These time calculations could be used in a Strongly-Connected-Cpomponent
		// algorithm described in Ch. 22
	} // end DFS()

	/** Dijkstra's algorithm determines the shortest path to every vertex from the given source. It assumes the graph is a weighted and without cycles.
	*/
	public static void Dijkstra(Graph G, Vertex source) {

	} // end Dijkstra()

} // end class Graph
