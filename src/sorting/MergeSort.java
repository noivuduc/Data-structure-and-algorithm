package sorting;

import java.util.Arrays;

public class MergeSort {
    public static int[] merge(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[] tmp = new int[m + n];
        int i=0, j=0, k = 0;
        if (i < m && j < n) {
            for (i = 0; i < m + n;) {
                if (j < m && k < n) {
                    if (a[j] < b[k]) {
                        tmp[i] = a[j];
                        j++;
                    } else {
                        tmp[i] = b[k];
                        k++;
                    }
                    i++;
                } else if (j == m) {
                    for (; i < m + n; ) {
                        tmp[i] = b[k];
                        k++;
                        i++;
                    }
                } else {
                    for (; i < m + n; ) {
                        tmp[i] = a[j];
                        j++;
                        i++;
                    }
                }
            }
        }
        return tmp;
    }

    public static int[] mergeSort(int[] a) {
        int length = a.length;
        if (length == 1) return a;
        int mid = length / 2;
        int[] leftArray = Arrays.copyOfRange(a, 0, mid );
        int[] rightArray = Arrays.copyOfRange(a, mid, length);
        int[] left = mergeSort(leftArray);
        int[] right = mergeSort(rightArray);
        return merge(left, right);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{6, 3, 10, 6, 8,2, 9};
        mergeSort1(arr1, 0, arr1.length - 1);
        printArray(arr1);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print("]");
    }

    public static void mergeSort1(int[] arr, int l, int r) {
       if (l < r) {
           int m = (l + r) / 2;
           mergeSort1(arr, l, m);
           mergeSort1(arr, m + 1, r);
           merge1(arr, l, m, r);
       }
    }

    public static void merge1(int[] arr, int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 =  r - m;

        /* create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];
        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1+ j];

        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = l; // Initial index of merged subarray
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

    /* Copy the remaining elements of L[], if there
       are any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

    /* Copy the remaining elements of R[], if there
       are any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
