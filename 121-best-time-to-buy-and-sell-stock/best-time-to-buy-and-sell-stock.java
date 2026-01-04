class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int smallest=prices[0];

        for(int i=1;i<prices.length;i++){
            smallest=Math.min(smallest,prices[i]);
            ans=Math.max(ans,prices[i]-smallest);
        }
        return ans;
    }
}   