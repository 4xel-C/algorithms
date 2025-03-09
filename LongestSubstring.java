public class LongestSubstring {

    // ------------------------------------------------------Naive iterative method
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
    */
    public static String LCSSuffixRecursion(String string1, String string2, int m, int n) {

        // base case
        if (m == -1 || n == -1  || string1.charAt(m) != string2.charAt(n)) {
            return null;
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


    public static void main(String[] args) {
        String string1 = "Je mange du chocolat";
        String string2 = "Je bois un choco tout chaud";

        String substring = longestSubstring(string1, string2);
        String substringNaiveReursive = longestSubstring(string1, string2);

        System.out.println(substringNaiveReursive);

    }
}