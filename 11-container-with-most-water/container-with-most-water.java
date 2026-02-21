class Solution {
    public int maxArea(int[] height) {
        int ans=0;
        int n=height.length;

        int i=0;
        int j=n-1;

        while(i<j && j<n){
            int hi=height[i];
            int hj=height[j];

            int area=(j-i)*Math.min(hi,hj);
            ans=Math.max(ans,area);
            if(hi<hj)i++;
            else j--;
        }

        return ans;


    }
}