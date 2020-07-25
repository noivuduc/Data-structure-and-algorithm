package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,2, 9, 5};
        int[] nums2 = new int[]{9,4,2,8,9};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length) {
            return intersect(nums2, nums1);
        }
        List<Integer> intersects = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num: nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersects.add(num);
                map.put(num, count - 1);
            }
        }
        int[] results = new int[intersects.size()];
        int i = 0;
        for ( int num: intersects ) {
            results[i++] = num;
        }
        return results;
    }
}
