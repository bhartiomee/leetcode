class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0]=nums[0];
        if(n==1)return dp[0];
        dp[1]=Math.max(nums[0],nums[1]);
        
        for(int i=2;i<n;i++){
            int rob=nums[i]+dp[i-2];
            int skip=dp[i-1];
            dp[i]=Math.max(rob,skip);
        }
        return dp[n-1];

    }

    public int traverse(int[] nums, int idx, int[] dp) {
        if (idx >= nums.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        dp[idx] = Math.max(nums[idx] + traverse(nums, idx + 2, dp),
                traverse(nums, idx + 1, dp));
        return dp[idx];

    }
}