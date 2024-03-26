package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinArrowToBurstBalloon {

    public static void main(String[] args) {
        int [][] points = {{10,16},{2,8},{1,6},{7,12}};
        //printArray(intervals);
        System.out.println(getMergedIntervals(points).size());

        points = new int[][]{{1,2},{3,4},{5,6},{7,8}};
        //printArray(intervals);
        System.out.println(getMergedIntervals(points).size());

        points = new int[][]{{1,2},{2,3},{3,4},{4,5}};
        //printArray(intervals);
        System.out.println(getMergedIntervals(points).size());
    }

    private static List<List<Integer>> getMergedIntervals(int [][] points) {
        List<List<Integer>> mergedIntervals = new ArrayList<>();
        Arrays.sort(points, (a, b) -> (a[0] > b[0])? 1 : (a[0] == b[0])? 0 : -1);
        //printArray(points);
        List<Integer> currentResultInterval = new ArrayList<Integer>(){{
            add(points[0][0]);
            add(points[0][1]);
        }};
        mergedIntervals.add(currentResultInterval);
        for (int i = 1,resultItr = 0; i < points.length; i++) {
            int currentTupleLeftNum = points[i][0];
            int currentTupleRightNum = points[i][1];

            if (currentTupleLeftNum > currentResultInterval.get(1)) {
                List<Integer> newResultInterval = new ArrayList<Integer>();
                newResultInterval.add(points[i][0]);
                newResultInterval.add(points[i][1]);

                mergedIntervals.add(newResultInterval);
                currentResultInterval = newResultInterval;
            } else {
                currentResultInterval.set(0, currentTupleLeftNum);

                if (currentResultInterval.get(1) > currentTupleRightNum) {
                    currentResultInterval.set(1, currentTupleRightNum);
                }
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
