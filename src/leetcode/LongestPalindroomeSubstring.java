package leetcode;

public class LongestPalindroomeSubstring {

    public static void main(String[] args) {
        testLongestPalindroome();
    }

    private static void testLongestPalindroome() {

        String str = "babadd";
        System.out.println(longestPalindroome(str));

        str = "babadabad";
        System.out.println(longestPalindroome(str));

        str = "baab";
        System.out.println(longestPalindroome(str));
    }

    private static int longestPalindroome(String str) {
        int longestPalindroome = 0;
        for (int i = 0; i < str.length(); i++) {
            int tempLongestPalindroomeOdd = 1;
            int tempLongestPalindroomeEven = 0;

            for (int left = i-1, right=i+1; left >= 0 && right < str.length(); left--, right++) {
                if (str.charAt(left) == str.charAt(right)) {
                    tempLongestPalindroomeOdd += 2;
                } else {
                    break;
                }
            }
            if (tempLongestPalindroomeOdd > longestPalindroome) {
                longestPalindroome = tempLongestPalindroomeOdd;
            }

            for (int left = i, right=i+1; left >= 0 && right < str.length(); left--, right++) {
                if (str.charAt(left) == str.charAt(right)) {
                    tempLongestPalindroomeEven += 2;
                } else {
                    break;
                }
            }

            if (tempLongestPalindroomeEven > longestPalindroome) {
                longestPalindroome = tempLongestPalindroomeEven;
            }
        }
        return longestPalindroome;
    }
}
