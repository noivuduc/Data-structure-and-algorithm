package leetcode.algorithm;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * tmp = 13
 *
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * [
 * [15,15,2,5]
 * [15,15,13,5] tmp = 2
 * ]
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
                            };
        rotate(matrix);
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix[0].length / 2; i++) {
            rotateSubArray(matrix, i);
        }
    }

    private static void rotateSubArray(int[][] matrix, int i) {
        int n = matrix[0].length;
        int count = 1;
        while (count < n - (i * 2)) {
            int tmp = matrix[i][i];
            int j = i + 1;
            // top line
            while (j < n - i) {
                int temp = matrix[i][j];
                matrix[i][j] = tmp;
                tmp = temp;
                j++;
            }
            // right line
            j = i + 1;
            while (j < n - i) {
                int temp = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
                tmp = temp;
                j++;
            }
            j = n - i - 2;
            // bottom line
            while (j >= i) {
                int temp = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
                tmp = temp;
                j--;
            }

            // left line
            j = n - i - 2;
            while (j >= i) {
                int temp = matrix[j][i];
                matrix[j][i] = tmp;
                tmp = temp;
                j--;
            }
            count++;
        }
    }
}
