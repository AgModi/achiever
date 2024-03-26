package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int [][] intervals = {{2,6},{15,18},{8,10},{1,3}};
        //printArray(intervals);
        System.out.println(getMergedIntervals(intervals));

        intervals = new int[][]{{1,4}, {4,5}};
        //printArray(intervals);
        System.out.println(getMergedIntervals(intervals));

        intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        //printArray(intervals);
        System.out.println(getMergedIntervals(intervals));
    }

    private static List<List<Integer>> getMergedIntervals(int [][] intervals) {
        List<List<Integer>> mergedIntervals = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> {
            return (a[0] > b[0])? 1 : (a[0] == b[0])? 0 : -1;
        });
        //printArray(intervals);
        mergedIntervals.add(Arrays.asList(intervals[0][0], intervals[0][1]));
        for (int i = 1,resultItr = 0; i < intervals.length; i++) {
            int resultTupleLeftNum = mergedIntervals.get(resultItr).get(0);
            int resultTupleRightNum = mergedIntervals.get(resultItr).get(1);

            int currentTupleLeftNum = intervals[i][0];
            int currentTupleRightNum = intervals[i][1];

            if (currentTupleLeftNum > resultTupleRightNum) {
                mergedIntervals.add(Arrays.asList(intervals[i][0], intervals[i][1]));
                resultItr++;
            } else if (resultTupleRightNum < currentTupleRightNum) {
                mergedIntervals.set(resultItr, Arrays.asList(resultTupleLeftNum, currentTupleRightNum));
            }
        }
        return mergedIntervals;
    }

    private static void printArray(int [][] intervals){
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length; j++) {
                System.out.print(intervals[i][j] + " ");
            }
            System.out.print("     ");
        }
        System.out.println();
    }
}
