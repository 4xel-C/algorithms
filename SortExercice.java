import utils.Helper;

public class SortExercice {

    
    public static void quickSort(int[] array, int start, int end) {

        if (start > end) return;

        int key = array[end]; // taking the last item in the array as the key for the sort. 
        int cursor = start;

        for (int i = start; i < end; i++) {

            if (array[i] < key) {
                Helper.permutation(array, i, cursor++);
            }
        }
        Helper.permutation(array, cursor, end);
        quickSort(array, start, cursor - 1);
        quickSort(array, cursor + 1, end);

    }


    // overload the method
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
