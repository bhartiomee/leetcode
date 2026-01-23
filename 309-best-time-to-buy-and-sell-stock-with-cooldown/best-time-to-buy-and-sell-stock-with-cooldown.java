class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        int n=prices.length;
        memo=new int[n+1][2];

        for(int[]row:memo){
            Arrays.fill(row,-1);
        }
        return calcProfit(prices, 0, 0);
        //  return ans;
    }

    public int calcProfit(int[] prices, int idx, int hasStock) {
        if (idx >= prices.length)
            return 0;

        if(memo[idx][hasStock]!=-1)return memo[idx][hasStock];    

        if (hasStock==0) {
            int buy = -1 * prices[idx] + calcProfit(prices, idx + 1, 1);
            int skip = calcProfit(prices, idx + 1, hasStock);
            return memo[idx][hasStock]=Math.max(buy, skip);
        } else {
            int sell = prices[idx] + calcProfit(prices, idx + 2, 0);
            int skip = calcProfit(prices, idx + 1, hasStock);

            return memo[idx][hasStock]= Math.max(sell, skip);
        }

    }
}