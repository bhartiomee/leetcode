class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        traverse(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    public void traverse(int[] candidates, int target, int idx, List<Integer> tmp) {

        if (target == 0) {
            ans.add(new ArrayList(tmp));
            return;
        }
        if (target < 0 || idx == candidates.length)
            return;

        tmp.add(candidates[idx]);
        traverse(candidates, target - candidates[idx], idx + 1, tmp);
        tmp.remove(tmp.get(tmp.size() - 1));
        for (int i = idx + 1; i < candidates.length; i++) {
            if (candidates[i] != candidates[idx]) {
                traverse(candidates, target, i,tmp);
                break;
            }
        }

    }
}