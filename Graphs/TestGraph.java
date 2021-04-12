import java.util.HashMap;
import java.util.LinkedList;

public class TestGraph {

  public static void main(String[] args) {

		// Create a graph using each of the representations
		Graph petTransport = new Graph();
		petTransport.directed(true);
		petTransport.weighted(false);

    // A clunky way to build a graph. It will do for now.
    /* Build vertices */
    Vertex v0000 = new Vertex("0000: { mouse dog cat human } { }");
    Vertex v0001 = new Vertex("0001: { mouse dog cat } { human }");
    Vertex v0010 = new Vertex("0010: { mouse dog human } { cat }");
    Vertex v0011 = new Vertex("0011: { mouse dog } { cat human }");
    Vertex v0100 = new Vertex("0100: { mouse cat human } { dog }");
    Vertex v0101 = new Vertex("0101: { mouse cat } { dog human }");
    Vertex v0110 = new Vertex("0110: { mouse human } { dog cat }");
    Vertex v0111 = new Vertex("0111: { mouse } { dog cat human }");
    Vertex v1000 = new Vertex("1000: { dog cat human } { mouse }");
    Vertex v1001 = new Vertex("1001: { dog cat } { mouse human }");
    Vertex v1010 = new Vertex("1010: { dog human } { mouse cat }");
    Vertex v1011 = new Vertex("1011: { dog } { mouse cat human }");
    Vertex v1100 = new Vertex("1100: { cat human } { mouse dog }");
    Vertex v1101 = new Vertex("1101: { cat } { mouse dog human }");
    Vertex v1110 = new Vertex("1110: { human } { mouse dog cat }");
    Vertex v1111 = new Vertex("1111: { } { mouse dog cat human }");

    // Add each vertex to the Graph
    petTransport.addVertex(v0000);
    petTransport.addVertex(v0001);
    petTransport.addVertex(v0010);
    petTransport.addVertex(v0011);
    petTransport.addVertex(v0100);
    petTransport.addVertex(v0101);
    petTransport.addVertex(v0110);
    petTransport.addVertex(v0111);
    petTransport.addVertex(v1000);
    petTransport.addVertex(v1001);
    petTransport.addVertex(v1010);
    petTransport.addVertex(v1011);
    petTransport.addVertex(v1100);
    petTransport.addVertex(v1101);
    petTransport.addVertex(v1110);
    petTransport.addVertex(v1111);

    // Add the edges to the Matrix represenation.
    petTransport.addEdge(v0000,v0001);
		petTransport.addEdge(v0001,v0000);
    petTransport.addEdge(v0000,v1001);
    petTransport.addEdge(v0000,v0011);
    petTransport.addEdge(v0011,v0000);
    petTransport.addEdge(v0000,v0101);
    petTransport.addEdge(v0011,v0010);
    petTransport.addEdge(v0010,v0011);
    petTransport.addEdge(v1000,v1011);
    petTransport.addEdge(v1011,v1000);
    petTransport.addEdge(v1000,v1101);
    petTransport.addEdge(v1101,v1000);
    petTransport.addEdge(v1101,v0100);
    petTransport.addEdge(v0100,v1101);
    petTransport.addEdge(v1101,v1100);
    petTransport.addEdge(v1100,v1101);
    petTransport.addEdge(v1011,v1010);
    petTransport.addEdge(v0010,v0111);
    petTransport.addEdge(v0111,v0010);
    petTransport.addEdge(v1100,v1111);
    petTransport.addEdge(v1111,v1100);
    petTransport.addEdge(v1111,v1010);
    petTransport.addEdge(v1000,v1001);
    petTransport.addEdge(v0100,v0101);
    petTransport.addEdge(v0100,v0111);
    petTransport.addEdge(v0111,v0100);
    petTransport.addEdge(v0111,v0110);
    petTransport.addEdge(v1111,v0110);
    petTransport.addEdge(v1111,v1110);
    petTransport.addEdge(v1110,v1111);
    petTransport.addEdge(v1011,v0010);
    petTransport.addEdge(v0010,v1011);

    // Ready for the interesting stuff ...
    System.out.println("\n\n--------------------- BFS ");
    Traverse.BFS(petTransport,v0000);
    petTransport.printPath(v1111);

    System.out.println("\n\n--------------------- DFS ");
    Traverse.DFS(petTransport);
    petTransport.printPath(v1111);

		//*** THIS TESTS IF IT IS RUNNING, but it does not confirm it
		// is providing the shortes path.
		// Create a WEIGHTED graph to confirm correctness
    System.out.println("\n\n--------------------- DIJKSTRAs ");
    Traverse.Dijkstra(petTransport,v0000);
    petTransport.printPath(v1111);
  }
}
