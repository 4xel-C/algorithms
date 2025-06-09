package problems;

public class CyclicRotation {

    /**
     * Method to check if a string is a cyclic rotation of another string.
     * Complexity: O(n).
     * @param string1
     * @param string2
     * @return
     */
    public static boolean checkCyclicRotation(String string1, String string2) {

        int len1 = string1.length(), len2 = string2.length();

        if (len1 != len2) return false;

        String concatenatedString = string1 + string1;

        return concatenatedString.contains(string2);
    }

    /**
     * Unit testing.
     * @param args
     */
    public static void main(String[] args) {
        String string1 = "winterbreak";
        String string2 = "breakwinter";

        System.out.println(checkCyclicRotation(string1, string2));
    }
    
}
