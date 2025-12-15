class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int ans = 0, i = 0,maxFreq=0;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(c));

            while ((j - i + 1) - maxFreq > k) {
                char left = s.charAt(i);
                freq.put(left, freq.getOrDefault(left, 0) - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);

        }
        return ans;

    }
}