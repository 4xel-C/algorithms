import utils.Helper;

public class BubbleSort {
    
    public static void bubbleSort(int[] array) {

        int length = array.length;
        int temp;
        Boolean isSorted = false;

        while (!isSorted){
            // consider the array sorted unless it finds a permutation
            isSorted = true;

            for (int i = 1; i < length; i++) {

                if (array[i] < array[i-1]) {
                    temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                    isSorted = false;
                }
        }
        }
        return;
    }

    public static void main(String args[]) {

        int[] array = {3, 1, 76, 23, 8, 9, 10, 3, 109, 433};

        bubbleSort(array);

        Helper.printArray(array);

    }

}
