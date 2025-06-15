import DataStructure.Digraph;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of a directed BFS.
 */
public class DirectedBFS {
    private boolean marked[]; // keep track visited vertices.

    /**
     * Compute a BFS on a directed graph D from source vertex s.
     * @param D
     * @param s
     */
    public DirectedBFS(Digraph D, int s) {
        
        // Initialization of the visited vertices array. 
        this.marked = new boolean[D.V()];

        // Build the Queue to keep track of the vertices to visit during the bfs.
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s); // add the source.

        while (!queue.isEmpty()) {

            // Pop and mark the first element of the queue.
            int v = queue.poll(); 
            marked[v] = true;

            // Add each neighbor to v to the queue.
            for (int w : D.adj(v)) {
                if (!marked[w]) queue.add(w);
            } // end for.
        } // end while.
    }


    /**
     * Check if a vertex v has been visited by the bfs.
     * @param v
     */
    public boolean visited(int v) {
        return marked[v];
    }

    
}
