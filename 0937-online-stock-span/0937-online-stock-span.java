// class StockSpanner {
//     List<Integer> list = new ArrayList<>() ; 
//     public StockSpanner() {
//         List<Integer> list = new ArrayList<>();
//     }

//     public int next(int price) {
//         int ct = 1;
//         for(int i = list.size() - 1; i >= 0; i --) {
//             if(list.get(i) <= price) ct++;
//             else break;
//         }
//         list.add(price);
//         return ct;
//     }
// }

// /**
//  * Your StockSpanner object will be instantiated and called as such:
//  * StockSpanner obj = new StockSpanner();
//  * int param_1 = obj.next(price);
//  */
class StockSpanner {
//Optimal : I ve to keep track of PGE element at evry instant, so store it in stk in terms of pairs[] where pairs[0] -> currVal and pairs[1] -> currIndex
    Stack<int[]> stk = new Stack<>();
    int index = -1;
    public StockSpanner() {
        stk = new Stack<>();
    }

    public int next(int price) {
        index = index + 1;
        int ans = 0;
        while(!stk.isEmpty() && stk.peek()[0] <= price)
            stk.pop();
        ans = index - ((stk.isEmpty())? -1 : stk.peek()[1]);
        stk.push(new int[]{price, index});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */