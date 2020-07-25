package leetcode.algorithm;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        rotate2(arr, 3);
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(rotate(new int[]{-1,-100,3,99}, 2)));
    }
    public static int[] rotate(int[] nums, int k) {
        int len = nums.length;
        if (k % len == 0) return null;
        if (k > len) {
            k = k % len;
        }
        int[] tmp = new int[len];
        int j =0;
        for (int i = len - k; i < len; i++) {
            tmp[j] = nums[i];
            j++;
        }
        for (int i = 0; i< len - k; i++ ) {
            tmp[j] = nums[i];
            j++;
        }
        return tmp;
    }

    public static void rotate2(int[] nums, int k) {
        int len = nums.length;
        if (k % len == 0) return;
        if (k > len) {
            k = k % len;
        }
        for (int i = 0; i< k; i++) {
            shift(nums);
        }
    }

    private static void shift(int[] nums) {
        int lastNumber = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = lastNumber;
    }
}
