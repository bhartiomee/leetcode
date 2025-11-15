class Solution {
    public void sortColors(int[] nums) {
        int cntZero=0,cntOne=0,cntTwo=0;
        int n=nums.length;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)cntZero++;
            else if(nums[i]==1)cntOne++;
            else cntTwo++;
        }

        int idx=0;
        // System.out.println(cntZero);
        // System.out.println(cntOne);
        // System.out.println(cntTwo);
        System.out.println(idx);

        while(cntZero!=0){
            nums[idx++]=0;
            cntZero--;
        }
        while(cntOne!=0){
            nums[idx++]=1;
            cntOne--;
        }
        while(cntTwo!=0){
            nums[idx++]=2;
            cntTwo--;
        }
                System.out.println(idx);

        
    }
}