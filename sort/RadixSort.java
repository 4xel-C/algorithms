import utils.Helper;

/**
 * Radix sort 
 */
public class RadixSort {
    
    private static final int r = 256; // UTF-8 character size.


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
            int[] count = new int[r + 1]; // count array to count the occurence of each character. Offset +1 for cumul calculation. Need to be reinitialized on each loop.

            // Apply the counting sort algorithm
            for (int i = 0; i < length; i++) {
                count[array[i].charAt(d) + 1]++;  // Increment by the value of the character in position d for each word.
            }

            // Generate the cummulation on the count array.
            for (int i = 0; i < r; i++) {
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
     * Testing method.
     * @param args
     */
    public static void main(String args[]) {

        String[] array1 = {
            "ABCD",
            "LKDN",
            "LKDI",
            "PDOD",
            "AWLC", 
            "DOBV",
            "ODFK"
        };

        lsdSort(array1);

        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }

    }
}