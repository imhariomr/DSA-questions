public class threeWayPartitioning {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 3, 4 };
        int a = 1;
        int b = 2;

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            if (arr[start] > b) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                end--;

            } else if (arr[end] < a) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                start++;
            } else {
                start++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
