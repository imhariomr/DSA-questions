public class minimumSwapsKTogether {
    public static void main(String[] args) {
        int arr[] = { 2, 7, 9, 5, 8, 7, 4 };
        int k = 6;

        int count = 0;
        int bad = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            if (arr[i] > k) {
                bad++;
            }
        }

        int i = 0;
        int j = count - 1;

        while (j < arr.length) {
            ans = Math.min(ans, bad);
            j++;
            if (j < arr.length && arr[j] > k) {
                bad++;
            }
            if (arr[i] > k) {
                bad--;
            }
            i++;
        }

        System.out.println(ans);
    }
}
