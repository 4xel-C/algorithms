

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


    public static void msdSort(String[] array) {

        // auxiliary array
        String[] aux = new String[array.length];

        msdSort(array, aux, 0, array.length - 1, 0);
    }

    private static void msdSort(String[] array, String[] aux, int low, int high, int d) {

        if (low >= high) return;
        
        int[] count = new int[R + 2]; // Creation of the count array, +2 for the negative value of out of range character and the cummulative space calculation.

        // Count
        for (int i = low; i <= high; i++) {

            // count the dth letter of each string
            count[charAt(array[i], d) + 2]++;
        }

        // compute cummulation
        for (int i = 0; i < R+1; i++) {
            count[i + 1] += count[i];
        }

        // sort the strings in the auxiliary array. (0 indexed because of the cummulation).
        for (int i = low; i <= high; i++) {
            aux[count[charAt(array[i], d) + 1]++] = array[i];
        }

        // copy the auxiliary strings into the array at the right position
        for (int i = low; i <= high; i++) {
            array[i] = aux[i - low];
        }

        // recursively apply the sort algorithm to the clusters
        for (int i = 0; i < R; i++) {
            msdSort(array, aux, low + count[i], low + count[i +1] - 1, d+1);
        }
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

        msdSort(array1);

        for (int i = 0; i < array1.length; i++) {
            
            System.out.println(array1[i]);
        }

    }
}