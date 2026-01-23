class Solution {
   
    public int maxProfit(int[] prices) {
        int n=prices.length;
         int[][] dp=new int[n+2][2];

        dp[n][0]=0;
        dp[n][1]=0;
        dp[n+1][0]=0;
        dp[n+1][1]=0;

        for(int i=n-1;i>=0;i--){

            //hasStock=0    
            int buy=-prices[i]+dp[i+1][1];
            int skip=dp[i+1][0];
            dp[i][0]=Math.max(buy,skip);

            //hasStock=1
            int sell=prices[i]+dp[i+2][0];
            int skipWithoutStock=dp[i+1][1];
            dp[i][1]=Math.max(sell,skipWithoutStock);

        }
        return dp[0][0];
      
    }

    // public int calcProfit(int[] prices, int idx, int hasStock) {
    //     if (idx >= prices.length)
    //         return 0;

    //     if(memo[idx][hasStock]!=-1)return memo[idx][hasStock];    

    //     if (hasStock==0) {
    //         int buy = -1 * prices[idx] + calcProfit(prices, idx + 1, 1);
    //         int skip = calcProfit(prices, idx + 1, hasStock);
    //         return memo[idx][hasStock]=Math.max(buy, skip);
    //     } else {
    //         int sell = prices[idx] + calcProfit(prices, idx + 2, 0);
    //         int skip = calcProfit(prices, idx + 1, hasStock);

    //         return memo[idx][hasStock]= Math.max(sell, skip);
    //     }

    // }
}