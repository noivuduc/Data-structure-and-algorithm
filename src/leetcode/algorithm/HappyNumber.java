package leetcode.algorithm;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }
    public static boolean isHappy(int n) {
        int finalSum = n;
        HashSet<Integer> visited = new HashSet<>();
        while (finalSum != 1) {
            finalSum = squareOfItsDigit(finalSum);
            if (!visited.add(finalSum)) return false;
        }
        return true;
    }

    public static int squareOfItsDigit(int n) {
        int result = 0;
        char[] arr = Integer.toString(n).toCharArray();
        for (char ch : arr) {
            result += Math.pow(Character.getNumericValue(ch), 2);
        }
        return result;
    }
}
