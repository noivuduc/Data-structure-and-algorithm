package leetcode.algorithm;

public class LongCommonSubSequence {
    public static void main(String[] args) {
        LongCommonSubSequence longCommonSubSequence = new LongCommonSubSequence();
        String s = "ABCEDF";
        String t = "GFBCEDFU";
        int len = longCommonSubSequence.LCS(s, t, s.length(), t.length());
        System.out.println(len);
    }
    /**
     *
     * @param s String A
     * @param t String B
     * @param m Length of String A
     * @param n Length of String B
     * @return Longest common substring length
     */
    public int LCS(String s, String t, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s.charAt(m-1) == t.charAt(n-1)) {
            return LCS(s, t, m-1, n-1) + 1;
        }

        return Integer.max(LCS(s, t, m - 1, n), LCS(s, t, m, n - 1));
    }
}
