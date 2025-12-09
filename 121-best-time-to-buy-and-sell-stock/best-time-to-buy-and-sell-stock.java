class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int minSoFar=prices[0];

        for(int i=1;i<prices.length;i++){
            minSoFar=Math.min(minSoFar,prices[i]);
            ans=Math.max(ans,prices[i]-minSoFar);
        }
        return ans;
    }
}