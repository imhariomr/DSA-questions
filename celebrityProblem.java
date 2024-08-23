import java.util.Stack;

public class celebrityProblem {

    public static boolean knows(int a, int b, int arr[][]) {
        if (arr[a][b] == 1) {
            return true;
        }
        return false;
    }

    public static int solve(int arr[][], int n) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();

            if (knows(a, b, arr)) {
                st.push(b);
            } else {
                st.push(a);
            }
        }

        int validElement = st.peek();
        int zeroCount = 0;
        int oneCount = 0;
        boolean rowCheck = false;
        boolean colCheck = false;

        // col check
        for (int i = 0; i < n; i++) {
            if (arr[i][validElement] == 1) {
                oneCount++;
            }
        }

        // row check
        for (int i = 0; i < n; i++) {
            if (arr[validElement][i] == 0) {
                zeroCount++;
            }
        }

        if (zeroCount == n) {
            rowCheck = true;
        }

        if (oneCount == n - 1) {
            colCheck = true;
        }
        if (rowCheck && colCheck) {
            return st.peek();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int n = 2;
        int arr[][] = { { 0, 1 }, { 1, 0 } };
        System.out.println(solve(arr, n));
    }
}
