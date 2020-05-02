package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> integers = solution(s,p);
        System.out.println(integers.toString());
    }
    public static List<Integer> solution(String s, String p) {
        List<Integer> results = new ArrayList<>();
        char[] pStr = p.toCharArray();
        int len = p.length();
        for (int i = 0; i <= s.length() - len; i++) {
            String sub = s.substring(i, len + i);
            if (isAnagram(sub, pStr)) {
                results.add(i);
            }
        }
        return results;
    }

    public static boolean isAnagram(String source, char[] dest) {
        char[] arr = source.toCharArray();
        int[] count = new int[255];
        Arrays.fill(count, 0);
        int i;
        for ( i =0; i< arr.length && i < dest.length; i++) {
            count[arr[i]]++;
            count[dest[i]]--;
        }
        for (i = 0; i< count.length; i++) {
            if (count[i] > 0) return false;
        }
        return true;
    }
}
