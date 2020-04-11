package searching;

/**
 * Jump search is searching algorithm for sorted array.
 * The basic idea is to check fewer elements by jumping ahead
 * by fixed step or skipping some elements in place of searching all elements
 */
public class JumpSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10};
        System.out.println(search(arr, 8));
    }
    /**
     * Perform search
     * @param arr sorted array
     * @param value value need to find
     * @return index of value or -1 if not found
     */
    public static int search(int[] arr, int value) {
        int length = arr.length;
        int prev = 0;
        int step = (int) Math.floor(Math.sqrt(length));

        // Find the block which value is present
        while ( arr[Math.min(step, length) - 1] < value) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(length));
            if (prev >= length) {
                return -1;
            }
        }
        // Do linear search to find the matching value
        for (int j = prev; j <= step; j++) {
            if (arr[j] == value) return j;
        }
        // not found
        return -1;
    }
}
