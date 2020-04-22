package leetcode.algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *    Hide Hint #1
 * In-place means we should not be allocating any space for extra array. But we are allowed to modify the existing array. However, as a first step, try coming up with a solution that makes use of additional space. For this problem as well, first apply the idea discussed using an additional array and the in-place solution will pop up eventually.
 *    Hide Hint #2
 * A two-pointer approach could be helpful here. The idea would be to have one pointer for iterating the array and another pointer that just works on the non-zero elements of the array.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{22,0, 0 ,1,0,3,12};
        anotherSolution(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i< nums.length-1; i++) {
            if (nums[i] == 0 && nums[i + 1] != 0) {
                //swap element
                int j = i+1;
                while (j > 0 && nums[j-1] == 0) {
                    swap(nums, j, j-1);
                    j--;
                }
            }
        }
    }

    public static void anotherSolution(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                i++;
                continue;
            }

            if (i == nums.length-1) {
                break;
            }
            int nextNonZero = i + 1;
            while (nextNonZero < nums.length && nums[nextNonZero] == 0) {
                nextNonZero++;
            }
            if (nextNonZero == nums.length) {
                break;
            }

            nums[i] = nums[nextNonZero];
            nums[nextNonZero] = 0;
            i++;
        }
    }

    public static void swap(int[] nums, int pos1, int pos2) {
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }
}
