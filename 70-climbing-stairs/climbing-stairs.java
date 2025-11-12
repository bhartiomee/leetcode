class Solution {
    public int climbStairs(int n) {
       int[] dp=new int[n+1]; 
       for(int i=0;i<=n;i++){
        dp[i]=-1;
       }
       helper(n,dp);
       return dp[n];
    }

    public int helper(int n,int[] dp){
        if(n<0)return 0;
        if(n==1||n==2)dp[n]=n;
        if(dp[n]!=-1)return dp[n];
        return dp[n]=helper(n-2,dp)+helper(n-1,dp);
    }
}