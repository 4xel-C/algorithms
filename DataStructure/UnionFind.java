package DataStructure;

// Implementation of the Weighed UnionFind datastructure, using two arrays to represent the tree. 
// Weighed -> keep track of the size of each component rooted at i.
// Optimization -> Union: link root of the smallest component to the root of the largest.
// Optimization -> Path compression: allow to notably reduce the height of the trees.


// Complexity: O(alpha(n)) for union and find method. With alpha(n) Ackermann function (almost always < 5).

public class UnionFind {

    private int[] parent; // Array that will contains the parent of each element (represented by the index of the array).
    private int[] size;  // Array to keep track of the size of each tree.
    private int count; // number of element in the DataStructure.


    /**
     * Constructor method to create an union find of size n.
     */
    public UnionFind(int n) {
        
        // Initialisation of the number of component.
        count = n;

        // Declare the array.
        parent = new int[n];
        size = new int[n];

        // Initialisation of the element of the array.
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Add connection between p and q
    public void union(int p, int q) {

        // get and connect the smaller component.
        int rootp = root(p);
        int rootq = root(q);

        // If the two elements are already unified, return.
        if (rootp == rootq) {
            return;
        }

        if (size[rootp] < size[rootq]) {
            parent[rootp] = rootq;
            size[rootq] += size[rootp];
        } else {
            parent[rootq] = rootp;
        }

        // reduce the number of component before returning.
        count--;
        return;
    }


    // Private method to find the root of one element.
    // Use path compression to reduce height of the tree.
    private int root(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    // Method to return the number of components.
    public int count() {
        return count;
    }

    // Method to check if 2 elements are connected.
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }


    
}
