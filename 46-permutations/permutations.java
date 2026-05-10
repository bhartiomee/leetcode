class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        func(nums, 0);
        return ans;
    }

    public void func(int[] nums, int idx) {
        if (idx == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            ans.add(tmp);
            return;
        }

        if (idx > nums.length)
            return;

        for (int i = idx; i < nums.length; i++) {
            swap(i, idx, nums);
            func(nums, idx + 1);
            swap(i, idx, nums);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}