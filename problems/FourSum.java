package problems;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class to find all the possible combination of two sums in an array such as array[i] + array[j] = array[k] + array[l] and i, j, k, l all different.
 */
public class FourSum {

    // Inner class to store a tupple
    public static class Index {
        int index1;
        int index2;

        Index(int idx1, int idx2) {
            this.index1 = idx1;
            this.index2 = idx2;
        }

        // Compare two Index objects and return true if both index are different.
        public boolean uniqueIndex(Index that) {
            if (
                (index1 != that.index1 && index1 != that.index2)
                && (index2 != that.index1 && index2 != that.index2)
                ) {
                    return true;
                }
            return false;
        }
    }

    // Solve the four sum problem and print all the index of the number resulting to the same sum.
    public static void fourSums(int[] array) {
        
        // create the hashmap to store all possibles sums.
        HashMap<Integer, Index> dict = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                if (dict.containsKey(sum)) {
                    Index storedIndex = dict.get(sum);
                    Index checkedIndex = new Index(i, j);

                    if (storedIndex.uniqueIndex(checkedIndex)) {
                        System.out.println(sum + " = " + array[storedIndex.index1] + " + " + array[storedIndex.index2] + " and " + array[checkedIndex.index1] + " + " + array[checkedIndex.index2]);
                    }
                } else {
                    dict.put(sum, new Index(i, j));
                }

            }
        }
    }

    public static void main(String[] args) {

        int[] array = {1, 4, 5, 2, 0, 9, 8, 4, 3, 8, 6, 9, 19, 23, 4};

        fourSums(array);

    }

}
