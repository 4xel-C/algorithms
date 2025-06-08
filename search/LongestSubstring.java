public class LongestSubstring {

    // ------------------------------------------------------Naive iterative method (brute force)
    // Complexity: O(n²)
    public static String longestSubstring(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();

        String substring = "";
        int lenSubstring = 0;

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int cursor1 = i;
                int cursor2 = j;

                String temp = "";
                int currentLen = 0;

                while((cursor1 < len1) && (cursor2 < len2) && text1.charAt(cursor1) == text2.charAt(cursor2)) {
                    temp += text1.charAt(cursor1);
                    currentLen++;
                    cursor1++;
                    cursor2++;
                }
                
                if (currentLen > lenSubstring) {
                    lenSubstring = currentLen;
                    substring = temp;
                }
            }
        }
        return substring;
    }


    // ------------------------------------------------------Naive recursive method
    // Using recursion to find and return the longest common suffix

    /*
    * The recursive method will check each character from the end of the substring and recursivly check each previous character,
    *adding it to the final result if this is a substring. It returns then the complete substring.
    * Complexity : O(n²)
    */
    public static String LCSSuffixRecursion(String string1, String string2, int m, int n) {

        // base case
        if (m == -1 || n == -1  || string1.charAt(m) != string2.charAt(n)) {
            return "";
        }

        return LCSSuffixRecursion(string1, string2, m-1, n-1) + string1.charAt(m);
    }

    public static String LongestSubstringNaiveRecursion(String string1, String string2) {
        int len1 = string1.length();
        int len2 = string2.length();

        // Initialize the substring beeing returned by the function
        String substring = "";

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {

                // Temp string to store the resulting string from the recursive function to be compared with the variable 'substring'
                String temp = LCSSuffixRecursion(string1, string2, i, j);

                if (temp.length() > substring.length()) {
                    substring = temp;
                }
            }
        }

        return substring;
    }


    // ------------------------------------------------------Dynamic Programming Solution
    //  This solution alow the user to progressivly store the substring into a 2d array,
    //  Testing the substring from the end to the start, avoiding reitering through the already iterated substring

    //  This solution will keep updated a matrix of all the substring detected on the other string from each character of the first string, and will use the previous value to update from one row to another.
    //      lcsTable = 
    //      |   | a | b | x | c |
    //  ----|---|---|---|---|---|
    //      |"""|"""|"""|"""|"""|
    //  ----|---|---|---|---|---|
    //  a   |"""|"a"|"""|"""|"""|
    //  ----|---|---|---|---|---|
    //  b   |"""|"""|"ab"|"""|"""|
    //  ----|---|---|---|---|---|
    //  c   |"""|"""|"""|"""|"c"|
     
    //  => ab beeing the longest subbstring


    public static String dynamicLongestSubstring(String string1, String string2) {
        int len1 = string1.length();
        int len2 = string2.length();  

        // initialize the substring variable that will contain the solution
        String substring = "";

        // initialize the array keeping track of the partially found substring (there will be len1 * len2 substrings potentially generated)
        String[][] lcsTable = new String[len1 + 1][len2 + 1];

        // Initialize all the values of the table to ""
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++){
                lcsTable[i][j] = "";
            }
        }

        // iterate through both Strings.
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (string1.charAt(i-1) == string2.charAt(j-1)) {

                    lcsTable[i][j] = lcsTable[i-1][j-1] + string1.charAt(i-1);
                    if (lcsTable[i][j].length() > substring.length()) {
                        substring = lcsTable[i][j];
                    }
                }
            }
        }
        return substring;
    }


    // ------------------------------------------------------Space optimized Dynamic Programming Solution

    /*
     * It applies the same strategy has seen above, but the previous row is beeing kept update after the current row 
     * generation until the end of the iteration in the array, we thus avoid generating the entire matrix
     * while keeping updating the longest substring.
     */

    public static String optimizedDynamicLongestSubstring(String string1, String string2) {
        int len1 = string1.length();
        int len2 = string2.length();  

        // initialize the substring variable that will contain the solution
        String substring = "";


        // Initialize the row storing the previous substring at i
        String[] previous = new String[len2 + 1];

        for (int k = 0; k < len1 + 1; k++) {
            previous[k] = "";
        }

        // iterate through both Strings.
        for (int i = 1; i <= len1; i++) {

            String[] current = new String[len2 + 1]; 

            for (int j = 1; j <= len2; j++) {

                if (string1.charAt(i-1) == string2.charAt(j-1)) {
                    current[j] = previous[j - 1] + string1.charAt(i-1);

                    if (current[j].length() > substring.length()) {
                        substring = current[j];
                    }

                } else {
                    current[j] = "";
                }

                }
            previous = current;
        }
        return substring;
        }

    public static void main(String[] args) {
        String string1 = "chocolat Je mange du";
        String string2 = "Je bois un café chocolaté tout chaud.";

        // String substring = longestSubstring(string1, string2);
        // String substringNaiveRecursive = longestSubstring(string1, string2);
        // String substringDynamic = dynamicLongestSubstring(string1, string2);
        String obtDynamic = optimizedDynamicLongestSubstring(string1, string2);

        System.out.println(obtDynamic);

    }
}