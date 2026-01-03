class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stk=new Stack<>();

        for(int i=0;i<num.length();i++){
            int curr=num.charAt(i)-'0';

            while(!stk.isEmpty() && k>0 && stk.peek()>curr){
                stk.pop();
                k--;
            }
            stk.push(curr);
        }
        while (k > 0 && !stk.isEmpty()) {
            stk.pop();
            k--;
        }
        System.out.println(stk);
        StringBuilder ans=new StringBuilder();
        while(!stk.isEmpty()){
            ans.append(Character.forDigit(stk.peek(), 10));
            stk.pop();
        }
        ans.reverse();
        int i=0;
        while(i<ans.length() && ans.charAt(i)=='0')i++;

        String result = ans.substring(i);
        return result.isEmpty() ? "0" : result;

    }
}