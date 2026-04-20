class Solution {
    public int[] singleNumber(int[] nums) {
        int xorNum=nums[0];

        for(int i=1;i<nums.length;i++){
            xorNum^=nums[i];
        }

        int rightmost=(xorNum&(xorNum-1))^xorNum;

        int b1=0,b2=0;

        for(int i=0;i<nums.length;i++){
            if((nums[i]&rightmost)==0)b1^=nums[i];
            else b2^=nums[i];
        }

        return new int[]{b1,b2};
    }
}