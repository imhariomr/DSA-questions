public class countOccuranceOfStringIn2D {

    public static int helper(String target, Character[][] str, int i, int j, int idx) {

        int found = 0;

        if (i < str.length && i >= 0 && j < str[0].length && j >= 0 && target.charAt(idx) == str[i][j]) {

            str[i][j] = '#';
            if (target.length() - 1 == idx) {
                found = 1;
            } else {
                found += helper(target, str, i, j - 1, idx + 1);
                found += helper(target, str, i + 1, j, idx + 1);
                found += helper(target, str, i, j + 1, idx + 1);
                found += helper(target, str, i - 1, j, idx + 1);
            }

            str[i][j] = target.charAt(idx);
        }

        return found;
    }

    public static void main(String[] args) {
        Character[][] str = { { 'D', 'D', 'D', 'G', 'D', 'D' },
                { 'B', 'B', 'D', 'E', 'B', 'S' },
                { 'B', 'S', 'K', 'E', 'B', 'K' },
                { 'D', 'D', 'D', 'D', 'D', 'E' },
                { 'D', 'D', 'D', 'D', 'D', 'E' },
                { 'D', 'D', 'D', 'D', 'D', 'G' }
        };

        String target = "GEEKS";
        int res = 0;

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[0].length; j++) {
                res += helper(target, str, i, j, 0);
            }
        }

        System.out.println(res);
    }
}