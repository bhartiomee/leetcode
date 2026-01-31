class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums,new ArrayList<>(),new boolean[nums.length]);
        return ans;
    }

    public void helper(int[] nums,List<Integer> tmp,boolean[] used){

        if(tmp.size()==nums.length){
            ans.add(new ArrayList(tmp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            used[i]=true;
            tmp.add(nums[i]);
            helper(nums,tmp,used);
            used[i]=false;
            tmp.remove(tmp.size()-1);

        }
    }
}