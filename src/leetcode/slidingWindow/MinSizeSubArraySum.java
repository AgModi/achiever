package leetcode.slidingWindow;

public class MinSizeSubArraySum {

    public static void main(String[] args) {
        testMinSizeArraySum();
    }

    private static void testMinSizeArraySum() {
        int nums[] = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));

        nums = new int[]{1,4,4};
        target = 4;
        System.out.println(minSubArrayLen(target, nums));

        nums = new int[]{1,1,1,1,1,1,1,1};
        target = 11;
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            int windowLengthForNow = i;
            int sumOfNumbersofCurrentWidow = 0;

            for (int j = 0; j < windowLengthForNow; j++) {
                sumOfNumbersofCurrentWidow += nums[j];
            }

            if (sumOfNumbersofCurrentWidow >= target) {
                return windowLengthForNow;
            }

            for (int j = i; j < nums.length; j++) {
                sumOfNumbersofCurrentWidow += nums[j] - nums[j-i];
                if (sumOfNumbersofCurrentWidow >= target) {
                    return windowLengthForNow;
                }
            }
        }
        return -1;
    }
}
