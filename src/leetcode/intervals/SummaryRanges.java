package leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        int arr [] = {0,1,2,4,5,7};
        System.out.println(getSummaryRanges(arr));

        arr= new int[]{0,2,3,4,6,8,9};
        System.out.println(getSummaryRanges(arr));

        arr= new int[]{1};
        System.out.println(getSummaryRanges(arr));
    }

    private static List<String> getSummaryRanges(int arr[]) {
        List<String> ranges = new ArrayList<>();
        int firstIndexOfPair = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]+1) {
                ranges.add(arr[firstIndexOfPair] + "->" + arr[i-1]);
                firstIndexOfPair = i;
            }
        }
        ranges.add(arr[firstIndexOfPair] + "->" + arr[arr.length-1]);
        return ranges;
    }
}
