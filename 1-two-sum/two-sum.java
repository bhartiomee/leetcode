class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            mp.put(nums[i],i);
        }

        for(int i=0;i<n;i++){
            int diff=target-nums[i];
           
            if(mp.containsKey(diff) && mp.get(diff)!=i)return new int[]{i,mp.get(diff)};
        }
        return new int[]{};
    }
}