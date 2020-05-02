package leetcode.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Give a list of integer L. Find the maximum length of a sequence of consecutive numbers that can be formed using elements in L
 * ex:
 * [5, 2, 99, 3, 4, 1, 100] => max([99,100], [1,..,5])
 * 5
 * ....
 * 5 -> 4 : 6
 * 4 -> 3 : 5
 * 3 -> 2: 4
 * 2 -> 1:
 * 1 -> null
 */
public class MaximumConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{99, 5, 2, 102, 4, 1, 100, 6, 101, };
        System.out.println(maximumConsecutiveSequence(nums));
    }
    public static int maximumConsecutiveSequence(int[] L) {
        Boolean[] visited = new Boolean[L.length];
        Arrays.fill(visited, false);
        Set<Integer> sets = arrayToSet(L);
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i< L.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int length = 1;
                int numRight = L[i] + 1;
                int numLeft = L[i] - 1;
                while (sets.contains(numRight)) {
                    length++;
                    numRight++;
                }
                while (sets.contains(numLeft)) {
                    length++;
                    numLeft--;
                }
                if (length > maxLength) maxLength = length;
            }
        }
        return maxLength;
    }

    public static Set<Integer> arrayToSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int num : arr) {
            set.add(num);
        }
        return set;
    }
}
