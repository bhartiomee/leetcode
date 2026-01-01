class Solution {
    public String longestPalindrome(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                int len = j - i + 1;
                if (isPalindrome(i, j, s) && ans.length() < len) {
                    ans = s.substring(i, j + 1);

                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}