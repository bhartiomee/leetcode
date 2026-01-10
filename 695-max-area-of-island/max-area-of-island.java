class Solution {
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid);
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] grid) {

        if (!isValid(i, j, grid) || grid[i][j] != 1)
            return 0;

        grid[i][j] = -1;
        int area = 1;

        for (int[] dir : dirs) {
            int row = dir[0] + i;
            int col = dir[1] + j;
            area += dfs(row, col, grid);
        }
        return area;
    }

    private boolean isValid(int i, int j, int[][] grid) {
        return (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length);
    }
}