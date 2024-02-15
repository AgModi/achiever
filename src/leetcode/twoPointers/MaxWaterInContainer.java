package leetcode.twoPointers;

public class MaxWaterInContainer {
    public static void main(String[] args) {
        tests();
    }

    public static void tests() {
        int heights[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));

        heights = new int[]{1,1};
        System.out.println(maxArea(heights));
    }

    private static int maxArea(int[] height) {
        int maxArea = 0;
        int []maxHeightIndexFromLeft = new int[height.length];
        int []maxHeightIndexFromRight = new int[height.length];

        maxHeightIndexFromLeft[0] = 0;
        maxHeightIndexFromRight[height.length-1] = height.length-1;

        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[maxHeightIndexFromLeft[i-1]]){
                maxHeightIndexFromLeft[i] = i;
            } else {
                maxHeightIndexFromLeft[i] = maxHeightIndexFromLeft[i-1];
            }
        }

        for (int i = height.length -2; i >= 0; i--) {
            if (height[i] > height[maxHeightIndexFromRight[i+1]]){
                maxHeightIndexFromRight[i] = i;
            } else {
                maxHeightIndexFromRight[i] = maxHeightIndexFromRight[i+1];
            }
        }

        for (int i = 0; i < height.length; i++) {
            int areaForNow = Math.abs(maxHeightIndexFromRight[i] - maxHeightIndexFromLeft[i])
                    * Math.min(height[maxHeightIndexFromRight[i]], height[maxHeightIndexFromLeft[i]]);
            if (maxArea < areaForNow) {
                maxArea = areaForNow;
            }
        }
        return maxArea;
    }
}
