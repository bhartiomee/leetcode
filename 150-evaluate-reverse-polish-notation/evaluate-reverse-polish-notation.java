class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (isNumber(token))
                stk.push(Integer.parseInt(token));
            else {
                int num1 = stk.pop();
                int num2 = stk.pop();
                int res = calculate(num2, num1, token.charAt(0));
                stk.push(res);
            }
        }
        return stk.pop();
    }

    private int calculate(int n1, int n2, char op) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                 return n1 / n2;
        }
        return -1;
    }

     private boolean isNumber(String s) {
        if (s.length() == 1) return Character.isDigit(s.charAt(0));
        return s.charAt(0) == '-' || Character.isDigit(s.charAt(0));
    }
}