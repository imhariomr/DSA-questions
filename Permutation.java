import java.util.*;

public class Permutation {

    public static void solvePermutation(StringBuilder str, int index, ArrayList<String> list) {

        if (index == str.length()) {
            list.add(str.toString());
            return;
        }

        for (int j = index; j < str.length(); j++) {
            swap(str, index, j);
            solvePermutation(str, index + 1, list);
            swap(str, index, j);
        }
    }

    public static void swap(StringBuilder str, int index, int j) {
        char temp = str.charAt(index);
        str.setCharAt(index, str.charAt(j));
        str.setCharAt(j, temp);
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("abc");
        ArrayList<String> list = new ArrayList<>();
        solvePermutation(str, 0, list);
        System.err.println(list);
    }
}
