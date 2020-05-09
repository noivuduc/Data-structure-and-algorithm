package leetcode.algorithm;

public class MissingItemFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4,6};
        System.out.print(new MissingItemFromSortedArray().solution(nums));
    }
    public int solution(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 1;
            if (nums[middle] != middle) {
                if (middle == 0 || nums[middle - 1] == middle - 1) {
                    return middle;
                }
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
