class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk=new Stack<>();
        int n=nums.length;
        int[] ans=new int[n];

        for(int i=2*n-1;i>=0;i--){
            int idx=i%n;
            int curr=nums[idx];
            while(!stk.isEmpty()&& (curr >= stk.peek()) ){
                stk.pop();
            }
            if(i<n)ans[idx]=stk.isEmpty()?-1:stk.peek();  
            stk.push(curr);

        }
        return ans;
    }
}