class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return ans;
    }

     private void backtrack(int[] arr, int target, int start, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < arr.length; i++) {

            // Skip duplicates
            if (i > start && arr[i] == arr[i - 1]) continue;

            // Pruning
            if (arr[i] > target) break;

            temp.add(arr[i]);
            backtrack(arr, target - arr[i], i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}