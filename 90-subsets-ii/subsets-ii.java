class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return ans;
    }

    public void helper(int[] nums, int idx, List<Integer> tmp) {
        ans.add(new ArrayList<>(tmp));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1])
                continue;

            tmp.add(nums[i]);
            helper(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }

    }

}