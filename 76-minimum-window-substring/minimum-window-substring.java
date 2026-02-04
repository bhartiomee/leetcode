class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() < t.length())
            return "";

        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        String ans = "";

        for (int i = 0; i < t.length(); i++) {
            freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) + 1);
        }

        int formed = 0;
        int required = freq.size();

        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (freq.containsKey(ch) &&
                    window.get(ch).intValue() == freq.get(ch).intValue()) {
                formed++;
            }

            while (i <= j && formed == required) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                char leftChar = s.charAt(i);
                window.put(leftChar, window.get(leftChar) - 1);

                if (freq.containsKey(leftChar) &&
                        freq.get(leftChar) > window.get(leftChar)) {
                    formed--;
                }
                i++;
            }
            j++;

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
