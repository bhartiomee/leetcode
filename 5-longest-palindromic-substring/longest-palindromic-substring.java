class Solution {
    public String longestPalindrome(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            int st = i, end = i;
            while (st >= 0 && end < s.length() 
                    && s.charAt(st) == s.charAt(end)) {
                st--;
                end++;
            }

            String tmp = s.substring(st + 1, end);
            if (tmp.length() > ans.length())
                ans = tmp;

             st = i; end = i + 1;
            while (st >= 0 && end < s.length() && 
                    s.charAt(st) == s.charAt(end)) {
                st--;
                end++;
            }
            tmp = s.substring(st + 1, end);
            if (tmp.length() > ans.length())
                ans = tmp;
        }

        return ans;
    }

}