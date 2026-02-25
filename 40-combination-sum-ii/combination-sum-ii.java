class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,target,0,new ArrayList<>());
        return ans;
    }

    public void helper(int[] candidates, int target,int idx,List<Integer> tmp){
        if(target==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        if(idx>=candidates.length || target<0)return;

        tmp.add(candidates[idx]);
        helper(candidates,target-candidates[idx],idx+1,tmp);

        tmp.remove(tmp.size()-1);

        while(idx+1<candidates.length && candidates[idx]==candidates[idx+1]){
            idx++;
        }

        helper(candidates,target,idx+1,tmp);

    }
}