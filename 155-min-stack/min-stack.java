class MinStack {
    private List<int[]>st;
    public MinStack() {
       st=new ArrayList<>();
    }
    
    public void push(int val) {
        int[] top=st.isEmpty()?new int[]{val,val}:st.get(st.size()-1);
        int minVal=top[1];
        if(val<minVal)minVal=val;
        st.add(new int[]{val,minVal});
    }
    
    public void pop() {
        st.remove(st.size()-1);
    }
    
    public int top() {
        return st.isEmpty()?-1:st.get(st.size()-1)[0];
    }
    
    public int getMin() {
        return st.isEmpty()?-1:st.get(st.size()-1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */