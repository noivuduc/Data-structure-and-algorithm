package datastructure.hashtable;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Employee noi = new Employee("Noi", "Vu", 1);
        Employee thuy = new Employee("Thuy", "Thu", 2);
        Employee nam = new Employee("Nam", "Ha", 3);
//        SimpleHashtable hashtable = new SimpleHashtable();
//        hashtable.put("Noi", noi);
//        hashtable.put("Thuy", thuy);
//        hashtable.put("Nam", nam);
//        hashtable.printHashtable();
//        hashtable.remove("Noi");
//        System.out.print("Key Noi" + hashtable.get("Nam"));
        HashMap has = new HashMap();
        int[] nums = new int[10];
        int[] values = new int[]{59382, 43, 6894, 500, 99, -58};
        for (int i = 0; i < values.length; i++) {
            nums[hash(values[i])] = values[i];
        }
        System.out.print(Arrays.toString(nums));
    }

    private static int hash(int num) {
        return Math.abs(num % 10);
    }
}
