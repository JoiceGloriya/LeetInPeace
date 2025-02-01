class Pair {
    int x, min;
    public Pair(int a, int b) {
        x = a;
        min = b;
    }
}

class MinStack {

    Stack<Pair> stk = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        int mini;
        if(stk.isEmpty()) mini = val;
        else {
            mini = Math.min(val, stk.peek().min);
        }
        stk.push(new Pair(val, mini));
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
       return stk.peek().x; 
    }
    
    public int getMin() {
        return stk.peek().min;
    }
}
