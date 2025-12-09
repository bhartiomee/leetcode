class Solution {
    public int maxProfit(int[] prices) {
       int n=prices.length;
       if(n==0)return 0;
       int[][]dp=new int[3][n];

       for(int i=1;i<=2;i++){
        int maxDiff=-prices[0];
        for(int j=1;j<n;j++){
            dp[i][j]=Math.max(dp[i][j-1],prices[j]+maxDiff);
            maxDiff=Math.max(maxDiff,dp[i-1][j]-prices[j]);
        }
       }
       return dp[2][n-1];
    }
}