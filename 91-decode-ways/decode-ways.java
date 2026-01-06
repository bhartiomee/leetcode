class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return decode(s,0);
    }

    public int decode(String s,int i){
        if(i==s.length())return 1;
        if(s.charAt(i)=='0')return 0;
        if(dp[i]!=-1)return dp[i];

        int ways=decode(s,i+1);

        if((i+1)<s.length()){
            int num=Integer.parseInt(s.substring(i,i+2));
            if(num>=10 && num<=26)ways+=decode(s,i+2);
        }
        return dp[i]=ways;


    }
}