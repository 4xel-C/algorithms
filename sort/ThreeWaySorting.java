import utils.Helper;
/**
 * Algorithm to sort and clusterize 3 differents items in an array
 * (Deutch national flag problem)
 * Quick sorting method working best when there is a lot of duplicates
 */
public class ThreeWaySorting {

    public static void quickSortThree(int[] array, int low, int high) {

        if (low >= high) return;

        // low pointer
        int lowp = low;

        // mid pointer
        int mid = low;

        // high pointer
        int highp = high;

        int key = array[low];

        while (mid <= highp) {

            if (array[mid] == key) {
                mid++;
            } else if (array[mid] < key) {
                Helper.permutation(array, mid++, lowp++);
            } else {
                Helper.permutation(array, mid, highp--);
            }
        }


        // Sort the left part, then the right part
        quickSortThree(array, low, lowp);
        quickSortThree(array, mid, high);

    }

    // Overload the method to only call on the array
    public static void quickSortThree(int[] array) {

        int high = array.length - 1;
        int low = 0;

        quickSortThree(array, low, high);
    }



    public static void main(String[] args) {

        int[] array = {1, 0, 0, 1, 2, 0, 2, 1, 2, 2, 1, 0, 3, 4, 4, 5, 1, 2, 2, 2, 8};

        quickSortThree(array);

        Helper.printArray(array);

    }

}