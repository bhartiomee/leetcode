class Solution {
    public int maxProfit(int transactions, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][transactions+1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= transactions; k++) {

                dp[i][k][1] = Math.max(-prices[i] + dp[i + 1][k][0], dp[i + 1][k][1]);

                dp[i][k][0] = Math.max(prices[i] + dp[i + 1][k - 1][1],
                        dp[i + 1][k][0]);

            }
        }
        return dp[0][transactions][1];
    }

}