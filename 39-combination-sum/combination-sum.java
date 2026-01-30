class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,0,target,new ArrayList<>());
        return ans;
    }

    public void helper(int[] candidates,int idx,int target,List<Integer> tmp){
        if(idx>=candidates.length || target<0)return;
        if(target==0){
            ans.add(new ArrayList(tmp));
            return;
        }
        tmp.add(candidates[idx]);
        helper(candidates,idx,target-candidates[idx],tmp);
        tmp.remove(tmp.get(tmp.size()-1));
        helper(candidates,idx+1,target,tmp);

    }
}