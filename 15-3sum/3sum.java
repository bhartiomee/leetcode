class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if(i>0 && nums[i]==nums[i-1])continue;
            int j = i + 1;
            int k = n - 1;
            int toFind = -1 * nums[i];

            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == toFind) {
                    ans.add(new ArrayList
                            (Arrays.asList(nums[i], nums[j], nums[k])));
                    while (j + 1 < k && nums[j] == nums[j + 1])
                        j++;
                    while (k - 1 > j && nums[k] == nums[k - 1])
                        k--;
                    j++;
                    k--;
                } else if (sum < toFind) {
                    j++;
                } else {
                    k--;
                }

            }
        }
        return ans;
    }
}