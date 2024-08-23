public class searchInMatrix {

    public static boolean Search(int arr[][], int target) {
        int row = arr.length;
        int col = arr[0].length;

        int i = 0;
        int j = col - 1;

        while (j >= 0 && i < row) {

            if (arr[i][j] == target) {
                return true;
            } else if (arr[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 3, 5, 7, }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 51;
        boolean result = Search(arr, target);
        System.out.println(result);
    }
}
