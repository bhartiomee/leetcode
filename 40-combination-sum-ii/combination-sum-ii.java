class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>());
        return ans;
    }

    public void helper(int[] candidates, int idx, int target, List<Integer> tmp) {
        if (target == 0) {
            ans.add(new ArrayList(tmp));
            return;
        }
        if (idx >= candidates.length || target < 0)
            return;

        tmp.add(candidates[idx]);
        helper(candidates, idx + 1, target - candidates[idx], tmp);
        tmp.remove(tmp.size() - 1);

        while (idx + 1 < candidates.length 
                                        && candidates[idx] == candidates[idx + 1])
            idx++;
        helper(candidates, idx + 1, target, tmp);
    }
}