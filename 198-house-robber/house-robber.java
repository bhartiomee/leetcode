class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return traverse(nums, 0, dp);

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