class Solution {
    int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    boolean[][] vis;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] != word.charAt(0))
                    continue;

                boolean ans = dfs(i, j, board, word, 0);
                if (ans == true)
                    return true;

            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, String word, int idx) {
        if (idx == word.length())
            return true;

        if (i >= board.length || j >= board[0].length
                || i < 0 || j < 0)
            return false;

        if (vis[i][j] || board[i][j] != word.charAt(idx))
            return false;

        vis[i][j] = true;

        for (int[] dir : direction) {
            int row = dir[0] + i;
            int col = dir[1] + j;

            if(dfs(row, col, board, word, idx + 1))return true;

        }
        vis[i][j] = false;
        return false;

    }
}