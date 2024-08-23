import java.util.ArrayList;
import java.util.List;

public class stringInGrid {

    public static boolean dfs(Character[][] grid, int n, int m, String target, int idx, int x, int y, int nei_x,
            int nei_y) {

        if (idx == target.length()) {
            return true;
        }

        if (x >= 0 && x < n && y >= 0 && y < m && target.charAt(idx) == grid[x][y]) {
            return dfs(grid, n, m, target, idx + 1, x + nei_x, y + nei_y, nei_x, nei_y);
        }

        return false;
    }

    public static void main(String[] args) {
        Character[][] grid = { { 'a', 'b', 'a', 'b' }, { 'a', 'b', 'e', 'b' }, { 'e', 'b', 'e', 'b' } };
        String target = "abe";

        int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

        int n = grid.length;
        int m = grid[0].length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 8; k++) {
                    if (dfs(grid, n, m, target, 0, i, j, dx[k], dy[k])) {
                        ArrayList<Integer> position = new ArrayList<>();
                        position.add(i);
                        position.add(j);
                        ans.add(position);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
