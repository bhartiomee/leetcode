class Solution {
    int[][] dp;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = Integer.MAX_VALUE;
        dp = new int[n][amount + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);
         ans = findCoins(coins, amount, 0);
        return ans >= Integer.MAX_VALUE ? -1 : ans;
    }

    private int findCoins(int[] coins, int amount, int idx) {
        if (amount == 0)
            return 0;
        if (idx == coins.length || amount < 0)
            return Integer.MAX_VALUE;
        if (dp[idx][amount] != -1)
            return dp[idx][amount];
        int take = findCoins(coins, amount - coins[idx], idx);
        if (take != Integer.MAX_VALUE)
            take += 1;

        int skip = findCoins(coins, amount, idx + 1);
        return dp[idx][amount] = Math.min(skip, take);

    }
}