class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // TC -> O(4N)
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i = 2 * n - 1; i >= 0; i --) {// => O(2N)
            while(!stk.isEmpty() && nums[i % n] >= stk.peek())  // => O(2N)
                stk.pop();
           if(i < n)
                ans[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i % n]);
        }
        return ans;
    }
}