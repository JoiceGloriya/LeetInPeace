class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stk = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && prices[i] < stk.peek())
                stk.pop();
            if (stk.isEmpty())
                list.add(prices[i]);
            else
                list.add(prices[i] - stk.peek());
            stk.push(prices[i]);
        }
        // reverse(list);
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            ans[i] = list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }

        return ans;
    }

    // void reverse(List<Integer> list) {
    // int start = 0;
    // int end = list.size() - 1;
    // while(start < end) {
    // int temp = list.get(start);
    // list.set(start, list.get(end));
    // list.set(end, temp);

    // start++;
    // end--;
    // }
}
