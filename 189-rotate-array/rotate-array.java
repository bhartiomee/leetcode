class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        if(n==1)return;
        reverse(0,n-1,nums);
        reverse(k,n-1,nums);
        reverse(0,k-1,nums);
    }
    private void reverse(int left,int right,int[] nums){
       while(left<=right){
        int tmp=nums[left];
        nums[left]=nums[right];
        nums[right]=tmp;
        left++;
        right--;
       }
    }
}