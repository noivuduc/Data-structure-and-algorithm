# Group Anagrams



```text
* Given an array of strings, group anagrams together.
*
* Example:
*
* Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
* Output:
* [
*   ["ate","eat","tea"],
*   ["nat","tan"],
*   ["bat"]
* ]
* Note:
*
* All inputs will be in lowercase.
* The order of your output does not matter.

```

Solution in Java



```text
public static List<List<String>> bruteForce(String[] strs) {
    Map<String, List<String>> values = new HashMap<>();
    for (String str : strs) {
        char[] s = str.toCharArray();
        Arrays.sort(s);
        String tmp = Arrays.toString(s);
        if (values.containsKey(tmp)) {
            values.get(tmp).add(str);
        } else {
            List<String> subs = new ArrayList<>();
            subs.add(str);
            values.put(tmp, subs);
        }
    }
    return new ArrayList<>(values.values());
}
```

