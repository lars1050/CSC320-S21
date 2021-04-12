public class Vertex {

	/** Internal, unique key used to identify each Vertex in the dictionary */
	private static Integer uniqueId = 0;
	private static Integer getUniqueId() {
		return uniqueId++;
	}

	/** Signifies discovery and exploration. White means that it has never been seen before, gray means that the algorithm is actively looking at its adjacent vertices (and their descendents possibly), and black means it is done and all adjacent vertices have been discovered.
	*/
	enum Color { WHITE, GRAY, BLACK };

	/** Used to reference the vertex -- key in the dictionary/hashmap */
	private Integer id;

	/** Depth for bfs, Discovery time for dfs. */
	private Integer distance;

	/** Finish time for dfs -- not used elsewhere. */
	private Integer finish;

	/** Set in all algorithms -- used to define paths and trees */
	private Vertex parent;

	/** Shows status of discovery */
	private Color color;

	/** For the human -- so you can see what the vertex represents. */
	private String description;

	/** Constructor assigns unique id and sets description. Default values of null used for all other member variables. */
	public Vertex(String desc) {
		id = getUniqueId();
		description = desc;
	}

	/** A default constructor -- (almost) always a good idea. */
	public Vertex() {
		this("No description");
	}

	/** Setters and Getters **/
	public Integer id() { return id; }		// cannot be set, only get.
	public Integer distance() { return distance; }
	public void distance(Integer d) { distance=d; }
	public Integer finish() { return finish; }
	public void finish(Integer f) { finish = f; }
	public Vertex parent() { return parent; }
	public void parent(Vertex p) { parent = p; }
	public Color color() { return color; }
	public void color(Color c) { color = c;}
	public String description() { return description; }
	public void description(String d) { description = d; }

	@Override
	public String toString() {
		if (null==parent) {
			return String.format("%s parent:null key:%f",description);
		}
		return String.format("%s parent:%s key:%f",description,parent.id);
	} // end toString

	/** reset all the variables -- used in every algorithm */
	void initialize() {
		distance = null;	// null means infinity!
		finish = null;		// null means infinity!
		parent = null;		// null means null -- no parent.
		color = Color.WHITE;
	} // end initialize
} // end class Vertex
