class Solution {
    HashSet<String> dict = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dict.addAll(wordDict);
        dp[0]=true;

        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                String prefix=s.substring(j,i);
                if(dict.contains(prefix) &&  dp[j]){
                    dp[i]=true;
                    break;
                }
            }

        }
        return dp[n];
        
    }

    // public int find(String s, int idx) {
    //     if (idx == s.length())
    //         return 1;
    //     if (dp[idx] != -1)
    //         return dp[idx];

    //     for (int i = idx; i < s.length(); i++) {
    //         String prefix = s.substring(idx, i + 1);
    //         if (dict.contains(prefix) && find(s, i + 1)==1) {
    //             return dp[idx] = 1;
    //         }
    //     }
    //     return dp[idx] = 0;
    // }
}