public class ThreeWayPartitioning {
    public static void threeWayPartition(int arr[], int a, int b) {
        int start = 0;
        int mid = 0;
        int end = arr.length - 1;

        while (mid <= end) {
            if (arr[mid] < a) {
                // Elements less than a should be moved to the beginning
                int temp = arr[start];
                arr[start] = arr[mid];
                arr[mid] = temp;
                start++;
                mid++;
            } else if (arr[mid] > b) {
                // Elements greater than b should be moved to the end
                int temp = arr[mid];
                arr[mid] = arr[end];
                arr[end] = temp;
                end--;
            } else {
                // Elements between a and b should remain in the middle
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        int a = 14;
        int b = 20;

        threeWayPartition(arr, a, b);

        // Print the partitioned array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
