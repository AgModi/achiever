package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinWindowSubstr {
    public static void main(String[] args) {
        testFindMinWindowSubstring();
    }

    private static void testFindMinWindowSubstring() {
        String s = "ADOBECODEBANCCCDBAAABCDEF";
        String t = "ABC";
        System.out.println(findMinWindowSubstring(s, t));

        s = "a";
        t = "a";
        System.out.println(findMinWindowSubstring(s, t));

        s = "ADOBECODEBANC";
        t = "ABC";
        System.out.println(findMinWindowSubstring(s, t));
    }

    private static String findMinWindowSubstring(String s, String t) {
        String result = "";
        Map<Character, Integer> charOccurenceMap = new HashMap<>();
        Map<Character, Integer> charOccurenceTempMap = new HashMap<>();
        int startIndex = 0;
        int lettersMatched = 0;

        for (Character ch: t.toCharArray()) {
            Integer count = charOccurenceMap.get(ch);
            if (count == null) {
                charOccurenceMap.put(ch, 1);
            } else {
                charOccurenceMap.put(ch, count + 1);
            }
            charOccurenceTempMap.put(ch, 0);
        }

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            Integer count = charOccurenceMap.get(ch);
            if (count != null) {
                if (count == charOccurenceTempMap.get(ch)) {
                    if (ch == s.charAt(startIndex) && startIndex != i) {
                        startIndex++;
                        while (startIndex < s.length() && (charOccurenceMap.get(s.charAt(startIndex)) == null)) {
                            startIndex++;
                        }
                    }
                } else {
                    lettersMatched++;
                    charOccurenceTempMap.put(ch, charOccurenceTempMap.get(ch)+1);
                    if (lettersMatched == t.length()) {
                        String subStr = s.substring(startIndex, i+1);
                        if (result.equals("")) {
                            result = subStr;
                        } else if (result.length() > subStr.length()){
                            result = subStr;
                        }

                        Character charAtStartIndex = s.charAt(startIndex);
                        charOccurenceTempMap.put(charAtStartIndex, charOccurenceTempMap.get(charAtStartIndex)-1);
                        lettersMatched--;

                        startIndex++;
                        while (startIndex < s.length() && charOccurenceMap.get(s.charAt(startIndex)) == null) {
                            startIndex++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
