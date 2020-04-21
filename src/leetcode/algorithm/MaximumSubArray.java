package leetcode.algorithm;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubArray {
    public static void main(String[] args) {
//        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] arr = new int[]{-10, -1, -2, -11, -9};
        System.out.println(maxSubArray(arr));
    }

    /**
     * This solution will not work if the array contains all negative number
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max_end_here = Integer.MIN_VALUE;
        int max_so_far = Integer.MIN_VALUE;
        for (int num: nums) {
            max_end_here += num;
            if (max_end_here < 0) {
                max_end_here = 0;
            }
            if (max_so_far < max_end_here) {
                max_so_far = max_end_here;
            }
        }
        return max_so_far;
    }

    public static int solution2(int[] nums) {
        int max_so_far = nums[0];
        int current_max = nums[0];
        for (int i = 1; i< nums.length; i++) {
            int num = nums[i];
            current_max = Math.max(num, current_max + num);
            max_so_far = Math.max(max_so_far, current_max);
        }
        return max_so_far;
    }
}
