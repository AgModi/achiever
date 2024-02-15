package leetcode.matrix;

public class RotateImage {
    public static void main(String[] args) {
        tests();
    }

    private static void tests() {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(matrix);
        rotateImage(matrix);
        System.out.println("===============Print new matrix==========");
        printMatrix(matrix);
    }

    private static void rotateImage(int [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[j][matrix.length - 1 - i];
            }
        }
    }

    private static void printMatrix(int [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
