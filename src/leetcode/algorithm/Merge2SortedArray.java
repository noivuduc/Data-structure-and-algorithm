package leetcode.algorithm;

import java.util.Arrays;

public class Merge2SortedArray {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 6, 7};
        int[] b = new int[]{4, 5, 8, 9};
        int[] c = merge(a, b);
        System.out.println(Arrays.toString(c));
    }
    public static int[] merge(int[] a, int[] b) {
        int length1 = a.length;
        int length2 = b.length;
        int[] merged = new int[length1 + length2];
        int posA = 0, posB = 0, mergePos = 0;
        while (posA < length1 && posB <length2) {
            if (a[posA] < b[posB]) {
                merged[mergePos++] = a[posA++];
            } else {
                merged[mergePos++] = b[posB++];
            }
        }
        while (posA < length1) {
            merged[mergePos++] = a[posA++];
        }
        while (posB < length2) {
            merged[mergePos++] = b[posB++];
        }
        return merged;
    }
}
