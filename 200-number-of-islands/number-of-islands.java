class Solution {
    int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    dfs(i, j, grid, vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(int row, int col, char[][] grid, int[][] vis) {
        if (vis[row][col] == 1)
            return;

        vis[row][col] = 1;

        for (int[] dir : dirs) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;

            if (newRow >= 0 && newCol >= 0
                    && newRow < grid.length && newCol < grid[0].length
                    && vis[newRow][newCol] == 0 && grid[newRow][newCol] == '1')
                dfs(newRow, newCol, grid, vis);
        }

    }
}