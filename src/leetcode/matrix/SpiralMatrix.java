package leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        tests();
    }

    private static void tests() {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));

        matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));

        matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        System.out.println(spiralOrder(matrix));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        for (int cellsTobeLeft = 0; cellsTobeLeft < matrix[0].length - 2; cellsTobeLeft++) {

            for (int j = cellsTobeLeft; j < matrix[0].length - cellsTobeLeft; j++) {
                result.add(matrix[cellsTobeLeft][j]);
            }

            for (int i = cellsTobeLeft+1; i < matrix.length - cellsTobeLeft; i++) {
                result.add(matrix[i][matrix[0].length - cellsTobeLeft - 1]);
            }

            for (int j = matrix[0].length - cellsTobeLeft - 1 - 1; j >= cellsTobeLeft; j--) {
                result.add(matrix[matrix.length - cellsTobeLeft - 1][j]);
            }

            for (int i = matrix.length - cellsTobeLeft - 1 - 1; i > cellsTobeLeft; i--) {
                result.add(matrix[i][cellsTobeLeft]);
            }
        }
        return result;
    }
}
