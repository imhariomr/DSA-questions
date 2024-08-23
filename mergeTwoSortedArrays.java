import java.util.*;

public class mergeTwoSortedArrays {

    public static void merge(int arr1[], int arr2[], int newarr[]) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                newarr[k++] = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                newarr[k++] = arr2[j++];
            } else {
                newarr[k++] = arr1[i++];
                newarr[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            newarr[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            newarr[k++] = arr2[j++];
        }
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3 };
        int arr2[] = { 2, 5, 6 };

        int n = arr1.length;
        int m = arr2.length;

        int newarr[] = new int[n + m];
        merge(arr1, arr2, newarr);

        for (int i = 0; i < newarr.length; i++) {
            System.out.println(newarr[i]);
        }
    }
}
