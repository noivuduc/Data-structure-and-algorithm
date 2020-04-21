package leetcode.algorithm;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }
    public static int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x = x ^ num;
        }
        return x;
    }
}
