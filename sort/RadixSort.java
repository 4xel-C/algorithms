import utils.Helper;

/**
 * Radix sort 
 */
public class RadixSort {
    
    private static final int R = 256; // Extended ASCII bits size.


    /**
     * Least significant digit first. -> Sort from the last element. Usefull to efficiently sort strings having the same length (using UTF-8 encoding).
     * Complexity: O(w * N). (w -> length of the strings).
     * @param array
     */
    public static void lsdSort(String[] array) {

        int w = array[0].length(); // size of the words.
        int length = array.length;
        
        String[] copy = new String[length]; // copy to sort the array before inplace modification.

        // Sort by each character starting from the end.
        for (int d = w - 1; d >= 0; d--) {
            int[] count = new int[R + 1]; // count array to count the occurence of each character. Offset +1 for cumul calculation. Need to be reinitialized on each loop.

            // Apply the counting sort algorithm
            for (int i = 0; i < length; i++) {
                count[array[i].charAt(d) + 1]++;  // Increment by the value of the character in position d for each word.
            }

            // Generate the cummulation on the count array.
            for (int i = 0; i < R; i++) {
                count[i+1] += count[i];
            }

            // copy the sorted array.
            for (int i = 0; i < length; i++) {
                copy[count[array[i].charAt(d)]++] = array[i];
            }

            // copy in place the array.
            for (int i = 0; i < length; i++) {
                array[i] = copy[i];
            }
        } // end for.
    }


    /**
     * Most significant digit first -> Sort the strings starting with the first letter. Can be adapted to different string length.
     * @param array
     */
    public static void msdSort(String[] array) {

        int len = array.length; // number of strings
        String[] copy = new String[len];
        msdSort(array, 0, len - 1, 0, copy);
    }

    // recursive function to sort using msdSort algorithm.
    private static void msdSort(String[] array, int low, int high, int d, String[] copy) {

        if (high <= low) return; // recursive base case.

        int[] count = new int[R + 2]; // Extended ASCII symbols -> considering 2 offset for cummulation computing and 0 value.


        // Sort each string of the array
        for (int i = low; i <= high; i++) {

            // Build the count array
            count[charAt(array[i], d) + 2]++;
        }

        // calculate the cummulation.
        for (int i = 0 ; i < R + 1; i++) {
            count[i+1] += count[i];
        } 

        // Copy the string in the corect order in the auxiliary array (will be 0 indexed because of the cummulation)
        for (int i = low; i <= high; i++) {
            copy[count[charAt(array[i], d) + 1]++] = array[i];
        }

        // copy in the correct order in place inside the original array
        for (int i = low; i <= high; i++) {
            array[i] = copy[i - low]; // recuperate the first string in the 0 indexed array.
        }

        // recursively apply the sort function to all the cluster on the d+1th character.
        for (int i = 0; i < R; i++) {
            msdSort(array, low + count[i], low + count[i+1]-1, d+1, copy);
        }
        
    }

    /**
     * 3-way radix sort: mix the radix sort with quick sort. Recursively sorting the the array not containing the pivot. Efficient for Strings having common prefixes.
     * @param array
     */
    public static void threeWayRadixSort(String[] array) {
        threeWayRadixSort(array, 0, array.length - 1, 0);
    }

    private static void threeWayRadixSort(String[] array, int low, int high, int d) {

        if (low >= high) return;

        int lowp = low; // low pointer
        int i = low; // mid pointer.
        int highp = high; // high pointer.
        int pivot = charAt(array[low], d);

        while(i <= highp) {

            // if element is lower than the pivot, place the element on the low pointer and increment both low and mid.
            if (charAt(array[i], d) < pivot) {
                Helper.permutation(array, lowp++, i++);
            }

            // if element if equal to the pivot, increase the middle.
            else if (charAt(array[i], d) == pivot) {
                i++;
            }

            // if element if higher than the pivot, exachange with the high pointer and decrease it.
            else if (charAt(array[i], d) > pivot) {
                Helper.permutation(array, highp--, i);
            }
        }

        // When sorting if finish: sort the lower part and the upper part on the same d value, and sort the middle part on the d + 1 value.
        threeWayRadixSort(array, low, lowp - 1, d); // sort lower part
        threeWayRadixSort(array, lowp, highp, d+1); // sort middle part
        threeWayRadixSort(array, highp + 1, high, d); // sort high part
    }

    /**
     * Helper method to extract the integert value of a character from a String at index d. Return -1 if the index is out of range (> string length).
     * @param string String to extract the character from.
     * @param d dth character to extract from the string.
     * @return
     */
    private static int charAt(String string, int d) {

        int len = string.length();

        if (d >= len) return -1;
        return string.charAt(d);
    }


    /**
     * Testing method.
     * @param args
     */
    public static void main(String args[]) {

        String[] array1 = {
            "ABCGD",
            "LKDNDS",
            "LKDDFGI",
            "PDDFGOD",
            "PDDFG",
            "AWDFGLC", 
            "DGDOBV",
            "ODFK"
        };

        threeWayRadixSort(array1);

        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }

    }
}