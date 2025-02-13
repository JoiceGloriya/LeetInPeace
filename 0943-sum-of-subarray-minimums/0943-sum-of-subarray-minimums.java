class Solution {
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        long mod = 1000000007L, total = 0, value = 0;
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        for(int i = 0; i < length; i ++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            value = (arr[i] * left * 1L * right) % mod;
            total = (total + value) % mod;
        }

        return (int)total;
    }

    private int[] findNSE(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int[] right = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i --) { 
            while(!stk.isEmpty() && arr[i] < arr[stk.peek()])
                stk.pop();
            right[i] = stk.isEmpty() ? arr.length : stk.peek();
            stk.push(i);
        } 
        return right;
    }

    private int[] findPSEE(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int[] left = new int[arr.length];
        for(int i = 0; i < arr.length; i ++) { 
            while(!stk.isEmpty() && arr[i] <= arr[stk.peek()])
                stk.pop();
            left[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        } 
        return left;
    }


}