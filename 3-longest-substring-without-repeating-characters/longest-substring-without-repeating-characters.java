class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> freq=new HashMap<>();
        int ans=0;

        int i=0;
        int j=0;

        while(i<=j && j<s.length()){
            char ch=s.charAt(j);
            freq.put(ch,freq.getOrDefault(ch,0)+1);

            while(i<=j && freq.get(ch)>1){
                char iFreq=s.charAt(i);
                freq.put(iFreq,freq.get(iFreq)-1);
                i++;
            }
            ans=Math.max(ans,(j-i+1));
            j++;

        }
        return ans;
    }
}