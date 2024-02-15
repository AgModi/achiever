package leetcode.slidingWindow;

import java.util.*;

public class SubstrWithConcatenationOfAllWords {
    public static void main(String[] args) {
        testFindSubstring();
    }

    private static void testFindSubstring() {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(findSubstring(s, words));

        s = "barfoofoobarthefoobarman";
        words = new String []{"bar","foo","the"};
        System.out.println(findSubstring(s, words));
    }

    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> subStringOccurences = new ArrayList<>();
        int stringLengthOfWordsFullStr = words.length * words[0].length();
        Map<String, Integer> wordsMap = new HashMap<>();

        if (s.length() < stringLengthOfWordsFullStr) {
            return subStringOccurences;
        }

        for (String word : words) {
            Integer count = wordsMap.get(word);
            if (count == null) {
                wordsMap.put(word, 1);
            } else {
                wordsMap.put(word, count + 1);
            }
        }

        String stringTillNow = s.substring(0, stringLengthOfWordsFullStr);
        if (checkIfStringIsPermutationOfWords(stringTillNow, new HashMap<>(wordsMap),  words[0].length())) {
            subStringOccurences.add(0);
        }

        for (int i = stringLengthOfWordsFullStr; i < s.length(); i++) {
            stringTillNow = stringTillNow.substring(1) + s.charAt(i);
            if (checkIfStringIsPermutationOfWords(stringTillNow, new HashMap<>(wordsMap),  words[0].length())) {
                subStringOccurences.add(i-stringLengthOfWordsFullStr+1);
            }
        }

        return subStringOccurences;
    }

    private static boolean checkIfStringIsPermutationOfWords(String s, Map<String, Integer> wordsMmap, int wordLength) {
        for (int i = 0; i < s.length(); i += wordLength) {
            String word = s.substring(i, i+wordLength);
            Integer count = wordsMmap.get(word);

            if (count == null) {
                return false;
            } else if (count > 1) {
                wordsMmap.put(word, count -1);
            } else {
                wordsMmap.remove(word);
            }
        }

        if (wordsMmap.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
