class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 1) return nums[0];

        int[] dp1=new int[n];
        int[] dp2=new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);


        return Math.max(traverse(nums,0,n-2,dp1),traverse(nums,1,n-1,dp2));
        
    }

    public int traverse(int[] nums, int idx, int n, int[] dp) {
        if (idx > n)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        dp[idx] = Math.max(nums[idx] + traverse(nums, idx + 2, n, dp),
                traverse(nums, idx + 1, n, dp));
        return dp[idx];

    }
}