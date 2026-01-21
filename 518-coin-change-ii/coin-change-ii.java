class Solution {
    int[][] memo;

    public int change(int amount, int[] coins) {
        int n = coins.length;
        memo = new int[amount + 1][n];
        for (int[] row:memo) {
            Arrays.fill(row, -1);
        }
        return dfs(amount, coins, 0);
    }

    public int dfs(int amount, int[] coins, int idx) {
        if (amount == 0)
            return 1;
        if (amount < 0)
            return 0;
        if (idx == coins.length)
            return 0;

        if (memo[amount][idx] != -1)
            return memo[amount][idx];
        int ways = 0;

        ways += dfs(amount - coins[idx], coins, idx) + dfs(amount, coins, idx + 1);
        return memo[amount][idx] = ways;
    }
}