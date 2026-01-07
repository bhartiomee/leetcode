class Solution {
    HashSet<String> dict = new HashSet<>();
    int[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new int[n];
        dict.addAll(wordDict);
        Arrays.fill(dp, -1);
        return find(s, 0) == 1 ? true : false;
    }

    public int find(String s, int idx) {
        if (idx == s.length())
            return 1;
        if (dp[idx] != -1)
            return dp[idx];

        for (int i = idx; i < s.length(); i++) {
            String prefix = s.substring(idx, i + 1);
            if (dict.contains(prefix) && find(s, i + 1)==1) {
                return dp[idx] = 1;
            }
        }
        return dp[idx] = 0;
    }
}