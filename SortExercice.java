import utils.Helper;

public class SortExercice {

    
    public static void quickSort(int[] array, int start, int end) {

        if (start > end) {
            return;
        }

        // Use of quick sort taking the pivot at the end of the array
        int key = array[end];

        int j = start;
        for (int i = start; i <= end; i++) {
            if (array[i] < key) {
                Helper.permutation(array, j, i);
                j++;
            }
        }

        Helper.permutation(array, j, end);

        quickSort(array, start, j-1);
        quickSort(array, j+1, end);
    }

    // surchargemethod overloading to only pass the array to the method
    public static void quickSort(int[] array) {
        int start = 0;
        int end = array.length - 1;
        quickSort(array, start, end);
    }


    public static void main(String args[]) {

        int[] array = {100, 4, 9, 3, 2, 5, 8, 7, 10};
        Helper.printArray(array);

        quickSort(array);

        Helper.printArray(array);

    }
}
