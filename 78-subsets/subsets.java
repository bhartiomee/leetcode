class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        generate(nums,0,new ArrayList<>());
        return ans;
    }

    public void generate(int[] nums,int idx,List<Integer> tmp){
        if(idx>nums.length)return;
        if(idx==nums.length){
            ans.add(new ArrayList(tmp));
            return;
        }
        tmp.add(nums[idx]);
        generate(nums,idx+1,tmp);
        tmp.remove(tmp.get(tmp.size()-1));
        generate(nums,idx+1,tmp);
    }
}