package leetcode;

/**
 * Let's say a positive integer is a superpalindrome if it is a palindrome, and it is also the square of a palindrome.
 * <p>
 * Now, given two positive integers L and R (represented as strings), return the number of superpalindromes in the inclusive range [L, R].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: L = "4", R = "1000"
 * Output: 4
 * Explanation: 4, 9, 121, and 484 are superpalindromes.
 * Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= len(L) <= 18
 * 1 <= len(R) <= 18
 * L and R are strings representing integers in the range [1, 10^18).
 * int(L) <= int(R)
 */
public class SuperPalindrome {
    public static void main(String[] args) {
        String L = "1";
        String R = "12";
        SuperPalindrome superPalindrome = new SuperPalindrome();
        System.out.println(superPalindrome.superPalindromesInRange(L, R));
    }

    public int superPalindromesInRange(String L, String R) {
        int count = 0;
        int left = Integer.parseInt(L);
        int right = Integer.parseInt(R);

        while (left <= right) {
            if (isSuperpalindrome(left) || isSuperpalindrome(right)) {
                count++;
            }
            left++;
            right--;
        }
        return count;
    }

    private boolean isSuperpalindrome(int num) {
        int sqrt = (int) Math.sqrt(num);
        return isPalindrome(num) && isPalindrome(sqrt) && sqrt * sqrt == num;
    }

    private boolean isPalindrome(int num) {
        String s = Integer.toString(num);
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
