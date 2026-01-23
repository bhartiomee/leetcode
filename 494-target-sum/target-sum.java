class Solution {
    int[][] memo;
    int offset;

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        offset = 0;

        for (int num : nums)
            offset += num;
        memo = new int[n + 1][2 * offset + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return target(nums, target, 0);
    }

    public int target(int[] nums, int target, int idx) {
        if (target < -offset || target > offset)
            return 0;
        if (idx >= nums.length) {
            if (target == 0)
                return 1;
            return 0;
        }

        if (memo[idx][target + offset] != -1)
            return memo[idx][target + offset];

        int add = target(nums, target - nums[idx], idx + 1);

        int sub = target(nums, target + nums[idx], idx + 1);

        return memo[idx][target + offset] = add + sub;
    }
}