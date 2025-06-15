import DataStructure.Digraph;

/**
 * Class to make a DFS on a directed graph.
 */
public class DirectedDFS {
    public boolean marked[]; // Array of booleans of marked vertices.

    /**
     * Generate a Depth First Search on the digraph G from source s.
     * @param G
     * @param S
     */
    public DirectedDFS(Digraph G, int s) {
        this.marked = new boolean[G.V()];
        dfs(G, s);
    }

    /**
     * dfs recursive method to explore all vertices in G from s.
     * @param G Directed Graph to compute dfs on.
     * @param s Source vertex to compute dfs from.
     */
    private void dfs(Digraph G, int v) {
        marked[v] = true;

        // dfs on all adj vertices of v.
        for (int i: G.adj(v)) {
            if (!marked[i]) dfs(G, i);
        }
    }


    /**
     * Return if a vertex v is reachable from the dfs.
     * @return
     */
    public boolean visited(int v) {
        return marked[v];
    }
    
}
