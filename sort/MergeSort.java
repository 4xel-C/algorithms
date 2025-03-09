import utils.Helper;

public class MergeSort {
    
    // function to merge 2 sorted arrays
    static int[] merge(int[] left, int[] right) {

        int len_left = left.length;
        int len_right = right.length;
        int[] sorted_array = new int[len_left + len_right];

        int l = 0; // index for left array
        int r = 0; // index for right array
        int i = 0; // index for sorted array

        while (l < len_left && r < len_right) {

            if (left[l] <= right[r]) {
                sorted_array[i] = left[l];
                i++;
                l++;
            } else {
                sorted_array[i] = right[r];
                i++;
                r++;
            }
        }

        while(l < len_left) {
            sorted_array[i] = left[l];
            i++;
            l++;
        }

        while(r < len_right) {
            sorted_array[i] = right[r];
            i++;
            r++;
        }
        return sorted_array;
    }

    static int[] merge_sort(int[] array){

        int length = array.length;
        int middle = length / 2;
        int[] left = new int[middle];
        int[] right = new int[length - middle];
        int[] sorted_array = new int[length];

        if (length == 1) {
            return array;
        }

        // creating left and right array
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
            right[i] = array[middle + i];
        }

        // add the last item in right
        if (length % 2 != 0) {
            right[length - middle - 1] = array[length-1];
        }

        left = merge_sort(left);
        right = merge_sort(right);
        
        sorted_array = merge(left, right);

        return sorted_array;
    }

    public static void main(String[] args) {

    int[] array = {4, 2, 6, 9, 10, 3, 23, 46};
    int[] sorted_array = merge_sort(array);
    Helper.printArray(sorted_array);
    }
}
