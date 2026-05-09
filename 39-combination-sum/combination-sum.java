class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,target,new ArrayList<>(),0);
        return ans;
    }

    public void helper(int[] candidates, int target,List<Integer> tmp,int idx){
        if(target==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if(target<0)return;
        if(idx>=candidates.length)return;

        tmp.add(candidates[idx]);
        helper(candidates,target-candidates[idx],tmp,idx);
        tmp.remove(tmp.size()-1);
        helper(candidates,target,tmp,idx+1);
    }
}