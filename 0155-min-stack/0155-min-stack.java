// class Pair {
//     int x, min;
//     public Pair(int a, int b) {
//         x = a;
//         min = b;
//     }
// }
// Brute: TC -> O(N) SC -> O(2N) [stores evry node in pairs]
// class MinStack {

//     Stack<Pair> stk = new Stack<>();

//     public MinStack() {
        
//     }
    
//     public void push(int val) {
//         int mini;
//         if(stk.isEmpty()) mini = val;
//         else {
//             mini = Math.min(val, stk.peek().min);
//         }
//         stk.push(new Pair(val, mini));
//     }
    
//     public void pop() {
//         stk.pop();
//     }
    
//     public int top() {
//        return stk.peek().x; 
//     }
    
//     public int getMin() {
//         return stk.peek().min;
//     }
// }

                // '2 * val - min' is used to encode the new value
                // Encoding min :-
                // When pushing a new value onto the stack, if the value is less than current minimum, we need to update the minimum. However, we also need to store the previous minimum value somewhere so that we can restore it when the minimum value is popped off in the future.
                

        // min = 2 * min - stk.peek() is used to decode the previous minimum value
        // Decoding min :-
        // while poppping, if the value to be popped off is < min value, then it' s an encoded value, so decode and return the original value![same formula]
   

   class MinStack {
    Stack<Long> stk = new Stack<>();
    long min = Long.MAX_VALUE;

    public MinStack() {
    }

    public void push(int val) {
        if (stk.isEmpty()) {
            min = val;
            stk.push((long)val);
        } else {
            if (val > min) {
                stk.push((long)val);
            } else {
                stk.push(2L * val - min);
                min = val;
            }
        }
    }

    public void pop() {
        if (stk.peek() < min) {
            min = 2 * min - stk.pop();
        } else {
            stk.pop();
        }
    }

    public int top() {
        if (stk.peek() < min) {
            return (int)min;
        }
        return stk.peek().intValue();
    }

    public int getMin() {
        return (int)min;
    }
}