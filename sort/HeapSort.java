import utils.Helper;

public class HeapSort {

    /**
     * Heap sort method: transform the array into a max heap, then delete maximum by exchanging it with the last item of the array and sinking the exchanged item.
     * The heap will be 0 indexed, that will slightly differ from the MaxHeap implementation.
     * Apply the sink method on the first half of the array (the other half are only leaves, and cannot sink further)
     * @param array The array to sort.s
     */
    public static void heapSort(int[] array) {

        int N = array.length; // Numbers of unsorted elements

        // Transform the array into a max heap.
        for (int k = (N / 2) - 1; k >= 0; k--) {
            sink(array, k, N);
        }

        while (N > 0) {
            delMax(array, N);
            N--;
        }
    }

    /**
     * Sink on a 0 indexed max heap of N elements in the array.
     * @param array The array representation of the max heap.
     * @param k the index of the element to sink.
     * @param N the number of element considered in the priority queue
     */
    private static void sink(int[] array, int k, int N) {
        while((2 * k) + 1 < N) {

            int j = (2 * k) + 1;
            if (j + 1 < N && array[j + 1] > array[j]) j += 1;
            if (array[k] >= array[j]) break;
            Helper.permutation(array, k, j);
            k = j;
        }
    }

    /**
     * Delete the maximum value by sending it to the last item of the current priority queue N 
     * @param array
     * @param N
     */
    private static void delMax(int[] array, int N) {
        
        // permute the max of the pq with the last item of the considered pq in the array.
        Helper.permutation(array, 0, N-1);
        sink(array, 0, N-1); // sink the element but stop before the former maximum.

    }

    public static void main(String[] args) {
        
        int[] array = {1, 2, 6, 5, 3, 9, 98, 34, 3, 6};
        heapSort(array);
        Helper.printArray(array);

    }
    
}
