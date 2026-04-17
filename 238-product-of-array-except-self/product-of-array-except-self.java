class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCnt=0;
        int n=nums.length;
        int[] ans=new int[n];

        int product=1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroCnt++;
            }else{
                product*=nums[i];
            }
        }

        for(int i=0;i<nums.length;i++){
            if(zeroCnt>1){
                ans[i]=0 ;
            }else if(zeroCnt==1){
                if(nums[i]==0)ans[i]=product;
                else ans[i]=0;
            }else{
                ans[i]=product/nums[i];
            }
        }
        return ans;
    }
}