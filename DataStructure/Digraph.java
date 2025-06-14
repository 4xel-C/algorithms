package DataStructure;
import java.util.ArrayList;

// Implementation of the directed graph data structure.
public class Digraph {
    
    private final int V; // Number of vertices.
    private ArrayList<Integer>[] adj; // adjency list using and array list (or a bag).
    
    /**
     * Constructor for a digraph of V vertices.
     * @param V
     */
    public Digraph(int V) {
        this.V = V;
        this.adj = (ArrayList<Integer>[]) new ArrayList[V]; // Create empty arraylist.
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>(); // Create empty bag in each position of the array.
        }
    }


    /**
     * Create an edge v -> w;
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }


    /**
     * Return an iterable of all vertices adj to v.
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Getter of V (number of vertices).
     * @return
     */
    public int V() {
        return this.V;
    }
}
