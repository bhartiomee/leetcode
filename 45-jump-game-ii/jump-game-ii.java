class Solution {
    public int jump(int[] nums) {
        int maxReach=0;
        int n=nums.length;
        int ans=0;
        int currEnd=0;

        for(int i=0;i<n-1;i++){
            // if(i>maxReach)break;
            maxReach=Math.max(maxReach,i+nums[i]);
            if(i==currEnd){
                ans++;
                currEnd=maxReach; 
            }
            
        }
        return ans;

        
    }
}