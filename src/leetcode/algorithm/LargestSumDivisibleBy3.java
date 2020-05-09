package leetcode.algorithm;

public class LargestSumDivisibleBy3 {
    public static void main(String[] args) {
        LargestSumDivisibleBy3 largestSumDivisibleBy3 = new LargestSumDivisibleBy3();
        int[] nums = new int[]{3,6,5,1,8};
        System.out.println(largestSumDivisibleBy3.maxSumDivThree(nums));
    }
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int rem1 = 9999;
        int rem2 = 9999;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] % 3 == 1) {
                if (rem2 > nums[i] + rem1) {
                    rem2 = nums[i] + rem1;
                }
                if (rem1 > nums[i]) {
                    rem1 = nums[i];
                }

            } else if (nums[i] % 3 == 2) {
                if (rem1 > nums[i] + rem2) {
                    rem1 = nums[i] + rem2;
                }
                if (rem2 > nums[i]) {
                    rem2 = nums[i];
                }
            }
        }
        if (sum % 3 == 1) {
            return sum - rem1;
        } else if (sum % 3 == 2) {
            return sum - rem2;
        } else {
            return sum;
        }
    }
}
