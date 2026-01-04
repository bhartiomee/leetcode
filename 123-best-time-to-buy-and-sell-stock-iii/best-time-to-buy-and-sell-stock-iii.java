class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][3][2];


        for(int i=n-1;i>=0;i--){
            for(int k=1;k<=2;k++){
                
                    dp[i][k][1]=Math.max(-prices[i]+dp[i+1][k][0],dp[i+1][k][1]);
                

                    dp[i][k][0]=Math.max(prices[i]+dp[i+1][k-1][1],
                                                    dp[i+1][k][0]);

            }
        }
        return dp[0][2][1];
    }

    public int helper(int[] prices,int k,int idx,boolean canBuy){
        if(idx==prices.length||k==0)return 0;


        if(canBuy){
            return Math.max(-prices[idx]+helper(prices,k,idx+1,false),
            helper(prices,k,idx+1,true));
        }
        else {
            return  Math.max(prices[idx]+helper(prices,k-1,idx+1,true),
            helper(prices,k,idx+1,false));

        }
    }
}