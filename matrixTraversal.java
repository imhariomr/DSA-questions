import java.util.*;

public class matrixTraversal {

    public static void Traversal(int arr[][], int r, int c) {
        ArrayList<Integer> list = new ArrayList<>();

        int left = 0;
        int right = c - 1;

        int top = 0;
        int bottom = r - 1;

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                list.add(arr[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                list.add(arr[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(arr[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(arr[i][left]);
                }
                left++;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4, },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        Traversal(arr, 4, 4);
    }
}
