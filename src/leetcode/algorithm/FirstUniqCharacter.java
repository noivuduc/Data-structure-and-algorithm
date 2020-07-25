package leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstUniqCharacter {
    public static void main(String[] args) {
        FirstUniqCharacter firstUniqCharacter = new FirstUniqCharacter();
        String s = "loveleetcode";
        firstUniqCharacter.firstUniqChar(s);
    }
    public int firstUniqChar(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(s.charAt(i), list);
        }
        int i = 0;
        for (Map.Entry<Character, List<Integer>> entry: map.entrySet() ) {
           if (entry.getValue().size() == 1) {
               return i;
           }
            i++;
        }
        return -1;
    }
}
