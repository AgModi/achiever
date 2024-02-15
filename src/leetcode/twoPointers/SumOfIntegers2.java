package leetcode.twoPointers;

public class SumOfIntegers2 {
    public static void main(String[] args) {
        tests();
    }

    private static void tests(){
        int numbers[] = {2,7,11,15};
        int target = 9;
        int []index = twoSum(numbers, target);
        printArray(index);

        numbers = new int[]{2,3,4};
        target = 6;
        index = twoSum(numbers, target);
        printArray(index);

        numbers = new int[]{-1,0};
        target = -1;
        index = twoSum(numbers, target);
        printArray(index);

        numbers = new int[]{2,4,6,7,11,15};
        target = 9;
        index = twoSum(numbers, target);
        printArray(index);

        numbers = new int[]{4,5,6,7,8,9,11,15};
        target = 10;// {6,5,4,3,2,1,-1,-5}
        index = twoSum(numbers, target);
        printArray(index);


        numbers = new int[]{4,5,6,7,8,9,11,15};
        target = 18;//

        index = twoSum(numbers, target);
        printArray(index);
    }

    private static int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];
        for (int i = 0, j = numbers.length -1; i < j ; ) {
            if (numbers[i] + numbers[j] == target){
                result[0] = i+1;
                result[1] = j+1;
                return result;
            }

            //Now check if jth index number requires less than ith index number or greater than it
            if ( target - numbers[j] < numbers[i]){
                j--;
            } else {
                i++;
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }

    private static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
