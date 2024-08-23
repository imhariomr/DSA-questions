import java.util.ArrayList;

public class printSubsequence {

    public static void printSubsequence(String str, int i, String subsequence, ArrayList<String> ans) {

        if (i == str.length() - 1) {
            ans.add(subsequence);
            return;
        }

        printSubsequence(str, i + 1, subsequence, ans);
        printSubsequence(str, i + 1, subsequence + str.charAt(i), ans);
    }

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> list = new ArrayList<>();
        printSubsequence(str, 0, "", list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
