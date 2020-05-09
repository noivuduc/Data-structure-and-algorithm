package leetcode.algorithm;

import datastructure.heap.MaxHeap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNonRepeated {
    public static void main(String[] args) {
        String str = "au";
        int max = lengthOfLongestSubstring(str);
//        char[] chars = str.toCharArray();
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//        int end = 0;
//        int start = 0;
//        int max = 0;
//        while (end < chars.length - 1) {
//            while (end < chars.length && hashMap.get(chars[end]) == null) {
//                hashMap.put(chars[end], 1);
//                end++;
//            }
//            max = Math.max(max, end - start);
//            hashMap.remove(chars[start]);
//            start++;
//        }

        System.out.println(max);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        int end = 0;
        int start = 0;
        Map<Character, Integer> hashmap = new HashMap<>();
        while (end <= chars.length) {
            if (end == chars.length) {
                max = Math.max(max, end - start);
                break;
            } else if (hashmap.get(chars[end]) != null) {
                max = Math.max(max, end - start);
                hashmap.remove(chars[start]);
                start++;
            } else {
                hashmap.put(chars[end], 1);
                end++;
            }

        }
        return max;
    }
}

