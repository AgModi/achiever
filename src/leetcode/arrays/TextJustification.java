package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public static void main(String[] args) {
        String words[] = {"This", "is", "an", "example", "of", "text", "justification."};
        fullJustify(words, 16);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> resultList = new ArrayList<>();
        String line = words[0];
        int wordsInCurrentLine = 1;
        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            if (line.length() + currentWord.length() + 1 > maxWidth) {
                if (line.length() != maxWidth) {
                    //We need to replace spaces with extra spaces
                    line = replaceSpacesWithExtraSpaces(line, wordsInCurrentLine, maxWidth);
                }
                resultList.add(line);
                line = currentWord;
                wordsInCurrentLine = 1;
            } else {
                line += " " + currentWord;
                wordsInCurrentLine++;
            }
        }
        line = replaceSpacesWithExtraSpaces(line, wordsInCurrentLine, maxWidth);
        resultList.add(line);
        System.out.println("Result list :" + resultList);
        return resultList;
    }

    private static String replaceSpacesWithExtraSpaces(String line, int wordsInCurrentLine, int maxWidth) {
        int extraSpacesNeededInLine = maxWidth - line.length();
        System.out.println("Line :" + line);
        for (int i = 0; i < line.length() && extraSpacesNeededInLine > 0; ) {
            char ch = line.charAt(i);
            if (ch == ' '){
                System.out.println("Extra spaces needed :"+ extraSpacesNeededInLine + " Words in line :"+ wordsInCurrentLine);
                String lineLeftPart = line.substring(0, i+1);
                System.out.println("Left :" + lineLeftPart);
                String lineRightPart = line.substring(i+1);
                System.out.println("Right :" + lineRightPart);
                int spacesToBeAddedAfterThisWord = 1 + (extraSpacesNeededInLine/wordsInCurrentLine);
                for (int j = 0; j < spacesToBeAddedAfterThisWord; j++) {
                    lineLeftPart += ' ';
                }
                line = lineLeftPart + lineRightPart;
                System.out.println("Merged line:" + line);
                extraSpacesNeededInLine -= spacesToBeAddedAfterThisWord;
                i += spacesToBeAddedAfterThisWord + 1;
                wordsInCurrentLine--;
            } else {
                i++;
            }
        }
        System.out.println("Final line:" + line);
        return line;
    }
}
