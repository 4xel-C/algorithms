import utils.Helper;

/**
 * Class to sort array containing number from 0 to 20.
 * Complexity O(n). Algorithm used to sort String on radix sort.
 */
public class CountingSort {

    private static final int values = 20;
    
    public static void countingSort(int[] array) {

        int n = array.length;
        int[] count = new int[values + 1]; // initialize the counting array with an offset of 1 for dynamicly calculating the cummulation.
        int[] copy = new int[n];

        // count the occurence of each different elements.
        for (int i = 0; i < n; i++) {
            count[array[i] + 1]++; 
        }

        // Cumulation.
        for (int i = 0; i < values; i++) {
            count[i+1] += count[i];
        }

        // Copy the array in correct order.
        for (int i = 0; i < n; i++) {
            copy[count[array[i]]++] = array[i];
        }

        // Copy in place the solution
        for (int i = 0; i < n; i++) {
            array[i] = copy[i];
        }
    }



    /**
     * Testing method.
     * @param args
     */
    public static void main(String[] args) {

        int[] array = {3, 1, 8, 3, 8, 9, 1, 3, 9, 3};

        countingSort(array);

        Helper.printArray(array);

    }
}