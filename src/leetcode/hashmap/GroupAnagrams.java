package leetcode.hashmap;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        testAnagram();
    }

    private static void testAnagram(){
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> anagrams = groupAnagrams(strs);
        anagrams.forEach(System.out::println);


        strs = new String[]{""};
        System.out.println(groupAnagrams(strs));

        strs = new String[]{"a"};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String [] strs) {
        List<List<String>> resultList = new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> mapToAnagrams = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> charMapForWord = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                Character ch = str.charAt(i);
                Integer count = charMapForWord.get(ch);
                if (count == null) {
                    charMapForWord.put(ch, 1);
                } else {
                    charMapForWord.put(ch, count+1);
                }
            }

            List<String> anagrams = mapToAnagrams.get(charMapForWord);
            if (anagrams == null) {
                mapToAnagrams.put(charMapForWord, new ArrayList<>(Arrays.asList(str)));
            } else {
                anagrams.add(str);
            }
        }

        for (Map.Entry<Map<Character, Integer>, List<String>> entry: mapToAnagrams.entrySet()) {
            resultList.add(entry.getValue());
        }

        return resultList;
    }
}
