public class AdjacentVertex {
	Vertex vertex = null;
	Integer weight = null;	// null means infinity!
	AdjacentVertex(Vertex v, Integer w) {
		vertex = v;
		weight = w;
	}
}
