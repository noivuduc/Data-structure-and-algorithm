package leetcode.algorithm;

public class IsPalindrome {
    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }
    public static boolean isPalindrome(String s) {
        s = s.toUpperCase();
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            if (s.charAt(i) < 65 || s.charAt(i) > 90) {
                i++;
            }
            if (s.charAt(j) < 65 || s.charAt(j) > 90) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
