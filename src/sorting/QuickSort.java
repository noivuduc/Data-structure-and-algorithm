package sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] test = new int[] {10, 80, 40, 90, 50, 30, 70};
        quickSort(test, 0, test.length - 1);
        printArray(test);
    }

    public static int partition(int[] arr, int low, int high) {
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= arr[high]) {
                i++;
                swap(arr, j, i);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1 );
            quickSort(arr, pi + 1, high);
        }
    }

    public static void swap(int[] arr, int pos1, int pos2) {
        int tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print("]");
    }
}
