package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    public static void main(String[] args) {
        BinaryPrefixDivisibleBy5 bpdb5 = new BinaryPrefixDivisibleBy5();
//        int[] A = new int[]{1,1,0,0,0,1,0,0,1};
        int[] A = new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};
        List<Boolean> results = bpdb5.prefixesDivBy5(A);
        print(results);
    }
    public static void print(List<Boolean> result) {
        Iterator iterator = result.iterator();
        System.out.print('[');
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(',');
        }
        System.out.print(']');
    }
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> r = new ArrayList<>();
        int num = 0;
        for (int x: A) {
            num = ((num << 1) + x) % 5;
            r.add(num % 5 == 0);
        }
        return r;
    }
}
