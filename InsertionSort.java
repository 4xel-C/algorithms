import utils.Helper;

/*
 * Insertion sort algorithm
 * Complexity:
 *  -Worst case: O(n²)
 *  -Best case: omega(n)
 *  -average case: O(n²)
 * 
 * This algorithme show a better efficiency on smaller array. (globally better than the selection sort)
 */


public class InsertionSort {

    static void insertion_sort(int [] array) {

        int len = array.length;

        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int key = array[i];
            
            // Compare array[i] to the sorted portion and shift each greater element to the right
            while ((j >= 0) && (array[j] >= key)) {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = key;
        }
    }

    public static void main(String[] args) {

        int[] array = {4, 2, 6, 9, 10, 3, 23, 46};
        insertion_sort(array);
        Helper.printArray(array);
    }

}
