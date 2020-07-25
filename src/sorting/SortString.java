package sorting;

import java.util.Arrays;

public class SortString {
    public static void main(String[] args) {
        String[] s = new String[]{"e","r", "n", "er", "en", "re", "eren", "ren"};
        for(int i = 0; i < s.length-1; ++i) {
            for (int j = i + 1; j < s.length; ++j) {
                if (s[i].compareTo(s[j]) > 0) {
                    String temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
        System.out.print("123".substring(0,2));
    }
}
