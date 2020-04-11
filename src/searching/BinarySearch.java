package searching;

public class BinarySearch {
    /**
     * Find the position of x in arr
     * @param arr must be in ordered
     * @param l left
     * @param r right
     * @param x
     * @return -1 if not exist
     */
    public static int execute(int[] arr, int l, int r, int x) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) return mid;

            if (arr[mid] > x) return execute(arr, l, mid - 1, x);

            return execute(arr, mid + 1, r, x);
        }
        return -1;
    }
}
