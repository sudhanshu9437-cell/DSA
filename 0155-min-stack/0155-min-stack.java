class MinStack {

    Stack<Integer> st;
    Stack<Integer> stm;
    public MinStack() {
        st = new Stack<>();
        stm = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if(stm.isEmpty()) stm.push(value);
        else{
            if(value <= stm.peek()) stm.push(value);
            else stm.push(stm.peek());
        }
    }
    
    public void pop() {
        st.pop();
        stm.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return stm.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */