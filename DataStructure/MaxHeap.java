package DataStructure;

import utils.Helper;


// Implmementation of a binary heap for a priority queue using an array (1 indexed)
public class MaxHeap {

    int[] pq;
    int N; // number of elements

//-----------------------------------------------------Constructor
    public MaxHeap() {
        this.pq = new int[10];
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

//-----------------------------------------------------Insertion/deletion
    public void insert(int e) {
        if (N+1 == pq.length) upsize();
        if (N+1 == pq.length/4) downsize();
        pq[++N] = e;
        swim(N);
    }

    // Delete and return the max node (position 1 in the array);
    public int delMax() {
        if (isEmpty()) throw new IllegalArgumentException("Cannot delete an element from an empty heap");

        int max = pq[1];
        
        // Exchange the max node with the last node of the array
        Helper.permutation(pq, 1, N--);
        pq[N+1] = 0; 
        sink(1);
        return max;
    }

//-----------------------------------------------------Helpers functions
    /**
     * Double the size of the array pq
     */
    private void upsize(){
        int len = pq.length;

        int[] newArray = new int[len * 2];

        for (int i = 1; i <= N; i++) {
            newArray[i] = pq[i];
        }
        pq = newArray;
    }

    /**
     * Downsize by half the size of the array
     */
    private void downsize(){
        int len = pq.length;

        int[] newArray = new int[len / 2];

        for (int i = 1; i <= N; i++) {
            newArray[i] = pq[i];
        }
        pq = newArray;
    }

    /**
     * Rearrange the node at index k to be consistent with the tree from bottom to top.
     * (If node value too high, place the element higher in the tree)
     */
    private void swim(int k) {
        while (k/2 >= 1 && pq[k/2] < pq[k]) {
            Helper.permutation(pq, k/2, k);
            k = k/2;
        }
    }


    /**
     * Rearrange the node at index k to be consistent with the tree from top to bottom.
     * (if node value too low, place the element deeper in the tree).
     */
    private void sink(int k) {

        while(2*k <= N) {

            int j = 2 * k; // Get the first child node.
            if (j+1 <= N && pq[j + 1] > pq[j]) j++; // select the highest child.

            // Compare with the child having the greatest value
            if (pq[k] < pq[j]) {
                Helper.permutation(pq, k, j);
                k = j;
            } else {
                break;
            }; 
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(8);
        heap.insert(7);
        heap.insert(6);

        Helper.printArray(heap.pq);

        heap.delMax();
        Helper.printArray(heap.pq);


    }

    
}
