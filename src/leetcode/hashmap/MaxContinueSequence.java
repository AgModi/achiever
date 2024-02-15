package leetcode.hashmap;

public class MaxContinueSequence {

    public static void main(String[] args) {
        testMaxContinueConsecutiveSequence();
    }

    private static void testMaxContinueConsecutiveSequence() {
        int arr[] = {100,4,200,1,3,2};
        System.out.println(maxContinueConsecutiveSequence(arr));

        arr = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(maxContinueConsecutiveSequence(arr));

        arr = new int[]{0,-3,7,-2,5,8,-4,-6,0,-1};
        System.out.println(maxContinueConsecutiveSequence(arr));

        arr = new int[]{0,-3,7,2,5,8,-4,-6,0,-1,-5,-7,-10};
        System.out.println(maxContinueConsecutiveSequence(arr));
    }

    private static int maxContinueConsecutiveSequence(int arr[]) {
        int maxInt = Integer.MIN_VALUE;
        int minInt = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < minInt) {
                minInt = num;
            }

            if (num > maxInt) {
                maxInt = num;
            }
        }

        int biggestNegativeIntIfAny = Math.abs(minInt);
        int positiveCountArr[] = new int[maxInt+1+biggestNegativeIntIfAny];

        for (int num : arr) {
            if (num < 0) {
                positiveCountArr[biggestNegativeIntIfAny + num] = 1;
            } else{
                positiveCountArr[num+biggestNegativeIntIfAny] = 1;
            }
        }

        int maxConsecuentInterval = 0;
        int tempMaxConsecuentInterval = 0;

        for (int num : positiveCountArr) {
            if (num == 1) {
                tempMaxConsecuentInterval++;
            } else{
                if (tempMaxConsecuentInterval > maxConsecuentInterval) {
                    maxConsecuentInterval = tempMaxConsecuentInterval;
                }
                tempMaxConsecuentInterval = 0;
            }
        }

        if (tempMaxConsecuentInterval > maxConsecuentInterval) {
            maxConsecuentInterval = tempMaxConsecuentInterval;
        }

        //printArray(positiveCountArr);
        return maxConsecuentInterval;
    }

    private static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + "," + arr[i] + "  ");
        }
    }
}
