import utils.Helper;


// Complexity of O(nlogN )

public class QuickSort {

    // Quick sort algorithm demonstration using the pivot at the end of the array (high).
    static void quickSort(int[] array, int low, int high) {

        if (low < high) {
            // Declare the pointer j to keep track of the left part of the pivot
            int j = low;

            // Iterate through the array to find all the elements lower than the pivot, and put them on the left part
            for (int i = low; i < high; i++) {
                if (array[i] < array[high]) {
                    Helper.permutation(array, j, i);
                    j++;
                }
            }

            // place the pivot after all the elements lower than it (with j the new index of the pivot that will be used to create the subarrays)
            Helper.permutation(array, j, high);

            quickSort(array, low, j-1);
            quickSort(array, j+1, high);

            return;
        }
    }


    // Overide function to pass only 1 parameter
    static void quickSort(int[] array) {

        // find the index of the beginning of the sub array
        int low = 0;

        // find the index of the end of the subarray from the right of the pivot
        int high = array.length - 1;

        // Call the quick sort function
        quickSort(array, low, high);
        return;
    }


    public static void main(String args[]) {
        
        int[] array = {1, 4, 9, 3, 2, 5, 8, 7, 10};

        quickSort(array);

        Helper.printArray(array);
    }
}