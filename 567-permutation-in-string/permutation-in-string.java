class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();

        if(n1>n2)return false;

        int[] freqS1 =new int[26];
        int[] freqS2=new int[26];

        for(int i=0;i<n1;i++){
            freqS1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<n1;i++){
            freqS2[s2.charAt(i)-'a']++;
        }

        if(anaGram(freqS1,freqS2))return true;
        int i=n1;

        while(i<n2){
            freqS2[s2.charAt(i-n1)-'a']--;
            freqS2[s2.charAt(i)-'a']++;
            i++;
           if(anaGram(freqS1,freqS2))return true;

        }
        return false;

       
    }

    public boolean anaGram(int[] freqS1, int[] freqS2) {
        for (int i = 0; i < 26; i++) {
            if (freqS1[i] != freqS2[i])
                return false;
        }
        return true;
    }
}