package other;
import utils.Helper;


/**
 * Algorithm to select the kth smallest number in an array using the key as the first element of the array.
 * Complexity O(n) (O(n²) if bad pivot or worst case, randomizing array helps having balanced parts from the pivot.)
 */
public class QuickSelect {
    
    public static int selectKSmallest(int[] array, int k) {

        // shuffle the array to reduce the chance of having balanced parts
        Helper.shuffle(array);


        k = k-1;
        int low = 0;  // Index of the first element
        int high = array.length - 1;  // Index of the last element

        while (low < high) {
            int j = partition(array, low, high);  // Partition using first element as the key, returning the good sorted position of the key
            
            // if j == k, because array[j] is in the correct sorted position, we can return j beeing, the jth smallest item of the array;
            if (j == k) return array[j];

            // The element is on the left part of the pivot
            if (k < j) {
                high = j - 1;
            } else if (k > j ) {   // the element is on th right part of the pivot
                low = j + 1;
            } 
        }

        // If the part containing the key is sorted, return the correct element
        return array[k];
    }

    public static int partition(int[] array, int low, int high) {

        // Using the low postion as the key (permutation with the median of 3)
        int medianIndex = medianOf3(array, low, high);
        Helper.permutation(array, medianIndex, low);

        int i = low + 1;
        int j = high;
        int key = array[low];

        while (true) {

            while (array[i] < key) {
                if (i == high) break;
                i++;
            }

            while (array[j] > key) {
                if (j == low) break;
                j--;
            }

            if (j <= i) break;  // if j cross the pointer i, all the element are in order; exchange with the key to place it in the correct position
            Helper.permutation(array, i, j);  // Put all the elements lower to the key on the left part
        }

        Helper.permutation(array, low, j);
        return j;
    }

    // Find the median of the three value (low, mid, hig) from an array to avoid having worst case in merge sort
    public static int medianOf3(int[] array, int low, int high) {
        int mid = (high + low) / 2;

        // If low < mid < high or low > mid > high (mid median)
        if ((array[low] - array[mid]) * (array[mid] - array[high]) >= 0) {
            return mid;
        
            // if mid < low < high or mid > low > high (low median)
        } else if ((array[low] - array[mid]) * (array[mid] - array[high]) <= 0) {
            return low;

            // if high index contains the median
        } else {
            return high;
        }


    }

    public static void main(String[] args) {

        int[] array = {100, 4, 9, 3, 2, 5, 8, 7, 10};
        Helper.printArray(array);

        int k = selectKSmallest(array, 3); // Select the first element 

        System.out.println(k);
    }
}