package interview;

public class SubstringwithSameSum {

    public static void main(String[] args) {
        String s = "1241424";
        System.out.println(maxSum2k(s));

        s = "1508823";
        System.out.println(maxSum2k(s));

        s = "12345778";
        System.out.println(maxSum2k(s));
    }

    private static int maxSum2k(String str) {
        int maxSum2KSubstrSize = -1;
        for (int i = 0, j = 1; i < str.length() -1 && j < str.length() -1 ; i++, j++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int left = i, right = j; left >=0 && right < str.length(); left--, right++) {
                leftSum += Integer.parseInt(str.charAt(left)+"");
                rightSum += Integer.parseInt(str.charAt(right)+"");
                if (leftSum == rightSum) {
                    int currentSubStrLength = right - left + 1;
                    if (currentSubStrLength > maxSum2KSubstrSize) {
                        maxSum2KSubstrSize = currentSubStrLength;
                    }
                }
            }
        }
        return maxSum2KSubstrSize;
    }
}
