public class SubstringSearch {

    final static int R = 256; // extended ASCII.

    /**
     * Brute force algorithm to find the index of the matching substring in the text.
     * Complexity of N * M.
     * @param text where to find the pattern.
     * @param pattern to detect.
     * @return
     */
    public static int bruteForce(String text, String pattern) {

        int n = text.length(); // length of the text.
        int m = pattern.length(); // length of the pattern.
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
                if (j == m) return i - j + 1;
            } else {
                i -= j;
                j = 0;
            }
        }

        return -1;
    }


    public static int knuthMorrisPratt(String text, String pattern) {

        int i, j, n = text.length(), m = pattern.length();

        int[][] dfa = dfa(pattern); // use the dfa method to initialize the dfa matrix.


        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[text.charAt(i)][j];
        }

        if (j == m) return i - j;
        else return -1;
    }
    
    /**
     * Helper method to initialize the dfa incidence matrix.
     * @param text text to search the substring in.
     * @param pattern pattern to find in the text.
     * @return the dfa matrix as an 2D in array.
     */
    private static int[][] dfa(String pattern) {

        int m = pattern.length();
        int[][] dfa = new int[R][m];
        int x = 0; // pointer to keep track of the mismatch transition.
        
        // Filling the transition matrix.
        dfa[pattern.charAt(0)][0] = 1;
        for (int i = 0; i < R; i++) {
            if (i == pattern.charAt(0)) continue; // do not overwrite match transition.
            dfa[i][0] = 0; // Set all the other characters in the state 0 to 0;
        }

        for (int i = 1; i < m; i++) {
            dfa[pattern.charAt(i)][i] = i + 1; // match transition.

            // fill up the mismtach transition being the same as the x pointer.
            for (int j = 0; j < R; j++) {
                if (pattern.charAt(i) == j) continue; // do not overwrite the matching transition.
                dfa[j][i] = dfa[j][x];
            }

            // take the transition of the current matching character to both i (iteration) and x.
            x = dfa[pattern.charAt(i)][x];
        }

        return dfa;
    }


    /**
     * Implementation of the Boyer-Moore algorithm.
     * @param text
     * @param pattern
     */
    public static int boyerMoore(String text, String pattern) {

        int n = text.length(), m = pattern.length();

        int[] right = new int[R]; // right matrix computing the index of the rightest character in the pattern.
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }

        for (int j = 0; j < m; j++) {
            right[pattern.charAt(j)] = j;
        }

        int skip; // number of element to skip.

        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;

            for (int j = m - 1; j >= 0; j--) {

                if (text.charAt(i + j) != pattern.charAt(j)) {
                    skip = Math.max(1, j - right[text.charAt(i + j)]);
                    break;
                }

            } // end for

            if (skip == 0) return i;

        }

        return -1; // no match found.
    }


    /**
     * Implementation of the Rabin-Karp algorithm to compute the substring search. 
     * Monte-Carlo version (we do not recheck the matching string, 
     * considering the hash fucntion with most likely not generate duplicates values for different strings).
     * @param text Text to search the substring in.
     * @param pattern Pattern to find in the text.
     * @return The index of the starting match in the text.
     */
    public static int rabinKarp(String text, String pattern) {

        int n = text.length(), m = pattern.length();
        int Q = 997; // high prime number.
        int RM = 1; // Used to compute the base R offset to select the last number of the hash.

        // Compute the base R offset RM
        for (int i = 1; i < pattern.length(); i++) {
            RM = (RM * R) % Q;
        }

        long patternHash = hash(pattern); // Compute the hash of the pattern.
        
        // Compare with the first character of the text
        long textHash = hash(text.substring(0, m));

        if (textHash == patternHash) return 0; // There is a prefix match.

        for (int i = m; i < n; i++) {

            // Compute the new text hash based on the previous one: Substract the first digit of the number and add the modulus of the new character.
            textHash = ((textHash - ((RM * text.charAt(i - m)) % Q)) + Q) % Q; // add Q to avoid negative number.
            textHash = (textHash * R + text.charAt(i)) % Q; // move the numbers to the right and add the new letter value.

            if(patternHash == textHash) return ++i - m;
        }

        return -1; // if not match.
    }

    /**
     * Helper method to compute a hash of a specific key on a base R using a high prime number (997).
     * @param key Key to compute the hash on.
     * @return The hash value.
     */
    private static long hash(String key) {

        int Q = 997; // high prime number.
        int m = key.length();

        long h = 0; // value of the hash.

        for (int i = 0; i < m; i++) {
            h = ((h * R) + key.charAt(i)) % Q;
        }

        return h;
    }




    /**
     * Unit testing method.
     */
    public static void main(String[] args) {

        String text = "Les sanglots longs des violons de l'autonme blessent mon couleur d'une langueur monotone.";
        String pattern = "longs";

        System.out.println("Knuth Morris Pratt search:");
        System.out.println(knuthMorrisPratt(text, pattern));
        System.out.println();
        System.out.println("Boyer-Moore search:");
        System.out.println(boyerMoore(text, pattern));
        System.out.println();
        System.out.println("Rabin-Karp:");
        System.out.println(rabinKarp(text, pattern));

    }
    
}
