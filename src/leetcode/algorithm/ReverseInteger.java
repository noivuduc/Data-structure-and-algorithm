package leetcode.algorithm;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        int div = x < 0 ? -1 : 1;
        int newNumber = 0;
        x = Math.abs(x);
        while(x > 0) {
            int pop = x % 10;
            x = x/10;
            if (newNumber > Integer.MAX_VALUE/10 || (newNumber == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            newNumber = newNumber * 10 + pop;
        }
        return newNumber * div;
    }
}
