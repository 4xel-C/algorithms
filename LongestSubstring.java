public class LongestSubstring {

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

    public static void main(String[] args) {
        String string1 = "Je mange du chocolat";
        String string2 = "Je bois un choco tout chaud";

        String substring = longestSubstring(string1, string2);

        System.out.println(substring);

    }
}