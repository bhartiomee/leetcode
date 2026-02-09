class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int curr = temperatures[i];
            while (!stk.isEmpty() && temperatures[stk.peek()] <= curr) {
                stk.pop();
            }
            ans[i] = stk.isEmpty() ? 0 : stk.peek() - i;
            stk.push(i);
        }

        return ans;
    }
}
