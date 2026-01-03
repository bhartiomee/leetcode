class Solution {
    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        return traverse(m - 1, n - 1);
    }

    public int traverse(int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i == 0 && j == 0) {

            return 1;
        }

        return dp[i][j] = traverse(i - 1, j) + traverse(i, j - 1);
    }
}