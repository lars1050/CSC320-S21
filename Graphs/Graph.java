import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.*;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;

/** Graph has a set of vertices and a set of edges that are defined and passed in the constructor. There are 3 algorithms that can be applied: bfs,dfs, and Dijkstra's. A print path method can be used to view the results of each.
*/
public class Graph {

	HashMap<Integer,Vertex> vertices = new HashMap<>();
	HashMap<Vertex,LinkedList<AdjacentVertex>> adjacencyList = new HashMap<>();

	boolean weighted = false;
	boolean directed = false;

	/** Graph constructor, default.
	*/
	public Graph() {

	}

	public void weighted(boolean bool) { weighted = bool; }
	public void directed(boolean bool) { directed = bool; }

	public void addVertex(Vertex v) {
		if (!vertices.containsKey(v.id())) {
			vertices.put(v.id(),v);
		}
	}

	public void addEdge(Vertex from, Vertex to) {
		if (!weighted) {
			addEdge(from,to,1);
		} else {
			// I should really throw an exception here!
			System.out.println("ERR: Attempt to add unweighted edge to weighted graph.");
		}
	}

	public void addEdge(Vertex from, Vertex to, Integer weight) {

		if (!adjacencyList.containsKey(from)) {
			adjacencyList.put(from,new LinkedList<AdjacentVertex>());
		}

		AdjacentVertex v = new AdjacentVertex(to,weight);

		LinkedList<AdjacentVertex> adjacent = adjacencyList.get(from);
		adjacent.add(v);

		if (!directed) {
			if (!adjacencyList.containsKey(to)) {
				adjacencyList.put(to,new LinkedList<AdjacentVertex>());
			}

			v = new AdjacentVertex(from,weight);

			adjacent = adjacencyList.get(to);
			adjacent.add(v);
		}
	}

	public LinkedList<AdjacentVertex> adjacent(Vertex v) {
		if (adjacencyList.containsKey(v)) {
			return adjacencyList.get(v);
		} else {
			return null;
		}
	} // end adjacent

	/** Print the path from the source vertex to the provided vertex.
	@param v Begin the trace from here back to the start node.
	*/
	public void printPath(Vertex v) {
	} // end printPath

} // end class Graph
